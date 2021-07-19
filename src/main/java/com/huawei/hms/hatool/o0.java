/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

public class o0 {
    public byte[] a = null;
    public int b = 0;

    public o0(int n10) {
        byte[] byArray = new byte[n10];
        this.a = byArray;
    }

    public void a(byte[] byArray, int n10) {
        int n11;
        if (n10 <= 0) {
            return;
        }
        byte[] byArray2 = this.a;
        int n12 = byArray2.length;
        int n13 = this.b;
        if ((n12 -= n13) >= n10) {
            System.arraycopy(byArray, 0, byArray2, n13, n10);
        } else {
            n12 = byArray2.length + n10 << 1;
            byte[] byArray3 = new byte[n12];
            System.arraycopy(byArray2, 0, byArray3, 0, n13);
            int n14 = this.b;
            System.arraycopy(byArray, 0, byArray3, n14, n10);
            this.a = byArray3;
        }
        this.b = n11 = this.b + n10;
    }

    public byte[] a() {
        int n10 = this.b;
        if (n10 <= 0) {
            return new byte[0];
        }
        byte[] byArray = new byte[n10];
        System.arraycopy(this.a, 0, byArray, 0, n10);
        return byArray;
    }

    public int b() {
        return this.b;
    }
}

