/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

public final class FunctionalEquivalence
extends Equivalence
implements Serializable {
    private static final long serialVersionUID;
    private final Function function;
    private final Equivalence resultEquivalence;

    public FunctionalEquivalence(Function object, Equivalence equivalence) {
        object = (Function)Preconditions.checkNotNull(object);
        this.function = object;
        this.resultEquivalence = object = (Equivalence)Preconditions.checkNotNull(equivalence);
    }

    public boolean doEquivalent(Object object, Object object2) {
        Equivalence equivalence = this.resultEquivalence;
        object = this.function.apply(object);
        object2 = this.function.apply(object2);
        return equivalence.equivalent(object, object2);
    }

    public int doHash(Object object) {
        Equivalence equivalence = this.resultEquivalence;
        object = this.function.apply(object);
        return equivalence.hash(object);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof FunctionalEquivalence;
        if (bl3) {
            boolean bl4;
            object = (FunctionalEquivalence)object;
            Object object2 = this.function;
            Function function = ((FunctionalEquivalence)object).function;
            bl3 = object2.equals(function);
            if (!bl3 || !(bl4 = (object2 = this.resultEquivalence).equals(object = ((FunctionalEquivalence)object).resultEquivalence))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.function;
        object = this.resultEquivalence;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.resultEquivalence;
        stringBuilder.append(object);
        stringBuilder.append(".onResultOf(");
        object = this.function;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

