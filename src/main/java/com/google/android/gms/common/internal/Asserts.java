/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class Asserts {
    private Asserts() {
        AssertionError assertionError = new AssertionError((Object)"Uninstantiable");
        throw assertionError;
    }

    public static void checkMainThread(String string2) {
        Object object;
        Object object2 = Looper.getMainLooper().getThread();
        if (object2 == (object = Thread.currentThread())) {
            return;
        }
        object2 = String.valueOf(Thread.currentThread());
        object = String.valueOf(Looper.getMainLooper().getThread());
        int n10 = String.valueOf(object2).length() + 57;
        int n11 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("checkMainThread: current thread ");
        stringBuilder.append((String)object2);
        stringBuilder.append(" IS NOT the main thread ");
        stringBuilder.append((String)object);
        stringBuilder.append("!");
        object2 = stringBuilder.toString();
        Log.e((String)"Asserts", (String)object2);
        object2 = new IllegalStateException(string2);
        throw object2;
    }

    public static void checkNotMainThread(String string2) {
        Object object;
        Object object2 = Looper.getMainLooper().getThread();
        if (object2 != (object = Thread.currentThread())) {
            return;
        }
        object2 = String.valueOf(Thread.currentThread());
        object = String.valueOf(Looper.getMainLooper().getThread());
        int n10 = String.valueOf(object2).length() + 56;
        int n11 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("checkNotMainThread: current thread ");
        stringBuilder.append((String)object2);
        stringBuilder.append(" IS the main thread ");
        stringBuilder.append((String)object);
        stringBuilder.append("!");
        object2 = stringBuilder.toString();
        Log.e((String)"Asserts", (String)object2);
        object2 = new IllegalStateException(string2);
        throw object2;
    }

    public static void checkNotNull(Object object) {
        if (object != null) {
            return;
        }
        object = new IllegalArgumentException("null reference");
        throw object;
    }

    public static void checkNotNull(Object object, Object object2) {
        if (object != null) {
            return;
        }
        object2 = String.valueOf(object2);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static void checkNull(Object object) {
        if (object == null) {
            return;
        }
        object = new IllegalArgumentException("non-null reference");
        throw object;
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
}

