/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

public final class Equivalence$EquivalentToPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    private final Equivalence equivalence;
    private final Object target;

    public Equivalence$EquivalentToPredicate(Equivalence equivalence, Object object) {
        this.equivalence = equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.target = object;
    }

    public boolean apply(Object object) {
        Equivalence equivalence = this.equivalence;
        Object object2 = this.target;
        return equivalence.equivalent(object, object2);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof Equivalence$EquivalentToPredicate;
        if (bl3) {
            boolean bl4;
            object = (Equivalence$EquivalentToPredicate)object;
            Object object2 = this.equivalence;
            Equivalence equivalence = ((Equivalence$EquivalentToPredicate)object).equivalence;
            bl3 = object2.equals(equivalence);
            if (!bl3 || !(bl4 = Objects.equal(object2 = this.target, object = ((Equivalence$EquivalentToPredicate)object).target))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.equivalence;
        object = this.target;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.equivalence;
        stringBuilder.append(object);
        stringBuilder.append(".equivalentTo(");
        object = this.target;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

