/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.h;

import androidx.lifecycle.Observer;
import d.v.c.y1.h.h;

public final class c
implements Observer {
    public final /* synthetic */ h a;

    public /* synthetic */ c(h h10) {
        this.a = h10;
    }

    public final void onChanged(Object object) {
        h h10 = this.a;
        object = (Boolean)object;
        h10.E((Boolean)object);
    }
}

