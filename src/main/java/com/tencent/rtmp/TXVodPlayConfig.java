/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import java.util.Map;

public class TXVodPlayConfig {
    public boolean autoRotate;
    public String cacheMp4ExtName;
    public boolean enableAccurateSeek;
    public String mCacheFolderPath;
    public int mConnectRetryCount;
    public int mConnectRetryInterval;
    public Map mHeaders;
    public int mMaxCacheItems;
    public int mPlayerType;
    public int mTimeout;
    public int maxBufferSize;
    public int progressInterval;
    public boolean smoothSwitchBitrate;

    public TXVodPlayConfig() {
        int n10;
        this.mConnectRetryCount = n10 = 3;
        this.mConnectRetryInterval = n10;
        this.mTimeout = 10;
        n10 = 1;
        this.enableAccurateSeek = n10;
        this.autoRotate = n10;
        this.smoothSwitchBitrate = false;
        this.cacheMp4ExtName = "mp4";
        this.maxBufferSize = 0;
    }

    public void setAutoRotate(boolean bl2) {
        this.autoRotate = bl2;
    }

    public void setCacheFolderPath(String string2) {
        this.mCacheFolderPath = string2;
    }

    public void setCacheMp4ExtName(String string2) {
        this.cacheMp4ExtName = string2;
    }

    public void setConnectRetryCount(int n10) {
        this.mConnectRetryCount = n10;
    }

    public void setConnectRetryInterval(int n10) {
        this.mConnectRetryInterval = n10;
    }

    public void setEnableAccurateSeek(boolean bl2) {
        this.enableAccurateSeek = bl2;
    }

    public void setHeaders(Map map) {
        this.mHeaders = map;
    }

    public void setMaxBufferSize(int n10) {
        this.maxBufferSize = n10;
    }

    public void setMaxCacheItems(int n10) {
        this.mMaxCacheItems = n10;
    }

    public void setPlayerType(int n10) {
        this.mPlayerType = n10;
    }

    public void setProgressInterval(int n10) {
        this.progressInterval = n10;
    }

    public void setSmoothSwitchBitrate(boolean bl2) {
        this.smoothSwitchBitrate = bl2;
    }

    public void setTimeout(int n10) {
        this.mTimeout = n10;
    }
}

