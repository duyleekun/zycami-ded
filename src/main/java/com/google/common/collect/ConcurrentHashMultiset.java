/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ConcurrentHashMultiset$1;
import com.google.common.collect.ConcurrentHashMultiset$2;
import com.google.common.collect.ConcurrentHashMultiset$3;
import com.google.common.collect.ConcurrentHashMultiset$EntrySet;
import com.google.common.collect.ConcurrentHashMultiset$FieldSettersHolder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConcurrentHashMultiset
extends AbstractMultiset
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final transient ConcurrentMap countMap;

    public ConcurrentHashMultiset(ConcurrentMap concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty(), "the backing map (%s) must be empty", (Object)concurrentMap);
        this.countMap = concurrentMap;
    }

    public static /* synthetic */ ConcurrentMap access$100(ConcurrentHashMultiset concurrentHashMultiset) {
        return concurrentHashMultiset.countMap;
    }

    public static ConcurrentHashMultiset create() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMultiset concurrentHashMultiset = new ConcurrentHashMultiset(concurrentHashMap);
        return concurrentHashMultiset;
    }

    public static ConcurrentHashMultiset create(Iterable iterable) {
        ConcurrentHashMultiset concurrentHashMultiset = ConcurrentHashMultiset.create();
        Iterables.addAll(concurrentHashMultiset, iterable);
        return concurrentHashMultiset;
    }

    public static ConcurrentHashMultiset create(ConcurrentMap concurrentMap) {
        ConcurrentHashMultiset concurrentHashMultiset = new ConcurrentHashMultiset(concurrentMap);
        return concurrentHashMultiset;
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        object = (ConcurrentMap)((ObjectInputStream)object).readObject();
        ConcurrentHashMultiset$FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set((Object)this, object);
    }

    private List snapshot() {
        int n10;
        int n11 = this.size();
        ArrayList arrayList = Lists.newArrayListWithExpectedSize(n11);
        Iterator iterator2 = this.entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator2.next();
            Object object = multiset$Entry.getElement();
            for (n10 = multiset$Entry.getCount(); n10 > 0; n10 += -1) {
                arrayList.add(object);
            }
        }
        return arrayList;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        ConcurrentMap concurrentMap = this.countMap;
        objectOutputStream.writeObject(concurrentMap);
    }

    public int add(Object object, int n10) {
        boolean bl2;
        AtomicInteger atomicInteger;
        Object object2;
        Preconditions.checkNotNull(object);
        if (n10 == 0) {
            return this.count(object);
        }
        Object object3 = "occurences";
        CollectPreconditions.checkPositive(n10, (String)object3);
        do {
            int n11;
            if ((object3 = (AtomicInteger)Maps.safeGet(this.countMap, object)) == null) {
                object3 = this.countMap;
                atomicInteger = new AtomicInteger(n10);
                if ((object3 = object3.putIfAbsent(object, atomicInteger)) == null) {
                    return 0;
                }
            }
            while ((n11 = ((AtomicInteger)object3).get()) != 0) {
                int n12;
                try {
                    n12 = IntMath.checkedAdd(n11, n10);
                }
                catch (ArithmeticException arithmeticException) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Overflow adding ");
                    ((StringBuilder)object3).append(n10);
                    ((StringBuilder)object3).append(" occurrences to a count of ");
                    ((StringBuilder)object3).append(n11);
                    String string2 = ((StringBuilder)object3).toString();
                    object = new IllegalArgumentException(string2);
                    throw object;
                }
                if ((n12 = (int)(((AtomicInteger)object3).compareAndSet(n11, n12) ? 1 : 0)) == 0) continue;
                return n11;
            }
        } while ((object2 = this.countMap.putIfAbsent(object, atomicInteger = new AtomicInteger(n10))) != null && !(bl2 = (object2 = this.countMap).replace(object, object3, atomicInteger)));
        return 0;
    }

    public void clear() {
        this.countMap.clear();
    }

    public int count(Object object) {
        int n10;
        ConcurrentMap concurrentMap = this.countMap;
        if ((object = (AtomicInteger)Maps.safeGet(concurrentMap, object)) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((AtomicInteger)object).get();
        }
        return n10;
    }

    public Set createElementSet() {
        Set set = this.countMap.keySet();
        ConcurrentHashMultiset$1 concurrentHashMultiset$1 = new ConcurrentHashMultiset$1(this, set);
        return concurrentHashMultiset$1;
    }

    public Set createEntrySet() {
        ConcurrentHashMultiset$EntrySet concurrentHashMultiset$EntrySet = new ConcurrentHashMultiset$EntrySet(this, null);
        return concurrentHashMultiset$EntrySet;
    }

    public int distinctElements() {
        return this.countMap.size();
    }

    public Iterator elementIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public Iterator entryIterator() {
        ConcurrentHashMultiset$2 concurrentHashMultiset$2 = new ConcurrentHashMultiset$2(this);
        ConcurrentHashMultiset$3 concurrentHashMultiset$3 = new ConcurrentHashMultiset$3(this, concurrentHashMultiset$2);
        return concurrentHashMultiset$3;
    }

    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }

    public int remove(Object object, int n10) {
        int n11;
        if (n10 == 0) {
            return this.count(object);
        }
        CollectPreconditions.checkPositive(n10, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            return 0;
        }
        while ((n11 = atomicInteger.get()) != 0) {
            int n12 = n11 - n10;
            boolean bl2 = atomicInteger.compareAndSet(n11, n12 = Math.max(0, n12));
            if (!bl2) continue;
            if (n12 == 0) {
                ConcurrentMap concurrentMap = this.countMap;
                concurrentMap.remove(object, atomicInteger);
            }
            return n11;
        }
        return 0;
    }

    public boolean removeExactly(Object object, int n10) {
        int n11;
        int n12;
        boolean bl2 = true;
        if (n10 == 0) {
            return bl2;
        }
        CollectPreconditions.checkPositive(n10, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            return false;
        }
        do {
            if ((n12 = atomicInteger.get()) >= n10) continue;
            return false;
        } while ((n12 = (int)(atomicInteger.compareAndSet(n12, n11 = n12 - n10) ? 1 : 0)) == 0);
        if (n11 == 0) {
            ConcurrentMap concurrentMap = this.countMap;
            concurrentMap.remove(object, atomicInteger);
        }
        return bl2;
    }

    public int setCount(Object object, int n10) {
        int n11;
        Preconditions.checkNotNull(object);
        Object object2 = "count";
        CollectPreconditions.checkNonnegative(n10, (String)object2);
        block0: while (true) {
            boolean bl2;
            AtomicInteger atomicInteger;
            if ((object2 = (AtomicInteger)Maps.safeGet(this.countMap, object)) == null) {
                if (n10 == 0) {
                    return 0;
                }
                object2 = this.countMap;
                atomicInteger = new AtomicInteger(n10);
                if ((object2 = object2.putIfAbsent(object, atomicInteger)) == null) {
                    return 0;
                }
            }
            do {
                boolean bl3;
                if ((n11 = ((AtomicInteger)object2).get()) != 0) continue;
                if (n10 == 0) {
                    return 0;
                }
                atomicInteger = new AtomicInteger(n10);
                Object object3 = this.countMap.putIfAbsent(object, atomicInteger);
                if (object3 != null && !(bl3 = (object3 = this.countMap).replace(object, object2, atomicInteger))) continue block0;
                return 0;
            } while (!(bl2 = ((AtomicInteger)object2).compareAndSet(n11, n10)));
            break;
        }
        if (n10 == 0) {
            ConcurrentMap concurrentMap = this.countMap;
            concurrentMap.remove(object, object2);
        }
        return n11;
    }

    public boolean setCount(Object object, int n10, int n11) {
        Preconditions.checkNotNull(object);
        CollectPreconditions.checkNonnegative(n10, "oldCount");
        CollectPreconditions.checkNonnegative(n11, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object);
        boolean bl2 = false;
        boolean bl3 = true;
        if (atomicInteger == null) {
            if (n10 != 0) {
                return false;
            }
            if (n11 == 0) {
                return bl3;
            }
            ConcurrentMap concurrentMap = this.countMap;
            atomicInteger = new AtomicInteger(n11);
            if ((object = concurrentMap.putIfAbsent(object, atomicInteger)) == null) {
                bl2 = bl3;
            }
            return bl2;
        }
        int n12 = atomicInteger.get();
        if (n12 == n10) {
            if (n12 == 0) {
                boolean bl4;
                if (n11 == 0) {
                    this.countMap.remove(object, atomicInteger);
                    return bl3;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(n11);
                Object object2 = this.countMap.putIfAbsent(object, atomicInteger2);
                if (object2 == null || (bl4 = (object2 = this.countMap).replace(object, atomicInteger, atomicInteger2))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            n10 = (int)(atomicInteger.compareAndSet(n12, n11) ? 1 : 0);
            if (n10 != 0) {
                if (n11 == 0) {
                    ConcurrentMap concurrentMap = this.countMap;
                    concurrentMap.remove(object, atomicInteger);
                }
                return bl3;
            }
        }
        return false;
    }

    public int size() {
        int n10;
        Iterator iterator2 = this.countMap.values().iterator();
        long l10 = 0L;
        while ((n10 = iterator2.hasNext()) != 0) {
            AtomicInteger atomicInteger = (AtomicInteger)iterator2.next();
            n10 = atomicInteger.get();
            long l11 = n10;
            l10 += l11;
        }
        return Ints.saturatedCast(l10);
    }

    public Object[] toArray() {
        return this.snapshot().toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.snapshot().toArray(objectArray);
    }
}

