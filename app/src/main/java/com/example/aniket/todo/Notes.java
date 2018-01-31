package com.example.aniket.todo;

/**
 * Created by aniket on 31/01/18.
 */

public class Notes {

    private String title;
    private String description;

    public Notes(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
