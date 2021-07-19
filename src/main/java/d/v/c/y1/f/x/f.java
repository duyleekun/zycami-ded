/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.x;

import androidx.lifecycle.Observer;
import d.v.c.y1.f.x.f0;
import d.v.c.y1.f.x.j0;
import java.util.List;

public final class f
implements Observer {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ j0 b;

    public /* synthetic */ f(f0 f02, j0 j02) {
        this.a = f02;
        this.b = j02;
    }

    public final void onChanged(Object object) {
        f0 f02 = this.a;
        j0 j02 = this.b;
        object = (List)object;
        f02.D(j02, (List)object);
    }
}

