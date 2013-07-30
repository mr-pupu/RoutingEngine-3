package id.ac.itats.skripsi.routingengine.tiga.test;

import id.ac.itats.skripsi.databuilder.GraphAdapter;
import id.ac.itats.skripsi.orm.Node;
import id.ac.itats.skripsi.shortestpath.model.Graph;
import android.test.AndroidTestCase;

public class GraphAdapterTest extends AndroidTestCase {
	protected final String TAG = "GraphAdapterTest";
	
	GraphAdapter graphAdapter;
	protected void setUp() throws Exception {
		graphAdapter = new GraphAdapter();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetNode() {
		Node n =  graphAdapter.getNode("257690928");
		assertEquals(n.getNodeID(), Long.valueOf("257690928"));
	}

	public void testBuildGraph() {
		Graph graph = graphAdapter.buildGraph();
		assertEquals(graph.getSize(), 22311);
	}
	
	public void testBuildGraph2() {
		Graph graph = graphAdapter.buildGraph2();
		assertEquals(graph.getSize(), 22311);
	}

}
