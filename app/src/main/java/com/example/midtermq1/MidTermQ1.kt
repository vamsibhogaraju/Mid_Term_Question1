package com.example.midtermq1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)

        val addButton: Button = findViewById(R.id.btAdd)
        val subtractButton: Button = findViewById(R.id.btSubtract)
        val multiplyButton: Button = findViewById(R.id.btMultiply)
        val divideButton: Button = findViewById(R.id.btDivide)

        addButton.setOnClickListener {
            performOperation(edtxt1.text.toString(), edtxt2.text.toString(), "add", resultTV)
        }

        subtractButton.setOnClickListener {
            performOperation(edtxt1.text.toString(), edtxt2.text.toString(), "subtract", resultTV)
        }

        multiplyButton.setOnClickListener {
            performOperation(edtxt1.text.toString(), edtxt2.text.toString(), "multiply", resultTV)
        }

        divideButton.setOnClickListener {
            performOperation(edtxt1.text.toString(), edtxt2.text.toString(), "divide", resultTV)
        }
    }

    private fun performOperation(a: String, b: String, operation: String, resultTV: TextView) {
        if (validateInput(a, b)) {
            val x = a.toInt()
            val y = b.toInt()
            val result = when (operation) {
                "add" -> sum(x, y)
                "subtract" -> subtract(x, y)
                "multiply" -> multiply(x, y)
                "divide" -> {
                    if (y != 0) divide(x, y)
                    else null
                }
                else -> 0
            }
            resultTV.text = result?.toString() ?: "Cannot divide by zero"
        } else {
            resultTV.text = "Invalid input"
        }
    }

    private fun validateInput(a: String, b: String): Boolean {
        return a.isNotEmpty() && b.isNotEmpty() && a.toIntOrNull() != null && b.toIntOrNull() != null
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    private fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    private fun divide(a: Int, b: Int): Int {
        return a / b
    }
}
