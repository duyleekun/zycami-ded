/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.List;

public final class h
implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ h(MediatorLiveData mediatorLiveData) {
        this.a = mediatorLiveData;
    }

    public final void onChanged(Object object) {
        MediatorLiveData mediatorLiveData = this.a;
        object = (List)object;
        mediatorLiveData.setValue(object);
    }
}

