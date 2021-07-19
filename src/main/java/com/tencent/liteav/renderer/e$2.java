/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.opengl.f;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.renderer.e;

public class e$2
implements Runnable {
    public final /* synthetic */ o a;
    public final /* synthetic */ e b;

    public e$2(e e10, o o10) {
        this.b = e10;
        this.a = o10;
    }

    public void run() {
        f f10 = e.a(this.b);
        if (f10 != null) {
            f10 = e.a(this.b);
            o o10 = this.a;
            f10.a(o10);
        }
    }
}

