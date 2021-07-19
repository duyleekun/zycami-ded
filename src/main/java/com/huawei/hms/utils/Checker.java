/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.huawei.hms.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Objects;

public final class Checker {
    public static void assertHandlerThread(Handler handler) {
        Checker.assertHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void assertHandlerThread(Handler object, String string2) {
        Looper looper = Looper.myLooper();
        if (looper == (object = object.getLooper())) {
            return;
        }
        object = new IllegalStateException(string2);
        throw object;
    }

    public static void assertNonEmpty(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return;
        }
        object = new IllegalStateException("Given String is empty or null");
        throw object;
    }

    public static void assertNonEmpty(String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return;
        }
        string2 = String.valueOf(string2);
        object = new IllegalStateException(string2);
        throw object;
    }

    public static Object assertNonNull(Object object) {
        Objects.requireNonNull(object, "Null reference");
        return object;
    }

    public static Object assertNonNull(Object object, String string2) {
        if (object != null) {
            return object;
        }
        string2 = String.valueOf(string2);
        object = new NullPointerException(string2);
        throw object;
    }

    public static void assertNotUiThread(String string2) {
        Looper looper;
        Object object = Looper.myLooper();
        if (object != (looper = Looper.getMainLooper())) {
            return;
        }
        object = new IllegalStateException(string2);
        throw object;
    }

    public static void assertUiThread(String string2) {
        Looper looper;
        Object object = Looper.myLooper();
        if (object == (looper = Looper.getMainLooper())) {
            return;
        }
        object = new IllegalStateException(string2);
        throw object;
    }

    public static String checkNonEmpty(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        object = new IllegalArgumentException("Given String is empty or null");
        throw object;
    }

    public static String checkNonEmpty(String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        string2 = String.valueOf(string2);
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static Object checkNonNull(Object object) {
        Objects.requireNonNull(object, "Null reference");
        return object;
    }

    public static Object checkNonNull(Object object, String string2) {
        if (object != null) {
            return object;
        }
        string2 = String.valueOf(string2);
        object = new NullPointerException(string2);
        throw object;
    }

    public static int checkNonZero(int n10) {
        if (n10 != 0) {
            return n10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given Integer is zero");
        throw illegalArgumentException;
    }

    public static int checkNonZero(int n10, String string2) {
        if (n10 != 0) {
            return n10;
        }
        string2 = String.valueOf(string2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static long checkNotZero(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            return l10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given Long is zero");
        throw illegalArgumentException;
    }

    public static long checkNotZero(long l10, String string2) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            return l10;
        }
        String string3 = String.valueOf(string2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }
}

