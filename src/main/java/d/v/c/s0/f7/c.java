/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.f7;

import androidx.lifecycle.Observer;
import d.v.c.s0.f7.d;

public final class c
implements Observer {
    public final /* synthetic */ d a;

    public /* synthetic */ c(d d10) {
        this.a = d10;
    }

    public final void onChanged(Object object) {
        d d10 = this.a;
        object = (Boolean)object;
        d10.m((Boolean)object);
    }
}

