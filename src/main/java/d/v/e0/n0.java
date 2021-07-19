/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.fe$b;
import e.a.v0.g;

public final class n0
implements g {
    public final /* synthetic */ fe$b a;

    public /* synthetic */ n0(fe$b fe$b) {
        this.a = fe$b;
    }

    public final void accept(Object object) {
        fe$b fe$b = this.a;
        object = (Throwable)object;
        fe$b.onError((Throwable)object);
    }
}

