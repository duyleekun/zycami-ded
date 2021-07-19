/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import d.v.j.e.h.j;

public final class f
implements Observer {
    public final /* synthetic */ j a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ f(j j10, LiveData liveData) {
        this.a = j10;
        this.b = liveData;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        LiveData liveData = this.b;
        j10.l(liveData, object);
    }
}

