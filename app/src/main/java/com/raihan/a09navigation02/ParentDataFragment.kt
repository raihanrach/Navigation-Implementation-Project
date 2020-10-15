package com.raihan.a09navigation02


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.raihan.a09navigation02.databinding.FragmentParentDataBinding
import com.raihan.a09navigation02.models.ParentData


class ParentDataFragment : Fragment() {
    private lateinit var binding: FragmentParentDataBinding
    private val args: ParentDataFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_parent_data, container, false)

        binding.btnParentToSchool.setOnClickListener {
            intentToSchool()
        }

        return binding.root
    }

    private fun intentToSchool() {
        val dataParent = ParentData(
            namaAyah = binding.editTextNamaAyah.text.toString(),
            nikAyah = binding.editTextNikAyah.text.toString(),
            namaIbu = binding.editTextNamaIbu.text.toString(),
            nikIbu = binding.editTextNikIbu.text.toString(),
            tanggalLahirAyah = binding.editTextLahirAyah.text.toString(),
            tanggalLahirIbu = binding.editTextLahirIbu.text.toString(),
            alamatParent = binding.editTextAlamat.text.toString(),
            phoneOrtu = binding.editTextPhone.text.toString(),
            emailParent = binding.editTextEmail.text.toString(),
            pendidikanAyah = binding.editTextPendidikanAyah.text.toString(),
            pendidikanIbu = binding.editTextPendidikanIbu.text.toString(),
            pekerjaanAyah = binding.editTextPekerjaanAyah.text.toString(),
            pekerjaanIbu = binding.editTextPekerjaanIbu.text.toString(),
        )
        val action =
            ParentDataFragmentDirections.actionParentDataFragmentToSchoolDataFragment(
                personal = args.personal,
                parent = dataParent
            )
        findNavController().navigate(action)
    }

}