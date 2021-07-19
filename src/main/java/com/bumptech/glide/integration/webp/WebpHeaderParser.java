/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.os.Build$VERSION
 *  android.util.Base64
 */
package com.bumptech.glide.integration.webp;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import com.bumptech.glide.integration.webp.WebpHeaderParser$WebpImageType;
import com.bumptech.glide.integration.webp.WebpHeaderParser$a;
import com.bumptech.glide.integration.webp.WebpHeaderParser$b;
import com.bumptech.glide.integration.webp.WebpHeaderParser$c;
import com.bumptech.glide.integration.webp.WebpHeaderParser$d;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import d.c.a.o.k.x.b;
import d.c.a.u.k;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class WebpHeaderParser {
    public static final int a = 21;
    private static final int b = 1380533830;
    private static final int c = 1464156752;
    private static final int d = 1448097824;
    private static final int e = 1448097868;
    private static final int f = 1448097880;
    private static final int g = 16;
    private static final int h = 2;
    private static final int i = 8;
    private static final String j = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    public static final boolean k = WebpHeaderParser.g();

    private static WebpHeaderParser$WebpImageType a(WebpHeaderParser$c object) {
        int n10 = object.a() << 16;
        int n11 = -65536;
        n10 &= n11;
        int n12 = object.a();
        char c10 = (char)-1;
        n12 &= c10;
        if ((n10 |= n12) != (n12 = 1380533830)) {
            return WebpHeaderParser$WebpImageType.NONE_WEBP;
        }
        long l10 = 4;
        object.skip(l10);
        n10 = object.a() << 16 & n11;
        n12 = object.a() & c10;
        n10 |= n12;
        n12 = 1464156752;
        if (n10 != n12) {
            return WebpHeaderParser$WebpImageType.NONE_WEBP;
        }
        n10 = object.a() << 16 & n11;
        n11 = object.a() & c10;
        if ((n10 |= n11) == (n11 = 1448097824)) {
            return WebpHeaderParser$WebpImageType.WEBP_SIMPLE;
        }
        n11 = 1448097868;
        if (n10 == n11) {
            object.skip(l10);
            int n13 = object.c() & 8;
            object = n13 != 0 ? WebpHeaderParser$WebpImageType.WEBP_LOSSLESS_WITH_ALPHA : WebpHeaderParser$WebpImageType.WEBP_LOSSLESS;
            return object;
        }
        n11 = 1448097880;
        if (n10 == n11) {
            object.skip(l10);
            int n14 = object.c();
            n10 = n14 & 2;
            if (n10 != 0) {
                return WebpHeaderParser$WebpImageType.WEBP_EXTENDED_ANIMATED;
            }
            if ((n14 &= 0x10) != 0) {
                return WebpHeaderParser$WebpImageType.WEBP_EXTENDED_WITH_ALPHA;
            }
            return WebpHeaderParser$WebpImageType.WEBP_EXTENDED;
        }
        return WebpHeaderParser$WebpImageType.NONE_WEBP;
    }

    public static WebpHeaderParser$WebpImageType b(InputStream inputStream, b object) {
        Object object2;
        if (inputStream == null) {
            return WebpHeaderParser$WebpImageType.NONE_WEBP;
        }
        boolean bl2 = inputStream.markSupported();
        if (!bl2) {
            object2 = new RecyclableBufferedInputStream(inputStream, (b)object);
            inputStream = object2;
        }
        int n10 = 21;
        inputStream.mark(n10);
        try {
            object2 = d.c.a.u.k.d(inputStream);
            object2 = (InputStream)object2;
            object = new WebpHeaderParser$d((InputStream)object2);
            object = WebpHeaderParser.a((WebpHeaderParser$c)object);
            return object;
        }
        finally {
            inputStream.reset();
        }
    }

    public static WebpHeaderParser$WebpImageType c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return WebpHeaderParser$WebpImageType.NONE_WEBP;
        }
        byteBuffer = (ByteBuffer)d.c.a.u.k.d(byteBuffer);
        WebpHeaderParser$b webpHeaderParser$b = new WebpHeaderParser$b(byteBuffer);
        return WebpHeaderParser.a(webpHeaderParser$b);
    }

    public static WebpHeaderParser$WebpImageType d(byte[] byArray) {
        int n10 = byArray.length;
        return WebpHeaderParser.e(byArray, 0, n10);
    }

    public static WebpHeaderParser$WebpImageType e(byte[] byArray, int n10, int n11) {
        WebpHeaderParser$a webpHeaderParser$a = new WebpHeaderParser$a(byArray, n10, n11);
        return WebpHeaderParser.a(webpHeaderParser$a);
    }

    public static boolean f(WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType) {
        boolean bl2;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.WEBP_EXTENDED_ANIMATED;
        if (webpHeaderParser$WebpImageType == webpHeaderParser$WebpImageType2) {
            bl2 = true;
        } else {
            bl2 = false;
            webpHeaderParser$WebpImageType = null;
        }
        return bl2;
    }

    public static boolean g() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 < n11) {
            return false;
        }
        int n12 = 1;
        if (n10 == n11) {
            byte[] byArray = Base64.decode((String)j, (int)0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = n12;
            int n13 = byArray.length;
            BitmapFactory.decodeByteArray((byte[])byArray, (int)0, (int)n13, (BitmapFactory.Options)options);
            n10 = options.outHeight;
            if (n10 != n12 || (n10 = options.outWidth) != n12) {
                return false;
            }
        }
        return n12 != 0;
    }

    public static boolean h(WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType) {
        boolean bl2;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.NONE_WEBP;
        if (webpHeaderParser$WebpImageType != webpHeaderParser$WebpImageType2 && webpHeaderParser$WebpImageType != (webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.WEBP_SIMPLE)) {
            bl2 = true;
        } else {
            bl2 = false;
            webpHeaderParser$WebpImageType = null;
        }
        return bl2;
    }

    public static boolean i(WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType) {
        boolean bl2;
        WebpHeaderParser$WebpImageType webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.WEBP_SIMPLE;
        if (webpHeaderParser$WebpImageType != webpHeaderParser$WebpImageType2 && webpHeaderParser$WebpImageType != (webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.WEBP_LOSSLESS) && webpHeaderParser$WebpImageType != (webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.WEBP_LOSSLESS_WITH_ALPHA) && webpHeaderParser$WebpImageType != (webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.WEBP_EXTENDED) && webpHeaderParser$WebpImageType != (webpHeaderParser$WebpImageType2 = WebpHeaderParser$WebpImageType.WEBP_EXTENDED_WITH_ALPHA)) {
            bl2 = false;
            webpHeaderParser$WebpImageType = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

