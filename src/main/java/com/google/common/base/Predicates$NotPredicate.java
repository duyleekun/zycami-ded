/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

public class Predicates$NotPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    public final Predicate predicate;

    public Predicates$NotPredicate(Predicate predicate) {
        this.predicate = predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    public boolean apply(Object object) {
        return this.predicate.apply(object) ^ true;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Predicates$NotPredicate;
        if (bl2) {
            object = (Predicates$NotPredicate)object;
            Predicate predicate = this.predicate;
            object = ((Predicates$NotPredicate)object).predicate;
            return predicate.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return ~this.predicate.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Predicates.not(");
        Predicate predicate = this.predicate;
        stringBuilder.append(predicate);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

