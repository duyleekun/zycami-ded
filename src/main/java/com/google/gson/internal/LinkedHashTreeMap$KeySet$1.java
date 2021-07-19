/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import com.google.gson.internal.LinkedHashTreeMap$KeySet;
import com.google.gson.internal.LinkedHashTreeMap$LinkedTreeMapIterator;

public class LinkedHashTreeMap$KeySet$1
extends LinkedHashTreeMap$LinkedTreeMapIterator {
    public final /* synthetic */ LinkedHashTreeMap$KeySet this$1;

    public LinkedHashTreeMap$KeySet$1(LinkedHashTreeMap$KeySet object) {
        this.this$1 = object;
        object = ((LinkedHashTreeMap$KeySet)object).this$0;
        super((LinkedHashTreeMap)object);
    }

    public Object next() {
        return this.nextNode().key;
    }
}

