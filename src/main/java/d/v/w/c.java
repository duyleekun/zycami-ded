/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import androidx.core.util.Pair;
import com.zhiyun.pay.PayClientLifecycle;
import e.a.k0;
import e.a.m0;

public final class c
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ Pair b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ c(PayClientLifecycle payClientLifecycle, Pair pair, String string2, String string3, String string4) {
        this.a = payClientLifecycle;
        this.b = pair;
        this.c = string2;
        this.d = string3;
        this.e = string4;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        Pair pair = this.b;
        String string2 = this.c;
        String string3 = this.d;
        String string4 = this.e;
        payClientLifecycle.R0(pair, string2, string3, string4, k02);
    }
}

