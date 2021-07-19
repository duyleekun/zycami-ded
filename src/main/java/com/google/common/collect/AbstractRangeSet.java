/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import java.util.Set;

public abstract class AbstractRangeSet
implements RangeSet {
    public void add(Range serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void addAll(RangeSet object) {
        object = object.asRanges();
        this.addAll((Iterable)object);
    }

    public void addAll(Iterable object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Range range = (Range)object.next();
            this.add(range);
        }
    }

    public void clear() {
        Range range = Range.all();
        this.remove(range);
    }

    public boolean contains(Comparable object) {
        boolean bl2;
        if ((object = this.rangeContaining((Comparable)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public abstract boolean encloses(Range var1);

    public boolean enclosesAll(RangeSet object) {
        object = object.asRanges();
        return this.enclosesAll((Iterable)object);
    }

    public boolean enclosesAll(Iterable object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Range range = (Range)object.next();
            bl2 = this.encloses(range);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof RangeSet;
        if (bl2) {
            object = (RangeSet)object;
            Set set = this.asRanges();
            object = object.asRanges();
            return set.equals(object);
        }
        return false;
    }

    public final int hashCode() {
        return this.asRanges().hashCode();
    }

    public boolean intersects(Range range) {
        return this.subRangeSet(range).isEmpty() ^ true;
    }

    public boolean isEmpty() {
        return this.asRanges().isEmpty();
    }

    public abstract Range rangeContaining(Comparable var1);

    public void remove(Range serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void removeAll(RangeSet object) {
        object = object.asRanges();
        this.removeAll((Iterable)object);
    }

    public void removeAll(Iterable object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Range range = (Range)object.next();
            this.remove(range);
        }
    }

    public final String toString() {
        return this.asRanges().toString();
    }
}

