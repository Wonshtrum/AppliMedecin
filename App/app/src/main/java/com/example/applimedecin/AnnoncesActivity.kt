package com.example.applimedecin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_annonces.*

class AnnoncesActivity : AppCompatActivity() {
    var box = 0
    var bdd = mutableListOf<String>()

    fun createBox() {
        box++
        val jsonStr = if (bdd.isEmpty()) "Annonce ${box}\nDescription de l'annonce ${box}" else bdd.removeAt(0)
        val text_view: TextView = TextView(this)
        val params: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        params.setMargins(10, 10, 10, 10)
        text_view.setBackgroundColor(Color.LTGRAY)
        text_view.layoutParams = params
        text_view.text = jsonStr
        text_view.setPadding(50, 10, 10, 100)
        text_view.setOnClickListener{
            val intent = Intent(this@AnnoncesActivity,AnnonceView::class.java)
            intent.putExtra("sujet", "Generic subject")
            intent.putExtra("description", jsonStr)
            startActivity(intent)
        }
        annonceContainer.addView(text_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_annonces)
        DoAsync {
            val res = RequestCatalog.getAllOffers().toString()
            bdd.addAll(res.split(","))
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
                startActivity(Intent(this@AnnoncesActivity,MainActivity::class.java))
            }
        }
        buttonAnnoncesRetour.setOnClickListener {
            TicketManager.disconnect()
            startActivity(Intent(this@AnnoncesActivity,MainActivity::class.java))
        }
        buttonCreate.setOnClickListener {
            startActivity(Intent(this@AnnoncesActivity,AnnonceActivity::class.java))
        }
    }
}
