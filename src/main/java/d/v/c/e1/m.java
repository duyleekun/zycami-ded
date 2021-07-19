/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import androidx.lifecycle.Observer;
import d.v.c.e1.u;
import d.v.h.f.a;
import java.util.List;

public final class m
implements Observer {
    public final /* synthetic */ u a;
    public final /* synthetic */ a b;

    public /* synthetic */ m(u u10, a a10) {
        this.a = u10;
        this.b = a10;
    }

    public final void onChanged(Object object) {
        u u10 = this.a;
        a a10 = this.b;
        object = (List)object;
        u10.R(a10, (List)object);
    }
}

