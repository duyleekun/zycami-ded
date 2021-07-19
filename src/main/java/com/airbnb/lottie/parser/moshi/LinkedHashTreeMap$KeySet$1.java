/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$KeySet;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$LinkedTreeMapIterator;

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

