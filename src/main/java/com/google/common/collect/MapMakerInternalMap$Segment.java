/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$InternalEntryHelper;
import com.google.common.collect.MapMakerInternalMap$WeakValueEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

public abstract class MapMakerInternalMap$Segment
extends ReentrantLock {
    public volatile int count;
    public final MapMakerInternalMap map;
    public final int maxSegmentSize;
    public int modCount;
    public final AtomicInteger readCount;
    public volatile AtomicReferenceArray table;
    public int threshold;

    public MapMakerInternalMap$Segment(MapMakerInternalMap serializable, int n10, int n11) {
        AtomicInteger atomicInteger;
        this.readCount = atomicInteger = new AtomicInteger();
        this.map = serializable;
        this.maxSegmentSize = n11;
        serializable = this.newEntryArray(n10);
        this.initTable((AtomicReferenceArray)serializable);
    }

    public static boolean isCollected(MapMakerInternalMap$InternalEntry object) {
        boolean bl2;
        if ((object = object.getValue()) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public abstract MapMakerInternalMap$InternalEntry castForTesting(MapMakerInternalMap$InternalEntry var1);

    public void clear() {
        int n10 = this.count;
        if (n10 != 0) {
            this.lock();
            Serializable serializable = this.table;
            int n11 = 0;
            while (true) {
                int n12 = ((AtomicReferenceArray)serializable).length();
                if (n11 >= n12) break;
                n12 = 0;
                ((AtomicReferenceArray)serializable).set(n11, null);
                ++n11;
                continue;
                break;
            }
            try {
                this.maybeClearReferenceQueues();
                serializable = this.readCount;
                ((AtomicInteger)serializable).set(0);
                this.modCount = n10 = this.modCount + 1;
                this.count = 0;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                this.unlock();
            }
        }
    }

    public void clearReferenceQueue(ReferenceQueue referenceQueue) {
        Reference reference;
        while ((reference = referenceQueue.poll()) != null) {
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean clearValueForTesting(Object var1_1, int var2_3, MapMakerInternalMap$WeakValueReference var3_4) {
        this.lock();
        var4_5 = this.table;
        var5_6 = var4_5.length();
        var6_7 = 1;
        var5_6 = var5_6 - var6_7 & var2_3;
        var7_8 = var4_5.get(var5_6);
        ** try [egrp 3[TRYBLOCK] [3 : 38->43)] { 
lbl11:
        // 2 sources

        for (var8_9 = var7_8 = (MapMakerInternalMap$InternalEntry)var7_8; var8_9 != null; var8_9 = var8_9.getNext()) {
            block17: {
                block18: {
                    var9_10 = var8_9.getKey();
                    var10_11 = var8_9.getHash();
                    if (var10_11 != var2_3 || var9_10 == null) break block17;
                    var11_12 = this.map;
                    var11_12 = var11_12.keyEquivalence;
                    var12_13 = var11_12.equivalent(var1_1, var9_10);
                    if (!var12_13) break block17;
                    var1_1 = var8_9;
                    var1_1 = (MapMakerInternalMap$WeakValueEntry)var8_9;
                    var1_1 = var1_1.getValueReference();
                    if (var1_1 != var3_4) break block18;
                    var1_1 = this.removeFromChain((MapMakerInternalMap$InternalEntry)var7_8, (MapMakerInternalMap$InternalEntry)var8_9);
                    var4_5.set(var5_6, var1_1);
                    return (boolean)var6_7;
                }
                this.unlock();
                return false;
            }
            continue;
        }
        this.unlock();
        return false;
lbl42:
        // 12 sources

        catch (Throwable var1_2) {
            throw var1_2;
        }
        finally {
            this.unlock();
        }
    }

    public boolean containsKey(Object object, int n10) {
        block4: {
            boolean bl2;
            block5: {
                try {
                    int n11 = this.count;
                    bl2 = false;
                    if (n11 == 0) break block4;
                }
                catch (Throwable throwable) {
                    this.postReadCleanup();
                    throw throwable;
                }
                object = this.getLiveEntry(object, n10);
                if (object == null) break block5;
                object = object.getValue();
                if (object == null) break block5;
                bl2 = true;
            }
            this.postReadCleanup();
            return bl2;
        }
        this.postReadCleanup();
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsValue(Object object) {
        try {
            int n10 = this.count;
            if (n10 == 0) return false;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n11 = atomicReferenceArray.length();
            for (int i10 = 0; i10 < n11; ++i10) {
                Object object2 = atomicReferenceArray.get(i10);
                for (object2 = (MapMakerInternalMap$InternalEntry)object2; object2 != null; object2 = object2.getNext()) {
                    Object object3 = this.getLiveValue((MapMakerInternalMap$InternalEntry)object2);
                    if (object3 == null) continue;
                    Object object4 = this.map;
                    boolean bl2 = ((Equivalence)(object4 = ((MapMakerInternalMap)object4).valueEquivalence())).equivalent(object, object3);
                    if (!bl2) continue;
                    this.postReadCleanup();
                    return true;
                }
            }
            return false;
        }
        finally {
            this.postReadCleanup();
        }
    }

    public MapMakerInternalMap$InternalEntry copyEntry(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry2) {
        MapMakerInternalMap$InternalEntryHelper mapMakerInternalMap$InternalEntryHelper = this.map.entryHelper;
        MapMakerInternalMap$Segment mapMakerInternalMap$Segment = this.self();
        return mapMakerInternalMap$InternalEntryHelper.copy(mapMakerInternalMap$Segment, mapMakerInternalMap$InternalEntry, mapMakerInternalMap$InternalEntry2);
    }

    public MapMakerInternalMap$InternalEntry copyForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry2) {
        MapMakerInternalMap$InternalEntryHelper mapMakerInternalMap$InternalEntryHelper = this.map.entryHelper;
        MapMakerInternalMap$Segment mapMakerInternalMap$Segment = this.self();
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        mapMakerInternalMap$InternalEntry2 = this.castForTesting(mapMakerInternalMap$InternalEntry2);
        return mapMakerInternalMap$InternalEntryHelper.copy(mapMakerInternalMap$Segment, mapMakerInternalMap$InternalEntry, mapMakerInternalMap$InternalEntry2);
    }

    public void drainKeyReferenceQueue(ReferenceQueue referenceQueue) {
        Object object;
        int n10 = 0;
        while ((object = referenceQueue.poll()) != null) {
            object = (MapMakerInternalMap$InternalEntry)object;
            MapMakerInternalMap mapMakerInternalMap = this.map;
            mapMakerInternalMap.reclaimKey((MapMakerInternalMap$InternalEntry)object);
            int n11 = 16;
            if (++n10 != n11) continue;
        }
    }

    public void drainValueReferenceQueue(ReferenceQueue referenceQueue) {
        Object object;
        int n10 = 0;
        while ((object = referenceQueue.poll()) != null) {
            object = (MapMakerInternalMap$WeakValueReference)object;
            MapMakerInternalMap mapMakerInternalMap = this.map;
            mapMakerInternalMap.reclaimValue((MapMakerInternalMap$WeakValueReference)object);
            int n11 = 16;
            if (++n10 != n11) continue;
        }
    }

    public void expand() {
        int n10;
        int n11;
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n12 = atomicReferenceArray.length();
        if (n12 >= (n11 = 0x40000000)) {
            return;
        }
        n11 = this.count;
        int n13 = n12 << 1;
        AtomicReferenceArray atomicReferenceArray2 = this.newEntryArray(n13);
        this.threshold = n10 = atomicReferenceArray2.length() * 3 / 4;
        n10 = atomicReferenceArray2.length() + -1;
        for (int i10 = 0; i10 < n12; ++i10) {
            MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry;
            MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry2 = (MapMakerInternalMap$InternalEntry)atomicReferenceArray.get(i10);
            if (mapMakerInternalMap$InternalEntry2 == null) continue;
            int n14 = mapMakerInternalMap$InternalEntry2.getHash() & n10;
            if (mapMakerInternalMap$InternalEntry == null) {
                atomicReferenceArray2.set(n14, mapMakerInternalMap$InternalEntry2);
                continue;
            }
            MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry3 = mapMakerInternalMap$InternalEntry2;
            for (mapMakerInternalMap$InternalEntry = mapMakerInternalMap$InternalEntry2.getNext(); mapMakerInternalMap$InternalEntry != null; mapMakerInternalMap$InternalEntry = mapMakerInternalMap$InternalEntry.getNext()) {
                int n15 = mapMakerInternalMap$InternalEntry.getHash() & n10;
                if (n15 == n14) continue;
                mapMakerInternalMap$InternalEntry3 = mapMakerInternalMap$InternalEntry;
                n14 = n15;
            }
            atomicReferenceArray2.set(n14, mapMakerInternalMap$InternalEntry3);
            while (mapMakerInternalMap$InternalEntry2 != mapMakerInternalMap$InternalEntry3) {
                int n16 = mapMakerInternalMap$InternalEntry2.getHash() & n10;
                MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry4 = (MapMakerInternalMap$InternalEntry)atomicReferenceArray2.get(n16);
                if ((mapMakerInternalMap$InternalEntry4 = this.copyEntry(mapMakerInternalMap$InternalEntry2, mapMakerInternalMap$InternalEntry4)) != null) {
                    atomicReferenceArray2.set(n16, mapMakerInternalMap$InternalEntry4);
                } else {
                    n11 += -1;
                }
                mapMakerInternalMap$InternalEntry2 = mapMakerInternalMap$InternalEntry2.getNext();
            }
        }
        this.table = atomicReferenceArray2;
        this.count = n11;
    }

    public Object get(Object object, int n10) {
        block6: {
            block5: {
                object = this.getLiveEntry(object, n10);
                if (object != null) break block5;
                this.postReadCleanup();
                return null;
            }
            object = object.getValue();
            if (object != null) break block6;
            this.tryDrainReferenceQueues();
        }
        return object;
        finally {
            this.postReadCleanup();
        }
    }

    public MapMakerInternalMap$InternalEntry getEntry(Object object, int n10) {
        int n11 = this.count;
        if (n11 != 0) {
            for (MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry = this.getFirst(n10); mapMakerInternalMap$InternalEntry != null; mapMakerInternalMap$InternalEntry = mapMakerInternalMap$InternalEntry.getNext()) {
                int n12 = mapMakerInternalMap$InternalEntry.getHash();
                if (n12 != n10) continue;
                Object object2 = mapMakerInternalMap$InternalEntry.getKey();
                if (object2 == null) {
                    this.tryDrainReferenceQueues();
                    continue;
                }
                Equivalence equivalence = this.map.keyEquivalence;
                n12 = (int)(equivalence.equivalent(object, object2) ? 1 : 0);
                if (n12 == 0) continue;
                return mapMakerInternalMap$InternalEntry;
            }
        }
        return null;
    }

    public MapMakerInternalMap$InternalEntry getFirst(int n10) {
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length() + -1;
        return (MapMakerInternalMap$InternalEntry)atomicReferenceArray.get(n10 &= n11);
    }

    public ReferenceQueue getKeyReferenceQueueForTesting() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public MapMakerInternalMap$InternalEntry getLiveEntry(Object object, int n10) {
        return this.getEntry(object, n10);
    }

    public Object getLiveValue(MapMakerInternalMap$InternalEntry object) {
        Object object2 = object.getKey();
        if (object2 == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        if ((object = object.getValue()) == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        return object;
    }

    public Object getLiveValueForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        return this.getLiveValue(mapMakerInternalMap$InternalEntry);
    }

    public ReferenceQueue getValueReferenceQueueForTesting() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public MapMakerInternalMap$WeakValueReference getWeakValueReferenceForTesting(MapMakerInternalMap$InternalEntry object) {
        object = new AssertionError();
        throw object;
    }

    public void initTable(AtomicReferenceArray atomicReferenceArray) {
        int n10;
        this.threshold = n10 = atomicReferenceArray.length() * 3 / 4;
        int n11 = this.maxSegmentSize;
        if (n10 == n11) {
            this.threshold = ++n10;
        }
        this.table = atomicReferenceArray;
    }

    public void maybeClearReferenceQueues() {
    }

    public void maybeDrainReferenceQueues() {
    }

    public AtomicReferenceArray newEntryArray(int n10) {
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(n10);
        return atomicReferenceArray;
    }

    public MapMakerInternalMap$InternalEntry newEntryForTesting(Object object, int n10, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        MapMakerInternalMap$InternalEntryHelper mapMakerInternalMap$InternalEntryHelper = this.map.entryHelper;
        MapMakerInternalMap$Segment mapMakerInternalMap$Segment = this.self();
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        return mapMakerInternalMap$InternalEntryHelper.newEntry(mapMakerInternalMap$Segment, object, n10, mapMakerInternalMap$InternalEntry);
    }

    public MapMakerInternalMap$WeakValueReference newWeakValueReferenceForTesting(MapMakerInternalMap$InternalEntry object, Object object2) {
        object = new AssertionError();
        throw object;
    }

    public void postReadCleanup() {
        AtomicInteger atomicInteger = this.readCount;
        int n10 = atomicInteger.incrementAndGet() & 0x3F;
        if (n10 == 0) {
            this.runCleanup();
        }
    }

    public void preWriteCleanup() {
        this.runLockedCleanup();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object put(Object object, int n10, Object object2, boolean bl2) {
        int n11;
        Object e10;
        this.lock();
        this.preWriteCleanup();
        int n12 = this.count + 1;
        int n13 = this.threshold;
        if (n12 > n13) {
            this.expand();
            n12 = this.count + 1;
        }
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n14 = atomicReferenceArray.length() + -1 & n10;
        Object e11 = atomicReferenceArray.get(n14);
        for (e10 = e11 = (MapMakerInternalMap$InternalEntry)e11; e10 != null; e10 = e10.getNext()) {
            Object object3 = e10.getKey();
            int n15 = e10.getHash();
            if (n15 != n10 || object3 == null) continue;
            Object object4 = this.map;
            object4 = ((MapMakerInternalMap)object4).keyEquivalence;
            boolean bl3 = ((Equivalence)object4).equivalent(object, object3);
            if (!bl3) continue;
            object = e10.getValue();
            if (object == null) {
                int n16;
                this.modCount = n16 = this.modCount + 1;
                this.setValue((MapMakerInternalMap$InternalEntry)e10, object2);
                this.count = n16 = this.count;
                this.unlock();
                return null;
            }
            if (bl2) {
                this.unlock();
                return object;
            }
            this.modCount = n10 = this.modCount + 1;
            this.setValue((MapMakerInternalMap$InternalEntry)e10, object2);
            return object;
        }
        this.modCount = n11 = this.modCount + 1;
        Object object5 = this.map;
        object5 = ((MapMakerInternalMap)object5).entryHelper;
        e10 = this.self();
        object = object5.newEntry((MapMakerInternalMap$Segment)e10, object, n10, (MapMakerInternalMap$InternalEntry)e11);
        this.setValue((MapMakerInternalMap$InternalEntry)object, object2);
        atomicReferenceArray.set(n14, object);
        this.count = n12;
        this.unlock();
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean reclaimKey(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, int n10) {
        Object object;
        Object object2;
        int n11;
        int n12;
        AtomicReferenceArray atomicReferenceArray;
        this.lock();
        try {
            atomicReferenceArray = this.table;
            n12 = atomicReferenceArray.length();
            n11 = 1;
            object2 = atomicReferenceArray.get(n10 &= (n12 -= n11));
            object = object2 = (MapMakerInternalMap$InternalEntry)object2;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.unlock();
        }
        while (true) {
            if (object == null) {
                this.unlock();
                return false;
            }
            if (object == mapMakerInternalMap$InternalEntry) {
                int n13;
                this.modCount = n13 = this.modCount + n11;
                mapMakerInternalMap$InternalEntry = this.removeFromChain((MapMakerInternalMap$InternalEntry)object2, (MapMakerInternalMap$InternalEntry)object);
                n12 = this.count - n11;
                atomicReferenceArray.set(n10, mapMakerInternalMap$InternalEntry);
                this.count = n12;
                return n11 != 0;
            }
            object = object.getNext();
            continue;
            break;
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public boolean reclaimValue(Object object, int n10, MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference) {
        Object e10;
        this.lock();
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length();
        int n12 = 1;
        n11 = n11 - n12 & n10;
        Object e11 = atomicReferenceArray.get(n11);
        for (e10 = e11 = (MapMakerInternalMap$InternalEntry)e11; e10 != null; e10 = e10.getNext()) {
            Object object2 = e10.getKey();
            int n13 = e10.getHash();
            if (n13 != n10 || object2 == null) break block8;
            Object object3 = this.map;
            object3 = ((MapMakerInternalMap)object3).keyEquivalence;
            boolean bl2 = ((Equivalence)object3).equivalent(object, object2);
            if (!bl2) break block8;
            object = e10;
            object = (MapMakerInternalMap$WeakValueEntry)e10;
            if ((object = object.getValueReference()) != mapMakerInternalMap$WeakValueReference) break block9;
        }
        {
            block8: {
                block9: {
                    int n14;
                    this.modCount = n14 = this.modCount + n12;
                    object = this.removeFromChain((MapMakerInternalMap$InternalEntry)e11, (MapMakerInternalMap$InternalEntry)e10);
                    n10 = this.count - n12;
                    atomicReferenceArray.set(n11, object);
                    this.count = n10;
                    return n12 != 0;
                }
                this.unlock();
                return false;
            }
            continue;
        }
        this.unlock();
        return false;
        finally {
            this.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object remove(Object object, int n10) {
        this.lock();
        try {
            this.preWriteCleanup();
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n11 = atomicReferenceArray.length() + -1 & n10;
            Object object2 = atomicReferenceArray.get(n11);
            Object object3 = object2 = (MapMakerInternalMap$InternalEntry)object2;
            while (object3 != null) {
                Object object4 = object3.getKey();
                int n12 = object3.getHash();
                if (n12 == n10 && object4 != null) {
                    Object object5 = this.map;
                    object5 = ((MapMakerInternalMap)object5).keyEquivalence;
                    boolean bl2 = ((Equivalence)object5).equivalent(object, object4);
                    if (bl2) {
                        object = object3.getValue();
                        if (object == null) {
                            n10 = (int)(MapMakerInternalMap$Segment.isCollected((MapMakerInternalMap$InternalEntry)object3) ? 1 : 0);
                            if (n10 == 0) return null;
                        }
                        this.modCount = n10 = this.modCount + 1;
                        MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry = this.removeFromChain((MapMakerInternalMap$InternalEntry)object2, (MapMakerInternalMap$InternalEntry)object3);
                        int n13 = this.count + -1;
                        atomicReferenceArray.set(n11, mapMakerInternalMap$InternalEntry);
                        this.count = n13;
                        return object;
                    }
                }
                object3 = object3.getNext();
            }
            return null;
        }
        finally {
            this.unlock();
        }
    }

    public boolean remove(Object object, int n10, Object object2) {
        Object object3;
        this.lock();
        this.preWriteCleanup();
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length();
        int n12 = 1;
        n11 = n11 - n12 & n10;
        Object object4 = atomicReferenceArray.get(n11);
        try {
            object3 = object4 = (MapMakerInternalMap$InternalEntry)object4;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.unlock();
        }
        while (true) {
            block24: {
                block26: {
                    int n13;
                    int n14;
                    block25: {
                        n14 = 0;
                        if (object3 == null) break;
                        Object object5 = object3.getKey();
                        int n15 = object3.getHash();
                        if (n15 != n10 || object5 == null) break block24;
                        Object object6 = this.map;
                        object6 = ((MapMakerInternalMap)object6).keyEquivalence;
                        boolean bl2 = ((Equivalence)object6).equivalent(object, object5);
                        if (!bl2) break block24;
                        object = object3.getValue();
                        Object object7 = this.map;
                        object7 = ((MapMakerInternalMap)object7).valueEquivalence();
                        boolean n132 = ((Equivalence)object7).equivalent(object2, object);
                        if (!n132) break block25;
                        n14 = n12;
                    }
                    boolean bl2 = MapMakerInternalMap$Segment.isCollected((MapMakerInternalMap$InternalEntry)object3);
                    if (!bl2) break block26;
                    this.modCount = n13 = this.modCount + n12;
                    object = this.removeFromChain((MapMakerInternalMap$InternalEntry)object4, (MapMakerInternalMap$InternalEntry)object3);
                    n10 = this.count - n12;
                    atomicReferenceArray.set(n11, object);
                    this.count = n10;
                    return n14 != 0;
                }
                this.unlock();
                return false;
            }
            object3 = object3.getNext();
            continue;
            break;
        }
        this.unlock();
        return false;
    }

    public boolean removeEntryForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry2;
        int n10 = mapMakerInternalMap$InternalEntry.getHash();
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length();
        int n12 = 1;
        for (MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry3 = mapMakerInternalMap$InternalEntry2 = (MapMakerInternalMap$InternalEntry)atomicReferenceArray.get(n10 &= (n11 -= n12)); mapMakerInternalMap$InternalEntry3 != null; mapMakerInternalMap$InternalEntry3 = mapMakerInternalMap$InternalEntry3.getNext()) {
            int n13;
            if (mapMakerInternalMap$InternalEntry3 != mapMakerInternalMap$InternalEntry) continue;
            this.modCount = n13 = this.modCount + n12;
            mapMakerInternalMap$InternalEntry = this.removeFromChain(mapMakerInternalMap$InternalEntry2, mapMakerInternalMap$InternalEntry3);
            n11 = this.count - n12;
            atomicReferenceArray.set(n10, mapMakerInternalMap$InternalEntry);
            this.count = n11;
            return n12 != 0;
        }
        return false;
    }

    public MapMakerInternalMap$InternalEntry removeFromChain(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry2) {
        int n10 = this.count;
        MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry3 = mapMakerInternalMap$InternalEntry2.getNext();
        while (mapMakerInternalMap$InternalEntry != mapMakerInternalMap$InternalEntry2) {
            MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry4 = this.copyEntry(mapMakerInternalMap$InternalEntry, mapMakerInternalMap$InternalEntry3);
            if (mapMakerInternalMap$InternalEntry4 != null) {
                mapMakerInternalMap$InternalEntry3 = mapMakerInternalMap$InternalEntry4;
            } else {
                n10 += -1;
            }
            mapMakerInternalMap$InternalEntry = mapMakerInternalMap$InternalEntry.getNext();
        }
        this.count = n10;
        return mapMakerInternalMap$InternalEntry3;
    }

    public MapMakerInternalMap$InternalEntry removeFromChainForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry2) {
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        mapMakerInternalMap$InternalEntry2 = this.castForTesting(mapMakerInternalMap$InternalEntry2);
        return this.removeFromChain(mapMakerInternalMap$InternalEntry, mapMakerInternalMap$InternalEntry2);
    }

    public boolean removeTableEntryForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        return this.removeEntryForTesting(mapMakerInternalMap$InternalEntry);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object replace(Object object, int n10, Object object2) {
        this.lock();
        try {
            this.preWriteCleanup();
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n11 = atomicReferenceArray.length() + -1 & n10;
            Object object3 = atomicReferenceArray.get(n11);
            Object object4 = object3 = (MapMakerInternalMap$InternalEntry)object3;
            while (object4 != null) {
                Object object5 = object4.getKey();
                int n12 = object4.getHash();
                if (n12 == n10 && object5 != null) {
                    Object object6 = this.map;
                    object6 = ((MapMakerInternalMap)object6).keyEquivalence;
                    boolean bl2 = ((Equivalence)object6).equivalent(object, object5);
                    if (bl2) {
                        object = object4.getValue();
                        if (object == null) {
                            int n13 = MapMakerInternalMap$Segment.isCollected((MapMakerInternalMap$InternalEntry)object4);
                            if (n13 == 0) return null;
                            this.modCount = n13 = this.modCount + 1;
                            object = this.removeFromChain((MapMakerInternalMap$InternalEntry)object3, (MapMakerInternalMap$InternalEntry)object4);
                            n10 = this.count + -1;
                            atomicReferenceArray.set(n11, object);
                            this.count = n10;
                            return null;
                        }
                        this.modCount = n10 = this.modCount + 1;
                        this.setValue((MapMakerInternalMap$InternalEntry)object4, object2);
                        return object;
                    }
                }
                object4 = object4.getNext();
            }
            return null;
        }
        finally {
            this.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean replace(Object object, int n10, Object object2, Object object3) {
        this.lock();
        this.preWriteCleanup();
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length();
        int n12 = 1;
        n11 = n11 - n12 & n10;
        Object object4 = atomicReferenceArray.get(n11);
        Object object5 = object4 = (MapMakerInternalMap$InternalEntry)object4;
        while (object5 != null) {
            Object object6 = object5.getKey();
            int n13 = object5.getHash();
            if (n13 == n10 && object6 != null) {
                Object object7 = this.map;
                object7 = ((MapMakerInternalMap)object7).keyEquivalence;
                boolean bl2 = ((Equivalence)object7).equivalent(object, object6);
                if (bl2) {
                    object = object5.getValue();
                    if (object == null) {
                        int n14 = MapMakerInternalMap$Segment.isCollected((MapMakerInternalMap$InternalEntry)object5);
                        if (n14 == 0) return false;
                        this.modCount = n14 = this.modCount + n12;
                        object = this.removeFromChain((MapMakerInternalMap$InternalEntry)object4, (MapMakerInternalMap$InternalEntry)object5);
                        n10 = this.count - n12;
                        atomicReferenceArray.set(n11, object);
                        this.count = n10;
                        return false;
                    }
                    Object object8 = this.map;
                    int n15 = ((Equivalence)(object8 = ((MapMakerInternalMap)object8).valueEquivalence())).equivalent(object2, object);
                    if (n15 == 0) return false;
                    this.modCount = n15 = this.modCount + n12;
                    this.setValue((MapMakerInternalMap$InternalEntry)object5, object3);
                    return n12 != 0;
                }
            }
            object5 = object5.getNext();
        }
        return false;
    }

    public void runCleanup() {
        this.runLockedCleanup();
    }

    public void runLockedCleanup() {
        boolean bl2 = this.tryLock();
        if (bl2) {
            try {
                this.maybeDrainReferenceQueues();
                AtomicInteger atomicInteger = this.readCount;
                atomicInteger.set(0);
            }
            finally {
                this.unlock();
            }
        }
    }

    public abstract MapMakerInternalMap$Segment self();

    public void setTableEntryForTesting(int n10, MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        AtomicReferenceArray atomicReferenceArray = this.table;
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        atomicReferenceArray.set(n10, mapMakerInternalMap$InternalEntry);
    }

    public void setValue(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, Object object) {
        MapMakerInternalMap$InternalEntryHelper mapMakerInternalMap$InternalEntryHelper = this.map.entryHelper;
        MapMakerInternalMap$Segment mapMakerInternalMap$Segment = this.self();
        mapMakerInternalMap$InternalEntryHelper.setValue(mapMakerInternalMap$Segment, mapMakerInternalMap$InternalEntry, object);
    }

    public void setValueForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, Object object) {
        MapMakerInternalMap$InternalEntryHelper mapMakerInternalMap$InternalEntryHelper = this.map.entryHelper;
        MapMakerInternalMap$Segment mapMakerInternalMap$Segment = this.self();
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        mapMakerInternalMap$InternalEntryHelper.setValue(mapMakerInternalMap$Segment, mapMakerInternalMap$InternalEntry, object);
    }

    public void setWeakValueReferenceForTesting(MapMakerInternalMap$InternalEntry object, MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference) {
        object = new AssertionError();
        throw object;
    }

    public void tryDrainReferenceQueues() {
        boolean bl2 = this.tryLock();
        if (bl2) {
            try {
                this.maybeDrainReferenceQueues();
            }
            finally {
                this.unlock();
            }
        }
    }
}

