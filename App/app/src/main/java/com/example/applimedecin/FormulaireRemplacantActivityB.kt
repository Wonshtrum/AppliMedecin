package com.example.applimedecin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_remplacant_activite.*

class FormulaireRemplacantActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_remplacant_activite)
        val editChamps1=findViewById<EditText>(R.id.editTextSpecRemp)
        val editChamps2=findViewById<EditText>(R.id.editTextDistRemp)
        val editChamps3=findViewById<EditText>(R.id.editTextDescRemp)
        val boutonValider=findViewById<Button>(R.id.boutonSuivantBRemp)

        fun isValid() {
            if (!editChamps1.getText().toString().trim().isEmpty() &&
                !editChamps2.getText().toString().trim().isEmpty()) {
                boutonValider.setEnabled(true)
            }else{
                boutonValider.setEnabled(false)
            }
        }

        editChamps1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        editChamps2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        boutonSuivantBRemp.setOnClickListener {
            intent.setClass(this@FormulaireRemplacantActivityB, FormulaireRemplacantActivityE::class.java)
            intent.putExtra("specialite", editChamps1.text.toString())
            intent.putExtra("kmMax", editChamps2.text.toString())
            intent.putExtra("description", editChamps3.text.toString())
            startActivity(intent)
        }
    }
}