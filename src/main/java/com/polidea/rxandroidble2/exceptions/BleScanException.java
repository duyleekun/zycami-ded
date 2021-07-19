/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.exceptions.BleException;
import java.util.Date;

public class BleScanException
extends BleException {
    public static final int BLUETOOTH_CANNOT_START = 0;
    public static final int BLUETOOTH_DISABLED = 1;
    public static final int BLUETOOTH_NOT_AVAILABLE = 2;
    public static final int LOCATION_PERMISSION_MISSING = 3;
    public static final int LOCATION_SERVICES_DISABLED = 4;
    public static final int SCAN_FAILED_ALREADY_STARTED = 5;
    public static final int SCAN_FAILED_APPLICATION_REGISTRATION_FAILED = 6;
    public static final int SCAN_FAILED_FEATURE_UNSUPPORTED = 8;
    public static final int SCAN_FAILED_INTERNAL_ERROR = 7;
    public static final int SCAN_FAILED_OUT_OF_HARDWARE_RESOURCES = 9;
    public static final int UNDOCUMENTED_SCAN_THROTTLE = 0x7FFFFFFE;
    public static final int UNKNOWN_ERROR_CODE = Integer.MAX_VALUE;
    private final int reason;
    private final Date retryDateSuggestion;

    public BleScanException(int n10) {
        String string2 = BleScanException.a(n10, null);
        super(string2);
        this.reason = n10;
        this.retryDateSuggestion = null;
    }

    public BleScanException(int n10, Throwable throwable) {
        String string2 = BleScanException.a(n10, null);
        super(string2, throwable);
        this.reason = n10;
        this.retryDateSuggestion = null;
    }

    public BleScanException(int n10, Date date) {
        String string2 = BleScanException.a(n10, date);
        super(string2);
        this.reason = n10;
        this.retryDateSuggestion = date;
    }

    private static String a(int n10, Date date) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = BleScanException.b(n10);
        stringBuilder.append(string2);
        stringBuilder.append(" (code ");
        stringBuilder.append(n10);
        stringBuilder.append(")");
        String string3 = BleScanException.c(date);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private static String b(int n10) {
        int n11 = 0x7FFFFFFE;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    return "Unknown error";
                }
                case 9: {
                    return "Scan failed because out of hardware resources";
                }
                case 8: {
                    return "Scan failed because feature unsupported";
                }
                case 7: {
                    return "Scan failed because of an internal error";
                }
                case 6: {
                    return "Scan failed because application registration failed";
                }
                case 5: {
                    return "Scan failed because it has already started";
                }
                case 4: {
                    return "Location Services disabled";
                }
                case 3: {
                    return "Location Permission missing";
                }
                case 2: {
                    return "Bluetooth not available";
                }
                case 1: {
                    return "Bluetooth disabled";
                }
                case 0: 
            }
            return "Bluetooth cannot start";
        }
        return "Undocumented scan throttle";
    }

    private static String c(Date date) {
        if (date == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", suggested retry date is ");
        stringBuilder.append(date);
        return stringBuilder.toString();
    }

    public int getReason() {
        return this.reason;
    }

    public Date getRetryDateSuggestion() {
        return this.retryDateSuggestion;
    }
}

