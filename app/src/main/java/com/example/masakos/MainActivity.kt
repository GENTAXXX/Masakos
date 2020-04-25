package com.example.masakos

//import android.R
//import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.masakos.fragment.FavoriteFragment
import com.example.masakos.fragment.DiscoverFragment
import com.example.masakos.fragment.HomeFragment
import com.example.masakos.fragment.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelected)
        val fragment = HomeFragment.newInstance()
        loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean{
        if (fragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content, fragment , fragment.javaClass.getSimpleName())
                    .commit()
        }
        return true


    }
    @SuppressLint("SetTextI18n")
    private val mOnNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val toolbar: TextView = findViewById(R.id.toolbar_title)
        when (item.itemId) {
                R.id.home_menu -> {
                   val fragment= HomeFragment.newInstance()
                    toolbar.text = "Home"
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.search_menu -> {
                    val fragment = DiscoverFragment.newInstance()
                    toolbar.text = "Explore"
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorite_menu -> {
                    val fragment = FavoriteFragment.newInstance()
                    toolbar.text = "Favorite"
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.account_menu -> {
                    val fragment = UserFragment.newInstance()
                    toolbar.text = "Account"
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                else -> {
                    val fragment= HomeFragment.newInstance()
                    toolbar.text = "Home"
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}


