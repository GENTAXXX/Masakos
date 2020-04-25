package com.example.masakos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.masakos.R
import com.example.masakos.classes.Explore
import kotlinx.android.synthetic.main.explore_card.view.*

class ExploreAdapter(private val listExplore: ArrayList<Explore>) : RecyclerView.Adapter<ExploreAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvExploreTitle : TextView? = itemView.findViewById(R.id.tv_explore_title)
        var tvExploreDesc : TextView? = itemView.findViewById(R.id.tv_explore_desc)
        var imgExplore : ImageView = itemView.findViewById(R.id.explore_pict)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_discover,parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val explore = listExplore[position]

        Glide.with(holder.itemView.context)
                .load(explore.photo)
                .apply(RequestOptions().override(55 , 55))
                .into(holder.imgExplore)
        holder.tvExploreTitle?.text = explore.name
        holder.tvExploreDesc?.text = explore.desc
    }

    override fun getItemCount(): Int {
        return listExplore.size
    }


}