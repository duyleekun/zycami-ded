/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import com.google.gson.internal.LinkedHashTreeMap$EntrySet;
import com.google.gson.internal.LinkedHashTreeMap$LinkedTreeMapIterator;
import java.util.Map;

public class LinkedHashTreeMap$EntrySet$1
extends LinkedHashTreeMap$LinkedTreeMapIterator {
    public final /* synthetic */ LinkedHashTreeMap$EntrySet this$1;

    public LinkedHashTreeMap$EntrySet$1(LinkedHashTreeMap$EntrySet object) {
        this.this$1 = object;
        object = ((LinkedHashTreeMap$EntrySet)object).this$0;
        super((LinkedHashTreeMap)object);
    }

    public Map.Entry next() {
        return this.nextNode();
    }
}

