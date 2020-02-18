package com.example.applimedecin

import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_autre_h.*

class FormulaireAutreHActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_autre_h)
        val editChamps2 = findViewById<View>(R.id.spinnerSecrétariat);
        val editSwitch = findViewById<Switch>(R.id.switchSecrétariat);
        boutonSuivantH.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreHActivity, MainActivity::class.java))
        }
    }
}