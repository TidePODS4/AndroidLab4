package com.example.lab3

import java.time.LocalDate
import java.util.Random


data class MovieItem(val id: Int, val name: String, val rating: Int, val releaseDate: LocalDate,
    val budget: Int)

class MovieDatabase {
    companion object {
        private val movieItems: MutableList<MovieItem> = mutableListOf()

        fun add(movie: MovieItem) {
            movieItems.add(movie)
        }

        fun get(id: Int): MovieItem? {
            return movieItems.find { it.id == id }
        }
    }
}

val random : Random = Random()

fun movies(): List<MovieItem> {
    val movieItems = MutableList(20) { index ->
        val movie = MovieItem(
            id = index,
            name = "Фильм $index",
            rating = Random().nextInt(11),
            releaseDate = generateRandomDate(Random().nextInt(30)),
            budget = random.nextInt(1000000000)
        )
        MovieDatabase.add(movie)
        movie
    }
    return movieItems
}

fun generateRandomDate(yearDiff : Int): LocalDate {
    val endYear = LocalDate.now().year
    val startYear = endYear - yearDiff
    val year = random.nextInt(endYear - startYear + 1) + startYear
    val month = random.nextInt(12) + 1
    val day = random.nextInt(28) + 1
    return LocalDate.of(year, month, day)
}