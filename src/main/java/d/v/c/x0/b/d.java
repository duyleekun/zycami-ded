/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import d.v.c.x0.b.p;

public final class d
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ d(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (Integer)object;
        p10.Q((Integer)object);
    }
}

