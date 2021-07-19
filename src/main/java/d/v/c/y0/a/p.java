/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.y0.a;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.common.util.Devices;
import com.zhiyun.protocol.constants.Model;
import d.v.a.f.a.a;
import d.v.a.f.c.b;
import d.v.c.y0.a.p$a;
import d.v.c.y0.a.p$b;
import d.v.c.y0.a.p$c;
import d.v.e.i.h;
import d.v.e.l.o1;
import d.v.e0.ce;
import k.f;

public class p
extends ViewModel {
    private final MutableLiveData a;
    private final MutableLiveData b;
    private final LiveData c;

    public p() {
        LiveData liveData;
        this.a = liveData = new MutableLiveData();
        Boolean bl2 = Boolean.FALSE;
        this.b = liveData = new MutableLiveData(bl2);
        liveData = d.v.a.f.c.b.N().c();
        this.c = liveData;
    }

    public void b(p$c p$c) {
        Object object = Devices.k(d.v.e.f.a().c());
        Object object2 = d.v.a.f.a.a.a;
        int n10 = 1;
        object = object2.l((String)object, n10, n10, "active");
        object2 = new p$a(this, p$c);
        object.h((f)object2);
    }

    public void c(Context context) {
        Model model = ce.E0().y0().b;
        Object object = p$b.a;
        int n10 = model.ordinal();
        int n11 = 1;
        n10 = (n10 = object[n10]) != n11 ? (n10 != (n11 = 2) ? 2131231820 : 2131231821) : 2131231823;
        object = this.a;
        context = o1.m(context, n10);
        ((MutableLiveData)object).setValue(context);
    }

    public MutableLiveData d() {
        return this.a;
    }

    public MutableLiveData e() {
        return this.b;
    }

    public LiveData f() {
        return this.c;
    }

    public void g(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }
}

