/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.loadmore;

public final class LoadMoreStatus
extends Enum {
    private static final /* synthetic */ LoadMoreStatus[] $VALUES;
    public static final /* enum */ LoadMoreStatus Complete;
    public static final /* enum */ LoadMoreStatus End;
    public static final /* enum */ LoadMoreStatus Fail;
    public static final /* enum */ LoadMoreStatus Loading;

    static {
        LoadMoreStatus loadMoreStatus;
        LoadMoreStatus[] loadMoreStatusArray = new LoadMoreStatus[4];
        Complete = loadMoreStatus = new LoadMoreStatus("Complete", 0);
        loadMoreStatusArray[0] = loadMoreStatus;
        int n10 = 1;
        Loading = loadMoreStatus = new LoadMoreStatus("Loading", n10);
        loadMoreStatusArray[n10] = loadMoreStatus;
        n10 = 2;
        Fail = loadMoreStatus = new LoadMoreStatus("Fail", n10);
        loadMoreStatusArray[n10] = loadMoreStatus;
        n10 = 3;
        End = loadMoreStatus = new LoadMoreStatus("End", n10);
        loadMoreStatusArray[n10] = loadMoreStatus;
        $VALUES = loadMoreStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LoadMoreStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static LoadMoreStatus valueOf(String string2) {
        return Enum.valueOf(LoadMoreStatus.class, string2);
    }

    public static LoadMoreStatus[] values() {
        return (LoadMoreStatus[])$VALUES.clone();
    }
}

