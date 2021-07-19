/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.SortedSet;

public final class Maps$6
extends ForwardingNavigableSet {
    public final /* synthetic */ NavigableSet val$set;

    public Maps$6(NavigableSet navigableSet) {
        this.val$set = navigableSet;
    }

    public boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public NavigableSet delegate() {
        return this.val$set;
    }

    public NavigableSet descendingSet() {
        return Maps.access$400(super.descendingSet());
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return Maps.access$400(super.headSet(object, bl2));
    }

    public SortedSet headSet(Object object) {
        return Maps.access$300(super.headSet(object));
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return Maps.access$400(super.subSet(object, bl2, object2, bl3));
    }

    public SortedSet subSet(Object object, Object object2) {
        return Maps.access$300(super.subSet(object, object2));
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return Maps.access$400(super.tailSet(object, bl2));
    }

    public SortedSet tailSet(Object object) {
        return Maps.access$300(super.tailSet(object));
    }
}

