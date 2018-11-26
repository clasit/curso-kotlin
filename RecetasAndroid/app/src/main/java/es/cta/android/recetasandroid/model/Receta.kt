package es.cta.android.recetasandroid.model

import android.os.Parcel
import android.os.Parcelable

// data class -> Clase sólo de datos
data class Receta(var titulo: String,
                  val desc: String,
                  val imgThumb: String,
                  val instruccion: String): Parcelable {

    // NOTA: Se extiende de Parcelable para poder serializar y pasar el objeto entre actividades

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return titulo
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(desc)
        parcel.writeString(imgThumb)
        parcel.writeString(instruccion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Receta> {
        override fun createFromParcel(parcel: Parcel): Receta {
            return Receta(parcel)
        }

        override fun newArray(size: Int): Array<Receta?> {
            return arrayOfNulls(size)
        }
    }
}