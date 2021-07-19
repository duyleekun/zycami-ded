/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

public final class Preconditions {
    public Preconditions() {
        AssertionError assertionError = new AssertionError((Object)"Cannot use constructor to make a new instance");
        throw assertionError;
    }

    public static boolean a() {
        boolean bl2;
        Looper looper;
        Looper looper2 = Looper.getMainLooper();
        if (looper2 == (looper = Looper.myLooper())) {
            bl2 = true;
        } else {
            bl2 = false;
            looper2 = null;
        }
        return bl2;
    }

    public static void checkArgument(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static void checkHandlerThread(Handler handler) {
        Preconditions.checkHandlerThread(handler, "Must be called on the handler thread");
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
        boolean bl2 = Preconditions.a();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static void checkNotMainThread() {
        boolean bl2 = Preconditions.a();
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Must not be called on the main application thread");
        throw illegalStateException;
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object, "must not refer to a null object");
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

    public static void checkState(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }
}

