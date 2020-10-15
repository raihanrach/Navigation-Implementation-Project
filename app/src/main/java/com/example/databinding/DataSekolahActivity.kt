package com.example.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityDataSekolahBinding
import com.example.databinding.models.Parent
import com.example.databinding.models.Personal
import com.example.databinding.models.Sekolah


class DataSekolahActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private val DATA_SCHOOL = "DATA_SCHOOL"
    lateinit var binding: ActivityDataSekolahBinding

    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>
    val dataSekolah : Sekolah = Sekolah()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_sekolah)
        setUp()
        loadDataSpinner()

        binding.btnGoToResult.setOnClickListener {
            intentToResult()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1 , Menu.NONE, "Light Mode")
        menu?.add(Menu.NONE, 2 , Menu.NONE, "Dark Mode")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUp() {
        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataKota)

        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerProvinsiUnivAsal.adapter = adapterProvinsi
        binding.spinnerKotaUnivAsal.adapter = adapterKota
    }

    private fun intentToResult() {

        dataSekolah.namaUnivAsal = binding.editTextUnivAsal.text.toString()
        dataSekolah.namaFakultasAsal = binding.editTextFakultasAsal.text.toString()
        dataSekolah.namaProdiAsal = binding.editTextProdiAsal.text.toString()
        dataSekolah.provinsiUnivAsal = binding.spinnerProvinsiUnivAsal.selectedItem.toString()
        dataSekolah.kotaUnivAsal = binding.spinnerKotaUnivAsal.selectedItem.toString()
        dataSekolah.alamatUnivAsal = binding.editTextAlamatUnivAsal.text.toString()
        dataSekolah.kodePosUnivAsal = binding.editTextKodePos.text.toString()
        dataSekolah.akreditasiUnivAsal = binding.editTextAkreditasiUnivAsal.text.toString()
        dataSekolah.nilaiIPK = binding.editTextNilaiIPK.text.toString()

        val dataParent = intent.getParcelableExtra<Parent>(DATA_PARENT)!!
        val dataPribadi = intent.getParcelableExtra<Personal>(DATA_PRIBADI)!!
        val resultIntent = Intent(this, ResultFormActivity::class.java)
        resultIntent.putExtra(DATA_SCHOOL, dataSekolah)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        resultIntent.putExtra(DATA_PRIBADI, dataPribadi)
        startActivity(resultIntent)
    }
}