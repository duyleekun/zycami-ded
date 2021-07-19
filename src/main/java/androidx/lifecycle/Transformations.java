/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations$1;
import androidx.lifecycle.Transformations$2;
import androidx.lifecycle.Transformations$3;

public class Transformations {
    private Transformations() {
    }

    public static LiveData distinctUntilChanged(LiveData liveData) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Transformations$3 transformations$3 = new Transformations$3(mediatorLiveData);
        mediatorLiveData.addSource(liveData, transformations$3);
        return mediatorLiveData;
    }

    public static LiveData map(LiveData liveData, Function function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Transformations$1 transformations$1 = new Transformations$1(mediatorLiveData, function);
        mediatorLiveData.addSource(liveData, transformations$1);
        return mediatorLiveData;
    }

    public static LiveData switchMap(LiveData liveData, Function function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Transformations$2 transformations$2 = new Transformations$2(function, mediatorLiveData);
        mediatorLiveData.addSource(liveData, transformations$2);
        return mediatorLiveData;
    }
}

