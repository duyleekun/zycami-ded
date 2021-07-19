/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package d.v.q;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.util.Pair;
import d.e.a.d$b;
import d.v.q.a;
import d.v.q.c;
import d.v.q.d;
import d.v.q.f;
import d.v.q.g;
import d.v.q.h.h;
import d.v.q.h.i;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class e {
    public static final int a = Integer.MIN_VALUE;
    private static final Pattern b = Pattern.compile("(\\$\\d+)+$");
    private static final int c = 23;
    private static int d = 2;
    private static String e = "";

    public static void A(Context context, boolean bl2) {
        d.v.q.d.a = bl2;
        d$b d$b = new d$b();
        Object object = f.b();
        d$b = d$b.b((String)object);
        object = f.c();
        d$b = d$b.h((String)object);
        object = "0123456789012345";
        byte[] byArray = ((String)object).getBytes();
        d$b = d$b.e(byArray);
        object = ((String)object).getBytes();
        d.e.a.c.c(d$b.d((byte[])object).a());
        g.i();
        d.v.q.h.e.a();
        i.g(context);
    }

    public static /* synthetic */ void B(Object[] objectArray, Object[] object, int n10) {
        int n11 = n10 + -1;
        objectArray[n10] = object = object[n11];
    }

    private static void C() {
        d = 2;
    }

    public static void D(Context object, String[] stringArray, h h10) {
        d.v.q.h.f f10 = new d.v.q.h.f();
        object = d.v.q.c.b(object.getApplicationContext());
        f10.j((Map)object).k(h10);
        d.e.a.c.g(stringArray, f10);
    }

    public static void E(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        e = string2;
    }

    public static void F(int n10, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        String string3 = d.v.q.e.v();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = d.v.q.e.a();
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        g.k(string3, n10, string2);
    }

    public static void G(int n10, String string2, Object ... objectArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        if (objectArray == null) {
            objectArray = d.v.q.e.v();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = d.v.q.e.a();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            g.k((String)objectArray, n10, string2);
            return;
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "%s";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            objectArray = d.v.q.e.u(objectArray);
        }
        g.l(d.v.q.e.v(), n10, string2, objectArray);
    }

    public static void H(String string2) {
        d.v.q.e.b(3);
        d.v.q.e.F(-1 << -1, string2);
        d.v.q.e.C();
    }

    public static void I(String string2, Object ... objectArray) {
        d.v.q.e.b(3);
        d.v.q.e.G(-1 << -1, string2, objectArray);
        d.v.q.e.C();
    }

    public static void J(int n10, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        String string3 = d.v.q.e.v();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = d.v.q.e.a();
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        g.m(string3, n10, string2);
    }

    public static void K(int n10, String string2, Object ... objectArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        if (objectArray == null) {
            objectArray = d.v.q.e.v();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = d.v.q.e.a();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            g.m((String)objectArray, n10, string2);
            return;
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "%s";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            objectArray = d.v.q.e.u(objectArray);
        }
        g.n(d.v.q.e.v(), n10, string2, objectArray);
    }

    public static void L(String string2) {
        d.v.q.e.b(3);
        d.v.q.e.J(-1 << -1, string2);
        d.v.q.e.C();
    }

    public static void M(String string2, Object ... objectArray) {
        d.v.q.e.b(3);
        d.v.q.e.K(-1 << -1, string2, objectArray);
        d.v.q.e.C();
    }

    private static String a() {
        CharSequence charSequence;
        boolean bl2 = d.v.q.d.a;
        if (bl2) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("----Device Info----start---");
            String string2 = d.v.q.c.a();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(" ");
            string2 = d.v.q.c.c();
            ((StringBuilder)charSequence).append(string2);
            string2 = "----Device Info---end--- \n";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    private static void b(int n10) {
        d = n10;
    }

    private static String c(StackTraceElement object) {
        int n10;
        Matcher matcher = b.matcher((CharSequence)(object = ((StackTraceElement)object).getClassName()));
        int n11 = matcher.find();
        if (n11 != 0) {
            object = matcher.replaceAll("");
        }
        int n12 = ((String)object).lastIndexOf(46) + 1;
        if ((n12 = ((String)(object = ((String)object).substring(n12))).length()) > (n11 = 23) && (n12 = Build.VERSION.SDK_INT) < (n10 = 24)) {
            n12 = 0;
            matcher = null;
            object = ((String)object).substring(0, n11);
        }
        return object;
    }

    public static void d(int n10, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        String string3 = d.v.q.e.v();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = d.v.q.e.a();
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        g.a(string3, n10, string2);
    }

    public static void e(int n10, String string2, Object ... objectArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        if (objectArray == null) {
            objectArray = d.v.q.e.v();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = d.v.q.e.a();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            g.a((String)objectArray, n10, string2);
            return;
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "%s";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            objectArray = d.v.q.e.u(objectArray);
        }
        g.b(d.v.q.e.v(), n10, string2, objectArray);
    }

    public static void f(String string2) {
        d.v.q.e.b(3);
        d.v.q.e.d(-1 << -1, string2);
        d.v.q.e.C();
    }

    public static void g(String string2, Object ... objectArray) {
        d.v.q.e.b(3);
        d.v.q.e.e(-1 << -1, string2, objectArray);
        d.v.q.e.C();
    }

    public static void h(int n10, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        String string3 = d.v.q.e.v();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = d.v.q.e.a();
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        g.c(string3, n10, string2);
    }

    public static void i(int n10, String object, Object ... object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        if (object2 == null) {
            object2 = d.v.q.e.v();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = d.v.q.e.a();
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            g.c((String)object2, n10, (String)object);
            return;
        }
        object = d.v.q.e.t((String)object, object2);
        object2 = d.v.q.e.v();
        String string3 = (String)object.first;
        object = (Object[])object.second;
        g.d((String)object2, n10, string3, object);
    }

    public static void j(int n10, Throwable throwable, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 && throwable == null) {
            return;
        }
        String string3 = d.v.q.e.v();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = d.v.q.e.a();
        stringBuilder.append(string4);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            string2 = "";
        }
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        g.j(string3, throwable, n10, string2, null);
    }

    public static void k(int n10, Throwable throwable, String string2, Object ... objectArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = null;
        if (bl2) {
            string2 = d.v.q.e.v();
            objectArray = d.v.q.e.a();
            g.j(string2, throwable, n10, (String)objectArray, null);
            return;
        }
        if (objectArray == null) {
            objectArray = d.v.q.e.v();
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = d.v.q.e.a();
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            g.j((String)objectArray, throwable, n10, string2, null);
            return;
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            string3 = "%s";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            objectArray = d.v.q.e.u(objectArray);
        }
        g.j(d.v.q.e.v(), throwable, n10, string2, objectArray);
    }

    public static void l(String string2) {
        d.v.q.e.b(3);
        d.v.q.e.h(-1 << -1, string2);
        d.v.q.e.C();
    }

    public static void m(String string2, Object ... objectArray) {
        d.v.q.e.b(3);
        d.v.q.e.i(-1 << -1, string2, objectArray);
        d.v.q.e.C();
    }

    public static void n(Throwable throwable, String string2) {
        d.v.q.e.b(3);
        d.v.q.e.j(-1 << -1, throwable, string2);
        d.v.q.e.C();
    }

    public static void o(Throwable throwable, String string2, Object ... objectArray) {
        d.v.q.e.b(3);
        d.v.q.e.k(-1 << -1, throwable, string2, objectArray);
        d.v.q.e.C();
    }

    public static void p(int n10, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        String string3 = d.v.q.e.v();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = d.v.q.e.a();
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        g.e(string3, n10, string2);
    }

    public static void q(int n10, String string2, Object ... objectArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        if (objectArray == null) {
            objectArray = d.v.q.e.v();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = d.v.q.e.a();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            g.e((String)objectArray, n10, string2);
            return;
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "%s";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            objectArray = d.v.q.e.u(objectArray);
        }
        g.f(d.v.q.e.v(), n10, string2, objectArray);
    }

    public static void r(String string2) {
        d.v.q.e.b(3);
        d.v.q.e.p(-1 << -1, string2);
        d.v.q.e.C();
    }

    public static void s(String string2, Object ... objectArray) {
        d.v.q.e.b(3);
        d.v.q.e.q(-1 << -1, string2, objectArray);
        d.v.q.e.C();
    }

    private static Pair t(String string2, Object ... objectArray) {
        boolean bl2 = d.v.q.d.a;
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "%s";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            objectArray = d.v.q.e.u(objectArray);
        }
        return Pair.create(string2, objectArray);
    }

    private static Object[] u(Object ... objectArray) {
        Object object;
        int n10 = objectArray.length + 1;
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = object = d.v.q.e.a();
        IntStream intStream = IntStream.range(0, n10).skip(1L);
        object = new a(objectArray2, objectArray);
        intStream.forEach((IntConsumer)object);
        return objectArray2;
    }

    private static String v() {
        Object object = e;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2 && (bl2 = d.v.q.d.a)) {
            int n10;
            object = new Throwable();
            int n11 = ((StackTraceElement[])(object = object.getStackTrace())).length;
            if (n11 <= (n10 = d)) {
                object = new Object[]{};
                m.a.a.i("Synthetic stacktrace didn't have enough elements: are you using proguard?", object);
                return "";
            }
            return d.v.q.e.c(object[n10]);
        }
        return e;
    }

    public static void w(int n10, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        String string3 = d.v.q.e.v();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = d.v.q.e.a();
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        g.g(string3, n10, string2);
    }

    public static void x(int n10, String string2, Object ... objectArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        if (objectArray == null) {
            objectArray = d.v.q.e.v();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = d.v.q.e.a();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            g.g((String)objectArray, n10, string2);
            return;
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "%s";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        bl2 = d.v.q.d.a;
        if (!bl2) {
            objectArray = d.v.q.e.u(objectArray);
        }
        g.h(d.v.q.e.v(), n10, string2, objectArray);
    }

    public static void y(String string2) {
        d.v.q.e.b(3);
        d.v.q.e.w(-1 << -1, string2);
        d.v.q.e.C();
    }

    public static void z(String string2, Object ... objectArray) {
        d.v.q.e.b(3);
        d.v.q.e.x(-1 << -1, string2, objectArray);
        d.v.q.e.C();
    }
}

