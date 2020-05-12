package widget

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.masakos.DetailExploreActivity
import com.example.masakos.model.Recipe

class RemoteViewWidgetFactory(context : Context) : RemoteViewsService.RemoteViewsFactory{
    val TRACK_ACTION = "com.ex.masakos"
    val USER_ID_EXTRA = "userId"
    var mWidgetItems = Recipe
    override fun onCreate() {
        TODO("Not yet implemented")
    }

    override fun getLoadingView(): RemoteViews {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long =0

    override fun onDataSetChanged() {

    }

    override fun hasStableIds(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getViewAt(position: Int): RemoteViews {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

}