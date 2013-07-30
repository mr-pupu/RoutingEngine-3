package id.ac.itats.skripsi.routingengine.tiga;

import android.app.Application;
import android.content.Context;

//Global variabel binding
public class RoutingEngine  extends Application{
	public static final String TAG = "RoutingEngine";
    private static Context context;

    public void onCreate(){
        super.onCreate();
        RoutingEngine.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return RoutingEngine.context;
    }

	
	@Override
	public String toString() {
		return "RoutingEngine instance";
	}
	
	
}
