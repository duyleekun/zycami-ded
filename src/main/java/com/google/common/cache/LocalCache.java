/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilder$NullListener;
import com.google.common.cache.CacheBuilder$OneWeigher;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$InvalidCacheLoadException;
import com.google.common.cache.CacheLoader$UnsupportedLoadingOperationException;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$2;
import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$EntrySet;
import com.google.common.cache.LocalCache$KeySet;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$Values;
import com.google.common.cache.ReferenceEntry;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalCache
extends AbstractMap
implements ConcurrentMap {
    public static final int CONTAINS_VALUE_RETRIES = 3;
    public static final Queue DISCARDING_QUEUE;
    public static final int DRAIN_MAX = 16;
    public static final int DRAIN_THRESHOLD = 63;
    public static final int MAXIMUM_CAPACITY = 0x40000000;
    public static final int MAX_SEGMENTS = 65536;
    public static final LocalCache$ValueReference UNSET;
    public static final Logger logger;
    public final int concurrencyLevel;
    public final CacheLoader defaultLoader;
    public final LocalCache$EntryFactory entryFactory;
    public Set entrySet;
    public final long expireAfterAccessNanos;
    public final long expireAfterWriteNanos;
    public final AbstractCache$StatsCounter globalStatsCounter;
    public final Equivalence keyEquivalence;
    public Set keySet;
    public final LocalCache$Strength keyStrength;
    public final long maxWeight;
    public final long refreshNanos;
    public final RemovalListener removalListener;
    public final Queue removalNotificationQueue;
    public final int segmentMask;
    public final int segmentShift;
    public final LocalCache$Segment[] segments;
    public final Ticker ticker;
    public final Equivalence valueEquivalence;
    public final LocalCache$Strength valueStrength;
    public Collection values;
    public final Weigher weigher;

    static {
        logger = Logger.getLogger(LocalCache.class.getName());
        Object object = new LocalCache$1();
        UNSET = object;
        DISCARDING_QUEUE = object = new LocalCache$2();
    }

    /*
     * WARNING - void declaration
     */
    public LocalCache(CacheBuilder cacheBuilder, CacheLoader localCache$SegmentArray) {
        int n10;
        int n11;
        int n12;
        void var13_14;
        long l10;
        long l11;
        long l12;
        int n13;
        long l13;
        long l14;
        Object object;
        int n112 = cacheBuilder.getConcurrencyLevel();
        int n122 = 65536;
        this.concurrencyLevel = n112 = Math.min(n112, n122);
        Object object2 = cacheBuilder.getKeyStrength();
        this.keyStrength = object2;
        this.valueStrength = object = cacheBuilder.getValueStrength();
        object = cacheBuilder.getKeyEquivalence();
        this.keyEquivalence = object;
        object = cacheBuilder.getValueEquivalence();
        this.valueEquivalence = object;
        this.maxWeight = l14 = cacheBuilder.getMaximumWeight();
        Object object3 = cacheBuilder.getWeigher();
        this.weigher = object3;
        this.expireAfterAccessNanos = l13 = cacheBuilder.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = l13 = cacheBuilder.getExpireAfterWriteNanos();
        this.refreshNanos = l13 = cacheBuilder.getRefreshNanos();
        object3 = cacheBuilder.getRemovalListener();
        this.removalListener = object3;
        Object object4 = CacheBuilder$NullListener.INSTANCE;
        object3 = object3 == object4 ? LocalCache.discardingQueue() : new ConcurrentLinkedQueue();
        this.removalNotificationQueue = object3;
        boolean n132 = this.recordsTime();
        object3 = cacheBuilder.getTicker(n132);
        this.ticker = object3;
        boolean bl2 = this.usesAccessEntries();
        int n14 = this.usesWriteEntries();
        object2 = LocalCache$EntryFactory.getFactory((LocalCache$Strength)((Object)object2), bl2, n14 != 0);
        this.entryFactory = object2;
        this.globalStatsCounter = object2 = (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = localCache$SegmentArray;
        int n15 = Math.min(cacheBuilder.getInitialCapacity(), 0x40000000);
        n112 = (int)(this.evictsBySize() ? 1 : 0);
        if (n112 != 0 && (n112 = (int)(this.customWeigher() ? 1 : 0)) == 0) {
            l13 = n15;
            long l15 = Math.min(l13, l14);
            n15 = (int)l15;
        }
        n112 = 0;
        object2 = null;
        n122 = 1;
        boolean bl3 = false;
        object3 = null;
        for (n13 = n122; n13 < (n14 = this.concurrencyLevel) && ((n14 = (int)(this.evictsBySize() ? 1 : 0)) == 0 || (n14 = (int)((l12 = (l11 = (long)(n13 * 20)) - (l10 = this.maxWeight)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0); n13 <<= 1) {
            ++var13_14;
        }
        this.segmentShift = n12 = 32 - var13_14;
        this.segmentMask = n11 = n13 + -1;
        object3 = this.newSegmentArray(n13);
        this.segments = object3;
        int n16 = n15 / n13;
        n14 = n16 * n13;
        if (n14 < n15) {
            n10 = n16 + 1;
        }
        while (n122 < n10) {
            n122 <<= 1;
        }
        n15 = (int)(this.evictsBySize() ? 1 : 0);
        if (n15 != 0) {
            l13 = this.maxWeight;
            long l16 = n13;
            long l17 = l13 / l16;
            long l18 = 1L;
            l17 += l18;
            l13 %= l16;
            while (n112 < (n13 = (localCache$SegmentArray = this.segments).length)) {
                l16 = n112;
                long l19 = l16 - l13;
                n13 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
                if (n13 == 0) {
                    l17 -= l18;
                }
                Object object5 = (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get();
                localCache$SegmentArray[n112] = object5 = this.createSegment(n122, l17, (AbstractCache$StatsCounter)object5);
                ++n112;
            }
        } else {
            while (n112 < (n13 = (localCache$SegmentArray = this.segments).length)) {
                LocalCache$Segment localCache$Segment;
                long l20 = -1;
                object4 = (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get();
                localCache$SegmentArray[n112] = localCache$Segment = this.createSegment(n122, l20, (AbstractCache$StatsCounter)object4);
                ++n112;
            }
        }
    }

    public static /* synthetic */ ArrayList access$200(Collection collection) {
        return LocalCache.toArrayList(collection);
    }

    public static void connectAccessOrder(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    public static void connectWriteOrder(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    public static Queue discardingQueue() {
        return DISCARDING_QUEUE;
    }

    public static ReferenceEntry nullEntry() {
        return LocalCache$NullEntry.INSTANCE;
    }

    public static void nullifyAccessOrder(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntry2 = LocalCache.nullEntry();
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry.setPreviousInAccessQueue(referenceEntry2);
    }

    public static void nullifyWriteOrder(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntry2 = LocalCache.nullEntry();
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry.setPreviousInWriteQueue(referenceEntry2);
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

    public static LocalCache$ValueReference unset() {
        return UNSET;
    }

    public void cleanUp() {
        for (LocalCache$Segment localCache$Segment : this.segments) {
            localCache$Segment.cleanUp();
        }
    }

    public void clear() {
        for (LocalCache$Segment localCache$Segment : this.segments) {
            localCache$Segment.clear();
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
            LocalCache localCache = this;
            Object object2 = object;
            Object object3 = 0;
            ReferenceEntry referenceEntry = null;
            if (object == null) {
                return false;
            }
            Object object4 = this.ticker;
            long l10 = ((Ticker)object4).read();
            Object object5 = this.segments;
            long l11 = -1;
            for (int i10 = 0; i10 < (n10 = 3); ++i10) {
                long l12;
                LocalCache$Segment[] localCache$SegmentArray;
                long l13 = 0L;
                int n11 = ((LocalCache$Segment[])object5).length;
                for (int i11 = 0; i11 < n11; ++i11) {
                    LocalCache$Segment localCache$Segment = object5[i11];
                    AtomicReferenceArray atomicReferenceArray = localCache$Segment.table;
                    for (int i12 = 0; i12 < (object3 = atomicReferenceArray.length()); ++i12) {
                        for (referenceEntry = (ReferenceEntry)atomicReferenceArray.get(i12); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            boolean bl2;
                            localCache$SegmentArray = object5;
                            object5 = localCache$Segment.getLiveValue(referenceEntry, l10);
                            l12 = l10;
                            if (object5 != null && (bl2 = ((Equivalence)(object4 = localCache.valueEquivalence)).equivalent(object2, object5))) {
                                return true;
                            }
                            object5 = localCache$SegmentArray;
                            l10 = l12;
                        }
                        l12 = l10;
                        localCache$SegmentArray = object5;
                    }
                    l12 = l10;
                    localCache$SegmentArray = object5;
                    long l14 = localCache$Segment.modCount;
                    l13 += l14;
                    object3 = 0;
                    referenceEntry = null;
                }
                l12 = l10;
                localCache$SegmentArray = object5;
                object3 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                if (object3 == 0) {
                    object2 = null;
                    break block7;
                }
                l11 = l13;
                object3 = 0;
                referenceEntry = null;
            }
            object2 = null;
        }
        return false;
    }

    public ReferenceEntry copyEntry(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        int n10 = referenceEntry.getHash();
        return this.segmentFor(n10).copyEntry(referenceEntry, referenceEntry2);
    }

    public LocalCache$Segment createSegment(int n10, long l10, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        LocalCache$Segment localCache$Segment = new LocalCache$Segment(this, n10, l10, abstractCache$StatsCounter);
        return localCache$Segment;
    }

    public boolean customWeigher() {
        boolean bl2;
        Weigher weigher = this.weigher;
        CacheBuilder$OneWeigher cacheBuilder$OneWeigher = CacheBuilder$OneWeigher.INSTANCE;
        if (weigher != cacheBuilder$OneWeigher) {
            bl2 = true;
        } else {
            bl2 = false;
            weigher = null;
        }
        return bl2;
    }

    public Set entrySet() {
        Set set = this.entrySet;
        if (set == null) {
            this.entrySet = set = new LocalCache$EntrySet(this, this);
        }
        return set;
    }

    public boolean evictsBySize() {
        long l10 = this.maxWeight;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean expires() {
        boolean bl2 = this.expiresAfterWrite();
        bl2 = bl2 || (bl2 = this.expiresAfterAccess());
        return bl2;
    }

    public boolean expiresAfterAccess() {
        long l10 = this.expireAfterAccessNanos;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean expiresAfterWrite() {
        long l10 = this.expireAfterWriteNanos;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public Object get(Object object) {
        if (object == null) {
            return null;
        }
        int n10 = this.hash(object);
        return this.segmentFor(n10).get(object, n10);
    }

    public Object get(Object object, CacheLoader cacheLoader) {
        Object object2 = Preconditions.checkNotNull(object);
        int n10 = this.hash(object2);
        return this.segmentFor(n10).get(object, n10, cacheLoader);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImmutableMap getAll(Iterable object) {
        Object object2;
        Object object3;
        boolean bl2;
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet<Object> linkedHashSet = Sets.newLinkedHashSet();
        object = object.iterator();
        int n10 = 0;
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            object3 = object.next();
            object2 = this.get(object3);
            boolean bl3 = linkedHashMap.containsKey(object3);
            if (bl3) continue;
            linkedHashMap.put(object3, object2);
            if (object2 == null) {
                ++n11;
                linkedHashSet.add(object3);
                continue;
            }
            ++n10;
        }
        try {
            block11: {
                boolean bl4 = linkedHashSet.isEmpty();
                if (!bl4) {
                    boolean bl5;
                    try {
                        boolean bl6;
                        object = this.defaultLoader;
                        object = this.loadAll(linkedHashSet, (CacheLoader)object);
                        object3 = linkedHashSet.iterator();
                        while (bl6 = object3.hasNext()) {
                            object2 = object3.next();
                            Object v10 = object.get(object2);
                            if (v10 == null) {
                                object3 = new StringBuilder();
                                String string2 = "loadAll failed to return a value for ";
                                ((StringBuilder)object3).append(string2);
                                ((StringBuilder)object3).append(object2);
                                object3 = ((StringBuilder)object3).toString();
                                object = new CacheLoader$InvalidCacheLoadException((String)object3);
                                throw object;
                            }
                            linkedHashMap.put(object2, v10);
                        }
                        break block11;
                    }
                    catch (CacheLoader$UnsupportedLoadingOperationException cacheLoader$UnsupportedLoadingOperationException) {}
                    object = linkedHashSet.iterator();
                    while (bl5 = object.hasNext()) {
                        linkedHashSet = object.next();
                        n11 += -1;
                        object3 = this.defaultLoader;
                        object3 = this.get(linkedHashSet, (CacheLoader)object3);
                        linkedHashMap.put(linkedHashSet, object3);
                    }
                }
            }
            object = ImmutableMap.copyOf((Map)linkedHashMap);
            return object;
        }
        finally {
            this.globalStatsCounter.recordHits(n10);
            this.globalStatsCounter.recordMisses(n11);
        }
    }

    public ImmutableMap getAllPresent(Iterable object) {
        boolean bl2;
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        object = object.iterator();
        int n10 = 0;
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Object object2 = this.get(e10);
            if (object2 == null) {
                ++n11;
                continue;
            }
            linkedHashMap.put(e10, object2);
            ++n10;
        }
        this.globalStatsCounter.recordHits(n10);
        this.globalStatsCounter.recordMisses(n11);
        return ImmutableMap.copyOf((Map)linkedHashMap);
    }

    public ReferenceEntry getEntry(Object object) {
        if (object == null) {
            return null;
        }
        int n10 = this.hash(object);
        return this.segmentFor(n10).getEntry(object, n10);
    }

    public Object getIfPresent(Object object) {
        Object object2 = Preconditions.checkNotNull(object);
        int n10 = this.hash(object2);
        Object object3 = this.segmentFor(n10);
        object = ((LocalCache$Segment)object3).get(object, n10);
        n10 = 1;
        if (object == null) {
            object3 = this.globalStatsCounter;
            object3.recordMisses(n10);
        } else {
            object3 = this.globalStatsCounter;
            object3.recordHits(n10);
        }
        return object;
    }

    public Object getLiveValue(ReferenceEntry referenceEntry, long l10) {
        Object object = referenceEntry.getKey();
        if (object == null) {
            return null;
        }
        object = referenceEntry.getValueReference().get();
        if (object == null) {
            return null;
        }
        boolean bl2 = this.isExpired(referenceEntry, l10);
        if (bl2) {
            return null;
        }
        return object;
    }

    public Object getOrDefault(Object object, Object object2) {
        if ((object = this.get(object)) != null) {
            object2 = object;
        }
        return object2;
    }

    public Object getOrLoad(Object object) {
        CacheLoader cacheLoader = this.defaultLoader;
        return this.get(object, cacheLoader);
    }

    public int hash(Object object) {
        return LocalCache.rehash(this.keyEquivalence.hash(object));
    }

    public void invalidateAll(Iterable object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            this.remove(e10);
        }
    }

    public boolean isEmpty() {
        int n10;
        int n11;
        LocalCache$Segment[] localCache$SegmentArray = this.segments;
        long l10 = 0L;
        int n12 = 0;
        long l11 = l10;
        for (n11 = 0; n11 < (n10 = localCache$SegmentArray.length); ++n11) {
            LocalCache$Segment localCache$Segment = localCache$SegmentArray[n11];
            n10 = localCache$Segment.count;
            if (n10 != 0) {
                return false;
            }
            localCache$Segment = localCache$SegmentArray[n11];
            n10 = localCache$Segment.modCount;
            long l12 = n10;
            l11 += l12;
        }
        n11 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        n10 = 1;
        if (n11 != 0) {
            int n13;
            for (n11 = 0; n11 < (n13 = localCache$SegmentArray.length); ++n11) {
                LocalCache$Segment localCache$Segment = localCache$SegmentArray[n11];
                n13 = localCache$Segment.count;
                if (n13 != 0) {
                    return false;
                }
                localCache$Segment = localCache$SegmentArray[n11];
                n13 = localCache$Segment.modCount;
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

    public boolean isExpired(ReferenceEntry referenceEntry, long l10) {
        long l11;
        Preconditions.checkNotNull(referenceEntry);
        Object object = this.expiresAfterAccess();
        boolean bl2 = true;
        if (object != 0) {
            l11 = referenceEntry.getAccessTime();
            long l12 = this.expireAfterAccessNanos;
            long l13 = (l11 = l10 - l11) - l12;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object >= 0) {
                return bl2;
            }
        }
        if ((object = this.expiresAfterWrite()) != 0) {
            l11 = referenceEntry.getWriteTime();
            long l14 = (l10 -= l11) - (l11 = this.expireAfterWriteNanos);
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 >= 0) {
                return bl2;
            }
        }
        return false;
    }

    public boolean isLive(ReferenceEntry object, long l10) {
        boolean bl2;
        int n10 = object.getHash();
        LocalCache$Segment localCache$Segment = this.segmentFor(n10);
        if ((object = localCache$Segment.getLiveValue((ReferenceEntry)object, l10)) != null) {
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
            this.keySet = set = new LocalCache$KeySet(this, this);
        }
        return set;
    }

    /*
     * Exception decompiling
     */
    public Map loadAll(Set var1_1, CacheLoader var2_10) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [6 : 296->299)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public long longSize() {
        int n10;
        LocalCache$Segment[] localCache$SegmentArray = this.segments;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = localCache$SegmentArray.length); ++i10) {
            LocalCache$Segment localCache$Segment = localCache$SegmentArray[i10];
            n10 = localCache$Segment.count;
            n10 = Math.max(0, n10);
            long l11 = n10;
            l10 += l11;
        }
        return l10;
    }

    public ReferenceEntry newEntry(Object object, int n10, ReferenceEntry referenceEntry) {
        LocalCache$Segment localCache$Segment = this.segmentFor(n10);
        localCache$Segment.lock();
        try {
            object = localCache$Segment.newEntry(object, n10, referenceEntry);
            return object;
        }
        finally {
            localCache$Segment.unlock();
        }
    }

    public final LocalCache$Segment[] newSegmentArray(int n10) {
        return new LocalCache$Segment[n10];
    }

    public LocalCache$ValueReference newValueReference(ReferenceEntry referenceEntry, Object object, int n10) {
        int n11 = referenceEntry.getHash();
        LocalCache$Strength localCache$Strength = this.valueStrength;
        LocalCache$Segment localCache$Segment = this.segmentFor(n11);
        object = Preconditions.checkNotNull(object);
        return localCache$Strength.referenceValue(localCache$Segment, referenceEntry, object, n10);
    }

    public void processPendingNotifications() {
        RemovalNotification removalNotification;
        while ((removalNotification = (RemovalNotification)this.removalNotificationQueue.poll()) != null) {
            Object object = this.removalListener;
            try {
                object.onRemoval(removalNotification);
            }
            catch (Throwable throwable) {
                object = logger;
                Level level = Level.WARNING;
                String string2 = "Exception thrown by removal listener";
                ((Logger)object).log(level, string2, throwable);
            }
        }
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

    public void reclaimKey(ReferenceEntry referenceEntry) {
        int n10 = referenceEntry.getHash();
        this.segmentFor(n10).reclaimKey(referenceEntry, n10);
    }

    public void reclaimValue(LocalCache$ValueReference localCache$ValueReference) {
        Object object = localCache$ValueReference.getEntry();
        int n10 = object.getHash();
        LocalCache$Segment localCache$Segment = this.segmentFor(n10);
        object = object.getKey();
        localCache$Segment.reclaimValue(object, n10, localCache$ValueReference);
    }

    public boolean recordsAccess() {
        return this.expiresAfterAccess();
    }

    public boolean recordsTime() {
        boolean bl2 = this.recordsWrite();
        bl2 = bl2 || (bl2 = this.recordsAccess());
        return bl2;
    }

    public boolean recordsWrite() {
        boolean bl2 = this.expiresAfterWrite();
        bl2 = bl2 || (bl2 = this.refreshes());
        return bl2;
    }

    public void refresh(Object object) {
        Object object2 = Preconditions.checkNotNull(object);
        int n10 = this.hash(object2);
        LocalCache$Segment localCache$Segment = this.segmentFor(n10);
        CacheLoader cacheLoader = this.defaultLoader;
        localCache$Segment.refresh(object, n10, cacheLoader, false);
    }

    public boolean refreshes() {
        long l10 = this.refreshNanos;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
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

    public LocalCache$Segment segmentFor(int n10) {
        LocalCache$Segment[] localCache$SegmentArray = this.segments;
        int n11 = this.segmentShift;
        n10 >>>= n11;
        n11 = this.segmentMask;
        return localCache$SegmentArray[n10 &= n11];
    }

    public int size() {
        return Ints.saturatedCast(this.longSize());
    }

    public boolean usesAccessEntries() {
        boolean bl2 = this.usesAccessQueue();
        bl2 = bl2 || (bl2 = this.recordsAccess());
        return bl2;
    }

    public boolean usesAccessQueue() {
        boolean bl2 = this.expiresAfterAccess();
        bl2 = bl2 || (bl2 = this.evictsBySize());
        return bl2;
    }

    public boolean usesKeyReferences() {
        boolean bl2;
        LocalCache$Strength localCache$Strength = this.keyStrength;
        LocalCache$Strength localCache$Strength2 = LocalCache$Strength.STRONG;
        if (localCache$Strength != localCache$Strength2) {
            bl2 = true;
        } else {
            bl2 = false;
            localCache$Strength = null;
        }
        return bl2;
    }

    public boolean usesValueReferences() {
        boolean bl2;
        LocalCache$Strength localCache$Strength = this.valueStrength;
        LocalCache$Strength localCache$Strength2 = LocalCache$Strength.STRONG;
        if (localCache$Strength != localCache$Strength2) {
            bl2 = true;
        } else {
            bl2 = false;
            localCache$Strength = null;
        }
        return bl2;
    }

    public boolean usesWriteEntries() {
        boolean bl2 = this.usesWriteQueue();
        bl2 = bl2 || (bl2 = this.recordsWrite());
        return bl2;
    }

    public boolean usesWriteQueue() {
        return this.expiresAfterWrite();
    }

    public Collection values() {
        Collection collection = this.values;
        if (collection == null) {
            this.values = collection = new LocalCache$Values(this, this);
        }
        return collection;
    }
}

