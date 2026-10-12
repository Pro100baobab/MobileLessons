package com.example.scrollviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.scrollviewapp.databinding.ActivityScrollViewAppBinding
import java.math.BigInteger
import com.example.listviewapp.ListViewApp

class ScrollViewApp : AppCompatActivity() {

    private lateinit var binding: ActivityScrollViewAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollViewAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpWrapper()

        binding.intentButton.setOnClickListener {
            val intent: Intent = Intent(this, ListViewApp::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setUpWrapper() {
        val wrapper = binding.wrapper
        var value: BigInteger = BigInteger.valueOf(1)

        for (i in 1..100){
            val view = layoutInflater.inflate(
                R.layout.item, binding.wrapper, false
            )

            val textVew = view.findViewById<TextView>(R.id.textView)
            textVew.setText("$i. $value")

            wrapper.addView(view)

            value = value.multiply(BigInteger.valueOf(2))
        }
    }
}