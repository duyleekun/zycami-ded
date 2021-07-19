/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import b.a.a.d.w0;

public class Camera2CameraInfoImpl$RedirectableLiveData
extends MediatorLiveData {
    private Object mInitialValue;
    private LiveData mLiveDataSource;

    public Camera2CameraInfoImpl$RedirectableLiveData(Object object) {
        this.mInitialValue = object;
    }

    public void addSource(LiveData object, Observer observer) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Object getValue() {
        Object object = this.mLiveDataSource;
        object = object == null ? this.mInitialValue : ((LiveData)object).getValue();
        return object;
    }

    public void redirectTo(LiveData liveData) {
        Object object = this.mLiveDataSource;
        if (object != null) {
            super.removeSource((LiveData)object);
        }
        this.mLiveDataSource = liveData;
        object = new w0(this);
        super.addSource(liveData, (Observer)object);
    }
}

