/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import com.tencent.liteav.renderer.TXCGLSurfaceView;

public class TXCGLSurfaceView$3
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ TXCGLSurfaceView b;

    public TXCGLSurfaceView$3(TXCGLSurfaceView tXCGLSurfaceView, int n10) {
        this.b = tXCGLSurfaceView;
        this.a = n10;
    }

    public void run() {
        TXCGLSurfaceView tXCGLSurfaceView = this.b;
        int n10 = this.a;
        TXCGLSurfaceView.c(tXCGLSurfaceView, n10);
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GLES20.glClear((int)16640);
    }
}

