/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.f;

import androidx.lifecycle.Observer;
import d.v.c.x0.c.f.k;
import java.util.List;

public final class d
implements Observer {
    public final /* synthetic */ k a;

    public /* synthetic */ d(k k10) {
        this.a = k10;
    }

    public final void onChanged(Object object) {
        k k10 = this.a;
        object = (List)object;
        k10.G((List)object);
    }
}

