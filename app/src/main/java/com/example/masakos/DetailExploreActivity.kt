package com.example.masakos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.masakos.classes.Explore
import com.example.masakos.fragment.DiscoverFragment
import kotlinx.android.synthetic.main.activity_detail_explore.*
import kotlinx.android.synthetic.main.content_detail_explore.*

class DetailExploreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_explore)

        val explore = intent.getParcelableExtra<Explore>(DiscoverFragment.ARG_POSITION)
        exdetail_title.text = explore?.title
        exdetail_desc.text = "\""+explore?.desc+"\""
        exdetail_detail.text = explore?.author
        toolbar_title.text = explore?.title

        Glide.with(this).load(explore?.photo).into(iv_exp_detail)

        btnBack.setOnClickListener {
            finish()
        }
    }

}
