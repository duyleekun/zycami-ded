/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.ForwardingConcurrentMap;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public abstract class MapMakerInternalMap$AbstractSerializationProxy
extends ForwardingConcurrentMap
implements Serializable {
    private static final long serialVersionUID = 3L;
    public final int concurrencyLevel;
    public transient ConcurrentMap delegate;
    public final Equivalence keyEquivalence;
    public final MapMakerInternalMap$Strength keyStrength;
    public final Equivalence valueEquivalence;
    public final MapMakerInternalMap$Strength valueStrength;

    public MapMakerInternalMap$AbstractSerializationProxy(MapMakerInternalMap$Strength mapMakerInternalMap$Strength, MapMakerInternalMap$Strength mapMakerInternalMap$Strength2, Equivalence equivalence, Equivalence equivalence2, int n10, ConcurrentMap concurrentMap) {
        this.keyStrength = mapMakerInternalMap$Strength;
        this.valueStrength = mapMakerInternalMap$Strength2;
        this.keyEquivalence = equivalence;
        this.valueEquivalence = equivalence2;
        this.concurrencyLevel = n10;
        this.delegate = concurrentMap;
    }

    public ConcurrentMap delegate() {
        return this.delegate;
    }

    public void readEntries(ObjectInputStream objectInputStream) {
        Object object;
        while ((object = objectInputStream.readObject()) != null) {
            Object object2 = objectInputStream.readObject();
            ConcurrentMap concurrentMap = this.delegate;
            concurrentMap.put(object, object2);
        }
        return;
    }

    public MapMaker readMapMaker(ObjectInputStream object) {
        int n10 = ((ObjectInputStream)object).readInt();
        Object object2 = new MapMaker();
        object = object2.initialCapacity(n10);
        object2 = this.keyStrength;
        object = ((MapMaker)object).setKeyStrength((MapMakerInternalMap$Strength)((Object)object2));
        object2 = this.valueStrength;
        object = ((MapMaker)object).setValueStrength((MapMakerInternalMap$Strength)((Object)object2));
        object2 = this.keyEquivalence;
        object = ((MapMaker)object).keyEquivalence((Equivalence)object2);
        int n11 = this.concurrencyLevel;
        return ((MapMaker)object).concurrencyLevel(n11);
    }

    public void writeMapTo(ObjectOutputStream objectOutputStream) {
        boolean bl2;
        int n10 = this.delegate.size();
        objectOutputStream.writeInt(n10);
        Iterator iterator2 = this.delegate.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Object k10 = entry.getKey();
            objectOutputStream.writeObject(k10);
            entry = entry.getValue();
            objectOutputStream.writeObject(entry);
        }
        objectOutputStream.writeObject(null);
    }
}

