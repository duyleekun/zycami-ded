/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.d;

import androidx.lifecycle.Observer;
import d.v.c.x0.c.d.j;
import java.util.List;

public final class f
implements Observer {
    public final /* synthetic */ j a;

    public /* synthetic */ f(j j10) {
        this.a = j10;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        object = (List)object;
        j10.G((List)object);
    }
}

