/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.SmallSortedMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class SmallSortedMap$1
extends SmallSortedMap {
    public SmallSortedMap$1(int n10) {
        super(n10, null);
    }

    public void makeImmutable() {
        int n10 = this.isImmutable();
        if (n10 == 0) {
            boolean bl2;
            Object object;
            Map.Entry entry;
            int n11;
            Iterator iterator2 = null;
            for (n10 = 0; n10 < (n11 = this.getNumArrayEntries()); ++n10) {
                entry = this.getArrayEntryAt(n10);
                object = (FieldSet$FieldDescriptorLite)entry.getKey();
                bl2 = object.isRepeated();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
            iterator2 = this.getOverflowEntries().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                entry = (Map.Entry)iterator2.next();
                object = (FieldSet$FieldDescriptorLite)entry.getKey();
                bl2 = object.isRepeated();
                if (!bl2) continue;
                object = Collections.unmodifiableList((List)entry.getValue());
                entry.setValue(object);
            }
        }
        super.makeImmutable();
    }
}

