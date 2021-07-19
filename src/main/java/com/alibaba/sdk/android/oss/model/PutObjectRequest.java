/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.callback.OSSRetryCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import java.util.Map;

public class PutObjectRequest
extends OSSRequest {
    private String bucketName;
    private Map callbackParam;
    private Map callbackVars;
    private ObjectMetadata metadata;
    private String objectKey;
    private OSSProgressCallback progressCallback;
    private OSSRetryCallback retryCallback;
    private byte[] uploadData;
    private String uploadFilePath;

    public PutObjectRequest(String string2, String string3, String string4) {
        this(string2, string3, string4, null);
    }

    public PutObjectRequest(String string2, String string3, String string4, ObjectMetadata objectMetadata) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setUploadFilePath(string4);
        this.setMetadata(objectMetadata);
    }

    public PutObjectRequest(String string2, String string3, byte[] byArray) {
        this(string2, string3, byArray, null);
    }

    public PutObjectRequest(String string2, String string3, byte[] byArray, ObjectMetadata objectMetadata) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setUploadData(byArray);
        this.setMetadata(objectMetadata);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public Map getCallbackParam() {
        return this.callbackParam;
    }

    public Map getCallbackVars() {
        return this.callbackVars;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
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

    public void setCallbackParam(Map map) {
        this.callbackParam = map;
    }

    public void setCallbackVars(Map map) {
        this.callbackVars = map;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setRetryCallback(OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }

    public void setUploadData(byte[] byArray) {
        this.uploadData = byArray;
    }

    public void setUploadFilePath(String string2) {
        this.uploadFilePath = string2;
    }
}

