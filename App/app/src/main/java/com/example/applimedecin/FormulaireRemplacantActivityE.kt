package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_remplacant_carte.*

class FormulaireRemplacantActivityE : AppCompatActivity() {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111 && resultCode == RESULT_OK) {
            val selectedFile = data?.data.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_remplacant_carte)

        boutonCarteRemp.setOnClickListener{
            val intent = Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)
        }

        boutonSuivantERemp.setOnClickListener {
            val data = intent.extras

            if (data != null) {
                val res = DoAsync {
                    RequestCatalog.saveDataRemplacant(
                        "-1",
                        data.getString("carteProFilename", ""),
                        data.getString("cvFilename", ""),
                        data.getString("description", ""),
                        data.getString("kmMax", ""),
                        data.getString("adresse", ""),
                        data.getString("mail", ""),
                        data.getString("tel", ""),
                        data.getString("specialite", ""),
                        data.getString("mdp", ""),
                        data.getString("zoneGeo", "")
                    )
                }.waitUntil()
                println(res)
            }
            startActivity(Intent(this@FormulaireRemplacantActivityE,MainActivity::class.java))
        }
    }

}