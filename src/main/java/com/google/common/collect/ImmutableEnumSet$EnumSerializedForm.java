/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableEnumSet;
import java.io.Serializable;
import java.util.EnumSet;

public class ImmutableEnumSet$EnumSerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final EnumSet delegate;

    public ImmutableEnumSet$EnumSerializedForm(EnumSet enumSet) {
        this.delegate = enumSet;
    }

    public Object readResolve() {
        Object object = this.delegate.clone();
        ImmutableEnumSet immutableEnumSet = new ImmutableEnumSet((EnumSet)object, null);
        return immutableEnumSet;
    }
}

