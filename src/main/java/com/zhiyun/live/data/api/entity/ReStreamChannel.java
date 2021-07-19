/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

import com.zhiyun.live.data.api.entity.BaseReStreamInfo;

public class ReStreamChannel
extends BaseReStreamInfo {
    public boolean active;
    public String displayName;
    public String embedUrl;
    public int id;
    public String identifier;
    public String platformIdName;
    public int streamingPlatformId;
    public String url;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReStreamChannel{id=");
        int bl2 = this.id;
        stringBuilder.append(bl2);
        stringBuilder.append(", streamingPlatformId=");
        int n10 = this.streamingPlatformId;
        stringBuilder.append(n10);
        stringBuilder.append(", embedUrl='");
        String string2 = this.embedUrl;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", url='");
        String string3 = this.url;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", identifier='");
        string3 = this.identifier;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", displayName='");
        string3 = this.displayName;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", active=");
        boolean bl3 = this.active;
        stringBuilder.append(bl3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

