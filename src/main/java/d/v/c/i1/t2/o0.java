/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.account.widget.StatusView$Status;
import d.v.e.i.h;

public class o0
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private final MutableLiveData d;

    public o0() {
        MutableLiveData mutableLiveData;
        Object object = StatusView$Status.STATUS_NONE;
        this.a = mutableLiveData = new MutableLiveData(object);
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
        object = Boolean.FALSE;
        this.d = mutableLiveData = new MutableLiveData(object);
    }

    public MutableLiveData b() {
        return this.d;
    }

    public MutableLiveData c() {
        return this.c;
    }

    public MutableLiveData d() {
        return this.b;
    }

    public boolean e() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Boolean)this.b.getValue();
            bl2 = (Boolean)object;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public MutableLiveData f() {
        return this.a;
    }

    public void g(boolean bl2) {
        MutableLiveData mutableLiveData = this.d;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void i(boolean bl2) {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void j(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl3 = bl2;
        h.e(mutableLiveData, bl3);
    }

    public void k(StatusView$Status statusView$Status) {
        h.e(this.a, (Object)statusView$Status);
    }
}

