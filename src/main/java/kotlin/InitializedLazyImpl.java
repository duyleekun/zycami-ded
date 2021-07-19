/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.t;
import java.io.Serializable;

public final class InitializedLazyImpl
implements t,
Serializable {
    private final Object value;

    public InitializedLazyImpl(Object object) {
        this.value = object;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(this.getValue());
    }
}

