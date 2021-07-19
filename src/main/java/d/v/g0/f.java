/*
 * Decompiled with CFR 0.151.
 */
package d.v.g0;

import androidx.lifecycle.Observer;
import d.v.g0.q;

public final class f
implements Observer {
    public final /* synthetic */ q a;

    public /* synthetic */ f(q q10) {
        this.a = q10;
    }

    public final void onChanged(Object object) {
        q q10 = this.a;
        object = (Integer)object;
        q10.A((Integer)object);
    }
}

