/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

public final class Maps$1
extends TransformedIterator {
    public Maps$1(Iterator iterator2) {
        super(iterator2);
    }

    public Object transform(Map.Entry entry) {
        return entry.getKey();
    }
}

