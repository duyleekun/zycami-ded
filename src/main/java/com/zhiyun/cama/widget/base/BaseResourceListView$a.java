/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.widget.base;

import com.zhiyun.cama.widget.base.BaseResourceListView$ResourceType;

public class BaseResourceListView$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        BaseResourceListView$ResourceType baseResourceListView$ResourceType;
        int n12 = BaseResourceListView$ResourceType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            baseResourceListView$ResourceType = BaseResourceListView$ResourceType.RESOURCE_TYPE_FONT;
            n11 = baseResourceListView$ResourceType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            baseResourceListView$ResourceType = BaseResourceListView$ResourceType.RESOURCE_TYPE_STICKER;
            n11 = baseResourceListView$ResourceType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            baseResourceListView$ResourceType = BaseResourceListView$ResourceType.RESOURCE_TYPE_CAPTION;
            n11 = baseResourceListView$ResourceType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            baseResourceListView$ResourceType = BaseResourceListView$ResourceType.RESOURCE_TYPE_TRANSITION;
            n11 = baseResourceListView$ResourceType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            baseResourceListView$ResourceType = BaseResourceListView$ResourceType.RESOURCE_TYPE_FILTER;
            n11 = baseResourceListView$ResourceType.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

