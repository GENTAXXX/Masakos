package com.example.masakos.data

import com.example.masakos.R
import com.example.masakos.classes.Explore

object ExploreData {
    private val exploreRecipe = arrayOf(
            "Bakpao Anak Kos",
            "Coklat Cake Kapitalis",
            "Kupi Dalgona",
            "Nutrisar* Jeruk",
            "Indom*e Aceh",
            "Bubur Oat",
            "Pancake Gopek",
            "Seblak Instan",
            "Warm Tea",
            "Fried Shrimp"
    )

    private val exploreDesc = arrayOf(
            "Bakpao yang dibuat menggunakan magic jar, ga repottttt",
            "Kue coklat khas negeri paman Sam",
            "Kopi mainstream sejuta umat",
            "Beli diwarung cuma 1500an, gampang bikinnyaaa~~~",
            "Sebenarnya ini cuman mie instan, maklum anak kos ehe",
            "Bubur oat pelepas lapar tengah malam anak kos",
            "Pancake instan yang tepung mixnya bisa dibeli di minimarket terdekat",
            "Seblak gadungan, aslinya ya dalam bentuk mie instan",
            "Warm tea biar keliatan mahal, btw teh anget kalo ga bisa bikin kebangetan deh!",
            "Kalo yang ini udah rada mewah sih hehe"
    )

    private val explorePict = intArrayOf(
            R.drawable.bakpao,
            R.drawable.coklatkek,
            R.drawable.dalgone,
            R.drawable.jusjeruk,
            R.drawable.mieaceh,
            R.drawable.oatdang,
            R.drawable.pancake,
            R.drawable.seblak,
            R.drawable.tehanget,
            R.drawable.udanggoreng
    )
//
//    val listData : ArrayList<Explore>
//        get(){
//            val list = arrayListOf<Explore>()
//            for (position in exploreRecipe.indices){
//                val explore = Explore()
//                explore.name = exploreRecipe[position]
//                explore.desc = exploreDesc[position]
//                explore.photo = explorePict[position]
//                list.add(explore)
//            }
//            return list
//        }
}