/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

public final class h {
    public static String a(int n10) {
        int n11 = 1000;
        if (n10 != n11) {
            n11 = 2000;
            if (n10 != n11) {
                n11 = 2100;
                if (n10 != n11) {
                    n11 = 2101;
                    if (n10 != n11) {
                        switch (n10) {
                            default: {
                                switch (n10) {
                                    default: {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("UNKNOWN - ");
                                        stringBuilder.append(n10);
                                        return stringBuilder.toString();
                                    }
                                    case 2204: {
                                        return "DOWNLOAD_NO_STORAGE";
                                    }
                                    case 2203: {
                                        return "DOWNLOAD_NO_SPACE";
                                    }
                                    case 2202: {
                                        return "DOWNLOAD_HASH_ERROR";
                                    }
                                    case 2201: 
                                }
                                return "DOWNLOAD_FAILURE";
                            }
                            case 1203: {
                                return "CHECK_NO_SUPPORTED";
                            }
                            case 1202: {
                                return "CHECK_NO_UPDATE";
                            }
                            case 1201: 
                        }
                        return "CHECK_FAILURE";
                    }
                    return "DOWNLOAD_CANCELED";
                }
                return "DOWNLOADING";
            }
            return "DOWNLOAD_SUCCESS";
        }
        return "CHECK_OK";
    }
}

