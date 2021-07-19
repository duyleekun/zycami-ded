/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap$1;
import com.google.common.collect.ImmutableSortedMap$1EntrySet;
import com.google.common.collect.ImmutableSortedMap$Builder;
import com.google.common.collect.ImmutableSortedMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMapFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

public final class ImmutableSortedMap
extends ImmutableSortedMapFauxverideShim
implements NavigableMap {
    private static final ImmutableSortedMap NATURAL_EMPTY_MAP;
    private static final Comparator NATURAL_ORDER;
    private static final long serialVersionUID;
    private transient ImmutableSortedMap descendingMap;
    private final transient RegularImmutableSortedSet keySet;
    private final transient ImmutableList valueList;

    static {
        ImmutableSortedMap immutableSortedMap;
        NATURAL_ORDER = Ordering.natural();
        RegularImmutableSortedSet regularImmutableSortedSet = ImmutableSortedSet.emptySet(Ordering.natural());
        ImmutableList immutableList = ImmutableList.of();
        NATURAL_EMPTY_MAP = immutableSortedMap = new ImmutableSortedMap(regularImmutableSortedSet, immutableList);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet regularImmutableSortedSet, ImmutableList immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet regularImmutableSortedSet, ImmutableList immutableList, ImmutableSortedMap immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    public static /* synthetic */ ImmutableSortedMap access$000(Comparator comparator, Object object, Object object2) {
        return ImmutableSortedMap.of(comparator, object, object2);
    }

    public static /* synthetic */ RegularImmutableSortedSet access$100(ImmutableSortedMap immutableSortedMap) {
        return immutableSortedMap.keySet;
    }

    public static /* synthetic */ ImmutableList access$200(ImmutableSortedMap immutableSortedMap) {
        return immutableSortedMap.valueList;
    }

    public static ImmutableSortedMap copyOf(Iterable iterable) {
        Ordering ordering = (Ordering)NATURAL_ORDER;
        return ImmutableSortedMap.copyOf(iterable, (Comparator)ordering);
    }

    public static ImmutableSortedMap copyOf(Iterable iterable, Comparator comparator) {
        return ImmutableSortedMap.fromEntries((Comparator)Preconditions.checkNotNull(comparator), false, iterable);
    }

    public static ImmutableSortedMap copyOf(Map map) {
        Ordering ordering = (Ordering)NATURAL_ORDER;
        return ImmutableSortedMap.copyOfInternal(map, ordering);
    }

    public static ImmutableSortedMap copyOf(Map map, Comparator comparator) {
        comparator = (Comparator)Preconditions.checkNotNull(comparator);
        return ImmutableSortedMap.copyOfInternal(map, comparator);
    }

    private static ImmutableSortedMap copyOfInternal(Map object, Comparator comparator) {
        Object object2;
        boolean bl2;
        boolean bl3;
        block2: {
            block4: {
                block3: {
                    bl3 = object instanceof SortedMap;
                    bl2 = false;
                    if (!bl3) break block2;
                    object2 = object;
                    object2 = ((SortedMap)object).comparator();
                    if (object2 != null) break block3;
                    object2 = NATURAL_ORDER;
                    if (comparator != object2) break block2;
                    bl3 = true;
                    break block4;
                }
                bl3 = comparator.equals(object2);
            }
            bl2 = bl3;
        }
        if (bl2 && (bl3 = object instanceof ImmutableSortedMap)) {
            object2 = object;
            object2 = (ImmutableSortedMap)object;
            boolean bl4 = ((ImmutableSortedMap)object2).isPartialView();
            if (!bl4) {
                return object2;
            }
        }
        object = object.entrySet();
        return ImmutableSortedMap.fromEntries(comparator, bl2, (Iterable)object);
    }

    public static ImmutableSortedMap copyOfSorted(SortedMap object) {
        boolean bl2;
        Comparator comparator = object.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (bl2 = object instanceof ImmutableSortedMap) {
            SortedMap sortedMap = object;
            sortedMap = (ImmutableSortedMap)object;
            boolean bl3 = ((ImmutableSortedMap)sortedMap).isPartialView();
            if (!bl3) {
                return sortedMap;
            }
        }
        object = object.entrySet();
        return ImmutableSortedMap.fromEntries(comparator, true, (Iterable)object);
    }

    public static ImmutableSortedMap emptyMap(Comparator object) {
        Object object2 = Ordering.natural();
        boolean bl2 = object2.equals(object);
        if (bl2) {
            return ImmutableSortedMap.of();
        }
        object = ImmutableSortedSet.emptySet((Comparator)object);
        ImmutableList immutableList = ImmutableList.of();
        object2 = new ImmutableSortedMap((RegularImmutableSortedSet)object, immutableList);
        return object2;
    }

    private static ImmutableSortedMap fromEntries(Comparator comparator, boolean bl2, Iterable entryArray) {
        Object[] objectArray = ImmutableMap.EMPTY_ENTRY_ARRAY;
        entryArray = (Map.Entry[])Iterables.toArray((Iterable)entryArray, objectArray);
        int n10 = entryArray.length;
        return ImmutableSortedMap.fromEntries(comparator, bl2, entryArray, n10);
    }

    private static ImmutableSortedMap fromEntries(Comparator object, boolean bl2, Map.Entry[] object2, int n10) {
        int n11;
        if (n11 != 0) {
            Object object3;
            int n12 = 1;
            if (n11 != n12) {
                Object k10;
                Object[] objectArray = new Object[n11];
                Object[] objectArray2 = new Object[n11];
                if (bl2) {
                    for (int i10 = 0; i10 < n11; ++i10) {
                        k10 = object3[i10].getKey();
                        Object v10 = object3[i10].getValue();
                        CollectPreconditions.checkEntryNotNull(k10, v10);
                        objectArray[i10] = k10;
                        objectArray2[i10] = v10;
                    }
                } else {
                    k10 = new ImmutableSortedMap$1((Comparator)object);
                    Arrays.sort(object3, 0, n11, k10);
                    objectArray[0] = k10 = object3[0].getKey();
                    Object object4 = object3[0].getValue();
                    objectArray2[0] = object4;
                    object4 = objectArray[0];
                    Object object5 = objectArray2[0];
                    CollectPreconditions.checkEntryNotNull(object4, object5);
                    for (int i11 = n12; i11 < n11; ++i11) {
                        object5 = object3[i11].getKey();
                        Object v11 = object3[i11].getValue();
                        CollectPreconditions.checkEntryNotNull(object5, v11);
                        objectArray[i11] = object5;
                        objectArray2[i11] = v11;
                        int n13 = object.compare(k10, object5);
                        if (n13 != 0) {
                            n13 = n12;
                        } else {
                            n13 = 0;
                            k10 = null;
                        }
                        int n14 = i11 + -1;
                        v11 = object3[n14];
                        Object v12 = object3[i11];
                        String string2 = "key";
                        ImmutableMap.checkNoConflict(n13 != 0, string2, v11, v12);
                        k10 = object5;
                    }
                }
                ImmutableList immutableList = ImmutableList.asImmutableList(objectArray);
                object3 = new Object(immutableList, (Comparator)object);
                object = ImmutableList.asImmutableList(objectArray2);
                k10 = new ImmutableSortedMap((RegularImmutableSortedSet)object3, (ImmutableList)object);
                return k10;
            }
            Object k10 = object3[0].getKey();
            object3 = object3[0].getValue();
            return ImmutableSortedMap.of((Comparator)object, k10, object3);
        }
        return ImmutableSortedMap.emptyMap((Comparator)object);
    }

    private ImmutableSortedMap getSubMap(int n10, int n11) {
        int n12;
        if (n10 == 0 && n11 == (n12 = this.size())) {
            return this;
        }
        if (n10 == n11) {
            return ImmutableSortedMap.emptyMap(this.comparator());
        }
        RegularImmutableSortedSet regularImmutableSortedSet = this.keySet.getSubSet(n10, n11);
        ImmutableList immutableList = this.valueList.subList(n10, n11);
        ImmutableSortedMap immutableSortedMap = new ImmutableSortedMap(regularImmutableSortedSet, immutableList);
        return immutableSortedMap;
    }

    public static ImmutableSortedMap$Builder naturalOrder() {
        Ordering ordering = Ordering.natural();
        ImmutableSortedMap$Builder immutableSortedMap$Builder = new ImmutableSortedMap$Builder(ordering);
        return immutableSortedMap$Builder;
    }

    public static ImmutableSortedMap of() {
        return NATURAL_EMPTY_MAP;
    }

    public static ImmutableSortedMap of(Comparable comparable, Object object) {
        return ImmutableSortedMap.of(Ordering.natural(), comparable, object);
    }

    public static ImmutableSortedMap of(Comparable object, Object object2, Comparable comparable, Object object3) {
        Map.Entry[] entryArray = new Map.Entry[]{object = ImmutableMap.entryOf(object, object2), object = ImmutableMap.entryOf(comparable, object3)};
        return ImmutableSortedMap.ofEntries(entryArray);
    }

    public static ImmutableSortedMap of(Comparable object, Object object2, Comparable comparable, Object object3, Comparable comparable2, Object object4) {
        Map.Entry[] entryArray = new Map.Entry[]{object = ImmutableMap.entryOf(object, object2), object = ImmutableMap.entryOf(comparable, object3), object = ImmutableMap.entryOf(comparable2, object4)};
        return ImmutableSortedMap.ofEntries(entryArray);
    }

    public static ImmutableSortedMap of(Comparable object, Object object2, Comparable comparable, Object object3, Comparable comparable2, Object object4, Comparable comparable3, Object object5) {
        Map.Entry[] entryArray = new Map.Entry[]{object = ImmutableMap.entryOf(object, object2), object = ImmutableMap.entryOf(comparable, object3), object = ImmutableMap.entryOf(comparable2, object4), object = ImmutableMap.entryOf(comparable3, object5)};
        return ImmutableSortedMap.ofEntries(entryArray);
    }

    public static ImmutableSortedMap of(Comparable object, Object object2, Comparable comparable, Object object3, Comparable comparable2, Object object4, Comparable comparable3, Object object5, Comparable comparable4, Object object6) {
        Map.Entry[] entryArray = new Map.Entry[]{object = ImmutableMap.entryOf(object, object2), object = ImmutableMap.entryOf(comparable, object3), object = ImmutableMap.entryOf(comparable2, object4), object = ImmutableMap.entryOf(comparable3, object5), object = ImmutableMap.entryOf(comparable4, object6)};
        return ImmutableSortedMap.ofEntries(entryArray);
    }

    private static ImmutableSortedMap of(Comparator object, Object object2, Object object3) {
        object2 = ImmutableList.of(object2);
        object = (Comparator)Preconditions.checkNotNull(object);
        RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet((ImmutableList)object2, (Comparator)object);
        object = ImmutableList.of(object3);
        ImmutableSortedMap immutableSortedMap = new ImmutableSortedMap(regularImmutableSortedSet, (ImmutableList)object);
        return immutableSortedMap;
    }

    private static ImmutableSortedMap ofEntries(Map.Entry ... entryArray) {
        Ordering ordering = Ordering.natural();
        int n10 = entryArray.length;
        return ImmutableSortedMap.fromEntries(ordering, false, entryArray, n10);
    }

    public static ImmutableSortedMap$Builder orderedBy(Comparator comparator) {
        ImmutableSortedMap$Builder immutableSortedMap$Builder = new ImmutableSortedMap$Builder(comparator);
        return immutableSortedMap$Builder;
    }

    public static ImmutableSortedMap$Builder reverseOrder() {
        Ordering ordering = Ordering.natural().reverse();
        ImmutableSortedMap$Builder immutableSortedMap$Builder = new ImmutableSortedMap$Builder(ordering);
        return immutableSortedMap$Builder;
    }

    public Map.Entry ceilingEntry(Object object) {
        return this.tailMap(object, true).firstEntry();
    }

    public Object ceilingKey(Object object) {
        return Maps.keyOrNull(this.ceilingEntry(object));
    }

    public Comparator comparator() {
        return ((ImmutableSortedSet)this.keySet()).comparator();
    }

    public ImmutableSet createEntrySet() {
        boolean bl2 = this.isEmpty();
        ImmutableSet immutableSet = bl2 ? ImmutableSet.of() : new ImmutableSortedMap$1EntrySet(this);
        return immutableSet;
    }

    public ImmutableSet createKeySet() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public ImmutableCollection createValues() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public ImmutableSortedSet descendingKeySet() {
        return this.keySet.descendingSet();
    }

    public ImmutableSortedMap descendingMap() {
        ImmutableSortedMap immutableSortedMap = this.descendingMap;
        if (immutableSortedMap == null) {
            boolean bl2 = this.isEmpty();
            if (bl2) {
                return ImmutableSortedMap.emptyMap(Ordering.from(this.comparator()).reverse());
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet)this.keySet.descendingSet();
            ImmutableList immutableList = this.valueList.reverse();
            immutableSortedMap = new ImmutableSortedMap(regularImmutableSortedSet, immutableList, this);
        }
        return immutableSortedMap;
    }

    public ImmutableSet entrySet() {
        return super.entrySet();
    }

    public Map.Entry firstEntry() {
        Map.Entry entry;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            entry = null;
        } else {
            entry = (Map.Entry)this.entrySet().asList().get(0);
        }
        return entry;
    }

    public Object firstKey() {
        return ((ImmutableSortedSet)this.keySet()).first();
    }

    public Map.Entry floorEntry(Object object) {
        return this.headMap(object, true).lastEntry();
    }

    public Object floorKey(Object object) {
        return Maps.keyOrNull(this.floorEntry(object));
    }

    public Object get(Object object) {
        int n10;
        ImmutableCollection immutableCollection = this.keySet;
        int n11 = ((RegularImmutableSortedSet)immutableCollection).indexOf(object);
        if (n11 == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            immutableCollection = this.valueList;
            object = immutableCollection.get(n11);
        }
        return object;
    }

    public ImmutableSortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public ImmutableSortedMap headMap(Object object, boolean bl2) {
        RegularImmutableSortedSet regularImmutableSortedSet = this.keySet;
        object = Preconditions.checkNotNull(object);
        int n10 = regularImmutableSortedSet.headIndex(object, bl2);
        return this.getSubMap(0, n10);
    }

    public Map.Entry higherEntry(Object object) {
        return this.tailMap(object, false).firstEntry();
    }

    public Object higherKey(Object object) {
        return Maps.keyOrNull(this.higherEntry(object));
    }

    public boolean isPartialView() {
        ImmutableCollection immutableCollection = this.keySet;
        boolean bl2 = ((RegularImmutableSortedSet)immutableCollection).isPartialView();
        if (!bl2 && !(bl2 = (immutableCollection = this.valueList).isPartialView())) {
            bl2 = false;
            immutableCollection = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public ImmutableSortedSet keySet() {
        return this.keySet;
    }

    public Map.Entry lastEntry() {
        Object object;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            object = this.entrySet().asList();
            int n10 = this.size() + -1;
            object = (Map.Entry)object.get(n10);
        }
        return object;
    }

    public Object lastKey() {
        return ((ImmutableSortedSet)this.keySet()).last();
    }

    public Map.Entry lowerEntry(Object object) {
        return this.headMap(object, false).lastEntry();
    }

    public Object lowerKey(Object object) {
        return Maps.keyOrNull(this.lowerEntry(object));
    }

    public ImmutableSortedSet navigableKeySet() {
        return this.keySet;
    }

    public final Map.Entry pollFirstEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final Map.Entry pollLastEntry() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int size() {
        return this.valueList.size();
    }

    public ImmutableSortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    /*
     * WARNING - void declaration
     */
    public ImmutableSortedMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        void var6_9;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Comparator comparator = this.comparator();
        int bl4 = comparator.compare(object, object2);
        if (bl4 <= 0) {
            boolean bl5 = true;
        } else {
            boolean bl6 = false;
            comparator = null;
        }
        Preconditions.checkArgument((boolean)var6_9, "expected fromKey <= toKey but %s > %s", object, object2);
        return this.headMap(object2, bl3).tailMap(object, bl2);
    }

    public ImmutableSortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public ImmutableSortedMap tailMap(Object object, boolean bl2) {
        RegularImmutableSortedSet regularImmutableSortedSet = this.keySet;
        object = Preconditions.checkNotNull(object);
        int n10 = regularImmutableSortedSet.tailIndex(object, bl2);
        int n11 = this.size();
        return this.getSubMap(n10, n11);
    }

    public ImmutableCollection values() {
        return this.valueList;
    }

    public Object writeReplace() {
        ImmutableSortedMap$SerializedForm immutableSortedMap$SerializedForm = new ImmutableSortedMap$SerializedForm(this);
        return immutableSortedMap$SerializedForm;
    }
}

