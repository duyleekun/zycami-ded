/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.g$c;

public final class g$a {
    private final g$c a;

    public g$a(g$c c10) {
        this.a = c10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void finalize() {
        boolean bl2;
        g$c g$c;
        try {
            g$c g$c2 = this.a;
            synchronized (g$c2) {
                g$c = this.a;
                bl2 = true;
            }
        }
        catch (Throwable throwable) {
            super.finalize();
            throw throwable;
        }
        {
            g$c.a(g$c, bl2);
            g$c = this.a;
            g$c.notify();
        }
        super.finalize();
    }
}

