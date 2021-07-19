/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import java.util.Map;

public class MultipartUploadRequest
extends OSSRequest {
    public String bucketName;
    public Map callbackParam;
    public Map callbackVars;
    public ObjectMetadata metadata;
    public String objectKey;
    public long partSize = 262144L;
    public OSSProgressCallback progressCallback;
    public String uploadFilePath;
    public String uploadId;

    public MultipartUploadRequest(String string2, String string3, String string4) {
        this(string2, string3, string4, null);
    }

    public MultipartUploadRequest(String string2, String string3, String string4, ObjectMetadata objectMetadata) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setUploadFilePath(string4);
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

    public long getPartSize() {
        return this.partSize;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public String getUploadId() {
        return this.uploadId;
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

    public void setPartSize(long l10) {
        this.partSize = l10;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setUploadFilePath(String string2) {
        this.uploadFilePath = string2;
    }

    public void setUploadId(String string2) {
        this.uploadId = string2;
    }
}

