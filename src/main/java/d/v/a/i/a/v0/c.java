/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a.v0;

import androidx.lifecycle.Observer;
import d.v.a.i.a.v0.m;

public final class c
implements Observer {
    public final /* synthetic */ m a;

    public /* synthetic */ c(m m10) {
        this.a = m10;
    }

    public final void onChanged(Object object) {
        m m10 = this.a;
        object = (String)object;
        m10.C((String)object);
    }
}

