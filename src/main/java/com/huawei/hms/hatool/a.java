/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.j;
import com.huawei.hms.hatool.k;
import com.huawei.hms.hatool.m;

public abstract class a {
    public static String a(String object, String string2) {
        if ((object = a.c((String)object, string2)) != null) {
            return ((j)object).a();
        }
        return "";
    }

    public static boolean b(String object, String string2) {
        boolean bl2;
        if ((object = a.c((String)object, string2)) != null && (bl2 = ((j)object).e())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static j c(String object, String string2) {
        i i10 = i.c();
        object = i10.a((String)object);
        if (object != null && (object = ((m)object).a(string2)) != null) {
            return ((k)object).j();
        }
        return null;
    }

    public static String d(String object, String string2) {
        if ((object = a.c((String)object, string2)) != null) {
            return ((j)object).b();
        }
        return "";
    }

    public static boolean e(String object, String string2) {
        boolean bl2;
        if ((object = a.c((String)object, string2)) != null && (bl2 = ((j)object).f())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean f(String object, String string2) {
        i i10 = i.c();
        object = i10.a((String)object);
        if (object != null && (object = ((m)object).a(string2)) != null) {
            return ((k)object).c();
        }
        return false;
    }

    public static String g(String object, String string2) {
        if ((object = a.c((String)object, string2)) != null) {
            return ((j)object).d();
        }
        return "";
    }

    public static boolean h(String object, String string2) {
        boolean bl2;
        if ((object = a.c((String)object, string2)) != null && (bl2 = ((j)object).g())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean i(String object, String string2) {
        i i10 = i.c();
        object = i10.a((String)object);
        if (object != null && (object = ((m)object).a(string2)) != null) {
            return ((k)object).e();
        }
        return false;
    }

    public static String j(String object, String string2) {
        if ((object = a.c((String)object, string2)) != null) {
            return ((j)object).c();
        }
        return "";
    }

    public static boolean k(String object, String string2) {
        boolean bl2;
        if ((object = a.c((String)object, string2)) != null && (bl2 = ((j)object).h())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

