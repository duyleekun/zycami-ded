/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.SortedSet;

public final class Maps$5
extends ForwardingSortedSet {
    public final /* synthetic */ SortedSet val$set;

    public Maps$5(SortedSet sortedSet) {
        this.val$set = sortedSet;
    }

    public boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public SortedSet delegate() {
        return this.val$set;
    }

    public SortedSet headSet(Object object) {
        return Maps.access$300(super.headSet(object));
    }

    public SortedSet subSet(Object object, Object object2) {
        return Maps.access$300(super.subSet(object, object2));
    }

    public SortedSet tailSet(Object object) {
        return Maps.access$300(super.tailSet(object));
    }
}

