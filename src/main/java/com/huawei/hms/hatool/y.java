/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.z;

public class y {
    public static z a;

    static {
        z z10;
        a = z10 = new z();
    }

    public static void a(int n10) {
        a.a(n10);
    }

    public static void a(String string2, String string3) {
        boolean bl2 = y.a();
        if (bl2 && string2 != null && string3 != null) {
            z z10 = a;
            int n10 = 3;
            z10.b(n10, string2, string3);
        }
    }

    public static void a(String string2, String string3, Object ... object) {
        int n10 = y.c();
        if (n10 != 0 && string2 != null && string3 != null) {
            string3 = String.format(string3, (Object[])object);
            object = a;
            n10 = 4;
            ((z)object).b(n10, string2, string3);
        }
    }

    public static boolean a() {
        return a.b(3);
    }

    public static void b(String string2, String string3) {
        boolean bl2 = y.b();
        if (bl2 && string2 != null && string3 != null) {
            z z10 = a;
            int n10 = 6;
            z10.b(n10, string2, string3);
        }
    }

    public static void b(String string2, String string3, Object ... objectArray) {
        string3 = String.format(string3, objectArray);
        y.d(string2, string3);
    }

    public static boolean b() {
        return a.b(6);
    }

    public static void c(String string2, String string3) {
        boolean bl2 = y.c();
        if (bl2 && string2 != null && string3 != null) {
            z z10 = a;
            int n10 = 4;
            z10.b(n10, string2, string3);
        }
    }

    public static boolean c() {
        return a.b(4);
    }

    public static void d(String string2, String string3) {
        if (string2 != null && string3 != null) {
            z z10 = a;
            int n10 = 4;
            z10.b(n10, string2, string3);
        }
    }

    public static boolean d() {
        return a.b(5);
    }

    public static void e(String string2, String string3) {
        if (string2 != null && string3 != null) {
            z z10 = a;
            int n10 = 5;
            z10.b(n10, string2, string3);
        }
    }

    public static void f(String string2, String string3) {
        boolean bl2 = y.d();
        if (bl2 && string2 != null && string3 != null) {
            z z10 = a;
            int n10 = 5;
            z10.b(n10, string2, string3);
        }
    }
}

