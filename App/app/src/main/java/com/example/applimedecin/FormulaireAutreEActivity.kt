package com.example.applimedecin

import android.os.Bundle
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire.*
import kotlinx.android.synthetic.main.activity_formulaire_autre_d.*
import kotlinx.android.synthetic.main.activity_formulaire_autre_e.*

class FormulaireAutreEActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_autre_e)
        boutonSuivantE.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreEActivity,FormulaireAutreFActivity::class.java))
        }
    }
}