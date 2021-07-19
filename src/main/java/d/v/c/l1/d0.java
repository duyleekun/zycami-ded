/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 */
package d.v.c.l1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.App;
import com.zhiyun.cama.data.api.entity.OrderBean;
import com.zhiyun.cama.data.api.entity.ProductPlatformListBean$ProductOfPlatform;
import com.zhiyun.common.exception.ValueException;
import com.zhiyun.common.util.Devices;
import com.zhiyun.pay.data.PayFlowResult;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.a.f.c.b;
import d.v.c.l1.a0;
import d.v.c.l1.c0;
import d.v.c.l1.d0$a;
import d.v.c.l1.d0$b;
import d.v.c.l1.d0$c;
import d.v.c.l1.d0$d;
import d.v.c.l1.p;
import d.v.c.l1.q;
import d.v.c.l1.t;
import d.v.c.l1.u;
import d.v.c.l1.v;
import d.v.c.l1.w;
import d.v.c.v0.l.c;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.e.l.b2;
import d.v.e.l.d1;
import d.v.e.l.w1;
import d.v.w.b0;
import d.v.w.c0.d;
import d.v.w.c0.e;
import d.v.w.y;
import e.a.h0;
import e.a.i0;
import e.a.k0;
import e.a.l0;
import e.a.m0;
import e.a.o0;
import e.a.v0.o;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import k.f;
import m.a.a;

public class d0
extends AndroidViewModel
implements Observer {
    public j a;
    public j b;
    public j c;
    public j d;
    private e.a.s0.a e;
    private y f;
    public LiveData g;

    public d0(Application object) {
        super((Application)object);
        Object object2 = new j();
        this.a = object2;
        object2 = new j();
        this.b = object2;
        object2 = new j();
        this.c = object2;
        object2 = new j();
        this.d = object2;
        b0.a().addObserver(this);
        this.e = object2 = new e.a.s0.a();
        boolean bl2 = object instanceof App;
        if (bl2) {
            object = ((App)((Object)object)).c();
            this.f = object;
            if (object != null) {
                this.g = object = object.O();
            }
        }
        if ((object = this.g) == null) {
            super();
            this.g = object;
        }
    }

    private /* synthetic */ o0 A(String string2, boolean bl2, boolean bl3, String string3, UserInfo userInfo) {
        return this.f.B(string2, bl2, bl3, string3);
    }

    private /* synthetic */ o0 G(int n10, e e10) {
        UserInfo userInfo = this.l();
        return this.f(n10, userInfo, e10);
    }

    private /* synthetic */ o0 I(AtomicBoolean atomicBoolean, OrderBean orderBean) {
        boolean bl2 = atomicBoolean.get();
        return this.j(orderBean, bl2);
    }

    private void P(PayFlowResult payFlowResult) {
        this.b.setValue((Object)payFlowResult);
    }

    private void Q(Pair pair) {
        this.c.setValue(pair);
    }

    private void R(PurchaseResult purchaseResult) {
        j j10 = this.c;
        Pair pair = new Pair((Object)purchaseResult, null);
        j10.setValue(pair);
    }

    public static /* synthetic */ e.a.s0.a b(d0 d02) {
        return d02.e;
    }

    public static /* synthetic */ void c(d0 d02, PayFlowResult payFlowResult) {
        d02.P(payFlowResult);
    }

    public static /* synthetic */ void d(d0 d02, List list) {
        d02.o(list);
    }

    private k.d e(int n10, UserInfo object, e e10) {
        a0 a02 = a0.c;
        int n11 = ((UserInfo)object).getId();
        String string2 = ((UserInfo)object).getToken();
        String string3 = this.i();
        String string4 = this.g();
        String string5 = w1.a();
        String string6 = e10.b();
        object = new StringBuilder();
        long l10 = e10.c() / 10000L;
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append("");
        String string7 = ((StringBuilder)object).toString();
        String string8 = e10.a();
        String string9 = e10.f();
        return a02.d(n11, string2, string3, n10, string4, string5, string6, string7, string8, string9);
    }

    private o0 f(int n10, UserInfo userInfo, e e10) {
        u u10 = new u(this, userInfo, n10, e10);
        return i0.H(u10);
    }

    private o0 j(OrderBean object, boolean bl2) {
        y y10 = this.f;
        String string2 = this.k();
        object = c0.a((OrderBean)object, string2, bl2);
        return y10.q((d.v.w.c0.b)object);
    }

    private String k() {
        int n10 = d.v.a.f.c.b.N().O();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    private String n() {
        return d.v.a.f.c.b.N().P();
    }

    private void o(List object) {
        int n10;
        if (object != null && (n10 = object.size()) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Object object2 = (ProductPlatformListBean$ProductOfPlatform)object.next();
                int n11 = ((ProductPlatformListBean$ProductOfPlatform)object2).getPlatformProductId();
                String string2 = ((ProductPlatformListBean$ProductOfPlatform)object2).getPlatform();
                Object object3 = ((ProductPlatformListBean$ProductOfPlatform)object2).getThirdProductType();
                boolean bl2 = d.v.c.v0.l.c.n((String)object3);
                boolean bl3 = d.v.c.v0.l.c.h((String)object3);
                String string3 = ((ProductPlatformListBean$ProductOfPlatform)object2).getThirdProductId();
                object2 = "googleplay";
                n10 = (int)(((String)object2).equals(string2) ? 1 : 0);
                if (n10 == 0) continue;
                object = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_COMPLETE;
                this.P((PayFlowResult)((Object)object));
                object3 = this;
                this.L(n11, string3, string2, bl2, bl3);
                return;
            }
            object = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_COMPLETE;
            this.P((PayFlowResult)((Object)object));
            object = PayFlowResult.PAY_FLOW_PRODUCT_INFO_ERROR;
            this.P((PayFlowResult)((Object)object));
            return;
        }
        object = new Object[]{};
        m.a.a.e("---primepay \u5546\u54c1\u5e73\u53f0\u5217\u8868\u4e3a\u7a7a", object);
        object = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_COMPLETE;
        this.P((PayFlowResult)((Object)object));
    }

    private /* synthetic */ void p(UserInfo object, int n10, e e10, k0 k02) {
        if (object == null) {
            object = PayFlowResult.USER_NOT_LOGIN;
            object = ValueException.create("\u7528\u6237\u672a\u767b\u5f55", object);
            k02.onError((Throwable)object);
            return;
        }
        object = this.e(n10, (UserInfo)object, e10);
        d0$c d0$c = new d0$c(this, k02);
        object.h(d0$c);
    }

    private /* synthetic */ void s(UserInfo userInfo, String string2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, k0 k02) {
        Object object = a0.c;
        int n10 = userInfo.getId();
        Object object2 = userInfo.getToken();
        object = object.c(n10, (String)object2);
        object2 = this;
        d0$b d0$b = new d0$b(this, string2, atomicBoolean, atomicBoolean2, k02, userInfo);
        object.h(d0$b);
    }

    private /* synthetic */ void u(int n10, String string2, String string3, boolean bl2, boolean bl3, DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        this.L(n10, string2, string3, bl2, bl3);
    }

    private /* synthetic */ void w(int n10, String string2, String string3, boolean bl2, boolean bl3, DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        this.L(n10, string2, string3, bl2, bl3);
    }

    private /* synthetic */ void y(String object, k0 k02) {
        Object object2 = this.getApplication();
        boolean bl2 = b2.m((Context)object2);
        if (!bl2) {
            object = PayFlowResult.SERVICE_UNAVAILABLE;
            object = ValueException.create("\u7f51\u7edc\u672a\u8fde\u63a5", object);
            k02.onError((Throwable)object);
            return;
        }
        object2 = this.l();
        int n10 = Objects.nonNull(object2);
        if (n10 == 0) {
            object = PayFlowResult.USER_NOT_LOGIN;
            object2 = "\u7528\u6237\u672a\u767b\u5f55";
            object = ValueException.create((String)object2, object);
            k02.onError((Throwable)object);
        } else {
            object.hashCode();
            n10 = -1;
            int n11 = object.hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 113584679: {
                    String string2 = "wxpay";
                    boolean bl3 = object.equals(string2);
                    if (!bl3) break;
                    n10 = 2;
                    break;
                }
                case -1414960566: {
                    String string3 = "alipay";
                    boolean bl4 = object.equals(string3);
                    if (!bl4) break;
                    n10 = 1;
                    break;
                }
                case -1534319379: {
                    String string4 = "googleplay";
                    boolean bl5 = object.equals(string4);
                    if (!bl5) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    break;
                }
                case 2: {
                    object = PayFlowResult.PAY_FLOW_LOADING_WX;
                    this.P((PayFlowResult)((Object)object));
                    break;
                }
                case 1: {
                    object = PayFlowResult.PAY_FLOW_LOADING_ALI;
                    this.P((PayFlowResult)((Object)object));
                    break;
                }
                case 0: {
                    object = PayFlowResult.PAY_FLOW_LOADING_GOOGLE;
                    this.P((PayFlowResult)((Object)object));
                }
            }
            k02.onSuccess(object2);
        }
    }

    public /* synthetic */ o0 F(String string2, boolean bl2, boolean bl3, String string3, UserInfo userInfo) {
        return this.A(string2, bl2, bl3, string3, userInfo);
    }

    public /* synthetic */ o0 H(int n10, e e10) {
        return this.G(n10, e10);
    }

    public /* synthetic */ o0 J(AtomicBoolean atomicBoolean, OrderBean orderBean) {
        return this.I(atomicBoolean, orderBean);
    }

    public void K(Activity object, d.v.w.c0.c c10) {
        y y10 = this.f;
        if (y10 == null) {
            return;
        }
        boolean bl2 = y10.D((Activity)object, c10);
        if (bl2) {
            object = PayFlowResult.PAY_FLOW_OK;
            this.P((PayFlowResult)((Object)object));
        } else {
            object = PayFlowResult.PAY_FLOW_FAIL;
            this.P((PayFlowResult)((Object)object));
        }
    }

    public void L(int n10, String object, String object2, boolean bl2, boolean bl3) {
        Object object3 = this.f;
        if (object3 == null) {
            return;
        }
        new AtomicBoolean(false);
        object3 = new AtomicBoolean(false);
        Object object4 = new t(this, (String)object2);
        object4 = i0.H((m0)object4);
        p p10 = new p(this, (String)object2, bl2, bl3, (String)object);
        object = ((i0)object4).h0(p10);
        object2 = new q(this, n10);
        i0 i02 = ((i0)object).h0((o)object2);
        object = new v(this, (AtomicBoolean)object3);
        i02 = i02.h0((o)object);
        object = e.a.q0.c.a.c();
        i02 = i02.f1((h0)object);
        object = e.a.q0.c.a.c();
        i02 = i02.O0((h0)object);
        object = new d0$a(this);
        i02.f((l0)object);
    }

    public void M(int n10) {
        Object object = this.getApplication();
        boolean bl2 = b2.m((Context)object);
        if (!bl2) {
            j j10 = this.b;
            object = PayFlowResult.SERVICE_UNAVAILABLE;
            h.e(j10, object);
            return;
        }
        object = this.b;
        Object object2 = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_START;
        h.e((MutableLiveData)object, object2);
        object = a0.c;
        object2 = this.i();
        k.d d10 = object.o(n10, (String)object2, "google");
        object = new d0$d(this);
        d10.h((f)object);
    }

    public void N(d d10) {
        d.v.w.a0.a().b(d10);
    }

    public List a(List list) {
        y y10 = this.f;
        list = y10 == null ? null : y10.a(list);
        return list;
    }

    public String g() {
        return Devices.k((Context)this.getApplication());
    }

    public String i() {
        return d1.d();
    }

    public UserInfo l() {
        return d.v.a.f.c.b.N().i();
    }

    public o0 m(String string2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, UserInfo userInfo) {
        w w10 = new w(this, userInfo, string2, atomicBoolean2, atomicBoolean);
        return i0.H(w10);
    }

    public void onCleared() {
        super.onCleared();
        this.g = null;
        this.f = null;
        b0.a().deleteObserver(this);
        this.e.e();
    }

    public /* synthetic */ void r(UserInfo userInfo, int n10, e e10, k0 k02) {
        this.p(userInfo, n10, e10, k02);
    }

    public /* synthetic */ void t(UserInfo userInfo, String string2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, k0 k02) {
        this.s(userInfo, string2, atomicBoolean, atomicBoolean2, k02);
    }

    public void update(Observable object, Object object2) {
        boolean bl2 = object2 instanceof PurchaseResult;
        if (bl2) {
            object2 = (PurchaseResult)((Object)object2);
            this.R((PurchaseResult)((Object)object2));
        } else {
            bl2 = object2 instanceof Pair;
            if (bl2) {
                object2 = (Pair)object2;
                object = ((Pair)object2).first;
                bl2 = object instanceof PurchaseResult;
                if (bl2) {
                    this.Q((Pair)object2);
                }
            }
        }
    }

    public /* synthetic */ void v(int n10, String string2, String string3, boolean bl2, boolean bl3, DialogFragment dialogFragment) {
        this.u(n10, string2, string3, bl2, bl3, dialogFragment);
    }

    public /* synthetic */ void x(int n10, String string2, String string3, boolean bl2, boolean bl3, DialogFragment dialogFragment) {
        this.w(n10, string2, string3, bl2, bl3, dialogFragment);
    }

    public /* synthetic */ void z(String string2, k0 k02) {
        this.y(string2, k02);
    }
}

