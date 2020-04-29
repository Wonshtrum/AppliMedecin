package com.example.applimedecin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FormulaireClientActivite: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_client_activite)
        val editChamps1 = findViewById<EditText>(R.id.editTextDomaine);
        val boutonValider = findViewById<Button>(R.id.boutonValider);
        val switch1 = findViewById<Switch>(R.id.switchAssociation2);
        val switch2 = findViewById<Switch>(R.id.switchSecrétariat);
        val textSec = findViewById<TextView>(R.id.textSecrétariat);
        val spinnerSec = findViewById<Spinner>(R.id.spinnerSecrétariat);
0
        fun isValid() {
            if (!editChamps1.getText().toString().trim().isEmpty()) {
                boutonValider.setEnabled(true);
            }else{
                boutonValider.setEnabled(false);
            }
        }

        editChamps1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        switch2.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                textSec.setEnabled(true)
                spinnerSec.setEnabled(true)
            }else{
                textSec.setEnabled(false)
                spinnerSec.setEnabled(false)
            }
        }

        boutonValider.setOnClickListener {
            intent.setClass(this@FormulaireClientActivite, FormulaireClientCarte::class.java)
            intent.putExtra("specialite", editChamps1.getText().toString())
            intent.putExtra("activite", if (switch1.isChecked) "1" else "0")
            intent.putExtra("secretariat", if (switch2.isChecked) "1" else "0")
            intent.putExtra("dispoSec", spinnerSec.selectedItemId.toString())
            startActivity(intent)
        }

    }
}