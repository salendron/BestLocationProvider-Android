Simple-Rss2-Android
===================

A simple wrapper to get fast and simple location updates on Android from GPS or Network. There is also a DemoApp to test this wrapper.


Example:
`````java
//init Listener
BestLocationListener mBestLocationListener = new BestLocationListener() {
				
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
	
//init Provider			
BestLocationProvider mBestLocationProvider = new BestLocationProvider(this, true, true, 10000, 1000, 2, 0);
	
//start Location Updates
mBestLocationProvider.startLocationUpdatesWithListener(mBestLocationListener);

//stop Location Updates
mBestLocationProvider.stopLocationUpdates();
`````
