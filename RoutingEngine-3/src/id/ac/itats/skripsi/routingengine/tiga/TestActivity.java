package id.ac.itats.skripsi.routingengine.tiga;

import id.ac.itats.skripsi.databuilder.DataBaseHelper;
import id.ac.itats.skripsi.databuilder.GraphAdapter;
import id.ac.itats.skripsi.shortestpath.AStar;
import id.ac.itats.skripsi.shortestpath.AStar2;
import id.ac.itats.skripsi.shortestpath.Dijkstra;
import id.ac.itats.skripsi.shortestpath.DijkstraImpl;
import id.ac.itats.skripsi.shortestpath.model.Graph;
import id.ac.itats.skripsi.shortestpath.model.Vertex;
import id.ac.itats.skripsi.util.StopWatch;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class TestActivity extends Activity {
	protected static final String TAG = "TestActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

//		 DijkstraDB.computePaths(graphAdapter.getNode("257690932"));
//		 List<Node> path =
//		 DijkstraDB.getShortestPathTo(graphAdapter.getNode("260114044"));
//		 Log.i(TAG, ""+path);
		runDijkstra();
//		runDijkstraImpl();
//		runAstar();
		runAstar2();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ormtest, menu);
		return true;
	}

	// XXX TESTTEST
	private void runDijkstra() {

		new AsyncTask<Void, Void, Graph>() {
			float time;

			@Override
			protected Graph doInBackground(Void... params) {
				StopWatch sw = new StopWatch().start();
				Graph graph = GraphAdapter.buildGraph3();
				time = sw.stop().getSeconds();
				Log.i(TAG, "build graph : " + time);
				DataBaseHelper.closeSession();
				return graph;
			}

			@Override
			protected void onPostExecute(Graph result) {
				StopWatch sw = new StopWatch().start();
				Dijkstra.computePaths(result.getVertex(257690898));
				List<Vertex> path = Dijkstra.getShortestPathTo(result
						.getVertex(1721971837));
				Log.i(TAG, "running time " + sw.stop().getSeconds() + "\n"
						+ path);
				super.onPostExecute(result);
			}
		}.execute();
	}
	
	private void runDijkstraImpl() {

		new AsyncTask<Void, Void, Graph>() {
			float time;

			@Override
			protected Graph doInBackground(Void... params) {
				StopWatch sw = new StopWatch().start();
				Graph graph = GraphAdapter.buildGraph2();
				time = sw.stop().getSeconds();
				Log.i(TAG, "build graph : " + time);
				DataBaseHelper.closeSession();
				return graph;
			}

			@Override
			protected void onPostExecute(Graph result) {
				StopWatch sw = new StopWatch().start();
				
				DijkstraImpl dijkstraImpl = new DijkstraImpl();
				result.getVertex(1427832568).setGoal(true);
				dijkstraImpl.getShortestPath(result, result.getVertex(1687756707));
				List<Vertex> path = dijkstraImpl.getVisited();
				
				Log.i(TAG, "running time " + sw.stop().getSeconds() + "\n"
						+ path);
				super.onPostExecute(result);
			}
		}.execute();
	}
	
	private void runAstar() {

		new AsyncTask<Void, Void, Graph>() {
			float time;

			@Override
			protected Graph doInBackground(Void... params) {
				StopWatch sw = new StopWatch().start();
				Graph graph = GraphAdapter.buildGraph3();
				time = sw.stop().getSeconds();
				Log.i(TAG, "build graph : " + time);
				
				return graph;
			}

			@Override
			protected void onPostExecute(Graph result) {
				StopWatch sw = new StopWatch().start();
				
				AStar aStar = new AStar(result.getVertex(1687756707), result
						.getVertex(1427832568));
				List<Vertex> path = aStar.getShortestPath();
				Log.i(TAG, "running time " + sw.stop().getSeconds() + "\n"
						+ path);
				DataBaseHelper.closeSession();
				super.onPostExecute(result);
			}
		}.execute();
	}
	
	private void runAstar2() {

		new AsyncTask<Void, Void, Graph>() {
			float time;

			@Override
			protected Graph doInBackground(Void... params) {
				StopWatch sw = new StopWatch().start();
				Graph graph = GraphAdapter.buildGraph3();
				time = sw.stop().getSeconds();
				Log.i(TAG, "build graph : " + time);
				DataBaseHelper.closeSession();
				return graph;
			}

			@Override
			protected void onPostExecute(Graph result) {
				StopWatch sw = new StopWatch().start();
				
				AStar2 aStar = new AStar2();
				List<Vertex> path = aStar.computePaths(result.getVertex(257690898), result
						.getVertex(1721971837));
				Log.i(TAG, "running time " + sw.stop().getSeconds() + "\n"
						+ path);
				super.onPostExecute(result);
			}
		}.execute();
	}
}
