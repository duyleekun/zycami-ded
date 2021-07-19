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

public final class Present
extends Optional {
    private static final long serialVersionUID;
    private final Object reference;

    public Present(Object object) {
        this.reference = object;
    }

    public Set asSet() {
        return Collections.singleton(this.reference);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Present;
        if (bl2) {
            object = (Present)object;
            Object object2 = this.reference;
            object = ((Present)object).reference;
            return object2.equals(object);
        }
        return false;
    }

    public Object get() {
        return this.reference;
    }

    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
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
        return this.reference;
    }

    public Object or(Object object) {
        Preconditions.checkNotNull(object, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    public Object orNull() {
        return this.reference;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Optional.of(");
        Object object = this.reference;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Optional transform(Function object) {
        Object object2 = this.reference;
        object = Preconditions.checkNotNull(object.apply(object2), "the Function passed to Optional.transform() must not return null.");
        Present present = new Present(object);
        return present;
    }
}

