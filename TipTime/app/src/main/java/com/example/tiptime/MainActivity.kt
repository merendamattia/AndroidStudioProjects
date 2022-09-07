package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    fun calculateTip(){
        // .text prende il valore al suo interno e .toString() lo trasforma in stringa
        val stringInTextField = binding.costOfService.text.toString()
        // Trasformo la stringa in double o null (se la trasformo solo in double
        // e inserisco un valore null l'app crasha.
        val cost = stringInTextField.toDoubleOrNull()

        // Se il costo è null
        if(cost == null) return

        // Seleziona il Radio Button
        val selectedId = binding.tipOptions.checkedRadioButtonId

        // Ottiene la percentuale del tip
        val tipPercentage = when(selectedId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        // Calcola la tip
        var tip = tipPercentage * cost

        // Controlla se è attivo l'arrotondamento al numero intero successivo della tip
        val roundUp = binding.roundUpSwitch.isChecked

        // Calcolo la nuova tip arrotondata, solo se selezionata la spunta
        if(roundUp) tip = kotlin.math.ceil(tip)

        // Trasformo il risultato di tipo Double in formato Currency
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        // Stampa nel textView (id=tipResult) il valore della mancia
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}