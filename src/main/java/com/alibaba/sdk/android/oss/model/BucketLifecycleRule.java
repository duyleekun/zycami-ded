/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

public class BucketLifecycleRule {
    private String mArchiveDays;
    private String mArchiveExpireDate;
    private String mDays;
    private String mExpireDate;
    private String mIADays;
    private String mIAExpireDate;
    private String mIdentifier;
    private String mMultipartDays;
    private String mMultipartExpireDate;
    private String mPrefix;
    private boolean mStatus;

    public String getArchiveDays() {
        return this.mArchiveDays;
    }

    public String getArchiveExpireDate() {
        return this.mArchiveExpireDate;
    }

    public String getDays() {
        return this.mDays;
    }

    public String getExpireDate() {
        return this.mExpireDate;
    }

    public String getIADays() {
        return this.mIADays;
    }

    public String getIAExpireDate() {
        return this.mIAExpireDate;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getMultipartDays() {
        return this.mMultipartDays;
    }

    public String getMultipartExpireDate() {
        return this.mMultipartExpireDate;
    }

    public String getPrefix() {
        return this.mPrefix;
    }

    public boolean getStatus() {
        return this.mStatus;
    }

    public void setArchiveDays(String string2) {
        this.mArchiveDays = string2;
    }

    public void setArchiveExpireDate(String string2) {
        this.mArchiveExpireDate = string2;
    }

    public void setDays(String string2) {
        this.mDays = string2;
    }

    public void setExpireDate(String string2) {
        this.mExpireDate = string2;
    }

    public void setIADays(String string2) {
        this.mIADays = string2;
    }

    public void setIAExpireDate(String string2) {
        this.mIAExpireDate = string2;
    }

    public void setIdentifier(String string2) {
        this.mIdentifier = string2;
    }

    public void setMultipartDays(String string2) {
        this.mMultipartDays = string2;
    }

    public void setMultipartExpireDate(String string2) {
        this.mMultipartExpireDate = string2;
    }

    public void setPrefix(String string2) {
        this.mPrefix = string2;
    }

    public void setStatus(boolean bl2) {
        this.mStatus = bl2;
    }
}

