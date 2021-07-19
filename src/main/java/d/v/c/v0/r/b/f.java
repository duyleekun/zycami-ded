/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.r.b;

import androidx.lifecycle.MutableLiveData;
import d.v.c.v0.r.b.g;

public final class f
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ MutableLiveData b;

    public /* synthetic */ f(g g10, MutableLiveData mutableLiveData) {
        this.a = g10;
        this.b = mutableLiveData;
    }

    public final void run() {
        g g10 = this.a;
        MutableLiveData mutableLiveData = this.b;
        g10.u(mutableLiveData);
    }
}

