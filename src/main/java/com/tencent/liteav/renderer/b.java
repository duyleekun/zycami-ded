/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.opengl.EGLContext
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.c;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class b
extends Thread {
    private WeakReference a;
    private volatile boolean b = false;
    private int c = 1280;
    private int d = 720;
    private final Semaphore e;
    private c f;
    private com.tencent.liteav.basic.opengl.b g;
    private Object h;

    public b(WeakReference weakReference) {
        Semaphore semaphore;
        this.e = semaphore = new Semaphore(0);
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = weakReference;
    }

    private boolean a(int n10, int n11) {
        block5: {
            Object object = this.a;
            if (object == null) break block5;
            object = ((Reference)object).get();
            object = (a)object;
            if (object == null) break block5;
            try {
                return ((a)object).b(n10, n11);
            }
            catch (Exception exception) {
                CharSequence charSequence = new StringBuilder();
                object = "drawFrame failed.";
                charSequence.append((String)object);
                String string2 = exception.getMessage();
                charSequence.append(string2);
                string2 = charSequence.toString();
                charSequence = "TXCVideoRenderThread";
                TXCLog.e((String)charSequence, string2);
            }
        }
        return false;
    }

    private com.tencent.liteav.basic.util.e f() {
        Object object = this.g;
        if (object != null) {
            return ((com.tencent.liteav.basic.opengl.b)object).f();
        }
        object = this.f;
        if (object != null) {
            return ((c)object).c();
        }
        TXCOpenGlUtils.a("getSurfaceSize");
        object = new com.tencent.liteav.basic.util.e(0, 0);
        return object;
    }

    private void g() {
        block5: {
            Object object = this.a;
            object = ((Reference)object).get();
            object = (a)object;
            if (object == null) break block5;
            try {
                ((a)object).a(this);
            }
            catch (Exception exception) {
                String string2 = "TXCVideoRenderThread";
                String string3 = "init texture render failed.";
                TXCLog.e(string2, string3, exception);
            }
        }
    }

    private void h() {
        block5: {
            Object object = this.a;
            object = ((Reference)object).get();
            object = (a)object;
            if (object == null) break block5;
            try {
                ((a)object).b(this);
            }
            catch (Exception exception) {
                String string2 = "TXCVideoRenderThread";
                String string3 = "destroy texture render failed";
                TXCLog.e(string2, string3, exception);
            }
        }
    }

    private void i() {
        Object object = this.a;
        if (object != null && (object = (a)((Reference)object).get()) != null) {
            ((e)object).j();
        }
    }

    private void j() {
        Object object = this.a;
        if (object != null && (object = (a)((Reference)object).get()) != null) {
            ((e)object).k();
        }
    }

    private void k() {
        int n10;
        Object object = (a)this.a.get();
        if (object == null) {
            return;
        }
        object = ((a)object).c();
        Object object2 = null;
        Object object3 = object != null ? new Surface((SurfaceTexture)object) : null;
        object = this.h;
        if (object != null && (n10 = object instanceof javax.microedition.khronos.egl.EGLContext) == 0) {
            object = (EGLContext)object;
            n10 = this.c;
            int n11 = this.d;
            this.f = object = com.tencent.liteav.basic.opengl.c.a(null, (EGLContext)object, object3, n10, n11);
        } else {
            object = (javax.microedition.khronos.egl.EGLContext)object;
            n10 = this.c;
            int n12 = this.d;
            this.g = object = com.tencent.liteav.basic.opengl.b.a(null, (javax.microedition.khronos.egl.EGLContext)object, object3, n10, n12);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("vrender: init egl share context ");
        object2 = this.h;
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(", create context");
        object2 = this.a();
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        TXCLog.w("TXCVideoRenderThread", (String)object);
        this.e();
    }

    private void l() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("vrender: uninit egl ");
        Object object2 = this.a();
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        TXCLog.w("TXCVideoRenderThread", (String)object);
        object = this.g;
        object2 = null;
        if (object != null) {
            ((com.tencent.liteav.basic.opengl.b)object).c();
            this.g = null;
        }
        if ((object = this.f) != null) {
            ((c)object).d();
            this.f = null;
        }
    }

    public Object a() {
        Object object = this.g;
        if (object != null) {
            return ((com.tencent.liteav.basic.opengl.b)object).d();
        }
        object = this.f;
        if (object != null) {
            return ((c)object).f();
        }
        return null;
    }

    public void a(Object object) {
        this.h = object;
    }

    public void b() {
        this.b = false;
        this.c();
    }

    public void c() {
        this.e.release();
    }

    public void d() {
        Object object = this.g;
        if (object != null) {
            ((com.tencent.liteav.basic.opengl.b)object).a();
        }
        if ((object = this.f) != null) {
            ((c)object).e();
        }
    }

    public void e() {
        Object object = this.g;
        if (object != null) {
            ((com.tencent.liteav.basic.opengl.b)object).b();
        }
        if ((object = this.f) != null) {
            ((c)object).b();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = new StringBuilder();
        String string2 = "VRender-";
        ((StringBuilder)object).append(string2);
        long l10 = this.getId();
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        this.setName((String)object);
        int n10 = 1;
        try {
            this.b = n10;
            this.k();
            this.g();
            this.i();
            block4: while (true) {
                if ((n10 = this.b) == 0) {
                    this.j();
                    this.h();
                    this.l();
                    return;
                }
                object = this.f();
                int n11 = ((com.tencent.liteav.basic.util.e)object).a;
                n10 = ((com.tencent.liteav.basic.util.e)object).b;
                if ((n10 = (int)(this.a(n11, n10) ? 1 : 0)) != 0) {
                    object = this.a;
                    if (object == null) {
                        n10 = 0;
                        object = null;
                    } else {
                        object = ((Reference)object).get();
                        object = (a)object;
                    }
                    if (object != null && (object = ((a)object).c()) != null) {
                        this.d();
                    }
                }
                while (true) {
                    TimeUnit timeUnit;
                    if ((n10 = (int)(this.b ? 1 : 0)) == 0 || (n10 = (int)(((Semaphore)(object = this.e)).tryAcquire(l10 = 500L, timeUnit = TimeUnit.MILLISECONDS) ? 1 : 0)) != 0) continue block4;
                }
                break;
            }
        }
        catch (Exception exception) {
            string2 = "TXCVideoRenderThread";
            String string3 = "render failed.";
            TXCLog.e(string2, string3, exception);
            return;
        }
    }
}

