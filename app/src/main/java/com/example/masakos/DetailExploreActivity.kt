package com.example.masakos

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.appwidget.AppWidgetManager;
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.masakos.adapter.GlideApp
import com.example.masakos.classes.Explore
import android.R.layout.simple_list_item_1
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.masakos.fragment.DiscoverFragment
import com.example.masakos.model.Recipe
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_detail_explore.*
import kotlinx.android.synthetic.main.content_detail_explore.*
import widget.WidgetResep

class DetailExploreActivity : AppCompatActivity(), YouTubePlayer.OnInitializedListener {

    private var TAG = "cobaa "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_explore)
        val storage = FirebaseStorage.getInstance()
        val recipe = intent.getParcelableExtra<Recipe>(DiscoverFragment.ARG_POSITION)
        val gsStorage = storage.getReferenceFromUrl(recipe.imgUrl.toString())
        var bahan: ArrayList<String> = recipe?.recipes as ArrayList<String>
        var langkah: ArrayList<String> = recipe?.steps as ArrayList<String>
        val vidId : String? = recipe?.videoUrl
        val videoUrl: String? = vidId?.drop(32)
        Log.d(TAG,videoUrl)
        exdetail_title.text = recipe?.title
        exdetail_rectype.text = recipe?.recipeType
        exdetail_category.text = recipe?.category
        exdetail_desc.text = "\"" + recipe?.desc + "\""
        toolbar_title.text = recipe?.title

        Log.d(TAG, bahan.toString())
        Log.d(TAG, "lihatt " + recipe?.steps?.get(0))
        Log.d(TAG, "lihatt " + recipe?.recipes)

        GlideApp.with(this).load(gsStorage).into(iv_exp_detail)


        btnBack.setOnClickListener {
            finish()
        }
        btnAdd.setOnClickListener {
            handleSetupWidget(recipe)
        }
        btnFav.setOnClickListener{
            val intent = YouTubeStandalonePlayer.createVideoIntent(this, getString(R.string.dev_key), videoUrl);
            startActivity(intent);
        }
    }
    private fun handleSetupWidget(data: Recipe) {
        val intent = Intent(this, WidgetResep::class.java)
        Toast.makeText(applicationContext,"Berhasil ditambahkan ke widget!" , Toast.LENGTH_SHORT).show()
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE)
        val ids: IntArray = AppWidgetManager.getInstance(application).getAppWidgetIds(ComponentName(application, WidgetResep::class.java))
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
        intent.putExtra(AppWidgetManager.ACTION_APPWIDGET_UPDATE, data)
        setResult(RESULT_OK, intent);
        Log.d(TAG, intent.toString())
        sendBroadcast(intent)
    }

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
        if (!p2) {
            p1?.cueVideo("asdasdqwe")
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
    }
}

//        appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
//        var intent: Intent = getIntent()
//        var extras: Bundle = intent.extras!!
//        if (extras!= null){
//            appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
//            if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
//                finish();
//            }
//            var resultValue : Intent = Intent()
//            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
//            setResult(Activity.RESULT_OK, resultValue)
//            finish()
