/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableEnumMap;
import java.io.Serializable;
import java.util.EnumMap;

public class ImmutableEnumMap$EnumSerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final EnumMap delegate;

    public ImmutableEnumMap$EnumSerializedForm(EnumMap enumMap) {
        this.delegate = enumMap;
    }

    public Object readResolve() {
        EnumMap enumMap = this.delegate;
        ImmutableEnumMap immutableEnumMap = new ImmutableEnumMap(enumMap, null);
        return immutableEnumMap;
    }
}

