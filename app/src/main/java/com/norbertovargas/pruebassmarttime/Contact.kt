package com.norbertovargas.pruebassmarttime

import android.net.Uri

class Contact {
    var name: String
    var photo: Uri
    var lastMsg: String? = null
    var isOnline = false
    var isUnread = false

    constructor(name: String, photo: Uri) {
        this.name = name
        this.photo = photo
    }

    constructor(name: String, photo: Uri, lastMsg: String?, online: Boolean) {
        this.name = name
        this.photo = photo
        this.lastMsg = lastMsg
        isOnline = online
    }
}