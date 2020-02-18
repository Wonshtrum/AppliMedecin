package com.example.applimedecin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.test.*

class MainTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        imageButton2.setOnClickListener {
            startActivity(Intent(this@MainTest,AnnoncesActivity::class.java))
        }
    }
}
