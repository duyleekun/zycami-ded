/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.l;
import java.util.function.Consumer;

public final class h
implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ int c;

    public /* synthetic */ h(String string2, Throwable throwable, int n10) {
        this.a = string2;
        this.b = throwable;
        this.c = n10;
    }

    public final void accept(Object object) {
        String string2 = this.a;
        Throwable throwable = this.b;
        int n10 = this.c;
        object = (k)object;
        l.e(string2, throwable, n10, (k)object);
    }
}

