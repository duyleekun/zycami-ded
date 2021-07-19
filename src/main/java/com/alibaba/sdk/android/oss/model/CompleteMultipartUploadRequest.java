/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompleteMultipartUploadRequest
extends OSSRequest {
    private String bucketName;
    private Map callbackParam;
    private Map callbackVars;
    private ObjectMetadata metadata;
    private String objectKey;
    private List partETags;
    private String uploadId;

    public CompleteMultipartUploadRequest(String string2, String string3, String string4, List list) {
        ArrayList arrayList;
        this.partETags = arrayList = new ArrayList();
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setUploadId(string4);
        this.setPartETags(list);
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

    public List getPartETags() {
        return this.partETags;
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

    public void setPartETags(List list) {
        this.partETags = list;
    }

    public void setUploadId(String string2) {
        this.uploadId = string2;
    }
}

