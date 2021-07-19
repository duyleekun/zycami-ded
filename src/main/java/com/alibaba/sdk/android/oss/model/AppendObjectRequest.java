/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;

public class AppendObjectRequest
extends OSSRequest {
    private String bucketName;
    private Long initCRC64;
    private ObjectMetadata metadata;
    private String objectKey;
    private long position;
    private OSSProgressCallback progressCallback;
    private byte[] uploadData;
    private String uploadFilePath;

    public AppendObjectRequest(String string2, String string3, String string4) {
        this(string2, string3, string4, null);
    }

    public AppendObjectRequest(String string2, String string3, String string4, ObjectMetadata objectMetadata) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setUploadFilePath(string4);
        this.setMetadata(objectMetadata);
    }

    public AppendObjectRequest(String string2, String string3, byte[] byArray) {
        this(string2, string3, byArray, null);
    }

    public AppendObjectRequest(String string2, String string3, byte[] byArray, ObjectMetadata objectMetadata) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setUploadData(byArray);
        this.setMetadata(objectMetadata);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public Long getInitCRC64() {
        return this.initCRC64;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public long getPosition() {
        return this.position;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setInitCRC64(Long l10) {
        this.initCRC64 = l10;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setPosition(long l10) {
        this.position = l10;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setUploadData(byte[] byArray) {
        this.uploadData = byArray;
    }

    public void setUploadFilePath(String string2) {
        this.uploadFilePath = string2;
    }
}

