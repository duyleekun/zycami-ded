/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import com.google.gson.internal.LinkedHashTreeMap$KeySet$1;
import java.util.AbstractSet;
import java.util.Iterator;

public final class LinkedHashTreeMap$KeySet
extends AbstractSet {
    public final /* synthetic */ LinkedHashTreeMap this$0;

    public LinkedHashTreeMap$KeySet(LinkedHashTreeMap linkedHashTreeMap) {
        this.this$0 = linkedHashTreeMap;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    public Iterator iterator() {
        LinkedHashTreeMap$KeySet$1 linkedHashTreeMap$KeySet$1 = new LinkedHashTreeMap$KeySet$1(this);
        return linkedHashTreeMap$KeySet$1;
    }

    public boolean remove(Object object) {
        boolean bl2;
        LinkedHashTreeMap linkedHashTreeMap = this.this$0;
        if ((object = linkedHashTreeMap.removeInternalByKey(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int size() {
        return this.this$0.size;
    }
}

