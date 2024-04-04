package com.example.lab4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MovieDetailsFragment : Fragment() {
    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getSerializable(ARG_MOVIE) as Movie?
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val yearTextView = view.findViewById<TextView>(R.id.yearTextView)
        movie?.let {
            titleTextView.text = it.title
            descriptionTextView.text = it.description
            yearTextView.text = it.year.toString()
        }
        return view
    }

    companion object {
        private const val ARG_MOVIE = "movie"
        fun newInstance(movie: Movie): MovieDetailsFragment {
            val fragment = MovieDetailsFragment()
            val args = Bundle()
            args.putSerializable(ARG_MOVIE, movie)
            fragment.arguments = args
            return fragment
        }
    }
}
