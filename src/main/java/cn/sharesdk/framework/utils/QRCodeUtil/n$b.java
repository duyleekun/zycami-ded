/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.n$a;

public final class n$b {
    private final int a;
    private final n$a[] b;

    public n$b(int n10, n$a ... n$aArray) {
        this.a = n10;
        this.b = n$aArray;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        n$a[] n$aArray = this.b;
        int n10 = n$aArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            n$a n$a = n$aArray[i10];
            int n12 = n$a.a();
            n11 += n12;
        }
        return n11;
    }

    public int c() {
        int n10 = this.a;
        int n11 = this.b();
        return n10 * n11;
    }

    public n$a[] d() {
        return this.b;
    }
}

