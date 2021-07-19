/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

public final class ParseException
extends RuntimeException {
    private static final String ELLIPSIS = "...";
    private static final int SNIPPET_LENGTH = 5;

    private ParseException(String string2, String string3) {
        super(string2);
    }

    public static ParseException atPosition(String string2, String string3, int n10) {
        int n11 = n10 + 1;
        string2 = ParseException.msg(string2, string3, n10, n11);
        ParseException parseException = new ParseException(string2, string3);
        return parseException;
    }

    public static ParseException generic(String string2, String string3) {
        ParseException parseException = new ParseException(string2, string3);
        return parseException;
    }

    private static String msg(String string2, String string3, int n10, int n11) {
        if (n11 < 0) {
            n11 = string3.length();
        }
        StringBuilder stringBuilder = new StringBuilder(string2);
        string2 = ": ";
        stringBuilder.append(string2);
        int n12 = 8;
        String string4 = ELLIPSIS;
        if (n10 > n12) {
            stringBuilder.append(string4);
            int c10 = n10 + -5;
            stringBuilder.append(string3, c10, n10);
        } else {
            boolean bl2 = false;
            stringBuilder.append(string3, 0, n10);
        }
        char c10 = '[';
        stringBuilder.append(c10);
        String string5 = string3.substring(n10, n11);
        stringBuilder.append(string5);
        stringBuilder.append(']');
        n10 = string3.length() - n11;
        if (n10 > n12) {
            n12 = n11 + 5;
            stringBuilder.append(string3, n11, n12);
            stringBuilder.append(string4);
        } else {
            n12 = string3.length();
            stringBuilder.append(string3, n11, n12);
        }
        return stringBuilder.toString();
    }

    public static ParseException withBounds(String string2, String string3, int n10, int n11) {
        string2 = ParseException.msg(string2, string3, n10, n11);
        ParseException parseException = new ParseException(string2, string3);
        return parseException;
    }

    public static ParseException withStartPosition(String string2, String string3, int n10) {
        string2 = ParseException.msg(string2, string3, n10, -1);
        ParseException parseException = new ParseException(string2, string3);
        return parseException;
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public Throwable fillInStackTrace() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return this;
    }
}

