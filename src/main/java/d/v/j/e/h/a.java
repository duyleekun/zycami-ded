/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import d.v.j.e.h.j$a;

public final class a
implements Observer {
    public final /* synthetic */ j$a a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ a(j$a j$a, LiveData liveData) {
        this.a = j$a;
        this.b = liveData;
    }

    public final void onChanged(Object object) {
        j$a j$a = this.a;
        LiveData liveData = this.b;
        j$a.b(liveData, object);
    }
}

