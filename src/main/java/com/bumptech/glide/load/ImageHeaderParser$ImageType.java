/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load;

public final class ImageHeaderParser$ImageType
extends Enum {
    private static final /* synthetic */ ImageHeaderParser$ImageType[] $VALUES;
    public static final /* enum */ ImageHeaderParser$ImageType GIF;
    public static final /* enum */ ImageHeaderParser$ImageType JPEG;
    public static final /* enum */ ImageHeaderParser$ImageType PNG;
    public static final /* enum */ ImageHeaderParser$ImageType PNG_A;
    public static final /* enum */ ImageHeaderParser$ImageType RAW;
    public static final /* enum */ ImageHeaderParser$ImageType UNKNOWN;
    public static final /* enum */ ImageHeaderParser$ImageType WEBP;
    public static final /* enum */ ImageHeaderParser$ImageType WEBP_A;
    private final boolean hasAlpha;

    static {
        ImageHeaderParser$ImageType imageHeaderParser$ImageType;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType2;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType3;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType4;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType5;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType6;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType7;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType8;
        int n10 = 1;
        GIF = imageHeaderParser$ImageType8 = new ImageHeaderParser$ImageType("GIF", 0, n10 != 0);
        JPEG = imageHeaderParser$ImageType7 = new ImageHeaderParser$ImageType("JPEG", n10, false);
        int n11 = 2;
        RAW = imageHeaderParser$ImageType6 = new ImageHeaderParser$ImageType("RAW", n11, false);
        int n12 = 3;
        PNG_A = imageHeaderParser$ImageType5 = new ImageHeaderParser$ImageType("PNG_A", n12, n10 != 0);
        int n13 = 4;
        PNG = imageHeaderParser$ImageType4 = new ImageHeaderParser$ImageType("PNG", n13, false);
        int n14 = 5;
        WEBP_A = imageHeaderParser$ImageType3 = new ImageHeaderParser$ImageType("WEBP_A", n14, n10 != 0);
        WEBP = imageHeaderParser$ImageType2 = new ImageHeaderParser$ImageType("WEBP", 6, false);
        int n15 = 7;
        UNKNOWN = imageHeaderParser$ImageType = new ImageHeaderParser$ImageType("UNKNOWN", n15, false);
        ImageHeaderParser$ImageType[] imageHeaderParser$ImageTypeArray = new ImageHeaderParser$ImageType[8];
        imageHeaderParser$ImageTypeArray[0] = imageHeaderParser$ImageType8;
        imageHeaderParser$ImageTypeArray[n10] = imageHeaderParser$ImageType7;
        imageHeaderParser$ImageTypeArray[n11] = imageHeaderParser$ImageType6;
        imageHeaderParser$ImageTypeArray[n12] = imageHeaderParser$ImageType5;
        imageHeaderParser$ImageTypeArray[n13] = imageHeaderParser$ImageType4;
        imageHeaderParser$ImageTypeArray[n14] = imageHeaderParser$ImageType3;
        imageHeaderParser$ImageTypeArray[6] = imageHeaderParser$ImageType2;
        imageHeaderParser$ImageTypeArray[n15] = imageHeaderParser$ImageType;
        $VALUES = imageHeaderParser$ImageTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ImageHeaderParser$ImageType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.hasAlpha = var3_1;
    }

    public static ImageHeaderParser$ImageType valueOf(String string2) {
        return Enum.valueOf(ImageHeaderParser$ImageType.class, string2);
    }

    public static ImageHeaderParser$ImageType[] values() {
        return (ImageHeaderParser$ImageType[])$VALUES.clone();
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }
}

