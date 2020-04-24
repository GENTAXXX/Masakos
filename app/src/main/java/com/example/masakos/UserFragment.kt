package com.example.masakos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container , false)
    }
    companion object {
        fun newInstance(): DiscoverFragment{
            val fragment = DiscoverFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
