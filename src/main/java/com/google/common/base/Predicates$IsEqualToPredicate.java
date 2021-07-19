/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;

public class Predicates$IsEqualToPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    private final Object target;

    private Predicates$IsEqualToPredicate(Object object) {
        this.target = object;
    }

    public /* synthetic */ Predicates$IsEqualToPredicate(Object object, Predicates$1 predicates$1) {
        this(object);
    }

    public boolean apply(Object object) {
        return this.target.equals(object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Predicates$IsEqualToPredicate;
        if (bl2) {
            object = (Predicates$IsEqualToPredicate)object;
            Object object2 = this.target;
            object = ((Predicates$IsEqualToPredicate)object).target;
            return object2.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Predicates.equalTo(");
        Object object = this.target;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

