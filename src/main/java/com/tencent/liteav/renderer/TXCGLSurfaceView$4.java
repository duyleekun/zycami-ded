/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase;

public class TXCGLSurfaceView$4
implements Runnable {
    public final /* synthetic */ TXCGLSurfaceView a;

    public TXCGLSurfaceView$4(TXCGLSurfaceView tXCGLSurfaceView) {
        this.a = tXCGLSurfaceView;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        synchronized (this) {
            Object object = "TXCGLSurfaceView";
            String string2 = "background capture exit background";
            TXCLog.i((String)object, string2);
            object = this.a;
            string2 = null;
            ((TXCGLSurfaceViewBase)object).c = false;
            return;
        }
    }
}

