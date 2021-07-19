/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.heytap.mcssdk.f;

import android.util.Log;

public class c {
    public static final String a = "mcssdk---";
    private static String b = "MCS";
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = true;
    private static boolean g = true;
    private static String h = "-->";
    private static boolean i = true;

    public static String a() {
        return b;
    }

    public static void a(Exception object) {
        boolean bl2 = g;
        if (bl2) {
            if (object == null) {
                return;
            }
            object = ((Throwable)object).getMessage();
            String string2 = a;
            Log.e((String)string2, (String)object);
        }
    }

    public static void a(String string2) {
        boolean bl2 = c;
        if (bl2 && (bl2 = i)) {
            CharSequence charSequence = new StringBuilder();
            String string3 = b;
            charSequence.append(string3);
            string3 = h;
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = a;
            Log.v((String)charSequence, (String)string2);
        }
    }

    public static void a(String string2, String string3) {
        boolean bl2 = c;
        if (bl2 && (bl2 = i)) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = b;
            stringBuilder.append(string4);
            string4 = h;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.v((String)string2, (String)string3);
        }
    }

    public static void a(String string2, Throwable object) {
        boolean bl2 = g;
        if (bl2) {
            object = ((Throwable)object).toString();
            Log.e((String)string2, (String)object);
        }
    }

    public static void a(boolean bl2) {
        c = bl2;
    }

    public static void b(String string2) {
        boolean bl2 = e;
        if (bl2 && (bl2 = i)) {
            CharSequence charSequence = new StringBuilder();
            String string3 = b;
            charSequence.append(string3);
            string3 = h;
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = a;
            Log.d((String)charSequence, (String)string2);
        }
    }

    public static void b(String string2, String string3) {
        boolean bl2 = e;
        if (bl2 && (bl2 = i)) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = b;
            stringBuilder.append(string4);
            string4 = h;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.d((String)string2, (String)string3);
        }
    }

    public static void b(boolean bl2) {
        e = bl2;
    }

    public static boolean b() {
        return c;
    }

    public static void c(String string2) {
        boolean bl2 = d;
        if (bl2 && (bl2 = i)) {
            CharSequence charSequence = new StringBuilder();
            String string3 = b;
            charSequence.append(string3);
            string3 = h;
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = a;
            Log.i((String)charSequence, (String)string2);
        }
    }

    public static void c(String string2, String string3) {
        boolean bl2 = d;
        if (bl2 && (bl2 = i)) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = b;
            stringBuilder.append(string4);
            string4 = h;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.i((String)string2, (String)string3);
        }
    }

    public static void c(boolean bl2) {
        d = bl2;
    }

    public static boolean c() {
        return e;
    }

    public static void d(String string2) {
        boolean bl2 = f;
        if (bl2 && (bl2 = i)) {
            CharSequence charSequence = new StringBuilder();
            String string3 = b;
            charSequence.append(string3);
            string3 = h;
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = a;
            Log.w((String)charSequence, (String)string2);
        }
    }

    public static void d(String string2, String string3) {
        boolean bl2 = f;
        if (bl2 && (bl2 = i)) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = b;
            stringBuilder.append(string4);
            string4 = h;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.w((String)string2, (String)string3);
        }
    }

    public static void d(boolean bl2) {
        f = bl2;
    }

    public static boolean d() {
        return d;
    }

    public static void e(String string2) {
        boolean bl2 = g;
        if (bl2 && (bl2 = i)) {
            CharSequence charSequence = new StringBuilder();
            String string3 = b;
            charSequence.append(string3);
            string3 = h;
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = a;
            Log.e((String)charSequence, (String)string2);
        }
    }

    public static void e(String string2, String string3) {
        boolean bl2 = g;
        if (bl2 && (bl2 = i)) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = b;
            stringBuilder.append(string4);
            string4 = h;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.e((String)string2, (String)string3);
        }
    }

    public static void e(boolean bl2) {
        g = bl2;
    }

    public static boolean e() {
        return f;
    }

    public static void f(String string2) {
        b = string2;
    }

    public static void f(boolean bl2) {
        i = bl2;
        bl2 = bl2;
        c = bl2;
        e = bl2;
        d = bl2;
        f = bl2;
        g = bl2;
    }

    public static boolean f() {
        return g;
    }

    public static void g(String string2) {
        h = string2;
    }

    public static boolean g() {
        return i;
    }

    public static String h() {
        return h;
    }
}

