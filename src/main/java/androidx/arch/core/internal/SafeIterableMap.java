/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap$AscendingIterator;
import androidx.arch.core.internal.SafeIterableMap$DescendingIterator;
import androidx.arch.core.internal.SafeIterableMap$Entry;
import androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions;
import androidx.arch.core.internal.SafeIterableMap$SupportRemove;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap
implements Iterable {
    private SafeIterableMap$Entry mEnd;
    private WeakHashMap mIterators;
    private int mSize;
    public SafeIterableMap$Entry mStart;

    public SafeIterableMap() {
        WeakHashMap weakHashMap;
        this.mIterators = weakHashMap = new WeakHashMap();
        this.mSize = 0;
    }

    public Iterator descendingIterator() {
        Object object = this.mEnd;
        Object object2 = this.mStart;
        SafeIterableMap$DescendingIterator safeIterableMap$DescendingIterator = new SafeIterableMap$DescendingIterator((SafeIterableMap$Entry)object, (SafeIterableMap$Entry)object2);
        object = this.mIterators;
        object2 = Boolean.FALSE;
        ((WeakHashMap)object).put(safeIterableMap$DescendingIterator, object2);
        return safeIterableMap$DescendingIterator;
    }

    public Map.Entry eldest() {
        return this.mStart;
    }

    public boolean equals(Object object) {
        boolean bl2;
        int n10;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        int n11 = object instanceof SafeIterableMap;
        if (n11 == 0) {
            return false;
        }
        object = (SafeIterableMap)object;
        n11 = this.size();
        if (n11 != (n10 = ((SafeIterableMap)object).size())) {
            return false;
        }
        Iterator iterator2 = this.iterator();
        object = ((SafeIterableMap)object).iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0 && (n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            Object e10 = object.next();
            if ((entry != null || e10 == null) && (entry == null || (n10 = (int)(entry.equals(e10) ? 1 : 0)) != 0)) continue;
            return false;
        }
        n11 = iterator2.hasNext() ? 1 : 0;
        if (n11 != 0 || (bl2 = object.hasNext())) {
            bl3 = false;
        }
        return bl3;
    }

    public SafeIterableMap$Entry get(Object object) {
        Object object2;
        boolean bl2;
        SafeIterableMap$Entry safeIterableMap$Entry = this.mStart;
        while (safeIterableMap$Entry != null && !(bl2 = (object2 = safeIterableMap$Entry.mKey).equals(object))) {
            safeIterableMap$Entry = safeIterableMap$Entry.mNext;
        }
        return safeIterableMap$Entry;
    }

    public int hashCode() {
        int n10;
        Iterator iterator2 = this.iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            n10 = entry.hashCode();
            n11 += n10;
        }
        return n11;
    }

    public Iterator iterator() {
        Object object = this.mStart;
        Object object2 = this.mEnd;
        SafeIterableMap$AscendingIterator safeIterableMap$AscendingIterator = new SafeIterableMap$AscendingIterator((SafeIterableMap$Entry)object, (SafeIterableMap$Entry)object2);
        object = this.mIterators;
        object2 = Boolean.FALSE;
        ((WeakHashMap)object).put(safeIterableMap$AscendingIterator, object2);
        return safeIterableMap$AscendingIterator;
    }

    public SafeIterableMap$IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap$IteratorWithAdditions safeIterableMap$IteratorWithAdditions = new SafeIterableMap$IteratorWithAdditions(this);
        WeakHashMap weakHashMap = this.mIterators;
        Boolean bl2 = Boolean.FALSE;
        weakHashMap.put(safeIterableMap$IteratorWithAdditions, bl2);
        return safeIterableMap$IteratorWithAdditions;
    }

    public Map.Entry newest() {
        return this.mEnd;
    }

    public SafeIterableMap$Entry put(Object object, Object object2) {
        int n10;
        SafeIterableMap$Entry safeIterableMap$Entry = new SafeIterableMap$Entry(object, object2);
        this.mSize = n10 = this.mSize + 1;
        object = this.mEnd;
        if (object == null) {
            this.mStart = safeIterableMap$Entry;
            this.mEnd = safeIterableMap$Entry;
            return safeIterableMap$Entry;
        }
        ((SafeIterableMap$Entry)object).mNext = safeIterableMap$Entry;
        safeIterableMap$Entry.mPrevious = object;
        this.mEnd = safeIterableMap$Entry;
        return safeIterableMap$Entry;
    }

    public Object putIfAbsent(Object object, Object object2) {
        SafeIterableMap$Entry safeIterableMap$Entry = this.get(object);
        if (safeIterableMap$Entry != null) {
            return safeIterableMap$Entry.mValue;
        }
        this.put(object, object2);
        return null;
    }

    public Object remove(Object object) {
        Object object2;
        int n10;
        if ((object = this.get(object)) == null) {
            return null;
        }
        this.mSize = n10 = this.mSize + -1;
        Object object3 = this.mIterators;
        n10 = ((WeakHashMap)object3).isEmpty() ? 1 : 0;
        if (n10 == 0) {
            boolean bl2;
            object3 = this.mIterators.keySet().iterator();
            while (bl2 = object3.hasNext()) {
                object2 = (SafeIterableMap$SupportRemove)object3.next();
                object2.supportRemove((SafeIterableMap$Entry)object);
            }
        }
        if ((object3 = ((SafeIterableMap$Entry)object).mPrevious) != null) {
            object2 = ((SafeIterableMap$Entry)object).mNext;
            ((SafeIterableMap$Entry)object3).mNext = object2;
        } else {
            object2 = ((SafeIterableMap$Entry)object).mNext;
            this.mStart = object2;
        }
        object2 = ((SafeIterableMap$Entry)object).mNext;
        if (object2 != null) {
            ((SafeIterableMap$Entry)object2).mPrevious = object3;
        } else {
            this.mEnd = object3;
        }
        ((SafeIterableMap$Entry)object).mNext = null;
        ((SafeIterableMap$Entry)object).mPrevious = null;
        return ((SafeIterableMap$Entry)object).mValue;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator iterator2 = this.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = ((Map.Entry)iterator2.next()).toString();
            stringBuilder.append(string2);
            bl2 = iterator2.hasNext();
            if (!bl2) continue;
            string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

