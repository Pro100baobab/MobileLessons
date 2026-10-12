package com.example.rumirearastopchinlesson9.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rumirearastopchinlesson9.data.repository.MovieRepositoryImpl
import com.example.rumirearastopchinlesson9.databinding.ActivityMainBinding
import com.example.rumirearastopchinlesson9.domain.models.Movie
import com.example.rumirearastopchinlesson9.domain.repository.MovieRepository
import com.example.rumirearastopchinlesson9.domain.usecases.GetFavoriteFilmUseCase
import com.example.rumirearastopchinlesson9.domain.usecases.SaveFilmToFavoriteUseCase


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val movieRepository: MovieRepository by lazy {
        MovieRepositoryImpl(applicationContext)
    }

    private val saveFavoriteUseCase by lazy { SaveFilmToFavoriteUseCase(movieRepository) }
    private val getFavoriteUseCase by lazy { GetFavoriteFilmUseCase(movieRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpOnClickListeners()
    }

    private fun setUpOnClickListeners() {
        binding.buttonSaveMovie.setOnClickListener {
            val movie = Movie(2, binding.editTextMovie.text.toString())
            val result = saveFavoriteUseCase.execute(movie)
            binding.textViewMovie.text = "Save result $result"
        }

        binding.buttonGetMovie.setOnClickListener {
            val movie: Movie = getFavoriteUseCase.execute()
            binding.textViewMovie.text = "Save result ${movie.name}"
        }
    }
}