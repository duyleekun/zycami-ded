/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class Transformations$3
implements Observer {
    public boolean mFirstTime = true;
    public final /* synthetic */ MediatorLiveData val$outputLiveData;

    public Transformations$3(MediatorLiveData mediatorLiveData) {
        this.val$outputLiveData = mediatorLiveData;
    }

    public void onChanged(Object object) {
        boolean bl2;
        Object object2 = this.val$outputLiveData.getValue();
        boolean bl3 = this.mFirstTime;
        if (bl3 || object2 == null && object != null || object2 != null && !(bl2 = object2.equals(object))) {
            bl2 = false;
            this.mFirstTime = false;
            object2 = this.val$outputLiveData;
            ((MutableLiveData)object2).setValue(object);
        }
    }
}

