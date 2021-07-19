/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.Absent;
import androidx.camera.core.impl.utils.Present;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.io.Serializable;

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

    public abstract boolean equals(Object var1);

    public abstract Object get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional or(Optional var1);

    public abstract Object or(Supplier var1);

    public abstract Object or(Object var1);

    public abstract Object orNull();

    public abstract String toString();
}

