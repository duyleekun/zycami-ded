/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.v.q;

import android.util.Log;
import d.v.q.d;
import d.v.q.g$a;
import d.v.q.g$b;
import d.v.q.g$c;

public class g {
    private static final g$c a;
    private static final g$c b;
    private static g$c c;

    static {
        g$c g$c = new g$a();
        a = g$c;
        g$c = new g$b();
        b = g$c;
        c = g$c;
    }

    public static void a(String string2, int n10, String string3) {
        g.b(string2, n10, string3, null);
    }

    public static void b(String string2, int n10, String string3, Object ... objectArray) {
        if (objectArray != null) {
            string3 = String.format(string3, objectArray);
        }
        if (string3 == null) {
            string3 = "";
        }
        c.b(string2, string3, n10);
    }

    public static void c(String string2, int n10, String string3) {
        g.d(string2, n10, string3, null);
    }

    public static void d(String string2, int n10, String string3, Object ... objectArray) {
        if (objectArray != null) {
            string3 = String.format(string3, objectArray);
        }
        if (string3 == null) {
            string3 = "";
        }
        c.f(string2, string3, n10);
    }

    public static void e(String string2, int n10, String string3) {
        g.f(string2, n10, string3, null);
    }

    public static void f(String string2, int n10, String string3, Object ... objectArray) {
        if (objectArray != null) {
            string3 = String.format(string3, objectArray);
        }
        if (string3 == null) {
            string3 = "";
        }
        c.c(string2, string3, n10);
    }

    public static void g(String string2, int n10, String string3) {
        g.h(string2, n10, string3, null);
    }

    public static void h(String string2, int n10, String string3, Object ... objectArray) {
        if (objectArray != null) {
            string3 = String.format(string3, objectArray);
        }
        if (string3 == null) {
            string3 = "";
        }
        c.a(string2, string3, n10);
    }

    public static void i() {
        g$c g$c;
        g$c g$c2;
        boolean bl2 = d.a;
        c = bl2 ? (g$c2 = b) : (g$c = a);
    }

    public static void j(String string2, Throwable object, int n10, String string3, Object ... object2) {
        if (object2 != null) {
            string3 = String.format(string3, (Object[])object2);
        }
        if (string3 == null) {
            string3 = "";
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append("---Error Trace start---- \n");
        object = Log.getStackTraceString((Throwable)object);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("---Error Trace end---");
        object = ((StringBuilder)object2).toString();
        c.f(string2, (String)object, n10);
    }

    public static void k(String string2, int n10, String string3) {
        g.l(string2, n10, string3, null);
    }

    public static void l(String string2, int n10, String string3, Object ... objectArray) {
        if (objectArray != null) {
            string3 = String.format(string3, objectArray);
        }
        if (string3 == null) {
            string3 = "";
        }
        c.e(string2, string3, n10);
    }

    public static void m(String string2, int n10, String string3) {
        g.n(string2, n10, string3, null);
    }

    public static void n(String string2, int n10, String string3, Object ... objectArray) {
        if (objectArray != null) {
            string3 = String.format(string3, objectArray);
        }
        if (string3 == null) {
            string3 = "";
        }
        c.d(string2, string3, n10);
    }
}

