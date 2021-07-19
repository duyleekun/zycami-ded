/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;

public class Predicates$CompositionPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    public final Function f;
    public final Predicate p;

    private Predicates$CompositionPredicate(Predicate object, Function function) {
        object = (Predicate)Preconditions.checkNotNull(object);
        this.p = object;
        this.f = object = (Function)Preconditions.checkNotNull(function);
    }

    public /* synthetic */ Predicates$CompositionPredicate(Predicate predicate, Function function, Predicates$1 predicates$1) {
        this(predicate, function);
    }

    public boolean apply(Object object) {
        Predicate predicate = this.p;
        object = this.f.apply(object);
        return predicate.apply(object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Predicates$CompositionPredicate;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Predicates$CompositionPredicate)object;
            Object object2 = this.f;
            Function function = ((Predicates$CompositionPredicate)object).f;
            bl2 = object2.equals(function);
            if (bl2 && (bl4 = (object2 = this.p).equals(object = ((Predicates$CompositionPredicate)object).p))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.f.hashCode();
        int n11 = this.p.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.p;
        stringBuilder.append(object);
        stringBuilder.append("(");
        object = this.f;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

