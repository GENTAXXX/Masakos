package com.example.masakos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.masakos.R
import com.example.masakos.model.Recipe
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.explore_card.view.*

class FirestoreRecipeAdapter (
        private val recipeList: MutableList<Recipe>,
        private val context: Context,
        private val firebaseDB: FirebaseFirestore
): RecyclerView.Adapter<FirestoreRecipeAdapter.CardViewViewHolder>(){
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback( onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Recipe)
    }
    inner class CardViewViewHolder (view: View):RecyclerView.ViewHolder(view){

        fun bind(recipe: Recipe){
            val storage = FirebaseStorage.getInstance()
            val gsStorage = storage.getReferenceFromUrl(recipe.imgUrl.toString())
          with(itemView){
              GlideApp.with(itemView.context)
                      .load(gsStorage)
                      .apply(RequestOptions().override(90 , 90))
                      .into(explore_pict)
              tv_explore_title.text = recipe.title
              tv_explore_desc.text = recipe.desc

              itemView.setOnClickListener { onItemClickCallback?.onItemClicked(recipe) }
          }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.explore_card,parent,false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(recipeList[position]);
    }

}