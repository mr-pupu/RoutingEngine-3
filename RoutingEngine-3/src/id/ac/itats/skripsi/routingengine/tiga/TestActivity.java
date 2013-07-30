package id.ac.itats.skripsi.routingengine.tiga;

import id.ac.itats.skripsi.databuilder.DataBaseHelper;
import id.ac.itats.skripsi.databuilder.GraphAdapter;
import id.ac.itats.skripsi.shortestpath.Dijkstra;
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
	GraphAdapter graphAdapter = new GraphAdapter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		// DijkstraDB.computePaths(graphAdapter.getNode("257690932"));
		// List<Node> path =
		// DijkstraDB.getShortestPathTo(graphAdapter.getNode("260114044"));
		// Log.i(TAG, ""+path);
		runDijkstra();

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
				Graph graph = graphAdapter.buildGraph2();
				time = sw.stop().getSeconds();
				Log.i(TAG, "build graph : " + time);
				DataBaseHelper.closeSession();
				return graph;
			}

			@Override
			protected void onPostExecute(Graph result) {
				StopWatch sw = new StopWatch().start();
				Dijkstra.computePaths(result.getVertex(1687756707));
				List<Vertex> path = Dijkstra.getShortestPathTo(result
						.getVertex(1427832568));
				Log.i(TAG, "running time " + sw.stop().getSeconds() + "\n"
						+ path);
				super.onPostExecute(result);
			}
		}.execute();
	}
}
