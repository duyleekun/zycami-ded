/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import java.util.Map;

public class TXLivePlayConfig {
    public boolean mAutoAdjustCacheTime;
    public boolean mAutoRotate;
    public String mCacheFolderPath;
    public float mCacheTime;
    public int mConnectRetryCount;
    public int mConnectRetryInterval;
    public boolean mEnableAec;
    public boolean mEnableMessage;
    public boolean mEnableMetaData;
    public boolean mEnableNearestIP;
    public String mFlvSessionKey;
    public Map mHeaders;
    public float mMaxAutoAdjustCacheTime;
    public int mMaxCacheItems;
    public float mMinAutoAdjustCacheTime;
    public int mRtmpChannelType;
    public int mVideoBlockThreshold;

    public TXLivePlayConfig() {
        int n10;
        float f10;
        this.mCacheTime = f10 = 5.0f;
        this.mMaxAutoAdjustCacheTime = f10;
        this.mMinAutoAdjustCacheTime = 1.0f;
        this.mVideoBlockThreshold = 800;
        this.mConnectRetryCount = n10 = 3;
        this.mConnectRetryInterval = n10;
        n10 = 1;
        this.mAutoAdjustCacheTime = n10;
        this.mEnableAec = false;
        this.mEnableNearestIP = n10;
        this.mEnableMessage = false;
        this.mEnableMetaData = false;
        this.mFlvSessionKey = "";
        this.mRtmpChannelType = 0;
        this.mAutoRotate = n10;
    }

    public void enableAEC(boolean bl2) {
        this.mEnableAec = bl2;
    }

    public void setAutoAdjustCacheTime(boolean bl2) {
        this.mAutoAdjustCacheTime = bl2;
    }

    public void setCacheFolderPath(String string2) {
        this.mCacheFolderPath = string2;
    }

    public void setCacheTime(float f10) {
        this.mCacheTime = f10;
    }

    public void setConnectRetryCount(int n10) {
        this.mConnectRetryCount = n10;
    }

    public void setConnectRetryInterval(int n10) {
        this.mConnectRetryInterval = n10;
    }

    public void setEnableMessage(boolean bl2) {
        this.mEnableMessage = bl2;
    }

    public void setEnableMetaData(boolean bl2) {
        this.mEnableMetaData = bl2;
    }

    public void setEnableNearestIP(boolean bl2) {
        this.mEnableNearestIP = bl2;
    }

    public void setFlvSessionKey(String string2) {
        this.mFlvSessionKey = string2;
    }

    public void setHeaders(Map map) {
        this.mHeaders = map;
    }

    public void setMaxAutoAdjustCacheTime(float f10) {
        this.mMaxAutoAdjustCacheTime = f10;
    }

    public void setMaxCacheItems(int n10) {
        this.mMaxCacheItems = n10;
    }

    public void setMinAutoAdjustCacheTime(float f10) {
        this.mMinAutoAdjustCacheTime = f10;
    }

    public void setRtmpChannelType(int n10) {
        this.mRtmpChannelType = n10;
    }

    public void setVideoBlockThreshold(int n10) {
        this.mVideoBlockThreshold = n10;
    }
}

