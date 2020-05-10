package services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class UpdateWidgetService : Service() {
    var LOG: String = "Widgettttt"
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}