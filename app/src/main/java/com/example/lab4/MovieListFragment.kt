package com.example.lab4

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieListFragment : Fragment(), MovieAdapter.OnMovieClickListener {
    private var movies = listOf<Movie>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        loadMovies()
        return view
    }

    private fun loadMovies() {
        movies = listOf(
            Movie("Фильм 1", "Описание фильма 1", 2022),
            Movie("Фильм 2", "Описание фильма 2", 2023),
            Movie("Фильм 3", "Описание фильма 3", 2024)
        )
        // Создание адаптера и привязка его к RecyclerView
        adapter = MovieAdapter(movies, this)
        recyclerView.adapter = adapter
    }

    override fun onMovieClick(movie: Movie) {
        val fragment = MovieDetailsFragment.newInstance(movie)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.detail_fragment_container, fragment)
                .commit()
        } else {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_master, fragment)

                .addToBackStack(null)
                .commit()
        }
    }

}