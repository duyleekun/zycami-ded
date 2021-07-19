/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.x;

import androidx.lifecycle.Observer;
import d.v.c.y1.f.x.i0;

public final class o
implements Observer {
    public final /* synthetic */ i0 a;

    public /* synthetic */ o(i0 i02) {
        this.a = i02;
    }

    public final void onChanged(Object object) {
        i0 i02 = this.a;
        object = (Boolean)object;
        i02.E((Boolean)object);
    }
}

