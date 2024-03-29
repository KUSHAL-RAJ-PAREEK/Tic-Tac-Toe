package com.krp.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    val btn1 = this.findViewById<Button>(R.id.btn1)
    val btn2 = this.findViewById<Button>(R.id.btn2)
    val btn3 = this.findViewById<Button>(R.id.btn3)
    val btn4 = this.findViewById<Button>(R.id.btn4)
    val btn5 = this.findViewById<Button>(R.id.btn5)
    val btn6 = this.findViewById<Button>(R.id.btn6)
    val btn7 = this.findViewById<Button>(R.id.btn7)
    val btn8 = this.findViewById<Button>(R.id.btn8)
    val btn9 = this.findViewById<Button>(R.id.btn9)
    var flag = 0
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }




        fun check(view: View) {

            val btnCurrent = view as Button

            if (btnCurrent.text == "") {
                count++

//            if(count % 2 == 1){
//                btnCurrent.text = "X"
//            }else{
//                btnCurrent.text = "O"
//            }

                if (flag == 0) {
                    btnCurrent.text = "X"
                    flag = 1
                } else {
                    btnCurrent.text = "O"
                    flag = 0
                }
                if (count > 4) {

                    when {
                        checkCond(btn1, btn2, btn3) -> {
                            showMsg("Winner is ${btn1.getStr()}")
                            restartGame()
                        }

                        checkCond(btn4, btn5, btn6) -> {
                            showMsg("Winner is ${btn4.getStr()}")
                            restartGame()
                        }

                        checkCond(btn7, btn8, btn9) -> {
                            showMsg("Winner is ${btn7.getStr()}")
                            restartGame()
                        }

                        checkCond(btn1, btn4, btn7) -> {
                            showMsg("Winner is ${btn1.getStr()}")
                            restartGame()
                        }

                        checkCond(btn2, btn5, btn8) -> {
                            showMsg("Winner is ${btn2.getStr()}")
                            restartGame()
                        }

                        checkCond(btn3, btn6, btn9) -> {
                            showMsg("Winner is ${btn3.getStr()}")
                            restartGame()
                        }

                        checkCond(btn1, btn5, btn9) -> {
                            showMsg("Winner is ${btn1.getStr()}")
                            restartGame()
                        }

                        checkCond(btn3, btn5, btn7) -> {
                            showMsg("Winner is ${btn3.getStr()}")
                            restartGame()
                        }

                        count == 9 -> {
                            showMsg("Match is Drawn")
                            restartGame()
                        }
                    }
                }


            }

    }
    fun Button.getStr() = this.text.toString()

    val checkCond: (Button, Button, Button) -> Boolean = { a, b, c ->
        a.getStr() == b.getStr()
                && b.getStr() == c.getStr()
                && c.getStr() != ""
    }
    val showMsg = { msg: String ->
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
    fun restartGame(){
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""
        flag = 0
        count = 0
    }
}



