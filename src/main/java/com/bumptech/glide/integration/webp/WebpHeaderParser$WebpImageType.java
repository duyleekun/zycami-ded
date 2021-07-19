/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp;

public final class WebpHeaderParser$WebpImageType
extends Enum {
    public static final /* enum */ WebpHeaderParser$WebpImageType NONE_WEBP;
    public static final /* enum */ WebpHeaderParser$WebpImageType WEBP_EXTENDED;
    public static final /* enum */ WebpHeaderParser$WebpImageType WEBP_EXTENDED_ANIMATED;
    public static final /* enum */ WebpHeaderParser$WebpImageType WEBP_EXTENDED_WITH_ALPHA;
    public static final /* enum */ WebpHeaderParser$WebpImageType WEBP_LOSSLESS;
    public static final /* enum */ WebpHeaderParser$WebpImageType WEBP_LOSSLESS_WITH_ALPHA;
    public static final /* enum */ WebpHeaderParser$WebpImageType WEBP_SIMPLE;
    private static final /* synthetic */ WebpHeaderParser$WebpImageType[] a;
    private final boolean hasAlpha;
    private final boolean hasAnimation;

    static {
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType2;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType3;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType4;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType5;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType6;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType7;
        WEBP_SIMPLE = webpHeaderParser$WebpImageType7 = new WebpHeaderParser$WebpImageType("WEBP_SIMPLE", 0, false, false);
        int n10 = 1;
        WEBP_LOSSLESS = webpHeaderParser$WebpImageType6 = new WebpHeaderParser$WebpImageType("WEBP_LOSSLESS", n10, false, false);
        int n11 = 2;
        WEBP_LOSSLESS_WITH_ALPHA = webpHeaderParser$WebpImageType5 = new WebpHeaderParser$WebpImageType("WEBP_LOSSLESS_WITH_ALPHA", n11, n10 != 0, false);
        int n12 = 3;
        WEBP_EXTENDED = webpHeaderParser$WebpImageType4 = new WebpHeaderParser$WebpImageType("WEBP_EXTENDED", n12, false, false);
        int n13 = 4;
        WEBP_EXTENDED_WITH_ALPHA = webpHeaderParser$WebpImageType3 = new WebpHeaderParser$WebpImageType("WEBP_EXTENDED_WITH_ALPHA", n13, n10 != 0, false);
        int n14 = 5;
        WEBP_EXTENDED_ANIMATED = webpHeaderParser$WebpImageType2 = new WebpHeaderParser$WebpImageType("WEBP_EXTENDED_ANIMATED", n14, false, n10 != 0);
        int n15 = 6;
        NONE_WEBP = webpHeaderParser$WebpImageType = new WebpHeaderParser$WebpImageType("NONE_WEBP", n15, false, false);
        WebpHeaderParser$WebpImageType[] webpHeaderParser$WebpImageTypeArray = new WebpHeaderParser$WebpImageType[7];
        webpHeaderParser$WebpImageTypeArray[0] = webpHeaderParser$WebpImageType7;
        webpHeaderParser$WebpImageTypeArray[n10] = webpHeaderParser$WebpImageType6;
        webpHeaderParser$WebpImageTypeArray[n11] = webpHeaderParser$WebpImageType5;
        webpHeaderParser$WebpImageTypeArray[n12] = webpHeaderParser$WebpImageType4;
        webpHeaderParser$WebpImageTypeArray[n13] = webpHeaderParser$WebpImageType3;
        webpHeaderParser$WebpImageTypeArray[n14] = webpHeaderParser$WebpImageType2;
        webpHeaderParser$WebpImageTypeArray[n15] = webpHeaderParser$WebpImageType;
        a = webpHeaderParser$WebpImageTypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private WebpHeaderParser$WebpImageType() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.hasAlpha = var3_1;
        this.hasAnimation = var4_2;
    }

    public static WebpHeaderParser$WebpImageType valueOf(String string2) {
        return Enum.valueOf(WebpHeaderParser$WebpImageType.class, string2);
    }

    public static WebpHeaderParser$WebpImageType[] values() {
        return (WebpHeaderParser$WebpImageType[])a.clone();
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }

    public boolean hasAnimation() {
        return this.hasAnimation;
    }
}

