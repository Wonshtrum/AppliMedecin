package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher;
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_client_general.*

class FormulaireClientGeneral : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_client_general)
        val editChamps1=findViewById<EditText>(R.id.editTextMail);
        val editChamps2=findViewById<EditText>(R.id.editTextMDP);
        val editChamps3=findViewById<EditText>(R.id.editTextNumTel);
        val editChamps4=findViewById<EditText>(R.id.editTextAdresse);
        val editChamps5=findViewById<EditText>(R.id.editTextKMMax);
        val boutonValider=findViewById<Button>(R.id.boutonSuivantA);

        fun isValid() {
            if (!editChamps1.getText().toString().trim().isEmpty() && !editChamps2.getText().toString().trim().isEmpty() &&
                !editChamps3.getText().toString().trim().isEmpty() && !editChamps4.getText().toString().trim().isEmpty() &&
                !editChamps5.getText().toString().trim().isEmpty()) {
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

        editChamps2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        editChamps3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        editChamps4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        editChamps5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {isValid()}
        })

        boutonSuivantA.setOnClickListener {
            val intent = Intent(this@FormulaireClientGeneral,FormulaireClientActivite::class.java)
            intent.putExtra("mail", editChamps1.text.toString())
            intent.putExtra("mdp", editChamps2.text.toString())
            intent.putExtra("tel", editChamps3.text.toString())
            intent.putExtra("adresse", editChamps4.text.toString())
            intent.putExtra("kmMax", editChamps5.text.toString())
            startActivity(intent)
        }
    }


}