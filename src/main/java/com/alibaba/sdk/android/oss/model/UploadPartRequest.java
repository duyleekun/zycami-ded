/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;

public class UploadPartRequest
extends OSSRequest {
    private String bucketName;
    private String md5Digest;
    private String objectKey;
    private byte[] partContent;
    private int partNumber;
    private OSSProgressCallback progressCallback;
    private String uploadId;

    public UploadPartRequest() {
    }

    public UploadPartRequest(String string2, String string3, String string4, int n10) {
        this.bucketName = string2;
        this.objectKey = string3;
        this.uploadId = string4;
        this.partNumber = n10;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public byte[] getPartContent() {
        return this.partContent;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setMd5Digest(String string2) {
        this.md5Digest = string2;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setPartContent(byte[] byArray) {
        this.partContent = byArray;
    }

    public void setPartNumber(int n10) {
        this.partNumber = n10;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setUploadId(String string2) {
        this.uploadId = string2;
    }
}

