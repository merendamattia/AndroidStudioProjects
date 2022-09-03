package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
    }

    private fun rollDice() {
        // Crea un nuovo oggetto di 6 facce
        val dice = Dice(6)
        var diceRoll = dice.roll()

        // Trascrive il risultato su schermo
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        diceRoll = dice.roll()
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll.toString()
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