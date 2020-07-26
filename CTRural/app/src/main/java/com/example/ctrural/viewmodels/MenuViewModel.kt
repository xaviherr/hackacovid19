package com.example.ctrural.viewmodels

import androidx.lifecycle.ViewModel
import com.example.ctrural.R
import com.example.ctrural.entities.MenuItemEntity

class MenuViewModel: ViewModel() {

    val menuList = listOf(
        MenuItemEntity("Registrar Caso", R.drawable.ic_reg_case),
        MenuItemEntity("Registrar Contacto", R.drawable.ic_reg_contact),
        MenuItemEntity("Seguimiento Caso", R.drawable.ic_seg_case),
        MenuItemEntity("Seguimiento Contacto", R.drawable.ic_seg_contact),
        MenuItemEntity("Solicitar Recursos", R.drawable.ic_req_resources),
        MenuItemEntity("Solicitar asistencia", R.drawable.ic_req_assistance)
    )
}