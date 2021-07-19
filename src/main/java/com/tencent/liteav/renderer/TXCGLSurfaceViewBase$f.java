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

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public interface TXCGLSurfaceViewBase$f {
    public EGLContext a(EGL10 var1, EGLDisplay var2, EGLConfig var3);

    public void a(EGL10 var1, EGLDisplay var2, EGLContext var3);
}

