/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

public final class Asserter {
    private Asserter() {
        AssertionError assertionError = new AssertionError((Object)"Cannot use constructor to make a new instance");
        throw assertionError;
    }

    public static void checkNotNull(Object object) {
        if (object != null) {
            return;
        }
        object = new IllegalArgumentException("checked object is null");
        throw object;
    }

    public static void checkNotNull(Object object, Object object2) {
        if (object != null) {
            return;
        }
        object2 = object2.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static void checkNull(Object object) {
        if (object == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = object.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(" is not null");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
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
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }
}

