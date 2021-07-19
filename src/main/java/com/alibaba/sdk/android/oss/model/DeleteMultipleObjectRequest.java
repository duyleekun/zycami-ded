/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.util.List;

public class DeleteMultipleObjectRequest
extends OSSRequest {
    private String bucketName;
    private boolean isQuiet;
    private List objectKeys;

    public DeleteMultipleObjectRequest(String string2, List list, Boolean bl2) {
        this.setBucketName(string2);
        this.setObjectKeys(list);
        this.setQuiet(bl2);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public List getObjectKeys() {
        return this.objectKeys;
    }

    public Boolean getQuiet() {
        return this.isQuiet;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setObjectKeys(List list) {
        this.objectKeys = list;
    }

    public void setQuiet(Boolean bl2) {
        boolean bl3;
        this.isQuiet = bl3 = bl2.booleanValue();
    }
}

