package es.cta.android.hobbies.model

import android.os.Parcel
import android.os.Parcelable

data class Hobbie(public val title: String,
                  public val image: String): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hobbie> {
        override fun createFromParcel(parcel: Parcel): Hobbie {
            return Hobbie(parcel)
        }

        override fun newArray(size: Int): Array<Hobbie?> {
            return arrayOfNulls(size)
        }
    }
}