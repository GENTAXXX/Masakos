package com.example.masakos.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masakos.R
import com.example.masakos.adapter.ExploreAdapter
import com.example.masakos.classes.Explore
import com.example.masakos.data.ExploreData.listData

/**
 * A simple [Fragment] subclass.
 */
class DiscoverFragment : Fragment() {
    private lateinit var rvExplore : RecyclerView
    private var list: ArrayList<Explore> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView : View = inflater.inflate(R.layout.fragment_favorit, container, false)
        var adapter : ExploreAdapter
        rvExplore = rootView.findViewById(R.id.rv_explore)
        rvExplore.layoutManager = LinearLayoutManager(activity)
        val listExploreAdapter = ExploreAdapter(listData)
        rvExplore.adapter = listExploreAdapter
        rootView.findViewById<RecyclerView>(R.id.rv_explore).adapter = listExploreAdapter
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvExplore = view.findViewById(R.id.rv_explore) as RecyclerView
        rvExplore.setHasFixedSize(true)
        list.addAll(listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvExplore.layoutManager = LinearLayoutManager(activity)
        val listExploreAdapter = ExploreAdapter(listData)
        rvExplore.adapter = listExploreAdapter
    }

    companion object {
        fun newInstance(): DiscoverFragment {
            val fragment = DiscoverFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
