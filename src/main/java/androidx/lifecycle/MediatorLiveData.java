/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData$Source;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData
extends MutableLiveData {
    private SafeIterableMap mSources;

    public MediatorLiveData() {
        SafeIterableMap safeIterableMap;
        this.mSources = safeIterableMap = new SafeIterableMap();
    }

    public void addSource(LiveData object, Observer observer) {
        Object object2 = this.mSources;
        MediatorLiveData$Source mediatorLiveData$Source = new MediatorLiveData$Source((LiveData)object, observer);
        if ((object = (MediatorLiveData$Source)((SafeIterableMap)object2).putIfAbsent(object, mediatorLiveData$Source)) != null && (object2 = ((MediatorLiveData$Source)object).mObserver) != observer) {
            object = new IllegalArgumentException("This source was already added with the different observer");
            throw object;
        }
        if (object != null) {
            return;
        }
        boolean bl2 = this.hasActiveObservers();
        if (bl2) {
            mediatorLiveData$Source.plug();
        }
    }

    public void onActive() {
        boolean bl2;
        Iterator iterator2 = this.mSources.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediatorLiveData$Source mediatorLiveData$Source = (MediatorLiveData$Source)((Map.Entry)iterator2.next()).getValue();
            mediatorLiveData$Source.plug();
        }
    }

    public void onInactive() {
        boolean bl2;
        Iterator iterator2 = this.mSources.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediatorLiveData$Source mediatorLiveData$Source = (MediatorLiveData$Source)((Map.Entry)iterator2.next()).getValue();
            mediatorLiveData$Source.unplug();
        }
    }

    public void removeSource(LiveData object) {
        SafeIterableMap safeIterableMap = this.mSources;
        if ((object = (MediatorLiveData$Source)safeIterableMap.remove(object)) != null) {
            ((MediatorLiveData$Source)object).unplug();
        }
    }
}

