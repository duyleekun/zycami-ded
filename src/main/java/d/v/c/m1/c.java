/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.m1;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.me.remote.PrimeManager;
import com.zhiyun.cama.prime.model.PrimeInfo;
import com.zhiyun.common.util.Times;
import d.v.a.f.c.b;
import d.v.c.m1.a;
import d.v.c.m1.c$a;
import d.v.c.m1.c$b;
import d.v.e.i.h;
import d.v.e.l.b2;
import d.v.e.l.c1;
import d.v.e.l.m1;
import java.util.concurrent.Executor;

public class c
extends ViewModel {
    private final MutableLiveData a;
    private final MutableLiveData b;
    private final MutableLiveData c;
    private final MutableLiveData d;
    private boolean e;

    public c() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        Boolean bl2 = Boolean.TRUE;
        this.b = mutableLiveData = new MutableLiveData(bl2);
        bl2 = Boolean.FALSE;
        this.c = mutableLiveData = new MutableLiveData(bl2);
        this.d = mutableLiveData = new MutableLiveData();
        this.e = false;
    }

    public static /* synthetic */ MutableLiveData b(c c10) {
        return c10.a;
    }

    public static /* synthetic */ MutableLiveData c(c c10) {
        return c10.d;
    }

    public static /* synthetic */ boolean d(c c10, PrimeInfo primeInfo) {
        return c10.r(primeInfo);
    }

    public static /* synthetic */ boolean e(c c10) {
        return c10.e;
    }

    public static /* synthetic */ MutableLiveData f(c c10) {
        return c10.c;
    }

    private boolean r(PrimeInfo primeInfo) {
        int n10;
        int n11;
        boolean bl2 = false;
        if (primeInfo != null && ((n11 = primeInfo.getStatus()) == 0 || (n10 = primeInfo.getInactive()) > 0)) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void s() {
        int n10 = d.v.a.f.c.b.N().i().getId();
        PrimeInfo primeInfo = PrimeManager.getLocalPrimeInfo(n10);
        if (primeInfo == null) {
            primeInfo = new PrimeInfo();
            int n11 = 2;
            primeInfo.setStatus(n11);
        }
        this.a.postValue(primeInfo);
    }

    public PrimeInfo g() {
        Object object = this.a.getValue();
        if (object != null) {
            return (PrimeInfo)this.a.getValue();
        }
        int n10 = d.v.a.f.c.b.N().i().getId();
        object = PrimeManager.getLocalPrimeInfo(n10);
        if (object == null) {
            object = new PrimeInfo();
            int n11 = 2;
            ((PrimeInfo)object).setStatus(n11);
        }
        h.g(this.a, object);
        return object;
    }

    public MutableLiveData i() {
        return this.d;
    }

    public MutableLiveData j() {
        return this.b;
    }

    public MutableLiveData k() {
        return this.c;
    }

    public MutableLiveData l() {
        return this.a;
    }

    public String m(String string2) {
        return Times.getTimeZoneDescribe(string2).replace("-", ".");
    }

    public boolean n() {
        return this.e;
    }

    public boolean o(Context context, String string2) {
        boolean bl2 = b2.m(context);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        if (string2 != null) {
            return m1.K(context, string2).equals("") ^ bl3;
        }
        return false;
    }

    public boolean p() {
        int n10;
        int n11 = d.v.a.f.c.b.N().i().getId();
        PrimeInfo primeInfo = PrimeManager.getLocalPrimeInfo(n11);
        boolean bl2 = false;
        if (primeInfo != null && ((n10 = primeInfo.getStatus()) == 0 || (n11 = primeInfo.getInactive()) > 0)) {
            bl2 = true;
        }
        return bl2;
    }

    public /* synthetic */ void t() {
        this.s();
    }

    public void u() {
        b b10 = d.v.a.f.c.b.N();
        c$b c$b = new c$b(this);
        b10.G(c$b);
    }

    public void v() {
        Executor executor = c1.b().a();
        a a10 = new a(this);
        executor.execute(a10);
    }

    public void w(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        c$a c$a = new c$a(this);
        PrimeManager.requestPrime(string2, c$a);
    }

    public void x(boolean bl2) {
        this.e = bl2;
    }

    public void y() {
        PrimeInfo primeInfo = (PrimeInfo)this.a.getValue();
        if (primeInfo != null) {
            boolean bl2 = true;
            primeInfo.setIsShowDialog(bl2);
            PrimeManager.savePrimeInfo(primeInfo);
        }
    }
}

