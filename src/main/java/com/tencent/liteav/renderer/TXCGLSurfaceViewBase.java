/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.opengl.GLSurfaceView$Renderer
 *  android.util.AttributeSet
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 */
package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$1;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$2;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$3;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$b;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$c;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$d;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$e;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$f;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$g;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$i;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$k;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$m;
import java.lang.ref.WeakReference;

public class TXCGLSurfaceViewBase
extends SurfaceView
implements SurfaceHolder.Callback {
    private static final TXCGLSurfaceViewBase$j a;
    public boolean b = false;
    public boolean c = false;
    public final WeakReference d;
    public boolean e;
    public boolean f;
    private TXCGLSurfaceViewBase$i g;
    private GLSurfaceView.Renderer h;
    private boolean i;
    private TXCGLSurfaceViewBase$e j;
    private TXCGLSurfaceViewBase$f k;
    private TXCGLSurfaceViewBase$g l;
    private TXCGLSurfaceViewBase$k m;
    private int n;
    private int o;
    private boolean p;

    static {
        TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j;
        a = tXCGLSurfaceViewBase$j = new TXCGLSurfaceViewBase$j(null);
    }

    public TXCGLSurfaceViewBase(Context object) {
        super(object);
        super(this);
        this.d = object;
        this.a();
    }

    public TXCGLSurfaceViewBase(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        super(this);
        this.d = object;
        this.a();
    }

    private void a() {
        this.getHolder().addCallback((SurfaceHolder.Callback)this);
    }

    public static /* synthetic */ boolean a(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.p;
    }

    public static /* synthetic */ GLSurfaceView.Renderer b(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.h;
    }

    public static /* synthetic */ TXCGLSurfaceViewBase$e c(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.j;
    }

    public static /* synthetic */ TXCGLSurfaceViewBase$f d(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.k;
    }

    public static /* synthetic */ TXCGLSurfaceViewBase$g e(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.l;
    }

    public static /* synthetic */ TXCGLSurfaceViewBase$j f() {
        return a;
    }

    public static /* synthetic */ TXCGLSurfaceViewBase$k f(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.m;
    }

    public static /* synthetic */ int g(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.n;
    }

    private void g() {
        Object object = this.g;
        if (object == null) {
            return;
        }
        object = new IllegalStateException("setRenderer has already been called for this instance.");
        throw object;
    }

    public static /* synthetic */ int h(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        return tXCGLSurfaceViewBase.o;
    }

    public void a(int n10, int n11, int n12, int n13, int n14, int n15) {
        TXCGLSurfaceViewBase$b tXCGLSurfaceViewBase$b = new TXCGLSurfaceViewBase$b(this, n10, n11, n12, n13, n14, n15);
        this.setEGLConfigChooser(tXCGLSurfaceViewBase$b);
    }

    public void b() {
    }

    public void b(boolean bl2) {
        TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i;
        this.b = bl2;
        if (!bl2 && (bl2 = this.c) && (tXCGLSurfaceViewBase$i = this.g) != null) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
            tXCGLSurfaceViewBase$i = this.g;
            TXCGLSurfaceViewBase$2 tXCGLSurfaceViewBase$2 = new TXCGLSurfaceViewBase$2(this);
            tXCGLSurfaceViewBase$i.a(tXCGLSurfaceViewBase$2);
            tXCGLSurfaceViewBase$i = this.g;
            tXCGLSurfaceViewBase$i.g();
        }
    }

    public int c() {
        return 0;
    }

    public boolean d() {
        return this.g.a();
    }

    public int e() {
        return this.g.b();
    }

    public void finalize() {
        block4: {
            TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i = this.g;
            if (tXCGLSurfaceViewBase$i == null) break block4;
            tXCGLSurfaceViewBase$i.h();
        }
        return;
        finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.n;
    }

    public TXCGLSurfaceViewBase$h getEGLHelper() {
        return this.g.c();
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.p;
    }

    public int getRenderMode() {
        return this.g.e();
    }

    public void onAttachedToWindow() {
        Object object;
        super.onAttachedToWindow();
        int n10 = this.i;
        if (n10 != 0 && (object = this.h) != null) {
            TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i;
            object = this.g;
            int n11 = 1;
            n10 = object != null ? ((TXCGLSurfaceViewBase$i)object).e() : n11;
            WeakReference weakReference = this.d;
            this.g = tXCGLSurfaceViewBase$i = new TXCGLSurfaceViewBase$i(weakReference);
            if (n10 != n11) {
                tXCGLSurfaceViewBase$i.a(n10);
            }
            object = this.g;
            ((Thread)object).start();
        }
        this.i = false;
    }

    public void onDetachedFromWindow() {
        TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i;
        boolean bl2 = this.b;
        if (bl2 && (tXCGLSurfaceViewBase$i = this.g) != null) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when onDetachedFromWindow");
            tXCGLSurfaceViewBase$i = this.g;
            TXCGLSurfaceViewBase$3 tXCGLSurfaceViewBase$3 = new TXCGLSurfaceViewBase$3(this);
            tXCGLSurfaceViewBase$i.a(tXCGLSurfaceViewBase$3);
            tXCGLSurfaceViewBase$i = this.g;
            tXCGLSurfaceViewBase$i.g();
        }
        if ((tXCGLSurfaceViewBase$i = this.g) != null) {
            tXCGLSurfaceViewBase$i.h();
        }
        this.i = true;
        super.onDetachedFromWindow();
    }

    public void setDebugFlags(int n10) {
        this.n = n10;
    }

    public void setEGLConfigChooser(TXCGLSurfaceViewBase$e tXCGLSurfaceViewBase$e) {
        this.g();
        this.j = tXCGLSurfaceViewBase$e;
    }

    public void setEGLConfigChooser(boolean bl2) {
        TXCGLSurfaceViewBase$m tXCGLSurfaceViewBase$m = new TXCGLSurfaceViewBase$m(this, bl2);
        this.setEGLConfigChooser(tXCGLSurfaceViewBase$m);
    }

    public void setEGLContextClientVersion(int n10) {
        this.g();
        this.o = n10;
    }

    public void setEGLContextFactory(TXCGLSurfaceViewBase$f tXCGLSurfaceViewBase$f) {
        this.g();
        this.k = tXCGLSurfaceViewBase$f;
    }

    public void setEGLWindowSurfaceFactory(TXCGLSurfaceViewBase$g tXCGLSurfaceViewBase$g) {
        this.g();
        this.l = tXCGLSurfaceViewBase$g;
    }

    public void setGLWrapper(TXCGLSurfaceViewBase$k tXCGLSurfaceViewBase$k) {
        this.m = tXCGLSurfaceViewBase$k;
    }

    public void setPreserveEGLContextOnPause(boolean bl2) {
        this.p = bl2;
    }

    public void setRenderMode(int n10) {
        this.g.a(n10);
    }

    public void setRenderer(GLSurfaceView.Renderer object) {
        boolean bl2;
        this.g();
        Object object2 = this.j;
        if (object2 == null) {
            bl2 = true;
            this.j = object2 = new TXCGLSurfaceViewBase$m(this, bl2);
        }
        object2 = this.k;
        bl2 = false;
        if (object2 == null) {
            this.k = object2 = new TXCGLSurfaceViewBase$c(this, null);
        }
        if ((object2 = this.l) == null) {
            this.l = object2 = new TXCGLSurfaceViewBase$d(null);
        }
        this.h = object;
        object2 = this.d;
        object = new TXCGLSurfaceViewBase$i((WeakReference)object2);
        this.g = object;
        ((Thread)object).start();
        TXCLog.i("TXCGLSurfaceViewBase", "setRenderer-->mGLThread.start");
    }

    public void setRunInBackground(boolean bl2) {
        this.c = bl2;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n10, int n11, int n12) {
        this.g.a(n11, n12);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.g.f();
        this.setRunInBackground(false);
    }

    public void surfaceDestroyed(SurfaceHolder object) {
        this.setRunInBackground(true);
        boolean bl2 = this.b;
        if (!bl2) {
            object = this.g;
            TXCGLSurfaceViewBase$1 tXCGLSurfaceViewBase$1 = new TXCGLSurfaceViewBase$1(this);
            ((TXCGLSurfaceViewBase$i)object).a(tXCGLSurfaceViewBase$1);
            object = this.g;
            ((TXCGLSurfaceViewBase$i)object).g();
        }
    }
}

