/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.opengl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;

public class e {
    private final int a;
    private final int b;
    private int c;
    private int d;

    public e(int n10, int n11) {
        int n12;
        this.c = n12 = -1;
        this.d = n12;
        this.a = n10;
        this.b = n11;
    }

    public void a() {
        int n10 = this.a;
        int n11 = this.b;
        this.c = n10 = TXCOpenGlUtils.a(null, n10, n11, -1);
        this.d = n10 = TXCOpenGlUtils.d();
        TXCOpenGlUtils.a(this.c, n10);
        Object[] objectArray = new Object[2];
        Integer n12 = this.d;
        objectArray[0] = n12;
        n12 = this.c;
        objectArray[1] = n12;
        TXCLog.i("GLFrameBuffer", "create frameBufferId: %d, textureId: %d", objectArray);
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public void e() {
        int n10;
        Object[] objectArray = new Object[2];
        Integer n11 = this.d;
        objectArray[0] = n11;
        n11 = this.c;
        objectArray[1] = n11;
        TXCLog.i("GLFrameBuffer", "destroy frameBufferId: %d, textureId: %d", objectArray);
        TXCOpenGlUtils.c(this.c);
        this.c = n10 = -1;
        TXCOpenGlUtils.b(this.d);
        this.d = n10;
    }
}

