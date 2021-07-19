/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.bean;

public final class TextureFormat
extends Enum {
    public static final /* enum */ TextureFormat NV21;
    public static final /* enum */ TextureFormat RGBA;
    public static final /* enum */ TextureFormat YUV420P;
    private static final /* synthetic */ TextureFormat[] a;
    private final String formaDescription;
    private final int formatValue;

    static {
        TextureFormat textureFormat;
        TextureFormat textureFormat2;
        TextureFormat textureFormat3;
        int n10 = 1;
        NV21 = textureFormat3 = new TextureFormat("NV21", 0, n10, "nv21 data");
        int n11 = 2;
        YUV420P = textureFormat2 = new TextureFormat("YUV420P", n10, n11, "yuv420p(I420)");
        int n12 = 3;
        RGBA = textureFormat = new TextureFormat("RGBA", n11, n12, "rgba");
        TextureFormat[] textureFormatArray = new TextureFormat[n12];
        textureFormatArray[0] = textureFormat3;
        textureFormatArray[n10] = textureFormat2;
        textureFormatArray[n11] = textureFormat;
        a = textureFormatArray;
    }

    /*
     * WARNING - void declaration
     */
    private TextureFormat() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.formatValue = var3_1;
        this.formaDescription = var4_2;
    }

    public static TextureFormat valueOf(String string2) {
        return Enum.valueOf(TextureFormat.class, string2);
    }

    public static TextureFormat[] values() {
        return (TextureFormat[])a.clone();
    }
}

