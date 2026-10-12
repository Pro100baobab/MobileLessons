package com.example.rumirearastopchinlesson9.domain.usecases

import com.example.rumirearastopchinlesson9.domain.models.Movie
import com.example.rumirearastopchinlesson9.domain.repository.MovieRepository

class GetFavoriteFilmUseCase(private var movieRepository: MovieRepository) {
    /*fun getFavoriteFilmUseCase(movieRepository: MovieRepository){
        this.movieRepository = movieRepository
    }*/
    fun execute(): Movie = movieRepository.getMovie()
}