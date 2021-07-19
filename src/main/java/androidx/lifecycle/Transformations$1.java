/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

public class Transformations$1
implements Observer {
    public final /* synthetic */ Function val$mapFunction;
    public final /* synthetic */ MediatorLiveData val$result;

    public Transformations$1(MediatorLiveData mediatorLiveData, Function function) {
        this.val$result = mediatorLiveData;
        this.val$mapFunction = function;
    }

    public void onChanged(Object object) {
        MediatorLiveData mediatorLiveData = this.val$result;
        object = this.val$mapFunction.apply(object);
        mediatorLiveData.setValue(object);
    }
}

