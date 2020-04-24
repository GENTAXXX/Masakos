package com.example.masakos

//import android.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    private var content: FrameLayout? = null

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
    private val mOnNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_menu -> {
                   val fragment= HomeFragment.newInstance()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.search_menu -> {
                    val fragment = DiscoverFragment.newInstance()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorite_menu -> {
                    val fragment = FavoriteFragment.newInstance()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.account_menu -> {
                    val fragment = UserFragment.newInstance()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                else -> {
                    val fragment= HomeFragment.newInstance()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
    }


}


