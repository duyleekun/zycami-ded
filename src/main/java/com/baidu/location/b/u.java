/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.aa;
import com.baidu.location.b.t;
import java.util.concurrent.ExecutorService;

public class u
implements Runnable {
    public final /* synthetic */ t a;

    public u(t t10) {
        this.a = t10;
    }

    public void run() {
        t t10 = this.a;
        ExecutorService executorService = aa.a().c();
        t10.a(executorService);
    }
}

