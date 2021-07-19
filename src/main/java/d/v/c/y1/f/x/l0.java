/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.x;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import d.v.c.y1.f.x.y;
import d.v.e.i.h;

public class l0
extends ViewModel {
    private final MutableLiveData a;
    private final MutableLiveData b;
    private final LiveData c;

    public l0() {
        LiveData liveData;
        Object object = Boolean.FALSE;
        this.a = liveData = new MutableLiveData(object);
        object = 0;
        this.b = liveData = new MutableLiveData(object);
        object = y.a;
        liveData = Transformations.map(liveData, (Function)object);
        this.c = liveData;
    }

    public static /* synthetic */ Boolean g(Integer n10) {
        int n11 = n10;
        if (n11 > 0) {
            n11 = 1;
        } else {
            n11 = 0;
            n10 = null;
        }
        return n11 != 0;
    }

    public MutableLiveData b() {
        return this.a;
    }

    public boolean c() {
        boolean bl2;
        Object object = this.a.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.a.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public LiveData d() {
        return this.c;
    }

    public MutableLiveData e() {
        return this.b;
    }

    public int f() {
        int n10;
        Object object = this.b.getValue();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)this.b.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public void i(boolean bl2) {
        MutableLiveData mutableLiveData = this.a;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void j(int n10) {
        MutableLiveData mutableLiveData = this.b;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }
}

