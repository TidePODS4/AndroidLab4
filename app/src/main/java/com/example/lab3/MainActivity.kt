package com.example.lab3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val list: RecyclerView = findViewById(R.id.list)
        val adapter = MoviesAdapter(movies(), this::onMovieItemClicked)
        list.adapter = adapter
    }

    private fun onMovieItemClicked(item: MovieItem) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movie_id", item.id)
        startActivity(intent)
    }
}