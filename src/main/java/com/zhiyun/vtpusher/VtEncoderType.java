/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.vtpusher;

public final class VtEncoderType
extends Enum {
    public static final /* enum */ VtEncoderType H264;
    public static final /* enum */ VtEncoderType H265;
    private static final /* synthetic */ VtEncoderType[] a;
    private final String mMime;

    static {
        VtEncoderType vtEncoderType;
        VtEncoderType vtEncoderType2;
        H264 = vtEncoderType2 = new VtEncoderType("H264", 0, "video/avc");
        int n10 = 1;
        H265 = vtEncoderType = new VtEncoderType("H265", n10, "video/hevc");
        VtEncoderType[] vtEncoderTypeArray = new VtEncoderType[2];
        vtEncoderTypeArray[0] = vtEncoderType2;
        vtEncoderTypeArray[n10] = vtEncoderType;
        a = vtEncoderTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private VtEncoderType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mMime = var3_1;
    }

    public static VtEncoderType valueOf(String string2) {
        return Enum.valueOf(VtEncoderType.class, string2);
    }

    public static VtEncoderType[] values() {
        return (VtEncoderType[])a.clone();
    }

    public String getMime() {
        return this.mMime;
    }
}

