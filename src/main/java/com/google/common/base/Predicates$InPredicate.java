/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import java.util.Collection;

public class Predicates$InPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    private final Collection target;

    private Predicates$InPredicate(Collection collection) {
        this.target = collection = (Collection)Preconditions.checkNotNull(collection);
    }

    public /* synthetic */ Predicates$InPredicate(Collection collection, Predicates$1 predicates$1) {
        this(collection);
    }

    public boolean apply(Object object) {
        Collection collection = this.target;
        try {
            return collection.contains(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Predicates$InPredicate;
        if (bl2) {
            object = (Predicates$InPredicate)object;
            Collection collection = this.target;
            object = ((Predicates$InPredicate)object).target;
            return collection.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Predicates.in(");
        Collection collection = this.target;
        stringBuilder.append(collection);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

