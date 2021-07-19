/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import java.util.Objects;

public final class Preconditions {
    public static void checkArgument(boolean bl2, String string2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static Object checkNotNull(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static void checkState(boolean bl2, String string2) {
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }
}

