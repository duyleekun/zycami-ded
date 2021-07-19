/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.x;

import androidx.lifecycle.Observer;
import d.v.c.y1.f.x.g0;
import java.util.List;

public final class m
implements Observer {
    public final /* synthetic */ g0 a;

    public /* synthetic */ m(g0 g02) {
        this.a = g02;
    }

    public final void onChanged(Object object) {
        g0 g02 = this.a;
        object = (List)object;
        g02.F((List)object);
    }
}

