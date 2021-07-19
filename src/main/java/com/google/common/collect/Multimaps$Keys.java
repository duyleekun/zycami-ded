/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Keys$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Multimaps$Keys
extends AbstractMultiset {
    public final Multimap multimap;

    public Multimaps$Keys(Multimap multimap) {
        this.multimap = multimap;
    }

    public void clear() {
        this.multimap.clear();
    }

    public boolean contains(Object object) {
        return this.multimap.containsKey(object);
    }

    public int count(Object object) {
        int n10;
        Map map = this.multimap.asMap();
        object = (Collection)Maps.safeGet(map, object);
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.size();
        }
        return n10;
    }

    public int distinctElements() {
        return this.multimap.asMap().size();
    }

    public Iterator elementIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public Set elementSet() {
        return this.multimap.keySet();
    }

    public Iterator entryIterator() {
        Iterator iterator2 = this.multimap.asMap().entrySet().iterator();
        Multimaps$Keys$1 multimaps$Keys$1 = new Multimaps$Keys$1(this, iterator2);
        return multimaps$Keys$1;
    }

    public Iterator iterator() {
        return Maps.keyIterator(this.multimap.entries().iterator());
    }

    public int remove(Object iterator2, int n10) {
        String string2 = "occurrences";
        CollectPreconditions.checkNonnegative(n10, string2);
        if (n10 == 0) {
            return this.count(iterator2);
        }
        iterator2 = (Collection)Maps.safeGet(this.multimap.asMap(), iterator2);
        string2 = null;
        if (iterator2 == null) {
            return 0;
        }
        int n11 = iterator2.size();
        if (n10 >= n11) {
            iterator2.clear();
        } else {
            iterator2 = iterator2.iterator();
            for (int i10 = 0; i10 < n10; ++i10) {
                iterator2.next();
                iterator2.remove();
            }
        }
        return n11;
    }

    public int size() {
        return this.multimap.size();
    }
}

