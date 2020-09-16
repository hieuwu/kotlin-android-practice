package com.hieuwu.mvcdemo.model.bean

import java.lang.IllegalArgumentException
import java.util.*

class ToDo {
    var title:String?
        set(value) {
            this.title = value
        }
        get() {
            return this.title
        }
    var content:String?
        set(value) {
            this.content = value
        }
         get() {
             return this.content
         }

    var createdAt:Date? = null
        set(value) {
            this.createdAt = value
            field = value
        }

    constructor(aTitle: String, aContent: String, createdAt: Date) {
        this.title = aTitle
        this.content = aContent
        this.createdAt = createdAt
    }
}