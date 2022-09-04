package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Questa attività permette di generare un numero da 1 a ${numSides} ogni volta
 * che si clicca il pulsante "Roll". Il risultato viene mostrato a video.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        // Quando viene cliccato il pulsante richiama la funzione rollDice()
        rollButton.setOnClickListener { rollDice() }

        // Lo esegue la prima volta quando l'app viene aperta
        rollDice()
    }

    private fun rollDice() {
        // Crea un nuovo oggetto di 6 facce
        val dice = Dice(6)
        // Estrae un numero
        var diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        // Imposta il valore uscito nella descrizione del content
        diceImage.contentDescription = diceRoll.toString()

        when(diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }

    /**
     * Classe dice che prende come parametro iniziale il numero delle facce
     */
    class Dice(val numSides: Int) {
        // Metodo che restituisce un numero casuale tra 1 e numSides
        fun roll(): Int {
            return (1..numSides).random();
        }
    }
}