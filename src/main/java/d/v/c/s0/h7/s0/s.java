/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.s0.y;

public final class s
implements Observer {
    public final /* synthetic */ y a;

    public /* synthetic */ s(y y10) {
        this.a = y10;
    }

    public final void onChanged(Object object) {
        y y10 = this.a;
        object = (Integer)object;
        y10.S((Integer)object);
    }
}

