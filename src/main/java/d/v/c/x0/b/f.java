/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import d.v.c.x0.b.p;

public final class f
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ f(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (Integer)object;
        p10.S((Integer)object);
    }
}

