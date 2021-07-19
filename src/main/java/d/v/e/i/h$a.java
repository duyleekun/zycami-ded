/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.MutableLiveData;

public class h$a
implements Runnable {
    private final MutableLiveData a;
    private final Object b;

    private h$a(MutableLiveData mutableLiveData, Object object) {
        this.a = mutableLiveData;
        this.b = object;
    }

    public static h$a a(MutableLiveData mutableLiveData, Object object) {
        h$a h$a = new h$a(mutableLiveData, object);
        return h$a;
    }

    public void run() {
        MutableLiveData mutableLiveData = this.a;
        Object object = this.b;
        mutableLiveData.setValue(object);
    }
}

