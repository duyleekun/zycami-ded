/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$1;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$f;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class TXCGLSurfaceViewBase$c
implements TXCGLSurfaceViewBase$f {
    public final /* synthetic */ TXCGLSurfaceViewBase a;
    private int b = 12440;

    private TXCGLSurfaceViewBase$c(TXCGLSurfaceViewBase tXCGLSurfaceViewBase) {
        this.a = tXCGLSurfaceViewBase;
    }

    public /* synthetic */ TXCGLSurfaceViewBase$c(TXCGLSurfaceViewBase tXCGLSurfaceViewBase, TXCGLSurfaceViewBase$1 tXCGLSurfaceViewBase$1) {
        this(tXCGLSurfaceViewBase);
    }

    public EGLContext a(EGL10 eGL10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int n10;
        int n11 = 3;
        int[] nArray = new int[n11];
        nArray[0] = n10 = this.b;
        nArray[1] = n10 = TXCGLSurfaceViewBase.h(this.a);
        n10 = 2;
        nArray[n10] = 12344;
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.a;
        int n12 = TXCGLSurfaceViewBase.h(tXCGLSurfaceViewBase);
        if (n12 == 0) {
            n11 = 0;
            nArray = null;
        }
        return eGL10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, nArray);
    }

    public void a(EGL10 eGL10, EGLDisplay object, EGLContext object2) {
        boolean bl2 = eGL10.eglDestroyContext(object, object2);
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "display:";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            stringBuilder.append(" context: ");
            stringBuilder.append(object2);
            object = stringBuilder.toString();
            object2 = "DefaultContextFactory";
            TXCLog.e((String)object2, (String)object);
            int n10 = eGL10.eglGetError();
            object = "eglDestroyContex";
            TXCGLSurfaceViewBase$h.a((String)object, n10);
        }
    }
}

