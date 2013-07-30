package id.ac.itats.skripsi.routingengine.tiga;

import id.ac.itats.skripsi.databuilder.DataBaseHelper;
import id.ac.itats.skripsi.databuilder.GraphAdapter;
import id.ac.itats.skripsi.orm.Node;
import id.ac.itats.skripsi.shortestpath.DijkstraDB;

import java.util.List;

import android.app.Activity;
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
	
		DijkstraDB.computePaths(graphAdapter.getNode("257690932"));
		List<Node> path = DijkstraDB.getShortestPathTo(graphAdapter.getNode("260114044"));
		Log.i(TAG, ""+path);
		
		DataBaseHelper.closeSession();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ormtest, menu);
		return true;
	}

	// XXX TESTTEST
}
