/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ja;
import com.xiaomi.push.js;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class jq
extends js {
    private int a;
    private ja a;

    public jq(int n10) {
        ja ja2;
        this.a = ja2 = new ja(n10);
    }

    public int a(byte[] byArray, int n10, int n11) {
        byte[] byArray2 = this.a.a();
        ja ja2 = this.a;
        int n12 = ja2.a();
        int n13 = this.a;
        if (n11 > (n12 -= n13)) {
            ja ja3 = this.a;
            n11 = ja3.a();
            n12 = this.a;
            n11 -= n12;
        }
        if (n11 > 0) {
            int n14;
            n12 = this.a;
            System.arraycopy(byArray2, n12, byArray, n10, n11);
            this.a = n14 = this.a + n11;
        }
        return n11;
    }

    public void a(byte[] byArray, int n10, int n11) {
        this.a.write(byArray, n10, n11);
    }

    public int a_() {
        return this.a.size();
    }
}

