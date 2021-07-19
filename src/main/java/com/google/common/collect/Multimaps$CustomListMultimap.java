/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractListMultimap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Multimaps$CustomListMultimap
extends AbstractListMultimap {
    private static final long serialVersionUID;
    public transient Supplier factory;

    public Multimaps$CustomListMultimap(Map object, Supplier supplier) {
        super((Map)object);
        this.factory = object = (Supplier)Preconditions.checkNotNull(supplier);
    }

    private void readObject(ObjectInputStream object) {
        Supplier supplier;
        ((ObjectInputStream)object).defaultReadObject();
        this.factory = supplier = (Supplier)((ObjectInputStream)object).readObject();
        object = (Map)((ObjectInputStream)object).readObject();
        this.setMap((Map)object);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Object object = this.factory;
        objectOutputStream.writeObject(object);
        object = this.backingMap();
        objectOutputStream.writeObject(object);
    }

    public Map createAsMap() {
        return this.createMaybeNavigableAsMap();
    }

    public List createCollection() {
        return (List)this.factory.get();
    }

    public Set createKeySet() {
        return this.createMaybeNavigableKeySet();
    }
}

