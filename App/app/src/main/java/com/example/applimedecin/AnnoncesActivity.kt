package com.example.applimedecin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import io.github.rybalkinsd.kohttp.dsl.httpGet
import kotlinx.android.synthetic.main.activity_annonces.*
import okhttp3.Response
import org.json.JSONObject
import java.net.URL

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
            val res = RequestCatalog.getAllOffers()
            bdd.addAll(res.split(","))
        }.execute()

        while(bdd.size == 0) {
            Thread.sleep(100)
        }
        for (i in 1..10) {
            createBox()
            if (bdd.size == 0) break
        }

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            if (!scrollView.canScrollVertically(1)) {
                for (i in 1..5) {
                    createBox()
                }
            }
        }

        buttonProfil.setOnClickListener {
            startActivity(Intent(this@AnnoncesActivity,Profil::class.java))
        }
        buttonAnnoncesRetour.setOnClickListener {
            startActivity(Intent(this@AnnoncesActivity,MainActivity::class.java))
        }
        buttonCreate.setOnClickListener {
            startActivity(Intent(this@AnnoncesActivity,AnnonceActivity::class.java))
        }
    }
}
