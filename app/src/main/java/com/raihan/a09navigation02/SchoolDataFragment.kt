package com.raihan.a09navigation02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.raihan.a09navigation02.databinding.FragmentSchoolDataBinding
import com.raihan.a09navigation02.models.SchoolData

class SchoolDataFragment : Fragment() {
    private lateinit var binding: FragmentSchoolDataBinding
    private val args: SchoolDataFragmentArgs by navArgs()

    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_school_data, container, false)

        setUp()
        loadDataSpinner()

        binding.btnGoToResult.setOnClickListener {
            intentToResult()
        }

        return binding.root
    }

    private fun setUp() {
        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterProvinsi = ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota = ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataKota)
        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerProvinsiUnivAsal.adapter = adapterProvinsi
        binding.spinnerKotaUnivAsal.adapter = adapterKota
    }

    private fun intentToResult() {
        val dataSchool = SchoolData(
            namaUnivAsal = binding.editTextUnivAsal.text.toString(),
            namaFakultasAsal = binding.editTextFakultasAsal.text.toString(),
            namaProdiAsal = binding.editTextProdiAsal.text.toString(),
            provinsiUnivAsal = binding.spinnerProvinsiUnivAsal.selectedItem.toString(),
            kotaUnivAsal = binding.spinnerKotaUnivAsal.selectedItem.toString(),
            alamatUnivAsal = binding.editTextAlamatUnivAsal.text.toString(),
            kodePosUnivAsal = binding.editTextKodePos.text.toString(),
            akreditasiUnivAsal = binding.editTextAkreditasiUnivAsal.text.toString(),
            nilaiIPK = binding.editTextNilaiIPK.text.toString(),
        )
        val action =
            SchoolDataFragmentDirections.actionSchoolDataFragmentToResultFormFragment(
                personal = args.personal,
                parent = args.parent,
                school = dataSchool
            )
        findNavController().navigate(action)
    }

}