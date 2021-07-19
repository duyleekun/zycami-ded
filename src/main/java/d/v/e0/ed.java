/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ie.g;

public final class ed
implements e.a.v0.g {
    public final /* synthetic */ g a;

    public /* synthetic */ ed(g g10) {
        this.a = g10;
    }

    public final void accept(Object object) {
        g g10 = this.a;
        object = (Throwable)object;
        g10.onFailed((Throwable)object);
    }
}

