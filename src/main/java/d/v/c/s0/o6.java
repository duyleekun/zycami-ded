/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

public final class o6
implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ o6(MediatorLiveData mediatorLiveData) {
        this.a = mediatorLiveData;
    }

    public final void onChanged(Object object) {
        MediatorLiveData mediatorLiveData = this.a;
        object = (Boolean)object;
        mediatorLiveData.setValue(object);
    }
}

