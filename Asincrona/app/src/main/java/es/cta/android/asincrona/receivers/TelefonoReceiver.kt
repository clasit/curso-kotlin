package es.cta.android.asincrona.receivers


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
 *
 * <intent-filter>
 *      <action android:name="android.intent.action.PHONE_STATE"></action>
 * </intent-filter>
 **/

class TelefonoReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("RECEIVER_TEL", "Llamada telefónica")
    }
}
