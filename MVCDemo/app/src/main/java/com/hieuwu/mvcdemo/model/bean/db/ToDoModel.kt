package com.hieuwu.mvcdemo.model.bean.db

import com.hieuwu.mvcdemo.model.bean.ToDo
import java.util.*
import kotlin.collections.ArrayList

interface ToDoModel {
    fun getAllToDoList(): ArrayList<ToDo>
    fun  addToDoItem(item: ToDo): Boolean
    fun removeToDoItem(id: Int): Boolean
    fun editToDoItem(atitle:String, aContent: String, modifedAt: Date): Boolean
}