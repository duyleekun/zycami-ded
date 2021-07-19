/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import com.zhiyun.cama.prime.web.PrimeWebFragment$d;
import java.util.List;

public final class h
implements Runnable {
    public final /* synthetic */ PrimeWebFragment$d a;
    public final /* synthetic */ List b;

    public /* synthetic */ h(PrimeWebFragment$d primeWebFragment$d, List list) {
        this.a = primeWebFragment$d;
        this.b = list;
    }

    public final void run() {
        PrimeWebFragment$d primeWebFragment$d = this.a;
        List list = this.b;
        primeWebFragment$d.i(list);
    }
}

