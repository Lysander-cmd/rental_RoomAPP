package www.smktelkommalang.sch.id.rental_room.Model.Ruangan

import android.os.Parcel
import android.os.Parcelable


data class RuanganData(
    val image: String, val kapasitas: String, val ukuran: String, val title : String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image)
        parcel.writeString(kapasitas)
        parcel.writeString(ukuran)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RuanganData> {
        override fun createFromParcel(parcel: Parcel): RuanganData {
            return RuanganData(parcel)
        }

        override fun newArray(size: Int): Array<RuanganData?> {
            return arrayOfNulls(size)
        }
    }
}

