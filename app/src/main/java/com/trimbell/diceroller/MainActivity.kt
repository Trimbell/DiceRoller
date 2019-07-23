package com.trimbell.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        break
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val diceNum1 = Random.nextInt(6) + 1
        val diceNum2 = Random.nextInt(6) + 1

        val drawableResource1 = when (diceNum1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceNum2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        val diceText = findViewById<TextView>(R.id.dice_text)
        val diceImage1: ImageView = findViewById(R.id.dice_image_1)
        val diceImage2: ImageView = findViewById(R.id.dice_image_2)
        diceText.text = getString(R.string.roll_info, diceNum1 + diceNum2)
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
    }
}
