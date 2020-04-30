package com.example.applimedecin

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_annonces.*
import org.json.JSONArray
import org.json.JSONObject


class AnnoncesActivity : AppCompatActivity() {
    var box = 0
    var bdd = mutableListOf<JSONObject>()

    fun createAnnonceComplement(annonce: JSONObject): String {
        val typeOffre = annonce.getInt("typeOffre")
        val visite = annonce.getInt("visiteDomicile")
        val horaire = JSONObject(annonce.getStringD("horaire"))
        val logiciel = annonce.getStringD("logicielUtilise")
        val remuneration = annonce.getStringD("retrocession")
        val typePatient = annonce.getInt("typePatient")
        val periode = JSONArray(annonce.getStringD("periode"))
        val start = periode.getString(0)
        val end = periode.getString(1)
        return "Offre : "+ arrayOf("Remplacement", "Succession", "Collaboration", "Installation")[typeOffre] +
                "\nPeriode : du $start au $end" +
                "\nPatientèle : "+ arrayOf("Non renseigné", "Personnes agées", "Enfants")[typePatient] +
                (if (logiciel.trim().isEmpty()) "" else "\nLogiciel(s) : $logiciel") +
                (if (visite > 0) "\nVisite à domicile dans un rayon de $visite km" else "") +
                "\nRemuneration : $remuneration€"
    }

    fun createBox() {
        box++
        val annonce = bdd.removeAt(0)
        val descripton = annonce.getStringD("description", "").split("\n", ignoreCase = true, limit = 0)


        val paramsBase: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        paramsBase.setMargins(10, 10, 10, 0)
        val params: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        params.setMargins(10, 10, 10, 10)

        val card = CardView(this)
        card.setBackgroundColor(Color.WHITE)
        card.layoutParams = paramsBase
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        card.addView(layout)

        val s_view = TextView(this)
        s_view.layoutParams = params
        s_view.text = descripton[0]
        s_view.typeface = Typeface.DEFAULT_BOLD
        layout.addView(s_view)
        val d_view = TextView(this)
        d_view.layoutParams = params
        d_view.text = descripton[1]
        layout.addView(d_view)

        card.setOnClickListener{
            val intent = Intent(this@AnnoncesActivity,AnnonceView::class.java)
            intent.putExtra("sujet", descripton[0])
            intent.putExtra("description", descripton[1])
            intent.putExtra("complement", createAnnonceComplement(annonce))
            intent.putExtra("auteur", annonce.getLong("idClient").toString())
            intent.putExtra("idOffre", annonce.getLong("idOffre").toString())
            startActivity(intent)
        }

        annonceContainer.addView(card)
    }

    fun initView(mod: Int) {
        bdd.removeAll { true }
        DoAsync {
            val res =
                if (mod == 1) RequestCatalog.requeteOffreLiee(TicketManager.ticket.id.toString(), TicketManager.ticket.type)
                else RequestCatalog.getAllOffers()
            val list = res.getJSONArray("offres")
            for (i in 0 until list.length()) {
                bdd.add(JSONObject(list.getString(i)))
            }
        }.waitUntil()
        annonceContainer.removeAllViews()
        for (i in 1..10) {
            if (bdd.size == 0) break
            createBox()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_annonces)

        if (TicketManager.ticket.type != TypeTicket.CLIENT) {
            buttonCreate.isEnabled = false
        }

        var mod = 0
        initView(mod)

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            if (!scrollView.canScrollVertically(1)) {
                for (i in 1..5) {
                    if (bdd.size == 0) break
                    createBox()
                }
            }
        }

        myAnnonces.setOnClickListener {
            mod = 1-mod
            if (mod == 0) {
                myAnnonces.text = "Mes annonces"
            } else {
                myAnnonces.text = "Toutes les annonces"
            }
            initView(mod)
        }

        buttonProfil.setOnClickListener {
            if (TicketManager.ticket.type == TypeTicket.CLIENT) {
                intent.setClass(this@AnnoncesActivity, ProfilClient::class.java)
                startActivity(intent)
            } else if (TicketManager.ticket.type == TypeTicket.REMPLACANT) {
                intent.setClass(this@AnnoncesActivity, ProfilRemplacant::class.java)
                startActivity(intent)
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
