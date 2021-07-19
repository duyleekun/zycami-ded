/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.v.c.i1.t2;

import android.net.Uri;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.f.b.a;
import d.v.c.i1.t2.k;
import d.v.c.i1.t2.l;
import d.v.c.i1.t2.m;
import d.v.c.i1.t2.n;
import d.v.c.i1.t2.o;
import d.v.c.i1.t2.p;
import d.v.c.i1.t2.q;
import d.v.c.v0.f;
import d.v.c.v0.g;
import d.v.c.v0.u.x;

public class i0
extends ViewModel {
    private final x a;
    private final MutableLiveData b;
    private final MutableLiveData c;
    private final LiveData d;
    private final LiveData e;
    private final LiveData f;
    private final LiveData g;
    private final LiveData h;
    private final LiveData i;
    private final LiveData j;
    private final LiveData k;
    private final LiveData l;
    private Uri m;
    private final MutableLiveData n;
    private int o;

    public i0() {
        LiveData liveData;
        this.b = liveData = new MutableLiveData();
        this.c = liveData = new MutableLiveData();
        this.m = null;
        Object object = new MutableLiveData();
        this.n = object;
        this.a = object = d.v.c.v0.f.a();
        Object object2 = new m(this);
        this.f = object2 = Transformations.map(liveData, (Function)object2);
        Object object3 = p.a;
        this.d = object3 = Transformations.switchMap((LiveData)object2, (Function)object3);
        object3 = d.v.c.i1.t2.n.a;
        this.e = object2 = Transformations.switchMap((LiveData)object2, (Function)object3);
        object2 = new o(this);
        this.i = object2 = Transformations.map(liveData, (Function)object2);
        object3 = d.v.c.i1.t2.k.a;
        this.g = object3 = Transformations.switchMap((LiveData)object2, (Function)object3);
        object3 = q.a;
        this.h = object2 = Transformations.switchMap((LiveData)object2, (Function)object3);
        object2 = new l(this);
        liveData = Transformations.switchMap(liveData, (Function)object2);
        this.j = liveData;
        liveData = object.h();
        this.k = liveData;
        liveData = object.i();
        this.l = liveData;
    }

    private /* synthetic */ g n(Integer n10) {
        x x10 = this.a;
        int n11 = n10;
        return x10.m(n11);
    }

    public static /* synthetic */ LiveData p(g g10) {
        return g10.a;
    }

    public static /* synthetic */ LiveData r(g g10) {
        return g10.b;
    }

    private /* synthetic */ g s(Integer n10) {
        x x10 = this.a;
        int n11 = n10;
        return x10.u(n11);
    }

    public static /* synthetic */ LiveData u(g g10) {
        return g10.a;
    }

    public static /* synthetic */ LiveData v(g g10) {
        return g10.b;
    }

    private /* synthetic */ LiveData w(Integer n10) {
        x x10 = this.a;
        int n11 = n10;
        return x10.s(n11, true);
    }

    public void A() {
        Object object = this.i.getValue();
        if (object != null) {
            object = ((g)this.i.getValue()).c;
            object.load();
        }
    }

    public void F() {
        MutableLiveData mutableLiveData = this.c;
        Object object = mutableLiveData.getValue();
        mutableLiveData.setValue(object);
    }

    public void G() {
        Object object = this.f.getValue();
        if (object != null) {
            object = ((g)this.f.getValue()).c;
            object.load();
        }
    }

    public void H(Uri uri) {
        this.m = uri;
    }

    public void I(String string2) {
        this.n.setValue(string2);
    }

    public void J(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public void K(int n10) {
        this.o = n10;
    }

    public void L(int n10) {
        int n11;
        Object object = this.c.getValue();
        if (object != null && (n11 = ((Integer)(object = (Integer)this.c.getValue())).intValue()) == n10) {
            return;
        }
        object = this.c;
        Integer n12 = n10;
        ((MutableLiveData)object).setValue(n12);
    }

    public void M() {
        this.a.w();
    }

    public void N() {
        this.a.C();
    }

    public void P(UserInfo userInfo, a a10) {
        this.a.t(userInfo, a10);
    }

    public Uri b() {
        return this.m;
    }

    public MutableLiveData c() {
        return this.n;
    }

    public MutableLiveData d() {
        return this.b;
    }

    public LiveData e() {
        return this.g;
    }

    public LiveData f() {
        return this.h;
    }

    public LiveData g() {
        return this.k;
    }

    public LiveData i() {
        return this.l;
    }

    public int j() {
        return this.o;
    }

    public LiveData k() {
        return this.j;
    }

    public LiveData l() {
        return this.d;
    }

    public LiveData m() {
        return this.e;
    }

    public /* synthetic */ g o(Integer n10) {
        return this.n(n10);
    }

    public /* synthetic */ g t(Integer n10) {
        return this.s(n10);
    }

    public /* synthetic */ LiveData x(Integer n10) {
        return this.w(n10);
    }

    public void y() {
        Object object = this.i.getValue();
        if (object != null) {
            object = ((g)this.i.getValue()).d;
            object.load();
        }
    }

    public void z() {
        Object object = this.f.getValue();
        if (object != null) {
            object = ((g)this.f.getValue()).d;
            object.load();
        }
    }
}

