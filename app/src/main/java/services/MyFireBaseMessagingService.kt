package services

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.masakos.MainActivity
import com.example.masakos.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@Suppress("DEPRECATION")
class MyFireBaseMessagingService : FirebaseMessagingService() {
    val TAG :String = "FIREBASE MESSAGE"
    @SuppressLint("LongLogTag")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "from " + remoteMessage.from )

        if (remoteMessage.notification != null){
            Log.d(TAG," from " +remoteMessage.from )
            Log.d(TAG, "judul notif " + remoteMessage.notification?.title)
            showNotification(remoteMessage.notification?.title , remoteMessage.notification?.body)
        }
    }

    private fun showNotification(title: String?, body:String?) {
        val intent =  Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_ONE_SHOT)
        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_app)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())
    }

    override fun onNewToken(p0: String?) {
        Log.d(TAG, "Refreshed token: " + p0);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server
    }

}
