/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import d.v.e.i.h;
import java.util.function.Consumer;

public final class a
implements Consumer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ a(MediatorLiveData mediatorLiveData, LiveData liveData) {
        this.a = mediatorLiveData;
        this.b = liveData;
    }

    public final void accept(Object object) {
        MediatorLiveData mediatorLiveData = this.a;
        LiveData liveData = this.b;
        object = (LiveData)object;
        h.a(mediatorLiveData, liveData, (LiveData)object);
    }
}

