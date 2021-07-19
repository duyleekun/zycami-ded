/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

public class DecodeJob$f {
    private boolean a;
    private boolean b;
    private boolean c;

    private boolean a(boolean bl2) {
        boolean bl3 = this.c;
        bl2 = (bl3 || bl2 || (bl2 = this.b)) && (bl2 = this.a);
        return bl2;
    }

    public boolean b() {
        synchronized (this) {
            boolean bl2 = true;
            this.b = bl2;
            bl2 = false;
            Object var2_2 = null;
            bl2 = this.a(false);
            return bl2;
        }
    }

    public boolean c() {
        synchronized (this) {
            boolean bl2 = true;
            this.c = bl2;
            bl2 = false;
            Object var2_2 = null;
            bl2 = this.a(false);
            return bl2;
        }
    }

    public boolean d(boolean bl2) {
        synchronized (this) {
            boolean bl3 = true;
            this.a = bl3;
            bl2 = this.a(bl2);
            return bl2;
        }
    }

    public void e() {
        synchronized (this) {
            Object var1_1 = null;
            this.b = false;
            this.a = false;
            this.c = false;
            return;
        }
    }
}

