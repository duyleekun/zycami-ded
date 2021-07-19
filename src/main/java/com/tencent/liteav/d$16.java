/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.d;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class d$16
implements Runnable {
    public final /* synthetic */ TXCGLSurfaceView[] a;
    public final /* synthetic */ TXCloudVideoView b;
    public final /* synthetic */ d c;

    public d$16(d d10, TXCGLSurfaceView[] tXCGLSurfaceViewArray, TXCloudVideoView tXCloudVideoView) {
        this.c = d10;
        this.a = tXCGLSurfaceViewArray;
        this.b = tXCloudVideoView;
    }

    public void run() {
        TXCGLSurfaceView tXCGLSurfaceView;
        Object object = this.a;
        Context context = this.b.getContext();
        object[0] = tXCGLSurfaceView = new TXCGLSurfaceView(context);
        object = this.b;
        tXCGLSurfaceView = this.a[0];
        ((TXCloudVideoView)((Object)object)).addVideoView(tXCGLSurfaceView);
    }
}

