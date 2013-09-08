package at.theengine.android.bestlocation.demo;

import java.util.Date;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.app.Activity;
import at.theengine.android.bestlocation.BestLocationListener;
import at.theengine.android.bestlocation.BestLocationProvider;
import at.theengine.android.bestlocation.BestLocationProvider.LocationType;

public class MainActivity extends Activity {

	private static String TAG = "BestLocationProvider";
	
	private TextView mTvLog;
	private BestLocationProvider mBestLocationProvider;
	private BestLocationListener mBestLocationListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTvLog = (TextView) findViewById(R.id.tvLog);
	}
	
	private void initLocation(){
		if(mBestLocationListener == null){
			mBestLocationListener = new BestLocationListener() {
				
				@Override
				public void onStatusChanged(String provider, int status, Bundle extras) {
					Log.i(TAG, "onStatusChanged PROVIDER:" + provider + " STATUS:" + String.valueOf(status));
				}
				
				@Override
				public void onProviderEnabled(String provider) {
					Log.i(TAG, "onProviderEnabled PROVIDER:" + provider);
				}
				
				@Override
				public void onProviderDisabled(String provider) {
					Log.i(TAG, "onProviderDisabled PROVIDER:" + provider);
				}
				
				@Override
				public void onLocationUpdateTimeoutExceeded(LocationType type) {
					Log.w(TAG, "onLocationUpdateTimeoutExceeded PROVIDER:" + type);
				}
				
				@Override
				public void onLocationUpdate(Location location, LocationType type,
						boolean isFresh) {
					Log.i(TAG, "onLocationUpdate TYPE:" + type + " Location:" + mBestLocationProvider.locationToString(location));
					mTvLog.setText("\n\n" + new Date().toLocaleString() + "\nLOCATION UPDATE: isFresh:" + String.valueOf(isFresh) + "\n" + mBestLocationProvider.locationToString(location) + mTvLog.getText());
				}
			};
			
			if(mBestLocationProvider == null){
				mBestLocationProvider = new BestLocationProvider(this, true, true, 10000, 1000, 2, 0);
			}
		}
	}
	
	@Override
	protected void onResume() {
		initLocation();
		mBestLocationProvider.startLocationUpdatesWithListener(mBestLocationListener);
		
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		initLocation();
		mBestLocationProvider.stopLocationUpdates();
		
		super.onPause();
	}

}
