/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.net.entities;

import java.io.Serializable;

public class FileList$ExFile
implements Serializable {
    private String createAt;
    private String duration;
    private String id;
    private String name;
    private long size;
    private String thumbnail;
    private String type;

    public String getCreateAt() {
        return this.createAt;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public String getType() {
        return this.type;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setDuration(String string2) {
        this.duration = string2;
    }

    public void setId(String string2) {
        this.id = string2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setSize(long l10) {
        this.size = l10;
    }

    public void setThumbnail(String string2) {
        this.thumbnail = string2;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExFile{name=");
        String string2 = this.name;
        stringBuilder.append(string2);
        stringBuilder.append(", id='");
        string2 = this.id;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", type='");
        String string3 = this.type;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", thumbnails='");
        string3 = this.thumbnail;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", createAt='");
        string3 = this.createAt;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", size='");
        long l10 = this.size;
        stringBuilder.append(l10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

