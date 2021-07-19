/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.c;

import androidx.lifecycle.Observer;
import d.v.c.x0.c.c.d;

public final class c
implements Observer {
    public final /* synthetic */ d a;

    public /* synthetic */ c(d d10) {
        this.a = d10;
    }

    public final void onChanged(Object object) {
        d d10 = this.a;
        object = (Integer)object;
        d10.D((Integer)object);
    }
}

