/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class SavedStateHandle$SavingStateLiveData
extends MutableLiveData {
    private SavedStateHandle mHandle;
    private String mKey;

    public SavedStateHandle$SavingStateLiveData(SavedStateHandle savedStateHandle, String string2) {
        this.mKey = string2;
        this.mHandle = savedStateHandle;
    }

    public SavedStateHandle$SavingStateLiveData(SavedStateHandle savedStateHandle, String string2, Object object) {
        super(object);
        this.mKey = string2;
        this.mHandle = savedStateHandle;
    }

    public void detach() {
        this.mHandle = null;
    }

    public void setValue(Object object) {
        Object object2 = this.mHandle;
        if (object2 != null) {
            object2 = ((SavedStateHandle)object2).mRegular;
            String string2 = this.mKey;
            object2.put(string2, object);
        }
        super.setValue(object);
    }
}

