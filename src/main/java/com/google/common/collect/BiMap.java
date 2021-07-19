/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Map;
import java.util.Set;

public interface BiMap
extends Map {
    public Object forcePut(Object var1, Object var2);

    public BiMap inverse();

    public Object put(Object var1, Object var2);

    public void putAll(Map var1);

    public Set values();
}

