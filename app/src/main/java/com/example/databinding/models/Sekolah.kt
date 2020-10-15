package com.example.databinding.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


class Sekolah () : Parcelable {
    lateinit var namaUnivAsal: String
    lateinit var namaFakultasAsal: String
    lateinit var namaProdiAsal: String
    lateinit var provinsiUnivAsal: String
    lateinit var kotaUnivAsal: String
    lateinit var alamatUnivAsal: String
    lateinit var kodePosUnivAsal: String
    lateinit var akreditasiUnivAsal: String
    lateinit var nilaiIPK:String

    constructor(parcel: Parcel) : this() {
        namaUnivAsal = parcel.readString().toString()
        namaFakultasAsal = parcel.readString().toString()
        namaProdiAsal = parcel.readString().toString()
        provinsiUnivAsal = parcel.readString().toString()
        kotaUnivAsal = parcel.readString().toString()
        alamatUnivAsal = parcel.readString().toString()
        kodePosUnivAsal = parcel.readString().toString()
        akreditasiUnivAsal = parcel.readString().toString()
        nilaiIPK = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(namaUnivAsal)
        parcel.writeString(namaFakultasAsal)
        parcel.writeString(namaProdiAsal)
        parcel.writeString(provinsiUnivAsal)
        parcel.writeString(kotaUnivAsal)
        parcel.writeString(alamatUnivAsal)
        parcel.writeString(kodePosUnivAsal)
        parcel.writeString(akreditasiUnivAsal)
        parcel.writeString(nilaiIPK)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sekolah> {
        override fun createFromParcel(parcel: Parcel): Sekolah {
            return Sekolah(parcel)
        }

        override fun newArray(size: Int): Array<Sekolah?> {
            return arrayOfNulls(size)
        }
    }
}