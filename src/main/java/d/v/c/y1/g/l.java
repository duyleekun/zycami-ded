/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.g;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.x1.p.c;
import d.v.c.y1.g.h;
import d.v.c.y1.g.i;
import d.v.c.y1.g.j;
import d.v.c.y1.g.k;
import e.a.h0;
import e.a.q0.c.a;
import e.a.s0.b;
import e.a.v0.g;
import e.a.v0.o;
import java.lang.constant.Constable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class l
extends ViewModel {
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 3;
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private c d;
    private b e;

    public l() {
        Constable constable = 1;
        Object object = new MutableLiveData(constable);
        this.a = object;
        constable = 3;
        object = new MutableLiveData(constable);
        this.b = object;
        constable = Boolean.FALSE;
        object = new MutableLiveData(constable);
        this.c = object;
        this.d = object = new c();
    }

    public static /* synthetic */ Integer f(int n10, Long l10) {
        int n11 = l10.intValue();
        return n10 - n11;
    }

    private /* synthetic */ void g(Integer n10) {
        MutableLiveData mutableLiveData = this.b;
        int n11 = n10;
        int n12 = n11 > 0 ? n10 : 1;
        n10 = n12;
        d.v.e.i.h.g(mutableLiveData, n10);
    }

    public static /* synthetic */ void j(Throwable throwable) {
    }

    private /* synthetic */ void k() {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl2 = Boolean.TRUE;
        d.v.e.i.h.g(mutableLiveData, bl2);
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

    public Integer e() {
        Object object = this.a.getValue();
        if (object == null) {
            int n10 = 1;
            object = n10;
        } else {
            object = (Integer)this.a.getValue();
        }
        return object;
    }

    public /* synthetic */ void i(Integer n10) {
        this.g(n10);
    }

    public /* synthetic */ void l() {
        this.k();
    }

    public List m() {
        return (List)this.d.a();
    }

    public void n(int n10) {
        this.o();
        Object object = this.b;
        Object object2 = n10;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        long l10 = n10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        object = e.a.j.y3(1L, l10, 1L, 1L, timeUnit);
        object2 = new j(n10);
        Object object3 = ((e.a.j)object).R3((o)object2);
        object = e.a.q0.c.a.c();
        object3 = ((e.a.j)object3).s4((h0)object);
        object = new h(this);
        object2 = k.a;
        i i10 = new i(this);
        this.e = object3 = ((e.a.j)object3).f((g)object, (g)object2, i10);
    }

    public void o() {
        b b10 = this.e;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.e = null;
        }
    }

    public void onCleared() {
        super.onCleared();
    }

    public void p(List list) {
        this.d.b(list);
    }
}

