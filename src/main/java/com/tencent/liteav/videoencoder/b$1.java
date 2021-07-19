/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.videoencoder.b;

public class b$1
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean[] c;
    public final /* synthetic */ b d;

    public b$1(b b10, int n10, int n11, boolean[] blArray) {
        this.d = b10;
        this.a = n10;
        this.b = n11;
        this.c = blArray;
    }

    public void run() {
        Object object = this.d;
        int n10 = this.a;
        int n11 = this.b;
        com.tencent.liteav.basic.opengl.b b10 = com.tencent.liteav.basic.opengl.b.a(null, null, null, n10, n11);
        com.tencent.liteav.videoencoder.b.a((b)object, b10);
        object = this.c;
        b10 = com.tencent.liteav.videoencoder.b.a(this.d);
        n11 = 0;
        if (b10 != null) {
            n10 = 1;
        } else {
            n10 = 0;
            b10 = null;
        }
        object[0] = n10;
    }
}

