/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.n.a.q0;

import android.util.Log;
import d.n.a.d0;
import d.n.a.d0$a;
import d.n.a.d0$b;
import d.n.a.q0.p$a;
import d.n.a.q0.p$b;
import d.n.a.q0.p$d;
import d.n.a.q0.t.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = Integer.MAX_VALUE;
    private static final Pattern g = Pattern.compile("\\$\\d+$");
    private static final ThreadLocal h;
    private static final d0$b i;
    private static a j;

    static {
        Object object = new ThreadLocal();
        h = object;
        p$a p$a = new p$a();
        i = p$a;
        j = object = new a(-1 >>> 1, -1 >>> 1, -1 >>> 1, false, true, p$a);
    }

    private p() {
    }

    private static String a() {
        int n10;
        Object object = h;
        Object object2 = (String)((ThreadLocal)object).get();
        if (object2 != null) {
            ((ThreadLocal)object).remove();
            return object2;
        }
        object = new Throwable();
        int n11 = ((StackTraceElement[])(object = ((Throwable)object).getStackTrace())).length;
        if (n11 >= (n10 = 5)) {
            n11 = 4;
            object = object[n11].getClassName();
            object2 = g.matcher((CharSequence)object);
            n10 = (int)(((Matcher)object2).find() ? 1 : 0);
            String string2 = "";
            if (n10 != 0) {
                object = ((Matcher)object2).replaceAll(string2);
            }
            object = ((String)object).replace("Impl", string2);
            object2 = "RxBle";
            object = ((String)object).replace((CharSequence)object2, string2);
            n11 = ((String)object).indexOf(36);
            n10 = 46;
            if (n11 <= 0) {
                n11 = ((String)object).lastIndexOf(n10) + 1;
                object = ((String)object).substring(n11);
            } else {
                n10 = ((String)object).lastIndexOf(n10) + 1;
                object = ((String)object).substring(n10, n11);
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("RxBle#");
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object = new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        throw object;
    }

    public static void b(String string2, Object ... objectArray) {
        p.q(3, null, string2, objectArray);
    }

    public static void c(Throwable throwable, String string2, Object ... objectArray) {
        p.q(3, throwable, string2, objectArray);
    }

    public static void d(String string2, Object ... objectArray) {
        p.q(6, null, string2, objectArray);
    }

    public static void e(Throwable throwable, String string2, Object ... objectArray) {
        p.q(6, throwable, string2, objectArray);
    }

    private static String f(String string2, Object ... objectArray) {
        int n10 = objectArray.length;
        if (n10 != 0) {
            string2 = String.format(string2, objectArray);
        }
        return string2;
    }

    public static int g() {
        return p.j.b;
    }

    public static boolean h() {
        return p.j.d;
    }

    public static boolean i() {
        return p.j.e;
    }

    public static int j() {
        return p.j.c;
    }

    public static void k(String string2, Object ... objectArray) {
        p.q(4, null, string2, objectArray);
    }

    public static void l(Throwable throwable, String string2, Object ... objectArray) {
        p.q(4, throwable, string2, objectArray);
    }

    public static boolean m(int n10) {
        a a10 = j;
        int n11 = a10.a;
        n10 = n11 <= n10 ? 1 : 0;
        return n10 != 0;
    }

    private static void n(int n10, String string2, String stringArray) {
        int n11;
        int n12 = stringArray.length();
        if (n12 < (n11 = 4000)) {
            d0$b d0$b = p.j.f;
            d0$b.a(n10, string2, (String)stringArray);
        } else {
            String string3 = "\n";
            for (String string4 : stringArray.split(string3)) {
                d0$b d0$b = p.j.f;
                d0$b.a(n10, string2, string4);
            }
        }
    }

    public static void o(int n10) {
        d0$a d0$a = new d0$a();
        Integer n11 = n10;
        p.r(d0$a.b(n11).a());
    }

    public static void p(p$d object) {
        Object object2;
        object = object == null ? i : (object2 = new p$b((p$d)object));
        object2 = new d0$a();
        p.r(((d0$a)object2).c((d0$b)object).a());
    }

    private static void q(int n10, Throwable object, String string2, Object ... object2) {
        block8: {
            block7: {
                block6: {
                    int n11;
                    a a10 = j;
                    int n12 = a10.a;
                    if (n10 < n12) {
                        return;
                    }
                    if ((string2 = p.f(string2, (Object[])object2)) == null || (n11 = string2.length()) == 0) break block6;
                    if (object != null) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append("\n");
                        object = Log.getStackTraceString((Throwable)object);
                        ((StringBuilder)object2).append((String)object);
                        string2 = ((StringBuilder)object2).toString();
                    }
                    break block7;
                }
                if (object == null) break block8;
                string2 = Log.getStackTraceString((Throwable)object);
            }
            object = p.a();
            p.n(n10, (String)object, string2);
        }
    }

    public static void r(d0 d02) {
        a a10 = j;
        a a11 = a10.a(d02);
        Object[] objectArray = new Object[]{d02, a10, a11};
        p.b("Received new options (%s) and merged with old setup: %s. New setup: %s", objectArray);
        j = a11;
    }

    public static void s(String string2, Object ... objectArray) {
        p.q(2, null, string2, objectArray);
    }

    public static void t(Throwable throwable, String string2, Object ... objectArray) {
        p.q(2, throwable, string2, objectArray);
    }

    public static void u(String string2, Object ... objectArray) {
        p.q(5, null, string2, objectArray);
    }

    public static void v(Throwable throwable, String string2, Object ... objectArray) {
        p.q(5, throwable, string2, objectArray);
    }
}

