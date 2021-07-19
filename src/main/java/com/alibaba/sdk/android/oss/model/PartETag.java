/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

public class PartETag {
    private long crc64;
    private String eTag;
    private int partNumber;
    private long partSize;

    public PartETag(int n10, String string2) {
        this.setPartNumber(n10);
        this.setETag(string2);
    }

    public long getCRC64() {
        return this.crc64;
    }

    public String getETag() {
        return this.eTag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public void setCRC64(long l10) {
        this.crc64 = l10;
    }

    public void setETag(String string2) {
        this.eTag = string2;
    }

    public void setPartNumber(int n10) {
        this.partNumber = n10;
    }

    public void setPartSize(long l10) {
        this.partSize = l10;
    }
}

