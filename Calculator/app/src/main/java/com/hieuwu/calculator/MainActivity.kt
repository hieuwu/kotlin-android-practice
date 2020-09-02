package com.hieuwu.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        var entryData = editTextNumber.text.toString()
        val selectedButton = view as Button
        if (isNewOp == true) {
            editTextNumber.setText("")
        }
        isNewOp = false
        when (selectedButton.id) {
            btnAC.id -> {
                entryData = "0"
                isNewOp == true
            }
            btnPlusMinus.id -> {
                if (entryData[0] != '-') {
                    entryData = "-" + entryData
                }
            }
            btnPercent.id -> {
                if (entryData.last() != '%') {
                    entryData += "%"
                }
            }
            btn13.id -> {
                entryData += "1"
            }
            btn14.id -> {
                entryData += "2"
            }
            btn15.id -> {
                entryData += "3"
            }
            btn9.id -> {
                entryData += "4"
            }
            btn10.id -> {
                entryData += "5"
            }
            btn11.id -> {
                entryData += "6"
            }
            btn5.id -> {
                entryData += "7"
            }
            btn6.id -> {
                entryData += "8"
            }
            btn7.id -> {
                entryData += "9"

            }
            btn17.id -> {
                entryData += "0"
            }
            btnDot.id -> {
                if (!entryData.contains(".")) {
                    entryData += "."
                }
            }
        }
        editTextNumber.setText(entryData)
    }

    var operation = "*"
    var oldNumber = "0"
    var isNewOp = true

    fun btnOpClick(view: View) {
        val selectedButton = view as Button
        var entryData = editTextNumber.text.toString()
        when (selectedButton.id) {
            btnPlus.id -> {
                operation = "+"
            }

            btnMinus.id -> {
                operation = "-"
            }

            btnDivide.id -> {
                operation = "/"
            }

            btnMultiple.id -> {
                operation = "*"
            }

        }
        oldNumber = editTextNumber.text.toString()
        editTextNumber.setText("")
        textOperation.setText(operation)
        isNewOp = true
    }

    fun btnEqualEvent(view: View) {
        var newNumber = editTextNumber.text.toString()
        var result: Double? = null
        when (operation) {
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()

            }
            "*" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()

            }
            "/" -> {
                result = oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        editTextNumber.setText(result.toString())
        isNewOp = true
    }
}