/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import d.v.j.e.i.c1$c;
import e.a.v0.g;

public final class g0
implements g {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ g0(MediatorLiveData mediatorLiveData) {
        this.a = mediatorLiveData;
    }

    public final void accept(Object object) {
        MediatorLiveData mediatorLiveData = this.a;
        object = (LiveData)object;
        c1$c.x(mediatorLiveData, (LiveData)object);
    }
}

