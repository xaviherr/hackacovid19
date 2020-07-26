package com.example.ctrural.dialogfragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ctrural.R

class RegAntMedDialogFragment: DialogFragment() {

    private var caseDni: Int? = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.dialog_fragment_reg_ant_med, null)
            caseDni = arguments?.getInt("caseDni")

            builder.setTitle("Antecedentes Médicos")
            builder.setView(view)
            builder.setPositiveButton("Aceptar", null)
            builder.setNegativeButton("Cancelar", null)
            builder.create()

        }?: throw IllegalStateException("Activity can't be null")
    }

    companion object{
        fun newInstance(caseDni: Int): RegAntMedDialogFragment{
            val regGenDialogFragment = RegAntMedDialogFragment()
            val args = Bundle()
            args.putInt("caseDni", caseDni)
            regGenDialogFragment.arguments = args
            return regGenDialogFragment
        }
    }
}