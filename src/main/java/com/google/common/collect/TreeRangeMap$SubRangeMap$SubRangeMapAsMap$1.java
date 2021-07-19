/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Map;

public class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1
extends Maps$KeySet {
    public final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

    public TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap, Map map) {
        this.this$2 = treeRangeMap$SubRangeMap$SubRangeMapAsMap;
        super(map);
    }

    public boolean remove(Object object) {
        boolean bl2;
        TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap = this.this$2;
        if ((object = treeRangeMap$SubRangeMap$SubRangeMapAsMap.remove(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean retainAll(Collection object) {
        TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap = this.this$2;
        object = Predicates.not(Predicates.in((Collection)object));
        Function function = Maps.keyFunction();
        object = Predicates.compose((Predicate)object, function);
        return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$400(treeRangeMap$SubRangeMap$SubRangeMapAsMap, (Predicate)object);
    }
}

