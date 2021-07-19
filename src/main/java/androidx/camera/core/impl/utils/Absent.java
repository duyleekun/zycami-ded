/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.Optional;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

public final class Absent
extends Optional {
    public static final Absent sInstance;
    private static final long serialVersionUID;

    static {
        Absent absent;
        sInstance = absent = new Absent();
    }

    private Absent() {
    }

    private Object readResolve() {
        return sInstance;
    }

    public static Optional withType() {
        return sInstance;
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
}

