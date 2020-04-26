package com.example.masakos.fragment

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masakos.DetailExploreActivity
import com.example.masakos.R
import com.example.masakos.adapter.ExploreAdapter
import com.example.masakos.classes.Explore
import kotlinx.android.synthetic.main.fragment_discover.view.*

/**
 * A simple [Fragment] subclass.
 */
class DiscoverFragment : Fragment() {

    private lateinit var dataTitle: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataDetail: Array<String>
    private lateinit var dataImage: TypedArray
    private var listExplore : ArrayList<Explore> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView : View = inflater.inflate(R.layout.fragment_discover, container, false)
        prepare()
        addItem()

        rootView.rv_explore.layoutManager = LinearLayoutManager(rootView.context)

        val adapter = ExploreAdapter(listExplore)
        adapter.setOnItemClickCallback(object : ExploreAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Explore) {
                val i = Intent(rootView.context , DetailExploreActivity::class.java)
                i.putExtra(ARG_POSITION , data)
                startActivity(i)
            }
        })
        rootView.rv_explore.adapter = adapter
        return rootView
    }

    companion object {
        const val ARG_POSITION: String = "positioin"
        fun newInstance(): DiscoverFragment {
            val fragment = DiscoverFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION,1)
            fragment.arguments = args
            return fragment
        }
    }

    private fun prepare() {
        dataTitle = resources.getStringArray(R.array.explore_title)
        dataDesc = resources.getStringArray(R.array.explore_desc)
        dataDetail = resources.getStringArray(R.array.explore_detail)
        dataImage = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataTitle.indices) {
            val explore = Explore(
                    dataTitle[position],
                    dataDesc[position],
                    dataDetail[position],
                    dataImage.getResourceId(position, -1)
            )
            listExplore.add(explore)
        }
    }


}
