package com.example.bottomnavigationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.bottomnavigationapp.R

class HomeFragment : Fragment() {

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvCounter = view.findViewById<TextView>(R.id.tvCounter)
        val button = view.findViewById<Button>(R.id.btnIncrement)

        counter = savedInstanceState?.getInt("counter") ?: 0
        tvCounter.text = "Нажатий: $counter"

        button.setOnClickListener {
            counter++
            tvCounter.text = "Нажатий: $counter"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }
}