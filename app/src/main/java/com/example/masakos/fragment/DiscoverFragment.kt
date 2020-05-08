package com.example.masakos.fragment

import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masakos.R
import com.example.masakos.adapter.FirestoreRecipeAdapter
import com.example.masakos.classes.Explore
import com.example.masakos.model.Recipe
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.fragment_discover.view.*
import kotlinx.android.synthetic.main.fragment_discover.view.rv_explore

/**
 * A simple [Fragment] subclass.
 */
class DiscoverFragment : Fragment() {

    private lateinit var dataTitle: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataDetail: Array<String>
    private lateinit var dataImage: TypedArray
    private val TAG = "DiscoverFragment!"
    private var firestoreDB: FirebaseFirestore? = null
    private var firestore: ListenerRegistration? = null
    private var listExplore: ArrayList<Explore> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_discover, container, false)
        firestoreDB = FirebaseFirestore.getInstance()
//        loadRecipes()
//        prepare()
//        addItem()

//        rootView.rv_explore.layoutManager = LinearLayoutManager(rootView.context)

//        val adapter = ExploreAdapter(listExplore)
//        adapter.setOnItemClickCallback(object : ExploreAdapter.OnItemClickCallback{
//            override fun onItemClicked(data: Explore) {
//                val i = Intent(rootView.context , DetailExploreActivity::class.java)
//                i.putExtra(ARG_POSITION , data)
//                startActivity(i)
//            }
//        })
        firestoreDB!!.collection("resep").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val resepList = mutableListOf<Recipe>()
                for (doc in task.result!!) {
                    val recipe = doc.toObject<Recipe>(Recipe::class.java)
                    recipe.id = doc.id
                    resepList.add(recipe)
                }
                val adapter = FirestoreRecipeAdapter(resepList, rootView.context, firestoreDB!!)
                val mLayoutManager = LinearLayoutManager(rootView.context)
                rv_explore.layoutManager = mLayoutManager
                rv_explore.itemAnimator = DefaultItemAnimator()
                rootView.rv_explore.adapter = adapter
            } else {
                Log.d(TAG, "Error Broo..", task.exception)
            }
        }

        return rootView
    }

    private fun loadRecipes() {

    }

    companion object {
        const val ARG_POSITION: String = "positioin"
        fun newInstance(): DiscoverFragment {
            val fragment = DiscoverFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, 1)
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

//    private fun addItem() {
//        for (position in dataTitle.indices) {
//            val explore = Explore(
//                    dataId[position],
//                    dataTitle[position],
//                    dataDesc[position],
//                    dataDetail[position],
//                    dataImage.getResourceId(position, -1)
//            )
//            listExplore.add(explore)
//        }
//    }


}
