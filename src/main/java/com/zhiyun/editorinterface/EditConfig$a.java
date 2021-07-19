/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorinterface;

public final class EditConfig$a {
    public static final int a = 48000;
    public static final int b = 2;
    public static final int c = 2;
    public static final int d = 720;
    public static final int e = 3000000;
    public static final int f = 500000;
    public static final int g = 500000;
    public static final long h = 40000L;
    public static final float i = 0.5f;
    public static final float j = 0.5f;
    public static float[] k;
    public static String[] l;
    public static final String[] m;

    static {
        float[] fArray;
        float[] fArray2 = fArray = new float[7];
        float[] fArray3 = fArray;
        fArray2[0] = 0.5625f;
        fArray3[1] = 1.0f;
        fArray2[2] = 1.3333334f;
        fArray3[3] = 1.7777778f;
        fArray2[4] = 1.0f;
        fArray3[5] = 0.75f;
        fArray3[6] = 1.0f;
        k = fArray;
        l = new String[]{"9:16", "1:1", "4:3", "16:9", "-1:-1", "3:4", "1:1"};
        m = new String[]{"Exposure", "Contrast", "Saturation", "ColorTemp", "Hue", "VIGNETTING", "SHARPEN"};
    }
}

