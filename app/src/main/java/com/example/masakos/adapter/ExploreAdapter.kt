package com.example.masakos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.masakos.R
import com.example.masakos.classes.Explore
import kotlinx.android.synthetic.main.explore_card.view.*

class ExploreAdapter(private val listExplore: ArrayList<Explore>) : RecyclerView.Adapter<ExploreAdapter.CardViewViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreAdapter.CardViewViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.explore_card, parent, false)

        return CardViewViewHolder(view)
    }
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback( onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Explore)
    }

    inner class CardViewViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(explore: Explore) {
            with(itemView){

                Glide.with(itemView.context)
                        .load(explore.photo)
                        .apply(RequestOptions().override(90 , 90))
                        .into(explore_pict)
                tv_explore_title.text = explore.name
                tv_explore_desc.text = explore.desc

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(explore) }
            }
        }

    }

    override fun getItemCount(): Int {
        return listExplore.size
    }

    override fun onBindViewHolder(holder: ExploreAdapter.CardViewViewHolder, position: Int) {
        holder.bind(listExplore[position])
    }
}
//        RecyclerView.Adapter<ExploreAdapter.ListViewHolder>() {
//
//    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var tvExploreTitle : TextView? = itemView.findViewById(R.id.tv_explore_title)
//        var tvExploreDesc : TextView? = itemView.findViewById(R.id.tv_explore_desc)
//        var imgExplore : ImageView = itemView.findViewById(R.id.explore_pict)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.explore_card, parent, false)
//        return ListViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val explore = listExplore[position]
//
//        Glide.with(holder.itemView.context)
//                .load(explore.photo)
//                .apply(RequestOptions().override(55 , 55))
//                .into(holder.imgExplore)
//        holder.tvExploreTitle?.text = explore.name
//        holder.tvExploreDesc?.text = explore.desc
//    }
//
//    override fun getItemCount(): Int {
//        return listExplore.size
//    }
//
//
//}