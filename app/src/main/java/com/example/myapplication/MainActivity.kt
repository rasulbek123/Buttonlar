package com.example.myapplication

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.weightSum = 3f
        setContentView(layout)
        val layoutLP = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        val layout1 = LinearLayout(this)
        layout1.orientation = LinearLayout.HORIZONTAL
        layout1.weightSum = 3f
        val buttonLP = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,1f)
        val buttonStart = Button(this)
        val buttonCenter = Button(this)
        val buttonEnd = Button(this)
        buttonStart.text = "Start"
        buttonCenter.text = "Center"
        buttonEnd.text = "End"
        buttonStart.layoutParams = buttonLP
        buttonCenter.layoutParams = buttonLP
        buttonEnd.layoutParams = buttonLP
        layout1.addView(buttonStart)
        layout1.addView(buttonCenter)
        layout1.addView(buttonEnd)
        layout.addView(layout1)
        val layout2 = LinearLayout(this)
        layout2.weightSum = 1f
        val buttonClear = Button(this)
        buttonClear.text = "Clear"
        buttonClear.layoutParams = buttonLP
        layout2.addView(buttonClear)
        layout.addView(layout2)
        val scrollView = ScrollView(this)
        scrollView.layoutParams = layoutLP
        val layout3 = LinearLayout(this)
        layout3.orientation = LinearLayout.VERTICAL
        val buttonLP2 = LinearLayout.LayoutParams(toInt(120),toInt(40))
        buttonStart.setOnClickListener {
            val button = Button(this)
            buttonLP2.gravity = Gravity.START
            button.layoutParams = buttonLP2
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            layout3.addView(button)
        }
        buttonCenter.setOnClickListener {
            val button = Button(this)
            buttonLP2.gravity =Gravity.CENTER
            button.layoutParams = buttonLP2
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            layout3.addView(button)
        }
        buttonEnd.setOnClickListener {
            val button = Button(this)
            buttonLP2.gravity = Gravity.END
            button.layoutParams = buttonLP2
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            layout3.addView(button)
        }
        buttonClear.setOnClickListener {
            layout3.removeAllViews()
        }
        scrollView.addView(layout3)
        layout.addView(scrollView)
    }
    fun toInt(param:Int):Int{
        return (param*Resources.getSystem().displayMetrics.density+0.5f).toInt()
    }
}