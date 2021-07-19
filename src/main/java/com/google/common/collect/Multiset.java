/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface Multiset
extends Collection {
    public int add(Object var1, int var2);

    public boolean add(Object var1);

    public boolean contains(Object var1);

    public boolean containsAll(Collection var1);

    public int count(Object var1);

    public Set elementSet();

    public Set entrySet();

    public boolean equals(Object var1);

    public int hashCode();

    public Iterator iterator();

    public int remove(Object var1, int var2);

    public boolean remove(Object var1);

    public boolean removeAll(Collection var1);

    public boolean retainAll(Collection var1);

    public int setCount(Object var1, int var2);

    public boolean setCount(Object var1, int var2, int var3);

    public int size();

    public String toString();
}

