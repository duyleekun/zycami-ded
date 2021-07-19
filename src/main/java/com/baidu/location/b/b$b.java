/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.b;

public class b$b
implements Runnable {
    public final /* synthetic */ b a;
    private int b;
    private boolean c;

    public void run() {
        int n10 = this.c;
        if (n10 != 0) {
            return;
        }
        this.b = n10 = this.b + 1;
        com.baidu.location.b.b.a(this.a, false);
    }
}

