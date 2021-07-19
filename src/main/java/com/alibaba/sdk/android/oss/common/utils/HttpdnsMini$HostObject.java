/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.utils;

import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini;

public class HttpdnsMini$HostObject {
    private String hostName;
    private String ip;
    private long queryTime;
    public final /* synthetic */ HttpdnsMini this$0;
    private long ttl;

    public HttpdnsMini$HostObject(HttpdnsMini httpdnsMini) {
        this.this$0 = httpdnsMini;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String getIp() {
        return this.ip;
    }

    public long getQueryTime() {
        return this.queryTime;
    }

    public long getTtl() {
        return this.ttl;
    }

    public boolean isExpired() {
        long l10 = this.getQueryTime();
        long l11 = this.ttl;
        l10 += l11;
        l11 = System.currentTimeMillis();
        long l12 = 1000L;
        long l13 = l10 - (l11 /= l12);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean isStillAvailable() {
        long l10 = this.getQueryTime();
        long l11 = this.ttl;
        l10 = l10 + l11 + 600L;
        l11 = System.currentTimeMillis();
        long l12 = 1000L;
        long l13 = l10 - (l11 /= l12);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void setHostName(String string2) {
        this.hostName = string2;
    }

    public void setIp(String string2) {
        this.ip = string2;
    }

    public void setQueryTime(long l10) {
        this.queryTime = l10;
    }

    public void setTtl(long l10) {
        this.ttl = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[hostName=");
        String string2 = this.getHostName();
        stringBuilder.append(string2);
        stringBuilder.append(", ip=");
        string2 = this.ip;
        stringBuilder.append(string2);
        stringBuilder.append(", ttl=");
        long l10 = this.getTtl();
        stringBuilder.append(l10);
        stringBuilder.append(", queryTime=");
        l10 = this.queryTime;
        stringBuilder.append(l10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

