/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedAsMapValues$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.Iterator;

public class Synchronized$SynchronizedAsMapValues
extends Synchronized$SynchronizedCollection {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedAsMapValues(Collection collection, Object object) {
        super(collection, object, null);
    }

    public Iterator iterator() {
        Iterator iterator2 = super.iterator();
        Synchronized$SynchronizedAsMapValues$1 synchronized$SynchronizedAsMapValues$1 = new Synchronized$SynchronizedAsMapValues$1(this, iterator2);
        return synchronized$SynchronizedAsMapValues$1;
    }
}

