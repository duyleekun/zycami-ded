/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import java.util.Map;

public interface TypeToInstanceMap
extends Map {
    public Object getInstance(TypeToken var1);

    public Object getInstance(Class var1);

    public Object putInstance(TypeToken var1, Object var2);

    public Object putInstance(Class var1, Object var2);
}

