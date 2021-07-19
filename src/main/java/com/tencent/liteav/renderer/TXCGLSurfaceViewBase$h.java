/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLDebugHelper
 *  android.view.SurfaceHolder
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 *  javax.microedition.khronos.opengles.GL
 */
package com.tencent.liteav.renderer;

import android.opengl.GLDebugHelper;
import android.view.SurfaceHolder;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$k;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$l;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class TXCGLSurfaceViewBase$h {
    public EGL10 a;
    public EGLDisplay b;
    public EGLSurface c;
    public EGLConfig d;
    public EGLContext e;
    private WeakReference f;

    public TXCGLSurfaceViewBase$h(WeakReference weakReference) {
        this.f = weakReference;
    }

    private void a(String string2) {
        int n10 = this.a.eglGetError();
        TXCGLSurfaceViewBase$h.a(string2, n10);
    }

    public static void a(String string2, int n10) {
        string2 = TXCGLSurfaceViewBase$h.b(string2, n10);
        RuntimeException runtimeException = new RuntimeException(string2);
        throw runtimeException;
    }

    public static void a(String string2, String string3, int n10) {
        string3 = TXCGLSurfaceViewBase$h.b(string3, n10);
        TXCLog.w(string2, string3);
    }

    public static String b(String string2, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" failed: ");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    private void i() {
        Object object;
        Object object2 = this.c;
        if (object2 != null && object2 != (object = EGL10.EGL_NO_SURFACE)) {
            object2 = this.a;
            EGLDisplay eGLDisplay = this.b;
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            object2.eglMakeCurrent(eGLDisplay, (EGLSurface)object, (EGLSurface)object, eGLContext);
            object2 = (TXCGLSurfaceViewBase)((Object)this.f.get());
            if (object2 != null) {
                object = TXCGLSurfaceViewBase.e((TXCGLSurfaceViewBase)((Object)object2));
                eGLDisplay = this.a;
                eGLContext = this.b;
                EGLSurface eGLSurface = this.c;
                object.a((EGL10)eGLDisplay, (EGLDisplay)eGLContext, eGLSurface);
                object = null;
                object2.e = false;
            }
            object2 = null;
            this.c = null;
        }
    }

    public void a() {
        Object object;
        this.a = object = (EGL10)EGLContext.getEGL();
        Object object2 = EGL10.EGL_DEFAULT_DISPLAY;
        object = object.eglGetDisplay(object2);
        this.b = object;
        object2 = EGL10.EGL_NO_DISPLAY;
        if (object != object2) {
            Object object3 = this.a;
            int n10 = 2;
            object2 = new int[n10];
            boolean bl2 = object3.eglInitialize((EGLDisplay)object, (int[])object2);
            if (bl2) {
                Object object4;
                object = (TXCGLSurfaceViewBase)((Object)this.f.get());
                n10 = 0;
                object2 = null;
                if (object == null) {
                    this.d = null;
                    this.e = null;
                    object3 = "TXCGLSurfaceViewBase";
                    object4 = "start() error when view is null ";
                    TXCLog.w((String)object3, (String)object4);
                } else {
                    object3 = TXCGLSurfaceViewBase.c((TXCGLSurfaceViewBase)((Object)object));
                    object4 = this.a;
                    EGLDisplay eGLDisplay = this.b;
                    object3 = object3.a((EGL10)object4, eGLDisplay);
                    this.d = object3;
                    object3 = TXCGLSurfaceViewBase.d((TXCGLSurfaceViewBase)((Object)object));
                    object4 = this.a;
                    eGLDisplay = this.b;
                    EGLConfig eGLConfig = this.d;
                    object3 = object3.a((EGL10)object4, eGLDisplay, eGLConfig);
                    this.e = object3;
                }
                object3 = this.e;
                if (object3 == null || object3 == (object4 = EGL10.EGL_NO_CONTEXT)) {
                    this.e = null;
                    object3 = "createContext";
                    this.a((String)object3);
                }
                if (object != null) {
                    boolean bl3;
                    object.f = bl3 = true;
                }
                this.c = null;
                return;
            }
            object = new RuntimeException("eglInitialize failed");
            throw object;
        }
        object = new RuntimeException("eglGetDisplay failed");
        throw object;
    }

    public boolean b() {
        Object object = this.a;
        if (object != null) {
            object = this.b;
            if (object != null) {
                object = this.d;
                if (object != null) {
                    int n10;
                    SurfaceHolder surfaceHolder;
                    EGLConfig eGLConfig;
                    EGLDisplay eGLDisplay;
                    EGL10 eGL10;
                    Object object2;
                    this.i();
                    object = (TXCGLSurfaceViewBase)((Object)this.f.get());
                    if (object != null) {
                        object2 = TXCGLSurfaceViewBase.e((TXCGLSurfaceViewBase)((Object)object));
                        eGL10 = this.a;
                        eGLDisplay = this.b;
                        eGLConfig = this.d;
                        surfaceHolder = object.getHolder();
                        object2 = object2.a(eGL10, eGLDisplay, eGLConfig, surfaceHolder);
                        this.c = object2;
                    } else {
                        n10 = 0;
                        object2 = null;
                        this.c = null;
                    }
                    object2 = this.c;
                    eGL10 = null;
                    if (object2 != null && object2 != (eGLDisplay = EGL10.EGL_NO_SURFACE)) {
                        eGLDisplay = this.a;
                        eGLConfig = this.b;
                        surfaceHolder = this.e;
                        n10 = (int)(eGLDisplay.eglMakeCurrent((EGLDisplay)eGLConfig, (EGLSurface)object2, (EGLSurface)object2, (EGLContext)surfaceHolder) ? 1 : 0);
                        if (!n10) {
                            int n11 = this.a.eglGetError();
                            TXCGLSurfaceViewBase$h.a("EGLHelper", "eglMakeCurrent", n11);
                            return false;
                        }
                        n10 = 1;
                        if (object != null) {
                            object.e = n10;
                        }
                        return n10 != 0;
                    }
                    object = this.a;
                    int n12 = object.eglGetError();
                    if (n12 == (n10 = 12299)) {
                        object = "EglHelper";
                        object2 = "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.";
                        TXCLog.e((String)object, (String)object2);
                    }
                    return false;
                }
                object = new RuntimeException("mEglConfig not initialized");
                throw object;
            }
            object = new RuntimeException("eglDisplay not initialized");
            throw object;
        }
        object = new RuntimeException("egl not initialized");
        throw object;
    }

    public boolean c() {
        EGL10 eGL10 = this.a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.c;
        EGLContext eGLContext = this.e;
        int n10 = eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        if (n10 == 0) {
            n10 = this.a.eglGetError();
            TXCGLSurfaceViewBase$h.a("EGLHelper", "eglMakeCurrent", n10);
            return false;
        }
        return true;
    }

    public int d() {
        return this.f();
    }

    public GL e() {
        GL gL = this.e.getGL();
        TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)((Object)this.f.get());
        if (tXCGLSurfaceViewBase != null) {
            int n10;
            TXCGLSurfaceViewBase$k tXCGLSurfaceViewBase$k = TXCGLSurfaceViewBase.f(tXCGLSurfaceViewBase);
            if (tXCGLSurfaceViewBase$k != null) {
                tXCGLSurfaceViewBase$k = TXCGLSurfaceViewBase.f(tXCGLSurfaceViewBase);
                gL = tXCGLSurfaceViewBase$k.a(gL);
            }
            if ((n10 = TXCGLSurfaceViewBase.g(tXCGLSurfaceViewBase) & 3) != 0) {
                int n11;
                n10 = 0;
                tXCGLSurfaceViewBase$k = null;
                TXCGLSurfaceViewBase$l tXCGLSurfaceViewBase$l = null;
                int n12 = TXCGLSurfaceViewBase.g(tXCGLSurfaceViewBase);
                int n13 = 1;
                if ((n12 &= n13) != 0) {
                    n10 = n13;
                }
                if ((n11 = TXCGLSurfaceViewBase.g(tXCGLSurfaceViewBase) & 2) != 0) {
                    tXCGLSurfaceViewBase$l = new TXCGLSurfaceViewBase$l();
                }
                gL = GLDebugHelper.wrap((GL)gL, (int)n10, (Writer)tXCGLSurfaceViewBase$l);
            }
        }
        return gL;
    }

    public int f() {
        EGL10 eGL10 = this.a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.c;
        boolean bl2 = eGL10.eglSwapBuffers(eGLDisplay, eGLSurface);
        if (!bl2) {
            return this.a.eglGetError();
        }
        return 12288;
    }

    public void g() {
        this.i();
    }

    public void h() {
        EGL10 eGL10;
        Object object = this.e;
        if (object != null) {
            object = (TXCGLSurfaceViewBase)((Object)this.f.get());
            if (object != null) {
                object = TXCGLSurfaceViewBase.d((TXCGLSurfaceViewBase)((Object)object));
                eGL10 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLContext eGLContext = this.e;
                object.a(eGL10, eGLDisplay, eGLContext);
            }
            this.e = null;
        }
        if ((object = this.b) != null) {
            eGL10 = this.a;
            eGL10.eglTerminate((EGLDisplay)object);
            this.b = null;
        }
    }
}

