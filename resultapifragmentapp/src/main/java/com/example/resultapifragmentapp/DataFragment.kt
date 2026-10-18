package com.example.resultapifragmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class DataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.editTextInfo)

        view.findViewById<Button>(R.id.buttonOpenBottomSheet).setOnClickListener {
            val text = editText.text.toString().trim()

            if (text.isEmpty()) {
                Toast.makeText(requireContext(), "Введите сообщение", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val bundle = Bundle().apply { putString(BottomSheetFragment.TEXT_KEY, text) }

            parentFragmentManager.setFragmentResult(BottomSheetFragment.REQUEST_KEY, bundle)

            BottomSheetFragment().show(parentFragmentManager, "ModalBottomSheet")
        }
    }
}
