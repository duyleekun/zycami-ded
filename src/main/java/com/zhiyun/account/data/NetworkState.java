/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data;

import com.zhiyun.account.data.NetworkState$Status;

public class NetworkState {
    public NetworkState$Status a;
    public int b;
    public String c;

    public NetworkState(NetworkState$Status networkState$Status) {
        this.a = networkState$Status;
    }

    public NetworkState(NetworkState$Status networkState$Status, int n10, String string2) {
        this.a = networkState$Status;
        this.b = n10;
        this.c = string2;
    }
}

