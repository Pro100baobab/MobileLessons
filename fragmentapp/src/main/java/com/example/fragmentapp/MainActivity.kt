package com.example.fragmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val studentNumber = 21

            supportFragmentManager
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(
                    R.id.header_container,
                    HeaderFragment.newInstance(studentNumber)
                )
                .add(
                    R.id.tasks_container,
                    TasksFragment()
                )
                .commit()
        }
    }
}