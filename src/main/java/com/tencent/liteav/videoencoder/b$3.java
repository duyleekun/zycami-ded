/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.videoencoder.b;
import com.tencent.liteav.videoencoder.c;

public class b$3
implements Runnable {
    public final /* synthetic */ com.tencent.liteav.basic.opengl.b a;
    public final /* synthetic */ b b;

    public b$3(b b10, com.tencent.liteav.basic.opengl.b b11) {
        this.b = b10;
        this.a = b11;
    }

    public void run() {
        com.tencent.liteav.videoencoder.b.c(this.b).clear();
        Object object = com.tencent.liteav.videoencoder.b.d(this.b);
        if (object != null) {
            object = com.tencent.liteav.videoencoder.b.d(this.b);
            ((c)object).stop();
        }
        if ((object = com.tencent.liteav.videoencoder.b.b(this.b)) != null) {
            com.tencent.liteav.videoencoder.b.b(this.b).d();
            object = this.b;
            com.tencent.liteav.videoencoder.b.a((b)object, null);
        }
        if ((object = this.a) != null) {
            ((com.tencent.liteav.basic.opengl.b)object).c();
        }
    }
}

