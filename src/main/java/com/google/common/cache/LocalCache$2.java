/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.collect.ImmutableSet;
import java.util.AbstractQueue;
import java.util.Iterator;

public final class LocalCache$2
extends AbstractQueue {
    public Iterator iterator() {
        return ImmutableSet.of().iterator();
    }

    public boolean offer(Object object) {
        return true;
    }

    public Object peek() {
        return null;
    }

    public Object poll() {
        return null;
    }

    public int size() {
        return 0;
    }
}

