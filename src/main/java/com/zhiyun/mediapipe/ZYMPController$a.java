/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  com.zhiyun.mediapipe.ZYMPController
 */
package com.zhiyun.mediapipe;

import android.view.SurfaceHolder;
import com.google.mediapipe.framework.SurfaceOutput;
import com.zhiyun.mediapipe.ZYMPController;
import d.v.r.c;
import d.v.r.e;

public class ZYMPController$a
implements SurfaceHolder.Callback {
    public final /* synthetic */ ZYMPController a;

    public ZYMPController$a(ZYMPController zYMPController) {
        this.a = zYMPController;
    }

    public void surfaceChanged(SurfaceHolder object, int n10, int n11, int n12) {
        object = ZYMPController.c((ZYMPController)this.a);
        e e10 = ZYMPController.b((ZYMPController)this.a);
        ((c)object).b(e10);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceOutput surfaceOutput = ZYMPController.a((ZYMPController)this.a).getVideoSurfaceOutput();
        surfaceHolder = surfaceHolder.getSurface();
        surfaceOutput.setSurface(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ZYMPController.a((ZYMPController)this.a).getVideoSurfaceOutput().setSurface(null);
    }
}

