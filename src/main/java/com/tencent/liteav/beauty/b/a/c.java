/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.NativeLoad;

public class c
extends i {
    public boolean a() {
        int n10;
        this.a = n10 = NativeLoad.nativeLoadGLProgram(6);
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
}

