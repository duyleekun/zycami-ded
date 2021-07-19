/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.vtpusher;

public final class VtDataType
extends Enum {
    public static final /* enum */ VtDataType ByteType;
    public static final /* enum */ VtDataType SurfaceType;
    private static final /* synthetic */ VtDataType[] a;

    static {
        VtDataType vtDataType;
        VtDataType vtDataType2;
        ByteType = vtDataType2 = new VtDataType("ByteType", 0);
        int n10 = 1;
        SurfaceType = vtDataType = new VtDataType("SurfaceType", n10);
        VtDataType[] vtDataTypeArray = new VtDataType[2];
        vtDataTypeArray[0] = vtDataType2;
        vtDataTypeArray[n10] = vtDataType;
        a = vtDataTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private VtDataType() {
        void var2_-1;
        void var1_-1;
    }

    public static VtDataType valueOf(String string2) {
        return Enum.valueOf(VtDataType.class, string2);
    }

    public static VtDataType[] values() {
        return (VtDataType[])a.clone();
    }
}

