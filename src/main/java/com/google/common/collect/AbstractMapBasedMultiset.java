/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultiset$1;
import com.google.common.collect.AbstractMapBasedMultiset$2;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.ObjectCountHashMap;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

public abstract class AbstractMapBasedMultiset
extends AbstractMultiset
implements Serializable {
    private static final long serialVersionUID;
    public transient ObjectCountHashMap backingMap;
    public transient long size;

    public AbstractMapBasedMultiset(int n10) {
        this.init(n10);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n10 = Serialization.readCount(objectInputStream);
        this.init(3);
        Serialization.populateMultiset(this, objectInputStream, n10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    public final int add(Object object, int n10) {
        long l10;
        ObjectCountHashMap objectCountHashMap;
        int n11;
        if (n10 == 0) {
            return this.count(object);
        }
        int n12 = 1;
        if (n10 > 0) {
            n11 = n12;
        } else {
            n11 = 0;
            objectCountHashMap = null;
        }
        String string2 = "occurrences cannot be negative: %s";
        Preconditions.checkArgument(n11 != 0, string2, n10);
        objectCountHashMap = this.backingMap;
        n11 = objectCountHashMap.indexOf(object);
        int n13 = -1;
        if (n11 == n13) {
            this.backingMap.put(object, n10);
            long l11 = this.size;
            long l12 = n10;
            this.size = l11 += l12;
            return 0;
        }
        object = this.backingMap;
        int n14 = ((ObjectCountHashMap)object).getValue(n11);
        long l13 = n14;
        long l14 = n10;
        long l15 = Integer.MAX_VALUE;
        long l16 = (l13 += l14) - l15;
        if ((n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1))) > 0) {
            n12 = 0;
        }
        Preconditions.checkArgument(n12 != 0, "too many occurrences: %s", l13);
        ObjectCountHashMap objectCountHashMap2 = this.backingMap;
        n12 = (int)l13;
        objectCountHashMap2.setValue(n11, n12);
        this.size = l10 = this.size + l14;
        return n14;
    }

    public void addTo(Multiset multiset) {
        Preconditions.checkNotNull(multiset);
        ObjectCountHashMap objectCountHashMap = this.backingMap;
        int n10 = objectCountHashMap.firstIndex();
        while (n10 >= 0) {
            Object object = this.backingMap.getKey(n10);
            ObjectCountHashMap objectCountHashMap2 = this.backingMap;
            int n11 = objectCountHashMap2.getValue(n10);
            multiset.add(object, n11);
            object = this.backingMap;
            n10 = ((ObjectCountHashMap)object).nextIndex(n10);
        }
    }

    public final void clear() {
        this.backingMap.clear();
        this.size = 0L;
    }

    public final int count(Object object) {
        return this.backingMap.get(object);
    }

    public final int distinctElements() {
        return this.backingMap.size();
    }

    public final Iterator elementIterator() {
        AbstractMapBasedMultiset$1 abstractMapBasedMultiset$1 = new AbstractMapBasedMultiset$1(this);
        return abstractMapBasedMultiset$1;
    }

    public final Iterator entryIterator() {
        AbstractMapBasedMultiset$2 abstractMapBasedMultiset$2 = new AbstractMapBasedMultiset$2(this);
        return abstractMapBasedMultiset$2;
    }

    public abstract void init(int var1);

    public final Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }

    public final int remove(Object object, int n10) {
        ObjectCountHashMap objectCountHashMap;
        int n11;
        if (n10 == 0) {
            return this.count(object);
        }
        int n12 = 0;
        ObjectCountHashMap objectCountHashMap2 = null;
        if (n10 > 0) {
            n11 = 1;
        } else {
            n11 = 0;
            objectCountHashMap = null;
        }
        String string2 = "occurrences cannot be negative: %s";
        Preconditions.checkArgument(n11 != 0, string2, n10);
        objectCountHashMap = this.backingMap;
        int n13 = objectCountHashMap.indexOf(object);
        n11 = -1;
        if (n13 == n11) {
            return 0;
        }
        objectCountHashMap2 = this.backingMap;
        n12 = objectCountHashMap2.getValue(n13);
        if (n12 > n10) {
            objectCountHashMap = this.backingMap;
            int n14 = n12 - n10;
            objectCountHashMap.setValue(n13, n14);
        } else {
            ObjectCountHashMap objectCountHashMap3 = this.backingMap;
            objectCountHashMap3.removeEntry(n13);
            n10 = n12;
        }
        long l10 = this.size;
        long l11 = n10;
        this.size = l10 -= l11;
        return n12;
    }

    public final int setCount(Object object, int n10) {
        CollectPreconditions.checkNonnegative(n10, "count");
        ObjectCountHashMap objectCountHashMap = this.backingMap;
        int n11 = n10 == 0 ? objectCountHashMap.remove(object) : objectCountHashMap.put(object, n10);
        long l10 = this.size;
        long l11 = n10 - n11;
        this.size = l10 += l11;
        return n11;
    }

    public final boolean setCount(Object object, int n10, int n11) {
        CollectPreconditions.checkNonnegative(n10, "oldCount");
        CollectPreconditions.checkNonnegative(n11, "newCount");
        ObjectCountHashMap objectCountHashMap = this.backingMap;
        int n12 = objectCountHashMap.indexOf(object);
        boolean bl2 = true;
        int n13 = -1;
        if (n12 == n13) {
            if (n10 != 0) {
                return false;
            }
            if (n11 > 0) {
                ObjectCountHashMap objectCountHashMap2 = this.backingMap;
                objectCountHashMap2.put(object, n11);
                long l10 = this.size;
                long l11 = n11;
                this.size = l10 += l11;
            }
            return bl2;
        }
        object = this.backingMap;
        int n14 = ((ObjectCountHashMap)object).getValue(n12);
        if (n14 != n10) {
            return false;
        }
        if (n11 == 0) {
            object = this.backingMap;
            ((ObjectCountHashMap)object).removeEntry(n12);
            long l12 = this.size;
            long l13 = n10;
            this.size = l12 -= l13;
        } else {
            object = this.backingMap;
            ((ObjectCountHashMap)object).setValue(n12, n11);
            long l14 = this.size;
            long l15 = n11 -= n10;
            this.size = l14 += l15;
        }
        return bl2;
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }
}

