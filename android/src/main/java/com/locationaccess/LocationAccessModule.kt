package com.locationaccess

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise 
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import com.facebook.react.bridge.Arguments  
import android.app.Activity
import com.facebook.react.bridge.*


class LocationAccessModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

private val REQUEST_ENABLE_GPS = 1001
    private var enableGpsPromise: Promise? = null

  override fun getName(): String {
    return NAME
  }

   @ReactMethod
  fun checkGpsStatus(promise: Promise) {
    val locationManager = reactApplicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    promise.resolve(isEnabled)
  }

    @ReactMethod
    fun onChangeState(promise: Promise) {
        enableGpsPromise = promise
        val activity = currentActivity
        if (activity != null) {
            val intent = Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            activity.startActivityForResult(intent, REQUEST_ENABLE_GPS)
        } else {
            promise.reject("ACTIVITY_NULL", "Current activity is null")
        }
    }

  

  companion object {
    const val NAME = "LocationAccess"
  }
}