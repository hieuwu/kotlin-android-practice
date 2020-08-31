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
        when (selectedButton.id) {
            btnAC.id -> {
                entryData = "0"
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
            btnDivide.id -> {
                if (entryData.last() != '/') {
                    entryData += "/"
                }
            }
            btnMultiple.id -> {
                if (entryData.last() != 'x') {
                    entryData += "x"
                }
            }
            btnMinus.id -> {
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
            btnPlus.id -> {
                if (entryData.last() != '+') {
                    entryData += "+"
                }
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
}