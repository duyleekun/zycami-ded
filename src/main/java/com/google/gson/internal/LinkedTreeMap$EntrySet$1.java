/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$EntrySet;
import com.google.gson.internal.LinkedTreeMap$LinkedTreeMapIterator;
import java.util.Map;

public class LinkedTreeMap$EntrySet$1
extends LinkedTreeMap$LinkedTreeMapIterator {
    public final /* synthetic */ LinkedTreeMap$EntrySet this$1;

    public LinkedTreeMap$EntrySet$1(LinkedTreeMap$EntrySet object) {
        this.this$1 = object;
        object = ((LinkedTreeMap$EntrySet)object).this$0;
        super((LinkedTreeMap)object);
    }

    public Map.Entry next() {
        return this.nextNode();
    }
}

