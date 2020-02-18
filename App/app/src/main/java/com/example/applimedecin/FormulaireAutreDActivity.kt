package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire.*
import kotlinx.android.synthetic.main.activity_formulaire_autre_c.*
import kotlinx.android.synthetic.main.activity_formulaire_autre_d.*

class FormulaireAutreDActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_autre_d)
        boutonSuivantD.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreDActivity,FormulaireAutreEActivity::class.java))
        }
        val editChamps1 = findViewById<EditText>(R.id.editTextKMMax);
        val editChamps2 = findViewById<EditText>(R.id.editTextRayonVisite);
        val editSwitch = findViewById<Switch>(R.id.switchVisite);
        val boutonValider = findViewById<Button>(R.id.boutonSuivantD);

        editSwitch.setOnCheckedChangeListener{ buttonView, isChecked ->
            println(isChecked)
            if (isChecked) {
                editChamps2.setEnabled(true)
            }else{
                editChamps2.setEnabled(false)
                editChamps2.setText("0");
            }
        }

        editChamps1.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (!editChamps1.getText().toString().trim().isEmpty()) {
                    boutonValider.setEnabled(true);
                }else{
                    boutonValider.setEnabled(false);
                }
            }
        })
    }
}