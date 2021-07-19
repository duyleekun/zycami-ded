/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$EntrySet;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$KeySet;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$SerializationProxy;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$StrongKeyDummyValueEntry$Helper;
import com.google.common.collect.MapMakerInternalMap$StrongKeyStrongValueEntry$Helper;
import com.google.common.collect.MapMakerInternalMap$StrongKeyWeakValueEntry$Helper;
import com.google.common.collect.MapMakerInternalMap$Values;
import com.google.common.collect.MapMakerInternalMap$WeakKeyDummyValueEntry$Helper;
import com.google.common.collect.MapMakerInternalMap$WeakKeyStrongValueEntry$Helper;
import com.google.common.collect.MapMakerInternalMap$WeakKeyWeakValueEntry$Helper;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MapMakerInternalMap
extends AbstractMap
implements ConcurrentMap,
Serializable {
    public static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
    public static final int CONTAINS_VALUE_RETRIES = 3;
    public static final int DRAIN_MAX = 16;
    public static final int DRAIN_THRESHOLD = 63;
    public static final int MAXIMUM_CAPACITY = 0x40000000;
    public static final int MAX_SEGMENTS = 65536;
    public static final MapMakerInternalMap$WeakValueReference UNSET_WEAK_VALUE_REFERENCE;
    private static final long serialVersionUID = 5L;
    public final int concurrencyLevel;
    public final transient MapMakerInternalMap$InternalEntryHelper entryHelper;
    public transient Set entrySet;
    public final Equivalence keyEquivalence;
    public transient Set keySet;
    public final transient int segmentMask;
    public final transient int segmentShift;
    public final transient MapMakerInternalMap$Segment[] segments;
    public transient Collection values;

    static {
        MapMakerInternalMap$1 mapMakerInternalMap$1 = new MapMakerInternalMap$1();
        UNSET_WEAK_VALUE_REFERENCE = mapMakerInternalMap$1;
    }

    private MapMakerInternalMap(MapMaker mapMakerInternalMap$SegmentArray, MapMakerInternalMap$InternalEntryHelper mapMakerInternalMap$InternalEntryHelper) {
        int n10;
        int n11;
        Equivalence equivalence;
        int n12;
        this.concurrencyLevel = n12 = Math.min(mapMakerInternalMap$SegmentArray.getConcurrencyLevel(), 65536);
        this.keyEquivalence = equivalence = mapMakerInternalMap$SegmentArray.getKeyEquivalence();
        this.entryHelper = mapMakerInternalMap$InternalEntryHelper;
        int n13 = Math.min(mapMakerInternalMap$SegmentArray.getInitialCapacity(), 0x40000000);
        int n14 = 0;
        mapMakerInternalMap$InternalEntryHelper = null;
        n12 = 1;
        int n15 = 0;
        MapMakerInternalMap$Segment[] mapMakerInternalMap$SegmentArray2 = null;
        for (n11 = n12; n11 < (n10 = this.concurrencyLevel); n11 <<= 1) {
            ++n15;
        }
        this.segmentShift = n15 = 32 - n15;
        this.segmentMask = n15 = n11 + -1;
        mapMakerInternalMap$SegmentArray2 = this.newSegmentArray(n11);
        this.segments = mapMakerInternalMap$SegmentArray2;
        if ((n11 *= (n15 = n13 / n11)) < n13) {
            ++n15;
        }
        while (n12 < n15) {
            n12 <<= 1;
        }
        while (n14 < (n11 = (mapMakerInternalMap$SegmentArray = this.segments).length)) {
            MapMakerInternalMap$Segment mapMakerInternalMap$Segment;
            n11 = -1;
            mapMakerInternalMap$SegmentArray[n14] = mapMakerInternalMap$Segment = this.createSegment(n12, n11);
            ++n14;
        }
    }

    public static /* synthetic */ ArrayList access$900(Collection collection) {
        return MapMakerInternalMap.toArrayList(collection);
    }

    public static MapMakerInternalMap create(MapMaker object) {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength;
        Object object2;
        Object object3 = ((MapMaker)object).getKeyStrength();
        if (object3 == (object2 = MapMakerInternalMap$Strength.STRONG) && (object3 = ((MapMaker)object).getValueStrength()) == object2) {
            object2 = MapMakerInternalMap$StrongKeyStrongValueEntry$Helper.instance();
            object3 = new MapMakerInternalMap((MapMaker)object, (MapMakerInternalMap$InternalEntryHelper)object2);
            return object3;
        }
        object3 = ((MapMaker)object).getKeyStrength();
        if (object3 == object2 && (object3 = ((MapMaker)object).getValueStrength()) == (mapMakerInternalMap$Strength = MapMakerInternalMap$Strength.WEAK)) {
            object2 = MapMakerInternalMap$StrongKeyWeakValueEntry$Helper.instance();
            object3 = new MapMakerInternalMap((MapMaker)object, (MapMakerInternalMap$InternalEntryHelper)object2);
            return object3;
        }
        object3 = ((MapMaker)object).getKeyStrength();
        if (object3 == (mapMakerInternalMap$Strength = MapMakerInternalMap$Strength.WEAK) && (object3 = ((MapMaker)object).getValueStrength()) == object2) {
            object2 = MapMakerInternalMap$WeakKeyStrongValueEntry$Helper.instance();
            object3 = new MapMakerInternalMap((MapMaker)object, (MapMakerInternalMap$InternalEntryHelper)object2);
            return object3;
        }
        object3 = ((MapMaker)object).getKeyStrength();
        if (object3 == mapMakerInternalMap$Strength && (object3 = ((MapMaker)object).getValueStrength()) == mapMakerInternalMap$Strength) {
            object2 = MapMakerInternalMap$WeakKeyWeakValueEntry$Helper.instance();
            object3 = new MapMakerInternalMap((MapMaker)object, (MapMakerInternalMap$InternalEntryHelper)object2);
            return object3;
        }
        object = new AssertionError();
        throw object;
    }

    public static MapMakerInternalMap createWithDummyValues(MapMaker object) {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength;
        Object object2;
        Object object3 = object.getKeyStrength();
        if (object3 == (object2 = MapMakerInternalMap$Strength.STRONG) && (object3 = object.getValueStrength()) == object2) {
            object2 = MapMakerInternalMap$StrongKeyDummyValueEntry$Helper.instance();
            object3 = new MapMakerInternalMap((MapMaker)object, (MapMakerInternalMap$InternalEntryHelper)object2);
            return object3;
        }
        object3 = object.getKeyStrength();
        if (object3 == (mapMakerInternalMap$Strength = MapMakerInternalMap$Strength.WEAK) && (object3 = object.getValueStrength()) == object2) {
            object2 = MapMakerInternalMap$WeakKeyDummyValueEntry$Helper.instance();
            object3 = new MapMakerInternalMap((MapMaker)object, (MapMakerInternalMap$InternalEntryHelper)object2);
            return object3;
        }
        if ((object = object.getValueStrength()) == mapMakerInternalMap$Strength) {
            object = new IllegalArgumentException("Map cannot have both weak and dummy values");
            throw object;
        }
        object = new AssertionError();
        throw object;
    }

    public static int rehash(int n10) {
        int n11 = n10 << 15 ^ 0xFFFFCD7D;
        n10 += n11;
        n11 = n10 >>> 10;
        n10 ^= n11;
        n11 = n10 << 3;
        n10 += n11;
        n11 = n10 >>> 6;
        n10 ^= n11;
        n11 = n10 << 2;
        int n12 = n10 << 14;
        n11 = (n10 += (n11 += n12)) >>> 16;
        return n10 ^ n11;
    }

    private static ArrayList toArrayList(Collection object) {
        int n10 = object.size();
        ArrayList arrayList = new ArrayList(n10);
        object = object.iterator();
        Iterators.addAll(arrayList, (Iterator)object);
        return arrayList;
    }

    public static MapMakerInternalMap$WeakValueReference unsetWeakValueReference() {
        return UNSET_WEAK_VALUE_REFERENCE;
    }

    public void clear() {
        for (MapMakerInternalMap$Segment mapMakerInternalMap$Segment : this.segments) {
            mapMakerInternalMap$Segment.clear();
        }
    }

    public boolean containsKey(Object object) {
        if (object == null) {
            return false;
        }
        int n10 = this.hash(object);
        return this.segmentFor(n10).containsKey(object, n10);
    }

    public boolean containsValue(Object object) {
        block7: {
            int n10;
            Object object2 = object;
            Object object3 = false;
            Equivalence equivalence = null;
            if (object == null) {
                return false;
            }
            MapMakerInternalMap$Segment[] mapMakerInternalMap$SegmentArray = this.segments;
            long l10 = -1;
            for (int i10 = 0; i10 < (n10 = 3); ++i10) {
                long l11 = 0L;
                for (MapMakerInternalMap$Segment mapMakerInternalMap$Segment : mapMakerInternalMap$SegmentArray) {
                    int n11;
                    AtomicReferenceArray atomicReferenceArray = mapMakerInternalMap$Segment.table;
                    for (int i11 = 0; i11 < (n11 = atomicReferenceArray.length()); ++i11) {
                        for (MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry = (MapMakerInternalMap$InternalEntry)atomicReferenceArray.get(i11); mapMakerInternalMap$InternalEntry != null; mapMakerInternalMap$InternalEntry = mapMakerInternalMap$InternalEntry.getNext()) {
                            Object object4 = mapMakerInternalMap$Segment.getLiveValue(mapMakerInternalMap$InternalEntry);
                            if (object4 != null && (object3 = (equivalence = this.valueEquivalence()).equivalent(object2, object4))) {
                                return true;
                            }
                            object3 = false;
                            equivalence = null;
                        }
                        object3 = false;
                        equivalence = null;
                    }
                    long l12 = mapMakerInternalMap$Segment.modCount;
                    l11 += l12;
                    object3 = false;
                    equivalence = null;
                }
                object3 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (!object3) {
                    object2 = null;
                    break block7;
                }
                l10 = l11;
                object3 = false;
                equivalence = null;
            }
            object2 = null;
        }
        return false;
    }

    public MapMakerInternalMap$InternalEntry copyEntry(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry2) {
        int n10 = mapMakerInternalMap$InternalEntry.getHash();
        return this.segmentFor(n10).copyEntry(mapMakerInternalMap$InternalEntry, mapMakerInternalMap$InternalEntry2);
    }

    public MapMakerInternalMap$Segment createSegment(int n10, int n11) {
        return this.entryHelper.newSegment(this, n10, n11);
    }

    public Set entrySet() {
        Set set = this.entrySet;
        if (set == null) {
            this.entrySet = set = new MapMakerInternalMap$EntrySet(this);
        }
        return set;
    }

    public Object get(Object object) {
        if (object == null) {
            return null;
        }
        int n10 = this.hash(object);
        return this.segmentFor(n10).get(object, n10);
    }

    public MapMakerInternalMap$InternalEntry getEntry(Object object) {
        if (object == null) {
            return null;
        }
        int n10 = this.hash(object);
        return this.segmentFor(n10).getEntry(object, n10);
    }

    public Object getLiveValue(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        Object object = mapMakerInternalMap$InternalEntry.getKey();
        if (object == null) {
            return null;
        }
        return mapMakerInternalMap$InternalEntry.getValue();
    }

    public int hash(Object object) {
        return MapMakerInternalMap.rehash(this.keyEquivalence.hash(object));
    }

    public boolean isEmpty() {
        int n10;
        int n11;
        MapMakerInternalMap$Segment[] mapMakerInternalMap$SegmentArray = this.segments;
        long l10 = 0L;
        int n12 = 0;
        long l11 = l10;
        for (n11 = 0; n11 < (n10 = mapMakerInternalMap$SegmentArray.length); ++n11) {
            MapMakerInternalMap$Segment mapMakerInternalMap$Segment = mapMakerInternalMap$SegmentArray[n11];
            n10 = mapMakerInternalMap$Segment.count;
            if (n10 != 0) {
                return false;
            }
            mapMakerInternalMap$Segment = mapMakerInternalMap$SegmentArray[n11];
            n10 = mapMakerInternalMap$Segment.modCount;
            long l12 = n10;
            l11 += l12;
        }
        n11 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        n10 = 1;
        if (n11 != 0) {
            int n13;
            for (n11 = 0; n11 < (n13 = mapMakerInternalMap$SegmentArray.length); ++n11) {
                MapMakerInternalMap$Segment mapMakerInternalMap$Segment = mapMakerInternalMap$SegmentArray[n11];
                n13 = mapMakerInternalMap$Segment.count;
                if (n13 != 0) {
                    return false;
                }
                mapMakerInternalMap$Segment = mapMakerInternalMap$SegmentArray[n11];
                n13 = mapMakerInternalMap$Segment.modCount;
                long l13 = n13;
                l11 -= l13;
            }
            Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object == false) {
                n12 = n10;
            }
            return n12 != 0;
        }
        return n10 != 0;
    }

    public boolean isLiveForTesting(MapMakerInternalMap$InternalEntry object) {
        boolean bl2;
        int n10 = object.getHash();
        MapMakerInternalMap$Segment mapMakerInternalMap$Segment = this.segmentFor(n10);
        if ((object = mapMakerInternalMap$Segment.getLiveValueForTesting((MapMakerInternalMap$InternalEntry)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Set keySet() {
        Set set = this.keySet;
        if (set == null) {
            this.keySet = set = new MapMakerInternalMap$KeySet(this);
        }
        return set;
    }

    public MapMakerInternalMap$Strength keyStrength() {
        return this.entryHelper.keyStrength();
    }

    public final MapMakerInternalMap$Segment[] newSegmentArray(int n10) {
        return new MapMakerInternalMap$Segment[n10];
    }

    public Object put(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        int n10 = this.hash(object);
        return this.segmentFor(n10).put(object, n10, object2, false);
    }

    public void putAll(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            this.put(k10, entry);
        }
    }

    public Object putIfAbsent(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        int n10 = this.hash(object);
        return this.segmentFor(n10).put(object, n10, object2, true);
    }

    public void reclaimKey(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        int n10 = mapMakerInternalMap$InternalEntry.getHash();
        this.segmentFor(n10).reclaimKey(mapMakerInternalMap$InternalEntry, n10);
    }

    public void reclaimValue(MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference) {
        Object object = mapMakerInternalMap$WeakValueReference.getEntry();
        int n10 = object.getHash();
        MapMakerInternalMap$Segment mapMakerInternalMap$Segment = this.segmentFor(n10);
        object = object.getKey();
        mapMakerInternalMap$Segment.reclaimValue(object, n10, mapMakerInternalMap$WeakValueReference);
    }

    public Object remove(Object object) {
        if (object == null) {
            return null;
        }
        int n10 = this.hash(object);
        return this.segmentFor(n10).remove(object, n10);
    }

    public boolean remove(Object object, Object object2) {
        if (object != null && object2 != null) {
            int n10 = this.hash(object);
            return this.segmentFor(n10).remove(object, n10, object2);
        }
        return false;
    }

    public Object replace(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        int n10 = this.hash(object);
        return this.segmentFor(n10).replace(object, n10, object2);
    }

    public boolean replace(Object object, Object object2, Object object3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object3);
        if (object2 == null) {
            return false;
        }
        int n10 = this.hash(object);
        return this.segmentFor(n10).replace(object, n10, object2, object3);
    }

    public MapMakerInternalMap$Segment segmentFor(int n10) {
        MapMakerInternalMap$Segment[] mapMakerInternalMap$SegmentArray = this.segments;
        int n11 = this.segmentShift;
        n10 >>>= n11;
        n11 = this.segmentMask;
        return mapMakerInternalMap$SegmentArray[n10 &= n11];
    }

    public int size() {
        int n10;
        MapMakerInternalMap$Segment[] mapMakerInternalMap$SegmentArray = this.segments;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = mapMakerInternalMap$SegmentArray.length); ++i10) {
            MapMakerInternalMap$Segment mapMakerInternalMap$Segment = mapMakerInternalMap$SegmentArray[i10];
            n10 = mapMakerInternalMap$Segment.count;
            long l11 = n10;
            l10 += l11;
        }
        return Ints.saturatedCast(l10);
    }

    public Equivalence valueEquivalence() {
        return this.entryHelper.valueStrength().defaultEquivalence();
    }

    public MapMakerInternalMap$Strength valueStrength() {
        return this.entryHelper.valueStrength();
    }

    public Collection values() {
        Collection collection = this.values;
        if (collection == null) {
            this.values = collection = new MapMakerInternalMap$Values(this);
        }
        return collection;
    }

    public Object writeReplace() {
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength = this.entryHelper.keyStrength();
        MapMakerInternalMap$Strength mapMakerInternalMap$Strength2 = this.entryHelper.valueStrength();
        Equivalence equivalence = this.keyEquivalence;
        Equivalence equivalence2 = this.entryHelper.valueStrength().defaultEquivalence();
        int n10 = this.concurrencyLevel;
        MapMakerInternalMap$SerializationProxy mapMakerInternalMap$SerializationProxy = new MapMakerInternalMap$SerializationProxy(mapMakerInternalMap$Strength, mapMakerInternalMap$Strength2, equivalence, equivalence2, n10, this);
        return mapMakerInternalMap$SerializationProxy;
    }
}

