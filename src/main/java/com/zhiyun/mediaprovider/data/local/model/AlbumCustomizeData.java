/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local.model;

public class AlbumCustomizeData {
    private int albumId;
    private String albumTag;
    private int id;
    private String path;

    public AlbumCustomizeData(String string2, int n10, String string3) {
        this.albumTag = string2;
        this.albumId = n10;
        this.path = string3;
    }

    public int getAlbumId() {
        return this.albumId;
    }

    public String getAlbumTag() {
        return this.albumTag;
    }

    public int getId() {
        return this.id;
    }

    public String getPath() {
        return this.path;
    }

    public void setAlbumId(int n10) {
        this.albumId = n10;
    }

    public void setAlbumTag(String string2) {
        this.albumTag = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setPath(String string2) {
        this.path = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AlbumCustomizeData{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", albumTag='");
        String string2 = this.albumTag;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", albumId=");
        int n10 = this.albumId;
        stringBuilder.append(n10);
        stringBuilder.append(", path='");
        String string3 = this.path;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

