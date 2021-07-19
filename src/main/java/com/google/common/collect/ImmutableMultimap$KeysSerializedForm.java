/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap;
import java.io.Serializable;

public final class ImmutableMultimap$KeysSerializedForm
implements Serializable {
    public final ImmutableMultimap multimap;

    public ImmutableMultimap$KeysSerializedForm(ImmutableMultimap immutableMultimap) {
        this.multimap = immutableMultimap;
    }

    public Object readResolve() {
        return this.multimap.keys();
    }
}

