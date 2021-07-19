/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.baidu.lbsapi.auth;

import android.util.Log;
import java.io.Serializable;

public class a {
    public static boolean a = false;
    private static String b = "BaiduApiAuth";

    public static String a() {
        Serializable serializable = new Throwable();
        serializable = ((Throwable)serializable).getStackTrace()[2];
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = ((StackTraceElement)serializable).getFileName();
        stringBuilder.append(string2);
        stringBuilder.append("[");
        int n10 = ((StackTraceElement)serializable).getLineNumber();
        stringBuilder.append(n10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void a(String string2) {
        int n10 = a;
        if (n10 != 0) {
            Object object = Thread.currentThread().getStackTrace();
            n10 = ((StackTraceElement[])object).length;
            if (n10 == 0) {
                return;
            }
            object = b;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = com.baidu.lbsapi.auth.a.a();
            stringBuilder.append(string3);
            string3 = ";";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Log.d((String)object, (String)string2);
        }
    }

    public static void b(String string2) {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        int n10 = stackTraceElementArray.length;
        if (n10 == 0) {
            return;
        }
        Log.i((String)b, (String)string2);
    }

    public static void c(String string2) {
        int n10 = a;
        if (n10 != 0) {
            Object object = Thread.currentThread().getStackTrace();
            n10 = ((StackTraceElement[])object).length;
            if (n10 == 0) {
                return;
            }
            object = b;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = com.baidu.lbsapi.auth.a.a();
            stringBuilder.append(string3);
            string3 = ";";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Log.e((String)object, (String)string2);
        }
    }
}

