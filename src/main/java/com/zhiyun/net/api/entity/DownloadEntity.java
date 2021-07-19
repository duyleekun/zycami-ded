/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.api.entity;

import java.util.Objects;

public class DownloadEntity {
    public String destFileDir;
    public String fileName;
    public Object t;
    public String url;

    public DownloadEntity(String string2, String string3, String string4) {
        this.url = string2;
        this.destFileDir = string3;
        this.fileName = string4;
    }

    public DownloadEntity(String string2, String string3, String string4, Object object) {
        this.url = string2;
        this.destFileDir = string3;
        this.fileName = string4;
        this.t = object;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (DownloadEntity)object;
            object3 = this.url;
            object2 = ((DownloadEntity)object).url;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.destFileDir, object2 = ((DownloadEntity)object).destFileDir)) && (bl4 = Objects.equals(object3 = this.fileName, object2 = ((DownloadEntity)object).fileName)) && (bl3 = Objects.equals(object3 = this.t, object = ((DownloadEntity)object).t)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getDestFileDir() {
        return this.destFileDir;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Object getT() {
        return this.t;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Object object = this.url;
        object = this.destFileDir;
        object = this.fileName;
        object = this.t;
        Object[] objectArray = new Object[]{object, object, object, object};
        return Objects.hash(objectArray);
    }

    public void setDestFileDir(String string2) {
        this.destFileDir = string2;
    }

    public void setFileName(String string2) {
        this.fileName = string2;
    }

    public void setT(Object object) {
        this.t = object;
    }

    public void setUrl(String string2) {
        this.url = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DownloadEntity{url='");
        Object object = this.url;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", destFileDir='");
        String string2 = this.destFileDir;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", fileName='");
        string2 = this.fileName;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", t=");
        object = this.t;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

