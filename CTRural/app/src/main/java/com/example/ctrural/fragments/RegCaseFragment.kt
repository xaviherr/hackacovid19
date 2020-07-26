package com.example.ctrural.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ctrural.R
import com.example.ctrural.dialogfragments.RegGenDialogFragment
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_reg_case.view.*

class RegCaseFragment: Fragment() {

    private lateinit var regCaseView: View
    private lateinit var btnSave: MaterialButton
    private lateinit var btnRegGen: MaterialButton
    private lateinit var btnAntMed: MaterialButton
    private var caseDni: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        regCaseView = inflater.inflate(R.layout.fragment_reg_case, container, false)

        setBtnRegGenListener()

        return regCaseView
    }

    private fun setBtnRegGenListener() {
        btnRegGen = regCaseView.btn_gen
        btnRegGen.setOnClickListener{
            val regGenDialogFragment = RegGenDialogFragment.newInstance(caseDni)
            regGenDialogFragment.show(childFragmentManager, "dialog")
        }
    }

}