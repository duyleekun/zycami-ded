/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import d.v.c.x0.b.q;
import d.v.h.d.c;
import java.util.List;

public final class m
implements Observer {
    public final /* synthetic */ q a;
    public final /* synthetic */ c b;

    public /* synthetic */ m(q q10, c c10) {
        this.a = q10;
        this.b = c10;
    }

    public final void onChanged(Object object) {
        q q10 = this.a;
        c c10 = this.b;
        object = (List)object;
        q10.y(c10, (List)object);
    }
}

