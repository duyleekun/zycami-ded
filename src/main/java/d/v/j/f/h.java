/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.f;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.j.e.c;
import d.v.j.e.h.k;
import d.v.j.e.i.a1;
import d.v.j.f.f;

public class h
extends ViewModel {
    private final MutableLiveData a;
    private final LiveData b;
    private a1 c;
    public LiveData d;

    public h() {
        LiveData liveData;
        this.a = liveData = new MutableLiveData();
        Object object = d.v.j.e.c.a();
        this.c = object;
        object = new f(this);
        liveData = Transformations.switchMap(liveData, (Function)object);
        this.b = liveData;
    }

    private /* synthetic */ LiveData g(Boolean bl2) {
        return this.c.b(0);
    }

    public void b() {
        this.c.e();
    }

    public LiveData c() {
        LiveData liveData = this.d;
        if (liveData == null) {
            this.d = liveData = this.c.k();
        }
        return this.d;
    }

    public LiveData d() {
        return this.b;
    }

    public boolean e() {
        Status status;
        Object object = (k)this.b.getValue();
        return object != null && (object = object.a) == (status = Status.ERROR);
    }

    public boolean f() {
        boolean bl2;
        Object object = this.a.getValue();
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public /* synthetic */ LiveData i(Boolean bl2) {
        return this.g(bl2);
    }

    public void j() {
        MutableLiveData mutableLiveData = this.a;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
    }

    public void onCleared() {
        super.onCleared();
    }
}

