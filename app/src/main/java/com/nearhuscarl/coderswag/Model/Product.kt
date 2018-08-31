package com.nearhuscarl.coderswag.Model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Product(val title: String, val price: String, val image: String) : Parcelable {
    var rate: Int = 0

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        rate = parcel.readInt()
    }

    init {
        val random = Random()
        val randomRate = random.nextInt(6)
        rate = randomRate
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(price)
        parcel.writeString(image)
        parcel.writeInt(rate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}