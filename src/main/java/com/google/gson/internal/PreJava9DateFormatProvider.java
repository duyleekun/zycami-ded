/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 == n11) {
                        return "M/d/yy";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown DateFormat style: ");
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                    throw illegalArgumentException;
                }
                return "MMM d, y";
            }
            return "MMMM d, y";
        }
        return "EEEE, MMMM d, y";
    }

    private static String getDatePartOfDateTimePattern(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 == n11) {
                        return "M/d/yy";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown DateFormat style: ");
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                    throw illegalArgumentException;
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }

    private static String getTimePartOfDateTimePattern(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11) {
                    return "h:mm a";
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown DateFormat style: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            return "h:mm:ss a";
        }
        return "h:mm:ss a z";
    }

    public static DateFormat getUSDateFormat(int n10) {
        String string2 = PreJava9DateFormatProvider.getDateFormatPattern(n10);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string2, locale);
        return simpleDateFormat;
    }

    public static DateFormat getUSDateTimeFormat(int n10, int n11) {
        Serializable serializable = new StringBuilder();
        String string2 = PreJava9DateFormatProvider.getDatePartOfDateTimePattern(n10);
        serializable.append(string2);
        serializable.append(" ");
        string2 = PreJava9DateFormatProvider.getTimePartOfDateTimePattern(n11);
        serializable.append(string2);
        string2 = serializable.toString();
        serializable = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string2, (Locale)serializable);
        return simpleDateFormat;
    }
}

