package com.example.applimedecin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_offre_schedule.*
import android.view.View
import android.widget.CheckBox
import android.widget.Spinner

class FormulaireOffreSchedule: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_offre_schedule)

        fun <type : View?> getResourceByName(name: String): type {
            return findViewById<type>(resources.getIdentifier(name, "id", packageName))
        }

        boutonValider.setOnClickListener {
            var res = "{"
            var first = true
            for (day in arrayOf("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche")) {
                if (getResourceByName<CheckBox>("checkBox"+day).isChecked) {
                    res += (if (first) "" else ",") + day + ":[" +
                            getResourceByName<Spinner>("spinnerHoraires"+day+"1").selectedItemId + "," +
                            getResourceByName<Spinner>("spinnerHoraires"+day+"2").selectedItemId + "]"
                    first = false
                }
            }
            intent.setClass(this@FormulaireOffreSchedule, FormulaireOffreValidate::class.java)
            intent.putExtra("horaire", res)
            startActivity(intent)
        }
    }
}