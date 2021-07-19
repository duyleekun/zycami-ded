/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;

public class i$1
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ i c;

    public i$1(i i10, int n10, int n11) {
        this.c = i10;
        this.a = n10;
        this.b = n11;
    }

    public void run() {
        int n10 = this.a;
        int n11 = this.b;
        GLES20.glUniform1i((int)n10, (int)n11);
    }
}

