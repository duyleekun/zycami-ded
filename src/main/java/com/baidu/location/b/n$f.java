/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.n;
import com.baidu.location.b.n$1;

public class n$f
implements Runnable {
    public final /* synthetic */ n a;

    private n$f(n n10) {
        this.a = n10;
    }

    public /* synthetic */ n$f(n n10, n$1 n$1) {
        this(n10);
    }

    public void run() {
        n.a(this.a, false);
        n.b(this.a).obtainMessage(6).sendToTarget();
    }
}

