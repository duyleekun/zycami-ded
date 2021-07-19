/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;

public class MutableLiveData
extends LiveData {
    public MutableLiveData() {
    }

    public MutableLiveData(Object object) {
        super(object);
    }

    public void postValue(Object object) {
        super.postValue(object);
    }

    public void setValue(Object object) {
        super.setValue(object);
    }
}

