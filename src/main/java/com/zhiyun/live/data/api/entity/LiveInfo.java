/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class LiveInfo
extends BaseEntity {
    private String liveVideoId;
    private String rtmpUrl;

    public String getLiveVideoId() {
        return this.liveVideoId;
    }

    public String getRtmpUrl() {
        return this.rtmpUrl;
    }

    public void setLiveVideoId(String string2) {
        this.liveVideoId = string2;
    }

    public void setRtmpUrl(String string2) {
        this.rtmpUrl = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LiveInfo{liveVideoId='");
        String string2 = this.liveVideoId;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", rtmpUrl='");
        String string3 = this.rtmpUrl;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", errcode=");
        int n10 = this.errcode;
        stringBuilder.append(n10);
        stringBuilder.append(", errmsg='");
        string3 = this.errmsg;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

