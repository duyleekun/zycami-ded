/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.BitmapRegionDecoder
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.a.a;
import com.tencent.rtmp.a.b$1;
import com.tencent.rtmp.a.b$a;
import com.tencent.rtmp.a.b$b;
import com.tencent.rtmp.a.c;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class b
implements a {
    private final BitmapFactory.Options a;
    private HandlerThread b;
    private Handler c;
    private List d;
    private Map e;

    public b() {
        Object object;
        this.a = object = new BitmapFactory.Options();
        this.d = object;
        object = Collections.synchronizedList(object);
        this.d = object;
        super();
        this.e = object;
        object = Collections.synchronizedMap(object);
        this.e = object;
    }

    private c a(int n10, int n11, float f10) {
        int n12 = (n11 - n10) / 2 + n10;
        c c10 = (c)this.d.get(n12);
        float f11 = c10.a;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object <= 0) {
            c10 = (c)this.d.get(n12);
            f11 = c10.b;
            float f13 = f11 - f10;
            object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object > 0) {
                return (c)this.d.get(n12);
            }
        }
        if (n10 >= n11) {
            return (c)this.d.get(n10);
        }
        c10 = (c)this.d.get(n12);
        f11 = c10.b;
        float f14 = f10 - f11;
        object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object >= 0) {
            return this.a(++n12, n11, f10);
        }
        c c11 = (c)this.d.get(n12);
        float f15 = c11.a;
        float f16 = f10 - f15;
        n11 = (int)(f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1));
        if (n11 < 0) {
            return this.a(n10, n12 += -1, f10);
        }
        return null;
    }

    public static /* synthetic */ InputStream a(b b10, String string2) {
        return b10.a(string2);
    }

    private InputStream a(String object) {
        URL uRL = new URL((String)object);
        object = (URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection());
        ((URLConnection)object).connect();
        ((URLConnection)object).getInputStream();
        int n10 = 15000;
        ((URLConnection)object).setConnectTimeout(n10);
        ((URLConnection)object).setReadTimeout(n10);
        return ((URLConnection)object).getInputStream();
    }

    public static /* synthetic */ List a(b b10) {
        return b10.d;
    }

    private void a() {
        HandlerThread handlerThread = this.b;
        if (handlerThread == null) {
            this.b = handlerThread = new HandlerThread("SuperVodThumbnailsWorkThread");
            handlerThread.start();
            Looper looper = this.b.getLooper();
            handlerThread = new Handler(looper);
            this.c = handlerThread;
        }
    }

    public static /* synthetic */ Map b(b b10) {
        return b10.e;
    }

    private void b() {
        Handler handler = this.c;
        if (handler != null) {
            TXCLog.i("TXImageSprite", " remove all tasks!");
            this.c.removeCallbacksAndMessages(null);
            handler = this.c;
            b$1 b$1 = new b$1(this);
            handler.post((Runnable)b$1);
        }
    }

    public static /* synthetic */ void c(b b10) {
        b10.b();
    }

    public Bitmap getThumbnail(float f10) {
        int n10;
        Object object = this.d;
        int n11 = object.size();
        Rect rect = null;
        if (n11 == 0) {
            return null;
        }
        n11 = 0;
        object = null;
        Object object2 = this.d;
        int n12 = object2.size() + -1;
        c c10 = this.a(0, n12, f10);
        if (c10 == null) {
            return null;
        }
        object = c10.d;
        object2 = this.e;
        if ((object = (BitmapRegionDecoder)object2.get(object)) == null) {
            return null;
        }
        rect = new Rect();
        rect.left = n12 = c10.e;
        rect.top = n10 = c10.f;
        int n13 = c10.g;
        rect.right = n12 += n13;
        int n14 = c10.h;
        rect.bottom = n10 += n14;
        c10 = this.a;
        return object.decodeRegion(rect, (BitmapFactory.Options)c10);
    }

    public void release() {
        Handler handler;
        this.b();
        HandlerThread handlerThread = this.b;
        if (handlerThread != null && (handler = this.c) != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            if (n10 >= n11) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
            handlerThread = null;
            this.c = null;
            this.b = null;
        }
    }

    public void setVTTUrlAndImageUrls(String string2, List object) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            TXCLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
            return;
        }
        this.b();
        this.a();
        Object object2 = this.c;
        b$a b$a = new b$a(this, string2);
        object2.post((Runnable)b$a);
        if (object != null && (n10 = object.size()) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (String)object.next();
                b$a = this.c;
                b$b b$b = new b$b(this, string2, (String)object2);
                b$a.post(b$b);
            }
        }
    }
}

