package com.example.ctrural.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ctrural.R
import com.example.ctrural.dialogfragments.RegAntMedDialogFragment
import com.example.ctrural.dialogfragments.RegGenDialogFragment
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_reg_case.view.*

class RegContactFragment: Fragment() {

    private lateinit var regContactView: View
    private lateinit var btnSave: MaterialButton
    private lateinit var btnRegGen: MaterialButton
    private lateinit var btnAntMed: MaterialButton
    private var contactDni: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        regContactView = inflater.inflate(R.layout.fragment_reg_contact, container, false)

        setBtnRegGenListener()
        setBtnAntMedListener()

        return regContactView
    }

    private fun setBtnRegGenListener() {
        btnRegGen = regContactView.btn_gen
        btnRegGen.setOnClickListener{
            val regGenDialogFragment = RegGenDialogFragment.newInstance(contactDni)
            regGenDialogFragment.show(childFragmentManager, "dialog")
        }
    }

    private fun setBtnAntMedListener() {
        btnAntMed = regContactView.btn_am
        btnAntMed.setOnClickListener{
            val regAntMedDialogFragment = RegAntMedDialogFragment.newInstance(contactDni)
            regAntMedDialogFragment.show(childFragmentManager, "dialog")
        }
    }
}