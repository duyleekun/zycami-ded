/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy;
import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy$CacheControl;

public final class WebpFrameCacheStrategy$b {
    private WebpFrameCacheStrategy$CacheControl a;
    private int b;

    public static /* synthetic */ WebpFrameCacheStrategy$CacheControl a(WebpFrameCacheStrategy$b webpFrameCacheStrategy$b) {
        return webpFrameCacheStrategy$b.a;
    }

    public static /* synthetic */ int b(WebpFrameCacheStrategy$b webpFrameCacheStrategy$b) {
        return webpFrameCacheStrategy$b.b;
    }

    public WebpFrameCacheStrategy c() {
        WebpFrameCacheStrategy webpFrameCacheStrategy = new WebpFrameCacheStrategy(this, null);
        return webpFrameCacheStrategy;
    }

    public WebpFrameCacheStrategy$b d() {
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl;
        this.a = webpFrameCacheStrategy$CacheControl = WebpFrameCacheStrategy$CacheControl.CACHE_ALL;
        return this;
    }

    public WebpFrameCacheStrategy$b e() {
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl;
        this.a = webpFrameCacheStrategy$CacheControl = WebpFrameCacheStrategy$CacheControl.CACHE_AUTO;
        return this;
    }

    public WebpFrameCacheStrategy$b f(WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl) {
        this.a = webpFrameCacheStrategy$CacheControl;
        return this;
    }

    public WebpFrameCacheStrategy$b g() {
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl;
        this.a = webpFrameCacheStrategy$CacheControl = WebpFrameCacheStrategy$CacheControl.CACHE_LIMITED;
        return this;
    }

    public WebpFrameCacheStrategy$b h(int n10) {
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl2;
        int n11;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl3;
        this.b = n10;
        this.a = n10 == 0 ? (webpFrameCacheStrategy$CacheControl3 = WebpFrameCacheStrategy$CacheControl.CACHE_NONE) : (n10 == (n11 = -1 >>> 1) ? (webpFrameCacheStrategy$CacheControl2 = WebpFrameCacheStrategy$CacheControl.CACHE_ALL) : (webpFrameCacheStrategy$CacheControl = WebpFrameCacheStrategy$CacheControl.CACHE_LIMITED));
        return this;
    }

    public WebpFrameCacheStrategy$b i() {
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl;
        this.a = webpFrameCacheStrategy$CacheControl = WebpFrameCacheStrategy$CacheControl.CACHE_NONE;
        return this;
    }
}

