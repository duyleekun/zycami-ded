/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.d;

import androidx.lifecycle.Observer;
import d.v.c.m1.d.k;

public final class c
implements Observer {
    public final /* synthetic */ k a;

    public /* synthetic */ c(k k10) {
        this.a = k10;
    }

    public final void onChanged(Object object) {
        k k10 = this.a;
        object = (Boolean)object;
        k10.C((Boolean)object);
    }
}

