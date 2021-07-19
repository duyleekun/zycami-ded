/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.zhiyun.pay.googleplay;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.Purchase$b;
import com.android.billingclient.api.SkuDetails;
import com.zhiyun.common.exception.ValueException$b;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle$a;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle$b;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle$c;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle$d;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle$e;
import d.b.a.b.b;
import d.b.a.b.d;
import d.b.a.b.d$b;
import d.b.a.b.f;
import d.b.a.b.g;
import d.b.a.b.h;
import d.b.a.b.i;
import d.b.a.b.j;
import d.b.a.b.m;
import d.b.a.b.n;
import d.b.a.b.o;
import d.b.a.b.o$a;
import d.b.a.b.p;
import d.v.w.c0.e;
import d.v.w.d0.c;
import d.v.w.d0.k.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m.a.a;

public abstract class GoogleBillingClientLifecycle
implements LifecycleObserver {
    public Application a;
    public d b;
    private GoogleBillingClientLifecycle$e c;
    public boolean d;
    public boolean e;
    public boolean f;
    public List g;
    public Set h;
    public Map i;
    private MediatorLiveData j;
    private MutableLiveData k;
    private MutableLiveData l;

    public GoogleBillingClientLifecycle(Application object) {
        Object object2 = new HashSet();
        this.h = object2;
        this.i = object2;
        this.j = object2 = new MediatorLiveData();
        this.k = object2 = new MutableLiveData();
        this.l = object2 = new MutableLiveData();
        this.a = object;
        super(this);
        this.c = object;
        object = this.j;
        object2 = this.k;
        Observer observer = new d.v.w.d0.j(this);
        ((MediatorLiveData)object).addSource((LiveData)object2, observer);
        object = this.j;
        object2 = this.l;
        super(this);
        ((MediatorLiveData)object).addSource((LiveData)object2, observer);
    }

    private /* synthetic */ void A(h h10, List list) {
        this.V("inapp");
    }

    private /* synthetic */ void G(m m10, h h10, List list) {
        GoogleBillingClientLifecycle$e googleBillingClientLifecycle$e = this.c;
        googleBillingClientLifecycle$e.f(h10, list);
        if (m10 != null) {
            m10.f(h10, list);
        }
    }

    private /* synthetic */ void I(h h10, List list) {
        this.r(list, "subs");
    }

    private /* synthetic */ void K(h h10, List list) {
        this.r(list, "inapp");
    }

    private /* synthetic */ void M(p p10, h h10, List list) {
        GoogleBillingClientLifecycle$e googleBillingClientLifecycle$e = this.c;
        googleBillingClientLifecycle$e.c(h10, list);
        if (p10 != null) {
            p10.c(h10, list);
        }
    }

    private void Q(List object) {
        int n10;
        int n11;
        boolean bl2 = true;
        Object[] objectArray = new Object[bl2];
        objectArray[0] = object;
        String string2 = "logAcknowledgementStatus \u4ea4\u6613\u5217\u8868, purchasesList= %s";
        m.a.a.b(string2, objectArray);
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            n11 = 0;
            objectArray = null;
            n10 = 0;
            string2 = null;
            while (bl3 = object.hasNext()) {
                Purchase purchase = (Purchase)object.next();
                boolean bl4 = purchase.k();
                if (bl4) {
                    ++n11;
                    continue;
                }
                ++n10;
                bl4 = false;
                this.R(purchase, bl2, false, null);
            }
        } else {
            n11 = 0;
            objectArray = null;
            n10 = 0;
            string2 = null;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("logAcknowledgementStatus, acknowledged=");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(" unacknowledged=");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Object[] objectArray2 = new Object[]{};
        m.a.a.b((String)object, objectArray2);
    }

    private boolean S() {
        boolean bl2;
        List list = this.o();
        Object object = (List)this.j.getValue();
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                String string2 = ((e)object.next()).d();
                list.remove(string2);
            }
        }
        if ((bl2 = list.size()) > false) {
            bl2 = true;
        } else {
            bl2 = false;
            list = null;
        }
        return bl2;
    }

    private void T(List objectArray) {
        boolean bl2;
        String string2 = null;
        if (objectArray != null && !(bl2 = objectArray.isEmpty())) {
            bl2 = this.i((List)objectArray);
            if (bl2) {
                this.g = objectArray;
                this.Q((List)objectArray);
            } else {
                objectArray = new Object[]{};
                string2 = "processPurchases: with no change purchases";
                m.a.a.b(string2, objectArray);
            }
            return;
        }
        this.R(null, true, false, null);
    }

    private void V(String objectArray) {
        int n10 = 1;
        Object object = new Object[n10];
        object[0] = objectArray;
        String string2 = "queryPurchasesAndNotify, skuType: %s";
        m.a.a.i(string2, object);
        objectArray = this.U((String)objectArray);
        if (objectArray != null && (n10 = (int)(objectArray.isEmpty() ? 1 : 0)) == 0) {
            this.Q((List)objectArray);
        } else {
            objectArray = new Object[]{};
            object = "queryPurchasesAndNotify: null purchase list";
            m.a.a.i((String)object, objectArray);
        }
    }

    public static /* synthetic */ GoogleBillingClientLifecycle$e b(GoogleBillingClientLifecycle googleBillingClientLifecycle) {
        return googleBillingClientLifecycle.c;
    }

    public static /* synthetic */ void c(GoogleBillingClientLifecycle googleBillingClientLifecycle, List list) {
        googleBillingClientLifecycle.p(list);
    }

    public static /* synthetic */ void d(GoogleBillingClientLifecycle googleBillingClientLifecycle, List list) {
        googleBillingClientLifecycle.T(list);
    }

    private boolean i(List object) {
        int n10 = 2;
        Object object2 = new Object[n10];
        List list = this.g;
        object2[0] = list;
        boolean bl2 = true;
        object2[bl2] = object;
        String string2 = "checkPurchasesChange, \u4e0a\u6b21\u7684\u7ed3\u679c: %s;     \u65b0\u7684\u7ed3\u679c: %s;";
        m.a.a.b(string2, object2);
        if (object != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            List list2;
            int n11;
            object2 = this.g;
            string2 = "checkPurchasesChange, true";
            if (object2 != null && (n10 = object.size()) <= (n11 = (list2 = this.g).size())) {
                object = object.iterator();
                while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    list2 = this.g;
                    object2 = (Purchase)object.next();
                    n10 = (int)(list2.contains(object2) ? 1 : 0);
                    if (n10 != 0) continue;
                    object = new Object[]{};
                    m.a.a.b(string2, (Object[])object);
                    return bl2;
                }
            } else {
                object = new Object[]{};
                m.a.a.b(string2, (Object[])object);
                return bl2;
            }
        }
        object = new Object[]{};
        m.a.a.b("checkPurchasesChange, false", (Object[])object);
        return false;
    }

    private boolean j(h h10) {
        boolean bl2;
        if (h10 != null && !(bl2 = h10.b())) {
            bl2 = true;
        } else {
            bl2 = false;
            h10 = null;
        }
        return bl2;
    }

    private boolean k(String string2) {
        h h10 = this.b.d(string2);
        boolean bl2 = this.j(h10);
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        String string3 = bl2 ? "\u652f\u6301" : "\u4e0d\u652f\u6301";
        objectArray[0] = string3;
        objectArray[1] = string2;
        m.a.a.i("Google Play %s \u529f\u80fd: %s", objectArray);
        return bl2;
    }

    private void m() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (bl2 = ((d)object).e())) {
            this.Y();
        } else {
            object = new GoogleBillingClientLifecycle$b(this);
            this.l((f)object);
        }
    }

    private List o() {
        Set set = this.h;
        ArrayList arrayList = new ArrayList(set);
        return arrayList;
    }

    private void p(List object) {
        boolean bl2 = false;
        Object object2 = null;
        if (object == null) {
            object = new Object[]{};
            object2 = "onSkuDetailsResponse: null SkuDetails list";
            m.a.a.x((String)object2, (Object[])object);
            this.i = object = Collections.emptyMap();
        } else {
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append("onSkuDetailsResponse: count ");
            int n10 = object.size();
            ((StringBuilder)object3).append(n10);
            ((StringBuilder)object3).append(" list:");
            ((StringBuilder)object3).append(object);
            object3 = ((StringBuilder)object3).toString();
            Object object4 = new Object[]{};
            m.a.a.i((String)object3, object4);
            object2 = new Object[]{};
            object3 = "-------------\u5206\u5272\u7ebf------------------";
            m.a.a.i((String)object3, (Object[])object2);
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (SkuDetails)object.next();
                object3 = this.i;
                object4 = ((SkuDetails)object2).n();
                object3.remove(object4);
                object3 = this.i;
                object4 = ((SkuDetails)object2).n();
                object3.put(object4, object2);
            }
        }
    }

    private void r(List list, String object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        object2[0] = object;
        String string2 = "handleSkuDetailCollectionAndNotifyLiveData, skuType: %s";
        m.a.a.i(string2, (Object[])object2);
        if (list != null && (n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) == 0) {
            object2 = "subs";
            n10 = (int)(((String)object2).equals(object) ? 1 : 0);
            if (n10 != 0) {
                object = this.l;
                list = this.b0(list);
                ((MutableLiveData)object).setValue(list);
            } else {
                object2 = "inapp";
                boolean bl2 = ((String)object2).equals(object);
                if (bl2) {
                    object = this.k;
                    list = this.b0(list);
                    ((MutableLiveData)object).setValue(list);
                }
            }
        }
    }

    public static /* synthetic */ void s(h object) {
        int n10 = ((h)object).b();
        object = ((h)object).a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("acknowledgePurchase: ");
        stringBuilder.append(n10);
        stringBuilder.append(" ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
    }

    public static /* synthetic */ void t(j j10, h h10, String string2) {
        int n10 = h10.b();
        Object[] objectArray = h10.a();
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "consumeSku: ";
        stringBuilder.append(string3);
        stringBuilder.append(n10);
        stringBuilder.append(" ");
        stringBuilder.append((String)objectArray);
        String string4 = stringBuilder.toString();
        objectArray = new Object[]{};
        m.a.a.b(string4, objectArray);
        if (j10 != null) {
            j10.h(h10, string2);
        }
    }

    private /* synthetic */ void u(List object) {
        List list = (List)this.l.getValue();
        boolean bl2 = this.e;
        if (!bl2 || list != null) {
            ArrayList arrayList = new ArrayList();
            if (object != null) {
                arrayList.addAll(object);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            object = this.j;
            ((MutableLiveData)object).setValue(arrayList);
        }
    }

    private /* synthetic */ void w(List object) {
        List list = (List)this.k.getValue();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (object != null) {
                arrayList.addAll(object);
            }
            arrayList.addAll(list);
            object = this.j;
            ((MutableLiveData)object).setValue(arrayList);
        }
    }

    private /* synthetic */ void y(h h10, List list) {
        this.V("subs");
    }

    public void C() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (bl2 = ((d)object).e())) {
            this.W();
        } else {
            object = new GoogleBillingClientLifecycle$a(this);
            this.l((f)object);
        }
    }

    public /* synthetic */ void F(h h10, List list) {
        this.A(h10, list);
    }

    public /* synthetic */ void H(m m10, h h10, List list) {
        this.G(m10, h10, list);
    }

    public /* synthetic */ void J(h h10, List list) {
        this.I(h10, list);
    }

    public /* synthetic */ void L(h h10, List list) {
        this.K(h10, list);
    }

    public /* synthetic */ void N(p p10, h h10, List list) {
        this.M(p10, h10, list);
    }

    public LiveData O() {
        return this.j;
    }

    public int P(Activity object, g g10) {
        Object object2 = g10.d();
        String string2 = g10.a();
        Object object3 = new StringBuilder();
        String string3 = "launchBillingFlow: sku: ";
        object3.append(string3);
        object3.append((String)object2);
        object3.append(", oldSku: ");
        object3.append(string2);
        object2 = object3.toString();
        string2 = null;
        object3 = new Object[]{};
        m.a.a.i((String)object2, object3);
        object2 = this.b;
        boolean bl2 = ((d)object2).e();
        if (!bl2) {
            object2 = new Object[]{};
            object3 = "launchBillingFlow: BillingClient is not ready";
            m.a.a.e((String)object3, (Object[])object2);
        }
        object = this.b.f((Activity)object, g10);
        int n10 = ((h)object).b();
        object = ((h)object).a();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("launchBillingFlow: BillingResponse ");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = new Object[]{};
        m.a.a.b((String)object, (Object[])object2);
        return n10;
    }

    public abstract void R(Purchase var1, boolean var2, boolean var3, ValueException$b var4);

    public List U(String object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        object2[0] = object;
        m.a.a.i("queryPurchases, skuType: %s", (Object[])object2);
        object2 = this.b;
        boolean n11 = ((d)object2).e();
        if (!n11) {
            object = new Object[]{};
            m.a.a.e("queryPurchases, BillingClient is not ready", (Object[])object);
            return null;
        }
        object2 = this.b;
        if ((object = ((d)object2).j((String)object)) != null && (object2 = ((Purchase$b)object).a()) != null) {
            CharSequence objectArray;
            object2 = ((Purchase$b)object).a();
            boolean bl2 = this.j((h)object2);
            if (!bl2) {
                object = new Object[n10];
                Integer charSequence = ((h)object2).b();
                object[0] = charSequence;
                m.a.a.e("queryPurchases, getResponseCode: %s", (Object[])object);
                return null;
            }
            if ((object = ((Purchase$b)object).b()) == null) {
                object = new Object[]{};
                objectArray = "queryPurchases, null purchase result";
                m.a.a.i((String)objectArray, (Object[])object);
                object = new ArrayList();
            }
            objectArray = new StringBuilder();
            ((StringBuilder)objectArray).append("queryPurchases,  ");
            int n12 = object.size();
            ((StringBuilder)objectArray).append(n12);
            ((StringBuilder)objectArray).append(" purchase(s); ");
            ((StringBuilder)objectArray).append(object);
            objectArray = ((StringBuilder)objectArray).toString();
            object2 = new Object[]{};
            m.a.a.b((String)objectArray, (Object[])object2);
            return object;
        }
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        m.a.a.e("queryPurchases, PurchasesResult: %s", objectArray);
        return null;
    }

    public void W() {
        m m10 = new d.v.w.d0.d(this);
        this.X("subs", m10);
        m10 = new d.v.w.d0.g(this);
        this.X("inapp", m10);
    }

    public boolean X(String string2, m m10) {
        Object object = this.b;
        boolean bl2 = ((d)object).e();
        d.v.w.d0.e e10 = null;
        if (!bl2) {
            return false;
        }
        bl2 = this.e;
        if (!bl2 && (bl2 = (boolean)((String)(object = "subs")).equals(string2))) {
            return false;
        }
        bl2 = true;
        Object[] objectArray = new Object[bl2];
        objectArray[0] = string2;
        m.a.a.b("queryPurchasesAsync, %s", objectArray);
        e10 = new d.v.w.d0.e(this, m10);
        this.b.i(string2, e10);
        return bl2;
    }

    public void Y() {
        p p10 = new d.v.w.d0.b(this);
        this.Z(null, "subs", p10);
        p10 = new c(this);
        this.Z(null, "inapp", p10);
    }

    public boolean Z(List object, String object2, p object3) {
        Object object4 = new Object[2];
        object4[0] = object2;
        boolean bl2 = true;
        object4[bl2] = object;
        String string2 = "querySkuDetailsAsync, type: %s, skus: %s";
        m.a.a.i(string2, (Object[])object4);
        object4 = this.b;
        boolean bl3 = ((d)object4).e();
        if (!bl3) {
            return false;
        }
        bl3 = this.e;
        if (!bl3 && (bl3 = ((String)(object4 = "subs")).equals(object2))) {
            return false;
        }
        this.f((List)object);
        object = this.o();
        object4 = o.c();
        ((o$a)object4).b((List)object).c((String)object2);
        object = new d.v.w.d0.a(this, (p)object3);
        object2 = this.b;
        object3 = ((o$a)object4).a();
        ((d)object2).k((o)object3, (p)object);
        return bl2;
    }

    public List a(List list) {
        boolean bl2;
        if (list != null) {
            Set set = this.h;
            set.addAll(list);
        }
        if (bl2 = this.S()) {
            this.m();
            return null;
        }
        return (List)this.j.getValue();
    }

    public k a0(SkuDetails skuDetails) {
        String string2 = skuDetails.n();
        String string3 = skuDetails.q();
        String string4 = skuDetails.k();
        long l10 = skuDetails.l();
        String string5 = skuDetails.i();
        long l11 = skuDetails.j();
        String string6 = skuDetails.m();
        return d.v.w.d0.k.k.i(string2, string3, string4, l10, string5, l11, string6, skuDetails);
    }

    public List b0(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (SkuDetails)object.next();
            object2 = this.a0((SkuDetails)object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public void create() {
        Object object = new Object[]{};
        m.a.a.b("ON_CREATE", object);
        object = new GoogleBillingClientLifecycle$c(this);
        this.l((f)object);
    }

    public void destroy() {
        Object object = null;
        Object object2 = new Object[]{};
        String string2 = "ON_DESTROY";
        m.a.a.b(string2, (Object[])object2);
        object2 = this.b;
        boolean bl2 = ((d)object2).e();
        if (bl2) {
            object = new Object[]{};
            object2 = "BillingClient can only be used once -- closing connection";
            m.a.a.b((String)object2, (Object[])object);
            object = this.b;
            ((d)object).c();
        }
    }

    public void e(String object) {
        Object object2 = new Object[]{};
        m.a.a.b("acknowledgePurchase", (Object[])object2);
        object = d.b.a.b.b.b().b((String)object).a();
        object2 = this.b;
        d.v.w.d0.f f10 = d.v.w.d0.f.a;
        ((d)object2).a((b)object, f10);
    }

    public void f(List list) {
        if (list != null) {
            Set set = this.h;
            set.addAll(list);
        }
    }

    public void g() {
        boolean bl2;
        this.d = bl2 = this.k("priceChangeConfirmation");
        this.e = bl2 = this.k("subscriptions");
        this.f = bl2 = this.k("subscriptionsUpdate");
    }

    public void l(f f10) {
        GoogleBillingClientLifecycle$d googleBillingClientLifecycle$d = new GoogleBillingClientLifecycle$d(this, f10);
        Object object = d.b.a.b.d.h((Context)this.a);
        Object object2 = this.c;
        this.b = object = ((d$b)object).c((n)object2).b().a();
        boolean bl2 = ((d)object).e();
        if (!bl2) {
            bl2 = false;
            object = new Object[]{};
            object2 = "BillingClient: Start connection...";
            m.a.a.b((String)object2, (Object[])object);
            object = this.b;
            try {
                ((d)object).l(googleBillingClientLifecycle$d);
            }
            catch (Exception exception) {
                if (f10 != null) {
                    f10.b();
                }
                int n10 = 41001;
                object = "\u7248\u672c\u53f71.0.7 BillingClient: Start connection exception, \u8c03\u7528\u5f00\u59cb\u8fde\u63a5\u5f02\u5e38";
                d.v.q.e.j(n10, exception, (String)object);
            }
        }
    }

    public boolean n(String object, j j10) {
        d.v.w.d0.i i10 = null;
        Object object2 = new Object[]{};
        String string2 = "consumeSku";
        m.a.a.b(string2, (Object[])object2);
        object2 = this.b;
        boolean bl2 = ((d)object2).e();
        if (!bl2) {
            return false;
        }
        i10 = new d.v.w.d0.i(j10);
        object = d.b.a.b.i.b().b((String)object).a();
        this.b.b((i)object, i10);
        return true;
    }

    public /* synthetic */ void v(List list) {
        this.u(list);
    }

    public /* synthetic */ void x(List list) {
        this.w(list);
    }

    public /* synthetic */ void z(h h10, List list) {
        this.y(h10, list);
    }
}

