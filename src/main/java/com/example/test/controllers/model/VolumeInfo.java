package com.example.test.controllers.model;

import lombok.Data;

@Data
public class VolumeInfo {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
