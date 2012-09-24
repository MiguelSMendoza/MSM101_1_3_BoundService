package es.netrunners.boundservice;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LocalService extends Service {

	// Random number generator
	private final Random mGenerator = new Random();

	// Binder given to clients
	private final IBinder mBinder = new LocalBinder();

	public class LocalBinder extends Binder {
		LocalService getService() {
			return LocalService.this;
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return mBinder;
	}

	public int getRandomNumber() {
		return mGenerator.nextInt(100);
	}

}
