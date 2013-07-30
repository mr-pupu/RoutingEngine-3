package id.ac.itats.skripsi.routingengine.tiga.test;

import id.ac.itats.skripsi.databuilder.DataBaseHelper;
import id.ac.itats.skripsi.orm.DaoSession;
import android.test.AndroidTestCase;

public class DatabaseHelperTest extends AndroidTestCase {
	DataBaseHelper dataBaseHelper;
	
	protected void setUp() throws Exception {
		dataBaseHelper = DataBaseHelper.getInstance();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetInstance() {
		assertTrue("DatabaseHelperInstance", dataBaseHelper!=null);
		assertEquals("new instance == current", dataBaseHelper, DataBaseHelper.getInstance());
	}

	public void testOpenSession() {
		DaoSession daoSession = DataBaseHelper.getInstance().openSession();
		assertTrue("daoSession not nul", daoSession != null);
		assertTrue(daoSession != DataBaseHelper.getInstance().openSession());
		
		assertTrue(daoSession.getNodeDao() != null);
		assertTrue(daoSession.getWayDao() != null);
		
	}

}
