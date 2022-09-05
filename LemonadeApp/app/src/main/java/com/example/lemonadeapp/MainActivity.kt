package com.example.lemonadeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    // Stato attuale limonata
    private var lemonadeState = "LEMONADE_STATE"

    // Stato dei limoni
    private val ALBERO = "ALBERO"       // Da raccogliere
    private val LIMONE = "LIMONE"       // Raccolto da spremere
    private val SPREMUTO = "SPREMUTO"   // Spremuto da bere
    private val BEVUTO = "BEVUTO"       // Bevuto

    // Vari counter
    private var spremutaCount = -1
    private var lemonateCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assegna a imageView l'oggetto immagine
        val imageView : ImageView = findViewById(R.id.imageView)

        lemonadeState = ALBERO

        // Ogni volta che viene cliccata l'immagine viene richiamata questa funzione
        imageView.setOnClickListener {
            clickLemonImage(imageView)
        }
    }

    private fun clickLemonImage(imageView: ImageView){
        // Assegna a textView l'oggetto testo
        val textView : TextView = findViewById(R.id.textView)
        // Assegna a msg l'oggetto messaggio
        val msg : TextView = findViewById(R.id.msg)
        // Assegna a lemonateMsg l'oggetto in basso a destra del display (counter)
        val lemonateMsg : TextView = findViewById(R.id.lemonateCount)

        when(lemonadeState){
            ALBERO -> {
                imageView.setImageResource(R.drawable.lemon)
                textView.text = "Clicca per spremere!"
                lemonadeState = LIMONE
                spremutaCount = (2..4).random();
            }

            LIMONE -> {
                if(spremutaCount == 0){
                    imageView.setImageResource(R.drawable.bicchiere)
                    textView.text = "Clicca per bere!"
                    msg.text = ""
                    lemonadeState = SPREMUTO
                } else {
                    msg.text = "Click rimanenti: ${spremutaCount}"
                    spremutaCount--
                }
            }

            SPREMUTO -> {
                imageView.setImageResource(R.drawable.bicchierevuoto)
                textView.text = "Limonata bevuta!"
                msg.text = "Clicca sull'immagine per raccogliere un altro limone"
                lemonadeState = BEVUTO
            }

            BEVUTO -> {
                imageView.setImageResource(R.drawable.treelemon)
                textView.text = "Clicca per raccogliere un limone!"
                lemonadeState = ALBERO
                msg.text = ""
                lemonateCount++
                lemonateMsg.text = "Limonate bevute: ${lemonateCount}"
            }
        }
    }
}