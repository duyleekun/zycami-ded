/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import b.a.d.a;

public final class ForwardingLiveData
extends MediatorLiveData {
    private LiveData mLiveDataSource;

    public Object getValue() {
        Object object = this.mLiveDataSource;
        object = object == null ? null : ((LiveData)object).getValue();
        return object;
    }

    public void setSource(LiveData liveData) {
        Object object = this.mLiveDataSource;
        if (object != null) {
            super.removeSource((LiveData)object);
        }
        this.mLiveDataSource = liveData;
        object = new a(this);
        super.addSource(liveData, (Observer)object);
    }
}

