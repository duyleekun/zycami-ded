/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.d;

import androidx.lifecycle.Observer;
import d.v.c.x0.c.d.j;

public final class c
implements Observer {
    public final /* synthetic */ j a;

    public /* synthetic */ c(j j10) {
        this.a = j10;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        object = (Integer)object;
        j10.K((Integer)object);
    }
}

