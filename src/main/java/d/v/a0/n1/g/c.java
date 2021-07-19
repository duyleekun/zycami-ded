/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import d.v.a0.n1.g.u;
import d.v.a0.n1.g.v;
import java.util.function.Consumer;

public final class c
implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ int c;

    public /* synthetic */ c(String string2, Throwable throwable, int n10) {
        this.a = string2;
        this.b = throwable;
        this.c = n10;
    }

    public final void accept(Object object) {
        String string2 = this.a;
        Throwable throwable = this.b;
        int n10 = this.c;
        object = (v)object;
        u.e(string2, throwable, n10, (v)object);
    }
}

