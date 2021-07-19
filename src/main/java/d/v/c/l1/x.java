/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package d.v.c.l1;

import android.content.Context;
import android.os.Bundle;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.App;
import com.zhiyun.pay.data.PayFlowResult;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.c.l1.b;
import d.v.c.l1.b0;
import d.v.c.l1.c;
import d.v.c.l1.d;
import d.v.c.l1.d0;
import d.v.c.l1.e;
import d.v.c.l1.e0.b$a;
import d.v.c.l1.e0.c$a;
import d.v.c.l1.e0.d$a;
import d.v.c.l1.x$a;
import d.v.c.l1.x$b;
import d.v.c.w0.r;
import d.v.e.i.j;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.g0.k$b;
import d.v.w.y;
import m.a.a;

public class x
extends d.v.f.c.d {
    private d0 b;
    private y c;
    public d.v.c.l1.e0.c d;
    public r e;

    public static /* synthetic */ d0 d(x x10) {
        return x10.b;
    }

    private /* synthetic */ void f(d.v.w.c0.c c10) {
        if (c10 != null) {
            d0 d02 = this.b;
            d02.K(this, c10);
        }
    }

    private /* synthetic */ void i(PayFlowResult object) {
        Object object2 = 1;
        Object object3 = new Object[object2];
        object3[0] = object;
        String string2 = "payUIState: %s";
        a.b(string2, object3);
        object3 = PayFlowResult.PAY_FLOW_LOADING_GOOGLE;
        if (object == object3) {
            this.m((boolean)object2);
        } else {
            this.m(false);
            object3 = x$a.b;
            Object object4 = object.ordinal();
            object4 = object3[object4];
            if (object4 != object2) {
                object2 = 2;
                if (object4 != object2) {
                    object = "\u8c03\u8d77\u652f\u4ed8\u5931\u8d25";
                    this.r((String)object);
                } else {
                    object = "\u7f51\u7edc\u5f00\u5c0f\u5dee\u4e86,\u8bf7\u7a0d\u5019\u518d\u8bd5";
                    n2.e((String)object);
                }
            }
        }
    }

    private /* synthetic */ void k(Pair object) {
        Object object2 = 1;
        Object object3 = new Object[object2];
        object3[0] = object;
        a.b("payUIState: %s", object3);
        object3 = ((Pair)object).first;
        PurchaseResult purchaseResult = PurchaseResult.PURCHASE_LOADING;
        if (object3 == purchaseResult) {
            this.m((boolean)object2);
        } else {
            this.m(false);
            object3 = x$a.a;
            object = (PurchaseResult)((Object)((Pair)object).first);
            Object object4 = ((Enum)object).ordinal();
            object4 = object3[object4];
            if (object4 != object2) {
                object2 = 2;
                if (object4 != object2) {
                    this.o();
                } else {
                    object = "\u652f\u4ed8\u53d6\u6d88";
                    this.r((String)object);
                }
            } else {
                this.p(false);
            }
        }
    }

    public /* synthetic */ void h(d.v.w.c0.c c10) {
        this.f(c10);
    }

    public /* synthetic */ void j(PayFlowResult payFlowResult) {
        this.i(payFlowResult);
    }

    public /* synthetic */ void l(Pair pair) {
        this.k(pair);
    }

    public void m(boolean bl2) {
        if (bl2) {
            this.n();
        } else {
            d.v.c.l1.e0.c c10 = this.d;
            if (c10 != null && (bl2 = c10.isAdded())) {
                c10 = this.d;
                c10.dismissAllowingStateLoss();
            }
        }
    }

    public void n() {
        Object object = new c$a();
        object = ((c$a)object).b("\u524d\u5f80\u652f\u4ed8\u5b9d\u652f\u4ed8").c();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.d = object = ((c$a)object).d(fragmentManager);
    }

    public void o() {
        k$b k$b = new k$b((Context)this);
        k$b = (k$b)((k$b)k$b.B("\u652f\u4ed8\u5931\u8d25")).n("\u5f88\u62b1\u6b49\uff0c\u60a8\u7684\u4ed8\u6b3e\u6ca1\u6709\u6210\u529f\uff0c\u8bf7\u91cd\u65b0\u4ed8\u6b3e");
        Object object = d.v.c.l1.b.a;
        k$b = (k$b)k$b.x("\u786e\u5b9a", (d.v.f.f.a)object);
        object = this.getSupportFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.getWindow();
        int n10 = 1024;
        object.setFlags(n10, n10);
        int n11 = 2131558444;
        object = (r)DataBindingUtil.setContentView(this, n11);
        this.e = object;
        Object object2 = new x$b(this);
        ((r)object).z((x$b)object2);
        this.e.setLifecycleOwner(this);
        object = this.e.f;
        n10 = (int)(b0.a ? 1 : 0);
        object2 = n10 != 0 ? "\u70b9\u51fb\u5173\u95ed\u4ea4\u6613\u6821\u9a8c" : "\u70b9\u51fb\u5f00\u542f\u4ea4\u6613\u6821\u9a8c";
        object.setText((CharSequence)object2);
        object = this.e.g;
        n10 = (int)(b0.b ? 1 : 0);
        object2 = n10 != 0 ? "\u70b9\u51fb\u5173\u95ed\u6d88\u8d39\u6821\u9a8c" : "\u70b9\u51fb\u5f00\u542f\u6d88\u8d39\u6821\u9a8c";
        object.setText((CharSequence)object2);
        this.c = object = ((App)this.getApplication()).c();
        object = this.getLifecycle();
        object2 = this.c;
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        this.b = object = (d0)d.v.i0.b.c(this).get(d0.class);
        object = ((d0)object).a;
        object2 = new c(this);
        ((j)object).observe(this, (Observer)object2);
        object = this.b.b;
        object2 = new e(this);
        ((j)object).observe(this, (Observer)object2);
        object = this.b.c;
        object2 = new d(this);
        ((j)object).observe(this, (Observer)object2);
    }

    public void p(boolean bl2) {
        Object object = new b$a();
        Object object2 = bl2 ? "\u6210\u529f\u7eed\u8d39" : "\u6210\u529f\u5f00\u901a";
        object2 = ((b$a)object).f((String)object2).d("\u606d\u559c\u60a8\u6210\u4e3aZHIYUN Prime\uff0c\u53ef\u70b9\u51fb\u4e0b\u65b9\u6309\u94ae\u67e5\u770bPrime\u7279\u6743");
        object = g.m((Context)this, 2131951887);
        b b10 = d.v.c.l1.b.a;
        object2 = ((b$a)object2).b((String)object, b10).e(b10);
        object = this.getSupportFragmentManager();
        ((b$a)object2).g((FragmentManager)object);
    }

    public void q() {
        d$a d$a = new d$a();
        boolean bl2 = true;
        d$a = d$a.h(bl2).b(bl2).c(bl2);
        Object object = d.v.c.l1.b.a;
        d$a = d$a.e((d.v.f.f.a)object);
        object = this.getSupportFragmentManager();
        d$a.i((FragmentManager)object);
    }

    public void r(String string2) {
        n2.e(string2);
    }
}

