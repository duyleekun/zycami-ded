/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.f;

public class f$2
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ f b;

    public f$2(f f10, int n10) {
        this.b = f10;
        this.a = n10;
    }

    public void run() {
        f f10 = this.b;
        int n10 = this.a;
        f.b(f10, n10);
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GLES20.glClear((int)16640);
    }
}

