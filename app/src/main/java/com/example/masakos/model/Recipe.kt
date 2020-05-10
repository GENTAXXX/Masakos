package com.example.masakos.model

import android.os.Parcel
import android.os.Parcelable

data class Recipe (
    var id: String? = null,
    var title: String? = null,
    var videoUrl: String? = null,
    var author: String? = null,
    var category: String? = null,
    var desc: String? = null,
    var imgUrl: String? = null,
    var recipeType: String? = null,
    var recipes: List<String>? = null,
    var steps: List<String>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.createStringArrayList()) {
    }

    fun toMap():Map<String, Any>{
        val result = HashMap<String, Any>()
        result.put("title", title!!)
        result.put("videoUrl",videoUrl!!)
        result.put("author",author!!)
        result.put("category",category!!)
        result.put("imgUrl",imgUrl!!)
        result.put("recipeType",recipeType!!)

        return  result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(videoUrl)
        parcel.writeString(author)
        parcel.writeString(category)
        parcel.writeString(desc)
        parcel.writeString(imgUrl)
        parcel.writeString(recipeType)
        parcel.writeStringList(recipes)
        parcel.writeStringList(steps)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}