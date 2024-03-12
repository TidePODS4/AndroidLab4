package com.example.lab3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieId = intent.getIntExtra("movie_id", -1)
        if (movieId == -1) {
            throw IllegalArgumentException("No 'contactId' parameter passed")
        }

        setContentView(R.layout.movie_info)

        val movie = MovieDatabase.get(movieId)

        val nameTextView = findViewById<TextView>(R.id.movie_name)
        val releaseDateTextView = findViewById<TextView>(R.id.movie_release_date)
        val ratingTextView = findViewById<TextView>(R.id.movie_rating)
        val budgetTextView = findViewById<TextView>(R.id.movie_budget)
        val buttonViewWeb = findViewById<Button>(R.id.button_view_web)

        nameTextView.text = movie!!.name
        releaseDateTextView.text = "Дата выхода: ${movie.releaseDate}"
        ratingTextView.text = "Рейтинг: ${movie.rating}  из 10"
        budgetTextView.text = "Бюджет: ${movie.budget}$"

        buttonViewWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://okko.tv/"))
            startActivity(intent)
        }
    }
}