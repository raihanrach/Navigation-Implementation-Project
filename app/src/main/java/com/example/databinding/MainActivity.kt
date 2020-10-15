package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.models.Personal
import java.util.*

class MainActivity : AppCompatActivity() {

    private val DATA_PRIBADI = "DATA_PRIBADI"
    private lateinit var binding: ActivityMainBinding

    private lateinit var dataFakultas: Array<String>
    private lateinit var dataProdi: Array<String>
    private lateinit var dataStatus: Array<String>
    private lateinit var dataAgama: Array<String>
    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>
    val dataPribadi : Personal = Personal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUp()
        loadDataSpinner()

        binding.editTextDate.setOnClickListener {
            datePicker()
        }

        binding.btnPersonaltoParent.setOnClickListener {
            intentToParent()
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
        dataFakultas = resources.getStringArray(R.array.dataFakultas)
        dataProdi = resources.getStringArray(R.array.dataProdi)
        dataStatus = resources.getStringArray(R.array.dataStatus)
        dataAgama = resources.getStringArray(R.array.dataAgama)
        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterFakultas = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataFakultas)
        val adapterProdi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProdi)
        val adapterStatus = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataStatus)
        val adapterAgama = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataAgama)
        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataKota)

        adapterFakultas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterProdi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterAgama.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerFakultas.adapter = adapterFakultas
        binding.spinnerProdi.adapter = adapterProdi
        binding.spinnerStatus.adapter = adapterStatus
        binding.spinnerAgama.adapter = adapterAgama
        binding.spinnerProvinsi.adapter = adapterProvinsi
        binding.spinnerKota.adapter = adapterKota
    }


    private fun datePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                val bulan = (monthOfYear + 1)
                binding.editTextDate.setText("$dayOfMonth/$bulan/$year")
            },
            year,
            month,
            day
        )
        dpd.show()
    }

    private fun radioButtonSelectionSex(): String {
        val selected: Int = binding.radioGroupSex.checkedRadioButtonId
        return if (selected == binding.radioButtonPerempuan.id) {
            binding.radioButtonPerempuan.text.toString()
        } else {
            binding.radioButtonLaki.text.toString()
        }
    }

    private fun radioButtonSelectionNation(): String {
        val selected: Int = binding.radioGroupNationality.checkedRadioButtonId
        return if (selected == binding.radioButtonAsing.id) {
            binding.radioButtonAsing.text.toString()
        } else {
            binding.radioButtonIndonesia.text.toString()
        }
    }

    private fun intentToParent() {
        dataPribadi.nama = binding.editTextNama.text.toString()
        dataPribadi.faculty = binding.textViewFakultas.toString()
        dataPribadi.prodi = binding.textViewProdi.text.toString()
        dataPribadi.statusMhs = binding.textViewStatus.text.toString()
        dataPribadi.password = binding.textViewPassword.text.toString()
        dataPribadi.reasonMhs = binding.textViewAlasan.text.toString()
        dataPribadi.achievement = binding.textViewPrestasi.text.toString()
        dataPribadi.religion = binding.textViewAgama.text.toString()
        dataPribadi.rt = binding.textViewRtRw.text.toString()
        dataPribadi.rw = binding.textViewSlashRtRW.text.toString()
        dataPribadi.province = binding.textViewProvinsi.text.toString()
        dataPribadi.Town = binding.textViewKota.text.toString()
        dataPribadi.phone = binding.textViewPhone.text.toString()
        dataPribadi.email = binding.textViewEmail.text.toString()
        dataPribadi.NIK = binding.textViewNik.text.toString()
        dataPribadi.birthDate = binding.editTextDate.text.toString()
        dataPribadi.birthPlace = binding.editTextPlace.text.toString()
        dataPribadi.citizen = binding.textViewKota.text.toString()
        dataPribadi.codePost = binding.editTextPostal.text.toString()

        val resultIntent = Intent(this, ParentDataActivity::class.java)
        resultIntent.putExtra(DATA_PRIBADI, dataPribadi)
        startActivity(resultIntent)
    }


}