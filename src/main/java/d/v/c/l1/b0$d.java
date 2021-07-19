/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.pay.data.PurchaseResult;

public class b0$d {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PurchaseResult purchaseResult;
        int n12 = PurchaseResult.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            purchaseResult = PurchaseResult.PURCHASE_LOADING;
            n11 = purchaseResult.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            purchaseResult = PurchaseResult.PURCHASE_OK;
            n11 = purchaseResult.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

