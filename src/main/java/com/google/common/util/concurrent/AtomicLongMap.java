/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AtomicLongMap$1;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class AtomicLongMap
implements Serializable {
    private transient Map asMap;
    private final ConcurrentHashMap map;

    private AtomicLongMap(ConcurrentHashMap concurrentHashMap) {
        this.map = concurrentHashMap = (ConcurrentHashMap)Preconditions.checkNotNull(concurrentHashMap);
    }

    public static AtomicLongMap create() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        AtomicLongMap atomicLongMap = new AtomicLongMap(concurrentHashMap);
        return atomicLongMap;
    }

    public static AtomicLongMap create(Map map) {
        AtomicLongMap atomicLongMap = AtomicLongMap.create();
        atomicLongMap.putAll(map);
        return atomicLongMap;
    }

    private Map createAsMap() {
        ConcurrentHashMap concurrentHashMap = this.map;
        AtomicLongMap$1 atomicLongMap$1 = new AtomicLongMap$1(this);
        return Collections.unmodifiableMap(Maps.transformValues(concurrentHashMap, (Function)atomicLongMap$1));
    }

    public long addAndGet(Object object, long l10) {
        long l11;
        block0: while (true) {
            long l12;
            boolean bl2;
            Serializable serializable;
            Serializable serializable2;
            if ((serializable2 = (AtomicLong)this.map.get(object)) == null) {
                serializable2 = this.map;
                serializable = new AtomicLong(l10);
                if ((serializable2 = ((ConcurrentHashMap)serializable2).putIfAbsent(object, serializable)) == null) {
                    return l10;
                }
            }
            do {
                long l13;
                long l14;
                if ((l14 = (l13 = (l12 = ((AtomicLong)serializable2).get()) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) continue;
                serializable = this.map;
                AtomicLong atomicLong = new AtomicLong(l10);
                boolean bl3 = ((ConcurrentHashMap)serializable).replace(object, serializable2, atomicLong);
                if (!bl3) continue block0;
                return l10;
            } while (!(bl2 = ((AtomicLong)serializable2).compareAndSet(l12, l11 = l12 + l10)));
            break;
        }
        return l11;
    }

    public Map asMap() {
        Map map = this.asMap;
        if (map == null) {
            this.asMap = map = this.createAsMap();
        }
        return map;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public long decrementAndGet(Object object) {
        return this.addAndGet(object, -1);
    }

    public long get(Object object) {
        ConcurrentHashMap concurrentHashMap = this.map;
        long l10 = (object = (AtomicLong)concurrentHashMap.get(object)) == null ? 0L : ((AtomicLong)object).get();
        return l10;
    }

    public long getAndAdd(Object object, long l10) {
        long l11;
        block0: while (true) {
            long l12;
            long l13;
            Serializable serializable;
            Serializable serializable2 = (AtomicLong)this.map.get(object);
            long l14 = 0L;
            if (serializable2 == null) {
                serializable2 = this.map;
                serializable = new AtomicLong(l10);
                if ((serializable2 = ((ConcurrentHashMap)serializable2).putIfAbsent(object, serializable)) == null) {
                    return l14;
                }
            }
            do {
                long l15;
                if ((l13 = (l15 = (l11 = ((AtomicLong)serializable2).get()) - l14) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) continue;
                serializable = this.map;
                AtomicLong atomicLong = new AtomicLong(l10);
                boolean bl2 = ((ConcurrentHashMap)serializable).replace(object, serializable2, atomicLong);
                if (!bl2) continue block0;
                return l14;
            } while ((l13 = (long)((AtomicLong)serializable2).compareAndSet(l11, l12 = l11 + l10)) == false);
            break;
        }
        return l11;
    }

    public long getAndDecrement(Object object) {
        return this.getAndAdd(object, -1);
    }

    public long getAndIncrement(Object object) {
        return this.getAndAdd(object, 1L);
    }

    public long incrementAndGet(Object object) {
        return this.addAndGet(object, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public long put(Object object, long l10) {
        long l11;
        block0: while (true) {
            long l12;
            Serializable serializable;
            Serializable serializable2 = (AtomicLong)this.map.get(object);
            long l13 = 0L;
            if (serializable2 == null) {
                serializable2 = this.map;
                serializable = new AtomicLong(l10);
                if ((serializable2 = ((ConcurrentHashMap)serializable2).putIfAbsent(object, serializable)) == null) {
                    return l13;
                }
            }
            do {
                long l14;
                if ((l12 = (l14 = (l11 = ((AtomicLong)serializable2).get()) - l13) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) continue;
                serializable = this.map;
                AtomicLong atomicLong = new AtomicLong(l10);
                boolean bl2 = ((ConcurrentHashMap)serializable).replace(object, serializable2, atomicLong);
                if (!bl2) continue block0;
                return l13;
            } while ((l12 = (long)((AtomicLong)serializable2).compareAndSet(l11, l10)) == false);
            break;
        }
        return l11;
    }

    public void putAll(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object k10 = object2.getKey();
            object2 = (Long)object2.getValue();
            long l10 = (Long)object2;
            this.put(k10, l10);
        }
    }

    public long putIfAbsent(Object object, long l10) {
        long l11;
        block3: {
            long l12;
            AtomicLong atomicLong;
            Serializable serializable;
            Serializable serializable2;
            boolean bl2;
            do {
                long l13;
                long l14;
                serializable = (AtomicLong)this.map.get(object);
                l12 = 0L;
                if (serializable == null) {
                    serializable = this.map;
                    serializable2 = new AtomicLong(l10);
                    if ((serializable = ((ConcurrentHashMap)serializable).putIfAbsent(object, serializable2)) == null) {
                        return l12;
                    }
                }
                if ((l14 = (l13 = (l11 = ((AtomicLong)serializable).get()) - l12) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) break block3;
            } while (!(bl2 = ((ConcurrentHashMap)(serializable2 = this.map)).replace(object, serializable, atomicLong = new AtomicLong(l10))));
            return l12;
        }
        return l11;
    }

    public long remove(Object object) {
        long l10;
        long l11;
        long l12;
        AtomicLong atomicLong = (AtomicLong)this.map.get(object);
        long l13 = 0L;
        if (atomicLong == null) {
            return l13;
        }
        while ((l12 = (l11 = (l10 = atomicLong.get()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false && (l12 = (long)atomicLong.compareAndSet(l10, l13)) == false) {
        }
        this.map.remove(object, atomicLong);
        return l10;
    }

    public boolean remove(Object object, long l10) {
        AtomicLong atomicLong = (AtomicLong)this.map.get(object);
        if (atomicLong == null) {
            return false;
        }
        long l11 = atomicLong.get();
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            return false;
        }
        l10 = 0L;
        long l13 = l11 - l10;
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 != false && (object2 = (Object)atomicLong.compareAndSet(l11, l10)) == false) {
            return false;
        }
        this.map.remove(object, atomicLong);
        return true;
    }

    public void removeAllZeros() {
        boolean bl2;
        Iterator iterator2 = this.map.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            long l10;
            long l11;
            long l12;
            AtomicLong atomicLong = (AtomicLong)iterator2.next().getValue();
            if (atomicLong == null || (bl2 = (l12 = (l11 = atomicLong.get()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) continue;
            iterator2.remove();
        }
    }

    public boolean removeIfZero(Object object) {
        return this.remove(object, 0L);
    }

    public boolean replace(Object object, long l10, long l11) {
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        boolean bl2 = false;
        if (l13 == false) {
            long l14 = this.putIfAbsent(object, l11);
            long l15 = l14 - l12;
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 == false) {
                bl2 = true;
            }
            return bl2;
        }
        ConcurrentHashMap concurrentHashMap = this.map;
        if ((object = (AtomicLong)concurrentHashMap.get(object)) != null) {
            bl2 = ((AtomicLong)object).compareAndSet(l10, l11);
        }
        return bl2;
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        boolean bl2;
        Iterator iterator2 = this.map.values().iterator();
        long l10 = 0L;
        while (bl2 = iterator2.hasNext()) {
            AtomicLong atomicLong = (AtomicLong)iterator2.next();
            long l11 = atomicLong.get();
            l10 += l11;
        }
        return l10;
    }

    public String toString() {
        return this.map.toString();
    }
}

