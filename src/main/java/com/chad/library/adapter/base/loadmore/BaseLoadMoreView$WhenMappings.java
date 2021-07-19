/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.loadmore;

import com.chad.library.adapter.base.loadmore.LoadMoreStatus;

public final class BaseLoadMoreView$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[LoadMoreStatus.values().length];
        $EnumSwitchMapping$0 = nArray;
        int n10 = LoadMoreStatus.Complete.ordinal();
        nArray[n10] = 1;
        n10 = LoadMoreStatus.Loading.ordinal();
        nArray[n10] = 2;
        n10 = LoadMoreStatus.Fail.ordinal();
        nArray[n10] = 3;
        n10 = LoadMoreStatus.End.ordinal();
        nArray[n10] = 4;
    }
}

