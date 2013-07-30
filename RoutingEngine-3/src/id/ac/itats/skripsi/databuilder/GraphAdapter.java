package id.ac.itats.skripsi.databuilder;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import de.greenrobot.dao.query.LazyList;
import de.greenrobot.dao.query.Query;

import id.ac.itats.skripsi.orm.DaoSession;
import id.ac.itats.skripsi.orm.Node;
import id.ac.itats.skripsi.orm.NodeDao;
import id.ac.itats.skripsi.orm.Way;
import id.ac.itats.skripsi.orm.WayDao;
import id.ac.itats.skripsi.shortestpath.model.Graph;

public class GraphAdapter {
	protected static final String TAG = "GraphAdapter";
	private DaoSession daoSession = DataBaseHelper.getInstance().openSession();
	private NodeDao nodeDao = daoSession.getNodeDao();
	private WayDao wayDao = daoSession.getWayDao();

	public Graph graph = new Graph();

	public Node getNode(String nodeId) {
		return nodeDao.queryBuilder()
				.where(NodeDao.Properties.NodeID.eq(nodeId)).list().get(0);
	}

	public Graph buildGraph() {
		List<Way> ways = wayDao.queryBuilder().list();

		Iterator<Way> it = ways.iterator();
		while (it.hasNext()) {
			Way way = it.next();

			graph.addEdge(way.getWayID(), way.getFk_sourceNode(),
					way.getFk_targetNode(), way.getWeight());
		}

		return graph;
	}

	public Graph buildGraph2() {
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
				graph.addEdge(way.getWayID(), way.getFk_sourceNode(),
						way.getFk_targetNode(), way.getWeight());
			}
			i = j + 1;
			j += 1000;

		} while (j <= rowCount);
		
		LazyList<Way> ways = wayDao.queryBuilder().where(WayDao.Properties.Id.gt(j - 1000)).listLazy();
		ListIterator<Way> it = ways.listIteratorAutoClose();
		while (it.hasNext()) {
			Way way = (Way) it.next();
			graph.addEdge(way.getWayID(), way.getFk_sourceNode(),
					way.getFk_targetNode(), way.getWeight());		
		}
		
		return graph;
	}

}
