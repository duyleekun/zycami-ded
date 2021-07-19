/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.a;
import com.tencent.liteav.basic.opengl.i;

public class p
extends i {
    private a r;

    public int b(int n10) {
        int n11;
        a a10 = this.r;
        if (a10 == null) {
            this.r = a10 = new a();
            a10.a = 0;
            a10.b = 0;
            a10.c = n11 = this.e;
            a10.d = n11 = this.f;
        }
        a10 = this.r;
        n11 = a10.a;
        int n12 = a10.b;
        int n13 = a10.c;
        int n14 = a10.d;
        GLES20.glViewport((int)n11, (int)n12, (int)n13, (int)n14);
        return super.b(n10);
    }
}

