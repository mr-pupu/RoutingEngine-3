package id.ac.itats.skripsi.routingengine.tiga.test;

import id.ac.itats.skripsi.databuilder.GraphAdapter;
import id.ac.itats.skripsi.orm.Node;
import id.ac.itats.skripsi.shortestpath.model.Graph;
import android.test.AndroidTestCase;

public class GraphAdapterTest extends AndroidTestCase {
	protected final String TAG = "GraphAdapterTest";
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetNode() {
		Node n =  GraphAdapter.getNode(257690928);
		assertEquals(n.getNodeID(), Long.valueOf(257690928));
	}

	public void testBuildGraph() {
		Graph graph = GraphAdapter.buildGraph();
		assertEquals(graph.getSize(), 22311);
	}
	
	public void testBuildGraph2() {
		Graph graph = GraphAdapter.buildGraph2();
		assertEquals(graph.getSize(), 22311);
	}
	
	public void testBuildGraph3() {
		Graph graph = GraphAdapter.buildGraph3();
		assertEquals(graph.getSize(), 22311);
	}

}
