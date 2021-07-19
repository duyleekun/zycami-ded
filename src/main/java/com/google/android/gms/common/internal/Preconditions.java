/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.zzc;
import java.util.Objects;

public final class Preconditions {
    private Preconditions() {
        AssertionError assertionError = new AssertionError((Object)"Uninstantiable");
        throw assertionError;
    }

    public static void checkArgument(boolean bl2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, String string2, Object ... objectArray) {
        if (bl2) {
            return;
        }
        string2 = String.format(string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkHandlerThread(Handler object) {
        Object object2;
        Object object3 = Looper.myLooper();
        if (object3 != (object2 = object.getLooper())) {
            object3 = object3 != null ? object3.getThread().getName() : "null current looper";
            object = object.getLooper().getThread().getName();
            int n10 = String.valueOf(object).length() + 36;
            int n11 = String.valueOf(object3).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += n11);
            stringBuilder.append("Must be called on ");
            stringBuilder.append((String)object);
            stringBuilder.append(" thread, but got ");
            stringBuilder.append((String)object3);
            stringBuilder.append(".");
            object = stringBuilder.toString();
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
    }

    public static void checkHandlerThread(Handler object, String string2) {
        Looper looper = Looper.myLooper();
        if (looper == (object = object.getLooper())) {
            return;
        }
        object = new IllegalStateException(string2);
        throw object;
    }

    public static void checkMainThread(String string2) {
        boolean bl2 = zzc.zza();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static String checkNotEmpty(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        object = new IllegalArgumentException("Given String is empty or null");
        throw object;
    }

    public static String checkNotEmpty(String object, Object object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        object2 = String.valueOf(object2);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static void checkNotMainThread() {
        Preconditions.checkNotMainThread("Must not be called on the main application thread");
    }

    public static void checkNotMainThread(String string2) {
        boolean bl2 = zzc.zza();
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object, "null reference");
        return object;
    }

    public static Object checkNotNull(Object object, Object object2) {
        if (object != null) {
            return object;
        }
        object2 = String.valueOf(object2);
        object = new NullPointerException((String)object2);
        throw object;
    }

    public static int checkNotZero(int n10) {
        if (n10 != 0) {
            return n10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given Integer is zero");
        throw illegalArgumentException;
    }

    public static int checkNotZero(int n10, Object object) {
        if (n10 != 0) {
            return n10;
        }
        object = String.valueOf(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
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

    public static long checkNotZero(long l10, Object object) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            return l10;
        }
        String string2 = String.valueOf(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkState(boolean bl2) {
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public static void checkState(boolean bl2, String string2, Object ... objectArray) {
        if (bl2) {
            return;
        }
        string2 = String.format(string2, objectArray);
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }
}

