/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp.decoder;

public final class WebpFrameCacheStrategy$CacheControl
extends Enum {
    public static final /* enum */ WebpFrameCacheStrategy$CacheControl CACHE_ALL;
    public static final /* enum */ WebpFrameCacheStrategy$CacheControl CACHE_AUTO;
    public static final /* enum */ WebpFrameCacheStrategy$CacheControl CACHE_LIMITED;
    public static final /* enum */ WebpFrameCacheStrategy$CacheControl CACHE_NONE;
    private static final /* synthetic */ WebpFrameCacheStrategy$CacheControl[] a;

    static {
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl2;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl3;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl4;
        CACHE_NONE = webpFrameCacheStrategy$CacheControl4 = new WebpFrameCacheStrategy$CacheControl("CACHE_NONE", 0);
        int n10 = 1;
        CACHE_LIMITED = webpFrameCacheStrategy$CacheControl3 = new WebpFrameCacheStrategy$CacheControl("CACHE_LIMITED", n10);
        int n11 = 2;
        CACHE_AUTO = webpFrameCacheStrategy$CacheControl2 = new WebpFrameCacheStrategy$CacheControl("CACHE_AUTO", n11);
        int n12 = 3;
        CACHE_ALL = webpFrameCacheStrategy$CacheControl = new WebpFrameCacheStrategy$CacheControl("CACHE_ALL", n12);
        WebpFrameCacheStrategy$CacheControl[] webpFrameCacheStrategy$CacheControlArray = new WebpFrameCacheStrategy$CacheControl[4];
        webpFrameCacheStrategy$CacheControlArray[0] = webpFrameCacheStrategy$CacheControl4;
        webpFrameCacheStrategy$CacheControlArray[n10] = webpFrameCacheStrategy$CacheControl3;
        webpFrameCacheStrategy$CacheControlArray[n11] = webpFrameCacheStrategy$CacheControl2;
        webpFrameCacheStrategy$CacheControlArray[n12] = webpFrameCacheStrategy$CacheControl;
        a = webpFrameCacheStrategy$CacheControlArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WebpFrameCacheStrategy$CacheControl() {
        void var2_-1;
        void var1_-1;
    }

    public static WebpFrameCacheStrategy$CacheControl valueOf(String string2) {
        return Enum.valueOf(WebpFrameCacheStrategy$CacheControl.class, string2);
    }

    public static WebpFrameCacheStrategy$CacheControl[] values() {
        return (WebpFrameCacheStrategy$CacheControl[])a.clone();
    }
}

