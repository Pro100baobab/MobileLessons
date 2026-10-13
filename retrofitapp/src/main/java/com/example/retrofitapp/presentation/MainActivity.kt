package com.example.retrofitapp.presentation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.model.Todo
import com.example.retrofitapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var status: TextView
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        status = binding.textStatus

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TodoAdapter { todo, isChecked ->
            updateTodo(todo, isChecked)
        }
        recyclerView.adapter = adapter

        loadTodos()
    }

    private fun loadTodos() {
        status.text = "Загрузка задач..."

        RetrofitClient.api.getTodos()
            .enqueue(object : Callback<List<Todo>> {

                override fun onResponse(
                    call: Call<List<Todo>>,
                    response: Response<List<Todo>>
                ) {
                    if (response.isSuccessful) {
                        val todos = response.body()

                        if (todos != null) {
                            adapter.setTodos(todos)
                            status.text = "Загружено задач: ${todos.size}"
                        } else {
                            status.text = "Сервер вернул пустой ответ"
                        }
                    } else {
                        status.text =
                            "Ошибка сервера: ${response.code()}"
                    }
                }

                override fun onFailure(
                    call: Call<List<Todo>>,
                    t: Throwable
                ) {
                    Log.e("RetrofitApp", "Ошибка загрузки", t)
                    status.text = "Не удалось загрузить задачи"
                    Toast.makeText(
                        this@MainActivity,
                        t.message ?: "Ошибка сети",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    private fun updateTodo(todo: Todo, isChecked: Boolean) {
        val previousValue = todo.completed
        val updatedTodo = todo.copy(completed = isChecked)

        status.text = "Обновление задачи..."

        RetrofitClient.api.updateTodo(
            updatedTodo.id,
            updatedTodo
        ).enqueue(object : Callback<Todo> {

            override fun onResponse(
                call: Call<Todo>,
                response: Response<Todo>
            ) {
                if (response.isSuccessful) {
                    adapter.updateTodo(updatedTodo)
                    status.text = "Задача обновлена"
                } else {
                    adapter.updateTodo(todo.copy(completed = previousValue))
                    status.text =
                        "Ошибка обновления: ${response.code()}"
                    Toast.makeText(
                        this@MainActivity,
                        "Не удалось обновить задачу",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(
                call: Call<Todo>,
                t: Throwable
            ) {
                Log.e("RetrofitApp", "Ошибка обновления", t)

                adapter.updateTodo(todo.copy(completed = previousValue))
                status.text = "Ошибка сети при обновлении"

                Toast.makeText(
                    this@MainActivity,
                    "Не удалось отправить изменения",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}