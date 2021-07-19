/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Equivalence$Equals;
import com.google.common.base.Equivalence$EquivalentToPredicate;
import com.google.common.base.Equivalence$Identity;
import com.google.common.base.Equivalence$Wrapper;
import com.google.common.base.Function;
import com.google.common.base.FunctionalEquivalence;
import com.google.common.base.PairwiseEquivalence;
import com.google.common.base.Predicate;

public abstract class Equivalence {
    public static Equivalence equals() {
        return Equivalence$Equals.INSTANCE;
    }

    public static Equivalence identity() {
        return Equivalence$Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(Object var1, Object var2);

    public abstract int doHash(Object var1);

    public final boolean equivalent(Object object, Object object2) {
        if (object == object2) {
            return true;
        }
        if (object != null && object2 != null) {
            return this.doEquivalent(object, object2);
        }
        return false;
    }

    public final Predicate equivalentTo(Object object) {
        Equivalence$EquivalentToPredicate equivalence$EquivalentToPredicate = new Equivalence$EquivalentToPredicate(this, object);
        return equivalence$EquivalentToPredicate;
    }

    public final int hash(Object object) {
        if (object == null) {
            return 0;
        }
        return this.doHash(object);
    }

    public final Equivalence onResultOf(Function function) {
        FunctionalEquivalence functionalEquivalence = new FunctionalEquivalence(function, this);
        return functionalEquivalence;
    }

    public final Equivalence pairwise() {
        PairwiseEquivalence pairwiseEquivalence = new PairwiseEquivalence(this);
        return pairwiseEquivalence;
    }

    public final Equivalence$Wrapper wrap(Object object) {
        Equivalence$Wrapper equivalence$Wrapper = new Equivalence$Wrapper(this, object, null);
        return equivalence$Wrapper;
    }
}

