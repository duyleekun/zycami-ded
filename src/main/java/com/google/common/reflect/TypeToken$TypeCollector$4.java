/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

public final class TypeToken$TypeCollector$4
extends Ordering {
    public final /* synthetic */ Map val$map;
    public final /* synthetic */ Comparator val$valueComparator;

    public TypeToken$TypeCollector$4(Comparator comparator, Map map) {
        this.val$valueComparator = comparator;
        this.val$map = map;
    }

    public int compare(Object object, Object object2) {
        Comparator comparator = this.val$valueComparator;
        object = this.val$map.get(object);
        object2 = this.val$map.get(object2);
        return comparator.compare(object, object2);
    }
}

