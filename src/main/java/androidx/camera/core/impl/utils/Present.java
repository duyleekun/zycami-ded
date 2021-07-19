/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.Optional;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

public final class Present
extends Optional {
    private static final long serialVersionUID;
    private final Object mReference;

    public Present(Object object) {
        this.mReference = object;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Present;
        if (bl2) {
            object = (Present)object;
            Object object2 = this.mReference;
            object = ((Present)object).mReference;
            return object2.equals(object);
        }
        return false;
    }

    public Object get() {
        return this.mReference;
    }

    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    public boolean isPresent() {
        return true;
    }

    public Optional or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    public Object or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.mReference;
    }

    public Object or(Object object) {
        Preconditions.checkNotNull(object, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    public Object orNull() {
        return this.mReference;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Optional.of(");
        Object object = this.mReference;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

