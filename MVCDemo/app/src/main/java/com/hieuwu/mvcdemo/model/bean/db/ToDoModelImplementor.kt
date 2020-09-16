package com.hieuwu.mvcdemo.model.bean.db

import android.content.res.Resources
import com.hieuwu.mvcdemo.model.bean.ToDo
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class ToDoModelImplementor: ToDoModel {
    var todoListAdapter:  ToDoListAdapter
    var listOfToDos = ArrayList<ToDo>()

    override fun getAllToDoList(): ArrayList<ToDo> {
        if (this.listOfToDos != null && this.listOfToDos.size > 0) {
            return this.listOfToDos
        } else {
            throw Exception("To do list is empty")
        }
    }

    override fun addToDoItem(todoItem: ToDo): Boolean {
        TODO("Not yet implemented")
        var isSuccess: Boolean = todoListAdapter.insert(todoItem)
        if (isSuccess) {
            refresh()
        } else {
            throw Exception("Something went wrong !")
        }
        return isSuccess
    }

    override fun removeToDoItem(id: Int): Boolean {
        var isSuccess = todoListAdapter.delete(id);
        if (isSuccess) {
            refresh()
        } else {
            throw Resources.NotFoundException("Id is wrong")
        }
        return isSuccess
    }

    override fun editToDoItem(atitle: String, aContent: String, modifedAt: Date): Boolean {
        var isSuccess = todoListAdapter.modify(id: Int, newTodoValue);
        if (isSuccess) {
            refresh()
        } else {
            throw Exception("Error!")
        }
    }
}