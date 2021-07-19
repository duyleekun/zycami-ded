/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$1;
import com.google.protobuf.MessageLite;
import java.util.Map;

public class LazyField$LazyEntry
implements Map.Entry {
    private Map.Entry entry;

    private LazyField$LazyEntry(Map.Entry entry) {
        this.entry = entry;
    }

    public /* synthetic */ LazyField$LazyEntry(Map.Entry entry, LazyField$1 lazyField$1) {
        this(entry);
    }

    public LazyField getField() {
        return (LazyField)this.entry.getValue();
    }

    public Object getKey() {
        return this.entry.getKey();
    }

    public Object getValue() {
        LazyField lazyField = (LazyField)this.entry.getValue();
        if (lazyField == null) {
            return null;
        }
        return lazyField.getValue();
    }

    public Object setValue(Object object) {
        boolean bl2 = object instanceof MessageLite;
        if (bl2) {
            LazyField lazyField = (LazyField)this.entry.getValue();
            object = (MessageLite)object;
            return lazyField.setValue((MessageLite)object);
        }
        object = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        throw object;
    }
}

