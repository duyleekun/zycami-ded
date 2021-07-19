/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class CompleteMultipartUploadResult
extends OSSResult {
    private String bucketName;
    private String eTag;
    private String location;
    private String objectKey;
    private String serverCallbackReturnBody;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getLocation() {
        return this.location;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getServerCallbackReturnBody() {
        return this.serverCallbackReturnBody;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setETag(String string2) {
        this.eTag = string2;
    }

    public void setLocation(String string2) {
        this.location = string2;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setServerCallbackReturnBody(String string2) {
        this.serverCallbackReturnBody = string2;
    }
}

