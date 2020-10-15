package com.raihan.a09navigation02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.raihan.a09navigation02.databinding.FragmentResultFormBinding

class ResultFormFragment : Fragment() {
    private lateinit var binding: FragmentResultFormBinding
    private val args: ResultFormFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result_form, container, false)
        binding.school = args.school
        binding.parent = args.parent
        binding.personal = args.personal
        return binding.root
    }

}