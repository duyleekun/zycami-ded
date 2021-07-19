/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$KeySet$1;
import java.util.AbstractSet;
import java.util.Iterator;

public final class LinkedTreeMap$KeySet
extends AbstractSet {
    public final /* synthetic */ LinkedTreeMap this$0;

    public LinkedTreeMap$KeySet(LinkedTreeMap linkedTreeMap) {
        this.this$0 = linkedTreeMap;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    public Iterator iterator() {
        LinkedTreeMap$KeySet$1 linkedTreeMap$KeySet$1 = new LinkedTreeMap$KeySet$1(this);
        return linkedTreeMap$KeySet$1;
    }

    public boolean remove(Object object) {
        boolean bl2;
        LinkedTreeMap linkedTreeMap = this.this$0;
        if ((object = linkedTreeMap.removeInternalByKey(object)) != null) {
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

