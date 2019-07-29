package com.trimbell.diceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.roll_button)
        val diceText = findViewById<TextView>(R.id.dice_text)
        val diceImage1 = findViewById<ImageView>(R.id.dice_image_1)
        val diceImage2 = findViewById<ImageView>(R.id.dice_image_2)

        rollButton.setOnClickListener {
            var count = 0
            val rolls = 1000
            repeat(rolls) {
                if (rollDie(diceImage1) == rollDie(diceImage2)) count++
            }
            diceText.text = getString(R.string.roll_info, (count / rolls.toFloat() * 100f))
//            diceText.text = "${0= * 100f}"
        }
    }

    private fun rollDie(image: ImageView): Int {
        val diceNum = Random.nextInt(6) + 1

        image.setImageResource(when (diceNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })

        return diceNum
    }
}
