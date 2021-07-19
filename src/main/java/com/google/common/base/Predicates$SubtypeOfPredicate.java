/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;

public class Predicates$SubtypeOfPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    private final Class clazz;

    private Predicates$SubtypeOfPredicate(Class clazz) {
        this.clazz = clazz = (Class)Preconditions.checkNotNull(clazz);
    }

    public /* synthetic */ Predicates$SubtypeOfPredicate(Class clazz, Predicates$1 predicates$1) {
        this(clazz);
    }

    public boolean apply(Class clazz) {
        return this.clazz.isAssignableFrom(clazz);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Predicates$SubtypeOfPredicate;
        boolean bl3 = false;
        if (bl2) {
            object = (Predicates$SubtypeOfPredicate)object;
            Class clazz = this.clazz;
            object = ((Predicates$SubtypeOfPredicate)object).clazz;
            if (clazz == object) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Predicates.subtypeOf(");
        String string2 = this.clazz.getName();
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

