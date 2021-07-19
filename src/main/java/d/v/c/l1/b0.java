/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.l1;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.zhiyun.common.exception.ValueException;
import com.zhiyun.common.util.Devices;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.a.f.c.b;
import d.v.c.l1.a;
import d.v.c.l1.a0;
import d.v.c.l1.b0$a;
import d.v.c.l1.b0$b;
import d.v.c.l1.b0$c;
import d.v.c.l1.b0$d;
import d.v.c.l1.h;
import d.v.c.l1.i;
import d.v.c.l1.j;
import d.v.c.l1.k;
import d.v.c.l1.l;
import d.v.c.l1.m;
import d.v.c.l1.n;
import d.v.c.l1.o;
import d.v.w.c0.d;
import d.v.w.x;
import d.v.w.y;
import e.a.h0;
import e.a.i0;
import e.a.k0;
import e.a.l0;
import e.a.o0;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import k.f;

public class b0 {
    public static boolean a = true;
    public static boolean b = true;
    private static volatile b0 c;

    private b0() {
    }

    public static /* synthetic */ void a(b0 b02, PurchaseResult purchaseResult, d d10) {
        b02.d(purchaseResult, d10);
    }

    private void c(Application application, y y10) {
        d.v.w.a0 a02 = d.v.w.a0.a();
        o o10 = new o(this, application, y10);
        a02.addObserver(o10);
    }

    private void d(PurchaseResult purchaseResult, d object) {
        Object object2 = b0$d.a;
        int n10 = purchaseResult.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1) && n11 != (n10 = 2)) {
            object2 = d.v.w.b0.a();
            Pair pair = new Pair((Object)purchaseResult, object);
            ((d.v.w.b0)object2).b(pair);
        } else {
            object = d.v.w.b0.a();
            ((d.v.w.b0)object).c(purchaseResult);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b0 e() {
        Object object = c;
        if (object != null) return c;
        object = b0.class;
        synchronized (object) {
            b0 b02 = c;
            if (b02 != null) return c;
            c = b02 = new b0();
            return c;
        }
    }

    private void f(y y10) {
        y10.C();
    }

    private /* synthetic */ void h(Observable object, Object object2) {
        boolean bl2 = object2 instanceof d.v.w.c0.a;
        if (bl2) {
            object2 = (d.v.w.c0.a)object2;
            object = a0.c.b((d.v.w.c0.a)object2);
            b0$a b0$a = new b0$a(this, (d.v.w.c0.a)object2);
            object.f(b0$a);
        }
    }

    private /* synthetic */ void j(Application object, y object2, Observable object3, Object object4) {
        object3 = new AtomicBoolean(false);
        Object object5 = i0.x0(object4);
        e.a.v0.o o10 = new k(this, (AtomicBoolean)object3);
        object5 = ((i0)object5).h0(o10);
        o10 = new i(object4, (Application)object);
        object = ((i0)object5).h0(o10);
        object5 = j.a;
        object = ((i0)object).h0((e.a.v0.o)object5);
        object5 = new l((y)object2);
        object = ((i0)object).h0((e.a.v0.o)object5);
        object2 = a0.c;
        object2.getClass();
        object5 = new a((a0)object2);
        object = ((i0)object).h0((e.a.v0.o)object5);
        object2 = e.a.q0.c.a.c();
        object = ((i0)object).f1((h0)object2);
        object2 = e.a.q0.c.a.c();
        object = ((i0)object).O0((h0)object2);
        object2 = new b0$b(this, (AtomicBoolean)object3, object4);
        ((i0)object).f((l0)object2);
    }

    private /* synthetic */ void l(Object object, AtomicBoolean object2, k0 k02) {
        boolean bl2 = object instanceof d;
        if (bl2 && (bl2 = a)) {
            object = (d)object;
            bl2 = object.c();
            ((AtomicBoolean)object2).set(bl2);
            this.t(k02, (d)object);
        } else {
            object = PurchaseResult.PURCHASE_FAIL_NOTIFY_PLATFORM_FAIL;
            object2 = "\u4ea4\u6613\u5931\u8d25,\u6821\u9a8c\u53c2\u6570\u5f02\u5e38";
            object = ValueException.create((String)object2, object);
            k02.onError((Throwable)object);
        }
    }

    private /* synthetic */ o0 n(AtomicBoolean atomicBoolean, Object object) {
        n n10 = new n(this, object, atomicBoolean);
        return i0.H(n10);
    }

    public static /* synthetic */ o0 p(Object object, Application object2, d object3) {
        object3 = a0.c;
        object = (d)object;
        object2 = Devices.k((Context)object2);
        return object3.a((d)object, (String)object2);
    }

    public static /* synthetic */ void q(d.v.w.c0.f object, k0 k02) {
        boolean bl2 = b;
        if (bl2) {
            k02.onSuccess(object);
        } else {
            object = PurchaseResult.PURCHASE_OK;
            String string2 = "\u4ea4\u6613\u6210\u529f,\u4f46\u6d88\u8d39\u88ab\u963b\u65ad";
            object = ValueException.create(string2, object);
            k02.onError((Throwable)object);
        }
    }

    public static /* synthetic */ o0 r(d.v.w.c0.f f10) {
        m m10 = new m(f10);
        return i0.H(m10);
    }

    public static /* synthetic */ o0 s(y y10, d.v.w.c0.f f10) {
        return y10.h(f10);
    }

    private void t(k0 k02, d object) {
        boolean bl2 = object.isSuccessful();
        if (bl2) {
            bl2 = object.c();
            if (!bl2) {
                PurchaseResult purchaseResult = PurchaseResult.PURCHASE_LOADING;
                Object var5_6 = null;
                this.d(purchaseResult, null);
            }
            k02.onSuccess(object);
        } else {
            Object object2;
            Object object3 = object.b();
            if (object3 == null) {
                object3 = PurchaseResult.PURCHASE_FAIL_NOTIFY_PLATFORM_FAIL;
                object2 = "\u4ea4\u6613\u5931\u8d25,\u652f\u4ed8\u5e73\u53f0\u652f\u4ed8\u5931\u8d25.";
                object3 = ValueException.createValue((String)object2, object3);
            }
            object2 = object3.a();
            CharSequence charSequence = object.a();
            boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence);
            if (!bl3) {
                Object object4;
                object3 = (PurchaseResult)((Object)object3.a);
                charSequence = new StringBuilder();
                String string2 = ((Throwable)object2).getMessage();
                ((StringBuilder)charSequence).append(string2);
                string2 = "";
                if (object3 == null) {
                    object3 = string2;
                } else {
                    object4 = new StringBuilder();
                    String string3 = ", \u5ba2\u6237\u7aef\u9519\u8bef\u7801:";
                    ((StringBuilder)object4).append(string3);
                    ((StringBuilder)object4).append(object3);
                    object3 = ((StringBuilder)object4).toString();
                }
                ((StringBuilder)charSequence).append((String)object3);
                object3 = ((StringBuilder)charSequence).toString();
                charSequence = object.a();
                if (charSequence != null) {
                    string2 = object.a();
                }
                int n10 = d.v.a.f.c.b.N().O();
                charSequence = d.v.a.f.c.b.N().P();
                object4 = a0.c;
                object = object4.i(n10, (String)charSequence, string2, (String)object3);
                object3 = new b0$c(this);
                object.h((f)object3);
            } else {
                boolean bl4 = false;
                object = new Object[]{};
                object3 = "\u901a\u77e5\u670d\u52a1\u5668\u8ba2\u5355\u5931\u8d25\u4e0d\u6210\u529f,\u56e0\u4e3a\u6ca1\u6709\u4ea4\u6613\u8ba2\u5355\u53f7\u53c2\u6570";
                m.a.a.e((String)object3, (Object[])object);
            }
            k02.onError((Throwable)object2);
        }
    }

    public void b() {
        x x10 = x.a();
        h h10 = new h(this);
        x10.addObserver(h10);
    }

    public void g(Application application, y y10) {
        if (y10 == null) {
            return;
        }
        this.c(application, y10);
        this.b();
        this.f(y10);
    }

    public /* synthetic */ void i(Observable observable, Object object) {
        this.h(observable, object);
    }

    public /* synthetic */ void k(Application application, y y10, Observable observable, Object object) {
        this.j(application, y10, observable, object);
    }

    public /* synthetic */ void m(Object object, AtomicBoolean atomicBoolean, k0 k02) {
        this.l(object, atomicBoolean, k02);
    }

    public /* synthetic */ o0 o(AtomicBoolean atomicBoolean, Object object) {
        return this.n(atomicBoolean, object);
    }
}

