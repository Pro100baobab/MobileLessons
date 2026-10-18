package com.example.resultapifragmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textReceived = view.findViewById<TextView>(R.id.textReceived)

        parentFragmentManager.setFragmentResultListener(REQUEST_KEY, viewLifecycleOwner)
        { _, bundle ->
            textReceived.text = bundle.getString(TEXT_KEY).orEmpty()
        }
    }

    companion object {
        const val REQUEST_KEY = "requestKey"
        const val TEXT_KEY = "key"
    }
}
