package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher;
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire.*
import kotlinx.android.synthetic.main.activity_formulaire_autre_a.*

class FormulaireAutreAActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_autre_a)
        val editChamps1=findViewById<EditText>(R.id.editTextMail);
        val editChamps2=findViewById<EditText>(R.id.editTextNumTel);
        val editChamps3=findViewById<EditText>(R.id.editTextAdresse);
        val boutonValider=findViewById<Button>(R.id.boutonSuivantA);


        editChamps1.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (!editChamps1.getText().toString().trim().isEmpty()&&!editChamps2.getText().toString().trim().isEmpty()&&!editChamps3.getText().toString().trim().isEmpty()){
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
                if (!editChamps1.getText().toString().trim().isEmpty()&&!editChamps2.getText().toString().trim().isEmpty()&&!editChamps3.getText().toString().trim().isEmpty()) {
                    boutonValider.setEnabled(true);
                }else{
                    boutonValider.setEnabled(false);
                }
            }
        })

        editChamps3.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (!editChamps1.getText().toString().trim().isEmpty()&&!editChamps2.getText().toString().trim().isEmpty()&&!editChamps3.getText().toString().trim().isEmpty()){
                    boutonValider.setEnabled(true);
                }else{
                    boutonValider.setEnabled(false);
                }
            }
        })

        boutonSuivantA.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreAActivity,FormulaireAutreBActivity::class.java))
        }
    }


}