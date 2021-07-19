/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableBiMap$Builder;
import com.google.common.collect.ImmutableMap$SerializedForm;

public class ImmutableBiMap$SerializedForm
extends ImmutableMap$SerializedForm {
    private static final long serialVersionUID;

    public ImmutableBiMap$SerializedForm(ImmutableBiMap immutableBiMap) {
        super(immutableBiMap);
    }

    public Object readResolve() {
        ImmutableBiMap$Builder immutableBiMap$Builder = new ImmutableBiMap$Builder();
        return this.createMap(immutableBiMap$Builder);
    }
}

