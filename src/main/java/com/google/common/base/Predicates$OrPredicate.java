/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import java.util.List;

public class Predicates$OrPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    private final List components;

    private Predicates$OrPredicate(List list) {
        this.components = list;
    }

    public /* synthetic */ Predicates$OrPredicate(List list, Predicates$1 predicates$1) {
        this(list);
    }

    public boolean apply(Object object) {
        Object object2;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object2 = this.components).size()); ++i10) {
            object2 = (Predicate)this.components.get(i10);
            n10 = (int)(object2.apply(object) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Predicates$OrPredicate;
        if (bl2) {
            object = (Predicates$OrPredicate)object;
            List list = this.components;
            object = ((Predicates$OrPredicate)object).components;
            return list.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.components.hashCode() + 87855567;
    }

    public String toString() {
        List list = this.components;
        return Predicates.access$800("or", list);
    }
}

