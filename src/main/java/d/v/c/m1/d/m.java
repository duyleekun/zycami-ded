/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.d;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.e.i.h;
import java.lang.constant.Constable;

public class m
extends ViewModel {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;

    public m() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
    }

    public void b(int n10) {
        int n11;
        boolean bl2;
        int n12;
        block3: {
            block0: {
                boolean bl3;
                block1: {
                    block2: {
                        n12 = 2131952140;
                        bl2 = false;
                        bl3 = true;
                        n11 = 2131952126;
                        if (n10 == bl3) break block0;
                        int n13 = 3;
                        if (n10 == n13) break block1;
                        n13 = 4;
                        if (n10 == n13) break block2;
                        n13 = 5;
                        if (n10 != n13) break block3;
                        n12 = 2131952134;
                        n11 = 2131952143;
                        break block1;
                    }
                    n12 = 2131952132;
                    break block3;
                }
                bl2 = bl3;
                break block3;
            }
            n12 = 2131952133;
        }
        MutableLiveData mutableLiveData = this.a;
        Constable constable = n12;
        d.v.e.i.h.g(mutableLiveData, constable);
        mutableLiveData = this.c;
        constable = Boolean.valueOf(bl2);
        d.v.e.i.h.g(mutableLiveData, constable);
        mutableLiveData = this.b;
        constable = n11;
        d.v.e.i.h.g(mutableLiveData, constable);
    }
}

