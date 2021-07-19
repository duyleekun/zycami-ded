/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.ArrayList;
import java.util.List;

public class ListPartsResult
extends OSSResult {
    private String bucketName;
    private boolean isTruncated = false;
    private String key;
    private int maxParts = 0;
    private int nextPartNumberMarker = 0;
    private int partNumberMarker = 0;
    private List parts;
    private String storageClass;
    private String uploadId;

    public ListPartsResult() {
        ArrayList arrayList;
        this.parts = arrayList = new ArrayList();
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public int getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public List getParts() {
        return this.parts;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setKey(String string2) {
        this.key = string2;
    }

    public void setMaxParts(int n10) {
        this.maxParts = n10;
    }

    public void setNextPartNumberMarker(int n10) {
        this.nextPartNumberMarker = n10;
    }

    public void setPartNumberMarker(int n10) {
        this.partNumberMarker = n10;
    }

    public void setParts(List list) {
        boolean bl2;
        List list2 = this.parts;
        list2.clear();
        if (list != null && !(bl2 = list.isEmpty())) {
            list2 = this.parts;
            list2.addAll(list);
        }
    }

    public void setStorageClass(String string2) {
        this.storageClass = string2;
    }

    public void setTruncated(boolean bl2) {
        this.isTruncated = bl2;
    }

    public void setUploadId(String string2) {
        this.uploadId = string2;
    }
}

