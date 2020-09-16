package com.hieuwu.mvcdemo.model.bean

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.util.*

class ToDoListAdapter {
    companion object {
        private val todoListAdapter : ToDoListAdapter ? =null
        private  val TAG:String = ToDoListAdapter::class.java.simpleName

        private const val  DB_NAME: String = "todolist.db"
        private const val DB_VERSION:Int = 2

        private const val TABLE_TODO = "table_todo"
        private const val COLUMN_TODO_ID = "task_id"
        private const val COLUMN_TODO = "task_todo"
        private const val COLUMN_TODO_DATE = "createdAt"

        private val CREATE_TABLE_TODO:String="CREATE TABLE "+TABLE_TODO+"("+COLUMN_TODO_ID+" INTEGER PRIMARY KEY, "+COLUMN_TODO+" TEXT NOT NULL, "+
                COLUMN_TODO_DATE + " TEXT )";

    }
    private  val context: Context ? = null
    private val sqLiteDatabase: SQLiteDatabase? = null

    private fun ToDoListAdapter(context:Context) {
        this.context = context
    }

private static class

}