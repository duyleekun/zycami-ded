/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load;

public final class DecodeFormat
extends Enum {
    public static final DecodeFormat DEFAULT;
    public static final /* enum */ DecodeFormat PREFER_ARGB_8888;
    public static final /* enum */ DecodeFormat PREFER_RGB_565;
    private static final /* synthetic */ DecodeFormat[] a;

    static {
        DecodeFormat decodeFormat;
        DecodeFormat decodeFormat2;
        PREFER_ARGB_8888 = decodeFormat2 = new DecodeFormat("PREFER_ARGB_8888", 0);
        int n10 = 1;
        PREFER_RGB_565 = decodeFormat = new DecodeFormat("PREFER_RGB_565", n10);
        DecodeFormat[] decodeFormatArray = new DecodeFormat[2];
        decodeFormatArray[0] = decodeFormat2;
        decodeFormatArray[n10] = decodeFormat;
        a = decodeFormatArray;
        DEFAULT = decodeFormat2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DecodeFormat() {
        void var2_-1;
        void var1_-1;
    }

    public static DecodeFormat valueOf(String string2) {
        return Enum.valueOf(DecodeFormat.class, string2);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[])a.clone();
    }
}

