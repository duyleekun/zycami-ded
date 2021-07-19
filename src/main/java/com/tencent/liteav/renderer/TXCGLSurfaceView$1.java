/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.TXCGLSurfaceView;

public class TXCGLSurfaceView$1
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ TXCGLSurfaceView b;

    public TXCGLSurfaceView$1(TXCGLSurfaceView tXCGLSurfaceView, int n10) {
        this.b = tXCGLSurfaceView;
        this.a = n10;
    }

    public void run() {
        TXCGLSurfaceView tXCGLSurfaceView = this.b;
        int n10 = this.a;
        TXCGLSurfaceView.a(tXCGLSurfaceView, n10);
        tXCGLSurfaceView = this.b;
        int n11 = TXCGLSurfaceView.a(tXCGLSurfaceView);
        if (n11 <= 0) {
            tXCGLSurfaceView = this.b;
            n10 = 1;
            TXCGLSurfaceView.a(tXCGLSurfaceView, n10);
        } else {
            tXCGLSurfaceView = this.b;
            n11 = TXCGLSurfaceView.a(tXCGLSurfaceView);
            if (n11 > (n10 = 60)) {
                tXCGLSurfaceView = this.b;
                TXCGLSurfaceView.a(tXCGLSurfaceView, n10);
            }
        }
        tXCGLSurfaceView = this.b;
        long l10 = 0L;
        TXCGLSurfaceView.a(tXCGLSurfaceView, l10);
        TXCGLSurfaceView.b(this.b, l10);
    }
}

