/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.Resources
 */
package com.zhiyun.device.active;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.common.util.Times;
import com.zhiyun.device.R$string;
import com.zhiyun.device.active.ActivationViewModel$ProcessStatus;
import com.zhiyun.device.active.ActivationViewModel$a;
import com.zhiyun.device.active.ActivationViewModel$b;
import com.zhiyun.device.active.ActivationViewModel$c;
import com.zhiyun.device.active.ActivationViewModel$d;
import com.zhiyun.device.active.ActivationViewModel$e;
import com.zhiyun.device.active.ActivationViewModel$f;
import com.zhiyun.device.data.local.entity.ActivationData;
import d.v.e.i.h;
import d.v.e.l.b2;
import d.v.e.l.c1;
import d.v.e.l.o1;
import d.v.e0.ce;
import d.v.e0.ie.l;
import d.v.e0.td;
import d.v.g.b;
import d.v.g.f.b.c;
import d.v.p.a;
import d.v.p.a$c;
import d.v.q.e;
import java.lang.constant.Constable;
import java.util.concurrent.Executor;
import k.f;

public class ActivationViewModel
extends AndroidViewModel {
    public static final int A = 252;
    public static final int s = 0;
    public static final int t = 1;
    public static final int u = 2;
    public static final int v = 3;
    public static final int w = 4;
    public static final int x = 255;
    public static final int y = 254;
    public static final int z = 253;
    private Context a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private MediatorLiveData i;
    private MutableLiveData j;
    private d.v.g.f.b.d.a k;
    private MutableLiveData l;
    private MutableLiveData m;
    private MutableLiveData n;
    private MutableLiveData o;
    private MutableLiveData p;
    private a q;
    private a$c r;

    public ActivationViewModel(Application object) {
        super((Application)object);
        Object object2 = new MutableLiveData();
        this.b = object2;
        object2 = new MutableLiveData();
        this.c = object2;
        Constable constable = 0;
        object2 = new MutableLiveData(constable);
        this.d = object2;
        object2 = new MutableLiveData();
        this.e = object2;
        object2 = new MutableLiveData();
        this.f = object2;
        object2 = new MutableLiveData();
        this.g = object2;
        object2 = new MutableLiveData();
        this.h = object2;
        super();
        this.i = object2;
        object2 = new MutableLiveData();
        this.j = object2;
        object2 = new MutableLiveData();
        this.l = object2;
        object2 = new MutableLiveData();
        this.m = object2;
        object2 = new MutableLiveData();
        this.n = object2;
        constable = Boolean.FALSE;
        object2 = new MutableLiveData(constable);
        this.o = object2;
        object2 = new MutableLiveData(constable);
        this.p = object2;
        this.r = object2 = new ActivationViewModel$a(this);
        this.a = object;
        object = d.v.p.a.c(d.v.e.f.a().c());
        this.q = object;
        object = d.v.g.f.b.c.b().a().e();
        this.k = object;
        this.s();
    }

    private /* synthetic */ void S(Integer object) {
        int n10;
        if (object != null && (n10 = ((Integer)object).intValue()) <= 0) {
            Object object2;
            int n11;
            n10 = (Integer)object;
            int n12 = 1;
            int n13 = -4;
            CharSequence charSequence = "";
            if (n10 != n13) {
                n11 = -3;
                if (n10 != n11) {
                    n11 = -2;
                    if (n10 != n11) {
                        object2 = this.a.getResources();
                        n11 = R$string.active_device_activation_other_error;
                        Object[] objectArray = new Object[n12];
                        Object object3 = this.t();
                        object3 = object3 == null ? charSequence : this.t();
                        objectArray[0] = object3;
                        object2 = o1.O(object2, n11, objectArray);
                    } else {
                        object2 = this.a.getResources();
                        n11 = R$string.active_device_activation_area_error;
                        object2 = o1.N(object2, n11);
                    }
                } else {
                    object2 = this.a.getResources();
                    n11 = R$string.active_device_activation_repeat_error;
                    object2 = o1.N(object2, n11);
                }
            } else {
                object2 = this.a.getResources();
                n11 = R$string.active_device_activation_version_error;
                object2 = o1.N(object2, n11);
            }
            this.e0((String)object2);
            object2 = this.z();
            object2 = object2 == null ? charSequence : this.z().e;
            Object[] objectArray = this.t();
            if (objectArray != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("(-");
                objectArray = this.t();
                ((StringBuilder)charSequence).append(objectArray);
                objectArray = ")";
                ((StringBuilder)charSequence).append((String)objectArray);
                charSequence = ((StringBuilder)charSequence).toString();
            }
            int n14 = (Integer)object;
            if (n14 == n13) {
                object = this.a.getResources();
                n10 = R$string.device_activation_fail_version_error;
                object = o1.N((Resources)object, n10);
            } else {
                object = this.a.getResources();
                n13 = R$string.device_activation_fail_describe;
                n11 = 2;
                objectArray = new Object[n11];
                objectArray[0] = object2;
                objectArray[n12] = charSequence;
                object = o1.O((Resources)object, n13, objectArray);
            }
            object2 = this.i;
            d.v.e.i.h.g((MutableLiveData)object2, object);
        }
    }

    private /* synthetic */ void U(td object) {
        Object object2;
        if (object != null && (object2 = ((td)object).e) != null) {
            object2 = this.m;
            ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus = ActivationViewModel$ProcessStatus.PROCESS_STATUS_SUCCESS;
            d.v.e.i.h.g((MutableLiveData)object2, (Object)activationViewModel$ProcessStatus);
            d.v.e.i.h.g(this.e, object);
            return;
        }
        object = this.m;
        object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_FAIL;
        d.v.e.i.h.g((MutableLiveData)object, object2);
    }

    private /* synthetic */ void W(ActivationData activationData) {
        d.v.g.f.b.d.a a10 = this.k;
        ActivationData[] activationDataArray = new ActivationData[]{activationData};
        a10.b(activationDataArray);
    }

    private void Y(String string2, Object ... object) {
        string2 = String.format(string2, (Object[])object);
        object = new StringBuilder();
        ((StringBuilder)object).append("device sn = %s activationCode = %s,");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        Object object2 = this.z().e;
        object2 = this.h.getValue();
        object = new Object[]{object2, object2};
        d.v.q.e.e(10001, string2, (Object[])object);
    }

    private void Z(String string2, Throwable throwable, Object ... object) {
        string2 = String.format(string2, (Object[])object);
        object = new StringBuilder();
        ((StringBuilder)object).append("device sn = %s activationCode = %s,");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        Object object2 = this.z().e;
        object2 = this.h.getValue();
        object = new Object[]{object2, object2};
        d.v.q.e.k(10001, throwable, string2, (Object[])object);
    }

    private void a0(ActivationData activationData) {
        Executor executor = c1.b().a();
        d.v.g.c.c c10 = new d.v.g.c.c(this, activationData);
        executor.execute(c10);
    }

    public static /* synthetic */ MutableLiveData b(ActivationViewModel activationViewModel) {
        return activationViewModel.g;
    }

    private void b0(byte[] byArray) {
        Object object = this.d;
        Object object2 = 2;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = ce.E0();
        object2 = new ActivationViewModel$d(this);
        ((ce)object).x5(byArray, (l)object2);
    }

    public static /* synthetic */ MutableLiveData c(ActivationViewModel activationViewModel) {
        return activationViewModel.f;
    }

    private void c0(String string2, String string3, d.v.g.d.a a10) {
        String string4;
        Object object;
        Object object2 = this;
        Object object3 = object = this.b.getValue();
        object3 = (Integer)object;
        Object object4 = object = this.c.getValue();
        object4 = (String)object;
        Object object5 = object = this.h.getValue();
        object5 = (String)object;
        object = this.z();
        int n10 = ((td)object).b.getCode();
        String string5 = ((td)object).a;
        String string6 = ((td)object).e;
        String string7 = d.v.g.b.a().b();
        String string8 = Times.TIME.getDate();
        object = this.I();
        Object object6 = object == null ? null : (object = String.valueOf(this.I()));
        object = this.L();
        Object object7 = object == null ? null : (object = String.valueOf(this.L()));
        Object object8 = d.v.g.f.c.a.a;
        int n11 = (Integer)object3;
        int n12 = this.G();
        Object object9 = object8.c(n11, (String)object4, string6, n10, string5, string7, (String)object7, (String)object6, (String)object5, string8, string2, n12, string3);
        object = string4;
        object2 = string4;
        string4 = string2;
        object8 = object;
        object2 = object9;
        object9 = string3;
        ((ActivationViewModel$f)object)(this, a10, (Integer)object3, (String)object4, string6, n10, string5, string7, (String)object7, (String)object6, (String)object5, string8, string2, string3);
        object2.h((f)object);
    }

    public static /* synthetic */ MutableLiveData d(ActivationViewModel activationViewModel) {
        return activationViewModel.d;
    }

    private void d0() {
        Object object = this.d;
        Integer n10 = 3;
        d.v.e.i.h.g((MutableLiveData)object, n10);
        object = new ActivationViewModel$e(this);
        this.c0("1", "", (d.v.g.d.a)object);
    }

    public static /* synthetic */ void e(ActivationViewModel activationViewModel, byte[] byArray) {
        activationViewModel.b0(byArray);
    }

    private void e0(String string2) {
        Integer n10 = (Integer)this.b.getValue();
        Object object = this.z();
        if (n10 != null && object != null) {
            n10 = null;
            object = "0";
            this.c0((String)object, string2, null);
        }
    }

    public static /* synthetic */ void f(ActivationViewModel activationViewModel, String string2, Throwable throwable, Object[] objectArray) {
        activationViewModel.Z(string2, throwable, objectArray);
    }

    public static /* synthetic */ void g(ActivationViewModel activationViewModel) {
        activationViewModel.d0();
    }

    public static /* synthetic */ void i(ActivationViewModel activationViewModel, ActivationData activationData) {
        activationViewModel.a0(activationData);
    }

    public static /* synthetic */ MutableLiveData j(ActivationViewModel activationViewModel) {
        return activationViewModel.l;
    }

    public static /* synthetic */ a$c k(ActivationViewModel activationViewModel) {
        return activationViewModel.r;
    }

    public static /* synthetic */ a l(ActivationViewModel activationViewModel) {
        return activationViewModel.q;
    }

    public static /* synthetic */ MutableLiveData m(ActivationViewModel activationViewModel) {
        return activationViewModel.o;
    }

    public static /* synthetic */ MutableLiveData n(ActivationViewModel activationViewModel) {
        return activationViewModel.n;
    }

    public static /* synthetic */ MutableLiveData o(ActivationViewModel activationViewModel) {
        return activationViewModel.h;
    }

    public static /* synthetic */ void p(ActivationViewModel activationViewModel, String string2, Object[] objectArray) {
        activationViewModel.Y(string2, objectArray);
    }

    public static /* synthetic */ MutableLiveData r(ActivationViewModel activationViewModel) {
        return activationViewModel.j;
    }

    private void s() {
        MediatorLiveData mediatorLiveData = this.i;
        MutableLiveData mutableLiveData = this.d;
        mediatorLiveData.removeSource(mutableLiveData);
        mediatorLiveData = this.i;
        mutableLiveData = this.d;
        d.v.g.c.b b10 = new d.v.g.c.b(this);
        mediatorLiveData.addSource(mutableLiveData, b10);
    }

    private void w() {
        boolean bl2;
        Object object = this.d;
        int n10 = 1;
        Object object2 = n10;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = (Integer)this.b.getValue();
        object2 = this.z();
        int n11 = -1;
        Integer n12 = n11;
        if (object != null && (bl2 = ce.A1()) && object2 != null) {
            Object object3 = d.v.e.f.a().c();
            bl2 = b2.m((Context)object3);
            if (!bl2) {
                object = this.j;
                object2 = 20300;
                d.v.e.i.h.g((MutableLiveData)object, object2);
                d.v.e.i.h.g(this.d, n12);
                return;
            }
            int n13 = ((td)object2).b.getCode();
            String string2 = ((td)object2).a;
            String string3 = ((td)object2).e;
            object2 = this.I();
            n11 = 0;
            n12 = null;
            Object object4 = object2 == null ? null : (object2 = String.valueOf(this.I()));
            object2 = this.L();
            Object object5 = object2 == null ? null : (object2 = String.valueOf(this.L()));
            object3 = d.v.g.f.c.a.a;
            int n14 = (Integer)object;
            object = object3.b(n14, n13, string2, string3, (String)object5, (String)object4);
            object2 = new ActivationViewModel$c(this);
            object.h((f)object2);
            return;
        }
        object = this.j;
        object2 = 29300;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        d.v.e.i.h.g(this.d, n12);
    }

    public MutableLiveData A() {
        return this.n;
    }

    public MutableLiveData F() {
        return this.p;
    }

    public boolean G() {
        boolean bl2;
        Object object = this.p;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Boolean)this.p.getValue();
            bl2 = (Boolean)object;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public MutableLiveData H() {
        return this.g;
    }

    public Double I() {
        Object object = this.g;
        object = object == null ? null : (Double)((LiveData)object).getValue();
        return object;
    }

    public MutableLiveData J() {
        return this.l;
    }

    public MutableLiveData K() {
        return this.f;
    }

    public Double L() {
        Object object = this.f;
        object = object == null ? null : (Double)((LiveData)object).getValue();
        return object;
    }

    public void M() {
        Object object = this.z();
        if (object == null) {
            object = this.n;
            ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus = ActivationViewModel$ProcessStatus.PROCESS_STATUS_FAIL;
            d.v.e.i.h.g((MutableLiveData)object, (Object)activationViewModel$ProcessStatus);
            return;
        }
        object = ((td)object).e;
        object = d.v.g.f.c.a.a.a((String)object);
        ActivationViewModel$b activationViewModel$b = new ActivationViewModel$b(this);
        object.h(activationViewModel$b);
    }

    public MutableLiveData N() {
        return this.o;
    }

    public boolean P() {
        boolean bl2;
        Object object = this.o;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Boolean)this.o.getValue();
            bl2 = (Boolean)object;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public MutableLiveData Q() {
        return this.c;
    }

    public MutableLiveData R() {
        return this.b;
    }

    public /* synthetic */ void T(Integer n10) {
        this.S(n10);
    }

    public /* synthetic */ void V(td td2) {
        this.U(td2);
    }

    public /* synthetic */ void X(ActivationData activationData) {
        this.W(activationData);
    }

    public void f0() {
        MutableLiveData mutableLiveData = this.p;
        Boolean bl2 = Boolean.TRUE;
        d.v.e.i.h.g(mutableLiveData, bl2);
    }

    public void g0() {
        this.w();
    }

    public void h0() {
        Object object = this.l;
        Object object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_ING;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = this.I();
        if (object != null && (object = this.L()) != null) {
            object = this.l;
            object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_SUCCESS;
            d.v.e.i.h.g((MutableLiveData)object, object2);
            return;
        }
        object = this.q;
        object2 = this.r;
        ((a)object).e((a$c)object2);
    }

    public Integer t() {
        Object object = this.j;
        object = object == null ? null : (Integer)((LiveData)object).getValue();
        return object;
    }

    public MediatorLiveData u() {
        return this.i;
    }

    public MutableLiveData v() {
        return this.d;
    }

    public void x() {
        Object object = this.m;
        Object object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_ING;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        boolean bl2 = ce.A1();
        if (!bl2) {
            object = this.m;
            object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_FAIL;
            d.v.e.i.h.g((MutableLiveData)object, object2);
            return;
        }
        object = this.z();
        if (object != null) {
            object = this.m;
            object2 = ActivationViewModel$ProcessStatus.PROCESS_STATUS_SUCCESS;
            d.v.e.i.h.g((MutableLiveData)object, object2);
            return;
        }
        object = ce.E0();
        object2 = new d.v.g.c.a(this);
        ((ce)object).z0((l)object2);
    }

    public MutableLiveData y() {
        return this.m;
    }

    public td z() {
        Object object = this.e;
        object = object == null ? null : (td)((LiveData)object).getValue();
        return object;
    }
}

