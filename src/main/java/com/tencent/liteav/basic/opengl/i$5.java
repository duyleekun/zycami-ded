/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import java.nio.FloatBuffer;

public class i$5
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ float[] b;
    public final /* synthetic */ i c;

    public i$5(i i10, int n10, float[] fArray) {
        this.c = i10;
        this.a = n10;
        this.b = fArray;
    }

    public void run() {
        int n10 = this.a;
        FloatBuffer floatBuffer = FloatBuffer.wrap(this.b);
        GLES20.glUniform4fv((int)n10, (int)1, (FloatBuffer)floatBuffer);
    }
}

