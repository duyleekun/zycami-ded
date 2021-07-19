/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$1EntriesImpl;
import com.google.common.collect.LinkedListMultimap$1KeySetImpl;
import com.google.common.collect.LinkedListMultimap$1ValuesImpl;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$Node;
import com.google.common.collect.LinkedListMultimap$ValueForKeyIterator;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multiset;
import com.google.common.collect.Platform;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedListMultimap
extends AbstractMultimap
implements ListMultimap,
Serializable {
    private static final long serialVersionUID;
    private transient LinkedListMultimap$Node head;
    private transient Map keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient LinkedListMultimap$Node tail;

    public LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int n10) {
        Map map;
        this.keyToKeyList = map = Platform.newHashMapWithExpectedSize(n10);
    }

    private LinkedListMultimap(Multimap multimap) {
        int n10 = multimap.keySet().size();
        this(n10);
        this.putAll(multimap);
    }

    public static /* synthetic */ int access$000(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.modCount;
    }

    public static /* synthetic */ LinkedListMultimap$Node access$100(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.tail;
    }

    public static /* synthetic */ LinkedListMultimap$Node access$200(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.head;
    }

    public static /* synthetic */ void access$300(Object object) {
        LinkedListMultimap.checkElement(object);
    }

    public static /* synthetic */ void access$400(LinkedListMultimap linkedListMultimap, LinkedListMultimap$Node linkedListMultimap$Node) {
        linkedListMultimap.removeNode(linkedListMultimap$Node);
    }

    public static /* synthetic */ void access$500(LinkedListMultimap linkedListMultimap, Object object) {
        linkedListMultimap.removeAllNodes(object);
    }

    public static /* synthetic */ Map access$600(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.keyToKeyList;
    }

    public static /* synthetic */ LinkedListMultimap$Node access$700(LinkedListMultimap linkedListMultimap, Object object, Object object2, LinkedListMultimap$Node linkedListMultimap$Node) {
        return linkedListMultimap.addNode(object, object2, linkedListMultimap$Node);
    }

    public static /* synthetic */ int access$900(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.size;
    }

    private LinkedListMultimap$Node addNode(Object object, Object object2, LinkedListMultimap$Node object3) {
        int n10;
        LinkedListMultimap$Node linkedListMultimap$Node = new LinkedListMultimap$Node(object, object2);
        object2 = this.head;
        if (object2 == null) {
            this.tail = linkedListMultimap$Node;
            this.head = linkedListMultimap$Node;
            object2 = this.keyToKeyList;
            object3 = new LinkedListMultimap$KeyList(linkedListMultimap$Node);
            object2.put(object, object3);
            this.modCount = n10 = this.modCount + 1;
        } else if (object3 == null) {
            object2 = this.tail;
            ((LinkedListMultimap$Node)object2).next = linkedListMultimap$Node;
            linkedListMultimap$Node.previous = object2;
            this.tail = linkedListMultimap$Node;
            object2 = (LinkedListMultimap$KeyList)this.keyToKeyList.get(object);
            if (object2 == null) {
                object2 = this.keyToKeyList;
                object3 = new LinkedListMultimap$KeyList(linkedListMultimap$Node);
                object2.put(object, object3);
                this.modCount = n10 = this.modCount + 1;
            } else {
                ((LinkedListMultimap$KeyList)object2).count = n10 = ((LinkedListMultimap$KeyList)object2).count + 1;
                object = ((LinkedListMultimap$KeyList)object2).tail;
                ((LinkedListMultimap$Node)object).nextSibling = linkedListMultimap$Node;
                linkedListMultimap$Node.previousSibling = object;
                ((LinkedListMultimap$KeyList)object2).tail = linkedListMultimap$Node;
            }
        } else {
            int n11;
            object2 = (LinkedListMultimap$KeyList)this.keyToKeyList.get(object);
            ((LinkedListMultimap$KeyList)object2).count = n11 = ((LinkedListMultimap$KeyList)object2).count + 1;
            linkedListMultimap$Node.previous = object2 = ((LinkedListMultimap$Node)object3).previous;
            linkedListMultimap$Node.previousSibling = object2 = ((LinkedListMultimap$Node)object3).previousSibling;
            linkedListMultimap$Node.next = object3;
            linkedListMultimap$Node.nextSibling = object3;
            object2 = ((LinkedListMultimap$Node)object3).previousSibling;
            if (object2 == null) {
                object2 = this.keyToKeyList;
                object = (LinkedListMultimap$KeyList)object2.get(object);
                ((LinkedListMultimap$KeyList)object).head = linkedListMultimap$Node;
            } else {
                ((LinkedListMultimap$Node)object2).nextSibling = linkedListMultimap$Node;
            }
            object = ((LinkedListMultimap$Node)object3).previous;
            if (object == null) {
                this.head = linkedListMultimap$Node;
            } else {
                ((LinkedListMultimap$Node)object).next = linkedListMultimap$Node;
            }
            ((LinkedListMultimap$Node)object3).previous = linkedListMultimap$Node;
            ((LinkedListMultimap$Node)object3).previousSibling = linkedListMultimap$Node;
        }
        this.size = n10 = this.size + 1;
        return linkedListMultimap$Node;
    }

    private static void checkElement(Object object) {
        if (object != null) {
            return;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static LinkedListMultimap create() {
        LinkedListMultimap linkedListMultimap = new LinkedListMultimap();
        return linkedListMultimap;
    }

    public static LinkedListMultimap create(int n10) {
        LinkedListMultimap linkedListMultimap = new LinkedListMultimap(n10);
        return linkedListMultimap;
    }

    public static LinkedListMultimap create(Multimap multimap) {
        LinkedListMultimap linkedListMultimap = new LinkedListMultimap(multimap);
        return linkedListMultimap;
    }

    private List getCopy(Object object) {
        LinkedListMultimap$ValueForKeyIterator linkedListMultimap$ValueForKeyIterator = new LinkedListMultimap$ValueForKeyIterator(this, object);
        return Collections.unmodifiableList(Lists.newArrayList(linkedListMultimap$ValueForKeyIterator));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        CompactLinkedHashMap compactLinkedHashMap = CompactLinkedHashMap.create();
        this.keyToKeyList = compactLinkedHashMap;
        int n10 = objectInputStream.readInt();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            this.put(object, object2);
        }
    }

    private void removeAllNodes(Object object) {
        LinkedListMultimap$ValueForKeyIterator linkedListMultimap$ValueForKeyIterator = new LinkedListMultimap$ValueForKeyIterator(this, object);
        Iterators.clear(linkedListMultimap$ValueForKeyIterator);
    }

    private void removeNode(LinkedListMultimap$Node object) {
        int n10;
        Object object2;
        Object object3 = ((LinkedListMultimap$Node)object).previous;
        if (object3 != null) {
            object2 = ((LinkedListMultimap$Node)object).next;
            ((LinkedListMultimap$Node)object3).next = object2;
        } else {
            object2 = ((LinkedListMultimap$Node)object).next;
            this.head = object2;
        }
        object2 = ((LinkedListMultimap$Node)object).next;
        if (object2 != null) {
            ((LinkedListMultimap$Node)object2).previous = object3;
        } else {
            this.tail = object3;
        }
        object3 = ((LinkedListMultimap$Node)object).previousSibling;
        if (object3 == null && (object3 = ((LinkedListMultimap$Node)object).nextSibling) == null) {
            object3 = this.keyToKeyList;
            object = ((LinkedListMultimap$Node)object).key;
            object = (LinkedListMultimap$KeyList)object3.remove(object);
            object3 = null;
            ((LinkedListMultimap$KeyList)object).count = 0;
            this.modCount = n10 = this.modCount + 1;
        } else {
            int n11;
            object3 = this.keyToKeyList;
            object2 = ((LinkedListMultimap$Node)object).key;
            object3 = (LinkedListMultimap$KeyList)object3.get(object2);
            ((LinkedListMultimap$KeyList)object3).count = n11 = ((LinkedListMultimap$KeyList)object3).count + -1;
            object2 = ((LinkedListMultimap$Node)object).previousSibling;
            if (object2 == null) {
                LinkedListMultimap$Node linkedListMultimap$Node;
                ((LinkedListMultimap$KeyList)object3).head = linkedListMultimap$Node = ((LinkedListMultimap$Node)object).nextSibling;
            } else {
                LinkedListMultimap$Node linkedListMultimap$Node;
                ((LinkedListMultimap$Node)object2).nextSibling = linkedListMultimap$Node = ((LinkedListMultimap$Node)object).nextSibling;
            }
            object = ((LinkedListMultimap$Node)object).nextSibling;
            if (object == null) {
                ((LinkedListMultimap$KeyList)object3).tail = object2;
            } else {
                ((LinkedListMultimap$Node)object).previousSibling = object2;
            }
        }
        this.size = n10 = this.size + -1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        boolean bl2;
        objectOutputStream.defaultWriteObject();
        int n10 = this.size();
        objectOutputStream.writeInt(n10);
        Iterator iterator2 = this.entries().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            Object k10 = entry.getKey();
            objectOutputStream.writeObject(k10);
            entry = entry.getValue();
            objectOutputStream.writeObject(entry);
        }
    }

    public void clear() {
        int n10;
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount = n10 = this.modCount + 1;
    }

    public boolean containsKey(Object object) {
        return this.keyToKeyList.containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.values().contains(object);
    }

    public Map createAsMap() {
        Multimaps$AsMap multimaps$AsMap = new Multimaps$AsMap(this);
        return multimaps$AsMap;
    }

    public List createEntries() {
        LinkedListMultimap$1EntriesImpl linkedListMultimap$1EntriesImpl = new LinkedListMultimap$1EntriesImpl(this);
        return linkedListMultimap$1EntriesImpl;
    }

    public Set createKeySet() {
        LinkedListMultimap$1KeySetImpl linkedListMultimap$1KeySetImpl = new LinkedListMultimap$1KeySetImpl(this);
        return linkedListMultimap$1KeySetImpl;
    }

    public Multiset createKeys() {
        Multimaps$Keys multimaps$Keys = new Multimaps$Keys(this);
        return multimaps$Keys;
    }

    public List createValues() {
        LinkedListMultimap$1ValuesImpl linkedListMultimap$1ValuesImpl = new LinkedListMultimap$1ValuesImpl(this);
        return linkedListMultimap$1ValuesImpl;
    }

    public List entries() {
        return (List)super.entries();
    }

    public Iterator entryIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public List get(Object object) {
        LinkedListMultimap$1 linkedListMultimap$1 = new LinkedListMultimap$1(this, object);
        return linkedListMultimap$1;
    }

    public boolean isEmpty() {
        boolean bl2;
        LinkedListMultimap$Node linkedListMultimap$Node = this.head;
        if (linkedListMultimap$Node == null) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedListMultimap$Node = null;
        }
        return bl2;
    }

    public boolean put(Object object, Object object2) {
        this.addNode(object, object2, null);
        return true;
    }

    public List removeAll(Object object) {
        List list = this.getCopy(object);
        this.removeAllNodes(object);
        return list;
    }

    public List replaceValues(Object iterator2, Iterable iterable) {
        boolean bl2;
        List list = this.getCopy(iterator2);
        LinkedListMultimap$ValueForKeyIterator linkedListMultimap$ValueForKeyIterator = new LinkedListMultimap$ValueForKeyIterator(this, iterator2);
        iterator2 = iterable.iterator();
        while ((bl2 = linkedListMultimap$ValueForKeyIterator.hasNext()) && (bl2 = iterator2.hasNext())) {
            linkedListMultimap$ValueForKeyIterator.next();
            iterable = iterator2.next();
            linkedListMultimap$ValueForKeyIterator.set(iterable);
        }
        while (bl2 = linkedListMultimap$ValueForKeyIterator.hasNext()) {
            linkedListMultimap$ValueForKeyIterator.next();
            linkedListMultimap$ValueForKeyIterator.remove();
        }
        while (bl2 = iterator2.hasNext()) {
            iterable = iterator2.next();
            linkedListMultimap$ValueForKeyIterator.add(iterable);
        }
        return list;
    }

    public int size() {
        return this.size;
    }

    public List values() {
        return (List)super.values();
    }
}

