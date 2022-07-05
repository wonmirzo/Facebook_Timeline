package com.wonmirzo.model

class Story{
    var profile: String = ""
    var fullName: String = ""

    constructor(profile: String){
        this.profile = profile
    }
    constructor(profile: String, fullName: String) {
        this.profile = profile
        this.fullName = fullName
    }
}
