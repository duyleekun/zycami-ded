/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.k;
import com.huawei.hms.hatool.m;
import java.util.Map;

public abstract class c {
    public static void a(String object, String string2, long l10) {
        if ((object = c.h((String)object, string2)) != null) {
            ((k)object).a(l10);
        }
    }

    public static boolean a(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).a();
        }
        return true;
    }

    public static int b(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).d();
        }
        return 7;
    }

    public static boolean c(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).g();
        }
        return true;
    }

    public static String d(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).f();
        }
        return "";
    }

    public static boolean e(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).i();
        }
        return false;
    }

    public static String f(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).h();
        }
        return "";
    }

    public static String g(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).n();
        }
        return "";
    }

    public static k h(String object, String object2) {
        Object object3 = i.c();
        object = ((i)object3).a((String)object);
        if (object != null) {
            object3 = "alltype";
            boolean bl2 = ((String)object3).equals(object2);
            if (bl2) {
                object2 = ((m)object).a("oper");
                if (object2 == null) {
                    object2 = ((m)object).a("maint");
                }
                return object2;
            }
            return ((m)object).a((String)object2);
        }
        return null;
    }

    public static Map i(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).k();
        }
        return null;
    }

    public static long j(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).l();
        }
        return 0L;
    }

    public static int k(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).b();
        }
        return 10;
    }

    public static String l(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).o();
        }
        return "";
    }

    public static String m(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).q();
        }
        return "";
    }

    public static String n(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).m();
        }
        return "";
    }

    public static String o(String object, String string2) {
        if ((object = c.h((String)object, string2)) != null) {
            return ((k)object).p();
        }
        return "";
    }
}

