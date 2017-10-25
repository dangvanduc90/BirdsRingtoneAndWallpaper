package com.changeringtone.birdrringtone.birdsringtoneandwallpaper;

public class Song {
    private String title;
    private String during;

    public Song(String title, String during) {
        this.title = title;
        this.during = during;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during;
    }
}
