/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import d.v.a0.h1;
import d.v.a0.n1.g.w;
import d.v.a0.n1.g.x;
import d.v.z.l.d;
import java.util.function.Consumer;

public final class s
implements Consumer {
    public final /* synthetic */ h1 a;
    public final /* synthetic */ d b;

    public /* synthetic */ s(h1 h12, d d10) {
        this.a = h12;
        this.b = d10;
    }

    public final void accept(Object object) {
        h1 h12 = this.a;
        d d10 = this.b;
        object = (w)object;
        x.c(h12, d10, (w)object);
    }
}

