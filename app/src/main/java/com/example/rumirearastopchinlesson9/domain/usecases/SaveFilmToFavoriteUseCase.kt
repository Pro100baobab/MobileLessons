package com.example.rumirearastopchinlesson9.domain.usecases

import com.example.rumirearastopchinlesson9.domain.models.Movie
import com.example.rumirearastopchinlesson9.domain.repository.MovieRepository

class SaveFilmToFavoriteUseCase(private val repository: MovieRepository) {
    /*fun saveMovieToFavoriteUseCase(movieRepository: MovieRepository){
        this.movieRepository = movieRepository
    }*/
    fun execute(movie: Movie): Boolean = repository.saveMovie(movie)
}