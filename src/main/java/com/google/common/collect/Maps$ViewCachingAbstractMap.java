/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.Maps$Values;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

public abstract class Maps$ViewCachingAbstractMap
extends AbstractMap {
    private transient Set entrySet;
    private transient Set keySet;
    private transient Collection values;

    public abstract Set createEntrySet();

    public Set createKeySet() {
        Maps$KeySet maps$KeySet = new Maps$KeySet(this);
        return maps$KeySet;
    }

    public Collection createValues() {
        Maps$Values maps$Values = new Maps$Values(this);
        return maps$Values;
    }

    public Set entrySet() {
        Set set = this.entrySet;
        if (set == null) {
            this.entrySet = set = this.createEntrySet();
        }
        return set;
    }

    public Set keySet() {
        Set set = this.keySet;
        if (set == null) {
            this.keySet = set = this.createKeySet();
        }
        return set;
    }

    public Collection values() {
        Collection collection = this.values;
        if (collection == null) {
            this.values = collection = this.createValues();
        }
        return collection;
    }
}

