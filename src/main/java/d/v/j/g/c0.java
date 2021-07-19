/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import d.v.e.i.h;
import d.v.j.g.o;
import d.v.j.g.q;
import d.v.j.g.r;
import d.v.j.g.s;
import d.v.j.g.t;
import d.v.j.g.u;
import e.a.c1.b;
import e.a.h0;
import e.a.i0;
import e.a.q0.c.a;
import e.a.v0.g;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Supplier;

public class c0 {
    public static LiveData a(Object object, Function object2, boolean bl2) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        object = i0.x0(object);
        Object object3 = bl2 ? a.c() : b.d();
        object = ((i0)object).O0((h0)object3);
        object2.getClass();
        object3 = new o((Function)object2);
        object = ((i0)object).z0((e.a.v0.o)object3);
        object2 = new t(mutableLiveData);
        ((i0)object).d((g)object2);
        return mutableLiveData;
    }

    public static LiveData b(Supplier supplier, Executor executor) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (executor != null) {
            u u10 = new u(mutableLiveData, supplier);
            executor.execute(u10);
        } else {
            supplier = supplier.get();
            h.g(mutableLiveData, supplier);
        }
        return mutableLiveData;
    }

    public static LiveData c(Supplier object, boolean bl2) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        Object object2 = i0.x0(Boolean.TRUE);
        Object object3 = bl2 ? a.c() : b.d();
        object3 = ((i0)object2).O0((h0)object3);
        object2 = new s((Supplier)object);
        object = ((i0)object3).z0((e.a.v0.o)object2);
        object3 = new r(mutableLiveData);
        ((i0)object).d((g)object3);
        return mutableLiveData;
    }

    public static void d() {
    }

    public static /* synthetic */ void e(MutableLiveData mutableLiveData, Supplier supplier) {
        supplier = supplier.get();
        h.g(mutableLiveData, supplier);
    }

    public static /* synthetic */ Object f(Supplier supplier, Boolean bl2) {
        return supplier.get();
    }

    public static /* synthetic */ void g(MutableLiveData mutableLiveData, Object object) {
        h.g(mutableLiveData, object);
    }

    public static /* synthetic */ void h(MutableLiveData mutableLiveData, Object object) {
        h.g(mutableLiveData, object);
    }

    public static /* synthetic */ LiveData i(Function function, boolean bl2, Object object) {
        return c0.a(object, function, bl2);
    }

    public static LiveData j(LiveData liveData, Function function, boolean bl2) {
        q q10 = new q(function, bl2);
        return Transformations.switchMap(liveData, q10);
    }
}

