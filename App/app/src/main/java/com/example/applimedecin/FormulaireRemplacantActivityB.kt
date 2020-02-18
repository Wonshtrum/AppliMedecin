package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_remplacant_b.*

class FormulaireRemplacantActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_remplacant_b)
        boutonSuivantBRemp.setOnClickListener {

            startActivity(Intent(this@FormulaireRemplacantActivityB,FormulaireRemplacantActivityC::class.java))
        }
        val editChamps1=findViewById<EditText>(R.id.editTextSpecRemp);
        val editChamps2=findViewById<EditText>(R.id.editTextDistRemp);
        val boutonValider=findViewById<Button>(R.id.boutonSuivantBRemp);


        editChamps1.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (!editChamps1.getText().toString().trim().isEmpty()&&!editChamps2.getText().toString().trim().isEmpty()){
                    boutonValider.setEnabled(true);
                }else{
                    boutonValider.setEnabled(false);
                }
            }
        })

        editChamps2.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (!editChamps1.getText().toString().trim().isEmpty()&&!editChamps2.getText().toString().trim().isEmpty()) {
                    boutonValider.setEnabled(true);
                }else{
                    boutonValider.setEnabled(false);
                }
            }
        })

    }

}