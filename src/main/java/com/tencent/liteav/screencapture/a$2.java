/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.screencapture;

import com.tencent.liteav.screencapture.a;

public class a$2
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ a b;

    public a$2(a a10, boolean bl2) {
        this.b = a10;
        this.a = bl2;
    }

    public void run() {
        Object object = com.tencent.liteav.screencapture.a.b(this.b);
        a a10 = this.b;
        boolean bl2 = a10.i;
        boolean bl3 = this.a;
        if (bl2 != bl3 && object != null) {
            if (bl3) {
                object.b();
            } else {
                object.c();
            }
        }
        object = this.b;
        ((a)object).i = bl2 = this.a;
    }
}

