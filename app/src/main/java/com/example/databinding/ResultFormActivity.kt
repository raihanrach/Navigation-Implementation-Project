package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityResultFormBinding
import com.example.databinding.models.Parent
import com.example.databinding.models.Personal
import com.example.databinding.models.Sekolah

class ResultFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private val DATA_SCHOOL = "DATA_SCHOOL"
    private lateinit var binding: ActivityResultFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result_form)

        val sekolah : Sekolah = intent.getParcelableExtra<Sekolah>(DATA_SCHOOL)!!
        val parent : Parent = intent.getParcelableExtra<Parent>(DATA_PARENT)!!
        val personal : Personal = intent.getParcelableExtra<Personal>(DATA_PRIBADI)!!
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
}