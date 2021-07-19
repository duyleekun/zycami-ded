/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.web;

import com.zhiyun.pay.data.PayFlowResult;
import com.zhiyun.pay.data.PurchaseResult;

public class PrimeWebFragment$c {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object2;
        int n13;
        Object object3;
        int n14;
        Object object4;
        int n15;
        Object object5;
        int n16;
        Object object6;
        int n17;
        Object object7;
        int n18;
        Object object8;
        int n19;
        Object object9;
        int n20;
        Object object10;
        int n21 = PayFlowResult.values().length;
        int[] nArray = new int[n21];
        b = nArray;
        int n22 = 1;
        try {
            object10 = PayFlowResult.PAY_FLOW_SUB_STATE_QUERY_FAIL;
            n20 = object10.ordinal();
            nArray[n20] = n22;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n21 = 2;
        try {
            object10 = b;
            object9 = PayFlowResult.PAY_FLOW_NOT_INSTALL_WX;
            n19 = object9.ordinal();
            object10[n19] = (PayFlowResult)n21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n20 = 3;
        try {
            object9 = b;
            object8 = PayFlowResult.PAY_FLOW_WX_VERSION_LOW;
            n18 = object8.ordinal();
            object9[n18] = (PayFlowResult)n20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n19 = 4;
        try {
            object8 = b;
            object7 = PayFlowResult.PAY_FLOW_NOT_INSTALL_ALI;
            n17 = object7.ordinal();
            object8[n17] = (PayFlowResult)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n18 = 5;
        try {
            object7 = b;
            object6 = PayFlowResult.PAY_FLOW_PRODUCT_INFO_ERROR;
            n16 = object6.ordinal();
            object7[n16] = (PayFlowResult)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n17 = 6;
        try {
            object6 = b;
            object5 = PayFlowResult.PAY_FLOW_ORDER_CREATE_TOO_FAST;
            n15 = object5.ordinal();
            object6[n15] = (PayFlowResult)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n16 = 7;
        try {
            object5 = b;
            object4 = PayFlowResult.PAY_FLOW_USER_SUBSCRIBING;
            n14 = object4.ordinal();
            object5[n14] = (PayFlowResult)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n15 = 8;
        try {
            object4 = b;
            object3 = PayFlowResult.PAY_FLOW_PRIME_TIME_LIMIT;
            n13 = object3.ordinal();
            object4[n13] = (PayFlowResult)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 9;
        try {
            object3 = b;
            object2 = PayFlowResult.PAY_FLOW_OK;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (PayFlowResult)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 10;
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_GOOGLE_NOT_SUPPORTED;
            n11 = enum_.ordinal();
            object2[n11] = (PayFlowResult)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.USER_NOT_LOGIN;
            n11 = enum_.ordinal();
            n10 = 11;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_PLATFORM_ACCOUNT_SUBSCRIBING_FOR_OTHER_USER;
            n11 = enum_.ordinal();
            n10 = 12;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_USER_SUBSCRIBING_ON_OTHER_PLATFORM;
            n11 = enum_.ordinal();
            n10 = 13;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAIL_CREATE_ORDER;
            n11 = enum_.ordinal();
            n10 = 14;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAIL_GET_PARAM;
            n11 = enum_.ordinal();
            n10 = 15;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT;
            n11 = enum_.ordinal();
            n10 = 16;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_ITEM_BUY_REPEAT;
            n11 = enum_.ordinal();
            n10 = 17;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAILT_QUERY_PAST_TRADE;
            n11 = enum_.ordinal();
            n10 = 18;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAIL;
            n11 = enum_.ordinal();
            n10 = 19;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.SERVICE_UNAVAILABLE;
            n11 = enum_.ordinal();
            n10 = 20;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_START;
            n11 = enum_.ordinal();
            n10 = 21;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_COMPLETE;
            n11 = enum_.ordinal();
            n10 = 22;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_LOADING_GOOGLE;
            n11 = enum_.ordinal();
            n10 = 23;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_LOADING_WX;
            n11 = enum_.ordinal();
            n10 = 24;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_LOADING_ALI;
            n11 = enum_.ordinal();
            n10 = 25;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = PurchaseResult.values().length;
        object2 = new int[n12];
        a = (int[])object2;
        try {
            enum_ = PurchaseResult.PURCHASE_USER_CANCELED;
            n11 = enum_.ordinal();
            object2[n11] = (PayFlowResult)n22;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = PurchaseResult.PURCHASE_OK;
            n12 = ((Enum)object2).ordinal();
            object[n12] = n21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)PurchaseResult.PURCHASE_RESULT_UNKNOWN;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PurchaseResult.PURCHASE_FAIL_SERVER_FAIL;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PurchaseResult.PURCHASE_FAIL;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PurchaseResult.PURCHASE_FAIL_NOTIFY_PLATFORM_FAIL;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PurchaseResult.PURCHASE_NOTIFY_PLATFORM_UNSPECIFIED_STATE;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PurchaseResult.PURCHASE_FAIL_NOTIFY_DEVELOPER_ERROR;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PurchaseResult.PURCHASE_FAIL_NOTIFY_ITEM_ALREADY_OWNED;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PurchaseResult.PURCHASE_FAIL_NOTIFY_ITEM_NOT_OWNED;
            n22 = ((Enum)object).ordinal();
            nArray[n22] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

