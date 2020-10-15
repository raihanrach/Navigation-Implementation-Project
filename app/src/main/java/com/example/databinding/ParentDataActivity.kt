package com.example.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityParentDataBinding
import com.example.databinding.models.Parent
import com.example.databinding.models.Personal
import kotlinx.android.synthetic.main.activity_result_form.*

class ParentDataActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private lateinit var binding: ActivityParentDataBinding
    val dataParent : Parent = Parent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parent_data)

        binding.btnParentToSchool.setOnClickListener {
            intentToSchool()
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

    private fun intentToSchool() {

            dataParent.namaAyah = binding.editTextNamaAyah.text.toString()
            dataParent.nikAyah = binding.editTextNikAyah.text.toString()
            dataParent.namaIbu = binding.editTextNamaIbu.text.toString()
            dataParent.nikIbu = binding.editTextNikIbu.text.toString()
            dataParent.tanggalLahirAyah = binding.editTextLahirAyah.text.toString()
            dataParent.tanggalLahirIbu = binding.editTextLahirIbu.text.toString()
            dataParent.alamatParent = binding.editTextAlamat.text.toString()
            dataParent.phoneOrtu = binding.editTextPhone.text.toString()
            dataParent.emailParent = binding.editTextEmail.text.toString()
            dataParent.pendidikanAyah = binding.editTextPendidikanAyah.text.toString()
            dataParent.pendidikanIbu = binding.editTextPendidikanIbu.text.toString()
            dataParent.pekerjaanAyah = binding.editTextPekerjaanAyah.text.toString()
            dataParent.pekerjaanIbu = binding.editTextPekerjaanIbu.text.toString()

        val dataPribadi = intent.getParcelableExtra<Personal>(DATA_PRIBADI)!!
        val resultIntent = Intent(this, DataSekolahActivity::class.java)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        resultIntent.putExtra(DATA_PRIBADI, dataPribadi)
        startActivity(resultIntent)
    }
}