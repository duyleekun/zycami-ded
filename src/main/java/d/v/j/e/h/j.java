/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.NetCallback;
import d.v.e.l.c1;
import d.v.j.e.h.e;
import d.v.j.e.h.f;
import d.v.j.e.h.g;
import d.v.j.e.h.h;
import d.v.j.e.h.i;
import d.v.j.e.h.j$a;
import d.v.j.e.h.k;
import java.util.Objects;
import k.d;

public abstract class j {
    public int a = 1;
    private final c1 b;
    private final MediatorLiveData c;

    public j(c1 c12) {
        this(c12, null);
    }

    public j(c1 object, h h10) {
        MediatorLiveData mediatorLiveData;
        this.c = mediatorLiveData = new MediatorLiveData();
        this.b = object;
        object = this.m();
        e e10 = new e(this, (LiveData)object, h10);
        mediatorLiveData.addSource((LiveData)object, e10);
    }

    public static /* synthetic */ MediatorLiveData a(j j10) {
        return j10.c;
    }

    public static /* synthetic */ c1 b(j j10) {
        return j10.b;
    }

    public static /* synthetic */ void c(j j10, k k10) {
        j10.q(k10);
    }

    private void f(LiveData liveData, h h10) {
        if (h10 == null) {
            h10 = new i();
        }
        Object object = new j$a(this, liveData);
        h10.b((NetCallback)object);
        object = this.c;
        g g10 = new g(this, liveData);
        ((MediatorLiveData)object).addSource(liveData, g10);
        this.e().h(h10);
    }

    private /* synthetic */ void g(LiveData object, Object object2) {
        boolean bl2 = this.s();
        if (bl2) {
            MediatorLiveData mediatorLiveData = this.c;
            mediatorLiveData.removeSource((LiveData)object);
        }
        object = k.c(object2);
        this.q((k)object);
    }

    private /* synthetic */ void i(LiveData liveData, h object, Object object2) {
        MediatorLiveData mediatorLiveData = this.c;
        mediatorLiveData.removeSource(liveData);
        boolean bl2 = this.r(object2);
        if (bl2) {
            this.f(liveData, (h)object);
        } else {
            object = this.c;
            object2 = new f(this, liveData);
            ((MediatorLiveData)object).addSource(liveData, (Observer)object2);
        }
    }

    private /* synthetic */ void k(LiveData object, Object object2) {
        boolean bl2 = this.s();
        if (bl2) {
            MediatorLiveData mediatorLiveData = this.c;
            mediatorLiveData.removeSource((LiveData)object);
        }
        object = k.a(object2);
        this.q((k)object);
    }

    private void q(k k10) {
        Object object = this.c.getValue();
        boolean bl2 = Objects.equals(object, k10);
        if (!bl2) {
            object = this.c;
            ((MutableLiveData)object).setValue(k10);
        }
    }

    public LiveData d() {
        return this.c;
    }

    public abstract d e();

    public /* synthetic */ void h(LiveData liveData, Object object) {
        this.g(liveData, object);
    }

    public /* synthetic */ void j(LiveData liveData, h h10, Object object) {
        this.i(liveData, h10, object);
    }

    public /* synthetic */ void l(LiveData liveData, Object object) {
        this.k(liveData, object);
    }

    public LiveData m() {
        return this.n();
    }

    public abstract LiveData n();

    public void o(Throwable throwable) {
    }

    public abstract void p(BaseEntity var1);

    public abstract boolean r(Object var1);

    public boolean s() {
        return false;
    }
}

