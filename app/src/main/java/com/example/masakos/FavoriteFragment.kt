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
class FavoriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorit, container , false)
    }

    companion object {
        fun newInstance(): FavoriteFragment {
            val fragment = FavoriteFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
