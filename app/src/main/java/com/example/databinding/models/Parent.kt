package com.example.databinding.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import android.view.View
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

class Parent : Fragment {
       lateinit var namaAyah: String
        lateinit var nikAyah: String
        lateinit var namaIbu: String
        lateinit var nikIbu: String
        lateinit var tanggalLahirAyah: String
        lateinit var tanggalLahirIbu: String
        lateinit var alamatParent: String
        lateinit var phoneOrtu: String
        lateinit var emailParent: String
        lateinit var pendidikanAyah: String
        lateinit var pendidikanIbu: String
        lateinit var pekerjaanAyah: String
        lateinit var pekerjaanIbu: String

        constructor(parcel: Parcel) : this() {
            namaAyah = parcel.readString().toString()
            nikAyah = parcel.readString().toString()
            namaIbu = parcel.readString().toString()
            nikIbu = parcel.readString().toString()
            tanggalLahirAyah = parcel.readString().toString()
            tanggalLahirIbu = parcel.readString().toString()
            alamatParent = parcel.readString().toString()
            phoneOrtu = parcel.readString().toString()
            emailParent = parcel.readString().toString()
            pendidikanAyah = parcel.readString().toString()
            pendidikanIbu = parcel.readString().toString()
            pekerjaanAyah = parcel.readString().toString()
            pekerjaanIbu = parcel.readString().toString()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(namaAyah)
            parcel.writeString(nikAyah)
            parcel.writeString(namaIbu)
            parcel.writeString(nikIbu)
            parcel.writeString(tanggalLahirAyah)
            parcel.writeString(tanggalLahirIbu)
            parcel.writeString(alamatParent)
            parcel.writeString(phoneOrtu)
            parcel.writeString(emailParent)
            parcel.writeString(pendidikanAyah)
            parcel.writeString(pendidikanIbu)
            parcel.writeString(pekerjaanAyah)
            parcel.writeString(pekerjaanIbu)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Parent> {
            override fun createFromParcel(parcel: Parcel): Parent {
                return Parent(parcel)
            }

            override fun newArray(size: Int): Array<Parent?> {
                return arrayOfNulls(size)
            }
        }
    }
