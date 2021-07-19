/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CopyObjectRequest
extends OSSRequest {
    private String destinationBucketName;
    private String destinationKey;
    private List matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private ObjectMetadata newObjectMetadata;
    private List nonmatchingEtagConstraints;
    private String serverSideEncryption;
    private String sourceBucketName;
    private String sourceKey;
    private Date unmodifiedSinceConstraint;

    public CopyObjectRequest(String string2, String string3, String string4, String string5) {
        ArrayList arrayList;
        this.matchingETagConstraints = arrayList = new ArrayList();
        this.nonmatchingEtagConstraints = arrayList = new ArrayList();
        this.setSourceBucketName(string2);
        this.setSourceKey(string3);
        this.setDestinationBucketName(string4);
        this.setDestinationKey(string5);
    }

    public void clearMatchingETagConstraints() {
        this.matchingETagConstraints.clear();
    }

    public void clearNonmatchingETagConstraints() {
        this.nonmatchingEtagConstraints.clear();
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public List getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public ObjectMetadata getNewObjectMetadata() {
        return this.newObjectMetadata;
    }

    public List getNonmatchingEtagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setDestinationBucketName(String string2) {
        this.destinationBucketName = string2;
    }

    public void setDestinationKey(String string2) {
        this.destinationKey = string2;
    }

    public void setMatchingETagConstraints(List list) {
        boolean bl2;
        List list2 = this.matchingETagConstraints;
        list2.clear();
        if (list != null && !(bl2 = list.isEmpty())) {
            list2 = this.matchingETagConstraints;
            list2.addAll(list);
        }
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNewObjectMetadata(ObjectMetadata objectMetadata) {
        this.newObjectMetadata = objectMetadata;
    }

    public void setNonmatchingETagConstraints(List list) {
        boolean bl2;
        List list2 = this.nonmatchingEtagConstraints;
        list2.clear();
        if (list != null && !(bl2 = list.isEmpty())) {
            list2 = this.nonmatchingEtagConstraints;
            list2.addAll(list);
        }
    }

    public void setServerSideEncryption(String string2) {
        this.serverSideEncryption = string2;
    }

    public void setSourceBucketName(String string2) {
        this.sourceBucketName = string2;
    }

    public void setSourceKey(String string2) {
        this.sourceKey = string2;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }
}

