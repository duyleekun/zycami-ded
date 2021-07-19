/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Multimap {
    public Map asMap();

    public void clear();

    public boolean containsEntry(Object var1, Object var2);

    public boolean containsKey(Object var1);

    public boolean containsValue(Object var1);

    public Collection entries();

    public boolean equals(Object var1);

    public Collection get(Object var1);

    public int hashCode();

    public boolean isEmpty();

    public Set keySet();

    public Multiset keys();

    public boolean put(Object var1, Object var2);

    public boolean putAll(Multimap var1);

    public boolean putAll(Object var1, Iterable var2);

    public boolean remove(Object var1, Object var2);

    public Collection removeAll(Object var1);

    public Collection replaceValues(Object var1, Iterable var2);

    public int size();

    public Collection values();
}

