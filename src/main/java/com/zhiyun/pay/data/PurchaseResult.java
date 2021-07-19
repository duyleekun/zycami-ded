/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.pay.data;

public final class PurchaseResult
extends Enum {
    public static final /* enum */ PurchaseResult PURCHASE_FAIL;
    public static final /* enum */ PurchaseResult PURCHASE_FAIL_NOTIFY_DEVELOPER_ERROR;
    public static final /* enum */ PurchaseResult PURCHASE_FAIL_NOTIFY_ITEM_ALREADY_OWNED;
    public static final /* enum */ PurchaseResult PURCHASE_FAIL_NOTIFY_ITEM_NOT_OWNED;
    public static final /* enum */ PurchaseResult PURCHASE_FAIL_NOTIFY_PLATFORM_FAIL;
    public static final /* enum */ PurchaseResult PURCHASE_FAIL_SERVER_FAIL;
    public static final /* enum */ PurchaseResult PURCHASE_LOADING;
    public static final /* enum */ PurchaseResult PURCHASE_NOTIFY_PLATFORM_UNSPECIFIED_STATE;
    public static final /* enum */ PurchaseResult PURCHASE_OK;
    public static final /* enum */ PurchaseResult PURCHASE_RESULT_UNKNOWN;
    public static final /* enum */ PurchaseResult PURCHASE_USER_CANCELED;
    private static final /* synthetic */ PurchaseResult[] a;

    static {
        PurchaseResult purchaseResult;
        PurchaseResult purchaseResult2;
        PurchaseResult purchaseResult3;
        PurchaseResult purchaseResult4;
        PurchaseResult purchaseResult5;
        PurchaseResult purchaseResult6;
        PurchaseResult purchaseResult7;
        PurchaseResult purchaseResult8;
        PurchaseResult purchaseResult9;
        PurchaseResult purchaseResult10;
        PurchaseResult purchaseResult11;
        PURCHASE_LOADING = purchaseResult11 = new PurchaseResult("PURCHASE_LOADING", 0);
        int n10 = 1;
        PURCHASE_OK = purchaseResult10 = new PurchaseResult("PURCHASE_OK", n10);
        int n11 = 2;
        PURCHASE_FAIL = purchaseResult9 = new PurchaseResult("PURCHASE_FAIL", n11);
        PURCHASE_USER_CANCELED = purchaseResult8 = new PurchaseResult("PURCHASE_USER_CANCELED", 3);
        PURCHASE_NOTIFY_PLATFORM_UNSPECIFIED_STATE = purchaseResult7 = new PurchaseResult("PURCHASE_NOTIFY_PLATFORM_UNSPECIFIED_STATE", 4);
        PURCHASE_FAIL_NOTIFY_PLATFORM_FAIL = purchaseResult6 = new PurchaseResult("PURCHASE_FAIL_NOTIFY_PLATFORM_FAIL", 5);
        PURCHASE_FAIL_NOTIFY_DEVELOPER_ERROR = purchaseResult5 = new PurchaseResult("PURCHASE_FAIL_NOTIFY_DEVELOPER_ERROR", 6);
        PURCHASE_FAIL_NOTIFY_ITEM_ALREADY_OWNED = purchaseResult4 = new PurchaseResult("PURCHASE_FAIL_NOTIFY_ITEM_ALREADY_OWNED", 7);
        PURCHASE_FAIL_NOTIFY_ITEM_NOT_OWNED = purchaseResult3 = new PurchaseResult("PURCHASE_FAIL_NOTIFY_ITEM_NOT_OWNED", 8);
        PURCHASE_FAIL_SERVER_FAIL = purchaseResult2 = new PurchaseResult("PURCHASE_FAIL_SERVER_FAIL", 9);
        int n12 = 10;
        PURCHASE_RESULT_UNKNOWN = purchaseResult = new PurchaseResult("PURCHASE_RESULT_UNKNOWN", n12);
        PurchaseResult[] purchaseResultArray = new PurchaseResult[11];
        purchaseResultArray[0] = purchaseResult11;
        purchaseResultArray[n10] = purchaseResult10;
        purchaseResultArray[n11] = purchaseResult9;
        purchaseResultArray[3] = purchaseResult8;
        purchaseResultArray[4] = purchaseResult7;
        purchaseResultArray[5] = purchaseResult6;
        purchaseResultArray[6] = purchaseResult5;
        purchaseResultArray[7] = purchaseResult4;
        purchaseResultArray[8] = purchaseResult3;
        purchaseResultArray[9] = purchaseResult2;
        purchaseResultArray[n12] = purchaseResult;
        a = purchaseResultArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PurchaseResult() {
        void var2_-1;
        void var1_-1;
    }

    public static PurchaseResult valueOf(String string2) {
        return Enum.valueOf(PurchaseResult.class, string2);
    }

    public static PurchaseResult[] values() {
        return (PurchaseResult[])a.clone();
    }
}

