/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.s;

public class e
extends s {
    private int A;
    private float[] B;
    private int x;
    private int y;
    private int z;

    public void b(float[] fArray) {
        float f10;
        float[] fArray2 = new float[3];
        double d10 = (double)fArray[0] * 0.2989;
        int n10 = 1;
        double d11 = (double)fArray[n10] * 0.5866;
        int n11 = 2;
        double d12 = (double)fArray[n11] * 0.1145;
        fArray2[0] = f10 = (float)((d10 += d11) + d12);
        f10 = fArray[0];
        float f11 = fArray2[0];
        fArray2[n10] = f10 = (float)((double)(f10 - f11) * 0.7132);
        float f12 = fArray[n11];
        float f13 = fArray2[0];
        fArray2[n11] = f12 = (float)((double)(f12 - f13) * 0.5647);
        int n12 = this.y;
        this.b(n12, fArray2);
    }

    public void c() {
        int n10;
        super.c();
        this.x = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"screenMode");
        this.y = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"screenReplaceColor");
        this.z = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"screenMirrorX");
        this.A = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"screenMirrorY");
        float[] fArray = this.B;
        this.b(fArray);
    }
}

