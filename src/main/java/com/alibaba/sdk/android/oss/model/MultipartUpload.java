/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import java.util.Date;

public class MultipartUpload {
    private Date initiated;
    private String key;
    private String storageClass;
    private String uploadId;

    public Date getInitiated() {
        return this.initiated;
    }

    public String getKey() {
        return this.key;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setInitiated(Date date) {
        this.initiated = date;
    }

    public void setKey(String string2) {
        this.key = string2;
    }

    public void setStorageClass(String string2) {
        this.storageClass = string2;
    }

    public void setUploadId(String string2) {
        this.uploadId = string2;
    }
}

