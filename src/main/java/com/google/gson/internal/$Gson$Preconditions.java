/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import java.util.Objects;

public final class $Gson$Preconditions {
    private $Gson$Preconditions() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public static void checkArgument(boolean bl2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }
}

