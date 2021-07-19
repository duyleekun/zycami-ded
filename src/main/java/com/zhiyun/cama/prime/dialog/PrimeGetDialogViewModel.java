/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.prime.dialog;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.me.remote.PrimeManager;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PRIME_STATUS;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PrimeShowType;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$a;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$b;
import com.zhiyun.cama.prime.model.ActivatePrimeInfo;
import d.v.a.f.b.a;
import d.v.e.i.h;

public class PrimeGetDialogViewModel
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private MutableLiveData i;

    public PrimeGetDialogViewModel() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
        this.d = mutableLiveData = new MutableLiveData();
        this.e = mutableLiveData = new MutableLiveData();
        this.f = mutableLiveData = new MutableLiveData();
        this.g = mutableLiveData = new MutableLiveData();
        this.h = mutableLiveData = new MutableLiveData();
        this.i = mutableLiveData = new MutableLiveData();
        mutableLiveData = this.h;
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_PENDING;
        mutableLiveData.setValue((Object)primeGetDialogViewModel$PRIME_STATUS);
    }

    public static /* synthetic */ MutableLiveData b(PrimeGetDialogViewModel primeGetDialogViewModel) {
        return primeGetDialogViewModel.i;
    }

    public static /* synthetic */ MutableLiveData c(PrimeGetDialogViewModel primeGetDialogViewModel) {
        return primeGetDialogViewModel.h;
    }

    private void r(int n10) {
        MutableLiveData mutableLiveData = this.d;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    private void s(int n10) {
        MutableLiveData mutableLiveData = this.b;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    private void t(Object object) {
        d.v.e.i.h.g(this.c, object);
    }

    private void v(int n10) {
        MutableLiveData mutableLiveData = this.a;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    public MutableLiveData d() {
        return this.i;
    }

    public MutableLiveData e() {
        return this.f;
    }

    public MutableLiveData f() {
        return this.e;
    }

    public MutableLiveData g() {
        return this.d;
    }

    public MutableLiveData i() {
        return this.b;
    }

    public MutableLiveData j() {
        return this.c;
    }

    public MutableLiveData k() {
        return this.g;
    }

    public PrimeGetDialogViewModel$PrimeShowType l() {
        Object object = this.g;
        object = object != null && (object = object.getValue()) != null ? (PrimeGetDialogViewModel$PrimeShowType)((Object)this.g.getValue()) : PrimeGetDialogViewModel$PrimeShowType.PRIME_SHOW_TYPE_OFFICIAL;
        return object;
    }

    public MutableLiveData m() {
        return this.h;
    }

    public PrimeGetDialogViewModel$PRIME_STATUS n() {
        Object object = this.h;
        object = object != null && (object = object.getValue()) != null ? (PrimeGetDialogViewModel$PRIME_STATUS)((Object)this.h.getValue()) : PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_PENDING;
        return object;
    }

    public MutableLiveData o() {
        return this.a;
    }

    public void p(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            Object object = this.h;
            PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_RECEIVING;
            ((MutableLiveData)object).setValue((Object)primeGetDialogViewModel$PRIME_STATUS);
            object = new PrimeGetDialogViewModel$a(this);
            PrimeManager.requestActivatePrime(string2, string3, (a)object);
        }
    }

    public void u(PrimeGetDialogViewModel$PrimeShowType primeGetDialogViewModel$PrimeShowType) {
        d.v.e.i.h.g(this.g, (Object)primeGetDialogViewModel$PrimeShowType);
    }

    /*
     * WARNING - void declaration
     */
    public void w(PrimeGetDialogViewModel$PRIME_STATUS object) {
        Boolean bl2 = Boolean.TRUE;
        Object object2 = Boolean.FALSE;
        PrimeGetDialogViewModel$PrimeShowType primeGetDialogViewModel$PrimeShowType = this.l();
        Object object3 = PrimeGetDialogViewModel$b.a;
        int n10 = ((Enum)object).ordinal();
        n10 = object3[n10];
        int n11 = 2131952668;
        int n12 = 2131952655;
        int n13 = 2131952670;
        int n14 = 2131952677;
        int n15 = 2131952669;
        int n16 = 1;
        float f10 = Float.MIN_VALUE;
        if (n10 != n16) {
            int n17 = 2;
            f10 = 2.8E-45f;
            if (n10 != n17) {
                int n18 = 3;
                if (n10 != n18) {
                    int n19 = 4;
                    if (n10 == n19 && (object = (ActivatePrimeInfo)this.i.getValue()) != null) {
                        this.v(2131952672);
                        int n20 = 2131952710;
                        this.s(n20);
                        object = ((ActivatePrimeInfo)object).getCount();
                        this.t(object);
                        int n21 = 2131951877;
                        this.r(n21);
                        d.v.e.i.h.g(this.e, bl2);
                        object = this.f;
                        d.v.e.i.h.g((MutableLiveData)object, object2);
                    }
                } else {
                    this.v(2131952671);
                    int n22 = 2131952660;
                    this.s(n22);
                    this.t(null);
                    this.r(n15);
                    d.v.e.i.h.g(this.e, object2);
                    object = this.f;
                    d.v.e.i.h.g((MutableLiveData)object, bl2);
                }
            } else {
                int n23;
                object = PrimeGetDialogViewModel$PrimeShowType.PRIME_SHOW_TYPE_OFFICIAL;
                if (primeGetDialogViewModel$PrimeShowType != object) {
                    n13 = n14;
                }
                this.v(n13);
                if (primeGetDialogViewModel$PrimeShowType != object) {
                    n23 = n12;
                }
                this.s(n23);
                this.t(null);
                int n24 = 2131952707;
                this.r(n24);
                d.v.e.i.h.g(this.e, object2);
                object = this.f;
                d.v.e.i.h.g((MutableLiveData)object, object2);
            }
        } else {
            boolean bl4;
            void var8_17;
            Boolean bl5;
            int n25;
            int n26;
            object = PrimeGetDialogViewModel$PrimeShowType.PRIME_SHOW_TYPE_OFFICIAL;
            bl2 = null;
            if (primeGetDialogViewModel$PrimeShowType == object) {
                n26 = n16;
            } else {
                n26 = 0;
                object2 = null;
            }
            if (n26 == 0) {
                n13 = n14;
            }
            this.v(n13);
            if (n26 == 0) {
                n25 = n12;
            }
            this.s(n25);
            this.t(null);
            object2 = PrimeGetDialogViewModel$PrimeShowType.PRIME_SHOW_TYPE_VISITOR;
            if (primeGetDialogViewModel$PrimeShowType == object2) {
                n15 = 2131952654;
            }
            this.r(n15);
            object3 = this.e;
            if (primeGetDialogViewModel$PrimeShowType == object2) {
                int n27 = n16;
            } else {
                boolean bl6 = false;
                bl5 = null;
            }
            bl5 = (boolean)var8_17;
            d.v.e.i.h.g((MutableLiveData)object3, bl5);
            object3 = this.f;
            if (primeGetDialogViewModel$PrimeShowType != object && primeGetDialogViewModel$PrimeShowType != object2 && primeGetDialogViewModel$PrimeShowType != (object = PrimeGetDialogViewModel$PrimeShowType.PRIME_SHOW_WEB_VIEW)) {
                bl4 = false;
                f10 = 0.0f;
            }
            object = bl4;
            d.v.e.i.h.g((MutableLiveData)object3, object);
        }
    }
}

