/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.NetCallback;
import d.v.j.e.h.a;
import d.v.j.e.h.b;
import d.v.j.e.h.c;
import d.v.j.e.h.d;
import d.v.j.e.h.j;
import d.v.j.e.h.k;

public class j$a
implements NetCallback {
    public final /* synthetic */ LiveData a;
    public final /* synthetic */ j b;

    public j$a(j j10, LiveData liveData) {
        this.b = j10;
        this.a = liveData;
    }

    private /* synthetic */ void a(LiveData object, Object object2) {
        Object object3 = this.b;
        boolean bl2 = ((j)object3).s();
        if (bl2) {
            object3 = j.a(this.b);
            ((MediatorLiveData)object3).removeSource((LiveData)object);
        }
        object = this.b;
        object2 = k.d(object2);
        j.c((j)object, (k)object2);
    }

    private /* synthetic */ void c() {
        LiveData liveData = this.b.n();
        MediatorLiveData mediatorLiveData = j.a(this.b);
        a a10 = new a(this, liveData);
        mediatorLiveData.addSource(liveData, a10);
    }

    private /* synthetic */ void e(LiveData object, Object object2) {
        Object object3 = this.b;
        boolean bl2 = ((j)object3).s();
        if (bl2) {
            object3 = j.a(this.b);
            ((MediatorLiveData)object3).removeSource((LiveData)object);
        }
        object = this.b;
        object2 = k.b("", object2);
        j.c((j)object, (k)object2);
    }

    private /* synthetic */ void g(BaseEntity object) {
        this.b.p((BaseEntity)object);
        object = j.b(this.b).c();
        d d10 = new d(this);
        object.execute(d10);
    }

    public /* synthetic */ void b(LiveData liveData, Object object) {
        this.a(liveData, object);
    }

    public /* synthetic */ void d() {
        this.c();
    }

    public /* synthetic */ void f(LiveData liveData, Object object) {
        this.e(liveData, object);
    }

    public /* synthetic */ void h(BaseEntity baseEntity) {
        this.g(baseEntity);
    }

    public void i(BaseEntity baseEntity) {
        Object object = j.a(this.b);
        Object object2 = this.a;
        ((MediatorLiveData)object).removeSource((LiveData)object2);
        object = j.b(this.b).a();
        object2 = new b(this, baseEntity);
        object.execute((Runnable)object2);
    }

    public void onError(Throwable throwable, int n10, String object) {
        MediatorLiveData mediatorLiveData = j.a(this.b);
        object = this.a;
        mediatorLiveData.removeSource((LiveData)object);
        mediatorLiveData = j.a(this.b);
        object = this.a;
        c c10 = new c(this, (LiveData)object);
        mediatorLiveData.addSource((LiveData)object, c10);
        this.b.o(throwable);
    }
}

