/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.zhiyun.mediaprovider.data;

import android.net.Uri;

public class MediaBean {
    private long dataModified;
    private long dateAdded;
    private String displayName;
    private int id;
    private String mime;
    private String path;
    private long size;
    private String tag;
    private int type;
    private Uri uri;

    public long getDataModified() {
        return this.dataModified;
    }

    public long getDateAdded() {
        return this.dateAdded;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getId() {
        return this.id;
    }

    public String getMime() {
        return this.mime;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public String getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public Uri getUri() {
        return this.uri;
    }

    public MediaBean setDataModified(long l10) {
        this.dataModified = l10;
        return this;
    }

    public MediaBean setDateAdded(long l10) {
        this.dateAdded = l10;
        return this;
    }

    public MediaBean setDisplayName(String string2) {
        this.displayName = string2;
        return this;
    }

    public MediaBean setId(int n10) {
        this.id = n10;
        return this;
    }

    public MediaBean setMime(String string2) {
        this.mime = string2;
        return this;
    }

    public MediaBean setPath(String string2) {
        this.path = string2;
        return this;
    }

    public MediaBean setSize(long l10) {
        this.size = l10;
        return this;
    }

    public MediaBean setTag(String string2) {
        this.tag = string2;
        return this;
    }

    public MediaBean setType(int n10) {
        this.type = n10;
        return this;
    }

    public MediaBean setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaBean{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", uri=");
        Object object = this.uri;
        stringBuilder.append(object);
        stringBuilder.append(", path='");
        object = this.path;
        stringBuilder.append((String)object);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", size=");
        long l10 = this.size;
        stringBuilder.append(l10);
        stringBuilder.append(", displayName='");
        String string2 = this.displayName;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", dateAdded=");
        l10 = this.dateAdded;
        stringBuilder.append(l10);
        stringBuilder.append(c11);
        stringBuilder.append(", dataModified=");
        l10 = this.dataModified;
        stringBuilder.append(l10);
        stringBuilder.append(", mime='");
        string2 = this.mime;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", type=");
        int n10 = this.type;
        stringBuilder.append(n10);
        stringBuilder.append(", tag='");
        string2 = this.tag;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

