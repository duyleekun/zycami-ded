/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.f;

import com.baidu.location.f.b;
import com.baidu.location.f.b$a;

public class c
implements Runnable {
    public final /* synthetic */ b$a a;

    public c(b$a b$a) {
        this.a = b$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            b$a b$a = this.a;
            b b10 = b$a.a;
            b.a(b10);
        }
        catch (Exception exception) {}
        com.baidu.location.c.b.a().e();
    }
}

