/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import d.v.c.s0.h7.r0.u;
import java.util.List;

public final class o
implements Observer {
    public final /* synthetic */ u a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ o(u u10, LiveData liveData) {
        this.a = u10;
        this.b = liveData;
    }

    public final void onChanged(Object object) {
        u u10 = this.a;
        LiveData liveData = this.b;
        object = (List)object;
        u10.g(liveData, (List)object);
    }
}

