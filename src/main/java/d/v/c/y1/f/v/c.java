/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.v;

import androidx.lifecycle.Observer;
import d.v.c.y1.f.v.i;
import java.util.List;

public final class c
implements Observer {
    public final /* synthetic */ i a;

    public /* synthetic */ c(i i10) {
        this.a = i10;
    }

    public final void onChanged(Object object) {
        i i10 = this.a;
        object = (List)object;
        i10.H((List)object);
    }
}

