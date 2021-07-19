/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.d;

import androidx.lifecycle.Observer;
import d.v.c.m1.d.k;

public final class d
implements Observer {
    public final /* synthetic */ k a;

    public /* synthetic */ d(k k10) {
        this.a = k10;
    }

    public final void onChanged(Object object) {
        k k10 = this.a;
        object = (String)object;
        k10.A((String)object);
    }
}

