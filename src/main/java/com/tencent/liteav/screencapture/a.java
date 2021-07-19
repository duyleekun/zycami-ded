/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.screencapture;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.screencapture.a$2;
import com.tencent.liteav.screencapture.a$3;
import com.tencent.liteav.screencapture.a$a;
import com.tencent.liteav.screencapture.a$b;
import com.tencent.liteav.screencapture.b;
import com.tencent.liteav.screencapture.c$b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLContext;

public class a {
    public final Handler a;
    public volatile HandlerThread b = null;
    public volatile a$b c = null;
    public volatile WeakReference d = null;
    public volatile int e = 0;
    public int f;
    public int g;
    public int h;
    public boolean i;
    private final boolean j;
    private final Context k;
    private Object l;
    private int m;
    private int n;
    private WeakReference o;
    private WeakReference p;
    private c$b q;

    public a(Context context, boolean bl2, a$a a$a) {
        int n10;
        int n11;
        this.f = n11 = 720;
        this.g = n10 = 1280;
        this.h = 20;
        this.i = true;
        this.l = null;
        this.m = n11;
        this.n = n10;
        this.o = null;
        WeakReference<a$a> weakReference = new WeakReference<a$a>(this);
        this.q = weakReference;
        this.p = weakReference = new WeakReference<a$a>(a$a);
        this.k = context = context.getApplicationContext();
        a$a = Looper.getMainLooper();
        super((Looper)a$a);
        this.a = context;
        this.j = bl2;
    }

    public static /* synthetic */ WeakReference a(a a10) {
        return a10.o;
    }

    public static /* synthetic */ WeakReference a(a a10, WeakReference weakReference) {
        a10.p = weakReference;
        return weakReference;
    }

    public static /* synthetic */ a$a b(a a10) {
        return a10.d();
    }

    private void c(int n10, int n11) {
        int n12 = this.j;
        if (n12 != 0) {
            int n13;
            Context context = this.k;
            n12 = com.tencent.liteav.basic.util.g.f(context);
            if (n12 != 0 && n12 != (n13 = 2)) {
                if (n10 < n11) {
                    this.f = n11;
                    this.g = n10;
                } else {
                    this.f = n10;
                    this.g = n11;
                }
            } else if (n10 > n11) {
                this.f = n11;
                this.g = n10;
            } else {
                this.f = n10;
                this.g = n11;
            }
        } else {
            this.f = n10;
            this.g = n11;
        }
        this.m = n10 = this.f;
        this.n = n10 = this.g;
    }

    public static /* synthetic */ boolean c(a a10) {
        return a10.j;
    }

    public static /* synthetic */ int d(a a10) {
        return a10.m;
    }

    private a$a d() {
        Object object = this.p;
        object = object != null ? (a$a)((Reference)object).get() : null;
        return object;
    }

    public static /* synthetic */ int e(a a10) {
        return a10.n;
    }

    public static /* synthetic */ Object f(a a10) {
        return a10.l;
    }

    public static /* synthetic */ Context g(a a10) {
        return a10.k;
    }

    public static /* synthetic */ c$b h(a a10) {
        return a10.q;
    }

    public int a(int n10, int n11, int n12) {
        this.h = n12;
        n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 < n13) {
            n10 = 20000004;
            this.c(n10);
            return n10;
        }
        this.c(n10, n11);
        this.a();
        TXCLog.i("TXCScreenCapture", "start screen capture");
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        this.b();
        synchronized (this) {
            int n10;
            Object object;
            String string2 = "ScreenCaptureGLThread";
            object = this.b = (object = new HandlerThread(string2));
            object.start();
            string2 = this.b;
            string2 = string2.getLooper();
            object = new a$b(this, (Looper)string2, this);
            this.c = object;
            int n11 = this.e;
            int n12 = 1;
            this.e = n11 += n12;
            object = this.c;
            object.a = n10 = this.e;
            object = this.c;
            object.e = n10 = this.m;
            object = this.c;
            object.f = n10 = this.n;
            object = this.c;
            n10 = this.h;
            if (n10 >= n12) {
                n12 = n10;
            }
            object.g = n12;
        }
        this.b(100);
    }

    public void a(int n10) {
        this.h = n10;
        this.b(103, n10);
    }

    public void a(int n10, int n11) {
        this.c(n10, n11);
        this.b(105, n10, n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, long l10) {
        synchronized (this) {
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = this.c;
                a$b.sendEmptyMessageDelayed(n10, l10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, Runnable runnable) {
        synchronized (this) {
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = new Message();
                ((Message)a$b).what = n10;
                ((Message)a$b).obj = runnable;
                a$b a$b2 = this.c;
                a$b2.sendMessage((Message)a$b);
            }
            return;
        }
    }

    public void a(int n10, EGLContext eGLContext, int n11, int n12, int n13, long l10) {
        b b10 = this.c();
        if (b10 != null) {
            b10.a(n10, eGLContext, n11, n12, n13, l10);
        }
    }

    public void a(com.tencent.liteav.basic.b.b b10) {
        WeakReference<com.tencent.liteav.basic.b.b> weakReference;
        this.o = weakReference = new WeakReference<com.tencent.liteav.basic.b.b>(b10);
    }

    public void a(b b10) {
        WeakReference<b> weakReference;
        this.d = weakReference = new WeakReference<b>(b10);
    }

    public void a(Object object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("stop encode: ");
        charSequence.append(object);
        charSequence = charSequence.toString();
        TXCLog.i("TXCScreenCapture", (String)charSequence);
        this.l = object;
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable runnable) {
        synchronized (this) {
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = this.c;
                a$b.post(runnable);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        synchronized (this) {
            a$2 a$2 = new a$2(this, bl2);
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = this.c;
                a$b.post(a$2);
            } else {
                a$2.run();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        synchronized (this) {
            int n10;
            this.e = n10 = this.e + 1;
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = this.b;
                a$b a$b2 = this.c;
                int n11 = 101;
                a$3 a$3 = new a$3(this, a$b2, (HandlerThread)a$b);
                this.a(n11, a$3);
            }
            n10 = 0;
            a$b = null;
            this.c = null;
            this.b = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(int n10) {
        synchronized (this) {
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = this.c;
                a$b.sendEmptyMessage(n10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(int n10, int n11) {
        synchronized (this) {
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = new Message();
                ((Message)a$b).what = n10;
                ((Message)a$b).arg1 = n11;
                a$b a$b2 = this.c;
                a$b2.sendMessage((Message)a$b);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(int n10, int n11, int n12) {
        synchronized (this) {
            a$b a$b = this.c;
            if (a$b != null) {
                a$b = new Message();
                ((Message)a$b).what = n10;
                ((Message)a$b).arg1 = n11;
                ((Message)a$b).arg2 = n12;
                a$b a$b2 = this.c;
                a$b2.sendMessage((Message)a$b);
            }
            return;
        }
    }

    public void b(boolean bl2) {
        Object object;
        if (bl2) {
            int n10 = this.f;
            int n11 = this.g;
            int n12 = n10 < n11 ? n10 : n11;
            this.m = n12;
            if (n10 < n11) {
                n10 = n11;
            }
            this.n = n10;
        } else {
            int n13 = this.f;
            int n14 = this.g;
            int n15 = n13 < n14 ? n14 : n13;
            this.m = n15;
            if (n13 >= n14) {
                n13 = n14;
            }
            this.n = n13;
        }
        Locale locale = Locale.ENGLISH;
        Object[] objectArray = new Object[3];
        objectArray[0] = object = Boolean.valueOf(bl2);
        Integer n16 = this.m;
        objectArray[1] = n16;
        n16 = this.n;
        objectArray[2] = n16;
        object = String.format(locale, "reset screen capture isPortrait[%b] output size[%d/%d]", objectArray);
        TXCLog.i("TXCScreenCapture", (String)object);
    }

    public b c() {
        Object object = this.d;
        object = object == null ? null : (b)this.d.get();
        return object;
    }

    public void c(int n10) {
        a$a a$a = this.d();
        if (a$a != null && n10 == 0) {
            a$a.a();
        }
    }
}

