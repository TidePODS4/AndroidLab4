package com.example.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movies: List<Movie>, private val listener: OnMovieClickListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onMovieClick(movies[position])
            }
        }
    }

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)
    }
}