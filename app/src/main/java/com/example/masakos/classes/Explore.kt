package com.example.masakos.classes

import android.os.Parcel
import android.os.Parcelable

data class Explore(var name : String  , var desc : String , val detail : String , val photo : Int ) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeString(detail)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Explore> {
        override fun createFromParcel(parcel: Parcel): Explore {
            return Explore(parcel)
        }

        override fun newArray(size: Int): Array<Explore?> {
            return arrayOfNulls(size)
        }
    }
}