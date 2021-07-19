/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty.b;

public class a {
    private boolean a = false;

    public void a() {
        synchronized (this) {
            boolean bl2 = true;
            this.a = bl2;
            this.notify();
            return;
        }
    }

    public void b() {
        synchronized (this) {
            boolean bl2;
            while (true) {
                bl2 = this.a;
                if (bl2) break;
                this.wait();
                continue;
                break;
            }
            bl2 = false;
            Object var2_2 = null;
            this.a = false;
            return;
        }
    }
}

