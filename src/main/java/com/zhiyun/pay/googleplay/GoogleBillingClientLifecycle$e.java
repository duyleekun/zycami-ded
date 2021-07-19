/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.pay.googleplay;

import com.zhiyun.common.exception.ValueException;
import com.zhiyun.common.exception.ValueException$b;
import com.zhiyun.pay.data.PurchaseResult;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle;
import d.b.a.b.d;
import d.b.a.b.f;
import d.b.a.b.h;
import d.b.a.b.m;
import d.b.a.b.n;
import d.b.a.b.p;
import d.v.q.e;
import java.util.List;
import m.a.a;

public class GoogleBillingClientLifecycle$e
implements n,
f,
p,
m {
    public final /* synthetic */ GoogleBillingClientLifecycle a;

    public GoogleBillingClientLifecycle$e(GoogleBillingClientLifecycle googleBillingClientLifecycle) {
        this.a = googleBillingClientLifecycle;
    }

    public void a(h object) {
        int n10;
        int n11 = ((h)object).b();
        object = ((h)object).a();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("onBillingSetupFinished, \u8c37\u6b4c\u8fde\u63a5\u6210\u529f: ");
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        Object object3 = new Object[]{};
        m.a.a.b((String)object2, (Object[])object3);
        if (n11 == 0 && (n10 = (int)(((d)(object2 = this.a.b)).e() ? 1 : 0)) != 0) {
            object2 = this.a;
            ((GoogleBillingClientLifecycle)object2).g();
        }
        if (n11 != 0 || (n10 = (int)(((d)(object2 = this.a.b)).e() ? 1 : 0)) == 0) {
            n10 = 41001;
            object3 = new StringBuilder();
            String string2 = "\u7248\u672c\u53f71.0.7 BillingClient: \u8fde\u63a5\u5f02\u5e38\u4fe1\u606f, responseCode:";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(n11);
            String string3 = ", debugMessage:";
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            e.h(n10, (String)object);
        }
    }

    public void b() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("onBillingServiceDisconnected,\u8c37\u6b4c\u8fde\u63a5\u5931\u8d25", objectArray);
    }

    public void c(h object, List objectArray) {
        Object[] objectArray2 = null;
        if (object == null) {
            object = new Object[]{};
            m.a.a.A("onSkuDetailsResponse: null BillingResult", object);
            return;
        }
        int n10 = object.b();
        object = object.a();
        String string2 = " ";
        String string3 = "onSkuDetailsResponse: ";
        switch (n10) {
            default: {
                objectArray = new StringBuilder();
                objectArray.append(string3);
                objectArray.append(n10);
                objectArray.append(string2);
                objectArray.append((String)object);
                object = objectArray.toString();
                objectArray = new Object[]{};
                m.a.a.A((String)object, objectArray);
                break;
            }
            case 1: {
                objectArray = new StringBuilder();
                objectArray.append(string3);
                objectArray.append(n10);
                objectArray.append(string2);
                objectArray.append((String)object);
                object = objectArray.toString();
                objectArray = new Object[]{};
                m.a.a.i((String)object, objectArray);
                break;
            }
            case 0: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(n10);
                stringBuilder.append(string2);
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                objectArray2 = new Object[]{};
                m.a.a.i((String)object, objectArray2);
                object = this.a;
                GoogleBillingClientLifecycle.c((GoogleBillingClientLifecycle)object, (List)objectArray);
                break;
            }
            case -1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                objectArray = new StringBuilder();
                objectArray.append(string3);
                objectArray.append(n10);
                objectArray.append(string2);
                objectArray.append((String)object);
                object = objectArray.toString();
                objectArray = new Object[]{};
                m.a.a.e((String)object, objectArray);
            }
        }
    }

    public void d(h object, List object2) {
        Object object3;
        String string2 = null;
        if (object == null) {
            object = new Object[]{};
            m.a.a.A("onPurchasesUpdated: null BillingResult", object);
            return;
        }
        int n10 = object.b();
        object = object.a();
        int n11 = 2;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object3 = Integer.valueOf(n10);
        int n12 = 1;
        objectArray[n12] = object;
        CharSequence charSequence = "onPurchasesUpdated: responseCode:%s debugMessage:%s";
        m.a.a.b((String)charSequence, objectArray);
        if (n10 != 0) {
            object2 = ", \u8c37\u6b4c\u9519\u8bef\u7801";
            n11 = 0;
            objectArray = null;
            if (n10 != n12) {
                n12 = 5;
                if (n10 != n12) {
                    n12 = 7;
                    if (n10 != n12) {
                        object3 = this.a;
                        charSequence = new StringBuilder();
                        String string3 = " \u8d2d\u4e70\u5931\u8d25,\u652f\u4ed8api\u672a\u77e5\u9519\u8bef";
                        ((StringBuilder)charSequence).append(string3);
                        ((StringBuilder)charSequence).append((String)object);
                        ((StringBuilder)charSequence).append((String)object2);
                        ((StringBuilder)charSequence).append(n10);
                        object = ((StringBuilder)charSequence).toString();
                        object2 = PurchaseResult.PURCHASE_FAIL_NOTIFY_PLATFORM_FAIL;
                        object = ValueException.createValue((String)object, object2);
                        ((GoogleBillingClientLifecycle)object3).R(null, false, false, (ValueException$b)object);
                    } else {
                        object3 = new Object[]{};
                        m.a.a.i("onPurchasesUpdated: The user already owns this item", (Object[])object3);
                        object3 = this.a;
                        charSequence = new StringBuilder();
                        String string4 = "\u8d2d\u4e70\u5931\u8d25\uff0c\u56e0\u4e3a\u8be5\u7269\u54c1\u5df2\u88ab\u62e5\u6709\uff0c\u8fd8\u6ca1\u6709\u88ab\u6d88\u8017";
                        ((StringBuilder)charSequence).append(string4);
                        ((StringBuilder)charSequence).append((String)object);
                        ((StringBuilder)charSequence).append((String)object2);
                        ((StringBuilder)charSequence).append(n10);
                        object = ((StringBuilder)charSequence).toString();
                        object2 = PurchaseResult.PURCHASE_FAIL_NOTIFY_ITEM_ALREADY_OWNED;
                        object = ValueException.createValue((String)object, object2);
                        ((GoogleBillingClientLifecycle)object3).R(null, false, false, (ValueException$b)object);
                    }
                } else {
                    object3 = new Object[]{};
                    m.a.a.e("onPurchasesUpdated: Developer error means that Google Play does not recognize the configuration. If you are just getting started, make sure you have configured the application correctly in the Google Play Console. The SKU product ID must match and the APK you are using must be signed with release keys.", (Object[])object3);
                    object3 = this.a;
                    charSequence = new StringBuilder();
                    String string5 = " \u8d2d\u4e70\u5931\u8d25,\u652f\u4ed8api\u9519\u8bef";
                    ((StringBuilder)charSequence).append(string5);
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append((String)object2);
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(n10);
                    object = ((StringBuilder)charSequence).toString();
                    object2 = PurchaseResult.PURCHASE_FAIL_NOTIFY_DEVELOPER_ERROR;
                    object = ValueException.createValue((String)object, object2);
                    ((GoogleBillingClientLifecycle)object3).R(null, false, false, (ValueException$b)object);
                }
            } else {
                object3 = new Object[]{};
                m.a.a.i("onPurchasesUpdated: User canceled the purchase", (Object[])object3);
                object3 = this.a;
                charSequence = new StringBuilder();
                String string6 = "\u7528\u6237\u4e3b\u52a8\u53d6\u6d88";
                ((StringBuilder)charSequence).append(string6);
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(n10);
                object = ((StringBuilder)charSequence).toString();
                object2 = PurchaseResult.PURCHASE_USER_CANCELED;
                object = ValueException.createValue((String)object, object2);
                ((GoogleBillingClientLifecycle)object3).R(null, false, false, (ValueException$b)object);
            }
        } else {
            if (object2 == null) {
                object = new Object[]{};
                string2 = "onPurchasesUpdated: null purchase list";
                m.a.a.b(string2, object);
            }
            object = this.a;
            GoogleBillingClientLifecycle.d((GoogleBillingClientLifecycle)object, (List)object2);
        }
    }

    public void f(h objectArray, List object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u7f51\u7edconPurchaseHistoryResponse, getResponseCode=");
        int n10 = objectArray.b();
        stringBuilder.append(n10);
        stringBuilder.append("list=");
        stringBuilder.append(object);
        objectArray = stringBuilder.toString();
        stringBuilder = null;
        Object[] objectArray2 = new Object[]{};
        m.a.a.b((String)objectArray, objectArray2);
        if (object != null) {
            objectArray = new Object[]{};
            object = "--------------\u5206\u5272\u7ebf---------------";
            m.a.a.b((String)object, objectArray);
        }
    }
}

