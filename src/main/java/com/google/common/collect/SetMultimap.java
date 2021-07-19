/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import java.util.Map;
import java.util.Set;

public interface SetMultimap
extends Multimap {
    public Map asMap();

    public Set entries();

    public boolean equals(Object var1);

    public Set get(Object var1);

    public Set removeAll(Object var1);

    public Set replaceValues(Object var1, Iterable var2);
}

