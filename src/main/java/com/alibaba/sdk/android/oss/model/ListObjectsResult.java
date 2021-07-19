/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSObjectSummary;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.ArrayList;
import java.util.List;

public class ListObjectsResult
extends OSSResult {
    private String bucketName;
    private List commonPrefixes;
    private String delimiter;
    private String encodingType;
    private boolean isTruncated;
    private String marker;
    private int maxKeys;
    private String nextMarker;
    private List objectSummaries;
    private String prefix;

    public ListObjectsResult() {
        ArrayList arrayList;
        this.objectSummaries = arrayList = new ArrayList();
        this.commonPrefixes = arrayList = new ArrayList();
    }

    public void addCommonPrefix(String string2) {
        this.commonPrefixes.add(string2);
    }

    public void addObjectSummary(OSSObjectSummary oSSObjectSummary) {
        this.objectSummaries.add(oSSObjectSummary);
    }

    public void clearCommonPrefixes() {
        this.commonPrefixes.clear();
    }

    public void clearObjectSummaries() {
        this.objectSummaries.clear();
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public List getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
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

    public List getObjectSummaries() {
        return this.objectSummaries;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setDelimiter(String string2) {
        this.delimiter = string2;
    }

    public void setEncodingType(String string2) {
        this.encodingType = string2;
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

    public void setPrefix(String string2) {
        this.prefix = string2;
    }

    public void setTruncated(boolean bl2) {
        this.isTruncated = bl2;
    }
}

