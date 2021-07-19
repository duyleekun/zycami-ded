/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;

public class ImmutableMapEntrySet$EntrySetSerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final ImmutableMap map;

    public ImmutableMapEntrySet$EntrySetSerializedForm(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    public Object readResolve() {
        return this.map.entrySet();
    }
}

