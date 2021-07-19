/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Present;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Set;

public abstract class Optional
implements Serializable {
    private static final long serialVersionUID;

    public static Optional absent() {
        return Absent.withType();
    }

    public static Optional fromNullable(Object object) {
        if (object == null) {
            object = Optional.absent();
        } else {
            Present present = new Present(object);
            object = present;
        }
        return object;
    }

    public static Optional of(Object object) {
        object = Preconditions.checkNotNull(object);
        Present present = new Present(object);
        return present;
    }

    public static Iterable presentInstances(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        Optional$1 optional$1 = new Optional$1(iterable);
        return optional$1;
    }

    public abstract Set asSet();

    public abstract boolean equals(Object var1);

    public abstract Object get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional or(Optional var1);

    public abstract Object or(Supplier var1);

    public abstract Object or(Object var1);

    public abstract Object orNull();

    public abstract String toString();

    public abstract Optional transform(Function var1);
}

