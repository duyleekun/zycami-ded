/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap$1;
import com.google.protobuf.SmallSortedMap$DescendingEntrySet;
import com.google.protobuf.SmallSortedMap$EmptySet;
import com.google.protobuf.SmallSortedMap$Entry;
import com.google.protobuf.SmallSortedMap$EntrySet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SmallSortedMap
extends AbstractMap {
    private List entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap$DescendingEntrySet lazyDescendingEntrySet;
    private volatile SmallSortedMap$EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map overflowEntries;
    private Map overflowEntriesDescending;

    private SmallSortedMap(int n10) {
        this.maxArraySize = n10;
        Map map = Collections.emptyList();
        this.entryList = map;
        map = Collections.emptyMap();
        this.overflowEntries = map;
        this.overflowEntriesDescending = map = Collections.emptyMap();
    }

    public /* synthetic */ SmallSortedMap(int n10, SmallSortedMap$1 smallSortedMap$1) {
        this(n10);
    }

    public static /* synthetic */ void access$300(SmallSortedMap smallSortedMap) {
        smallSortedMap.checkMutable();
    }

    public static /* synthetic */ List access$600(SmallSortedMap smallSortedMap) {
        return smallSortedMap.entryList;
    }

    public static /* synthetic */ Map access$700(SmallSortedMap smallSortedMap) {
        return smallSortedMap.overflowEntries;
    }

    public static /* synthetic */ Object access$800(SmallSortedMap smallSortedMap, int n10) {
        return smallSortedMap.removeArrayEntryAt(n10);
    }

    public static /* synthetic */ Map access$900(SmallSortedMap smallSortedMap) {
        return smallSortedMap.overflowEntriesDescending;
    }

    private int binarySearchInArray(Comparable comparable) {
        int n10;
        Comparable comparable2;
        List list = this.entryList;
        int n11 = list.size() + -1;
        if (n11 >= 0) {
            comparable2 = ((SmallSortedMap$Entry)this.entryList.get(n11)).getKey();
            n10 = comparable.compareTo(comparable2);
            if (n10 > 0) {
                return -(n11 + 2);
            }
            if (n10 == 0) {
                return n11;
            }
        }
        n10 = 0;
        comparable2 = null;
        while (n10 <= n11) {
            int n12 = (n10 + n11) / 2;
            Comparable comparable3 = ((SmallSortedMap$Entry)this.entryList.get(n12)).getKey();
            int n13 = comparable.compareTo(comparable3);
            if (n13 < 0) {
                n11 = n12 += -1;
                continue;
            }
            if (n13 > 0) {
                n10 = ++n12;
                continue;
            }
            return n12;
        }
        return -(n10 + 1);
    }

    private void checkMutable() {
        boolean bl2 = this.isImmutable;
        if (!bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private void ensureEntryArrayMutable() {
        this.checkMutable();
        ArrayList arrayList = this.entryList;
        boolean bl2 = arrayList.isEmpty();
        if (bl2 && !(bl2 = (arrayList = this.entryList) instanceof ArrayList)) {
            int n10 = this.maxArraySize;
            this.entryList = arrayList = new ArrayList(n10);
        }
    }

    private SortedMap getOverflowEntriesMutable() {
        this.checkMutable();
        NavigableMap navigableMap = this.overflowEntries;
        boolean bl2 = navigableMap.isEmpty();
        if (bl2 && !(bl2 = (navigableMap = this.overflowEntries) instanceof TreeMap)) {
            this.overflowEntries = navigableMap = new NavigableMap();
            this.overflowEntriesDescending = navigableMap = navigableMap.descendingMap();
        }
        return (SortedMap)this.overflowEntries;
    }

    public static SmallSortedMap newFieldMap(int n10) {
        SmallSortedMap$1 smallSortedMap$1 = new SmallSortedMap$1(n10);
        return smallSortedMap$1;
    }

    public static SmallSortedMap newInstanceForTest(int n10) {
        SmallSortedMap smallSortedMap = new SmallSortedMap(n10);
        return smallSortedMap;
    }

    private Object removeArrayEntryAt(int n10) {
        this.checkMutable();
        Object object = ((SmallSortedMap$Entry)this.entryList.remove(n10)).getValue();
        Object object2 = this.overflowEntries;
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = this.getOverflowEntriesMutable().entrySet().iterator();
            List list = this.entryList;
            Map.Entry entry = (Map.Entry)object2.next();
            SmallSortedMap$Entry smallSortedMap$Entry = new SmallSortedMap$Entry(this, entry);
            list.add(smallSortedMap$Entry);
            object2.remove();
        }
        return object;
    }

    public void clear() {
        this.checkMutable();
        Object object = this.entryList;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            object = this.entryList;
            object.clear();
        }
        if (!(bl2 = (object = this.overflowEntries).isEmpty())) {
            object = this.overflowEntries;
            object.clear();
        }
    }

    public boolean containsKey(Object object) {
        Map map;
        boolean bl2;
        int n10 = this.binarySearchInArray((Comparable)(object = (Comparable)object));
        if (n10 < 0 && !(bl2 = (map = this.overflowEntries).containsKey(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Set descendingEntrySet() {
        SmallSortedMap$DescendingEntrySet smallSortedMap$DescendingEntrySet = this.lazyDescendingEntrySet;
        if (smallSortedMap$DescendingEntrySet == null) {
            this.lazyDescendingEntrySet = smallSortedMap$DescendingEntrySet = new SmallSortedMap$DescendingEntrySet(this, null);
        }
        return this.lazyDescendingEntrySet;
    }

    public Set entrySet() {
        SmallSortedMap$EntrySet smallSortedMap$EntrySet = this.lazyEntrySet;
        if (smallSortedMap$EntrySet == null) {
            this.lazyEntrySet = smallSortedMap$EntrySet = new SmallSortedMap$EntrySet(this, null);
        }
        return this.lazyEntrySet;
    }

    public boolean equals(Object object) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n12 = object instanceof SmallSortedMap;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (SmallSortedMap)object;
        n12 = this.size();
        if (n12 != (n11 = ((SmallSortedMap)object).size())) {
            return false;
        }
        n11 = this.getNumArrayEntries();
        if (n11 != (n10 = ((SmallSortedMap)object).getNumArrayEntries())) {
            Set set = this.entrySet();
            object = ((SmallSortedMap)object).entrySet();
            return set.equals(object);
        }
        for (n10 = 0; n10 < n11; ++n10) {
            Map.Entry entry;
            Map.Entry entry2 = this.getArrayEntryAt(n10);
            boolean bl3 = entry2.equals(entry = ((SmallSortedMap)object).getArrayEntryAt(n10));
            if (bl3) continue;
            return false;
        }
        if (n11 != n12) {
            Map map = this.overflowEntries;
            object = ((SmallSortedMap)object).overflowEntries;
            return map.equals(object);
        }
        return bl2;
    }

    public Object get(Object object) {
        int n10 = this.binarySearchInArray((Comparable)(object = (Comparable)object));
        if (n10 >= 0) {
            return ((SmallSortedMap$Entry)this.entryList.get(n10)).getValue();
        }
        return this.overflowEntries.get(object);
    }

    public Map.Entry getArrayEntryAt(int n10) {
        return (Map.Entry)this.entryList.get(n10);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable getOverflowEntries() {
        Object object = this.overflowEntries;
        boolean bl2 = object.isEmpty();
        object = bl2 ? SmallSortedMap$EmptySet.iterable() : this.overflowEntries.entrySet();
        return object;
    }

    public Iterable getOverflowEntriesDescending() {
        Object object = this.overflowEntriesDescending;
        boolean bl2 = object.isEmpty();
        object = bl2 ? SmallSortedMap$EmptySet.iterable() : this.overflowEntriesDescending.entrySet();
        return object;
    }

    public int hashCode() {
        int n10 = this.getNumArrayEntries();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            SmallSortedMap$Entry smallSortedMap$Entry = (SmallSortedMap$Entry)this.entryList.get(i10);
            int n12 = smallSortedMap$Entry.hashCode();
            n11 += n12;
        }
        n10 = this.getNumOverflowEntries();
        if (n10 > 0) {
            Map map = this.overflowEntries;
            n10 = map.hashCode();
            n11 += n10;
        }
        return n11;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        boolean bl2 = this.isImmutable;
        if (!bl2) {
            Map map = this.overflowEntries;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.overflowEntries);
            this.overflowEntries = map;
            map = this.overflowEntriesDescending;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.overflowEntriesDescending);
            this.overflowEntriesDescending = map;
            this.isImmutable = bl2 = true;
        }
    }

    public Object put(Comparable comparable, Object object) {
        Object object2;
        int n10;
        this.checkMutable();
        int n11 = this.binarySearchInArray(comparable);
        if (n11 >= 0) {
            return ((SmallSortedMap$Entry)this.entryList.get(n11)).setValue(object);
        }
        this.ensureEntryArrayMutable();
        n11 = -(n11 + 1);
        int n12 = this.maxArraySize;
        if (n11 >= n12) {
            return this.getOverflowEntriesMutable().put(comparable, object);
        }
        Object object3 = this.entryList;
        n12 = object3.size();
        if (n12 == (n10 = this.maxArraySize)) {
            object3 = this.entryList;
            object3 = (SmallSortedMap$Entry)object3.remove(n10 += -1);
            object2 = this.getOverflowEntriesMutable();
            Comparable comparable2 = ((SmallSortedMap$Entry)object3).getKey();
            object3 = ((SmallSortedMap$Entry)object3).getValue();
            object2.put(comparable2, object3);
        }
        object3 = this.entryList;
        object2 = new SmallSortedMap$Entry(this, comparable, object);
        object3.add(n11, object2);
        return null;
    }

    public Object remove(Object object) {
        this.checkMutable();
        object = (Comparable)object;
        int n10 = this.binarySearchInArray((Comparable)object);
        if (n10 >= 0) {
            return this.removeArrayEntryAt(n10);
        }
        Map map = this.overflowEntries;
        n10 = (int)(map.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        return this.overflowEntries.remove(object);
    }

    public int size() {
        int n10 = this.entryList.size();
        int n11 = this.overflowEntries.size();
        return n10 + n11;
    }
}

