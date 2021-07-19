/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$EntrySet$1;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$Node;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class LinkedHashTreeMap$EntrySet
extends AbstractSet {
    public final /* synthetic */ LinkedHashTreeMap this$0;

    public LinkedHashTreeMap$EntrySet(LinkedHashTreeMap linkedHashTreeMap) {
        this.this$0 = linkedHashTreeMap;
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
        LinkedHashTreeMap linkedHashTreeMap = this.this$0;
        object = (Map.Entry)object;
        if ((object = linkedHashTreeMap.findByEntry((Map.Entry)object)) == null) return false;
        return true;
    }

    public Iterator iterator() {
        LinkedHashTreeMap$EntrySet$1 linkedHashTreeMap$EntrySet$1 = new LinkedHashTreeMap$EntrySet$1(this);
        return linkedHashTreeMap$EntrySet$1;
    }

    public boolean remove(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        LinkedHashTreeMap linkedHashTreeMap = this.this$0;
        object = (Map.Entry)object;
        if ((object = linkedHashTreeMap.findByEntry((Map.Entry)object)) == null) {
            return false;
        }
        linkedHashTreeMap = this.this$0;
        bl3 = true;
        linkedHashTreeMap.removeInternal((LinkedHashTreeMap$Node)object, bl3);
        return bl3;
    }

    public int size() {
        return this.this$0.size;
    }
}

