package com.example.applimedecin

import android.text.Editable
import android.widget.TextView

class Annonce {
    private var sujet: Editable? = null
    private var contenu: Editable? = null
    class Annonce constructor(val sujet: Editable, val contenu: Editable)
}