package com.cordova.plugin.widespace;

import java.util.Map;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.widespace.AdSpace;

import com.widespace.adspace.PrefetchStatus;
import com.widespace.exception.ExceptionTypes;
import com.widespace.interfaces.AdMediaEventListener;

import com.widespace.interfaces.AdErrorEventListener;
import com.widespace.interfaces.AdEventListener;
import com.widespace.interfaces.AdAnimationEventListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;

public class CDVWidespace extends CordovaPlugin{

    private String TAG = "SplashAd";
    private static final String SPLASH_SID = "cfee88cc-8d1c-4151-9a4d-d09400a912ea";
    private AdSpace adSpace;
    

    
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	if (action.equals("initSplashAd")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                	 adSpace = new AdSpace(cordova.getActivity(), SPLASH_SID, false, false);
                	initSplashAd();
                }
            });
            return true;
        }
        return false;
    }
    
   

    private void initSplashAd() {
        adSpace.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        adSpace.setAdEventListener(adEventListener);
        adSpace.setAdErrorEventListener(adErrorListener);
        // It is better to pre-fetch the ad and then on the onPrefetchAd event
        // call the runAd method of the adSpace. Please explore the advanced
        // demo to see the varieties of implementations of Splash Ad.
        // For this basic demo we are going to use runAd method.
        adSpace.runAd();
    }

    /**
     * This is the basic event listeners for AdSpace
     */
    private AdEventListener adEventListener = new AdEventListener() {

        @Override
        public void onPrefetchAd(AdSpace sender, PrefetchStatus status) {
            Log.d(TAG, "onPrefetchAd");
        }

        @Override
        public void onNoAdRecieved(AdSpace sender) {
            Log.d(TAG, "onNoAdRecieved");
        }

        @Override
        public void onAdLoading(AdSpace sender) {
            Log.d(TAG, "onAdLoading");
        }

       
		@Override
		public void onAdClosed(AdSpace arg0, com.widespace.AdInfo.AdType arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAdClosing(AdSpace arg0, com.widespace.AdInfo.AdType arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAdDismissed(AdSpace arg0, boolean arg1,
				com.widespace.AdInfo.AdType arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAdDismissing(AdSpace arg0, boolean arg1,
				com.widespace.AdInfo.AdType arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAdLoaded(AdSpace arg0, com.widespace.AdInfo.AdType arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAdPresented(AdSpace arg0, boolean arg1,
				com.widespace.AdInfo.AdType arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAdPresenting(AdSpace arg0, boolean arg1,
				com.widespace.AdInfo.AdType arg2) {
			// TODO Auto-generated method stub
			
		}

	
    };

    // Please implement this event listener while you are in development mode,
    // so that you get notification if there is any errors.
    private AdErrorEventListener adErrorListener = new AdErrorEventListener() {

        @Override
        public void onFailedWithError(Object sender, ExceptionTypes type, String message,
                Exception exeception) {
            Log.d(TAG, "onFailedWithError : error message # " + message);
        }

		
    };

   


}
