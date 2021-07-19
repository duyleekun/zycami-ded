/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod$1;
import com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod$HttpMethodVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkRequestMetric$HttpMethod
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ NetworkRequestMetric$HttpMethod[] $VALUES;
    public static final /* enum */ NetworkRequestMetric$HttpMethod CONNECT;
    public static final int CONNECT_VALUE = 9;
    public static final /* enum */ NetworkRequestMetric$HttpMethod DELETE;
    public static final int DELETE_VALUE = 4;
    public static final /* enum */ NetworkRequestMetric$HttpMethod GET;
    public static final int GET_VALUE = 1;
    public static final /* enum */ NetworkRequestMetric$HttpMethod HEAD;
    public static final int HEAD_VALUE = 5;
    public static final /* enum */ NetworkRequestMetric$HttpMethod HTTP_METHOD_UNKNOWN;
    public static final int HTTP_METHOD_UNKNOWN_VALUE = 0;
    public static final /* enum */ NetworkRequestMetric$HttpMethod OPTIONS;
    public static final int OPTIONS_VALUE = 7;
    public static final /* enum */ NetworkRequestMetric$HttpMethod PATCH;
    public static final int PATCH_VALUE = 6;
    public static final /* enum */ NetworkRequestMetric$HttpMethod POST;
    public static final int POST_VALUE = 3;
    public static final /* enum */ NetworkRequestMetric$HttpMethod PUT;
    public static final int PUT_VALUE = 2;
    public static final /* enum */ NetworkRequestMetric$HttpMethod TRACE;
    public static final int TRACE_VALUE = 8;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod2;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod3;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod4;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod5;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod6;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod7;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod8;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod9;
        Object object = new NetworkRequestMetric$HttpMethod("HTTP_METHOD_UNKNOWN", 0, 0);
        HTTP_METHOD_UNKNOWN = object;
        int n10 = 1;
        GET = networkRequestMetric$HttpMethod9 = new NetworkRequestMetric$HttpMethod("GET", n10, n10);
        int n11 = 2;
        PUT = networkRequestMetric$HttpMethod8 = new NetworkRequestMetric$HttpMethod("PUT", n11, n11);
        int n12 = 3;
        POST = networkRequestMetric$HttpMethod7 = new NetworkRequestMetric$HttpMethod("POST", n12, n12);
        int n13 = 4;
        DELETE = networkRequestMetric$HttpMethod6 = new NetworkRequestMetric$HttpMethod("DELETE", n13, n13);
        int n14 = 5;
        HEAD = networkRequestMetric$HttpMethod5 = new NetworkRequestMetric$HttpMethod("HEAD", n14, n14);
        int n15 = 6;
        PATCH = networkRequestMetric$HttpMethod4 = new NetworkRequestMetric$HttpMethod("PATCH", n15, n15);
        n15 = 7;
        OPTIONS = networkRequestMetric$HttpMethod3 = new NetworkRequestMetric$HttpMethod("OPTIONS", n15, n15);
        n14 = 8;
        TRACE = networkRequestMetric$HttpMethod2 = new NetworkRequestMetric$HttpMethod("TRACE", n14, n14);
        n13 = 9;
        CONNECT = networkRequestMetric$HttpMethod = new NetworkRequestMetric$HttpMethod("CONNECT", n13, n13);
        NetworkRequestMetric$HttpMethod[] networkRequestMetric$HttpMethodArray = new NetworkRequestMetric$HttpMethod[10];
        networkRequestMetric$HttpMethodArray[0] = object;
        networkRequestMetric$HttpMethodArray[n10] = networkRequestMetric$HttpMethod9;
        networkRequestMetric$HttpMethodArray[n11] = networkRequestMetric$HttpMethod8;
        networkRequestMetric$HttpMethodArray[n12] = networkRequestMetric$HttpMethod7;
        networkRequestMetric$HttpMethodArray[4] = networkRequestMetric$HttpMethod6;
        networkRequestMetric$HttpMethodArray[5] = networkRequestMetric$HttpMethod5;
        networkRequestMetric$HttpMethodArray[6] = networkRequestMetric$HttpMethod4;
        networkRequestMetric$HttpMethodArray[7] = networkRequestMetric$HttpMethod3;
        networkRequestMetric$HttpMethodArray[8] = networkRequestMetric$HttpMethod2;
        networkRequestMetric$HttpMethodArray[n13] = networkRequestMetric$HttpMethod;
        $VALUES = networkRequestMetric$HttpMethodArray;
        internalValueMap = object = new NetworkRequestMetric$HttpMethod$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NetworkRequestMetric$HttpMethod() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static NetworkRequestMetric$HttpMethod forNumber(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 9: {
                return CONNECT;
            }
            case 8: {
                return TRACE;
            }
            case 7: {
                return OPTIONS;
            }
            case 6: {
                return PATCH;
            }
            case 5: {
                return HEAD;
            }
            case 4: {
                return DELETE;
            }
            case 3: {
                return POST;
            }
            case 2: {
                return PUT;
            }
            case 1: {
                return GET;
            }
            case 0: 
        }
        return HTTP_METHOD_UNKNOWN;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return NetworkRequestMetric$HttpMethod$HttpMethodVerifier.INSTANCE;
    }

    public static NetworkRequestMetric$HttpMethod valueOf(int n10) {
        return NetworkRequestMetric$HttpMethod.forNumber(n10);
    }

    public static NetworkRequestMetric$HttpMethod valueOf(String string2) {
        return Enum.valueOf(NetworkRequestMetric$HttpMethod.class, string2);
    }

    public static NetworkRequestMetric$HttpMethod[] values() {
        return (NetworkRequestMetric$HttpMethod[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

