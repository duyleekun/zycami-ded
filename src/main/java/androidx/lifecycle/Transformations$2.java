/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations$2$1;

public class Transformations$2
implements Observer {
    public LiveData mSource;
    public final /* synthetic */ MediatorLiveData val$result;
    public final /* synthetic */ Function val$switchMapFunction;

    public Transformations$2(Function function, MediatorLiveData mediatorLiveData) {
        this.val$switchMapFunction = function;
        this.val$result = mediatorLiveData;
    }

    public void onChanged(Object object) {
        Object object2;
        LiveData liveData = this.mSource;
        if (liveData == (object = (LiveData)this.val$switchMapFunction.apply(object))) {
            return;
        }
        if (liveData != null) {
            object2 = this.val$result;
            ((MediatorLiveData)object2).removeSource(liveData);
        }
        this.mSource = object;
        if (object != null) {
            liveData = this.val$result;
            object2 = new Transformations$2$1(this);
            ((MediatorLiveData)liveData).addSource((LiveData)object, (Observer)object2);
        }
    }
}

