/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;

public final class Absent
extends Optional {
    public static final Absent INSTANCE;
    private static final long serialVersionUID;

    static {
        Absent absent;
        INSTANCE = absent = new Absent();
    }

    private Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static Optional withType() {
        return INSTANCE;
    }

    public Set asSet() {
        return Collections.emptySet();
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (object == this) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Object get() {
        IllegalStateException illegalStateException = new IllegalStateException("Optional.get() cannot be called on an absent value");
        throw illegalStateException;
    }

    public int hashCode() {
        return 2040732332;
    }

    public boolean isPresent() {
        return false;
    }

    public Optional or(Optional optional) {
        return (Optional)Preconditions.checkNotNull(optional);
    }

    public Object or(Supplier supplier) {
        return Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    public Object or(Object object) {
        return Preconditions.checkNotNull(object, "use Optional.orNull() instead of Optional.or(null)");
    }

    public Object orNull() {
        return null;
    }

    public String toString() {
        return "Optional.absent()";
    }

    public Optional transform(Function function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }
}

