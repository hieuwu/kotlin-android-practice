package com.hieuwu.mvcdemo.controller

import com.hieuwu.mvcdemo.MainActivity
import com.hieuwu.mvcdemo.model.bean.ToDo
import com.hieuwu.mvcdemo.model.bean.db.ToDoModelImplementor
import java.lang.Exception

class ToDoController {
    var todoModel: ToDoModelImplementor? = null
    var todoView: MainActivityImplementor? = null
    constructor(todoModel :ToDoModelImplementor, todoView: MainActivityImplementor) {
        this.todoModel = todoModel
        this.todoView = todoView
    }
    fun onViewLoaded() {
        try {
            todoView.showAllToDos(todoModel?.getAllToDoList())
        } catch (e:Exception) {

        }
    }

    fun onAddButtonClicked(todo:ToDo) {
        try {
            var isSuccess: Boolean = todoModel!!.addToDoItem(item)

        } catch(e:Exception) {

        }
    }

}