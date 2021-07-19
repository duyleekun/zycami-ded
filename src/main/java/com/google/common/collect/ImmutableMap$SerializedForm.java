/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import java.io.Serializable;
import java.util.Map;

public class ImmutableMap$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    private final Object[] keys;
    private final Object[] values;

    public ImmutableMap$SerializedForm(ImmutableMap object) {
        boolean bl2;
        Object[] objectArray = new Object[object.size()];
        this.keys = objectArray;
        objectArray = new Object[object.size()];
        this.values = objectArray;
        object = ((ImmutableMap)object).entrySet().iterator();
        int n10 = 0;
        objectArray = null;
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object[] objectArray2 = this.keys;
            Object k10 = entry.getKey();
            objectArray2[n10] = k10;
            objectArray2 = this.values;
            entry = entry.getValue();
            objectArray2[n10] = entry;
            ++n10;
        }
    }

    public Object createMap(ImmutableMap$Builder immutableMap$Builder) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((Object[])(object = this.keys)).length); ++i10) {
            object = object[i10];
            Object object2 = this.values[i10];
            immutableMap$Builder.put(object, object2);
        }
        return immutableMap$Builder.build();
    }

    public Object readResolve() {
        int n10 = this.keys.length;
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(n10);
        return this.createMap(immutableMap$Builder);
    }
}

