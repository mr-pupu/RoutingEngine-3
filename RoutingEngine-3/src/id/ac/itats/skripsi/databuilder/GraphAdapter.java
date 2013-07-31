package id.ac.itats.skripsi.databuilder;

import id.ac.itats.skripsi.orm.DaoSession;
import id.ac.itats.skripsi.orm.Node;
import id.ac.itats.skripsi.orm.NodeDao;
import id.ac.itats.skripsi.orm.Way;
import id.ac.itats.skripsi.orm.WayDao;
import id.ac.itats.skripsi.shortestpath.model.Graph;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import de.greenrobot.dao.query.LazyList;
import de.greenrobot.dao.query.Query;

public class GraphAdapter {
	protected static final String TAG = "GraphAdapter";
	private static DaoSession daoSession = DataBaseHelper.getInstance().openSession();
	private static NodeDao nodeDao = daoSession.getNodeDao();
	private static WayDao wayDao = daoSession.getWayDao();

	public static Graph graph = new Graph();

	public static Node getNode(long nodeId) {
		return nodeDao.queryBuilder()
				.where(NodeDao.Properties.NodeID.eq(nodeId)).list().get(0);
	}

	public static Graph buildGraph() {
		List<Way> ways = wayDao.queryBuilder().list();

		Iterator<Way> it = ways.iterator();
		while (it.hasNext()) {
			Way way = it.next();
			graph.addEdge(way.getWayID(), way.getFk_sourceNode(), way.getSourceNode().getLatitude(), way.getSourceNode().getLongitude(),
					way.getFk_targetNode(), way.getTargetNode().getLatitude(), way.getTargetNode().getLongitude(), way.getWeight());
		}

		return graph;
	}

	public static Graph buildGraph2() {
		Query<Way> query = wayDao.queryBuilder()
				.where(WayDao.Properties.Id.between(1, 1000)).build();
		int rowCount = 53702;
		int i = 1;
		int j = 1000;
		do {
			query.setParameter(0, i);
			query.setParameter(1, j);

			LazyList<Way> ways = query.listLazy();
			ListIterator<Way> it = ways.listIteratorAutoClose();
			while (it.hasNext()) {
				Way way = (Way) it.next();
				graph.addEdge(way.getWayID(), way.getFk_sourceNode(), way.getSourceNode().getLatitude(), way.getSourceNode().getLongitude(),
						way.getFk_targetNode(), way.getTargetNode().getLatitude(), way.getTargetNode().getLongitude(), way.getWeight());
			}
			i = j + 1;
			j += 1000;

		} while (j <= rowCount);
		
		LazyList<Way> ways = wayDao.queryBuilder().where(WayDao.Properties.Id.gt(j - 1000)).listLazy();
		ListIterator<Way> it = ways.listIteratorAutoClose();
		while (it.hasNext()) {
			Way way = (Way) it.next();
			
			
			graph.addEdge(way.getWayID(), way.getFk_sourceNode(), way.getSourceNode().getLatitude(), way.getSourceNode().getLongitude(),
					way.getFk_targetNode(), way.getTargetNode().getLatitude(), way.getTargetNode().getLongitude(), way.getWeight());		
		}
		
		return graph;
	}
	
	public static Graph buildGraph3() {
		String wayId = WayDao.Properties.Id.columnName;
		// int rowCount = mDb.rawQuery("SELECT "+ wayId +" FROM WAY",
		// null).getCount();
		int rowCount = 53702;

		int i = 0;
		int j = 1000;
		do {
			List<Way> ways = wayDao.queryDeep("WHERE T." + wayId
					+ " BETWEEN ? AND ?  ", new String[] { "" + i, "" + j });
			for (Way way : ways) {
				graph.addEdge(way.getWayID(), way.getFk_sourceNode(), way
						.getSourceNode().getLatitude(), way.getSourceNode()
						.getLongitude(), way.getFk_targetNode(), way
						.getTargetNode().getLatitude(), way.getTargetNode()
						.getLongitude(), way.getWeight());
			}
			i = j + 1;
			j += 1000;

		} while (j <= rowCount);

		List<Way> ways = wayDao.queryDeep("WHERE T." + wayId + ">?", ""
				+ (j - 1000));
		for (Way way : ways) {
			graph.addEdge(way.getWayID(), way.getFk_sourceNode(), way
					.getSourceNode().getLatitude(), way.getSourceNode()
					.getLongitude(), way.getFk_targetNode(), way
					.getTargetNode().getLatitude(), way.getTargetNode()
					.getLongitude(), way.getWeight());
		}
		return graph;

		// Log.i("Graph-Edge", ""+graph.getEdges().size());
		// Log.i("Graph-vertex", ""+graph.getVertices().size());

	}

}
