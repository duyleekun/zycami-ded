/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Column;
import java.util.Collection;

public class StandardTable$Column$KeySet
extends Maps$KeySet {
    public final /* synthetic */ StandardTable$Column this$1;

    public StandardTable$Column$KeySet(StandardTable$Column standardTable$Column) {
        this.this$1 = standardTable$Column;
        super(standardTable$Column);
    }

    public boolean contains(Object object) {
        Object object2 = this.this$1;
        StandardTable standardTable = ((StandardTable$Column)object2).this$0;
        object2 = ((StandardTable$Column)object2).columnKey;
        return standardTable.contains(object, object2);
    }

    public boolean remove(Object object) {
        boolean bl2;
        Object object2 = this.this$1;
        StandardTable standardTable = ((StandardTable$Column)object2).this$0;
        object2 = ((StandardTable$Column)object2).columnKey;
        if ((object = standardTable.remove(object, object2)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean retainAll(Collection object) {
        StandardTable$Column standardTable$Column = this.this$1;
        object = Maps.keyPredicateOnEntries(Predicates.not(Predicates.in((Collection)object)));
        return standardTable$Column.removeFromColumnIf((Predicate)object);
    }
}

