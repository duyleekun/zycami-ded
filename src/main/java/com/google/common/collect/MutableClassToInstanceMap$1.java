/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.MutableClassToInstanceMap;
import java.util.Map;

public final class MutableClassToInstanceMap$1
extends ForwardingMapEntry {
    public final /* synthetic */ Map.Entry val$entry;

    public MutableClassToInstanceMap$1(Map.Entry entry) {
        this.val$entry = entry;
    }

    public Map.Entry delegate() {
        return this.val$entry;
    }

    public Object setValue(Object object) {
        object = MutableClassToInstanceMap.access$000((Class)this.getKey(), object);
        return super.setValue(object);
    }
}

