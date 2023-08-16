package com.example.slider_image;

import java.io.Serializable;

public class PhoTo implements Serializable {
    private int resourceId;

    public PhoTo(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
