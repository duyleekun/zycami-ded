/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.Observer;
import d.v.c.s0.a7.y0;
import java.util.List;

public final class j
implements Observer {
    public final /* synthetic */ y0 a;

    public /* synthetic */ j(y0 y02) {
        this.a = y02;
    }

    public final void onChanged(Object object) {
        y0 y02 = this.a;
        object = (List)object;
        y0.L(y02, (List)object);
    }
}

