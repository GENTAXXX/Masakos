package com.example.masakos

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.masakos.adapter.GlideApp
import com.example.masakos.classes.Explore
import android.R.layout.simple_list_item_1
import com.example.masakos.fragment.DiscoverFragment
import com.example.masakos.model.Recipe
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_detail_explore.*
import kotlinx.android.synthetic.main.content_detail_explore.*

class DetailExploreActivity : AppCompatActivity() {
    private var TAG = "cobaa"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_explore)
        val storage = FirebaseStorage.getInstance()
        val recipe = intent.getParcelableExtra<Recipe>(DiscoverFragment.ARG_POSITION)
        val gsStorage = storage.getReferenceFromUrl(recipe.imgUrl.toString())
        var bahan : ArrayList<String> = recipe?.recipes as ArrayList<String>
        var langkah : ArrayList<String> = recipe?.steps as ArrayList<String>
        exdetail_title.text = recipe?.title
        exdetail_rectype.text = recipe?.recipeType
        exdetail_category.text = recipe?.category
        exdetail_desc.text = "\""+recipe?.desc+"\""
        toolbar_title.text = recipe?.title
        Log.d(TAG, bahan.toString())
        Log.d(TAG, "clihatt " + recipe?.steps?.get(0) )
        Log.d(TAG, "clihatt " + recipe?.recipes )

        GlideApp.with(this).load(gsStorage).into(iv_exp_detail)

        btnBack.setOnClickListener {
            finish()
        }
    }

}
