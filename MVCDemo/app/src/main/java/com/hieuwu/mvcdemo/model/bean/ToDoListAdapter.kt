package com.hieuwu.mvcdemo.model.bean

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ToDoListAdapter(context: Context) {
    companion object {
        private var todoListAdapterInstance: ToDoListAdapter? = null
        private val TAG: String = ToDoListAdapter::class.java.simpleName

        private const val DB_NAME: String = "todolist.db"
        private const val DB_VERSION: Int = 2

        private const val TABLE_TODO = "table_todo"
        private const val COLUMN_TODO_ID = "task_id"
        private const val COLUMN_TODO = "task_todo"
        private const val COLUMN_TODO_DATE = "createdAt"
        private const val COLUMN_PLACE = "place"
        private val CREATE_TABLE_TODO: String =
            "CREATE TABLE " + TABLE_TODO + "(" + COLUMN_TODO_ID + " INTEGER PRIMARY KEY, " + COLUMN_TODO + " TEXT NOT NULL, " +
                    COLUMN_TODO_DATE + " TEXT )";
        fun getToDoListAdapterInstance(context:Context): ToDoListAdapter {
            if(todoListAdapterInstance==null){
                todoListAdapterInstance= ToDoListAdapter(context);
            }
            return todoListAdapterInstance as ToDoListAdapter;
        }
    }

    private var context: Context? = null
    private var sqLiteDatabase: SQLiteDatabase? = null

    private fun ToDoListAdapter(context: Context) {
        this.context = context
        sqLiteDatabase =
            ToDoListHelper(context, DB_NAME, null, DB_VERSION).getWritableDatabase();
    }


    private class ToDoListHelper: SQLiteOpenHelper {
        constructor(context: Context, databaseName: String, factory: SQLiteDatabase.CursorFactory?, dbVersion: Int) : super(context,databaseName,factory,dbVersion) {
        }

        override fun onCreate(sqliteDatabase: SQLiteDatabase?) {
            TODO("Not yet implemented")
            sqliteDatabase?.execSQL(CREATE_TABLE_TODO)
        }

        override fun onConfigure(db: SQLiteDatabase?) {
            super.onConfigure(db)
            db?.setForeignKeyConstraintsEnabled(true)
        }


        override fun onUpgrade(sqliteDatabase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
            if (oldVersion == 1) {
                sqliteDatabase?.execSQL("ALTER TABLE " + TABLE_TODO + " ADD COLUMN " + COLUMN_PLACE + " TEXT");
            }
        }
    }
}



