/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView$1EntrySetImpl;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Set;

public class Maps$AsMapView
extends Maps$ViewCachingAbstractMap {
    public final Function function;
    private final Set set;

    public Maps$AsMapView(Set object, Function function) {
        object = (Set)Preconditions.checkNotNull(object);
        this.set = object;
        this.function = object = (Function)Preconditions.checkNotNull(function);
    }

    public Set backingSet() {
        return this.set;
    }

    public void clear() {
        this.backingSet().clear();
    }

    public boolean containsKey(Object object) {
        return this.backingSet().contains(object);
    }

    public Set createEntrySet() {
        Maps$AsMapView$1EntrySetImpl maps$AsMapView$1EntrySetImpl = new Maps$AsMapView$1EntrySetImpl(this);
        return maps$AsMapView$1EntrySetImpl;
    }

    public Set createKeySet() {
        return Maps.access$200(this.backingSet());
    }

    public Collection createValues() {
        Set set = this.set;
        Function function = this.function;
        return Collections2.transform(set, function);
    }

    public Object get(Object object) {
        Set set = this.backingSet();
        boolean bl2 = Collections2.safeContains(set, object);
        if (bl2) {
            return this.function.apply(object);
        }
        return null;
    }

    public Object remove(Object object) {
        Set set = this.backingSet();
        boolean bl2 = set.remove(object);
        if (bl2) {
            return this.function.apply(object);
        }
        return null;
    }

    public int size() {
        return this.backingSet().size();
    }
}

