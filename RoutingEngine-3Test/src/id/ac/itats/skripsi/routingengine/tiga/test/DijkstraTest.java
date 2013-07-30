package id.ac.itats.skripsi.routingengine.tiga.test;

import id.ac.itats.skripsi.databuilder.GraphAdapter;
import id.ac.itats.skripsi.shortestpath.DijkstraDB;
import android.test.AndroidTestCase;

public class DijkstraTest extends AndroidTestCase {
	protected final String TAG = "Dijkstra";
	GraphAdapter graphAdapter;
	
	protected void setUp() throws Exception {
		graphAdapter = new GraphAdapter();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testComputePaths() {
//		
//		DijkstraDB.computePaths(graphAdapter, "257690928");
//		
		
	}

}
