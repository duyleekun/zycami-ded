/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.CannedAccessControlList;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.Owner;

public class GetBucketACLResult
extends OSSResult {
    private CannedAccessControlList bucketACL;
    private Owner bucketOwner;

    public GetBucketACLResult() {
        Owner owner;
        this.bucketOwner = owner = new Owner();
    }

    public String getBucketACL() {
        Object object = this.bucketACL;
        object = object != null ? object.toString() : null;
        return object;
    }

    public String getBucketOwner() {
        return this.bucketOwner.getDisplayName();
    }

    public String getBucketOwnerID() {
        return this.bucketOwner.getId();
    }

    public Owner getOwner() {
        return this.bucketOwner;
    }

    public void setBucketACL(String object) {
        object = CannedAccessControlList.parseACL(object);
        this.bucketACL = object;
    }

    public void setBucketOwner(String string2) {
        this.bucketOwner.setDisplayName(string2);
    }

    public void setBucketOwnerID(String string2) {
        this.bucketOwner.setId(string2);
    }
}

