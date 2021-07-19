/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

public class CommonStatusCodes {
    public static final int API_NOT_CONNECTED = 17;
    public static final int CANCELED = 16;
    public static final int CONNECTION_SUSPENDED_DURING_CALL = 20;
    public static final int DEVELOPER_ERROR = 10;
    public static final int ERROR = 13;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_ACCOUNT = 5;
    public static final int NETWORK_ERROR = 7;
    public static final int REMOTE_EXCEPTION = 19;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_CACHE = 255;
    public static final int TIMEOUT = 15;

    public static String getStatusCodeString(int n10) {
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder(32);
                stringBuilder.append("unknown status code: ");
                stringBuilder.append(n10);
                return stringBuilder.toString();
            }
            case 20: {
                return "CONNECTION_SUSPENDED_DURING_CALL";
            }
            case 19: {
                return "REMOTE_EXCEPTION";
            }
            case 18: {
                return "DEAD_CLIENT";
            }
            case 17: {
                return "API_NOT_CONNECTED";
            }
            case 16: {
                return "CANCELED";
            }
            case 15: {
                return "TIMEOUT";
            }
            case 14: {
                return "INTERRUPTED";
            }
            case 13: {
                return "ERROR";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 0: {
                return "SUCCESS";
            }
            case -1: 
        }
        return "SUCCESS_CACHE";
    }
}

