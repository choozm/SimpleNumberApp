package com.example.simplenumberapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe (view: View) {
        var toastText = getTextViewValue().toString()

        toastText = "You press " + toastText + " times"

        val myToast = Toast.makeText(this, toastText, Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe (view: View) {
        val showCountTextView = findViewById<TextView>(R.id.textView)
        var count = getTextViewValue()
        count++

        // Display new value in the text view
        showCountTextView.text = count.toString()
    }

    private fun getTextViewValue (): Int {
        // Get the value of the text view
        val countString = textView.text.toString()

        // Convert value to number and increment it
        val count: Int = Integer.parseInt(countString)

        return count
    }
}
