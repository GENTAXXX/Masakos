@file:Suppress("DEPRECATION")

package services

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class FirebaseInstanceId : FirebaseInstanceIdService() {
    val TAG = "PushNotifService"
    lateinit var name: String

    override fun onTokenRefresh() {
        // Mengambil token perangkat
        val token = FirebaseInstanceId.getInstance().getToken()
        Log.d(TAG, "Token perangkat ini: ${token}")

        // Jika ingin mengirim push notifcation ke satu atau sekelompok perangkat,
        // simpan token ke server di sini.
    }

}