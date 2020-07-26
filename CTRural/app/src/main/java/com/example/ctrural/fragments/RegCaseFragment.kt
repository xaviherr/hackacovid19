package com.example.ctrural.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ctrural.R

class RegCaseFragment: Fragment() {

    private lateinit var regCaseView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        regCaseView = inflater.inflate(R.layout.fragment_reg_case, container, false)

        return regCaseView
    }
}