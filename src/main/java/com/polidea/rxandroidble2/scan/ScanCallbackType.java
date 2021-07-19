/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.scan;

public final class ScanCallbackType
extends Enum {
    public static final /* enum */ ScanCallbackType CALLBACK_TYPE_ALL_MATCHES;
    public static final /* enum */ ScanCallbackType CALLBACK_TYPE_BATCH;
    public static final /* enum */ ScanCallbackType CALLBACK_TYPE_FIRST_MATCH;
    public static final /* enum */ ScanCallbackType CALLBACK_TYPE_MATCH_LOST;
    public static final /* enum */ ScanCallbackType CALLBACK_TYPE_UNKNOWN;
    public static final /* enum */ ScanCallbackType CALLBACK_TYPE_UNSPECIFIED;
    private static final /* synthetic */ ScanCallbackType[] a;

    static {
        ScanCallbackType scanCallbackType;
        ScanCallbackType scanCallbackType2;
        ScanCallbackType scanCallbackType3;
        ScanCallbackType scanCallbackType4;
        ScanCallbackType scanCallbackType5;
        ScanCallbackType scanCallbackType6;
        CALLBACK_TYPE_ALL_MATCHES = scanCallbackType6 = new ScanCallbackType("CALLBACK_TYPE_ALL_MATCHES", 0);
        int n10 = 1;
        CALLBACK_TYPE_FIRST_MATCH = scanCallbackType5 = new ScanCallbackType("CALLBACK_TYPE_FIRST_MATCH", n10);
        int n11 = 2;
        CALLBACK_TYPE_MATCH_LOST = scanCallbackType4 = new ScanCallbackType("CALLBACK_TYPE_MATCH_LOST", n11);
        int n12 = 3;
        CALLBACK_TYPE_BATCH = scanCallbackType3 = new ScanCallbackType("CALLBACK_TYPE_BATCH", n12);
        int n13 = 4;
        CALLBACK_TYPE_UNSPECIFIED = scanCallbackType2 = new ScanCallbackType("CALLBACK_TYPE_UNSPECIFIED", n13);
        int n14 = 5;
        CALLBACK_TYPE_UNKNOWN = scanCallbackType = new ScanCallbackType("CALLBACK_TYPE_UNKNOWN", n14);
        ScanCallbackType[] scanCallbackTypeArray = new ScanCallbackType[6];
        scanCallbackTypeArray[0] = scanCallbackType6;
        scanCallbackTypeArray[n10] = scanCallbackType5;
        scanCallbackTypeArray[n11] = scanCallbackType4;
        scanCallbackTypeArray[n12] = scanCallbackType3;
        scanCallbackTypeArray[n13] = scanCallbackType2;
        scanCallbackTypeArray[n14] = scanCallbackType;
        a = scanCallbackTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ScanCallbackType() {
        void var2_-1;
        void var1_-1;
    }

    public static ScanCallbackType valueOf(String string2) {
        return Enum.valueOf(ScanCallbackType.class, string2);
    }

    public static ScanCallbackType[] values() {
        return (ScanCallbackType[])a.clone();
    }
}

