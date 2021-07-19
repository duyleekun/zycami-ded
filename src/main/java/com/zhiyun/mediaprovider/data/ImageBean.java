/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data;

import com.zhiyun.mediaprovider.data.MediaBean;

public class ImageBean
extends MediaBean {
    private int height;
    private int orientation;
    private int width;

    public int getHeight() {
        return this.height;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageBean setHeight(int n10) {
        this.height = n10;
        return this;
    }

    public ImageBean setOrientation(int n10) {
        this.orientation = n10;
        return this;
    }

    public ImageBean setWidth(int n10) {
        this.width = n10;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageBean{width=");
        int n10 = this.width;
        stringBuilder.append(n10);
        stringBuilder.append(", height=");
        n10 = this.height;
        stringBuilder.append(n10);
        stringBuilder.append(", orientation=");
        n10 = this.orientation;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

