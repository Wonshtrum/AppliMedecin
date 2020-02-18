package com.example.applimedecin

import android.os.Bundle
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_autre_f.*

class FormulaireAutreFActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_autre_f)
        val editChamps1 = findViewById<View>(R.id.spinnerSecrétariat);
        val editChamps2 = findViewById<EditText>(R.id.editTextRémunération);
        val editChamps3 = findViewById<EditText>(R.id.editTextDomaine);
        val boutonValider=findViewById<Button>(R.id.boutonSuivantF)
        editChamps1.setEnabled(false)
        val editSwitch = findViewById<Switch>(R.id.switchSecrétariat);

        boutonSuivantF.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreFActivity,FormulaireAutreGActivity::class.java))
        }
        editChamps2.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (!editChamps2.getText().toString().trim().isEmpty()&&!editChamps3.getText().toString().trim().isEmpty()){
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
                if (!editChamps2.getText().toString().trim().isEmpty()&&!editChamps3.getText().toString().trim().isEmpty()){
                    boutonValider.setEnabled(true);
                }else{
                    boutonValider.setEnabled(false);
                }
            }
        })
        editSwitch.setOnCheckedChangeListener{ buttonView, isChecked ->
            println(isChecked)
            if (isChecked) {
                editChamps1.setEnabled(true)
            }else{
                editChamps1.setEnabled(false)
            }
        }
    }
}