/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.b;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import d.v.a.f.b.a;
import d.v.c.j1.b.a0;
import d.v.c.j1.b.q;
import d.v.c.j1.b.r;
import d.v.c.j1.b.s;
import d.v.c.j1.b.t;
import d.v.c.j1.b.u;
import d.v.c.j1.b.v;
import d.v.c.j1.b.w;
import d.v.c.j1.b.x;
import d.v.c.j1.b.y;
import d.v.c.j1.b.z;
import d.v.c.v0.f;
import d.v.c.v0.g;
import d.v.j.e.h.k;

public class o0
extends ViewModel {
    private d.v.c.v0.u.x a;
    private final MutableLiveData b;
    private final LiveData c;
    private final LiveData d;
    private final LiveData e;
    private final MutableLiveData f;
    private final MutableLiveData g;
    private final LiveData h;
    private final LiveData i;
    private final LiveData j;
    private final LiveData k;
    private final LiveData l;
    private final LiveData m;
    private final LiveData n;
    private final MutableLiveData o;
    private final LiveData p;

    public o0() {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object object = new MutableLiveData();
        this.b = object;
        Object object2 = new MutableLiveData();
        this.f = object2;
        this.g = mutableLiveData2 = new MutableLiveData();
        this.o = mutableLiveData = new MutableLiveData();
        Object object3 = d.v.c.v0.f.a();
        this.a = object3;
        object3 = new r(this);
        this.e = object3 = Transformations.map((LiveData)object, (Function)object3);
        Object object4 = t.a;
        this.c = object4 = Transformations.switchMap((LiveData)object3, (Function)object4);
        object4 = s.a;
        this.d = object3 = Transformations.switchMap((LiveData)object3, (Function)object4);
        object3 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(object3);
        object = new y(this);
        this.l = object = Transformations.map((LiveData)object2, (Function)object);
        object4 = new z(this);
        this.m = object4 = Transformations.map(mutableLiveData2, (Function)object4);
        Object object5 = x.a;
        this.h = object5 = Transformations.switchMap((LiveData)object, (Function)object5);
        object5 = q.a;
        this.i = object5 = Transformations.switchMap((LiveData)object4, (Function)object5);
        object5 = v.a;
        this.j = object = Transformations.switchMap((LiveData)object, (Function)object5);
        object = u.a;
        this.k = object = Transformations.switchMap((LiveData)object4, (Function)object);
        ((MutableLiveData)object2).setValue(object3);
        mutableLiveData2.setValue(object3);
        object = new a0(this);
        this.n = object = Transformations.switchMap(mutableLiveData, (Function)object);
        object2 = w.a;
        this.p = object = Transformations.map((LiveData)object, (Function)object2);
    }

    private /* synthetic */ LiveData A(Boolean bl2) {
        return this.a.l();
    }

    private /* synthetic */ g m(Boolean bl2) {
        return this.a.loadMessageLike();
    }

    public static /* synthetic */ LiveData o(g g10) {
        return g10.a;
    }

    public static /* synthetic */ Boolean p(k k10) {
        return ((MessageUnReadCount)k10.c).getPunished();
    }

    public static /* synthetic */ LiveData r(g g10) {
        return g10.b;
    }

    private /* synthetic */ g s(Boolean bl2) {
        return this.a.loadMessageSystem();
    }

    private /* synthetic */ g u(Boolean bl2) {
        return this.a.loadMessageViolation();
    }

    public static /* synthetic */ LiveData w(g g10) {
        return g10.a;
    }

    public static /* synthetic */ LiveData x(g g10) {
        return g10.a;
    }

    public static /* synthetic */ LiveData y(g g10) {
        return g10.b;
    }

    public static /* synthetic */ LiveData z(g g10) {
        return g10.b;
    }

    public /* synthetic */ LiveData F(Boolean bl2) {
        return this.A(bl2);
    }

    public void G() {
        Object object = this.e.getValue();
        if (object != null) {
            object = ((g)this.e.getValue()).d;
            object.load();
        }
    }

    public void H() {
        Object object = this.l.getValue();
        if (object != null) {
            object = ((g)this.l.getValue()).d;
            object.load();
        }
    }

    public void I() {
        Object object = this.m.getValue();
        if (object != null) {
            object = ((g)this.m.getValue()).d;
            object.load();
        }
    }

    public void J() {
        Object object = this.e.getValue();
        if (object != null) {
            object = ((g)this.e.getValue()).c;
            object.load();
        }
    }

    public void K() {
        Object object = this.l.getValue();
        if (object != null) {
            object = ((g)this.l.getValue()).c;
            object.load();
        }
    }

    public void L() {
        MutableLiveData mutableLiveData = this.o;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
    }

    public void M() {
        Object object = this.m.getValue();
        if (object != null) {
            object = ((g)this.m.getValue()).c;
            object.load();
        }
    }

    public void N(MessagePageType messagePageType) {
        this.a.x(messagePageType);
    }

    public void b(int n10) {
        this.a.v(n10);
    }

    public void c(MessagePageType messagePageType, int n10, a a10) {
        this.a.y(messagePageType, n10, a10);
    }

    public LiveData d() {
        return this.d;
    }

    public LiveData e() {
        return this.c;
    }

    public LiveData f() {
        return this.h;
    }

    public LiveData g() {
        return this.n;
    }

    public LiveData i() {
        return this.i;
    }

    public LiveData j() {
        return this.p;
    }

    public LiveData k() {
        return this.j;
    }

    public LiveData l() {
        return this.k;
    }

    public /* synthetic */ g n(Boolean bl2) {
        return this.m(bl2);
    }

    public /* synthetic */ g t(Boolean bl2) {
        return this.s(bl2);
    }

    public /* synthetic */ g v(Boolean bl2) {
        return this.u(bl2);
    }
}

