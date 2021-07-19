/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence$1;
import com.google.common.base.Preconditions;
import java.io.Serializable;

public final class Equivalence$Wrapper
implements Serializable {
    private static final long serialVersionUID;
    private final Equivalence equivalence;
    private final Object reference;

    private Equivalence$Wrapper(Equivalence equivalence, Object object) {
        this.equivalence = equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.reference = object;
    }

    public /* synthetic */ Equivalence$Wrapper(Equivalence equivalence, Object object, Equivalence$1 equivalence$1) {
        this(equivalence, object);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof Equivalence$Wrapper;
        if (bl2) {
            object = (Equivalence$Wrapper)object;
            Equivalence equivalence = this.equivalence;
            Object object2 = ((Equivalence$Wrapper)object).equivalence;
            bl2 = equivalence.equals(object2);
            if (bl2) {
                equivalence = this.equivalence;
                object2 = this.reference;
                object = ((Equivalence$Wrapper)object).reference;
                return equivalence.equivalent(object2, object);
            }
        }
        return false;
    }

    public Object get() {
        return this.reference;
    }

    public int hashCode() {
        Equivalence equivalence = this.equivalence;
        Object object = this.reference;
        return equivalence.hash(object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.equivalence;
        stringBuilder.append(object);
        stringBuilder.append(".wrap(");
        object = this.reference;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

