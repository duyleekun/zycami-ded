/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.lifecycle.Observer;
import d.v.c.y1.f.p;
import d.v.c.y1.f.q;

public final class f
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ f(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (q)object;
        p10.I((q)object);
    }
}

