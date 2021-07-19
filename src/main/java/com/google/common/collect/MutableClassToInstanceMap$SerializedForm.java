/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MutableClassToInstanceMap;
import java.io.Serializable;
import java.util.Map;

public final class MutableClassToInstanceMap$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    private final Map backingMap;

    public MutableClassToInstanceMap$SerializedForm(Map map) {
        this.backingMap = map;
    }

    public Object readResolve() {
        return MutableClassToInstanceMap.create(this.backingMap);
    }
}

