/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric$NetworkClientErrorReason$1;
import com.google.firebase.perf.v1.NetworkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkRequestMetric$NetworkClientErrorReason
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ NetworkRequestMetric$NetworkClientErrorReason[] $VALUES;
    public static final /* enum */ NetworkRequestMetric$NetworkClientErrorReason GENERIC_CLIENT_ERROR;
    public static final int GENERIC_CLIENT_ERROR_VALUE = 1;
    public static final /* enum */ NetworkRequestMetric$NetworkClientErrorReason NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
    public static final int NETWORK_CLIENT_ERROR_REASON_UNKNOWN_VALUE;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        NetworkRequestMetric$NetworkClientErrorReason networkRequestMetric$NetworkClientErrorReason;
        Object object = new NetworkRequestMetric$NetworkClientErrorReason("NETWORK_CLIENT_ERROR_REASON_UNKNOWN", 0, 0);
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN = object;
        int n10 = 1;
        GENERIC_CLIENT_ERROR = networkRequestMetric$NetworkClientErrorReason = new NetworkRequestMetric$NetworkClientErrorReason("GENERIC_CLIENT_ERROR", n10, n10);
        NetworkRequestMetric$NetworkClientErrorReason[] networkRequestMetric$NetworkClientErrorReasonArray = new NetworkRequestMetric$NetworkClientErrorReason[2];
        networkRequestMetric$NetworkClientErrorReasonArray[0] = object;
        networkRequestMetric$NetworkClientErrorReasonArray[n10] = networkRequestMetric$NetworkClientErrorReason;
        $VALUES = networkRequestMetric$NetworkClientErrorReasonArray;
        internalValueMap = object = new NetworkRequestMetric$NetworkClientErrorReason$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NetworkRequestMetric$NetworkClientErrorReason() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static NetworkRequestMetric$NetworkClientErrorReason forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return null;
            }
            return GENERIC_CLIENT_ERROR;
        }
        return NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return NetworkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier.INSTANCE;
    }

    public static NetworkRequestMetric$NetworkClientErrorReason valueOf(int n10) {
        return NetworkRequestMetric$NetworkClientErrorReason.forNumber(n10);
    }

    public static NetworkRequestMetric$NetworkClientErrorReason valueOf(String string2) {
        return Enum.valueOf(NetworkRequestMetric$NetworkClientErrorReason.class, string2);
    }

    public static NetworkRequestMetric$NetworkClientErrorReason[] values() {
        return (NetworkRequestMetric$NetworkClientErrorReason[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

