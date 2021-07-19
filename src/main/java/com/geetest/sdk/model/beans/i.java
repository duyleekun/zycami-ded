/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.geetest.sdk.model.beans;

import android.content.Context;
import com.geetest.sdk.utils.o;

public class i {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static String h = "";
    private static String i = "";
    private static String j = "";
    private static String k = "";

    public static String a() {
        return e;
    }

    public static void a(Context object) {
        if (object != null) {
            int n10 = o.e(object, "gt3_geetest_click");
            a = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_http_error");
            b = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_please_verify");
            c = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_success");
            d = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_analyzing");
            e = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_checking");
            f = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_support");
            g = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_pass");
            h = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_http_timeout");
            i = object.getString(n10);
            n10 = o.e(object, "gt3_geetest_try_again");
            j = object.getString(n10);
            String string2 = "gt3_geetest_closed";
            n10 = o.e(object, string2);
            object = object.getString(n10);
            k = object;
        }
    }

    public static String b() {
        return k;
    }

    public static String c() {
        return f;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        return a;
    }

    public static String f() {
        return i;
    }

    public static String g() {
        return h;
    }

    public static String h() {
        return d;
    }

    public static String i() {
        return g;
    }

    public static String j() {
        return j;
    }

    public static String k() {
        return c;
    }
}

