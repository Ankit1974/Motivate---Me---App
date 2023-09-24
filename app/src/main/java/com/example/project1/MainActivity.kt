package com.example.project1

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //Declare our references to view before layout inflation
    private lateinit var name: EditText
    private lateinit var message: TextView

    //override lifecylce method onCreate . this should initialize all important item for the code.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate the given layout to turn xml view in kotlin object
        setContentView(R.layout.activity_main)

        // Get a reference to the button view from our layout and set a clickListener
        val updateButton: Button = findViewById(R.id.hjjghuk)
        updateButton.setOnClickListener { updateMessage() }

        // set the value to our declared view
        name = findViewById(R.id.main_activity_et_name)
        message = findViewById(R.id.main_activity_tv_textview)
    }

    // get a name from an editText and display a personalized message
    private fun updateMessage() {
        //Get the username from the editTex
        val username = name.text

        // pick a motivational message
        val motivationalMessages = listOf(
            "All our dreams can come true, if we have the courage to pursue them.",
            "The secret of getting ahead is getting started.",
            "It’s hard to beat a person who never gives up",
            "If people are doubting how far you can go, go so far that you can’t hear them anymore.",
            "Everything you can imagine is real.",
            "Smart people learn from everything and everyone, average people from their experiences, stupid people already have all the answers.",
            "Do what you feel in your heart to be right―for you’ll be criticized anyway.",
            "Happiness is not something ready made. It comes from your own actions."
        )
        val index = (0..7).random()
        val currentMessages = motivationalMessages[index]

        // update the textview to display our message
        if (username.toString() == "") {
            message.text = "Make sure to enter your name"
        } else {
            message.text = "Hello $username. $currentMessages"
        }
        //clear the editText and use setText because editText's require an editable
        name.setText("")
        hidekeyboard()
    }
    // hide keyboard function

    private fun hidekeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken , 0)
    }
}