/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import androidx.core.util.Pair;
import com.zhiyun.pay.PayClientLifecycle;
import e.a.v0.o;

public final class s
implements o {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ s(PayClientLifecycle payClientLifecycle, String string2, String string3, String string4) {
        this.a = payClientLifecycle;
        this.b = string2;
        this.c = string3;
        this.d = string4;
    }

    public final Object apply(Object object) {
        PayClientLifecycle payClientLifecycle = this.a;
        String string2 = this.b;
        String string3 = this.c;
        String string4 = this.d;
        object = (Pair)object;
        return payClientLifecycle.u0(string2, string3, string4, (Pair)object);
    }
}

