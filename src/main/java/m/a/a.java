/*
 * Decompiled with CFR 0.151.
 */
package m.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import m.a.a$a;
import m.a.a$c;

public final class a {
    private static final a$c[] a;
    private static final List b;
    public static volatile a$c[] c;
    private static final a$c d;

    static {
        ArrayList arrayList;
        Object object = new a$c[]{};
        a = object;
        b = arrayList = new ArrayList();
        c = object;
        d = object = new a$a();
    }

    private a() {
        AssertionError assertionError = new AssertionError((Object)"No instances.");
        throw assertionError;
    }

    public static void A(String string2, Object ... objectArray) {
        d.z(string2, objectArray);
    }

    public static void B(Throwable throwable) {
        d.A(throwable);
    }

    public static void C(Throwable throwable, String string2, Object ... objectArray) {
        d.B(throwable, string2, objectArray);
    }

    public static a$c a() {
        return d;
    }

    public static void b(String string2, Object ... objectArray) {
        d.a(string2, objectArray);
    }

    public static void c(Throwable throwable) {
        d.b(throwable);
    }

    public static void d(Throwable throwable, String string2, Object ... objectArray) {
        d.c(throwable, string2, objectArray);
    }

    public static void e(String string2, Object ... objectArray) {
        d.d(string2, objectArray);
    }

    public static void f(Throwable throwable) {
        d.e(throwable);
    }

    public static void g(Throwable throwable, String string2, Object ... objectArray) {
        d.f(throwable, string2, objectArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List h() {
        List list = b;
        synchronized (list) {
            List list2 = new List(list);
            return Collections.unmodifiableList(list2);
        }
    }

    public static void i(String string2, Object ... objectArray) {
        d.j(string2, objectArray);
    }

    public static void j(Throwable throwable) {
        d.k(throwable);
    }

    public static void k(Throwable throwable, String string2, Object ... objectArray) {
        d.l(throwable, string2, objectArray);
    }

    public static void l(int n10, String string2, Object ... objectArray) {
        d.p(n10, string2, objectArray);
    }

    public static void m(int n10, Throwable throwable) {
        d.q(n10, throwable);
    }

    public static void n(int n10, Throwable throwable, String string2, Object ... objectArray) {
        d.r(n10, throwable, string2, objectArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void o(a$c a$cArray) {
        Objects.requireNonNull(a$cArray, "tree == null");
        Object object = d;
        if (a$cArray != object) {
            object = b;
            synchronized (object) {
                object.add(a$cArray);
                int n10 = object.size();
                a$cArray = new a$c[n10];
                a$cArray = object.toArray(a$cArray);
                c = a$cArray;
                return;
            }
        }
        a$cArray = new IllegalArgumentException("Cannot plant Timber into itself.");
        throw a$cArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void p(a$c ... object) {
        Object object2 = "trees == null";
        Objects.requireNonNull(object, (String)object2);
        int n10 = ((a$c[])object).length;
        int n11 = 0;
        while (true) {
            if (n11 >= n10) {
                object2 = b;
                synchronized (object2) {
                    Collections.addAll(object2, object);
                    int n12 = object2.size();
                    object = new a$c[n12];
                    object = object2.toArray((T[])object);
                    c = object;
                    return;
                }
            }
            a$c a$c = object[n11];
            Objects.requireNonNull(a$c, "trees contains null");
            a$c a$c2 = d;
            if (a$c == a$c2) {
                object = new IllegalArgumentException("Cannot plant Timber into itself.");
                throw object;
            }
            ++n11;
        }
    }

    public static a$c q(String string2) {
        a$c[] a$cArray = c;
        int n10 = a$cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            ThreadLocal threadLocal = a$cArray[i10].a;
            threadLocal.set(string2);
        }
        return d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int r() {
        List list = b;
        synchronized (list) {
            return list.size();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void s(a$c object) {
        List list = b;
        synchronized (list) {
            boolean bl2 = list.remove(object);
            if (bl2) {
                int n10 = list.size();
                object = new a$c[n10];
                object = list.toArray((T[])object);
                c = object;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Cannot uproot tree which is not planted: ";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void t() {
        List list = b;
        synchronized (list) {
            list.clear();
            a$c[] a$cArray = a;
            c = a$cArray;
            return;
        }
    }

    public static void u(String string2, Object ... objectArray) {
        d.t(string2, objectArray);
    }

    public static void v(Throwable throwable) {
        d.u(throwable);
    }

    public static void w(Throwable throwable, String string2, Object ... objectArray) {
        d.v(throwable, string2, objectArray);
    }

    public static void x(String string2, Object ... objectArray) {
        d.w(string2, objectArray);
    }

    public static void y(Throwable throwable) {
        d.x(throwable);
    }

    public static void z(Throwable throwable, String string2, Object ... objectArray) {
        d.y(throwable, string2, objectArray);
    }
}

