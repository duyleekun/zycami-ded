/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.egl.EGL11
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.beauty.a.a.a;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

public class b {
    public a a;
    private EGLSurface b;
    private int c;
    private int d;

    public b(a a10) {
        int n10;
        EGLSurface eGLSurface;
        this.b = eGLSurface = EGL11.EGL_NO_SURFACE;
        this.c = n10 = -1;
        this.d = n10;
        this.a = a10;
    }

    public void a() {
        int n10;
        a a10 = this.a;
        EGLSurface eGLSurface = this.b;
        a10.a(eGLSurface);
        a10 = EGL11.EGL_NO_SURFACE;
        this.b = a10;
        this.d = n10 = -1;
        this.c = n10;
    }

    public void a(int n10, int n11) {
        EGLSurface eGLSurface = this.b;
        EGLSurface eGLSurface2 = EGL11.EGL_NO_SURFACE;
        if (eGLSurface == eGLSurface2) {
            this.b = eGLSurface = this.a.a(n10, n11);
            this.c = n10;
            this.d = n11;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("surface already created");
        throw illegalStateException;
    }

    public void b() {
        a a10 = this.a;
        EGLSurface eGLSurface = this.b;
        a10.b(eGLSurface);
    }
}

