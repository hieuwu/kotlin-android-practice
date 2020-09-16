package com.hieuwu.mvcdemo.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.hieuwu.mvcdemo.MainActivity
import com.hieuwu.mvcdemo.controller.ToDoController
import com.hieuwu.mvcdemo.model.bean.ToDo
import com.hieuwu.mvcdemo.model.bean.db.ToDoModelImplementor
import com.hieuwu.mvcdemo.R
class MainActivityViewImplementor: ToDoMainActivityView {
    var viewRoot: View
        get() {
            return this.viewRoot
        }
        set(value) {}

    var toDoController: ToDoController
        get() {
            return this.toDoController
        }
        set(value) {}


    private var todoModel:ToDoModelImplementor
        get() {
            return this.todoModelImplementor
        }
        set(value) {}
    private var editTextToDoTitle: EditText
        get() {
            return editTextToDoTitle
        }
        set(value) {}

    private var editTextToDoContent: EditText
        get() {
            return this.editTextToDoContent
        }
        set(value) {}

    fun MainActivityViewImplementor(context: Context, viewGroup: ViewGroup) {
        viewRoot = LayoutInflater.from(context).inflate(R.layout.activity_main, viewGroup)
        todoModel = ToDoModelImplementor(MyApplication.getToDoListAdapter())
        todoController = ToDoController(todoModel,this)
    }
    override fun bindDataToView() {
        TODO("Not yet implemented")
    }

    override fun showAllToDos(todoList: ArrayList<ToDo>) {
        TODO("Not yet implemented")
    }

    override fun updateViewOnAdd(todoList: ArrayList<ToDo>) {
        TODO("Not yet implemented")
    }

    override fun updateViewOnRemove(todoList: ArrayList<ToDo>) {
        TODO("Not yet implemented")
    }

    override fun updateViewOnEdit(todoList: ArrayList<ToDo>) {
        TODO("Not yet implemented")
    }

    override fun showErrorToast(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun getRootView(): View {
        TODO("Not yet implemented")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }


}