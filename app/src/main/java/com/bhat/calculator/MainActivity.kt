package com.bhat.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var firstNum: Double = 0.0
    var operation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num0 = findViewById<Button?>(R.id.num0)
        val num1 = findViewById<Button?>(R.id.num1)
        val num2 = findViewById<Button?>(R.id.num2)
        val num3 = findViewById<Button?>(R.id.num3)
        val num4 = findViewById<Button?>(R.id.num4)
        val num5 = findViewById<Button?>(R.id.num5)
        val num6 = findViewById<Button?>(R.id.num6)
        val num7 = findViewById<Button?>(R.id.num7)
        val num8 = findViewById<Button?>(R.id.num8)
        val num9 = findViewById<Button?>(R.id.num9)

        val on = findViewById<Button>(R.id.on)
        val off = findViewById<Button>(R.id.off)
        val ac = findViewById<Button>(R.id.ac)
        val del = findViewById<Button>(R.id.del)
        val div = findViewById<Button?>(R.id.div)
        val times = findViewById<Button?>(R.id.times)
        val min = findViewById<Button?>(R.id.min)
        val plus = findViewById<Button?>(R.id.plus)
        val equal = findViewById<Button>(R.id.equal)
        val point = findViewById<Button>(R.id.point)


        val screen = findViewById<TextView>(R.id.screen)

        ac.setOnClickListener(View.OnClickListener { view: View? ->
            firstNum = 0.0
            screen.setText("0")
        })
        off.setOnClickListener(View.OnClickListener { view: View? -> screen.setVisibility(View.GONE) })
        on.setOnClickListener(View.OnClickListener { view: View? ->
            screen.setVisibility(View.VISIBLE)
            screen.setText("0")
        })

        val nums = ArrayList<Button>()
        nums.add(num0!!)
        nums.add(num1!!)
        nums.add(num2!!)
        nums.add(num3!!)
        nums.add(num4!!)
        nums.add(num5!!)
        nums.add(num6!!)
        nums.add(num7!!)
        nums.add(num8!!)
        nums.add(num9!!)

        for (b in nums) {
            b.setOnClickListener(View.OnClickListener { view: View? ->
                if (screen.getText().toString() != "0") {
                    screen.setText(screen.getText().toString() + b.getText().toString())
                } else {
                    screen.setText(b.getText().toString())
                }
            })
        }

        val opers = ArrayList<Button>()
        opers.add(div!!)
        opers.add(times!!)
        opers.add(plus!!)
        opers.add(min!!)

        for (b in opers) {
            b.setOnClickListener(View.OnClickListener { view: View? ->
                firstNum = screen.getText().toString().toDouble()
                operation = b.getText().toString()
                screen.setText("0")
            })
        }

        del.setOnClickListener(View.OnClickListener { view: View? ->
            val num = screen.getText().toString()
            if (num.length > 1) {
                screen.setText(num.substring(0, num.length - 1))
            } else if (num.length == 1 && num != "0") {
                screen.setText("0")
            }
        })


        point.setOnClickListener(View.OnClickListener { view: View? ->
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".")
            }
        })

        equal.setOnClickListener(View.OnClickListener { view: View? ->
            val secondNum = screen.getText().toString().toDouble()
            var result: Double
            when (operation) {
                "/" -> result = firstNum / secondNum
                "X" -> result = firstNum * secondNum
                "+" -> result = firstNum + secondNum
                "-" -> result = firstNum - secondNum
                else -> result = firstNum + secondNum
            }
            screen.setText(result.toString())
            firstNum = result
        })
    }
}