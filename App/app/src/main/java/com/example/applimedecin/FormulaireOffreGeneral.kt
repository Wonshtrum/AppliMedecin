package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_offre_general.*

class FormulaireOffreGeneral : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_offre_general)

        val editChamps1=findViewById<EditText>(R.id.offreRemuneration)

        fun isValid() {
            if (!editChamps1.getText().toString().trim().isEmpty()) {
                boutonValider.setEnabled(true)
            }else{
                boutonValider.setEnabled(false)
            }
        }

        offreVisite.setOnClickListener {
            offreRayon.isEnabled = offreVisite.isEnabled
            offreTextRayon.isEnabled = offreVisite.isEnabled
        }

        editChamps1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        boutonValider.setOnClickListener {
            val intent = Intent(this@FormulaireOffreGeneral, FormulaireOffreStart::class.java)
            intent.putExtra("typeOffre", offreType.selectedItemId.toString())
            intent.putExtra("typePatient", offrePatient.selectedItemId.toString())
            intent.putExtra("visite", if (offreVisite.isChecked) offreRayon.text.toString() else "0")
            intent.putExtra("remuneration", offreRemuneration.text.toString())
            intent.putExtra("logiciel", offreLogiciel.text.toString())
            startActivity(intent)
        }
    }
}