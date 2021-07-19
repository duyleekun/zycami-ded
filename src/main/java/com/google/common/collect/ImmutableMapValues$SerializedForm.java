/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;

public class ImmutableMapValues$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final ImmutableMap map;

    public ImmutableMapValues$SerializedForm(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    public Object readResolve() {
        return this.map.values();
    }
}

