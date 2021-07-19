/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.Owner;
import java.util.Date;

public class OSSObjectSummary {
    private String bucketName;
    private String eTag;
    private String key;
    private Date lastModified;
    private Owner owner;
    private long size;
    private String storageClass;
    private String type;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getKey() {
        return this.key;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public long getSize() {
        return this.size;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getType() {
        return this.type;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setETag(String string2) {
        this.eTag = string2;
    }

    public void setKey(String string2) {
        this.key = string2;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setSize(long l10) {
        this.size = l10;
    }

    public void setStorageClass(String string2) {
        this.storageClass = string2;
    }

    public void setType(String string2) {
        this.type = string2;
    }
}

