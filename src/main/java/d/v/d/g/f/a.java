/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.f;

import d.v.d.g.f.c;
import d.v.d.g.f.c$b;
import java.util.function.Consumer;

public final class a
implements Consumer {
    public final /* synthetic */ byte[] a;

    public /* synthetic */ a(byte[] byArray) {
        this.a = byArray;
    }

    public final void accept(Object object) {
        byte[] byArray = this.a;
        object = (c$b)object;
        c.k(byArray, (c$b)object);
    }
}

