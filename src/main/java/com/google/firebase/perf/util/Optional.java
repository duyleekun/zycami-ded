/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class Optional {
    private final Object value;

    private Optional() {
        this.value = null;
    }

    private Optional(Object object) {
        Objects.requireNonNull(object, "value for optional is empty.");
        this.value = object;
    }

    public static Optional absent() {
        Optional optional = new Optional();
        return optional;
    }

    public static Optional fromNullable(Object object) {
        object = object == null ? Optional.absent() : Optional.of(object);
        return object;
    }

    public static Optional of(Object object) {
        Optional optional = new Optional(object);
        return optional;
    }

    public Object get() {
        Object object = this.value;
        if (object != null) {
            return object;
        }
        object = new NoSuchElementException("No value present");
        throw object;
    }

    public boolean isAvailable() {
        boolean bl2;
        Object object = this.value;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

