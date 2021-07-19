/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

public class Functions$PredicateFunction
implements Function,
Serializable {
    private static final long serialVersionUID;
    private final Predicate predicate;

    private Functions$PredicateFunction(Predicate predicate) {
        this.predicate = predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    public /* synthetic */ Functions$PredicateFunction(Predicate predicate, Functions$1 functions$1) {
        this(predicate);
    }

    public Boolean apply(Object object) {
        return this.predicate.apply(object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Functions$PredicateFunction;
        if (bl2) {
            object = (Functions$PredicateFunction)object;
            Predicate predicate = this.predicate;
            object = ((Functions$PredicateFunction)object).predicate;
            return predicate.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Functions.forPredicate(");
        Predicate predicate = this.predicate;
        stringBuilder.append(predicate);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

