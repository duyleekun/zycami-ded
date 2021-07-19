/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$InvalidCacheLoadException;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$LoadingValueReference;
import com.google.common.cache.LocalCache$Segment$1;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalNotification;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

public class LocalCache$Segment
extends ReentrantLock {
    public final Queue accessQueue;
    public volatile int count;
    public final ReferenceQueue keyReferenceQueue;
    public final LocalCache map;
    public final long maxSegmentWeight;
    public int modCount;
    public final AtomicInteger readCount;
    public final Queue recencyQueue;
    public final AbstractCache$StatsCounter statsCounter;
    public volatile AtomicReferenceArray table;
    public int threshold;
    public long totalWeight;
    public final ReferenceQueue valueReferenceQueue;
    public final Queue writeQueue;

    public LocalCache$Segment(LocalCache object, int n10, long l10, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        AtomicInteger atomicInteger;
        this.readCount = atomicInteger = new AtomicInteger();
        this.map = object;
        this.maxSegmentWeight = l10;
        ReferenceQueue referenceQueue = (AbstractCache$StatsCounter)Preconditions.checkNotNull(abstractCache$StatsCounter);
        this.statsCounter = referenceQueue;
        Queue queue = this.newEntryArray(n10);
        this.initTable((AtomicReferenceArray)((Object)queue));
        n10 = (int)(((LocalCache)object).usesKeyReferences() ? 1 : 0);
        referenceQueue = null;
        if (n10 != 0) {
            queue = new Queue();
        } else {
            n10 = 0;
            queue = null;
        }
        this.keyReferenceQueue = queue;
        n10 = (int)(((LocalCache)object).usesValueReferences() ? 1 : 0);
        if (n10 != 0) {
            referenceQueue = new ReferenceQueue();
        }
        this.valueReferenceQueue = referenceQueue;
        n10 = (int)(((LocalCache)object).usesAccessQueue() ? 1 : 0);
        queue = n10 != 0 ? new Queue() : LocalCache.discardingQueue();
        this.recencyQueue = queue;
        n10 = (int)(((LocalCache)object).usesWriteQueue() ? 1 : 0);
        if (n10 != 0) {
        } else {
            queue = LocalCache.discardingQueue();
        }
        this.writeQueue = queue;
        boolean bl2 = ((LocalCache)object).usesAccessQueue();
        object = bl2 ? new LocalCache$AccessQueue() : LocalCache.discardingQueue();
        this.accessQueue = object;
    }

    public void cleanUp() {
        long l10 = this.map.ticker.read();
        this.runLockedCleanup(l10);
        this.runUnlockedCleanup();
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        int n10 = this.count;
        if (n10 != 0) {
            this.lock();
            try {
                Object object;
                int n11;
                int n12;
                Object object2 = this.map;
                object2 = ((LocalCache)object2).ticker;
                long l10 = ((Ticker)object2).read();
                this.preWriteCleanup(l10);
                object2 = this.table;
                for (n12 = 0; n12 < (n11 = ((AtomicReferenceArray)object2).length()); ++n12) {
                    object = ((AtomicReferenceArray)object2).get(n12);
                    for (object = (ReferenceEntry)object; object != null; object = object.getNext()) {
                        Object object3 = object.getValueReference();
                        boolean bl2 = object3.isActive();
                        if (!bl2) continue;
                        Object object4 = object.getKey();
                        object3 = object.getValueReference();
                        Object object5 = object3.get();
                        object3 = object4 != null && object5 != null ? RemovalCause.EXPLICIT : RemovalCause.COLLECTED;
                        Object object6 = object3;
                        int n13 = object.getHash();
                        object3 = object.getValueReference();
                        int n14 = object3.getWeight();
                        this.enqueueNotification(object4, n13, object5, n14, (RemovalCause)((Object)object6));
                    }
                }
                for (n12 = 0; n12 < (n11 = ((AtomicReferenceArray)object2).length()); ++n12) {
                    n11 = 0;
                    object = null;
                    ((AtomicReferenceArray)object2).set(n12, null);
                }
                this.clearReferenceQueues();
                object2 = this.writeQueue;
                object2.clear();
                object2 = this.accessQueue;
                object2.clear();
                object2 = this.readCount;
                ((AtomicInteger)object2).set(0);
                this.modCount = n10 = this.modCount + 1;
                this.count = 0;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
    }

    public void clearKeyReferenceQueue() {
        Reference reference;
        while ((reference = this.keyReferenceQueue.poll()) != null) {
        }
    }

    public void clearReferenceQueues() {
        LocalCache localCache = this.map;
        boolean bl2 = localCache.usesKeyReferences();
        if (bl2) {
            this.clearKeyReferenceQueue();
        }
        if (bl2 = (localCache = this.map).usesValueReferences()) {
            this.clearValueReferenceQueue();
        }
    }

    public void clearValueReferenceQueue() {
        Reference reference;
        while ((reference = this.valueReferenceQueue.poll()) != null) {
        }
    }

    public boolean containsKey(Object object, int n10) {
        block9: {
            boolean bl2;
            block10: {
                try {
                    int n11 = this.count;
                    bl2 = false;
                    if (n11 == 0) break block9;
                }
                catch (Throwable throwable) {
                    this.postReadCleanup();
                    throw throwable;
                }
                Object object2 = this.map;
                object2 = ((LocalCache)object2).ticker;
                long l10 = ((Ticker)object2).read();
                object = this.getLiveEntry(object, n10, l10);
                if (object != null) break block10;
                this.postReadCleanup();
                return false;
            }
            object = object.getValueReference();
            object = object.get();
            if (object != null) {
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
            Object object2 = this.map;
            object2 = ((LocalCache)object2).ticker;
            long l10 = ((Ticker)object2).read();
            object2 = this.table;
            int n11 = ((AtomicReferenceArray)object2).length();
            for (int i10 = 0; i10 < n11; ++i10) {
                Object object3 = ((AtomicReferenceArray)object2).get(i10);
                for (object3 = (ReferenceEntry)object3; object3 != null; object3 = object3.getNext()) {
                    Object object4 = this.getLiveValue((ReferenceEntry)object3, l10);
                    if (object4 == null) continue;
                    Object object5 = this.map;
                    object5 = ((LocalCache)object5).valueEquivalence;
                    boolean bl2 = ((Equivalence)object5).equivalent(object, object4);
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

    public ReferenceEntry copyEntry(ReferenceEntry referenceEntry, ReferenceEntry object) {
        boolean bl2;
        Object object2 = referenceEntry.getKey();
        if (object2 == null) {
            return null;
        }
        object2 = referenceEntry.getValueReference();
        Object object3 = object2.get();
        if (object3 == null && (bl2 = object2.isActive())) {
            return null;
        }
        referenceEntry = this.map.entryFactory.copyEntry(this, referenceEntry, (ReferenceEntry)object);
        object = this.valueReferenceQueue;
        object = object2.copyFor((ReferenceQueue)object, object3, referenceEntry);
        referenceEntry.setValueReference((LocalCache$ValueReference)object);
        return referenceEntry;
    }

    public void drainKeyReferenceQueue() {
        Object object;
        int n10 = 0;
        while ((object = this.keyReferenceQueue.poll()) != null) {
            object = (ReferenceEntry)object;
            LocalCache localCache = this.map;
            localCache.reclaimKey((ReferenceEntry)object);
            int n11 = 16;
            if (++n10 != n11) continue;
        }
    }

    public void drainRecencyQueue() {
        ReferenceEntry referenceEntry;
        while ((referenceEntry = (ReferenceEntry)this.recencyQueue.poll()) != null) {
            Queue queue = this.accessQueue;
            boolean bl2 = queue.contains(referenceEntry);
            if (!bl2) continue;
            queue = this.accessQueue;
            queue.add(referenceEntry);
        }
    }

    public void drainReferenceQueues() {
        LocalCache localCache = this.map;
        boolean bl2 = localCache.usesKeyReferences();
        if (bl2) {
            this.drainKeyReferenceQueue();
        }
        if (bl2 = (localCache = this.map).usesValueReferences()) {
            this.drainValueReferenceQueue();
        }
    }

    public void drainValueReferenceQueue() {
        Object object;
        int n10 = 0;
        while ((object = this.valueReferenceQueue.poll()) != null) {
            object = (LocalCache$ValueReference)object;
            LocalCache localCache = this.map;
            localCache.reclaimValue((LocalCache$ValueReference)object);
            int n11 = 16;
            if (++n10 != n11) continue;
        }
    }

    public void enqueueNotification(Object object, int n10, Object object2, int n11, RemovalCause removalCause) {
        Queue queue;
        Object object3;
        long l10 = this.totalWeight;
        long l11 = n11;
        this.totalWeight = l10 -= l11;
        n10 = (int)(removalCause.wasEvicted() ? 1 : 0);
        if (n10 != 0) {
            object3 = this.statsCounter;
            object3.recordEviction();
        }
        if ((object3 = this.map.removalNotificationQueue) != (queue = LocalCache.DISCARDING_QUEUE)) {
            object = RemovalNotification.create(object, object2, removalCause);
            object3 = this.map.removalNotificationQueue;
            object3.offer(object);
        }
    }

    public void evictEntries(ReferenceEntry object) {
        long l10;
        RemovalCause removalCause;
        int n10;
        long l11;
        Object object2 = this.map;
        boolean n102 = ((LocalCache)object2).evictsBySize();
        if (!n102) {
            return;
        }
        this.drainRecencyQueue();
        object2 = object.getValueReference();
        long l12 = object2.getWeight();
        long l13 = this.maxSegmentWeight;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 > 0 && (l11 = (long)this.removeEntry((ReferenceEntry)object, n10 = object.getHash(), removalCause = RemovalCause.SIZE)) == false) {
            object = new AssertionError();
            throw object;
        }
        while ((l11 = (l10 = (l12 = this.totalWeight) - (l13 = this.maxSegmentWeight)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            int n11;
            object = this.getNextEvictable();
            l11 = (long)this.removeEntry((ReferenceEntry)object, n11 = object.getHash(), removalCause = RemovalCause.SIZE);
            if (l11 != false) continue;
            object = new AssertionError();
            throw object;
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
            ReferenceEntry referenceEntry;
            ReferenceEntry referenceEntry2 = (ReferenceEntry)atomicReferenceArray.get(i10);
            if (referenceEntry2 == null) continue;
            int n14 = referenceEntry2.getHash() & n10;
            if (referenceEntry == null) {
                atomicReferenceArray2.set(n14, referenceEntry2);
                continue;
            }
            ReferenceEntry referenceEntry3 = referenceEntry2;
            for (referenceEntry = referenceEntry2.getNext(); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                int n15 = referenceEntry.getHash() & n10;
                if (n15 == n14) continue;
                referenceEntry3 = referenceEntry;
                n14 = n15;
            }
            atomicReferenceArray2.set(n14, referenceEntry3);
            while (referenceEntry2 != referenceEntry3) {
                int n16 = referenceEntry2.getHash() & n10;
                ReferenceEntry referenceEntry4 = (ReferenceEntry)atomicReferenceArray2.get(n16);
                if ((referenceEntry4 = this.copyEntry(referenceEntry2, referenceEntry4)) != null) {
                    atomicReferenceArray2.set(n16, referenceEntry4);
                } else {
                    this.removeCollectedEntry(referenceEntry2);
                    n11 += -1;
                }
                referenceEntry2 = referenceEntry2.getNext();
            }
        }
        this.table = atomicReferenceArray2;
        this.count = n11;
    }

    public void expireEntries(long l10) {
        boolean bl2;
        RemovalCause removalCause;
        LocalCache localCache;
        int n10;
        ReferenceEntry referenceEntry;
        this.drainRecencyQueue();
        while ((referenceEntry = (ReferenceEntry)this.writeQueue.peek()) != null && (n10 = (localCache = this.map).isExpired(referenceEntry, l10)) != 0) {
            n10 = referenceEntry.getHash();
            bl2 = this.removeEntry(referenceEntry, n10, removalCause = RemovalCause.EXPIRED);
            if (bl2) continue;
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        while ((referenceEntry = (ReferenceEntry)this.accessQueue.peek()) != null && (n10 = (int)((localCache = this.map).isExpired(referenceEntry, l10) ? 1 : 0)) != 0) {
            n10 = referenceEntry.getHash();
            bl2 = this.removeEntry(referenceEntry, n10, removalCause = RemovalCause.EXPIRED);
            if (bl2) continue;
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
    }

    public Object get(Object object, int n10) {
        block15: {
            ReferenceEntry referenceEntry;
            long l10;
            block16: {
                int n11 = this.count;
                if (n11 == 0) break block15;
                Object object2 = this.map;
                object2 = ((LocalCache)object2).ticker;
                l10 = ((Ticker)object2).read();
                referenceEntry = this.getLiveEntry(object, n10, l10);
                if (referenceEntry != null) break block16;
                this.postReadCleanup();
                return null;
            }
            object = referenceEntry.getValueReference();
            Object object3 = object.get();
            if (object3 != null) {
                this.recordRead(referenceEntry, l10);
                Object object4 = referenceEntry.getKey();
                object = this.map;
                CacheLoader cacheLoader = ((LocalCache)object).defaultLoader;
                object = this.scheduleRefresh(referenceEntry, object4, n10, object3, l10, cacheLoader);
                return object;
            }
            this.tryDrainReferenceQueues();
        }
        return null;
        finally {
            this.postReadCleanup();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(Object var1_1, int var2_6, CacheLoader var3_7) {
        block9: {
            Preconditions.checkNotNull(var1_1);
            Preconditions.checkNotNull(var3_7);
            var4_8 = this.count;
            if (var4_8 != 0 && (var5_9 = this.getEntry(var1_1, var2_6)) != null) {
                var6_10 = this.map;
                var6_10 = var6_10.ticker;
                var7_11 = var6_10.read();
                var9_12 = this.getLiveValue(var5_9, var7_11);
                if (var9_12 != null) {
                    this.recordRead(var5_9, var7_11);
                    var6_10 = this.statsCounter;
                    var10_13 = 1;
                    var6_10.recordHits(var10_13);
                    var1_1 = this.scheduleRefresh(var5_9, var1_1, var2_6, var9_12, var7_11, var3_7);
                    this.postReadCleanup();
                    return var1_1;
                }
            }
            ** GOTO lbl-1000
            {
                catch (Throwable var1_2) {
                    break block9;
                }
                catch (ExecutionException var1_3) {}
                {
                    var11_15 = var1_3.getCause();
                }
                var12_16 = var11_15 instanceof Error;
                if (var12_16) ** GOTO lbl33
                var12_16 = var11_15 instanceof RuntimeException;
                if (!var12_16) ** GOTO lbl32
                {
                    var1_4 = new UncheckedExecutionException(var11_15);
                    throw var1_4;
lbl32:
                    // 1 sources

                    throw var1_3;
lbl33:
                    // 1 sources

                    var11_15 = (Error)var11_15;
                    var1_5 = new ExecutionError((Error)var11_15);
                    throw var1_5;
                }
            }
            {
                var6_10 = var5_9.getValueReference();
                var10_14 = var6_10.isLoading();
                if (!var10_14) ** GOTO lbl-1000
                var1_1 = this.waitForLoadingValue(var5_9, var1_1, (LocalCache$ValueReference)var6_10);
                this.postReadCleanup();
                return var1_1;
            }
lbl-1000:
            // 2 sources

            {
                var1_1 = this.lockedGetOrLoad(var1_1, var2_6, var3_7);
                this.postReadCleanup();
                return var1_1;
            }
        }
        this.postReadCleanup();
        throw var1_2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getAndRecordStats(Object object, int n10, LocalCache$LoadingValueReference localCache$LoadingValueReference, ListenableFuture object2) {
        void var5_9;
        block8: {
            block6: {
                block7: {
                    object2 = Uninterruptibles.getUninterruptibly((Future)object2);
                    if (object2 == null) break block6;
                    try {
                        AbstractCache$StatsCounter abstractCache$StatsCounter = this.statsCounter;
                        long l10 = localCache$LoadingValueReference.elapsedNanos();
                        abstractCache$StatsCounter.recordLoadSuccess(l10);
                        this.storeLoadedValue(object, n10, localCache$LoadingValueReference, object2);
                        if (object2 != null) break block7;
                        abstractCache$StatsCounter = this.statsCounter;
                        l10 = localCache$LoadingValueReference.elapsedNanos();
                        abstractCache$StatsCounter.recordLoadException(l10);
                        this.removeLoadingValue(object, n10, localCache$LoadingValueReference);
                    }
                    catch (Throwable throwable) {}
                }
                return object2;
            }
            CharSequence charSequence = new StringBuilder();
            String string2 = "CacheLoader returned null for key ";
            charSequence.append(string2);
            charSequence.append(object);
            string2 = ".";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            CacheLoader$InvalidCacheLoadException cacheLoader$InvalidCacheLoadException = new CacheLoader$InvalidCacheLoadException((String)charSequence);
            throw cacheLoader$InvalidCacheLoadException;
            break block8;
            catch (Throwable throwable) {
                object2 = null;
            }
        }
        if (object2 == null) {
            object2 = this.statsCounter;
            long l11 = localCache$LoadingValueReference.elapsedNanos();
            object2.recordLoadException(l11);
            this.removeLoadingValue(object, n10, localCache$LoadingValueReference);
        }
        throw var5_9;
    }

    public ReferenceEntry getEntry(Object object, int n10) {
        for (ReferenceEntry referenceEntry = this.getFirst(n10); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
            int n11 = referenceEntry.getHash();
            if (n11 != n10) continue;
            Object object2 = referenceEntry.getKey();
            if (object2 == null) {
                this.tryDrainReferenceQueues();
                continue;
            }
            Equivalence equivalence = this.map.keyEquivalence;
            n11 = (int)(equivalence.equivalent(object, object2) ? 1 : 0);
            if (n11 == 0) continue;
            return referenceEntry;
        }
        return null;
    }

    public ReferenceEntry getFirst(int n10) {
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length() + -1;
        return (ReferenceEntry)atomicReferenceArray.get(n10 &= n11);
    }

    public ReferenceEntry getLiveEntry(Object object, int n10, long l10) {
        object = this.getEntry(object, n10);
        n10 = 0;
        if (object == null) {
            return null;
        }
        LocalCache localCache = this.map;
        boolean bl2 = localCache.isExpired((ReferenceEntry)object, l10);
        if (bl2) {
            this.tryExpireEntries(l10);
            return null;
        }
        return object;
    }

    public Object getLiveValue(ReferenceEntry referenceEntry, long l10) {
        Object object = referenceEntry.getKey();
        if (object == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        object = referenceEntry.getValueReference().get();
        if (object == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        LocalCache localCache = this.map;
        boolean bl2 = localCache.isExpired(referenceEntry, l10);
        if (bl2) {
            this.tryExpireEntries(l10);
            return null;
        }
        return object;
    }

    public ReferenceEntry getNextEvictable() {
        boolean bl2;
        Object object = this.accessQueue.iterator();
        while (bl2 = object.hasNext()) {
            ReferenceEntry referenceEntry = (ReferenceEntry)object.next();
            LocalCache$ValueReference localCache$ValueReference = referenceEntry.getValueReference();
            int n10 = localCache$ValueReference.getWeight();
            if (n10 <= 0) continue;
            return referenceEntry;
        }
        object = new AssertionError();
        throw object;
    }

    public void initTable(AtomicReferenceArray atomicReferenceArray) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        this.threshold = n10 = atomicReferenceArray.length() * 3 / 4;
        LocalCache localCache = this.map;
        n10 = (int)(localCache.customWeigher() ? 1 : 0);
        if (n10 == 0 && (l13 = (l12 = (l11 = (long)(n10 = this.threshold)) - (l10 = this.maxSegmentWeight)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            this.threshold = ++n10;
        }
        this.table = atomicReferenceArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LocalCache$LoadingValueReference insertLoadingValueReference(Object object, int n10, boolean bl2) {
        this.lock();
        try {
            int n11;
            Object object2 = this.map;
            object2 = ((LocalCache)object2).ticker;
            long l10 = ((Ticker)object2).read();
            this.preWriteCleanup(l10);
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n12 = atomicReferenceArray.length() + -1 & n10;
            Object e10 = atomicReferenceArray.get(n12);
            for (Object e11 = e10 = (ReferenceEntry)e10; e11 != null; e11 = e11.getNext()) {
                Object object3;
                Object object4 = e11.getKey();
                int n13 = e11.getHash();
                if (n13 != n10 || object4 == null) continue;
                Object object5 = this.map;
                object5 = ((LocalCache)object5).keyEquivalence;
                boolean bl3 = ((Equivalence)object5).equivalent(object, object4);
                if (!bl3) continue;
                object = e11.getValueReference();
                n10 = (int)(object.isLoading() ? 1 : 0);
                if (n10 != 0) return null;
                if (bl2) {
                    long l11 = e11.getWriteTime();
                    l10 -= l11;
                    object3 = this.map;
                    l11 = ((LocalCache)object3).refreshNanos;
                    long l12 = l10 - l11;
                    n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                    if (n10 < 0) {
                        return null;
                    }
                }
                this.modCount = n10 = this.modCount + 1;
                object3 = new LocalCache$LoadingValueReference((LocalCache$ValueReference)object);
                e11.setValueReference((LocalCache$ValueReference)object3);
                return object3;
            }
            this.modCount = n11 = this.modCount + 1;
            LocalCache$LoadingValueReference localCache$LoadingValueReference = new LocalCache$LoadingValueReference();
            object = this.newEntry(object, n10, (ReferenceEntry)e10);
            object.setValueReference(localCache$LoadingValueReference);
            atomicReferenceArray.set(n12, object);
            return localCache$LoadingValueReference;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    public ListenableFuture loadAsync(Object object, int n10, LocalCache$LoadingValueReference localCache$LoadingValueReference, CacheLoader object2) {
        object2 = localCache$LoadingValueReference.loadFuture(object, (CacheLoader)object2);
        LocalCache$Segment$1 localCache$Segment$1 = new LocalCache$Segment$1(this, object, n10, localCache$LoadingValueReference, (ListenableFuture)object2);
        object = MoreExecutors.directExecutor();
        object2.addListener(localCache$Segment$1, (Executor)object);
        return object2;
    }

    public Object loadSync(Object object, int n10, LocalCache$LoadingValueReference localCache$LoadingValueReference, CacheLoader object2) {
        object2 = localCache$LoadingValueReference.loadFuture(object, (CacheLoader)object2);
        return this.getAndRecordStats(object, n10, localCache$LoadingValueReference, (ListenableFuture)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object lockedGetOrLoad(Object object, int n10, CacheLoader cacheLoader) {
        Object object2;
        int n11;
        LocalCache$LoadingValueReference localCache$LoadingValueReference;
        Object object3;
        Object object4;
        int n12;
        AtomicReferenceArray atomicReferenceArray;
        int n13;
        Object object5;
        int n14;
        Object object6;
        LocalCache$Segment localCache$Segment;
        block22: {
            localCache$Segment = this;
            object6 = object;
            n14 = n10;
            this.lock();
            object5 = this.map;
            object5 = ((LocalCache)object5).ticker;
            long l10 = ((Ticker)object5).read();
            this.preWriteCleanup(l10);
            int n15 = this.count;
            n13 = 1;
            int n16 = n15 + -1;
            atomicReferenceArray = this.table;
            n15 = atomicReferenceArray.length() - n13;
            n12 = n10 & n15;
            Object object7 = atomicReferenceArray.get(n12);
            object4 = object7;
            object3 = object4 = (ReferenceEntry)object7;
            while (true) {
                localCache$LoadingValueReference = null;
                if (object3 == null) break;
                object7 = object3.getKey();
                int n17 = object3.getHash();
                if (n17 == n14 && object7 != null) {
                    Object object8 = localCache$Segment.map;
                    object8 = ((LocalCache)object8).keyEquivalence;
                    n17 = (int)(((Equivalence)object8).equivalent(object6, object7) ? 1 : 0);
                    if (n17 != 0) {
                        LocalCache$ValueReference localCache$ValueReference = object3.getValueReference();
                        n17 = (int)(localCache$ValueReference.isLoading() ? 1 : 0);
                        if (n17 != 0) {
                            n11 = 0;
                            object5 = null;
                        } else {
                            object8 = localCache$ValueReference.get();
                            if (object8 == null) {
                                int n18 = localCache$ValueReference.getWeight();
                                RemovalCause removalCause = RemovalCause.COLLECTED;
                                object5 = this;
                                object2 = object7;
                                n15 = n10;
                                this.enqueueNotification(object7, n10, object8, n18, removalCause);
                            } else {
                                LocalCache localCache = localCache$Segment.map;
                                int n19 = localCache.isExpired((ReferenceEntry)object3, l10);
                                if (n19 == 0) {
                                    localCache$Segment.recordLockedRead((ReferenceEntry)object3, l10);
                                    object6 = localCache$Segment.statsCounter;
                                    object6.recordHits(n13);
                                    return object8;
                                }
                                n19 = localCache$ValueReference.getWeight();
                                RemovalCause removalCause = RemovalCause.EXPIRED;
                                object5 = this;
                                object2 = object7;
                                n15 = n10;
                                this.enqueueNotification(object7, n10, object8, n19, removalCause);
                            }
                            object5 = localCache$Segment.writeQueue;
                            object5.remove(object3);
                            object5 = localCache$Segment.accessQueue;
                            object5.remove(object3);
                            localCache$Segment.count = n16;
                            n11 = n13;
                        }
                        object2 = localCache$ValueReference;
                        break block22;
                    }
                }
                object3 = object3.getNext();
            }
            n11 = n13;
            object2 = null;
        }
        if (n11 != 0) {
            localCache$LoadingValueReference = new LocalCache$LoadingValueReference();
            if (object3 == null) {
                object3 = localCache$Segment.newEntry(object6, n14, (ReferenceEntry)object4);
                object3.setValueReference(localCache$LoadingValueReference);
                atomicReferenceArray.set(n12, object3);
            } else {
                object3.setValueReference(localCache$LoadingValueReference);
            }
        }
        if (n11 == 0) return localCache$Segment.waitForLoadingValue((ReferenceEntry)object3, object6, (LocalCache$ValueReference)object2);
        try {
            synchronized (object3) {
                object5 = cacheLoader;
                object6 = localCache$Segment.loadSync(object6, n14, localCache$LoadingValueReference, cacheLoader);
            }
        }
        catch (Throwable throwable) {
            localCache$Segment.statsCounter.recordMisses(n13);
            throw throwable;
        }
        localCache$Segment.statsCounter.recordMisses(n13);
        return object6;
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    public ReferenceEntry newEntry(Object object, int n10, ReferenceEntry referenceEntry) {
        LocalCache$EntryFactory localCache$EntryFactory = this.map.entryFactory;
        object = Preconditions.checkNotNull(object);
        return localCache$EntryFactory.newEntry(this, object, n10, referenceEntry);
    }

    public AtomicReferenceArray newEntryArray(int n10) {
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(n10);
        return atomicReferenceArray;
    }

    public void postReadCleanup() {
        AtomicInteger atomicInteger = this.readCount;
        int n10 = atomicInteger.incrementAndGet() & 0x3F;
        if (n10 == 0) {
            this.cleanUp();
        }
    }

    public void postWriteCleanup() {
        this.runUnlockedCleanup();
    }

    public void preWriteCleanup(long l10) {
        this.runLockedCleanup(l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object put(Object object, int n10, Object object2, boolean bl2) {
        LocalCache$Segment localCache$Segment = this;
        Object object3 = object;
        int n11 = n10;
        this.lock();
        try {
            int n12;
            Object object4;
            Object object5;
            Object object6;
            Object object7 = this.map;
            object7 = ((LocalCache)object7).ticker;
            long l10 = ((Ticker)object7).read();
            this.preWriteCleanup(l10);
            int n13 = this.count + 1;
            int n14 = this.threshold;
            if (n13 > n14) {
                this.expand();
            }
            Object object8 = localCache$Segment.table;
            n13 = ((AtomicReferenceArray)object8).length() + -1;
            int n15 = n11 & n13;
            object7 = ((AtomicReferenceArray)object8).get(n15);
            for (object6 = object7 = (ReferenceEntry)object7; object6 != null; object6 = object6.getNext()) {
                object5 = object6.getKey();
                int n16 = object6.getHash();
                if (n16 != n11 || object5 == null) continue;
                object4 = localCache$Segment.map;
                object4 = ((LocalCache)object4).keyEquivalence;
                n14 = (int)(((Equivalence)object4).equivalent(object, object5) ? 1 : 0);
                if (n14 == 0) continue;
                object7 = object6.getValueReference();
                object8 = object7.get();
                if (object8 == null) {
                    int n17;
                    localCache$Segment.modCount = n14 = localCache$Segment.modCount + 1;
                    n14 = (int)(object7.isActive() ? 1 : 0);
                    if (n14 != 0) {
                        int n18 = object7.getWeight();
                        RemovalCause removalCause = RemovalCause.COLLECTED;
                        object7 = this;
                        object5 = object;
                        n11 = n10;
                        object4 = object8;
                        this.enqueueNotification(object, n10, object8, n18, removalCause);
                        object5 = object6;
                        object4 = object2;
                        this.setValue((ReferenceEntry)object6, object, object2, l10);
                        n17 = localCache$Segment.count;
                    } else {
                        object7 = this;
                        object5 = object6;
                        object4 = object2;
                        this.setValue((ReferenceEntry)object6, object, object2, l10);
                        n17 = localCache$Segment.count + 1;
                    }
                    localCache$Segment.count = n17;
                    this.evictEntries((ReferenceEntry)object6);
                    return null;
                }
                if (bl2) {
                    this.recordLockedRead((ReferenceEntry)object6, l10);
                    return object8;
                }
                localCache$Segment.modCount = n14 = localCache$Segment.modCount + 1;
                int n19 = object7.getWeight();
                RemovalCause removalCause = RemovalCause.REPLACED;
                object7 = this;
                object5 = object;
                n11 = n10;
                object4 = object8;
                this.enqueueNotification(object, n10, object8, n19, removalCause);
                object5 = object6;
                object4 = object2;
                this.setValue((ReferenceEntry)object6, object, object2, l10);
                this.evictEntries((ReferenceEntry)object6);
                return object8;
            }
            localCache$Segment.modCount = n14 = localCache$Segment.modCount + 1;
            object6 = this.newEntry(object, n11, (ReferenceEntry)object7);
            object7 = this;
            object5 = object6;
            object4 = object2;
            this.setValue((ReferenceEntry)object6, object, object2, l10);
            ((AtomicReferenceArray)object8).set(n15, object6);
            localCache$Segment.count = n12 = localCache$Segment.count + 1;
            this.evictEntries((ReferenceEntry)object6);
            return null;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean reclaimKey(ReferenceEntry object, int n10) {
        Object object2;
        Object object3;
        int n11;
        int n12;
        AtomicReferenceArray atomicReferenceArray;
        this.lock();
        try {
            atomicReferenceArray = this.table;
            n12 = atomicReferenceArray.length();
            n11 = 1;
            n12 = n12 - n11 & n10;
            Object e10 = atomicReferenceArray.get(n12);
            object3 = e10;
            object2 = object3 = (ReferenceEntry)e10;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
        while (true) {
            if (object2 == null) {
                this.unlock();
                this.postWriteCleanup();
                return false;
            }
            if (object2 == object) {
                int n13;
                this.modCount = n13 = this.modCount + n11;
                Object object4 = object2.getKey();
                object = object2.getValueReference();
                Object object5 = object.get();
                LocalCache$ValueReference localCache$ValueReference = object2.getValueReference();
                RemovalCause removalCause = RemovalCause.COLLECTED;
                object = this.removeValueFromChain((ReferenceEntry)object3, (ReferenceEntry)object2, object4, n10, object5, localCache$ValueReference, removalCause);
                n10 = this.count - n11;
                atomicReferenceArray.set(n12, object);
                this.count = n10;
                return n11 != 0;
            }
            object2 = object2.getNext();
            continue;
            break;
        }
    }

    public boolean reclaimValue(Object object, int n10, LocalCache$ValueReference localCache$ValueReference) {
        Object object2;
        this.lock();
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length();
        int n12 = 1;
        n11 = n11 - n12 & n10;
        Object e10 = atomicReferenceArray.get(n11);
        Object object3 = e10;
        try {
            object2 = object3 = (ReferenceEntry)e10;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.unlock();
            n10 = (int)(this.isHeldByCurrentThread() ? 1 : 0);
            if (n10 == 0) {
                this.postWriteCleanup();
            }
        }
        while (true) {
            block24: {
                block25: {
                    int n13;
                    e10 = null;
                    if (object2 == null) break;
                    Object object4 = object2.getKey();
                    int n14 = object2.getHash();
                    if (n14 != n10 || object4 == null) break block24;
                    Object object5 = this.map;
                    object5 = ((LocalCache)object5).keyEquivalence;
                    n14 = (int)(((Equivalence)object5).equivalent(object, object4) ? 1 : 0);
                    if (n14 == 0) break block24;
                    object = object2.getValueReference();
                    if (object != localCache$ValueReference) break block25;
                    this.modCount = n13 = this.modCount + n12;
                    Object object6 = localCache$ValueReference.get();
                    RemovalCause removalCause = RemovalCause.COLLECTED;
                    object5 = this;
                    object = this.removeValueFromChain((ReferenceEntry)object3, (ReferenceEntry)object2, object4, n10, object6, localCache$ValueReference, removalCause);
                    n10 = this.count - n12;
                    atomicReferenceArray.set(n11, object);
                    this.count = n10;
                    return n12 != 0;
                }
                this.unlock();
                boolean bl2 = this.isHeldByCurrentThread();
                if (!bl2) {
                    this.postWriteCleanup();
                }
                return false;
            }
            object2 = object2.getNext();
            continue;
            break;
        }
        this.unlock();
        boolean bl3 = this.isHeldByCurrentThread();
        if (!bl3) {
            this.postWriteCleanup();
        }
        return false;
    }

    public void recordLockedRead(ReferenceEntry referenceEntry, long l10) {
        LocalCache localCache = this.map;
        boolean bl2 = localCache.recordsAccess();
        if (bl2) {
            referenceEntry.setAccessTime(l10);
        }
        this.accessQueue.add(referenceEntry);
    }

    public void recordRead(ReferenceEntry referenceEntry, long l10) {
        LocalCache localCache = this.map;
        boolean bl2 = localCache.recordsAccess();
        if (bl2) {
            referenceEntry.setAccessTime(l10);
        }
        this.recencyQueue.add(referenceEntry);
    }

    public void recordWrite(ReferenceEntry referenceEntry, int n10, long l10) {
        this.drainRecencyQueue();
        long l11 = this.totalWeight;
        long l12 = n10;
        this.totalWeight = l11 += l12;
        LocalCache localCache = this.map;
        n10 = (int)(localCache.recordsAccess() ? 1 : 0);
        if (n10 != 0) {
            referenceEntry.setAccessTime(l10);
        }
        if ((n10 = (int)((localCache = this.map).recordsWrite() ? 1 : 0)) != 0) {
            referenceEntry.setWriteTime(l10);
        }
        this.accessQueue.add(referenceEntry);
        this.writeQueue.add(referenceEntry);
    }

    public Object refresh(Object object, int n10, CacheLoader cacheLoader, boolean bl2) {
        LocalCache$LoadingValueReference localCache$LoadingValueReference = this.insertLoadingValueReference(object, n10, bl2);
        if (localCache$LoadingValueReference == null) {
            return null;
        }
        if ((n10 = (int)((object = this.loadAsync(object, n10, localCache$LoadingValueReference, cacheLoader)).isDone() ? 1 : 0)) != 0) {
            try {
                return Uninterruptibles.getUninterruptibly((Future)object);
            }
            catch (Throwable throwable) {}
        }
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object remove(Object object, int n10) {
        this.lock();
        try {
            Object object2 = this.map;
            object2 = ((LocalCache)object2).ticker;
            long l10 = ((Ticker)object2).read();
            this.preWriteCleanup(l10);
            object2 = this.table;
            int n11 = ((AtomicReferenceArray)object2).length() + -1 & n10;
            Object e10 = ((AtomicReferenceArray)object2).get(n11);
            Object object3 = e10;
            Object object4 = object3 = (ReferenceEntry)e10;
            while (true) {
                int n12 = 0;
                Object var7_9 = null;
                if (object4 == null) return null;
                Object object5 = object4.getKey();
                int n13 = object4.getHash();
                if (n13 == n10 && object5 != null) {
                    Object object6 = this.map;
                    object6 = ((LocalCache)object6).keyEquivalence;
                    n13 = (int)(((Equivalence)object6).equivalent(object, object5) ? 1 : 0);
                    if (n13 != 0) {
                        void var7_11;
                        LocalCache$ValueReference localCache$ValueReference = object4.getValueReference();
                        object = localCache$ValueReference.get();
                        if (object != null) {
                            RemovalCause removalCause = RemovalCause.EXPLICIT;
                        } else {
                            n13 = (int)(localCache$ValueReference.isActive() ? 1 : 0);
                            if (n13 == 0) return null;
                            RemovalCause removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount = n12 = this.modCount + 1;
                        object6 = this;
                        ReferenceEntry referenceEntry = this.removeValueFromChain((ReferenceEntry)object3, (ReferenceEntry)object4, object5, n10, object, localCache$ValueReference, (RemovalCause)var7_11);
                        n12 = this.count + -1;
                        ((AtomicReferenceArray)object2).set(n11, referenceEntry);
                        this.count = n12;
                        return object;
                    }
                }
                object4 = object4.getNext();
            }
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    public boolean remove(Object object, int n10, Object object2) {
        Object object3;
        Object object4;
        this.lock();
        Object object5 = this.map;
        object5 = ((LocalCache)object5).ticker;
        long l10 = ((Ticker)object5).read();
        this.preWriteCleanup(l10);
        object5 = this.table;
        int n11 = ((AtomicReferenceArray)object5).length();
        int n12 = 1;
        n11 = n11 - n12 & n10;
        Object e10 = ((AtomicReferenceArray)object5).get(n11);
        Object object6 = e10;
        try {
            object4 = object6 = (ReferenceEntry)e10;
        }
        catch (Throwable throwable) {
            this.unlock();
            this.postWriteCleanup();
            throw throwable;
        }
        while (true) {
            e10 = null;
            if (object4 == null) break block34;
            object3 = object4.getKey();
            break;
        }
        {
            block31: {
                block34: {
                    Object object7;
                    LocalCache$ValueReference localCache$ValueReference;
                    Object object8;
                    block33: {
                        boolean bl2;
                        block32: {
                            int n13 = object4.getHash();
                            if (n13 != n10 || object3 == null) break block31;
                            object8 = this.map;
                            object8 = ((LocalCache)object8).keyEquivalence;
                            n13 = (int)(((Equivalence)object8).equivalent(object, object3) ? 1 : 0);
                            if (n13 == 0) break block31;
                            localCache$ValueReference = object4.getValueReference();
                            object7 = localCache$ValueReference.get();
                            object = this.map;
                            object = ((LocalCache)object).valueEquivalence;
                            bl2 = ((Equivalence)object).equivalent(object2, object7);
                            if (!bl2) break block32;
                            object = RemovalCause.EXPLICIT;
                            break block33;
                        }
                        if (object7 != null) break block34;
                        bl2 = localCache$ValueReference.isActive();
                        if (!bl2) break block34;
                        object = RemovalCause.COLLECTED;
                    }
                    int n14 = this.modCount + n12;
                    this.modCount = n14;
                    object8 = this;
                    Object object9 = this.removeValueFromChain((ReferenceEntry)object6, (ReferenceEntry)object4, object3, n10, object7, localCache$ValueReference, (RemovalCause)((Object)object));
                    n14 = this.count - n12;
                    ((AtomicReferenceArray)object5).set(n11, object9);
                    this.count = n14;
                    object9 = RemovalCause.EXPLICIT;
                    if (object != object9) {
                        n12 = 0;
                    }
                    this.unlock();
                    this.postWriteCleanup();
                    return n12 != 0;
                }
                this.unlock();
                this.postWriteCleanup();
                return false;
            }
            object4 = object4.getNext();
            continue;
        }
    }

    public void removeCollectedEntry(ReferenceEntry referenceEntry) {
        Object object = referenceEntry.getKey();
        int n10 = referenceEntry.getHash();
        Object object2 = referenceEntry.getValueReference().get();
        int n11 = referenceEntry.getValueReference().getWeight();
        RemovalCause removalCause = RemovalCause.COLLECTED;
        this.enqueueNotification(object, n10, object2, n11, removalCause);
        this.writeQueue.remove(referenceEntry);
        this.accessQueue.remove(referenceEntry);
    }

    public boolean removeEntry(ReferenceEntry referenceEntry, int n10, RemovalCause removalCause) {
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length();
        int n12 = 1;
        n11 = n11 - n12 & n10;
        Object e10 = atomicReferenceArray.get(n11);
        Object e11 = e10;
        for (Object e12 = e11 = (ReferenceEntry)e10; e12 != null; e12 = e12.getNext()) {
            int n13;
            if (e12 != referenceEntry) continue;
            this.modCount = n13 = this.modCount + n12;
            Object object = e12.getKey();
            Object object2 = e12.getValueReference().get();
            LocalCache$ValueReference localCache$ValueReference = e12.getValueReference();
            referenceEntry = this.removeValueFromChain((ReferenceEntry)e11, (ReferenceEntry)e12, object, n10, object2, localCache$ValueReference, removalCause);
            n10 = this.count - n12;
            atomicReferenceArray.set(n11, referenceEntry);
            this.count = n10;
            return n12 != 0;
        }
        return false;
    }

    public ReferenceEntry removeEntryFromChain(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        int n10 = this.count;
        ReferenceEntry referenceEntry3 = referenceEntry2.getNext();
        while (referenceEntry != referenceEntry2) {
            ReferenceEntry referenceEntry4 = this.copyEntry(referenceEntry, referenceEntry3);
            if (referenceEntry4 != null) {
                referenceEntry3 = referenceEntry4;
            } else {
                this.removeCollectedEntry(referenceEntry);
                n10 += -1;
            }
            referenceEntry = referenceEntry.getNext();
        }
        this.count = n10;
        return referenceEntry3;
    }

    public boolean removeLoadingValue(Object object, int n10, LocalCache$LoadingValueReference localCache$LoadingValueReference) {
        Object object2;
        this.lock();
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n11 = atomicReferenceArray.length();
        int n12 = 1;
        n11 = n11 - n12 & n10;
        Object object3 = atomicReferenceArray.get(n11);
        try {
            object2 = object3 = (ReferenceEntry)object3;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
        while (true) {
            block22: {
                block23: {
                    if (object2 != null) {
                        Object object4 = object2.getKey();
                        int n13 = object2.getHash();
                        if (n13 != n10 || object4 == null) break block22;
                        Object object5 = this.map;
                        object5 = ((LocalCache)object5).keyEquivalence;
                        boolean bl2 = ((Equivalence)object5).equivalent(object, object4);
                        if (!bl2) break block22;
                        object = object2.getValueReference();
                        if (object != localCache$LoadingValueReference) break block23;
                        boolean bl3 = localCache$LoadingValueReference.isActive();
                        if (bl3) {
                            object = localCache$LoadingValueReference.getOldValue();
                            object2.setValueReference((LocalCache$ValueReference)object);
                        } else {
                            object = this.removeEntryFromChain((ReferenceEntry)object3, (ReferenceEntry)object2);
                            atomicReferenceArray.set(n11, object);
                        }
                        return n12 != 0;
                    }
                }
                this.unlock();
                this.postWriteCleanup();
                return false;
            }
            object2 = object2.getNext();
            continue;
            break;
        }
    }

    public ReferenceEntry removeValueFromChain(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object object, int n10, Object object2, LocalCache$ValueReference localCache$ValueReference, RemovalCause removalCause) {
        int n11 = localCache$ValueReference.getWeight();
        this.enqueueNotification(object, n10, object2, n11, removalCause);
        this.writeQueue.remove(referenceEntry2);
        object = this.accessQueue;
        object.remove(referenceEntry2);
        boolean bl2 = localCache$ValueReference.isLoading();
        if (bl2) {
            localCache$ValueReference.notifyNewValue(null);
            return referenceEntry;
        }
        return this.removeEntryFromChain(referenceEntry, referenceEntry2);
    }

    public Object replace(Object object, int n10, Object object2) {
        Object object3;
        LocalCache$ValueReference localCache$ValueReference;
        Object object4;
        LocalCache$Segment localCache$Segment = this;
        int n11 = n10;
        this.lock();
        Object object5 = this.map;
        object5 = ((LocalCache)object5).ticker;
        long l10 = ((Ticker)object5).read();
        this.preWriteCleanup(l10);
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n12 = atomicReferenceArray.length() + -1;
        int n13 = n10 & n12;
        Object object6 = object5 = atomicReferenceArray.get(n13);
        Object object7 = object6 = (ReferenceEntry)object5;
        while (true) {
            block33: {
                block34: {
                    if (object7 != null) {
                        object4 = object7.getKey();
                        n12 = object7.getHash();
                        if (n12 != n11 || object4 == null) break block32;
                        object5 = localCache$Segment.map;
                        object5 = ((LocalCache)object5).keyEquivalence;
                        n12 = (int)(((Equivalence)object5).equivalent(object, object4) ? 1 : 0);
                        if (n12 == 0) break block32;
                        localCache$ValueReference = object7.getValueReference();
                        object3 = localCache$ValueReference.get();
                        if (object3 != null) break block33;
                        n12 = (int)(localCache$ValueReference.isActive() ? 1 : 0);
                        if (n12 == 0) break block34;
                        n12 = localCache$Segment.modCount + 1;
                        localCache$Segment.modCount = n12;
                        RemovalCause removalCause = RemovalCause.COLLECTED;
                        object5 = this;
                        int n14 = n10;
                        Object object8 = object3;
                        ReferenceEntry referenceEntry = this.removeValueFromChain((ReferenceEntry)object6, (ReferenceEntry)object7, object4, n10, object3, localCache$ValueReference, removalCause);
                        n12 = localCache$Segment.count + -1;
                        atomicReferenceArray.set(n13, referenceEntry);
                        localCache$Segment.count = n12;
                    }
                }
                return null;
            }
            n12 = localCache$Segment.modCount + 1;
            break;
        }
        {
            block32: {
                localCache$Segment.modCount = n12;
                int n15 = localCache$ValueReference.getWeight();
                RemovalCause removalCause = RemovalCause.REPLACED;
                object5 = this;
                object6 = object;
                object4 = object3;
                this.enqueueNotification(object, n10, object3, n15, removalCause);
                object6 = object7;
                object4 = object2;
                this.setValue((ReferenceEntry)object7, object, object2, l10);
                localCache$Segment.evictEntries((ReferenceEntry)object7);
                this.unlock();
                this.postWriteCleanup();
                return object3;
            }
            object7 = object7.getNext();
            continue;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean replace(Object object, int n10, Object object2, Object object3) {
        LocalCache$Segment localCache$Segment = this;
        int n11 = n10;
        this.lock();
        Object object4 = this.map;
        object4 = ((LocalCache)object4).ticker;
        long l10 = ((Ticker)object4).read();
        this.preWriteCleanup(l10);
        Object object5 = this.table;
        int n12 = ((AtomicReferenceArray)object5).length();
        int n13 = 1;
        int n14 = n10 & (n12 -= n13);
        Object object6 = object4 = ((AtomicReferenceArray)object5).get(n14);
        Object object7 = object6 = (ReferenceEntry)object4;
        while (object7 != null) {
            Object object8 = object7.getKey();
            n12 = object7.getHash();
            if (n12 == n11 && object8 != null) {
                object4 = localCache$Segment.map;
                object4 = ((LocalCache)object4).keyEquivalence;
                n12 = (int)(((Equivalence)object4).equivalent(object, object8) ? 1 : 0);
                if (n12 != 0) {
                    LocalCache$ValueReference localCache$ValueReference = object7.getValueReference();
                    Object object9 = localCache$ValueReference.get();
                    if (object9 == null) {
                        n12 = (int)(localCache$ValueReference.isActive() ? 1 : 0);
                        if (n12 == 0) return false;
                        localCache$Segment.modCount = n12 = localCache$Segment.modCount + n13;
                        RemovalCause removalCause = RemovalCause.COLLECTED;
                        object4 = this;
                        int n15 = n10;
                        ReferenceEntry referenceEntry = this.removeValueFromChain((ReferenceEntry)object6, (ReferenceEntry)object7, object8, n10, object9, localCache$ValueReference, removalCause);
                        n12 = localCache$Segment.count - n13;
                        ((AtomicReferenceArray)object5).set(n14, referenceEntry);
                        localCache$Segment.count = n12;
                        return false;
                    }
                    object4 = localCache$Segment.map;
                    object4 = ((LocalCache)object4).valueEquivalence;
                    n12 = (int)(((Equivalence)object4).equivalent(object2, object9) ? 1 : 0);
                    if (n12 != 0) {
                        localCache$Segment.modCount = n12 = localCache$Segment.modCount + n13;
                        int n16 = localCache$ValueReference.getWeight();
                        object5 = RemovalCause.REPLACED;
                        object4 = this;
                        object6 = object;
                        object8 = object9;
                        object9 = object5;
                        this.enqueueNotification(object, n10, object8, n16, (RemovalCause)((Object)object5));
                        object6 = object7;
                        object8 = object3;
                        this.setValue((ReferenceEntry)object7, object, object3, l10);
                        localCache$Segment.evictEntries((ReferenceEntry)object7);
                        return n13 != 0;
                    }
                    localCache$Segment.recordLockedRead((ReferenceEntry)object7, l10);
                    return false;
                }
            }
            object7 = object7.getNext();
        }
        return false;
    }

    public void runLockedCleanup(long l10) {
        boolean bl2 = this.tryLock();
        if (bl2) {
            try {
                this.drainReferenceQueues();
                this.expireEntries(l10);
                AtomicInteger atomicInteger = this.readCount;
                atomicInteger.set(0);
            }
            finally {
                this.unlock();
            }
        }
    }

    public void runUnlockedCleanup() {
        boolean bl2 = this.isHeldByCurrentThread();
        if (!bl2) {
            LocalCache localCache = this.map;
            localCache.processPendingNotifications();
        }
    }

    public Object scheduleRefresh(ReferenceEntry object, Object object2, int n10, Object object3, long l10, CacheLoader cacheLoader) {
        LocalCache localCache = this.map;
        boolean bl2 = localCache.refreshes();
        if (bl2) {
            boolean bl3;
            long l11 = object.getWriteTime();
            l10 -= l11;
            localCache = this.map;
            l11 = localCache.refreshNanos;
            long l12 = l10 - l11;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 > 0 && !(bl3 = (object = object.getValueReference()).isLoading()) && (object = this.refresh(object2, n10, cacheLoader, bl3 = true)) != null) {
                return object;
            }
        }
        return object3;
    }

    public void setValue(ReferenceEntry referenceEntry, Object object, Object object2, long l10) {
        boolean bl2;
        LocalCache$ValueReference localCache$ValueReference = referenceEntry.getValueReference();
        Object object3 = this.map.weigher;
        int n10 = object3.weigh(object, object2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object3 = null;
        }
        Preconditions.checkState(bl2, "Weights must be non-negative");
        object3 = this.map.valueStrength.referenceValue(this, referenceEntry, object2, n10);
        referenceEntry.setValueReference((LocalCache$ValueReference)object3);
        this.recordWrite(referenceEntry, n10, l10);
        localCache$ValueReference.notifyNewValue(object2);
    }

    /*
     * Unable to fully structure code
     */
    public boolean storeLoadedValue(Object var1_1, int var2_2, LocalCache$LoadingValueReference var3_3, Object var4_4) {
        block44: {
            var5_5 = this;
            var6_6 = var1_1;
            var7_8 = var2_2;
            this.lock();
            var8_9 = this.map;
            var8_9 = var8_9.ticker;
            var9_10 = var8_9.read();
            this.preWriteCleanup(var9_10);
            var11_11 = this.count;
            var12_12 = 1;
            var11_11 += var12_12;
            var13_13 = this.threshold;
            if (var11_11 <= var13_13) break block44;
            this.expand();
            var11_11 = this.count + var12_12;
        }
        var14_14 = var11_11;
        var15_15 = var5_5.table;
        var11_11 = var15_15.length() - var12_12;
        var16_16 = var7_8 & var11_11;
        var8_9 = var15_15.get(var16_16);
        var17_17 = var8_9 = (ReferenceEntry)var8_9;
        while (true) lbl-1000:
        // 3 sources

        {
            if (var17_17 != null) {
                block45: {
                    block48: {
                        block49: {
                            block46: {
                                block47: {
                                    var18_18 = var17_17.getKey();
                                    var19_19 = var17_17.getHash();
                                    if (var19_19 != var7_8 || var18_18 == null) break block45;
                                    var20_20 = var5_5.map;
                                    var20_20 = var20_20.keyEquivalence;
                                    var13_13 = (int)var20_20.equivalent(var6_6, var18_18);
                                    if (var13_13 == 0) break block45;
                                    var8_9 = var17_17.getValueReference();
                                    var20_20 = var8_9.get();
                                    var18_18 = var3_3;
                                    if (var3_3 == var8_9) break block46;
                                    if (var20_20 != null) break block47;
                                    var21_21 = LocalCache.UNSET;
                                    if (var8_9 != var21_21) break block46;
                                }
                                var22_22 = false;
                                var21_21 = null;
                                var23_24 = RemovalCause.REPLACED;
                                var8_9 = this;
                                var18_18 = var1_1;
                                var7_8 = var2_2;
                                var20_20 = var4_4;
                                this.enqueueNotification(var1_1, var2_2, var4_4, 0, var23_24);
                                return false;
                            }
                            var11_11 = var5_5.modCount + var12_12;
                            var5_5.modCount = var11_11;
                            var11_11 = (int)var3_3.isActive();
                            if (var11_11 == 0) break block48;
                            if (var20_20 != null) break block49;
                            var8_9 = RemovalCause.COLLECTED;
                        }
                        var8_9 = RemovalCause.REPLACED;
                        var23_25 = var8_9;
                        var22_23 = var3_3.getWeight();
                        var8_9 = this;
                        var18_18 = var1_1;
                        var7_8 = var2_2;
                        this.enqueueNotification(var1_1, var2_2, var20_20, var22_23, (RemovalCause)var23_25);
                        var14_14 += -1;
                    }
                    var8_9 = this;
                    var18_18 = var17_17;
                    var20_20 = var4_4;
                    this.setValue((ReferenceEntry)var17_17, var1_1, var4_4, var9_10);
                    var5_5.count = var14_14;
                    this.evictEntries((ReferenceEntry)var17_17);
lbl102:
                    // 2 sources

                    while (true) {
                        this.unlock();
                        this.postWriteCleanup();
                        return (boolean)var12_12;
                    }
                }
                var18_18 = var3_3;
                var17_17 = var17_17.getNext();
            }
            var13_13 = var5_5.modCount + var12_12;
            var5_5.modCount = var13_13;
            var17_17 = this.newEntry(var6_6, var7_8, (ReferenceEntry)var8_9);
            var8_9 = this;
            var18_18 = var17_17;
            var20_20 = var4_4;
            this.setValue((ReferenceEntry)var17_17, var1_1, var4_4, var9_10);
            var15_15.set(var16_16, var17_17);
            var5_5.count = var14_14;
            try {
                this.evictEntries((ReferenceEntry)var17_17);
                ** continue;
            }
            catch (Throwable var6_7) {
                ** break block50
            }
            finally {
                continue;
            }
            break;
        }
        ** GOTO lbl-1000
        finally {
        }
lbl-1000:
        // 1 sources

        {
            throw var6_7;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    public void tryDrainReferenceQueues() {
        boolean bl2 = this.tryLock();
        if (bl2) {
            try {
                this.drainReferenceQueues();
            }
            finally {
                this.unlock();
            }
        }
    }

    public void tryExpireEntries(long l10) {
        boolean bl2 = this.tryLock();
        if (bl2) {
            try {
                this.expireEntries(l10);
            }
            finally {
                this.unlock();
            }
        }
    }

    public Object waitForLoadingValue(ReferenceEntry object, Object object2, LocalCache$ValueReference object3) {
        boolean bl2 = object3.isLoading();
        if (bl2) {
            bl2 = Thread.holdsLock(object);
            int n10 = 1;
            String string2 = "Recursive load of: %s";
            Preconditions.checkState(bl2 ^= n10, string2, object2);
            try {
                object3 = object3.waitForValue();
                if (object3 != null) {
                    object2 = this.map;
                    object2 = ((LocalCache)object2).ticker;
                    long l10 = ((Ticker)object2).read();
                    this.recordRead((ReferenceEntry)object, l10);
                    return object3;
                }
                object3 = new StringBuilder();
                String string3 = "CacheLoader returned null for key ";
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(object2);
                object2 = ".";
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                object = new CacheLoader$InvalidCacheLoadException((String)object2);
                throw object;
            }
            finally {
                this.statsCounter.recordMisses(n10);
            }
        }
        object = new AssertionError();
        throw object;
    }
}

