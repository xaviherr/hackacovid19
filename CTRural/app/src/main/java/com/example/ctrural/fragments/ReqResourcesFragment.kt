package com.example.ctrural.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ctrural.R

class ReqResourcesFragment: Fragment() {

    private lateinit var reqResView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        reqResView = inflater.inflate(R.layout.fragment_req_resources, container, false)

        return reqResView
    }
}