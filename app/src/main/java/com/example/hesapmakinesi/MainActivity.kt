package com.example.hesapmakinesi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var resultText: TextView
    private var currentInput = ""
    private var total = 0
    private var isPlusPressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.textViewResult)

        val numberButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in numberButtons) {
            findViewById<Button>(id).setOnClickListener {
                val number = (it as Button).text.toString()
                currentInput += number
                resultText.text = currentInput
            }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                total += currentInput.toInt()
                currentInput = ""
                resultText.text = "+"
            }
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                total += currentInput.toInt()
                resultText.text = total.toString()
                currentInput = ""
                total = 0
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            total = 0
            resultText.text = "0"
        }

    }
}