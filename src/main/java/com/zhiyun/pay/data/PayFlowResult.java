/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.pay.data;

public final class PayFlowResult
extends Enum {
    public static final /* enum */ PayFlowResult PAY_FLOW_FAIL;
    public static final /* enum */ PayFlowResult PAY_FLOW_FAILT_QUERY_PAST_TRADE;
    public static final /* enum */ PayFlowResult PAY_FLOW_FAIL_CREATE_ORDER;
    public static final /* enum */ PayFlowResult PAY_FLOW_FAIL_GET_PARAM;
    public static final /* enum */ PayFlowResult PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT;
    public static final /* enum */ PayFlowResult PAY_FLOW_GOOGLE_NOT_SUPPORTED;
    public static final /* enum */ PayFlowResult PAY_FLOW_ITEM_BUY_REPEAT;
    public static final /* enum */ PayFlowResult PAY_FLOW_LOADING;
    public static final /* enum */ PayFlowResult PAY_FLOW_LOADING_ALI;
    public static final /* enum */ PayFlowResult PAY_FLOW_LOADING_GOOGLE;
    public static final /* enum */ PayFlowResult PAY_FLOW_LOADING_WX;
    public static final /* enum */ PayFlowResult PAY_FLOW_NOT_INSTALL_ALI;
    public static final /* enum */ PayFlowResult PAY_FLOW_NOT_INSTALL_WX;
    public static final /* enum */ PayFlowResult PAY_FLOW_OK;
    public static final /* enum */ PayFlowResult PAY_FLOW_ORDER_CREATE_TOO_FAST;
    public static final /* enum */ PayFlowResult PAY_FLOW_PLATFORM_ACCOUNT_SUBSCRIBING_FOR_OTHER_USER;
    public static final /* enum */ PayFlowResult PAY_FLOW_PRIME_TIME_LIMIT;
    public static final /* enum */ PayFlowResult PAY_FLOW_PRODUCT_INFO_ERROR;
    public static final /* enum */ PayFlowResult PAY_FLOW_PRODUCT_PLATFORM_COMPLETE;
    public static final /* enum */ PayFlowResult PAY_FLOW_PRODUCT_PLATFORM_START;
    public static final /* enum */ PayFlowResult PAY_FLOW_SUB_STATE_QUERY_FAIL;
    public static final /* enum */ PayFlowResult PAY_FLOW_USER_SUBSCRIBING;
    public static final /* enum */ PayFlowResult PAY_FLOW_USER_SUBSCRIBING_ON_OTHER_PLATFORM;
    public static final /* enum */ PayFlowResult PAY_FLOW_WX_VERSION_LOW;
    public static final /* enum */ PayFlowResult SERVICE_UNAVAILABLE;
    public static final /* enum */ PayFlowResult USER_NOT_LOGIN;
    private static final /* synthetic */ PayFlowResult[] a;

    static {
        PayFlowResult payFlowResult;
        PayFlowResult payFlowResult2;
        PayFlowResult payFlowResult3;
        PayFlowResult payFlowResult4;
        PayFlowResult payFlowResult5;
        PayFlowResult payFlowResult6;
        PayFlowResult payFlowResult7;
        PayFlowResult payFlowResult8;
        PayFlowResult payFlowResult9;
        PayFlowResult payFlowResult10;
        PayFlowResult payFlowResult11;
        PayFlowResult payFlowResult12;
        PayFlowResult payFlowResult13;
        PayFlowResult payFlowResult14;
        PayFlowResult payFlowResult15;
        USER_NOT_LOGIN = payFlowResult15 = new PayFlowResult("USER_NOT_LOGIN", 0);
        SERVICE_UNAVAILABLE = payFlowResult14 = new PayFlowResult("SERVICE_UNAVAILABLE", 1);
        PAY_FLOW_PRODUCT_PLATFORM_START = payFlowResult13 = new PayFlowResult("PAY_FLOW_PRODUCT_PLATFORM_START", 2);
        PAY_FLOW_PRODUCT_PLATFORM_COMPLETE = payFlowResult12 = new PayFlowResult("PAY_FLOW_PRODUCT_PLATFORM_COMPLETE", 3);
        PAY_FLOW_LOADING = payFlowResult11 = new PayFlowResult("PAY_FLOW_LOADING", 4);
        PAY_FLOW_LOADING_GOOGLE = payFlowResult10 = new PayFlowResult("PAY_FLOW_LOADING_GOOGLE", 5);
        PAY_FLOW_LOADING_WX = payFlowResult9 = new PayFlowResult("PAY_FLOW_LOADING_WX", 6);
        PAY_FLOW_LOADING_ALI = payFlowResult8 = new PayFlowResult("PAY_FLOW_LOADING_ALI", 7);
        PAY_FLOW_SUB_STATE_QUERY_FAIL = payFlowResult7 = new PayFlowResult("PAY_FLOW_SUB_STATE_QUERY_FAIL", 8);
        PAY_FLOW_OK = payFlowResult6 = new PayFlowResult("PAY_FLOW_OK", 9);
        PAY_FLOW_FAIL = payFlowResult5 = new PayFlowResult("PAY_FLOW_FAIL", 10);
        PAY_FLOW_PRODUCT_INFO_ERROR = payFlowResult4 = new PayFlowResult("PAY_FLOW_PRODUCT_INFO_ERROR", 11);
        PAY_FLOW_ORDER_CREATE_TOO_FAST = payFlowResult3 = new PayFlowResult("PAY_FLOW_ORDER_CREATE_TOO_FAST", 12);
        PAY_FLOW_USER_SUBSCRIBING = payFlowResult2 = new PayFlowResult("PAY_FLOW_USER_SUBSCRIBING", 13);
        PayFlowResult payFlowResult16 = payFlowResult2;
        PayFlowResult[] payFlowResultArray = new PayFlowResult("PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT", 14);
        PAY_FLOW_FAIL_QUERY_PLATFORM_PRODUCT = payFlowResultArray;
        PayFlowResult[] payFlowResultArray2 = payFlowResultArray;
        PAY_FLOW_ITEM_BUY_REPEAT = payFlowResult = new PayFlowResult("PAY_FLOW_ITEM_BUY_REPEAT", 15);
        PayFlowResult payFlowResult17 = payFlowResult;
        PAY_FLOW_FAILT_QUERY_PAST_TRADE = payFlowResult2 = new PayFlowResult("PAY_FLOW_FAILT_QUERY_PAST_TRADE", 16);
        PayFlowResult payFlowResult18 = payFlowResult2;
        payFlowResultArray = new PayFlowResult("PAY_FLOW_PRIME_TIME_LIMIT", 17);
        PAY_FLOW_PRIME_TIME_LIMIT = payFlowResultArray;
        PayFlowResult[] payFlowResultArray3 = payFlowResultArray;
        PAY_FLOW_PLATFORM_ACCOUNT_SUBSCRIBING_FOR_OTHER_USER = payFlowResult = new PayFlowResult("PAY_FLOW_PLATFORM_ACCOUNT_SUBSCRIBING_FOR_OTHER_USER", 18);
        PayFlowResult payFlowResult19 = payFlowResult;
        PAY_FLOW_USER_SUBSCRIBING_ON_OTHER_PLATFORM = payFlowResult2 = new PayFlowResult("PAY_FLOW_USER_SUBSCRIBING_ON_OTHER_PLATFORM", 19);
        PayFlowResult payFlowResult20 = payFlowResult2;
        payFlowResultArray = new PayFlowResult("PAY_FLOW_FAIL_CREATE_ORDER", 20);
        PAY_FLOW_FAIL_CREATE_ORDER = payFlowResultArray;
        PayFlowResult[] payFlowResultArray4 = payFlowResultArray;
        PAY_FLOW_FAIL_GET_PARAM = payFlowResult = new PayFlowResult("PAY_FLOW_FAIL_GET_PARAM", 21);
        PayFlowResult payFlowResult21 = payFlowResult;
        PAY_FLOW_GOOGLE_NOT_SUPPORTED = payFlowResult2 = new PayFlowResult("PAY_FLOW_GOOGLE_NOT_SUPPORTED", 22);
        PAY_FLOW_NOT_INSTALL_WX = payFlowResult = new PayFlowResult("PAY_FLOW_NOT_INSTALL_WX", 23);
        PayFlowResult payFlowResult22 = payFlowResult;
        payFlowResultArray = new PayFlowResult("PAY_FLOW_WX_VERSION_LOW", 24);
        PAY_FLOW_WX_VERSION_LOW = payFlowResultArray;
        PayFlowResult[] payFlowResultArray5 = payFlowResultArray;
        PAY_FLOW_NOT_INSTALL_ALI = payFlowResult = new PayFlowResult("PAY_FLOW_NOT_INSTALL_ALI", 25);
        payFlowResultArray = new PayFlowResult[]{payFlowResult15, payFlowResult14, payFlowResult13, payFlowResult12, payFlowResult11, payFlowResult10, payFlowResult9, payFlowResult8, payFlowResult7, payFlowResult6, payFlowResult5, payFlowResult4, payFlowResult3, payFlowResult16, payFlowResultArray2, payFlowResult17, payFlowResult18, payFlowResultArray3, payFlowResult19, payFlowResult20, payFlowResultArray4, payFlowResult21, payFlowResult2, payFlowResult22, payFlowResultArray5, payFlowResult};
        a = payFlowResultArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PayFlowResult() {
        void var2_-1;
        void var1_-1;
    }

    public static PayFlowResult valueOf(String string2) {
        return Enum.valueOf(PayFlowResult.class, string2);
    }

    public static PayFlowResult[] values() {
        return (PayFlowResult[])a.clone();
    }
}

