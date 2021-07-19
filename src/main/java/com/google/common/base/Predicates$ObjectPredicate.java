/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import com.google.common.base.Predicates$ObjectPredicate$1;
import com.google.common.base.Predicates$ObjectPredicate$2;
import com.google.common.base.Predicates$ObjectPredicate$3;
import com.google.common.base.Predicates$ObjectPredicate$4;

public abstract class Predicates$ObjectPredicate
extends Enum
implements Predicate {
    private static final /* synthetic */ Predicates$ObjectPredicate[] $VALUES;
    public static final /* enum */ Predicates$ObjectPredicate ALWAYS_FALSE;
    public static final /* enum */ Predicates$ObjectPredicate ALWAYS_TRUE;
    public static final /* enum */ Predicates$ObjectPredicate IS_NULL;
    public static final /* enum */ Predicates$ObjectPredicate NOT_NULL;

    static {
        Predicates$ObjectPredicate$1 predicates$ObjectPredicate$1 = new Predicates$ObjectPredicate$1();
        ALWAYS_TRUE = predicates$ObjectPredicate$1;
        int n10 = 1;
        Predicates$ObjectPredicate$2 predicates$ObjectPredicate$2 = new Predicates$ObjectPredicate$2();
        ALWAYS_FALSE = predicates$ObjectPredicate$2;
        int n11 = 2;
        Predicates$ObjectPredicate$3 predicates$ObjectPredicate$3 = new Predicates$ObjectPredicate$3();
        IS_NULL = predicates$ObjectPredicate$3;
        int n12 = 3;
        Predicates$ObjectPredicate$4 predicates$ObjectPredicate$4 = new Predicates$ObjectPredicate$4();
        NOT_NULL = predicates$ObjectPredicate$4;
        Predicates$ObjectPredicate[] predicates$ObjectPredicateArray = new Predicates$ObjectPredicate[4];
        predicates$ObjectPredicateArray[0] = predicates$ObjectPredicate$1;
        predicates$ObjectPredicateArray[n10] = predicates$ObjectPredicate$2;
        predicates$ObjectPredicateArray[n11] = predicates$ObjectPredicate$3;
        predicates$ObjectPredicateArray[n12] = predicates$ObjectPredicate$4;
        $VALUES = predicates$ObjectPredicateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Predicates$ObjectPredicate() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ Predicates$ObjectPredicate(Predicates$1 predicates$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static Predicates$ObjectPredicate valueOf(String string2) {
        return Enum.valueOf(Predicates$ObjectPredicate.class, string2);
    }

    public static Predicates$ObjectPredicate[] values() {
        return (Predicates$ObjectPredicate[])$VALUES.clone();
    }

    public Predicate withNarrowedType() {
        return this;
    }
}

