package com.example.databinding.models

import android.os.Parcel
import android.os.Parcelable

class Personal() : Parcelable{
 lateinit var nama: String
 lateinit var faculty: String
 lateinit var prodi: String
 lateinit var statusMhs: String
 lateinit var password: String
 lateinit var reasonMhs: String
 lateinit var NIK: String
 lateinit var achievement: String
 lateinit var birthPlace: String
 lateinit var birthDate: String
 var gender: String = "Laki - Laki"
 var citizen: String = "Indonesia"
 lateinit var religion: String
 lateinit var rt: String
 lateinit var rw: String
 lateinit var codePost: String
 lateinit var province: String
 lateinit var Town: String
 lateinit var phone: String
 var email: String? = null

 constructor(parcel:  Parcel) : this() {
  nama = parcel.readString().toString()
  faculty = parcel.readString().toString()
  prodi = parcel.readString().toString()
  statusMhs = parcel.readString().toString()
  password = parcel.readString().toString()
  reasonMhs = parcel.readString().toString()
  NIK = parcel.readString().toString()
  achievement = parcel.readString().toString()
  birthPlace = parcel.readString().toString()
  birthDate = parcel.readString().toString()
  gender = parcel.readString().toString()
  citizen = parcel.readString().toString()
  religion = parcel.readString().toString()
  rt = parcel.readString().toString()
  rw = parcel.readString().toString()
  codePost = parcel.readString().toString()
  province = parcel.readString().toString()
  Town = parcel.readString().toString()
  phone = parcel.readString().toString()
  email = parcel.readString().toString()
 }

 override fun writeToParcel(parcel: Parcel, flags: Int) {
  parcel.writeString(nama)
  parcel.writeString(faculty)
  parcel.writeString(prodi)
  parcel.writeString(statusMhs)
  parcel.writeString(password)
  parcel.writeString(reasonMhs)
  parcel.writeString(NIK)
  parcel.writeString(achievement)
  parcel.writeString(birthPlace)
  parcel.writeString(birthDate)
  parcel.writeString(gender)
  parcel.writeString(citizen)
  parcel.writeString(religion)
  parcel.writeString(rt)
  parcel.writeString(rw)
  parcel.writeString(codePost)
  parcel.writeString(province)
  parcel.writeString(Town)
  parcel.writeString(phone)
  parcel.writeString(email)
 }

 override fun describeContents(): Int {
  return 0
 }

 override fun toString(): String {
  return "Personal(nama='$nama', faculty='$faculty', prodi='$prodi', statusMhs='$statusMhs', password='$password', reasonMhs='$reasonMhs', NIK='$NIK', achievement='$achievement', birthPlace='$birthPlace', birthDate='$birthDate', gender='$gender', citizen='$citizen', religion='$religion', rt='$rt', rw='$rw', codePost='$codePost', province='$province', Town='$Town', phone='$phone', email='$email')"
 }

 companion object CREATOR : Parcelable.Creator<Personal> {
  override fun createFromParcel(parcel: Parcel): Personal {
   return Personal(parcel)
  }

  override fun newArray(size: Int): Array<Personal?> {
   return arrayOfNulls(size)
  }
 }


}