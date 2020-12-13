package com.norbertovargas.pruebassmarttime;

import android.net.Uri;

public class Contact {
    private String name;
    private Uri photo;
    private String lastMsg;
    private boolean online = false;
    private boolean unread = false;

    public Contact(String name, Uri photo) {
        this.name = name;
        this.photo = photo;
    }

    public Contact(String name, Uri photo, String lastMsg, boolean online) {
        this.name = name;
        this.photo = photo;
        this.lastMsg = lastMsg;
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }
}
