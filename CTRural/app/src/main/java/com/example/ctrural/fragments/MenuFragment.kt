package com.example.ctrural.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ctrural.R
import com.example.ctrural.adapters.MenuListAdapter
import com.example.ctrural.viewmodels.MenuViewModel
import kotlinx.android.synthetic.main.fragment_menu.view.*


class MenuFragment : Fragment(), MenuListAdapter.OnItemClickListener {

    private lateinit var menuViewModel: MenuViewModel
    private lateinit var menuView: View
    private lateinit var rvMenu: RecyclerView
    private lateinit var rvManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        menuView = inflater.inflate(R.layout.fragment_menu, container, false)
        menuViewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)

        initAdapter()

        return menuView
    }

    private fun initAdapter(){
        rvMenu = menuView.rv_menu
        rvManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvMenu.adapter = MenuListAdapter(menuViewModel.menuList, this.activity, this)
        rvMenu.layoutManager = rvManager
        rvMenu.itemAnimator = DefaultItemAnimator()
    }

    override fun onClick(position: Int, view: View) {
        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToRegCaseFragment())
    }
}