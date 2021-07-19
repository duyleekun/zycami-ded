/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.e.i.h;

public class t
extends ViewModel {
    private static final int d = 64;
    public static final int e = 2;
    public static final int f = 0;
    public static final int g = 1;
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;

    public t() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        Boolean bl2 = Boolean.TRUE;
        this.c = mutableLiveData = new MutableLiveData(bl2);
    }

    public MutableLiveData b() {
        return this.c;
    }

    public MutableLiveData c() {
        return this.b;
    }

    public MutableLiveData d() {
        return this.a;
    }

    public void e(int n10) {
        int n11;
        boolean bl2 = true;
        if (n10 != 0 && n10 != (n11 = 2)) {
            bl2 = false;
        }
        this.i(bl2);
    }

    public void f(int n10, float f10) {
        int n11 = 1;
        if (n10 == n11) {
            MutableLiveData mutableLiveData = this.a;
            Integer n12 = 64;
            h.g(mutableLiveData, n12);
            return;
        }
        MutableLiveData mutableLiveData = this.a;
        Integer n13 = (int)(f10 * 64.0f);
        h.g(mutableLiveData, n13);
    }

    public void g(int n10) {
        Boolean bl2;
        int n11 = 1;
        if (n10 == 0 || n10 != n11) {
            n11 = 0;
            bl2 = null;
        }
        MutableLiveData mutableLiveData = this.b;
        bl2 = n11 != 0;
        h.g(mutableLiveData, bl2);
    }

    public void i(boolean bl2) {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }
}

