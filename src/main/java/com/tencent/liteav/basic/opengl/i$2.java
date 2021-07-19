/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;

public class i$2
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ float b;
    public final /* synthetic */ i c;

    public i$2(i i10, int n10, float f10) {
        this.c = i10;
        this.a = n10;
        this.b = f10;
    }

    public void run() {
        int n10 = this.a;
        float f10 = this.b;
        GLES20.glUniform1f((int)n10, (float)f10);
    }
}

