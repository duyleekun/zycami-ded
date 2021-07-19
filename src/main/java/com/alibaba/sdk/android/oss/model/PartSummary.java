/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import java.util.Date;

public class PartSummary {
    private String eTag;
    private Date lastModified;
    private int partNumber;
    private long size;

    public String getETag() {
        return this.eTag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getSize() {
        return this.size;
    }

    public void setETag(String string2) {
        this.eTag = string2;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setPartNumber(int n10) {
        this.partNumber = n10;
    }

    public void setSize(long l10) {
        this.size = l10;
    }
}

