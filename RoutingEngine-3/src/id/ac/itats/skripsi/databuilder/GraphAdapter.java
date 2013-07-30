package id.ac.itats.skripsi.databuilder;

import java.util.List;

import id.ac.itats.skripsi.orm.DaoSession;
import id.ac.itats.skripsi.orm.Node;
import id.ac.itats.skripsi.orm.NodeDao;
import id.ac.itats.skripsi.orm.Way;
import id.ac.itats.skripsi.orm.WayDao;


public class GraphAdapter {
	protected static final String TAG = "GraphAdapter";
	private DaoSession daoSession = DataBaseHelper.getInstance().openSession();
	private NodeDao nodeDao = daoSession.getNodeDao();
	private WayDao wayDao = daoSession.getWayDao();
	
	public Node getNode(String nodeId){
		return nodeDao.queryBuilder().where(NodeDao.Properties.NodeID.eq(nodeId)).list().get(0);
	}
	
//	public List<Way> getAdjacencies (String nodeId){
//		
//	}
	

}
