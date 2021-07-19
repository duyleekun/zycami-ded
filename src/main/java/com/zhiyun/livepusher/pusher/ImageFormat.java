/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.livepusher.pusher;

public final class ImageFormat
extends Enum {
    public static final /* enum */ ImageFormat NV12;
    public static final /* enum */ ImageFormat NV21;
    public static final /* enum */ ImageFormat RGB_BGRA;
    public static final /* enum */ ImageFormat RGB_RGBA;
    public static final /* enum */ ImageFormat YUV420P;
    private static final /* synthetic */ ImageFormat[] a;
    private String description;
    private int value;

    static {
        ImageFormat imageFormat;
        ImageFormat imageFormat2;
        ImageFormat imageFormat3;
        ImageFormat imageFormat4;
        int n10 = 1;
        NV21 = imageFormat4 = new ImageFormat("NV21", 0, n10, "nv21(YUV_420SP  YUV_420YpCrCb data");
        int n11 = 2;
        NV12 = imageFormat3 = new ImageFormat("NV12", n10, n11, "nv12(YUV_420SP  YUV_420YpCbCr data");
        int n12 = 3;
        YUV420P = imageFormat2 = new ImageFormat("YUV420P", n11, n12, "yuv420P");
        Object object = "RGB_BGRA";
        int n13 = 4;
        RGB_BGRA = imageFormat = new ImageFormat(object, n12, n13, object);
        ImageFormat[] imageFormatArray = "RGB_RGBA";
        int n14 = 5;
        object = new ImageFormat((String)imageFormatArray, n13, n14, (String)imageFormatArray);
        RGB_RGBA = object;
        imageFormatArray = new ImageFormat[n14];
        imageFormatArray[0] = imageFormat4;
        imageFormatArray[n10] = imageFormat3;
        imageFormatArray[n11] = imageFormat2;
        imageFormatArray[n12] = imageFormat;
        imageFormatArray[n13] = object;
        a = imageFormatArray;
    }

    /*
     * WARNING - void declaration
     */
    private ImageFormat() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
        this.description = var4_2;
    }

    public static ImageFormat valueOf(String string2) {
        return Enum.valueOf(ImageFormat.class, string2);
    }

    public static ImageFormat[] values() {
        return (ImageFormat[])a.clone();
    }
}

