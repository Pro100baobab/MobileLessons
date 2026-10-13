package com.example.retrofitapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.model.Todo
import com.squareup.picasso.Picasso

class TodoAdapter(
    private val onCompletedChanged: (Todo, Boolean) -> Unit
): RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    class TodoHolder(view: View): RecyclerView.ViewHolder(view) {
        val todoTitle: TextView = view.findViewById(R.id.textViewTitle)
        val todoCheckBox: CheckBox = view.findViewById(R.id.checkBoxCompleted)
        val image: ImageView = view.findViewById(R.id.imageTodo)
    }

    private val todos = mutableListOf<Todo>()

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.run {
            todos[position].run {
                todoTitle.text = title
                todoCheckBox.isChecked = completed

                todoCheckBox.setOnCheckedChangeListener(null)
                todoCheckBox.setOnCheckedChangeListener { _, isChecked ->
                    if(isChecked != completed)
                        onCompletedChanged(todos[position], isChecked)
                }
            }

            Picasso.get()
                .load("https://picsum.photos/seed/todo${todos[position].id}/300/300")
                .resize(300, 300)
                .centerCrop()
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_todo ,parent, false) ;
        return TodoHolder(view)
    }

    fun setTodos(todos: List<Todo>) {
        this.todos.clear()
        this.todos.addAll(todos)
        notifyDataSetChanged()
    }

    fun updateTodo(updatedTodo: Todo) {
        val index = todos.indexOfFirst { it.id == updatedTodo.id }

        if (index != -1){
            todos[index] = updatedTodo
            notifyItemChanged(index)
        }
    }
}