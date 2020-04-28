package com.example.applimedecin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_annonces.*
import org.json.JSONObject


class AnnoncesActivity : AppCompatActivity() {
    var box = 0
    var bdd = mutableListOf<JSONObject>()

    fun createBox() {
        box++
        val annonce = bdd.removeAt(0)
        val descripton = annonce.getStringD("description", "").split("\n", ignoreCase = true, limit = 0)
        val text_view: TextView = TextView(this)
        val params: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        params.setMargins(10, 10, 10, 10)
        text_view.setBackgroundColor(Color.LTGRAY)
        text_view.layoutParams = params
        text_view.text = descripton[0]
        text_view.setPadding(50, 25, 10, 30)
        text_view.setOnClickListener{
            val intent = Intent(this@AnnoncesActivity,AnnonceView::class.java)
            intent.putExtra("sujet", descripton[0])
            intent.putExtra("description", descripton[1])
            startActivity(intent)
        }
        annonceContainer.addView(text_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_annonces)

        buttonCreate.isEnabled = TicketManager.ticket.type == TypeTicket.CLIENT

        DoAsync {
            val res = RequestCatalog.getAllOffers()
            val list = res.getJSONArray("offres")
            for (i in 0 until list.length()) {
                bdd.add(JSONObject(list.getString(i)))
            }
            println(res)
        }.waitUntil()

        for (i in 1..10) {
            if (bdd.size == 0) break
            createBox()
        }

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            if (!scrollView.canScrollVertically(1)) {
                for (i in 1..5) {
                    if (bdd.size == 0) break
                    createBox()
                }
            }
        }

        buttonProfil.setOnClickListener {
            if (TicketManager.ticket.type == TypeTicket.CLIENT) {
                startActivity(Intent(this@AnnoncesActivity, ProfilClient::class.java))
            } else if (TicketManager.ticket.type == TypeTicket.REMPLACANT) {
                startActivity(Intent(this@AnnoncesActivity, ProfilRemplacant::class.java))
            } else {
                startActivity(Intent(this@AnnoncesActivity, MainActivity::class.java))
            }
        }
        buttonAnnoncesRetour.setOnClickListener {
            TicketManager.disconnect()
            startActivity(Intent(this@AnnoncesActivity, MainActivity::class.java))
        }
        buttonCreate.setOnClickListener {
            startActivity(Intent(this@AnnoncesActivity, FormulaireOffreGeneral::class.java))
        }
    }
}
