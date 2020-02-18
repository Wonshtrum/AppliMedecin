package com.example.applimedecin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_annonces.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class AnnoncesActivity : AppCompatActivity() {
    var box = 0

    fun createBox() {
        box++
        val jsonStr = "Annonce ${box}\nDescription de l'annonce ${box}"
        val text_view: TextView = TextView(this)
        val params: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        params.setMargins(10, 10, 10, 10)
        text_view.setBackgroundColor(Color.LTGRAY)
        text_view.layoutParams = params
        text_view.text = jsonStr
        text_view.setPadding(50, 10, 10, 100)
        text_view.setOnClickListener{
            //Toast.makeText(this, text_view.text, Toast.LENGTH_SHORT).show()
        }
        annonceContainer.addView(text_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_annonces)
        buttonProfil.setOnClickListener {
            startActivity(Intent(this@AnnoncesActivity,MainTest::class.java))
        }
        for (i in 1..10) {
            createBox()
        }
        scrollView.viewTreeObserver.addOnScrollChangedListener {
            if (!scrollView.canScrollVertically(1)) {
                println("LOL")
                for (i in 1..5) {
                    createBox()
                }
            }
        }
        buttonAnnoncesRetour.setOnClickListener {
            startActivity(Intent(this@AnnoncesActivity,MainActivity::class.java))
        }
        buttonCreate.setOnClickListener {
//            println("----")
//            DoAsync {
//                println(URL("http://172.17.10.226:8080/test").readText())
//
//            }.execute()
            startActivity(Intent(this@AnnoncesActivity,AnnonceActivity::class.java))
        }
    }

}
