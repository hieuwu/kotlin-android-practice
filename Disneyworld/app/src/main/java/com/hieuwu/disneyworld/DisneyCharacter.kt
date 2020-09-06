package com.hieuwu.disneyworld

class DisneyCharacter {
    var name:String ?=null
    var description:String ?=null
    var image:Int ?= null
    var lat:Double ?=null
    var long:Double ?=null
    var isPhotographed:Boolean?= null
    constructor(image:Int, name: String, description: String, lat:Double, long:Double) {
        this.image = image
        this.name = name
        this.description = description
        this.lat = lat
        this.long = long
        this.isPhotographed = false
    }
}