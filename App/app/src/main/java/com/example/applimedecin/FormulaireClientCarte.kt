package com.example.applimedecin

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_autre_h.*
import kotlinx.android.synthetic.main.activity_formulaire_client_carte.*

class FormulaireClientCarte: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_client_carte)
        boutonSuivantG.setOnClickListener {
            val data = intent.extras

            if (data != null) {
                val res = DoAsync {
                    RequestCatalog.saveDataClient(
                        "-1",
                        data.getString("tel", ""),
                        data.getString("addresse", ""),
                        data.getString("kmMax", ""),
                        data.getString("mail", ""),
                        data.getString("specialite", ""),
                        data.getString("secretariat", ""),
                        data.getString("dispoSec", ""),
                        data.getString("activite", ""),
                        data.getString("mdp", ""),
                        data.getString("zoneGeo", ""),
                        data.getString("carteProFilename", "")
                    )
                }.waitUntil()
                println(res)
            }
            startActivity(Intent(this@FormulaireClientCarte, MainActivity::class.java))
        }
    }
}