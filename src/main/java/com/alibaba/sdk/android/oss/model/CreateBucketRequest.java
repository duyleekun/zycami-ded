/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.CannedAccessControlList;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.StorageClass;

public class CreateBucketRequest
extends OSSRequest {
    public static final String TAB_LOCATIONCONSTRAINT = "LocationConstraint";
    public static final String TAB_STORAGECLASS = "StorageClass";
    private CannedAccessControlList bucketACL;
    private String bucketName;
    private StorageClass bucketStorageClass;
    private String locationConstraint;

    public CreateBucketRequest(String string2) {
        StorageClass storageClass;
        this.bucketStorageClass = storageClass = StorageClass.Standard;
        this.setBucketName(string2);
    }

    public CannedAccessControlList getBucketACL() {
        return this.bucketACL;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public StorageClass getBucketStorageClass() {
        return this.bucketStorageClass;
    }

    public String getLocationConstraint() {
        return this.locationConstraint;
    }

    public void setBucketACL(CannedAccessControlList cannedAccessControlList) {
        this.bucketACL = cannedAccessControlList;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setBucketStorageClass(StorageClass storageClass) {
        this.bucketStorageClass = storageClass;
    }

    public void setLocationConstraint(String string2) {
        this.locationConstraint = string2;
    }
}

