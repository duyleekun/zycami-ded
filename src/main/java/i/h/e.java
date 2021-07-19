/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.slf4j.impl.StaticMDCBinder
 */
package i.h;

import i.h.e$b;
import i.h.h.f;
import i.h.h.i;
import i.h.i.c;
import java.util.Map;
import org.slf4j.impl.StaticMDCBinder;

public class e {
    public static final String a = "http://www.slf4j.org/codes.html#null_MDCA";
    public static final String b = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    public static c c;

    static {
        NoClassDefFoundError noClassDefFoundError2;
        block5: {
            c c10 = e.a();
            try {
                c = c10;
            }
            catch (Exception exception) {
                String string2 = "MDC binding unsuccessful.";
                i.d(string2, exception);
            }
            catch (NoClassDefFoundError noClassDefFoundError2) {
                String string3;
                boolean bl2;
                Object object = new f();
                c = object;
                object = noClassDefFoundError2.getMessage();
                if (object == null || !(bl2 = ((String)object).contains(string3 = "StaticMDCBinder"))) break block5;
                i.c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                i.c("Defaulting to no-operation MDCAdapter implementation.");
                String string4 = "See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.";
                i.c(string4);
            }
            return;
        }
        throw noClassDefFoundError2;
    }

    private e() {
    }

    private static c a() {
        StaticMDCBinder staticMDCBinder;
        try {
            staticMDCBinder = StaticMDCBinder.getSingleton();
        }
        catch (NoSuchMethodError noSuchMethodError) {
            return StaticMDCBinder.SINGLETON.getMDCA();
        }
        return staticMDCBinder.getMDCA();
    }

    public static void b() {
        Object object = c;
        if (object != null) {
            object.clear();
            return;
        }
        object = new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        throw object;
    }

    public static String c(String object) {
        if (object != null) {
            c c10 = c;
            if (c10 != null) {
                return c10.get((String)object);
            }
            object = new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw object;
        }
        object = new IllegalArgumentException("key parameter cannot be null");
        throw object;
    }

    public static Map d() {
        Object object = c;
        if (object != null) {
            return object.b();
        }
        object = new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        throw object;
    }

    public static c e() {
        return c;
    }

    public static void f(String object, String string2) {
        if (object != null) {
            c c10 = c;
            if (c10 != null) {
                c10.a((String)object, string2);
                return;
            }
            object = new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw object;
        }
        object = new IllegalArgumentException("key parameter cannot be null");
        throw object;
    }

    public static e$b g(String string2, String object) {
        e.f(string2, (String)object);
        object = new e$b(string2, null);
        return object;
    }

    public static void h(String object) {
        if (object != null) {
            c c10 = c;
            if (c10 != null) {
                c10.d((String)object);
                return;
            }
            object = new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw object;
        }
        object = new IllegalArgumentException("key parameter cannot be null");
        throw object;
    }

    public static void i(Map object) {
        c c10 = c;
        if (c10 != null) {
            c10.c((Map)object);
            return;
        }
        object = new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        throw object;
    }
}

