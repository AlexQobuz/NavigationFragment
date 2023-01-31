package com.example.navigationfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ConexionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion)


        // Au clique sur le bouton reset
        // je veux supprimer le texte des champs
        val clearBtn = findViewById<Button>(R.id.reset_button)
        val nameInput = findViewById<TextView>(R.id.name)
        val passwordInput = findViewById<TextView>(R.id.password)
        clearBtn.setOnClickListener{
            nameInput.text = ""
            passwordInput.text = ""
        }

        // je récupère le bouton et au clique
        // je suis rediriger vers la MainActivity
        val conexionBtn = findViewById<Button>(R.id.conexion_button)

        conexionBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Toast.makeText(parent, "$nameInput", Toast.LENGTH_LONG).show()
            startActivity(intent)
        }
    }

}