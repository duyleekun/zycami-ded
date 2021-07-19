/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.u;

public class v
extends u {
    public float u;

    public void a(int n10, int n11) {
        super.a(n10, n11);
        this.t();
    }

    public boolean b() {
        int n10 = super.b();
        return n10 != 0 && (n10 = GLES20.glGetError()) == 0;
    }

    public float r() {
        return this.u;
    }

    public float s() {
        return this.u;
    }

    public void t() {
        float f10 = this.s();
        i i10 = (i)this.r.get(0);
        int n10 = i10.q();
        String string2 = "texelWidthOffset";
        n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        int n11 = i10.q();
        String string3 = "texelHeightOffset";
        n11 = GLES20.glGetUniformLocation((int)n11, (String)string3);
        float f11 = this.e;
        i10.a(n10, f10 /= f11);
        i10.a(n11, 0.0f);
        float f12 = this.r();
        i i11 = (i)this.r.get(1);
        int n12 = GLES20.glGetUniformLocation((int)i11.q(), (String)string2);
        n11 = GLES20.glGetUniformLocation((int)i11.q(), (String)string3);
        i11.a(n12, 0.0f);
        f10 = this.f;
        i11.a(n11, f12 /= f10);
    }
}

