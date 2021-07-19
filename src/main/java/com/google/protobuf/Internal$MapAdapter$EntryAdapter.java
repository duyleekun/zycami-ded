/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$MapAdapter;
import com.google.protobuf.Internal$MapAdapter$Converter;
import java.util.Map;

public class Internal$MapAdapter$EntryAdapter
implements Map.Entry {
    private final Map.Entry realEntry;
    public final /* synthetic */ Internal$MapAdapter this$0;

    public Internal$MapAdapter$EntryAdapter(Internal$MapAdapter mapAdapter, Map.Entry entry) {
        this.this$0 = mapAdapter;
        this.realEntry = entry;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Map.Entry;
        if (!bl3) {
            return false;
        }
        object = (Map.Entry)object;
        Object object2 = this.getKey();
        boolean bl4 = object2.equals(object = object.getKey());
        if (!bl4 || !(bl4 = (object = this.getValue()).equals(object2 = this.getValue()))) {
            bl2 = false;
        }
        return bl2;
    }

    public Object getKey() {
        return this.realEntry.getKey();
    }

    public Object getValue() {
        Internal$MapAdapter$Converter internal$MapAdapter$Converter = Internal$MapAdapter.access$000(this.this$0);
        Object v10 = this.realEntry.getValue();
        return internal$MapAdapter$Converter.doForward(v10);
    }

    public int hashCode() {
        return this.realEntry.hashCode();
    }

    public Object setValue(Object object) {
        Map.Entry entry = this.realEntry;
        Internal$MapAdapter$Converter internal$MapAdapter$Converter = Internal$MapAdapter.access$000(this.this$0);
        object = internal$MapAdapter$Converter.doBackward(object);
        if ((object = entry.setValue(object)) == null) {
            return null;
        }
        return Internal$MapAdapter.access$000(this.this$0).doForward(object);
    }
}

