package com.hieuwu.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     fun btnClick(view: View) {
        val selectedButton = view as Button
        var cellID = 0
        when (selectedButton.id) {
            R.id.button -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }
        playGame(cellID, selectedButton)
     }
    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivePlayer = 1
    fun playGame(cellId: Int, selectedButton: Button) {
        if (ActivePlayer == 1) {
            selectedButton.text = "X"
            selectedButton.setBackgroundColor(Color.GREEN)
            Player1.add(cellId)
            ActivePlayer = 2
        } else {
            selectedButton.text = "O"
            selectedButton.setBackgroundColor(Color.BLUE)
            Player2.add(cellId)
            ActivePlayer = 1
        }
        selectedButton.isEnabled = false
        checkWinner()
    }
    fun checkWinner () {
        var winner = -1
        //Check for row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2
        }

        //Check for row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2
        }

        //Check for row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2
        }

        //Check for col 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2
        }

        //Check for row 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2
        }

        //Check for col
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2
        }
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this,"Player 1 win",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Player 2 win",Toast.LENGTH_LONG).show()
            }
        }
    }
}
