/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.utils.GT3ServiceNode;

public class a$c {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        GT3ServiceNode gT3ServiceNode;
        int n12 = GT3ServiceNode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            gT3ServiceNode = GT3ServiceNode.NODE_NORTH_AMERICA;
            n11 = gT3ServiceNode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            gT3ServiceNode = GT3ServiceNode.NODE_NORTH_GOOGLE;
            n11 = gT3ServiceNode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            gT3ServiceNode = GT3ServiceNode.NODE_IPV6;
            n11 = gT3ServiceNode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            gT3ServiceNode = GT3ServiceNode.NODE_CHINA;
            n11 = gT3ServiceNode.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

