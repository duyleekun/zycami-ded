/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.q1;

import android.content.Context;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.a.f.c.b;
import d.v.c.d0;
import d.v.c.j0;
import d.v.c.q1.a;
import d.v.c.q1.a0;
import d.v.c.q1.b0;
import d.v.c.q1.c0;
import d.v.c.q1.g0$a;
import d.v.c.q1.g0$b;
import d.v.c.v0.q.d;
import d.v.c.v0.u.z;
import d.v.e.i.j;
import d.v.e.l.c1;
import d.v.e.l.c2;
import d.v.e.l.i1;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.j.e.c;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class g0
extends ViewModel {
    private final b a;
    private final MutableLiveData b;
    private final MutableLiveData c;
    private final MutableLiveData d;
    private final MutableLiveData e;
    private final MutableLiveData f;
    private final MutableLiveData g;
    private final MutableLiveData h;
    private final MutableLiveData i;
    public final MediatorLiveData j;
    public final MutableLiveData k;
    public final MutableLiveData l;
    public final MutableLiveData m;
    public final LiveData n;
    public final MutableLiveData o;
    private final LiveData p;
    public j q;
    private final MutableLiveData r;
    private final MutableLiveData s;
    private final MutableLiveData t;
    private final MutableLiveData u;
    private final MutableLiveData v;
    private final d.v.j.e.i.c1 w;
    private final d x;
    private final EditConfig$ResourceType[] y;

    public g0() {
        Object object = new MutableLiveData();
        this.b = object;
        object = new MutableLiveData();
        this.c = object;
        object = new MutableLiveData();
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        object = new MutableLiveData();
        this.f = object;
        object = new MutableLiveData();
        this.g = object;
        object = new MutableLiveData();
        this.h = object;
        object = new MutableLiveData();
        this.i = object;
        this.j = object;
        object = new MutableLiveData();
        this.k = object;
        object = new MutableLiveData();
        this.l = object;
        object = new MutableLiveData();
        this.m = object;
        object = new MutableLiveData();
        this.o = object;
        super();
        this.q = object;
        object = new MutableLiveData();
        this.r = object;
        object = new MutableLiveData();
        this.s = object;
        object = new MutableLiveData();
        this.t = object;
        object = new MutableLiveData();
        this.u = object;
        object = new MutableLiveData();
        this.v = object;
        object = EditConfig$ResourceType.values();
        Object object2 = new ArrayList();
        int n10 = ((EditConfig$ResourceType[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.MUSIC;
            EditConfig$ResourceType editConfig$ResourceType2 = object[i10];
            if (editConfig$ResourceType == editConfig$ResourceType2) continue;
            ((ArrayList)object2).add(editConfig$ResourceType2);
        }
        object = new EditConfig$ResourceType[((ArrayList)object2).size()];
        object = ((ArrayList)object2).toArray((T[])object);
        this.y = object;
        this.a = object = d.v.a.f.c.b.N();
        this.w = object2 = d.v.j.e.c.a();
        Object object3 = d.v.c.v0.d.b();
        this.x = object3;
        this.G();
        object = ((b)object).c();
        object3 = new a0(this);
        this.p = object = Transformations.map((LiveData)object, (Function)object3);
        object = ((d.v.j.e.i.c1)object2).k();
        object2 = new b0(this);
        this.n = object = Transformations.map((LiveData)object, (Function)object2);
        object2 = this.j;
        object3 = new c0(this);
        ((MediatorLiveData)object2).addSource((LiveData)object, (Observer)object3);
        object = this.j;
        object2 = this.k;
        object3 = new c0(this);
        ((MediatorLiveData)object).addSource((LiveData)object2, (Observer)object3);
        object = this.j;
        object2 = this.l;
        object3 = new c0(this);
        ((MediatorLiveData)object).addSource((LiveData)object2, (Observer)object3);
        object = this.j;
        object2 = this.m;
        object3 = new c0(this);
        ((MediatorLiveData)object).addSource((LiveData)object2, (Observer)object3);
        object = this.j;
        object2 = this.o;
        object3 = new c0(this);
        ((MediatorLiveData)object).addSource((LiveData)object2, (Observer)object3);
    }

    private /* synthetic */ Integer I(UserInfo object) {
        Object object2 = "";
        int n10 = 2131952926;
        Integer n11 = n10;
        if (object != null) {
            String string2 = ((UserInfo)object).getMobile();
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((UserInfo)object).getMail()));
            if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
                this.s.setValue(string2);
                this.u.setValue(object);
                object = this.t;
                int n12 = 2131952878;
                n11 = n12;
                ((MutableLiveData)object).setValue(n11);
                object = this.v;
                object2 = n12;
                ((MutableLiveData)object).setValue(object2);
                return 3;
            }
            bl2 = TextUtils.isEmpty((CharSequence)object);
            int n13 = 2131951980;
            if (!bl2) {
                this.s.setValue(object2);
                this.u.setValue(object);
                this.t.setValue(n11);
                object = this.v;
                object2 = n13;
                ((MutableLiveData)object).setValue(object2);
                return 2;
            }
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3) {
                this.s.setValue(string2);
                this.u.setValue(object2);
                object = this.t;
                object2 = n13;
                ((MutableLiveData)object).setValue(object2);
                this.v.setValue(n11);
                return 1;
            }
        }
        this.t.setValue(n11);
        this.v.setValue(n11);
        this.s.setValue(object2);
        this.u.setValue(object2);
        return 0;
    }

    public static /* synthetic */ Pair K(g0 g02, long l10) {
        return g02.s(l10);
    }

    public static /* synthetic */ void L(g0 g02, Pair pair) {
        g02.X(pair);
    }

    private void X(Pair object) {
        object = this.n;
        long l10 = this.t((LiveData)object);
        object = this.k;
        long l11 = this.t((LiveData)object);
        l10 += l11;
        object = this.l;
        l11 = this.t((LiveData)object);
        l10 += l11;
        object = this.m;
        l11 = this.t((LiveData)object);
        l10 += l11;
        object = this.o;
        l11 = this.t((LiveData)object);
        object = this.j;
        Pair pair = this.s(l10 += l11);
        ((MutableLiveData)object).setValue(pair);
    }

    public static /* synthetic */ MutableLiveData b(g0 g02) {
        return g02.g;
    }

    public static /* synthetic */ MutableLiveData c(g0 g02) {
        return g02.i;
    }

    private Pair s(long l10) {
        Long l11 = l10;
        String string2 = c2.b(l10, 1);
        return Pair.create(l11, string2);
    }

    private long t(LiveData liveData) {
        Object object;
        if (liveData != null && (object = liveData.getValue()) != null && (object = ((Pair)liveData.getValue()).first) != null) {
            return (Long)((Pair)liveData.getValue()).first;
        }
        return 0L;
    }

    public MutableLiveData A() {
        return this.f;
    }

    public MutableLiveData F() {
        return this.d;
    }

    public void G() {
        MutableLiveData mutableLiveData = this.f;
        Object object = j0.A();
        mutableLiveData.setValue(object);
        mutableLiveData = this.g;
        object = this.a;
        boolean bl2 = ((b)object).m();
        boolean bl3 = true;
        if (bl2 != bl3) {
            bl3 = false;
        }
        object = bl3;
        mutableLiveData.setValue(object);
        mutableLiveData = this.h;
        object = z.m().i();
        mutableLiveData.setValue(object);
        mutableLiveData = this.c;
        object = z.m().x();
        mutableLiveData.setValue(object);
        mutableLiveData = this.b;
        object = z.m().w();
        mutableLiveData.setValue(object);
        mutableLiveData = this.d;
        object = z.m().B();
        mutableLiveData.setValue(object);
        mutableLiveData = this.e;
        object = z.m().c();
        mutableLiveData.setValue(object);
        mutableLiveData = this.r;
        object = z.m().v();
        mutableLiveData.setValue(object);
    }

    public void H() {
        long l10 = s1.w(d0.b(EditConfig$ResourceType.MUSIC));
        MutableLiveData mutableLiveData = this.k;
        Object object = this.s(l10);
        mutableLiveData.setValue(object);
        object = this.l;
        long l11 = 0L;
        Pair pair = this.s(l11);
        ((MutableLiveData)object).setValue(pair);
        long l12 = s1.w(k2.K());
        object = this.m;
        pair = this.s(l12);
        ((MutableLiveData)object).setValue(pair);
        object = this.y;
        int n10 = ((EditConfig$ResourceType[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            File file = d0.b(object[i10]);
            long l13 = s1.w(file);
            l11 += l13;
        }
        l12 = i1.c();
        object = this.o;
        Pair pair2 = this.s(l11 += l12);
        ((MutableLiveData)object).setValue(pair2);
    }

    public /* synthetic */ Integer J(UserInfo userInfo) {
        return this.I(userInfo);
    }

    public void M() {
        z.m().C();
    }

    public void N(boolean bl2) {
        boolean bl3;
        Object object = this.e.getValue();
        if (object != null && (bl3 = ((Boolean)(object = (Boolean)this.e.getValue())).booleanValue()) == bl2) {
            return;
        }
        z.m().E(bl2);
        object = this.e;
        Boolean bl4 = bl2;
        ((MutableLiveData)object).setValue(bl4);
    }

    public void P(boolean bl2) {
        MutableLiveData mutableLiveData = this.h;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        z.m().I(bl2);
    }

    public void Q(Context context, boolean bl2) {
        boolean bl3;
        Object object = this.g.getValue();
        if (object != null && (bl3 = ((Boolean)(object = (Boolean)this.g.getValue())).booleanValue()) == bl2) {
            return;
        }
        object = this.a;
        g0$a g0$a = new g0$a(this, bl2, context);
        ((b)object).q(bl2, g0$a);
    }

    public void R(boolean bl2) {
        MutableLiveData mutableLiveData = this.r;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        z.m().S(bl2);
    }

    public void S(String string2) {
        this.i.setValue(string2);
    }

    public void T(boolean bl2) {
        boolean bl3;
        Object object = this.b.getValue();
        if (object != null && (bl3 = ((Boolean)(object = (Boolean)this.b.getValue())).booleanValue()) == bl2) {
            return;
        }
        z.m().T(bl2);
        object = this.b;
        Boolean bl4 = bl2;
        ((MutableLiveData)object).setValue(bl4);
    }

    public void U(Context object, boolean n10) {
        int n11;
        Object object2 = this.c.getValue();
        if (object2 != null && (n11 = ((Boolean)(object2 = (Boolean)this.c.getValue())).booleanValue()) == n10) {
            return;
        }
        z.m().U(n10 != 0);
        object2 = this.c;
        Boolean bl2 = n10 != 0;
        ((MutableLiveData)object2).setValue(bl2);
        if (!n10) {
            MutableLiveData mutableLiveData = this.i;
            n11 = 2131952930;
            object = d.v.f.i.g.m(object, n11);
            mutableLiveData.setValue(object);
        } else {
            MutableLiveData mutableLiveData = this.i;
            n11 = 2131952927;
            object = d.v.f.i.g.m(object, n11);
            mutableLiveData.setValue(object);
        }
    }

    public void V(boolean bl2) {
        MutableLiveData mutableLiveData = this.f;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        j0.F(bl2);
    }

    public void W(Context object, boolean n10) {
        int n11;
        Object object2 = this.d.getValue();
        if (object2 != null && (n11 = ((Boolean)(object2 = (Boolean)this.d.getValue())).booleanValue()) == n10) {
            return;
        }
        z.m().Y(n10 != 0);
        object2 = this.d;
        Boolean bl2 = n10 != 0;
        ((MutableLiveData)object2).setValue(bl2);
        if (n10) {
            MutableLiveData mutableLiveData = this.i;
            n11 = 2131952929;
            object = d.v.f.i.g.m(object, n11);
            mutableLiveData.setValue(object);
        } else {
            MutableLiveData mutableLiveData = this.i;
            n11 = 2131952877;
            object = d.v.f.i.g.m(object, n11);
            mutableLiveData.setValue(object);
        }
    }

    public void d(Context context) {
        z z10 = z.m();
        g0$b g0$b = new g0$b(this, context);
        z10.a(g0$b);
    }

    public void e() {
        s1.g(k2.K());
        MutableLiveData mutableLiveData = this.m;
        Pair pair = this.s(0L);
        mutableLiveData.setValue(pair);
    }

    public void f() {
        Object object = this.x;
        Object object2 = EditConfig$ResourceType.MUSIC;
        ((d)object).a((EditConfig$ResourceType)object2);
        object = this.k;
        object2 = this.s(0L);
        ((MutableLiveData)object).setValue(object2);
    }

    public void g() {
        Object object = this.x;
        Object object2 = this.y;
        ((d)object).b((EditConfig$ResourceType[])object2);
        i1.a();
        object = this.o;
        object2 = this.s(0L);
        ((MutableLiveData)object).setValue(object2);
    }

    public void i() {
        Executor executor = c1.b().a();
        d.v.j.e.i.c1 c12 = this.w;
        c12.getClass();
        a a10 = new a(c12);
        executor.execute(a10);
    }

    public void j() {
        MutableLiveData mutableLiveData = this.l;
        Pair pair = this.s(0L);
        mutableLiveData.setValue(pair);
    }

    public MutableLiveData k() {
        return this.e;
    }

    public String l(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return "";
        }
        return "\uff1a";
    }

    public MutableLiveData m() {
        return this.u;
    }

    public MutableLiveData n() {
        return this.v;
    }

    public MutableLiveData o() {
        return this.s;
    }

    public MutableLiveData p() {
        return this.t;
    }

    public LiveData r() {
        return this.p;
    }

    public MutableLiveData u() {
        return this.h;
    }

    public LiveData v() {
        return this.g;
    }

    public MutableLiveData w() {
        return this.r;
    }

    public MutableLiveData x() {
        return this.i;
    }

    public LiveData y() {
        return this.b;
    }

    public LiveData z() {
        return this.c;
    }
}

