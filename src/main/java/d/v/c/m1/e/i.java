/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import com.zhiyun.cama.prime.web.PrimeWebFragment$d;

public final class i
implements Runnable {
    public final /* synthetic */ PrimeWebFragment$d a;
    public final /* synthetic */ String b;

    public /* synthetic */ i(PrimeWebFragment$d primeWebFragment$d, String string2) {
        this.a = primeWebFragment$d;
        this.b = string2;
    }

    public final void run() {
        PrimeWebFragment$d primeWebFragment$d = this.a;
        String string2 = this.b;
        primeWebFragment$d.k(string2);
    }
}

