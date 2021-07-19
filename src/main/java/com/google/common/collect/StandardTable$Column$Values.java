/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.StandardTable$Column;
import java.util.Collection;

public class StandardTable$Column$Values
extends Maps$Values {
    public final /* synthetic */ StandardTable$Column this$1;

    public StandardTable$Column$Values(StandardTable$Column standardTable$Column) {
        this.this$1 = standardTable$Column;
        super(standardTable$Column);
    }

    public boolean remove(Object object) {
        StandardTable$Column standardTable$Column;
        boolean bl2;
        if (object != null && (bl2 = (standardTable$Column = this.this$1).removeFromColumnIf((Predicate)(object = Maps.valuePredicateOnEntries(Predicates.equalTo(object)))))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean removeAll(Collection object) {
        StandardTable$Column standardTable$Column = this.this$1;
        object = Maps.valuePredicateOnEntries(Predicates.in((Collection)object));
        return standardTable$Column.removeFromColumnIf((Predicate)object);
    }

    public boolean retainAll(Collection object) {
        StandardTable$Column standardTable$Column = this.this$1;
        object = Maps.valuePredicateOnEntries(Predicates.not(Predicates.in((Collection)object)));
        return standardTable$Column.removeFromColumnIf((Predicate)object);
    }
}

