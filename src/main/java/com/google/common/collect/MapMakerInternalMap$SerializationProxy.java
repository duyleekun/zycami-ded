/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap$AbstractSerializationProxy;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;

public final class MapMakerInternalMap$SerializationProxy
extends MapMakerInternalMap$AbstractSerializationProxy {
    private static final long serialVersionUID = 3L;

    public MapMakerInternalMap$SerializationProxy(MapMakerInternalMap$Strength mapMakerInternalMap$Strength, MapMakerInternalMap$Strength mapMakerInternalMap$Strength2, Equivalence equivalence, Equivalence equivalence2, int n10, ConcurrentMap concurrentMap) {
        super(mapMakerInternalMap$Strength, mapMakerInternalMap$Strength2, equivalence, equivalence2, n10, concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ConcurrentMap concurrentMap;
        objectInputStream.defaultReadObject();
        this.delegate = concurrentMap = this.readMapMaker(objectInputStream).makeMap();
        this.readEntries(objectInputStream);
    }

    private Object readResolve() {
        return this.delegate;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.writeMapTo(objectOutputStream);
    }
}

