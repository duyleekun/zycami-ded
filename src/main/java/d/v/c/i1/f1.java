/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import d.v.c.i1.h2;

public final class f1
implements Observer {
    public final /* synthetic */ h2 a;

    public /* synthetic */ f1(h2 h22) {
        this.a = h22;
    }

    public final void onChanged(Object object) {
        h2 h22 = this.a;
        object = (Boolean)object;
        h22.Q0((Boolean)object);
    }
}

