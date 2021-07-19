/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.hotspot;

import com.zhiyun.protocol.message.bl.wifi.hotspot.Channel$Status;

public class Channel {
    private final int a;
    private final Channel$Status b;
    private final int c;

    public Channel(int n10, Channel$Status channel$Status, int n11) {
        this.a = n10;
        this.b = channel$Status;
        this.c = n11;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public Channel$Status c() {
        return this.b;
    }
}

