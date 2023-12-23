
package com.example.project1




import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var message: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shareButton = findViewById(R.id.share_button)
        shareButton.setOnClickListener { shareMessage() }
        shareButton.visibility = View.GONE

        message = findViewById(R.id.main_activity_tv_textview)


        updateMessage()
    }

    private fun updateMessage() {
        val motivationalMessages = listOf(
            "All our dreams can come true, if we have the courage to pursue them.",
            "The secret of getting ahead is getting started.",
            "It’s hard to beat a person who never gives up",
            "If people are doubting how far you can go, go so far that you can’t hear them anymore.",
            "Everything you can imagine is real.",
            "Smart people learn from everything and everyone, average people from their experiences, stupid people already have all the answers.",
            "Do what you feel in your heart to be right―for you’ll be criticized anyway.",
            "Happiness is not something ready-made. It comes from your own actions."
        )


        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        val index = dayOfYear % motivationalMessages.size
        val currentMessage = motivationalMessages[index]

        message.text = currentMessage

        shareButton.visibility = View.VISIBLE
    }

    // Function to share the motivational message
    private fun shareMessage() {
        val messageToShare = message.text.toString()
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, messageToShare)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}
