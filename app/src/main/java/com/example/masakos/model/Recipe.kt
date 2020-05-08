package com.example.masakos.model

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
){
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
}