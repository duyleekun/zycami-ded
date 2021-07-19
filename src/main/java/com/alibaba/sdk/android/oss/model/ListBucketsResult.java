/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSBucketSummary;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.ArrayList;
import java.util.List;

public class ListBucketsResult
extends OSSResult {
    private List buckets;
    private boolean isTruncated;
    private String marker;
    private int maxKeys;
    private String nextMarker;
    private String ownerDisplayName;
    private String ownerId;
    private String prefix;

    public ListBucketsResult() {
        ArrayList arrayList;
        this.buckets = arrayList = new ArrayList();
    }

    public void addBucket(OSSBucketSummary oSSBucketSummary) {
        this.buckets.add(oSSBucketSummary);
    }

    public void clearBucketList() {
        this.buckets.clear();
    }

    public List getBuckets() {
        return this.buckets;
    }

    public String getMarker() {
        return this.marker;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public String getOwnerDisplayName() {
        return this.ownerDisplayName;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean getTruncated() {
        return this.isTruncated;
    }

    public void setBuckets(List list) {
        this.buckets = list;
    }

    public void setMarker(String string2) {
        this.marker = string2;
    }

    public void setMaxKeys(int n10) {
        this.maxKeys = n10;
    }

    public void setNextMarker(String string2) {
        this.nextMarker = string2;
    }

    public void setOwnerDisplayName(String string2) {
        this.ownerDisplayName = string2;
    }

    public void setOwnerId(String string2) {
        this.ownerId = string2;
    }

    public void setPrefix(String string2) {
        this.prefix = string2;
    }

    public void setTruncated(boolean bl2) {
        this.isTruncated = bl2;
    }
}

