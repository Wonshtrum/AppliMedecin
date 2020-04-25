package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_remplacant_e.*

class FormulaireRemplacantActivityE : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_remplacant_e)

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
                        data.getString("addresse", ""),
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