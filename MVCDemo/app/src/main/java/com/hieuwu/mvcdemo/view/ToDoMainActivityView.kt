package com.hieuwu.mvcdemo.view

import com.hieuwu.mvcdemo.model.bean.ToDo

interface ToDoMainActivityView: ToDoView {
    fun bindDataToView()
    fun showAllToDos(todoList: ArrayList<ToDo>)
    fun updateViewOnAdd(todoList: ArrayList<ToDo>)
    fun updateViewOnRemove(todoList: ArrayList<ToDo>)
    fun updateViewOnEdit(todoList: ArrayList<ToDo>)
    fun  showErrorToast(errorMessage: String)
}