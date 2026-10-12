package com.example.rumirearastopchinlesson9.data.repository

import android.content.Context
import com.example.rumirearastopchinlesson9.domain.models.Movie
import com.example.rumirearastopchinlesson9.domain.repository.MovieRepository
import androidx.core.content.edit

private const val PREFS_NAME = "movie_prefs"
private const val KEY_ID = "favorite_movie_id"
private const val KEY_NAME = "favorite_movie_name"

class MovieRepositoryImpl(context: Context): MovieRepository {

    private val prefs = context.applicationContext
        .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveMovie(movie: Movie): Boolean {
        prefs.edit {
            putInt(KEY_ID, movie.id)
                .putString(KEY_NAME, movie.name)
        }
        return true
    }

    override fun getMovie(): Movie {
        val id = prefs.getInt(KEY_ID, 0)
        val name = prefs.getString(KEY_NAME, "") ?: ""
        return Movie(id, name)
    }}