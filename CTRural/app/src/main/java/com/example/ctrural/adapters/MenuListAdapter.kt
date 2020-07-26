package com.example.ctrural.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ctrural.R
import com.example.ctrural.entities.MenuItemEntity
import kotlinx.android.synthetic.main.item_list_menu.view.*


class MenuListAdapter(
    private val menuList: List<MenuItemEntity>,
    private val context: Context?,
    private val listener: OnItemClickListener
):RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onClick(position: Int, view: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_list_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = menuList[position]
        holder.bind(item, position, listener)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    inner class ViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        fun bind(item: MenuItemEntity, position: Int, listener: OnItemClickListener) = with(itemView){
            val menuItemName = itemView.tv_menu_item
            val menuItemIcon = itemView.iv_menu_item
            menuItemName.text = item.menuItemName
            menuItemIcon.setImageResource(item.menuItemIcon)
            menuItemName.setOnClickListener{listener.onClick(position, itemView)}
            menuItemIcon.setOnClickListener{listener.onClick(position, itemView)}
        }

    }
}