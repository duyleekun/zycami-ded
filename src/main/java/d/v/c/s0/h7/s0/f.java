/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.s0.y;
import java.util.List;

public final class f
implements Observer {
    public final /* synthetic */ y a;

    public /* synthetic */ f(y y10) {
        this.a = y10;
    }

    public final void onChanged(Object object) {
        y y10 = this.a;
        object = (List)object;
        y10.M((List)object);
    }
}

