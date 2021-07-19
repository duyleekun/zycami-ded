/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingObject;
import java.util.Iterator;

public abstract class ForwardingIterator
extends ForwardingObject
implements Iterator {
    public abstract Iterator delegate();

    public boolean hasNext() {
        return this.delegate().hasNext();
    }

    public Object next() {
        return this.delegate().next();
    }

    public void remove() {
        this.delegate().remove();
    }
}

