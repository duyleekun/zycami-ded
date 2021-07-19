/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import java.util.Map;

public class AbstractBiMap$BiMapEntry
extends ForwardingMapEntry {
    private final Map.Entry delegate;
    public final /* synthetic */ AbstractBiMap this$0;

    public AbstractBiMap$BiMapEntry(AbstractBiMap abstractBiMap, Map.Entry entry) {
        this.this$0 = abstractBiMap;
        this.delegate = entry;
    }

    public Map.Entry delegate() {
        return this.delegate;
    }

    public Object setValue(Object object) {
        this.this$0.checkValue(object);
        boolean bl2 = this.this$0.entrySet().contains(this);
        Object object2 = "entry no longer in map";
        Preconditions.checkState(bl2, object2);
        Object object3 = this.getValue();
        bl2 = Objects.equal(object, object3);
        if (bl2) {
            return object;
        }
        bl2 = this.this$0.containsValue(object);
        boolean bl3 = true;
        Preconditions.checkArgument(bl2 ^ bl3, "value already present: %s", object);
        object3 = this.delegate.setValue(object);
        Object object4 = this.this$0;
        Object object5 = this.getKey();
        object4 = ((ForwardingMap)object4).get(object5);
        Preconditions.checkState(Objects.equal(object, object4), object2);
        object2 = this.this$0;
        object4 = this.getKey();
        AbstractBiMap.access$500((AbstractBiMap)object2, object4, bl3, object3, object);
        return object3;
    }
}

