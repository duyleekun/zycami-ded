/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import d.v.j.e.h.h;
import d.v.j.e.h.j;

public final class e
implements Observer {
    public final /* synthetic */ j a;
    public final /* synthetic */ LiveData b;
    public final /* synthetic */ h c;

    public /* synthetic */ e(j j10, LiveData liveData, h h10) {
        this.a = j10;
        this.b = liveData;
        this.c = h10;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        LiveData liveData = this.b;
        h h10 = this.c;
        j10.j(liveData, h10, object);
    }
}

