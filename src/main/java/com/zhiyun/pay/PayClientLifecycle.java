/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 */
package com.zhiyun.pay;

import android.app.Activity;
import android.app.Application;
import androidx.core.util.Pair;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.zhiyun.common.exception.ValueException;
import com.zhiyun.common.exception.ValueException$b;
import com.zhiyun.pay.PayClientLifecycle$a;
import com.zhiyun.pay.data.PayFlowResult;
import com.zhiyun.pay.data.PurchaseResult;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle;
import d.b.a.b.a;
import d.b.a.b.d;
import d.b.a.b.f;
import d.b.a.b.g;
import d.b.a.b.g$a;
import d.b.a.b.h;
import d.b.a.b.j;
import d.v.w.a0;
import d.v.w.c0.b;
import d.v.w.c0.c;
import d.v.w.d0.k.i;
import d.v.w.d0.k.k;
import d.v.w.d0.k.l;
import d.v.w.e;
import d.v.w.m;
import d.v.w.n;
import d.v.w.p;
import d.v.w.q;
import d.v.w.r;
import d.v.w.s;
import d.v.w.t;
import d.v.w.u;
import d.v.w.v;
import d.v.w.x;
import d.v.w.y;
import d.v.w.z;
import e.a.i0;
import e.a.k0;
import e.a.m0;
import e.a.o0;
import e.a.v0.o;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PayClientLifecycle
extends GoogleBillingClientLifecycle
implements y {
    private static volatile PayClientLifecycle m;

    private PayClientLifecycle(Application application) {
        super(application);
    }

    private /* synthetic */ void A0(boolean bl2, String string2, k0 k02) {
        if (bl2) {
            bl2 = this.e;
            if (!bl2) {
                Object object = PayFlowResult.PAY_FLOW_GOOGLE_NOT_SUPPORTED;
                object = ValueException.create("Google Play \u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301\u8d2d\u4e70\u8ba2\u9605\u5546\u54c1", object);
                k02.tryOnError((Throwable)object);
                return;
            }
            bl2 = this.k0();
            if (bl2 && !(bl2 = this.f)) {
                Object object = PayFlowResult.PAY_FLOW_GOOGLE_NOT_SUPPORTED;
                object = ValueException.create("Google Play \u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301\u5347\u964d\u7ea7\u8ba2\u9605\u5546\u54c1", object);
                k02.tryOnError((Throwable)object);
                return;
            }
        }
        k02.onSuccess(string2);
    }

    private /* synthetic */ void C0(k0 k02) {
        Object object = this.U("subs");
        if (object != null) {
            int n10;
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
                String string2;
                if (i10 != 0) {
                    string2 = ",";
                    stringBuilder.append(string2);
                }
                string2 = ((Purchase)object.get(i10)).h();
                stringBuilder.append(string2);
            }
            object = stringBuilder.toString();
            k02.onSuccess(object);
        } else {
            object = PayFlowResult.PAY_FLOW_GOOGLE_NOT_SUPPORTED;
            String string3 = "\u83b7\u53d6\u8c37\u6b4c\u5f80\u671f\u4ea4\u6613\u5931\u8d25";
            object = ValueException.create(string3, object);
            k02.tryOnError((Throwable)object);
        }
    }

    private /* synthetic */ void E0(String object, k0 k02, String object2, h object3, List list) {
        object3 = this.i0((String)object);
        if (object3 != null) {
            object = this.a1((SkuDetails)object3, (String)object2);
            k02.onSuccess(object);
        } else {
            object2 = new StringBuilder();
            object3 = "\u67e5\u8be2\u8c37\u6b4c\u5546\u54c1\u5f02\u5e38, SkuId = ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = PayFlowResult.PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT;
            object = ValueException.create((String)object, object2);
            k02.tryOnError((Throwable)object);
        }
    }

    private /* synthetic */ void G0(k0 k02, SkuDetails object, String object2, h object3, List object4) {
        int n10 = ((h)object3).b();
        if (n10 != 0) {
            object = PayFlowResult.PAY_FLOW_FAILT_QUERY_PAST_TRADE;
            object2 = "\u67e5\u8be2\u8c37\u6b4c\u5f80\u671f\u4ea4\u6613\u8be6\u60c5\u5f02\u5e38";
            object = ValueException.create((String)object2, object);
            k02.tryOnError((Throwable)object);
        } else {
            object4 = ((SkuDetails)object).n();
            object2 = this.h0((String)object4, (String)object2);
            object3 = new Pair(object, object2);
            k02.onSuccess(object3);
        }
    }

    private /* synthetic */ void I0(String object, String object2, boolean bl2, k0 k02) {
        List<String> list = this.i0((String)object);
        if (list != null) {
            object = this.a1((SkuDetails)((Object)list), (String)object2);
            k02.onSuccess(object);
        } else {
            m m10;
            String string2;
            list = Collections.singletonList(object);
            boolean bl3 = this.Z(list, string2 = bl2 ? "subs" : "inapp", m10 = new m(this, (String)object, k02, (String)object2));
            if (!bl3) {
                object2 = new StringBuilder();
                string2 = "\u67e5\u8be2\u8c37\u6b4c\u5546\u54c1\u5f02\u5e38, SkuId = ";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                object2 = PayFlowResult.PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT;
                object = ValueException.create((String)object, object2);
                k02.tryOnError((Throwable)object);
            }
        }
    }

    private /* synthetic */ void K0(SkuDetails object, k0 k02) {
        u u10;
        String string2 = object.q();
        boolean bl2 = this.X(string2, u10 = new u(this, k02, (SkuDetails)object, string2));
        if (!bl2) {
            object = PayFlowResult.PAY_FLOW_FAILT_QUERY_PAST_TRADE;
            string2 = "\u67e5\u8be2\u8c37\u6b4c\u5f80\u671f\u4ea4\u6613\u8be6\u60c5\u5f02\u5e38";
            object = ValueException.create(string2, object);
            k02.tryOnError((Throwable)object);
        }
    }

    private /* synthetic */ void M0(Purchase object, k0 k02, Pair pair, h object2, String string2) {
        int n10;
        int n11 = ((h)object2).b();
        if (n11 && n11 != (n10 = 8)) {
            k02.onSuccess(pair);
        } else {
            object2 = x.a();
            n10 = 1;
            object = this.g0((Purchase)object);
            object = d.v.w.d0.k.g.b(n10 != 0, (String)object);
            ((x)object2).b((d.v.w.c0.a)object);
            k02.onSuccess(pair);
        }
    }

    private /* synthetic */ void O0(Pair pair, boolean bl2, k0 k02) {
        Purchase purchase;
        Object object = "inapp";
        String string2 = ((SkuDetails)pair.first).q();
        boolean bl3 = ((String)object).equals(string2);
        if (bl3 && bl2 && (purchase = (Purchase)pair.second) != null && (bl3 = purchase.k())) {
            string2 = purchase.h();
            bl2 = this.n(string2, (j)(object = new d.v.w.d(this, purchase, k02, pair)));
            if (!bl2) {
                k02.onSuccess(pair);
            }
            return;
        }
        k02.onSuccess(pair);
    }

    private /* synthetic */ void Q0(Pair object, String string2, String string3, String string4, k0 k02) {
        object = (SkuDetails)((Pair)object).first;
        Object object2 = z.b(string2);
        String string5 = z.b(string3);
        if (object2 == null) {
            object2 = string5;
        }
        Object object3 = d.b.a.b.g.h().f((SkuDetails)object);
        object2 = ((g$a)object3).b((String)object2).c(string5);
        string5 = "subs";
        boolean bl2 = string5.equals(object = ((SkuDetails)object).q());
        if (bl2) {
            int n10;
            object = this.j0();
            if (object != null) {
                n10 = 1;
            } else {
                n10 = 0;
                string5 = null;
            }
            if (n10 != 0) {
                string5 = ((Purchase)object).j();
                n10 = string4.equals(string5);
                if (n10 == 0) {
                    n10 = 4;
                    object3 = ((Purchase)object).j();
                    object = ((Purchase)object).h();
                    object = ((g$a)object2).d((String)object3, (String)object);
                    ((g$a)object).e(n10);
                } else {
                    object = PayFlowResult.PAY_FLOW_ITEM_BUY_REPEAT;
                    object = ValueException.create("\u8d2d\u4e70\u8c37\u6b4c\u5e73\u53f0\u76f8\u540c\u5546\u54c1\u5f02\u5e38", object);
                    k02.tryOnError((Throwable)object);
                    return;
                }
            }
        }
        object = ((g$a)object2).a();
        object = d.v.w.d0.k.i.c(string3, string2, string4, (g)object);
        k02.onSuccess(object);
    }

    private /* synthetic */ void S0(String string2, k0 k02) {
        Object object = this.b;
        boolean bl2 = ((d)object).e();
        if (!bl2) {
            object = new PayClientLifecycle$a(this, k02, string2);
            this.l((f)object);
        } else {
            k02.onSuccess(string2);
        }
    }

    private /* synthetic */ o0 U0(boolean bl2, String string2) {
        d.v.w.j j10 = new d.v.w.j(this, bl2, string2);
        return i0.H(j10);
    }

    private /* synthetic */ o0 W0(String object) {
        object = new t(this);
        return i0.H((m0)object);
    }

    private /* synthetic */ o0 Y0(String string2, boolean bl2, String string3) {
        r r10 = new r(this, string2, string3, bl2);
        return i0.H(r10);
    }

    public static /* synthetic */ d c0(PayClientLifecycle payClientLifecycle) {
        return payClientLifecycle.b;
    }

    private String e0(Purchase object) {
        object = object != null && (object = ((Purchase)object).a()) != null ? z.a(((a)object).a()) : "";
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PayClientLifecycle f0(Application application) {
        Object object = m;
        if (object != null) return m;
        object = PayClientLifecycle.class;
        synchronized (object) {
            PayClientLifecycle payClientLifecycle = m;
            if (payClientLifecycle != null) return m;
            m = payClientLifecycle = new PayClientLifecycle(application);
            return m;
        }
    }

    private String g0(Purchase object) {
        object = object != null && (object = ((Purchase)object).a()) != null ? z.a(((a)object).b()) : "";
        return object;
    }

    private Purchase h0(String string2, String stream) {
        if ((stream = this.U((String)((Object)stream))) != null) {
            stream = stream.stream();
            d.v.w.o o10 = new d.v.w.o(string2);
            return stream.filter(o10).findFirst().orElse(null);
        }
        return null;
    }

    private SkuDetails i0(String string2) {
        Map map = this.i;
        if (map != null) {
            return (SkuDetails)map.get(string2);
        }
        return null;
    }

    private Purchase j0() {
        Object object = this.U("subs");
        if (object != null) {
            object = object.stream();
            v v10 = v.a;
            return object.filter(v10).findFirst().orElse(null);
        }
        return null;
    }

    private boolean k0() {
        boolean bl2;
        Purchase purchase = this.j0();
        if (purchase != null) {
            bl2 = true;
        } else {
            bl2 = false;
            purchase = null;
        }
        return bl2;
    }

    private /* synthetic */ void l0(d.v.w.c0.f object, k0 k02) {
        boolean bl2 = object instanceof l;
        if (bl2) {
            Object object2 = object;
            object2 = (l)object;
            Object object3 = ((l)object2).d();
            String string2 = ((l)object2).c();
            ((l)object2).f();
            bl2 = ((l)object2).e();
            boolean bl3 = object.a();
            if (bl2) {
                boolean bl4;
                object2 = this.h0((String)object3, "inapp");
                if (object2 != null && (bl4 = ((Purchase)object2).k())) {
                    bl3 = PayClientLifecycle.super.n((String)(object2 = ((Purchase)object2).h()), (j)(object3 = new n(k02, bl3, string2)));
                    if (!bl3) {
                        object = PurchaseResult.PURCHASE_OK;
                        object2 = "\u8c37\u6b4c\u6d88\u8d39\u5546\u54c1\u5931\u8d25!";
                        object = ValueException.create((String)object2, object);
                        k02.tryOnError((Throwable)object);
                    }
                } else {
                    object = PurchaseResult.PURCHASE_OK;
                    object2 = "\u6ca1\u6709\u83b7\u53d6\u5230\u8c37\u6b4c\u8d2d\u4e70\u4ee4\u724c\u6216\u8005\u5546\u54c1\u6ca1\u6709\u786e\u8ba4\u8d2d\u4e70,\u65e0\u6cd5\u6d88\u8d39!";
                    object = ValueException.create((String)object2, object);
                    k02.tryOnError((Throwable)object);
                }
            } else {
                object = d.v.w.d0.k.g.b(bl3, string2);
                k02.onSuccess(object);
            }
        } else {
            object = PurchaseResult.PURCHASE_OK;
            String string3 = "\u6ca1\u6709\u6d88\u8d39\u53c2\u6570,\u65e0\u6cd5\u6d88\u8d39!";
            object = ValueException.create(string3, object);
            k02.tryOnError((Throwable)object);
        }
    }

    private /* synthetic */ void n0(String object, boolean bl2, k0 k02) {
        List<String> list = this.i0((String)object);
        if (list != null) {
            k02.onSuccess(list);
        } else {
            d.v.w.g g10;
            Object object2;
            list = Collections.singletonList(object);
            bl2 = this.Z(list, (String)(object2 = bl2 ? "subs" : "inapp"), g10 = new d.v.w.g(this, (String)object, k02));
            if (!bl2) {
                object2 = new StringBuilder();
                list = "\u67e5\u8be2\u8c37\u6b4c\u5546\u54c1\u5f02\u5e38, SkuId = ";
                ((StringBuilder)object2).append((String)((Object)list));
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                object2 = PayFlowResult.PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT;
                object = ValueException.create((String)object, object2);
                k02.tryOnError((Throwable)object);
            }
        }
    }

    private /* synthetic */ o0 p0(SkuDetails skuDetails) {
        d.v.w.a a10 = new d.v.w.a(this, skuDetails);
        return i0.H(a10);
    }

    private /* synthetic */ o0 r0(boolean bl2, Pair pair) {
        d.v.w.i i10 = new d.v.w.i(this, pair, bl2);
        return i0.H(i10);
    }

    private /* synthetic */ o0 t0(String string2, String string3, String string4, Pair pair) {
        d.v.w.c c10 = new d.v.w.c(this, pair, string2, string3, string4);
        return i0.H(c10);
    }

    public static /* synthetic */ boolean v0(String string2, Purchase purchase) {
        return purchase.j().equals(string2);
    }

    public static /* synthetic */ boolean w0(Purchase purchase) {
        int n10;
        boolean bl2 = purchase.k();
        int n11 = 1;
        if (!bl2 || !(bl2 = purchase.l()) || (n10 = purchase.f()) != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private /* synthetic */ void x0(String object, k0 k02, h object2, List object3) {
        object2 = this.i0((String)object);
        if (object2 != null) {
            k02.onSuccess(object2);
        } else {
            object2 = new StringBuilder();
            object3 = "\u67e5\u8be2\u8c37\u6b4c\u5546\u54c1\u5f02\u5e38, SkuId = ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = PayFlowResult.PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT;
            object = ValueException.create((String)object, object2);
            k02.tryOnError((Throwable)object);
        }
    }

    public static /* synthetic */ void z0(k0 k02, boolean bl2, String object, h h10, String string2) {
        int n10 = h10.b();
        if (n10 != 0) {
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("\u8c37\u6b4c\u6d88\u8d39\u5546\u54c1\u5931\u8d25! responseCode:");
            ((StringBuilder)object2).append(n10);
            object2 = ((StringBuilder)object2).toString();
            object = PurchaseResult.PURCHASE_OK;
            object2 = ValueException.create((String)object2, object);
            k02.tryOnError((Throwable)object2);
        } else {
            d.v.w.d0.k.a a10 = d.v.w.d0.k.g.b(bl2, object);
            k02.onSuccess(a10);
        }
    }

    public o0 B(String object, boolean bl2, boolean bl3, String string2) {
        object = new d.v.w.h(this, string2);
        object = i0.H((m0)object);
        o o10 = new d.v.w.k(this, bl2);
        object = ((i0)object).h0(o10);
        o10 = new d.v.w.l(this);
        object = ((i0)object).h0(o10);
        o10 = new d.v.w.b(this, string2, bl2);
        return ((i0)object).h0(o10);
    }

    public /* synthetic */ void B0(boolean bl2, String string2, k0 k02) {
        this.A0(bl2, string2, k02);
    }

    public boolean D(Activity activity, c object) {
        int n10;
        boolean bl2 = object instanceof i;
        boolean bl3 = false;
        if (bl2 && (n10 = super.P(activity, (g)(object = ((i)object).d()))) == 0) {
            bl3 = true;
        }
        return bl3;
    }

    public /* synthetic */ void D0(k0 k02) {
        this.C0(k02);
    }

    public /* synthetic */ void F0(String string2, k0 k02, String string3, h h10, List list) {
        this.E0(string2, k02, string3, h10, list);
    }

    public /* synthetic */ void H0(k0 k02, SkuDetails skuDetails, String string2, h h10, List list) {
        this.G0(k02, skuDetails, string2, h10, list);
    }

    public /* synthetic */ void J0(String string2, String string3, boolean bl2, k0 k02) {
        this.I0(string2, string3, bl2, k02);
    }

    public /* synthetic */ void L0(SkuDetails skuDetails, k0 k02) {
        this.K0(skuDetails, k02);
    }

    public /* synthetic */ void N0(Purchase purchase, k0 k02, Pair pair, h h10, String string2) {
        this.M0(purchase, k02, pair, h10, string2);
    }

    public /* synthetic */ void P0(Pair pair, boolean bl2, k0 k02) {
        this.O0(pair, bl2, k02);
    }

    /*
     * WARNING - void declaration
     */
    public void R(Purchase object, boolean bl2, boolean bl3, ValueException$b object2) {
        Object object3;
        Object object4;
        Object object5;
        boolean bl4;
        void var3_6;
        int n10;
        Object object6;
        int n11;
        int n12 = 2;
        int n13 = 1;
        if (object != null && bl2) {
            PurchaseResult purchaseResult;
            n11 = ((Purchase)object).f();
            if (n11 == 0 || n11 == n12) {
                object6 = new StringBuilder();
                ((StringBuilder)object6).append("\u8c37\u6b4c\u5f53\u524d\u4ea4\u6613\u72b6\u6001, getPurchaseState: %s");
                n11 = ((Purchase)object).f();
                ((StringBuilder)object6).append(n11);
                object6 = ((StringBuilder)object6).toString();
                purchaseResult = PurchaseResult.PURCHASE_NOTIFY_PLATFORM_UNSPECIFIED_STATE;
                object6 = ValueException.createValue((String)object6, (Object)purchaseResult);
            }
            n11 = ((Purchase)object).f();
            if (n11 == n13) {
                n11 = n13;
            } else {
                n11 = 0;
                purchaseResult = null;
            }
            n10 = bl2 & n11;
        }
        void var9_12 = n10;
        void var10_13 = object6;
        int n14 = 4;
        Object object7 = new Object[n14];
        object7[0] = object;
        object7[n13] = object6 = Boolean.valueOf((boolean)var9_12);
        object7[n12] = object6 = Boolean.valueOf((boolean)var3_6);
        int n15 = 3;
        object7[n15] = var10_13;
        object6 = "logPurchase, purchase : %s, successful : %s, background : %s,  failPurchaseResult : %s";
        m.a.a.b((String)object6, object7);
        String string2 = this.g0((Purchase)object);
        int n16 = object != null && !(bl4 = ((Purchase)object).k()) ? n13 : 0;
        object7 = "";
        if (n16 != 0) {
            object6 = ((Purchase)object).h();
            object5 = object6;
        } else {
            object5 = object7;
        }
        if (n16 != 0) {
            object6 = ((Purchase)object).i();
            object4 = object6;
        } else {
            object4 = object7;
        }
        if (n16 != 0) {
            object = ((Purchase)object).d();
            object3 = object;
        } else {
            object3 = object7;
        }
        n11 = var3_6;
        object = d.v.w.d0.k.j.d((boolean)var3_6, (boolean)var9_12, string2, (ValueException$b)var10_13, n16 != 0, (String)object5, (String)object4, (String)object3);
        a0.a().b((d.v.w.c0.d)object);
    }

    public /* synthetic */ void R0(Pair pair, String string2, String string3, String string4, k0 k02) {
        this.Q0(pair, string2, string3, string4, k02);
    }

    public /* synthetic */ void T0(String string2, k0 k02) {
        this.S0(string2, k02);
    }

    public /* synthetic */ o0 V0(boolean bl2, String string2) {
        return this.U0(bl2, string2);
    }

    public /* synthetic */ o0 X0(String string2) {
        return this.W0(string2);
    }

    public /* synthetic */ o0 Z0(String string2, boolean bl2, String string3) {
        return this.Y0(string2, bl2, string3);
    }

    public k a1(SkuDetails skuDetails, String string2) {
        String string3 = skuDetails.n();
        String string4 = skuDetails.q();
        String string5 = skuDetails.k();
        long l10 = skuDetails.l();
        String string6 = skuDetails.i();
        long l11 = skuDetails.j();
        String string7 = skuDetails.m();
        return k.j(string3, string4, string5, l10, string6, l11, string7, string2, skuDetails);
    }

    public o0 h(d.v.w.c0.f f10) {
        q q10 = new q(this, f10);
        return i0.H(q10);
    }

    public /* synthetic */ void m0(d.v.w.c0.f f10, k0 k02) {
        this.l0(f10, k02);
    }

    public /* synthetic */ void o0(String string2, boolean bl2, k0 k02) {
        this.n0(string2, bl2, k02);
    }

    public o0 q(b object) {
        boolean bl2;
        String string2 = object.c();
        String string3 = object.a();
        String string4 = object.b();
        boolean bl3 = object.d();
        boolean bl4 = object.e();
        boolean bl5 = object instanceof d.v.w.d0.k.h;
        if (bl5) {
            object = (d.v.w.d0.k.h)object;
            bl2 = ((d.v.w.d0.k.h)object).g();
        } else {
            bl2 = false;
            object = null;
        }
        Object[] objectArray = new Object[6];
        objectArray[0] = string2;
        objectArray[1] = string3;
        objectArray[2] = string4;
        Boolean bl6 = bl3;
        objectArray[3] = bl6;
        bl6 = bl4;
        objectArray[4] = bl6;
        objectArray[5] = object = Boolean.valueOf(bl2);
        m.a.a.b("getPayFlowParams,skuId: %s, orderSN: %s, userId: %s, isSubscribe: %s, isConsume: %s, userSubscribePlatform: %s", objectArray);
        object = new d.v.w.f(this, string2, bl3);
        object = i0.H((m0)object);
        o o10 = new p(this);
        object = ((i0)object).h0(o10);
        o10 = new e(this, bl4);
        object = ((i0)object).h0(o10);
        o10 = new s(this, string4, string3, string2);
        return ((i0)object).h0(o10);
    }

    public /* synthetic */ o0 q0(SkuDetails skuDetails) {
        return this.p0(skuDetails);
    }

    public /* synthetic */ o0 s0(boolean bl2, Pair pair) {
        return this.r0(bl2, pair);
    }

    public /* synthetic */ o0 u0(String string2, String string3, String string4, Pair pair) {
        return this.t0(string2, string3, string4, pair);
    }

    public /* synthetic */ void y0(String string2, k0 k02, h h10, List list) {
        this.x0(string2, k02, h10, list);
    }
}

