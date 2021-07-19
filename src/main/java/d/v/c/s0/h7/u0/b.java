/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.u0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.u0.j;
import d.v.c.s0.h7.u0.k;
import d.v.c.w0.yh;
import java.util.Map;

public final class b
implements Observer {
    public final /* synthetic */ j a;
    public final /* synthetic */ yh b;
    public final /* synthetic */ k c;

    public /* synthetic */ b(j j10, yh yh2, k k10) {
        this.a = j10;
        this.b = yh2;
        this.c = k10;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        yh yh2 = this.b;
        k k10 = this.c;
        object = (Map)object;
        j10.l(yh2, k10, (Map)object);
    }
}

