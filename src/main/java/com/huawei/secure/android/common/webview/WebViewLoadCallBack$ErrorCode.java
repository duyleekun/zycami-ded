/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.secure.android.common.webview;

public final class WebViewLoadCallBack$ErrorCode
extends Enum {
    public static final /* enum */ WebViewLoadCallBack$ErrorCode HTTP_URL;
    public static final /* enum */ WebViewLoadCallBack$ErrorCode OTHER;
    public static final /* enum */ WebViewLoadCallBack$ErrorCode URL_NOT_IN_WHITE_LIST;
    private static final /* synthetic */ WebViewLoadCallBack$ErrorCode[] a;

    static {
        WebViewLoadCallBack$ErrorCode webViewLoadCallBack$ErrorCode;
        WebViewLoadCallBack$ErrorCode webViewLoadCallBack$ErrorCode2;
        WebViewLoadCallBack$ErrorCode webViewLoadCallBack$ErrorCode3;
        HTTP_URL = webViewLoadCallBack$ErrorCode3 = new WebViewLoadCallBack$ErrorCode("HTTP_URL", 0);
        int n10 = 1;
        URL_NOT_IN_WHITE_LIST = webViewLoadCallBack$ErrorCode2 = new WebViewLoadCallBack$ErrorCode("URL_NOT_IN_WHITE_LIST", n10);
        int n11 = 2;
        OTHER = webViewLoadCallBack$ErrorCode = new WebViewLoadCallBack$ErrorCode("OTHER", n11);
        WebViewLoadCallBack$ErrorCode[] webViewLoadCallBack$ErrorCodeArray = new WebViewLoadCallBack$ErrorCode[3];
        webViewLoadCallBack$ErrorCodeArray[0] = webViewLoadCallBack$ErrorCode3;
        webViewLoadCallBack$ErrorCodeArray[n10] = webViewLoadCallBack$ErrorCode2;
        webViewLoadCallBack$ErrorCodeArray[n11] = webViewLoadCallBack$ErrorCode;
        a = webViewLoadCallBack$ErrorCodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WebViewLoadCallBack$ErrorCode() {
        void var2_-1;
        void var1_-1;
    }

    public static WebViewLoadCallBack$ErrorCode valueOf(String string2) {
        return Enum.valueOf(WebViewLoadCallBack$ErrorCode.class, string2);
    }

    public static WebViewLoadCallBack$ErrorCode[] values() {
        return (WebViewLoadCallBack$ErrorCode[])a.clone();
    }
}

