/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.d1;

import androidx.lifecycle.Observer;
import d.v.c.d1.e;
import d.v.c.d1.h;
import java.util.List;

public final class a
implements Observer {
    public final /* synthetic */ h a;
    public final /* synthetic */ e b;

    public /* synthetic */ a(h h10, e e10) {
        this.a = h10;
        this.b = e10;
    }

    public final void onChanged(Object object) {
        h h10 = this.a;
        e e10 = this.b;
        object = (List)object;
        h10.t(e10, (List)object);
    }
}

