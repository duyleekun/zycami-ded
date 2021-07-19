/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;

public class f$c
extends t {
    public int r;
    public int s;
    public float t = 1.5f;

    public f$c() {
        super(null, null);
    }

    public void a(float f10) {
        this.t = f10;
        int n10 = this.r;
        float f11 = this.e;
        this.a(n10, f10 /= f11);
        int n11 = this.s;
        float f12 = this.t;
        f11 = this.f;
        this.a(n11, f12 /= f11);
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
        float f10 = this.t;
        this.a(f10);
    }

    public boolean a() {
        int n10;
        this.a = n10 = NativeLoad.nativeLoadGLProgram(2);
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            n10 = 1;
            this.g = n10;
        } else {
            n10 = 0;
            this.g = false;
        }
        this.c();
        return this.g;
    }

    public boolean b() {
        int n10 = super.b();
        if (n10 != 0) {
            this.r = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"texelWidthOffset");
            this.s = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"texelHeightOffset");
            return true;
        }
        return false;
    }
}

