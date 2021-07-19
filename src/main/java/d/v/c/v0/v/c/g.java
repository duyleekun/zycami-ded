/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import d.v.c.v0.v.c.s;
import java.util.List;

public final class g
implements Observer {
    public final /* synthetic */ s a;
    public final /* synthetic */ MediatorLiveData b;
    public final /* synthetic */ LiveData c;
    public final /* synthetic */ LiveData d;

    public /* synthetic */ g(s s10, MediatorLiveData mediatorLiveData, LiveData liveData, LiveData liveData2) {
        this.a = s10;
        this.b = mediatorLiveData;
        this.c = liveData;
        this.d = liveData2;
    }

    public final void onChanged(Object object) {
        s s10 = this.a;
        MediatorLiveData mediatorLiveData = this.b;
        LiveData liveData = this.c;
        LiveData liveData2 = this.d;
        object = (List)object;
        s10.O(mediatorLiveData, liveData, liveData2, (List)object);
    }
}

