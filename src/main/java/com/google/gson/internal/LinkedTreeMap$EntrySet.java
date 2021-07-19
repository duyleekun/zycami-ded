/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$EntrySet$1;
import com.google.gson.internal.LinkedTreeMap$Node;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class LinkedTreeMap$EntrySet
extends AbstractSet {
    public final /* synthetic */ LinkedTreeMap this$0;

    public LinkedTreeMap$EntrySet(LinkedTreeMap linkedTreeMap) {
        this.this$0 = linkedTreeMap;
    }

    public void clear() {
        this.this$0.clear();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (!bl2) return false;
        LinkedTreeMap linkedTreeMap = this.this$0;
        object = (Map.Entry)object;
        if ((object = linkedTreeMap.findByEntry((Map.Entry)object)) == null) return false;
        return true;
    }

    public Iterator iterator() {
        LinkedTreeMap$EntrySet$1 linkedTreeMap$EntrySet$1 = new LinkedTreeMap$EntrySet$1(this);
        return linkedTreeMap$EntrySet$1;
    }

    public boolean remove(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        LinkedTreeMap linkedTreeMap = this.this$0;
        object = (Map.Entry)object;
        if ((object = linkedTreeMap.findByEntry((Map.Entry)object)) == null) {
            return false;
        }
        linkedTreeMap = this.this$0;
        bl3 = true;
        linkedTreeMap.removeInternal((LinkedTreeMap$Node)object, bl3);
        return bl3;
    }

    public int size() {
        return this.this$0.size;
    }
}

