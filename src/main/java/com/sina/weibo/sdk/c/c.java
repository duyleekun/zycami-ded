/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.sina.weibo.sdk.c;

import android.util.Log;

public final class c {
    private static boolean an = false;

    public static void a(String string2, String string3) {
        boolean bl2 = an;
        if (bl2) {
            Object object = Thread.currentThread().getStackTrace();
            int n10 = 3;
            object = object[n10];
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = ((StackTraceElement)object).getFileName();
            stringBuilder.append(string4);
            stringBuilder.append("(");
            int n11 = ((StackTraceElement)object).getLineNumber();
            stringBuilder.append(n11);
            string4 = ") ";
            stringBuilder.append(string4);
            object = ((StackTraceElement)object).getMethodName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = ": ";
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.d((String)string2, (String)string3);
        }
    }

    public static void b(String string2, String string3) {
        boolean bl2 = an;
        if (bl2) {
            Object object = Thread.currentThread().getStackTrace();
            int n10 = 3;
            object = object[n10];
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = ((StackTraceElement)object).getFileName();
            stringBuilder.append(string4);
            stringBuilder.append("(");
            int n11 = ((StackTraceElement)object).getLineNumber();
            stringBuilder.append(n11);
            string4 = ") ";
            stringBuilder.append(string4);
            object = ((StackTraceElement)object).getMethodName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = ": ";
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.e((String)string2, (String)string3);
        }
    }

    public static void setLoggerEnable(boolean bl2) {
        an = bl2;
    }
}

