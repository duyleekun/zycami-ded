/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.secure.android.common.util.LogsUtil$a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogsUtil {
    private static final Pattern a = Pattern.compile("[0-9]*[a-z|A-Z]*[\u4e00-\u9fa5]*");
    private static final char b = '*';
    private static final int c = 2;

    public static void A(String string2, String string3, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && throwable == null) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        throwable = LogsUtil.d(throwable);
        Log.w((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void B(String string2, String string3, Throwable throwable, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3 && throwable == null) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        throwable = LogsUtil.d(throwable);
        Log.w((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void C(String string2, String string3, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        Log.w((String)string2, (String)string3);
    }

    private static String a(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return string2;
        }
        n10 = string2.length();
        char c10 = '*';
        int n11 = 1;
        if (n11 == n10) {
            return String.valueOf(c10);
        }
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c11 = string2.charAt(i10);
            Object object = a;
            String string3 = String.valueOf(c11);
            int n12 = ((Matcher)(object = ((Pattern)object).matcher(string3))).matches();
            if (n12 != 0) {
                n12 = n11 % 2;
                if (n12 == 0) {
                    c11 = c10;
                }
                ++n11;
            }
            stringBuilder.append(c11);
        }
        return stringBuilder.toString();
    }

    private static String b(String string2, String string3) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder(512);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            stringBuilder.append(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            string2 = LogsUtil.a(string3);
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    private static String c(String string2, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder(512);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            if (bl2) {
                string2 = LogsUtil.a(string2);
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(string2);
            }
        }
        return stringBuilder.toString();
    }

    private static Throwable d(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        LogsUtil$a logsUtil$a = new LogsUtil$a(throwable);
        Object object = throwable.getStackTrace();
        logsUtil$a.setStackTrace((StackTraceElement[])object);
        object = LogsUtil.e(throwable.getMessage());
        logsUtil$a.setMessage((String)object);
        object = logsUtil$a;
        for (throwable = throwable.getCause(); throwable != null; throwable = throwable.getCause()) {
            LogsUtil$a logsUtil$a2 = new LogsUtil$a(throwable);
            Object object2 = throwable.getStackTrace();
            logsUtil$a2.setStackTrace((StackTraceElement[])object2);
            object2 = LogsUtil.e(throwable.getMessage());
            logsUtil$a2.setMessage((String)object2);
            ((LogsUtil$a)object).b(logsUtil$a2);
            object = logsUtil$a2;
        }
        return logsUtil$a;
    }

    private static String e(String object) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            return object;
        }
        object = ((String)object).toCharArray();
        String string2 = null;
        for (n11 = 0; n11 < (n10 = ((Object)object).length); ++n11) {
            n10 = n11 % 2;
            if (n10 != 0) continue;
            n10 = 42;
            object[n11] = n10;
        }
        string2 = new String((char[])object);
        return string2;
    }

    public static void f(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        Log.d((String)string2, (String)string3);
    }

    public static void g(String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string4))) {
            return;
        }
        string3 = LogsUtil.b(string3, string4);
        Log.d((String)string2, (String)string3);
    }

    public static void h(String string2, String string3, String object, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)object))) {
            return;
        }
        string3 = LogsUtil.b(string3, (String)object);
        object = LogsUtil.d(throwable);
        Log.d((String)string2, (String)string3, (Throwable)object);
    }

    public static void i(String string2, String string3, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && throwable == null) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        throwable = LogsUtil.d(throwable);
        Log.d((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void j(String string2, String string3, Throwable throwable, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        throwable = LogsUtil.d(throwable);
        Log.d((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void k(String string2, String string3, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        Log.d((String)string2, (String)string3);
    }

    public static void l(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        Log.e((String)string2, (String)string3);
    }

    public static void m(String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string4))) {
            return;
        }
        string3 = LogsUtil.b(string3, string4);
        Log.e((String)string2, (String)string3);
    }

    public static void n(String string2, String string3, String object, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)object))) {
            return;
        }
        string3 = LogsUtil.b(string3, (String)object);
        object = LogsUtil.d(throwable);
        Log.e((String)string2, (String)string3, (Throwable)object);
    }

    public static void o(String string2, String string3, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && throwable == null) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        throwable = LogsUtil.d(throwable);
        Log.e((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void p(String string2, String string3, Throwable throwable, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3 && throwable == null) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        throwable = LogsUtil.d(throwable);
        Log.e((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void q(String string2, String string3, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        Log.e((String)string2, (String)string3);
    }

    public static void r(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        Log.i((String)string2, (String)string3);
    }

    public static void s(String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string4))) {
            return;
        }
        string3 = LogsUtil.b(string3, string4);
        Log.i((String)string2, (String)string3);
    }

    public static void t(String string2, String string3, String object, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)object))) {
            return;
        }
        string3 = LogsUtil.b(string3, (String)object);
        object = LogsUtil.d(throwable);
        Log.i((String)string2, (String)string3, (Throwable)object);
    }

    public static void u(String string2, String string3, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && throwable == null) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        throwable = LogsUtil.d(throwable);
        Log.i((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void v(String string2, String string3, Throwable throwable, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3 && throwable == null) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        throwable = LogsUtil.d(throwable);
        Log.i((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void w(String string2, String string3, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            return;
        }
        string3 = LogsUtil.c(string3, bl2);
        Log.i((String)string2, (String)string3);
    }

    public static void x(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return;
        }
        string3 = LogsUtil.c(string3, false);
        Log.w((String)string2, (String)string3);
    }

    public static void y(String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string4))) {
            return;
        }
        string3 = LogsUtil.b(string3, string4);
        Log.w((String)string2, (String)string3);
    }

    public static void z(String string2, String string3, String object, Throwable throwable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)object))) {
            return;
        }
        string3 = LogsUtil.b(string3, (String)object);
        object = LogsUtil.d(throwable);
        Log.w((String)string2, (String)string3, (Throwable)object);
    }
}

