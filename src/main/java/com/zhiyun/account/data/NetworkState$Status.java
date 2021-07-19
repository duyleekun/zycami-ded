/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data;

public final class NetworkState$Status
extends Enum {
    public static final /* enum */ NetworkState$Status FAILED;
    public static final /* enum */ NetworkState$Status RUNNING;
    public static final /* enum */ NetworkState$Status SUCCESS;
    private static final /* synthetic */ NetworkState$Status[] a;

    static {
        NetworkState$Status networkState$Status;
        NetworkState$Status networkState$Status2;
        NetworkState$Status networkState$Status3;
        RUNNING = networkState$Status3 = new NetworkState$Status("RUNNING", 0);
        int n10 = 1;
        SUCCESS = networkState$Status2 = new NetworkState$Status("SUCCESS", n10);
        int n11 = 2;
        FAILED = networkState$Status = new NetworkState$Status("FAILED", n11);
        NetworkState$Status[] networkState$StatusArray = new NetworkState$Status[3];
        networkState$StatusArray[0] = networkState$Status3;
        networkState$StatusArray[n10] = networkState$Status2;
        networkState$StatusArray[n11] = networkState$Status;
        a = networkState$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NetworkState$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static NetworkState$Status valueOf(String string2) {
        return Enum.valueOf(NetworkState$Status.class, string2);
    }

    public static NetworkState$Status[] values() {
        return (NetworkState$Status[])a.clone();
    }
}

