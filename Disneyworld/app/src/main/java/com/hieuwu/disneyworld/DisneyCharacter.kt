package com.hieuwu.disneyworld

import android.location.Location

class DisneyCharacter {
    var name:String ?=null
    var description:String ?=null
    var image:Int ?= null
    var location:Location ?= null
    var isPhotographed:Boolean?= null
    constructor(image:Int, name: String, description: String, lat:Double, long:Double) {
        this.image = image
        this.name = name
        this.description = description
        this.location = Location(name)
        this.location!!.latitude = lat
        this.location!!.longitude = long
        this.isPhotographed = false
    }
}