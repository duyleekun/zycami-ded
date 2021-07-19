/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap$2;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

public class MutableClassToInstanceMap$2$1
extends TransformedIterator {
    public final /* synthetic */ MutableClassToInstanceMap.2 this$1;

    public MutableClassToInstanceMap$2$1(MutableClassToInstanceMap.2 var1_1, Iterator iterator2) {
        this.this$1 = var1_1;
        super(iterator2);
    }

    public Map.Entry transform(Map.Entry entry) {
        return MutableClassToInstanceMap.checkedEntry(entry);
    }
}

