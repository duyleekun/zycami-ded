/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ie.l;
import e.a.v0.g;

public final class xb
implements g {
    public final /* synthetic */ l a;

    public /* synthetic */ xb(l l10) {
        this.a = l10;
    }

    public final void accept(Object object) {
        l l10 = this.a;
        object = (Throwable)object;
        l10.onFailed((Throwable)object);
    }
}

