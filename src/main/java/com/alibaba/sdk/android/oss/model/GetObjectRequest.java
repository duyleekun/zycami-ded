/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.Range;
import java.util.Map;

public class GetObjectRequest
extends OSSRequest {
    private String bucketName;
    private String objectKey;
    private OSSProgressCallback progressListener;
    private Range range;
    private Map requestHeaders;
    private String xOssProcess;

    public GetObjectRequest(String string2, String string3) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public OSSProgressCallback getProgressListener() {
        return this.progressListener;
    }

    public Range getRange() {
        return this.range;
    }

    public Map getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getxOssProcess() {
        return this.xOssProcess;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setProgressListener(OSSProgressCallback oSSProgressCallback) {
        this.progressListener = oSSProgressCallback;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public void setRequestHeaders(Map map) {
        this.requestHeaders = map;
    }

    public void setxOssProcess(String string2) {
        this.xOssProcess = string2;
    }
}

