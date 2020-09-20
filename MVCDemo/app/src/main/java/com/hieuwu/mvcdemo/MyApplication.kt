package com.hieuwu.mvcdemo

import android.app.Application
import com.hieuwu.mvcdemo.model.bean.ToDoListAdapter
class MyApplication: Application() {
    companion object {
        private var toDoListAdapter: ToDoListAdapter ?= null
        fun  getToDoListAdapter(): ToDoListAdapter? {
            return toDoListAdapter
        }

    }

    override fun onCreate() {
        super.onCreate()
        toDoListAdapter = ToDoListAdapter.getToDoListAdapterInstance(this)
    }
}