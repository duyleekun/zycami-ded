/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.l0$b;

public class y
extends ViewModel {
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public boolean d;

    public y() {
        MutableLiveData mutableLiveData;
        Boolean bl2 = Boolean.FALSE;
        this.a = mutableLiveData = new MutableLiveData(bl2);
        this.b = mutableLiveData = new MutableLiveData(bl2);
        this.c = mutableLiveData = new MutableLiveData();
        this.d = false;
    }

    public String b(int n10) {
        int n11;
        String string2 = n10 != 0 ? (n10 != (n11 = 1) ? l0$b.f : l0$b.d) : l0$b.c;
        return string2;
    }
}

