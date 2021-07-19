/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$1;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$g;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class TXCGLSurfaceViewBase$d
implements TXCGLSurfaceViewBase$g {
    private TXCGLSurfaceViewBase$d() {
    }

    public /* synthetic */ TXCGLSurfaceViewBase$d(TXCGLSurfaceViewBase$1 tXCGLSurfaceViewBase$1) {
        this();
    }

    public EGLSurface a(EGL10 eGL10, EGLDisplay object, EGLConfig object2, Object object3) {
        EGLSurface eGLSurface = null;
        try {
            eGLSurface = eGL10.eglCreateWindowSurface(object, object2, object3, null);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = "TXCGLSurfaceViewBase";
            object2 = "eglCreateWindowSurface";
            TXCLog.e((String)object, (String)object2);
            String string2 = illegalArgumentException.toString();
            TXCLog.e((String)object, string2);
        }
        return eGLSurface;
    }

    public void a(EGL10 eGL10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        eGL10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}

