/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy$CacheControl;
import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy$a;
import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy$b;

public final class WebpFrameCacheStrategy {
    public static final WebpFrameCacheStrategy c;
    public static final WebpFrameCacheStrategy d;
    public static final WebpFrameCacheStrategy e;
    private WebpFrameCacheStrategy$CacheControl a;
    private int b;

    static {
        WebpFrameCacheStrategy$b webpFrameCacheStrategy$b = new WebpFrameCacheStrategy$b();
        c = webpFrameCacheStrategy$b.i().c();
        webpFrameCacheStrategy$b = new WebpFrameCacheStrategy$b();
        d = webpFrameCacheStrategy$b.e().c();
        webpFrameCacheStrategy$b = new WebpFrameCacheStrategy$b();
        e = webpFrameCacheStrategy$b.d().c();
    }

    private WebpFrameCacheStrategy(WebpFrameCacheStrategy$b webpFrameCacheStrategy$b) {
        int n10;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl;
        this.a = webpFrameCacheStrategy$CacheControl = WebpFrameCacheStrategy$b.a(webpFrameCacheStrategy$b);
        this.b = n10 = WebpFrameCacheStrategy$b.b(webpFrameCacheStrategy$b);
    }

    public /* synthetic */ WebpFrameCacheStrategy(WebpFrameCacheStrategy$b webpFrameCacheStrategy$b, WebpFrameCacheStrategy$a webpFrameCacheStrategy$a) {
        this(webpFrameCacheStrategy$b);
    }

    public boolean a() {
        boolean bl2;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl = this.a;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl2 = WebpFrameCacheStrategy$CacheControl.CACHE_ALL;
        if (webpFrameCacheStrategy$CacheControl == webpFrameCacheStrategy$CacheControl2) {
            bl2 = true;
        } else {
            bl2 = false;
            webpFrameCacheStrategy$CacheControl = null;
        }
        return bl2;
    }

    public boolean b() {
        boolean bl2;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl = this.a;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl2 = WebpFrameCacheStrategy$CacheControl.CACHE_AUTO;
        if (webpFrameCacheStrategy$CacheControl == webpFrameCacheStrategy$CacheControl2) {
            bl2 = true;
        } else {
            bl2 = false;
            webpFrameCacheStrategy$CacheControl = null;
        }
        return bl2;
    }

    public WebpFrameCacheStrategy$CacheControl c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public boolean e() {
        boolean bl2;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl = this.a;
        WebpFrameCacheStrategy$CacheControl webpFrameCacheStrategy$CacheControl2 = WebpFrameCacheStrategy$CacheControl.CACHE_NONE;
        if (webpFrameCacheStrategy$CacheControl == webpFrameCacheStrategy$CacheControl2) {
            bl2 = true;
        } else {
            bl2 = false;
            webpFrameCacheStrategy$CacheControl = null;
        }
        return bl2;
    }
}

