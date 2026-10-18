package com.example.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HeaderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_header, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentNumber = requireArguments().getInt(ARG_STUDENT_NUMBER)

        view.findViewById<TextView>(R.id.textStudentNumber).text =
            "Номер по списку: $studentNumber"
    }


    companion object {

        private const val ARG_STUDENT_NUMBER = "student_number"

        fun newInstance(studentNumber: Int) =
            HeaderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_STUDENT_NUMBER, studentNumber)
                }
            }
    }
}