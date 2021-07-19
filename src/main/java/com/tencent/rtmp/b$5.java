/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.rtmp.b;

public class b$5
implements Runnable {
    public final /* synthetic */ b a;

    public b$5(b b10) {
        this.a = b10;
    }

    public void run() {
        b b10 = this.a;
        boolean bl2 = b.i(b10);
        if (bl2) {
            b10 = this.a;
            b.j(b10);
        }
    }
}

