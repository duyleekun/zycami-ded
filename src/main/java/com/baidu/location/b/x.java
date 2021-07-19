/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.t;

public class x
extends Thread {
    public final /* synthetic */ t a;

    public x(t t10) {
        this.a = t10;
    }

    public void run() {
        t t10 = this.a;
        boolean bl2 = t.b(t10);
        if (bl2) {
            t10 = this.a;
            t.c(t10);
        }
    }
}

