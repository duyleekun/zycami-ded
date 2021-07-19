/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.slf4j.impl.StaticLoggerBinder
 */
package i.h;

import i.h.a;
import i.h.g.c;
import i.h.h.e;
import i.h.h.g;
import i.h.h.h;
import i.h.h.i;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.impl.StaticLoggerBinder;

public final class d {
    public static final String a = "http://www.slf4j.org/codes.html";
    public static final String b = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
    public static final String c = "http://www.slf4j.org/codes.html#multiple_bindings";
    public static final String d = "http://www.slf4j.org/codes.html#null_LF";
    public static final String e = "http://www.slf4j.org/codes.html#version_mismatch";
    public static final String f = "http://www.slf4j.org/codes.html#substituteLogger";
    public static final String g = "http://www.slf4j.org/codes.html#loggerNameMismatch";
    public static final String h = "http://www.slf4j.org/codes.html#replay";
    public static final String i = "http://www.slf4j.org/codes.html#unsuccessfulInit";
    public static final String j = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static volatile int p = 0;
    public static final h q;
    public static final e r;
    public static final String s = "slf4j.detectLoggerNameMismatch";
    public static final String t = "java.vendor.url";
    public static boolean u;
    private static final String[] v;
    private static String w;

    static {
        a a10;
        q = a10 = new h();
        a10 = new e();
        r = a10;
        u = i.h.h.i.f(s);
        v = new String[]{"1.6", "1.7"};
        w = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    private d() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void a() {
        NoClassDefFoundError noClassDefFoundError2;
        block5: {
            int n10 = 0;
            Object object = null;
            try {
                int n11 = i.h.d.l();
                if (n11 == 0) {
                    object = i.h.d.f();
                    i.h.d.s((Set)object);
                }
                StaticLoggerBinder.getSingleton();
                p = n11 = 3;
                i.h.d.r((Set)object);
                i.h.d.g();
                i.h.d.p();
                object = q;
                ((h)object).b();
                return;
            }
            catch (Exception exception) {
                i.h.d.e(exception);
                IllegalStateException illegalStateException = new IllegalStateException("Unexpected initialization failure", exception);
                throw illegalStateException;
            }
            catch (NoSuchMethodError noSuchMethodError) {
                String string2 = noSuchMethodError.getMessage();
                if (string2 == null) throw noSuchMethodError;
                String string3 = "org.slf4j.impl.StaticLoggerBinder.getSingleton()";
                int n12 = string2.contains(string3);
                if (n12 == 0) throw noSuchMethodError;
                p = n12 = 2;
                i.h.h.i.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                i.h.h.i.c("Your binding is version 1.5.5 or earlier.");
                string2 = "Upgrade your binding to version 1.6.x.";
                i.h.h.i.c(string2);
                throw noSuchMethodError;
            }
            catch (NoClassDefFoundError noClassDefFoundError2) {
                String string4 = noClassDefFoundError2.getMessage();
                boolean bl2 = i.h.d.m(string4);
                if (!bl2) break block5;
                p = n10 = 4;
                i.h.h.i.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                i.h.h.i.c("Defaulting to no-operation (NOP) logger implementation");
                String string5 = "See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.";
                i.h.h.i.c(string5);
            }
            return;
        }
        i.h.d.e(noClassDefFoundError2);
        throw noClassDefFoundError2;
    }

    private static void b(i.h.g.d object, int n10) {
        g g10 = ((i.h.g.d)object).g();
        boolean bl2 = g10.d();
        if (bl2) {
            i.h.d.c(n10);
        } else {
            boolean bl3 = ((g)(object = ((i.h.g.d)object).g())).e();
            if (!bl3) {
                i.h.d.d();
            }
        }
    }

    private static void c(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("A number (");
        stringBuilder.append(n10);
        stringBuilder.append(") of logging calls during the initialization phase have been intercepted and are");
        i.h.h.i.c(stringBuilder.toString());
        i.h.h.i.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        i.h.h.i.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        i.h.h.i.c("The following set of substitute loggers may have been accessed");
        i.h.h.i.c("during the initialization phase. Logging calls during this");
        i.h.h.i.c("phase were not honored. However, subsequent logging calls to these");
        i.h.h.i.c("loggers will work as normally expected.");
        i.h.h.i.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    public static void e(Throwable throwable) {
        p = 2;
        i.h.h.i.d("Failed to instantiate SLF4J LoggerFactory", throwable);
    }

    public static Set f() {
        Object object;
        Enumeration<URL> enumeration;
        LinkedHashSet<Object> linkedHashSet;
        block12: {
            block11: {
                linkedHashSet = new LinkedHashSet<Object>();
                enumeration = d.class;
                enumeration = ((Class)((Object)enumeration)).getClassLoader();
                if (enumeration != null) break block11;
                enumeration = w;
                enumeration = ClassLoader.getSystemResources((String)((Object)enumeration));
                break block12;
            }
            object = w;
            try {
                enumeration = ((ClassLoader)((Object)enumeration)).getResources((String)object);
            }
            catch (IOException iOException) {
                object = "Error getting resources from path";
                i.h.h.i.d((String)object, iOException);
            }
        }
        while (true) {
            boolean bl2 = enumeration.hasMoreElements();
            if (!bl2) break;
            object = enumeration.nextElement();
            object = (URL)object;
            linkedHashSet.add(object);
            continue;
            break;
        }
        return linkedHashSet;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void g() {
        h h10 = q;
        synchronized (h10) {
            h10.f();
            Object object = h10.e();
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (g)object2;
                Object object3 = ((g)object2).getName();
                object3 = i.h.d.j((String)object3);
                ((g)object2).h((i.h.c)object3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a h() {
        Object object;
        int n10 = p;
        int n11 = 1;
        if (n10 == 0) {
            object = d.class;
            synchronized (object) {
                int n12 = p;
                if (n12 == 0) {
                    p = n11;
                    i.h.d.o();
                }
            }
        }
        if ((n10 = p) == n11) {
            return q;
        }
        n11 = 2;
        if (n10 == n11) {
            object = new IllegalStateException(j);
            throw object;
        }
        n11 = 3;
        if (n10 == n11) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        n11 = 4;
        if (n10 == n11) {
            return r;
        }
        object = new IllegalStateException("Unreachable code");
        throw object;
    }

    public static i.h.c i(Class object) {
        int n10;
        Object object2;
        i.h.c c10 = i.h.d.j(object.getName());
        boolean bl2 = u;
        if (bl2 && (object2 = i.h.h.i.a()) != null && (n10 = i.h.d.n((Class)object, (Class)object2)) != 0) {
            n10 = 2;
            object = new Object[n10];
            String string2 = c10.getName();
            object[0] = string2;
            int n11 = 1;
            object[n11] = object2 = ((Class)object2).getName();
            object2 = "Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".";
            i.h.h.i.c(String.format((String)object2, object));
            object = "See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation";
            i.h.h.i.c((String)object);
        }
        return c10;
    }

    public static i.h.c j(String string2) {
        return i.h.d.h().a(string2);
    }

    private static boolean k(Set set) {
        int n10;
        int n11 = set.size();
        if (n11 <= (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private static boolean l() {
        String string2 = i.h.h.i.g(t);
        if (string2 == null) {
            return false;
        }
        return string2.toLowerCase().contains("android");
    }

    private static boolean m(String string2) {
        if (string2 == null) {
            return false;
        }
        String string3 = "org/slf4j/impl/StaticLoggerBinder";
        boolean bl2 = string2.contains(string3);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        string3 = "org.slf4j.impl.StaticLoggerBinder";
        boolean bl4 = string2.contains(string3);
        if (bl4) {
            return bl3;
        }
        return false;
    }

    private static boolean n(Class clazz, Class clazz2) {
        return clazz2.isAssignableFrom(clazz) ^ true;
    }

    private static final void o() {
        i.h.d.a();
        int n10 = p;
        int n11 = 3;
        if (n10 == n11) {
            i.h.d.u();
        }
    }

    private static void p() {
        LinkedBlockingQueue linkedBlockingQueue = q.c();
        int n10 = linkedBlockingQueue.size();
        int n11 = 128;
        ArrayList arrayList = new ArrayList(n11);
        int n12 = 0;
        int n13;
        while ((n13 = linkedBlockingQueue.drainTo(arrayList, n11)) != 0) {
            boolean bl2;
            Iterator iterator2 = arrayList.iterator();
            while (bl2 = iterator2.hasNext()) {
                i.h.g.d d10 = (i.h.g.d)iterator2.next();
                i.h.d.q(d10);
                int n14 = n12 + 1;
                if (n12 == 0) {
                    i.h.d.b(d10, n10);
                }
                n12 = n14;
            }
            arrayList.clear();
        }
        return;
    }

    private static void q(i.h.g.d object) {
        if (object == null) {
            return;
        }
        g g10 = ((i.h.g.d)object).g();
        String string2 = g10.getName();
        boolean bl2 = g10.f();
        if (!bl2) {
            bl2 = g10.e();
            if (!bl2) {
                bl2 = g10.d();
                if (bl2) {
                    g10.g((c)object);
                } else {
                    i.h.h.i.c(string2);
                }
            }
            return;
        }
        object = new IllegalStateException("Delegate logger cannot be null at this state.");
        throw object;
    }

    private static void r(Set object) {
        boolean bl2;
        if (object != null && (bl2 = i.h.d.k((Set)object))) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Actual binding is of type [");
            String string2 = StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr();
            ((StringBuilder)object).append(string2);
            string2 = "]";
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            i.h.h.i.c((String)object);
        }
    }

    private static void s(Set object) {
        boolean bl2 = i.h.d.k((Set)object);
        if (bl2) {
            Object object2 = "Class path contains multiple SLF4J bindings.";
            i.h.h.i.c((String)object2);
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (URL)object.next();
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Found binding in [";
                stringBuilder.append(string2);
                stringBuilder.append(object2);
                stringBuilder.append("]");
                object2 = stringBuilder.toString();
                i.h.h.i.c((String)object2);
            }
            object = "See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.";
            i.h.h.i.c((String)object);
        }
    }

    public static void t() {
        p = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void u() {
        try {
            Object object = StaticLoggerBinder.REQUESTED_API_VERSION;
            Object object2 = v;
            int n10 = ((String[])object2).length;
            int n11 = 0;
            boolean bl2 = false;
            while (true) {
                if (n11 >= n10) {
                    if (bl2) return;
                    object2 = new StringBuilder();
                    String string2 = "The requested version ";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append((String)object);
                    object = " by your slf4j binding is not compatible with ";
                    ((StringBuilder)object2).append((String)object);
                    object = v;
                    object = Arrays.asList(object);
                    object = object.toString();
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    i.h.h.i.c((String)object);
                    object = "See http://www.slf4j.org/codes.html#version_mismatch for further details.";
                    i.h.h.i.c((String)object);
                    return;
                }
                String string3 = object2[n11];
                boolean bl3 = ((String)object).startsWith(string3);
                if (bl3) {
                    bl2 = true;
                }
                ++n11;
            }
        }
        catch (Throwable throwable) {
            String string4 = "Unexpected problem occured during version sanity check";
            i.h.h.i.d(string4, throwable);
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

