/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import d.v.e.i.g$b$a;
import d.v.e.i.i;

public class g$b
implements Observer {
    public LiveData a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ i c;

    public g$b(Function function, i i10) {
        this.b = function;
        this.c = i10;
    }

    public void onChanged(Object object) {
        Object object2;
        LiveData liveData = this.a;
        if (liveData == (object = (LiveData)this.b.apply(object))) {
            return;
        }
        if (liveData != null) {
            object2 = this.c;
            ((MediatorLiveData)object2).removeSource(liveData);
        }
        this.a = object;
        if (object != null) {
            liveData = this.c;
            object2 = new g$b$a(this);
            ((MediatorLiveData)liveData).addSource((LiveData)object, (Observer)object2);
        }
    }
}

