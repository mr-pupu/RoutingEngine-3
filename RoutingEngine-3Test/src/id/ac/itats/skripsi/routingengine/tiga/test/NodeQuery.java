package id.ac.itats.skripsi.routingengine.tiga.test;

import java.util.List;

import id.ac.itats.skripsi.databuilder.DataBaseHelper;
import id.ac.itats.skripsi.orm.DaoSession;
import id.ac.itats.skripsi.orm.Node;
import id.ac.itats.skripsi.orm.NodeDao;
import id.ac.itats.skripsi.orm.Way;
import android.test.AndroidTestCase;
import android.util.Log;

public class NodeQuery extends AndroidTestCase {
	protected final String TAG = "Nodequery";
	DaoSession daoSession;
	NodeDao nodeDao;
	
	protected void setUp() throws Exception {
		daoSession  = DataBaseHelper.getInstance().openSession();
		nodeDao = daoSession.getNodeDao();
		super.setUp();
	}


	public void testGetTargetAdjacencies() {
		Node node = nodeDao.queryBuilder().where(NodeDao.Properties.NodeID.eq("257690928")).list().get(0);
		assertTrue(node != null);
		
		List<Way> adjacent = node.getTargetAdjacencies();
		assertTrue(adjacent.size() >=0);
		
		for (Way w : adjacent){
			Node n = w.getTargetNode();
			assertTrue(n!=null);
			n.minDistance = 5.;
			Log.e(TAG, ""+n.getNodeID() +" " +n.minDistance);
		}
		
		assertTrue(598.209 > Double.POSITIVE_INFINITY);
		
	}


}
