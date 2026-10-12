package com.example.rumirearastopchinlesson9.domain.repository

import com.example.rumirearastopchinlesson9.domain.models.Movie

interface MovieRepository {
    fun saveMovie(movie: Movie): Boolean
    fun getMovie(): Movie
}