package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_offre_validate.*

class FormulaireOffreValidate : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_offre_validate)

        val editChamps1=findViewById<EditText>(R.id.offreSujet)
        val editChamps2=findViewById<EditText>(R.id.offreText)

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

        boutonValider.setOnClickListener {
            intent.setClass(this@FormulaireOffreValidate, AnnoncesActivity::class.java)
            intent.putExtra("description", editChamps1.text.toString()+'\n'+editChamps2.text.toString())

            val data = intent.extras
            if (data != null) {
                DoAsync {
                    RequestCatalog.saveDataOffre(
                        "-1",
                        TicketManager.ticket.id.toString(),
                        "[\""+data.getString("date1","0")+"\",\""+data.getString("date2","0")+"\"]",
                        data.getString("description",""),
                        data.getString("horaire",""),
                        data.getString("logiciel",""),
                        data.getString("remuneration",""),
                        data.getString("typeOffre",""),
                        data.getString("typePatient",""),
                        data.getString("visite","")
                    )
                }.waitUntil()
            }
            startActivity(intent)
        }
    }
}