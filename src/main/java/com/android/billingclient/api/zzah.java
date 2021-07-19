/*
 * Decompiled with CFR 0.151.
 */
package com.android.billingclient.api;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.SkuDetails;
import d.b.a.b.c;
import d.b.a.b.f;
import d.b.a.b.h;
import d.b.a.b.j;
import d.b.a.b.k;
import d.b.a.b.m;
import d.b.a.b.n;
import d.b.a.b.p;
import java.util.Collections;
import java.util.List;

public final class zzah
implements c,
f,
j,
k,
m,
n,
p {
    private final long a;

    public zzah() {
        this.a = 0L;
    }

    public zzah(long l10) {
        this.a = l10;
    }

    public static native void nativeOnAcknowledgePurchaseResponse(int var0, String var1, long var2);

    public static native void nativeOnBillingServiceDisconnected();

    public static native void nativeOnBillingSetupFinished(int var0, String var1, long var2);

    public static native void nativeOnConsumePurchaseResponse(int var0, String var1, String var2, long var3);

    public static native void nativeOnPriceChangeConfirmationResult(int var0, String var1, long var2);

    public static native void nativeOnPurchaseHistoryResponse(int var0, String var1, PurchaseHistoryRecord[] var2, long var3);

    public static native void nativeOnPurchasesUpdated(int var0, String var1, Purchase[] var2);

    public static native void nativeOnQueryPurchasesResponse(int var0, String var1, Purchase[] var2, long var3);

    public static native void nativeOnSkuDetailsResponse(int var0, String var1, SkuDetails[] var2, long var3);

    public final void a(h object) {
        int n10 = ((h)object).b();
        object = ((h)object).a();
        long l10 = this.a;
        zzah.nativeOnBillingSetupFinished(n10, (String)object, l10);
    }

    public final void b() {
        zzah.nativeOnBillingServiceDisconnected();
    }

    public final void c(h object, List skuDetailsArray) {
        if (skuDetailsArray == null) {
            skuDetailsArray = Collections.emptyList();
        }
        SkuDetails[] skuDetailsArray2 = new SkuDetails[skuDetailsArray.size()];
        skuDetailsArray = skuDetailsArray.toArray(skuDetailsArray2);
        int n10 = ((h)object).b();
        object = ((h)object).a();
        long l10 = this.a;
        zzah.nativeOnSkuDetailsResponse(n10, (String)object, skuDetailsArray, l10);
    }

    public final void d(h object, List purchaseArray) {
        if (purchaseArray == null) {
            purchaseArray = Collections.emptyList();
        }
        Purchase[] purchaseArray2 = new Purchase[purchaseArray.size()];
        purchaseArray = purchaseArray.toArray(purchaseArray2);
        int n10 = ((h)object).b();
        object = ((h)object).a();
        zzah.nativeOnPurchasesUpdated(n10, (String)object, purchaseArray);
    }

    public final void e(h object) {
        int n10 = ((h)object).b();
        object = ((h)object).a();
        long l10 = this.a;
        zzah.nativeOnAcknowledgePurchaseResponse(n10, (String)object, l10);
    }

    public final void f(h object, List purchaseHistoryRecordArray) {
        if (purchaseHistoryRecordArray == null) {
            purchaseHistoryRecordArray = Collections.emptyList();
        }
        PurchaseHistoryRecord[] purchaseHistoryRecordArray2 = new PurchaseHistoryRecord[purchaseHistoryRecordArray.size()];
        purchaseHistoryRecordArray = purchaseHistoryRecordArray.toArray(purchaseHistoryRecordArray2);
        int n10 = ((h)object).b();
        object = ((h)object).a();
        long l10 = this.a;
        zzah.nativeOnPurchaseHistoryResponse(n10, (String)object, purchaseHistoryRecordArray, l10);
    }

    public final void g(h object) {
        int n10 = ((h)object).b();
        object = ((h)object).a();
        long l10 = this.a;
        zzah.nativeOnPriceChangeConfirmationResult(n10, (String)object, l10);
    }

    public final void h(h object, String string2) {
        int n10 = ((h)object).b();
        object = ((h)object).a();
        long l10 = this.a;
        zzah.nativeOnConsumePurchaseResponse(n10, (String)object, string2, l10);
    }
}

