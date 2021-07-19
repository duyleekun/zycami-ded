/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common;

public final class HttpMethod
extends Enum {
    private static final /* synthetic */ HttpMethod[] $VALUES;
    public static final /* enum */ HttpMethod DELETE;
    public static final /* enum */ HttpMethod GET;
    public static final /* enum */ HttpMethod HEAD;
    public static final /* enum */ HttpMethod OPTIONS;
    public static final /* enum */ HttpMethod POST;
    public static final /* enum */ HttpMethod PUT;

    static {
        HttpMethod httpMethod;
        HttpMethod httpMethod2;
        HttpMethod httpMethod3;
        HttpMethod httpMethod4;
        HttpMethod httpMethod5;
        HttpMethod httpMethod6;
        DELETE = httpMethod6 = new HttpMethod("DELETE", 0);
        int n10 = 1;
        GET = httpMethod5 = new HttpMethod("GET", n10);
        int n11 = 2;
        HEAD = httpMethod4 = new HttpMethod("HEAD", n11);
        int n12 = 3;
        POST = httpMethod3 = new HttpMethod("POST", n12);
        int n13 = 4;
        PUT = httpMethod2 = new HttpMethod("PUT", n13);
        int n14 = 5;
        OPTIONS = httpMethod = new HttpMethod("OPTIONS", n14);
        HttpMethod[] httpMethodArray = new HttpMethod[6];
        httpMethodArray[0] = httpMethod6;
        httpMethodArray[n10] = httpMethod5;
        httpMethodArray[n11] = httpMethod4;
        httpMethodArray[n12] = httpMethod3;
        httpMethodArray[n13] = httpMethod2;
        httpMethodArray[n14] = httpMethod;
        $VALUES = httpMethodArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HttpMethod() {
        void var2_-1;
        void var1_-1;
    }

    public static HttpMethod valueOf(String string2) {
        return Enum.valueOf(HttpMethod.class, string2);
    }

    public static HttpMethod[] values() {
        return (HttpMethod[])$VALUES.clone();
    }
}

