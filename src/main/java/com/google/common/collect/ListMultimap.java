/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Map;

public interface ListMultimap
extends Multimap {
    public Map asMap();

    public boolean equals(Object var1);

    public List get(Object var1);

    public List removeAll(Object var1);

    public List replaceValues(Object var1, Iterable var2);
}

