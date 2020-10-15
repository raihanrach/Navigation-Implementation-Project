package com.example.databinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_menu.view.*

class menu : Fragment() {

    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_menu, container, false)

        view.btnMenu.setOnClickListener {
            bundle = bundleOf("toAbout" to "toDetail")
            view.findNavController().navigate(R.id.action_menu2_to_detail, bundle)
        }

        view.btnAbout.setOnClickListener {
            bundle = bundleOf("toAbout" to "toDetail")
            view.findNavController().navigate(R.id.action_menu2_to_about, bundle)
        }

        return inflater.inflate(R.layout.fragment_menu, container, false)
    }



}