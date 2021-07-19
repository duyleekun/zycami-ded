/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.zhiyun.net.api.entity;

import android.net.Uri;
import java.io.Serializable;

public class DownloadFile
implements Serializable {
    private String cacheDir;
    private String cacheUriString;
    private String fileName;
    private String filePath;
    private String fileUriString;
    private String url;

    public DownloadFile(String string2, String string3, Uri uri) {
        this.fileName = string2;
        this.url = string3;
        this.fileUriString = string2 = uri.toString();
    }

    public DownloadFile(String string2, String string3, String string4) {
        this.fileName = string2;
        this.url = string3;
        this.filePath = string4;
    }

    public String getCacheDir() {
        return this.cacheDir;
    }

    public Uri getCacheUri() {
        return Uri.parse((String)this.cacheUriString);
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public Uri getFileUri() {
        return Uri.parse((String)this.fileUriString);
    }

    public String getUrl() {
        return this.url;
    }

    public void setCacheDir(String string2) {
        this.cacheDir = string2;
    }

    public void setCacheUri(Uri object) {
        object = object.toString();
        this.cacheUriString = object;
    }

    public void setFileName(String string2) {
        this.fileName = string2;
    }

    public void setFilePath(String string2) {
        this.filePath = string2;
    }

    public void setFileUri(Uri object) {
        object = object.toString();
        this.fileUriString = object;
    }

    public void setUrl(String string2) {
        this.url = string2;
    }
}

