/*
 * Decompiled with CFR 0.151.
 */
package d.v.h.l;

import m.a.a;

public class b {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static int f;

    public static void a(String string2, String string3) {
        int n10 = f;
        if (n10 <= 0) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string3;
            m.a.a.b(string2, objectArray);
        }
    }

    public static void b(String string2, String string3) {
        int n10 = f;
        int n11 = 3;
        if (n10 <= n11) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            n11 = 0;
            objectArray[0] = string3;
            m.a.a.e(string2, objectArray);
        }
    }

    public static void c(String string2, String string3, Exception exception) {
        int n10 = f;
        int n11 = 4;
        if (n10 <= n11) {
            d.v.h.l.b.b(string2, string3);
            if (exception != null) {
                exception.printStackTrace();
            }
        }
    }

    public static String d(Exception exception) {
        String string2;
        if (exception != null && (string2 = exception.getMessage()) != null) {
            return exception.getMessage();
        }
        return "";
    }

    public static void e(String string2, String string3) {
        int n10 = f;
        int n11 = 1;
        if (n10 <= n11) {
            Object[] objectArray = new Object[n11];
            n11 = 0;
            objectArray[0] = string3;
            m.a.a.i(string2, objectArray);
        }
    }

    public static void f(int n10) {
        f = n10;
    }

    public static void g(String string2, String string3) {
        int n10 = f;
        int n11 = 2;
        if (n10 <= n11) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            n11 = 0;
            objectArray[0] = string3;
            m.a.a.x(string2, objectArray);
        }
    }
}

