/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.js;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class jr
extends js {
    private int a;
    private byte[] a;
    private int b;

    public int a() {
        return this.a;
    }

    public int a(byte[] byArray, int n10, int n11) {
        int n12 = this.b();
        if (n11 > n12) {
            n11 = n12;
        }
        if (n11 > 0) {
            byte[] byArray2 = this.a;
            int n13 = this.a;
            System.arraycopy(byArray2, n13, byArray, n10, n11);
            this.a(n11);
        }
        return n11;
    }

    public void a(int n10) {
        int n11;
        this.a = n11 = this.a + n10;
    }

    public void a(byte[] byArray) {
        int n10 = byArray.length;
        this.b(byArray, 0, n10);
    }

    public void a(byte[] object, int n10, int n11) {
        object = new UnsupportedOperationException;
        object("No writing allowed!");
        throw object;
    }

    public byte[] a() {
        return this.a;
    }

    public int b() {
        int n10 = this.b;
        int n11 = this.a;
        return n10 - n11;
    }

    public void b(byte[] byArray, int n10, int n11) {
        this.a = byArray;
        this.a = n10;
        this.b = n10 += n11;
    }
}

