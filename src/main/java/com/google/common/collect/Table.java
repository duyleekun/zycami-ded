/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Table {
    public Set cellSet();

    public void clear();

    public Map column(Object var1);

    public Set columnKeySet();

    public Map columnMap();

    public boolean contains(Object var1, Object var2);

    public boolean containsColumn(Object var1);

    public boolean containsRow(Object var1);

    public boolean containsValue(Object var1);

    public boolean equals(Object var1);

    public Object get(Object var1, Object var2);

    public int hashCode();

    public boolean isEmpty();

    public Object put(Object var1, Object var2, Object var3);

    public void putAll(Table var1);

    public Object remove(Object var1, Object var2);

    public Map row(Object var1);

    public Set rowKeySet();

    public Map rowMap();

    public int size();

    public Collection values();
}

