/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap$1;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import com.google.common.collect.LinkedHashMultimapGwtSerializationDependencies;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Platform;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class LinkedHashMultimap
extends LinkedHashMultimapGwtSerializationDependencies {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    public static final double VALUE_SET_LOAD_FACTOR = 1.0;
    private static final long serialVersionUID = 1L;
    private transient LinkedHashMultimap$ValueEntry multimapHeaderEntry;
    public transient int valueSetCapacity;

    private LinkedHashMultimap(int n10, int n11) {
        Object object = Platform.newLinkedHashMapWithExpectedSize(n10);
        super((Map)object);
        this.valueSetCapacity = 2;
        CollectPreconditions.checkNonnegative(n11, "expectedValuesPerKey");
        this.valueSetCapacity = n11;
        this.multimapHeaderEntry = object = new LinkedHashMultimap$ValueEntry(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap((LinkedHashMultimap$ValueEntry)object, (LinkedHashMultimap$ValueEntry)object);
    }

    public static /* synthetic */ void access$200(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink, LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink2) {
        LinkedHashMultimap.succeedsInValueSet(linkedHashMultimap$ValueSetLink, linkedHashMultimap$ValueSetLink2);
    }

    public static /* synthetic */ LinkedHashMultimap$ValueEntry access$300(LinkedHashMultimap linkedHashMultimap) {
        return linkedHashMultimap.multimapHeaderEntry;
    }

    public static /* synthetic */ void access$400(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry, LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2) {
        LinkedHashMultimap.succeedsInMultimap(linkedHashMultimap$ValueEntry, linkedHashMultimap$ValueEntry2);
    }

    public static /* synthetic */ void access$500(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        LinkedHashMultimap.deleteFromValueSet(linkedHashMultimap$ValueSetLink);
    }

    public static /* synthetic */ void access$600(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        LinkedHashMultimap.deleteFromMultimap(linkedHashMultimap$ValueEntry);
    }

    public static LinkedHashMultimap create() {
        LinkedHashMultimap linkedHashMultimap = new LinkedHashMultimap(16, 2);
        return linkedHashMultimap;
    }

    public static LinkedHashMultimap create(int n10, int n11) {
        n10 = Maps.capacity(n10);
        n11 = Maps.capacity(n11);
        LinkedHashMultimap linkedHashMultimap = new LinkedHashMultimap(n10, n11);
        return linkedHashMultimap;
    }

    public static LinkedHashMultimap create(Multimap multimap) {
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(multimap.keySet().size(), 2);
        linkedHashMultimap.putAll(multimap);
        return linkedHashMultimap;
    }

    private static void deleteFromMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2 = linkedHashMultimap$ValueEntry.getPredecessorInMultimap();
        linkedHashMultimap$ValueEntry = linkedHashMultimap$ValueEntry.getSuccessorInMultimap();
        LinkedHashMultimap.succeedsInMultimap(linkedHashMultimap$ValueEntry2, linkedHashMultimap$ValueEntry);
    }

    private static void deleteFromValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink2 = linkedHashMultimap$ValueSetLink.getPredecessorInValueSet();
        linkedHashMultimap$ValueSetLink = linkedHashMultimap$ValueSetLink.getSuccessorInValueSet();
        LinkedHashMultimap.succeedsInValueSet(linkedHashMultimap$ValueSetLink2, linkedHashMultimap$ValueSetLink);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Object object;
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
        objectInputStream.defaultReadObject();
        int n10 = 0;
        this.multimapHeaderEntry = linkedHashMultimap$ValueEntry = new LinkedHashMultimap$ValueEntry(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap(linkedHashMultimap$ValueEntry, linkedHashMultimap$ValueEntry);
        this.valueSetCapacity = 2;
        int n11 = objectInputStream.readInt();
        int n12 = 12;
        Map map = Platform.newLinkedHashMapWithExpectedSize(n12);
        Object object2 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            object = objectInputStream.readObject();
            Collection collection = this.createCollection(object);
            map.put(object, collection);
        }
        n11 = objectInputStream.readInt();
        while (n10 < n11) {
            object2 = objectInputStream.readObject();
            object = objectInputStream.readObject();
            object2 = (Collection)map.get(object2);
            object2.add(object);
            ++n10;
        }
        this.setMap(map);
    }

    private static void succeedsInMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry, LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2) {
        linkedHashMultimap$ValueEntry.setSuccessorInMultimap(linkedHashMultimap$ValueEntry2);
        linkedHashMultimap$ValueEntry2.setPredecessorInMultimap(linkedHashMultimap$ValueEntry);
    }

    private static void succeedsInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink, LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink2) {
        linkedHashMultimap$ValueSetLink.setSuccessorInValueSet(linkedHashMultimap$ValueSetLink2);
        linkedHashMultimap$ValueSetLink2.setPredecessorInValueSet(linkedHashMultimap$ValueSetLink);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        Object object;
        boolean bl2;
        objectOutputStream.defaultWriteObject();
        int n10 = this.keySet().size();
        objectOutputStream.writeInt(n10);
        Iterator iterator2 = this.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = iterator2.next();
            objectOutputStream.writeObject(object);
        }
        n10 = this.size();
        objectOutputStream.writeInt(n10);
        iterator2 = this.entries().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Map.Entry)iterator2.next();
            Object k10 = object.getKey();
            objectOutputStream.writeObject(k10);
            object = object.getValue();
            objectOutputStream.writeObject(object);
        }
    }

    public void clear() {
        super.clear();
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = this.multimapHeaderEntry;
        LinkedHashMultimap.succeedsInMultimap(linkedHashMultimap$ValueEntry, linkedHashMultimap$ValueEntry);
    }

    public Collection createCollection(Object object) {
        int n10 = this.valueSetCapacity;
        LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet = new LinkedHashMultimap$ValueSet(this, object, n10);
        return linkedHashMultimap$ValueSet;
    }

    public Set createCollection() {
        return Platform.newLinkedHashSetWithExpectedSize(this.valueSetCapacity);
    }

    public Set entries() {
        return super.entries();
    }

    public Iterator entryIterator() {
        LinkedHashMultimap$1 linkedHashMultimap$1 = new LinkedHashMultimap$1(this);
        return linkedHashMultimap$1;
    }

    public Set keySet() {
        return super.keySet();
    }

    public Set replaceValues(Object object, Iterable iterable) {
        return super.replaceValues(object, iterable);
    }

    public Iterator valueIterator() {
        return Maps.valueIterator(this.entryIterator());
    }

    public Collection values() {
        return super.values();
    }
}

