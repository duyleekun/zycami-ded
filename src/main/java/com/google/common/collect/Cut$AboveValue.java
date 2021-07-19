/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.Cut$1;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

public final class Cut$AboveValue
extends Cut {
    private static final long serialVersionUID;

    public Cut$AboveValue(Comparable comparable) {
        comparable = (Comparable)Preconditions.checkNotNull(comparable);
        super(comparable);
    }

    public Cut canonical(DiscreteDomain object) {
        object = (object = this.leastValueAbove((DiscreteDomain)object)) != null ? Cut.belowValue((Comparable)object) : Cut.aboveAll();
        return object;
    }

    public void describeAsLowerBound(StringBuilder stringBuilder) {
        stringBuilder.append('(');
        Comparable comparable = this.endpoint;
        stringBuilder.append(comparable);
    }

    public void describeAsUpperBound(StringBuilder stringBuilder) {
        Comparable comparable = this.endpoint;
        stringBuilder.append(comparable);
        stringBuilder.append(']');
    }

    public Comparable greatestValueBelow(DiscreteDomain discreteDomain) {
        return this.endpoint;
    }

    public int hashCode() {
        return ~this.endpoint.hashCode();
    }

    public boolean isLessThan(Comparable comparable) {
        Comparable comparable2 = this.endpoint;
        int n10 = Range.compareOrThrow(comparable2, comparable);
        if (n10 < 0) {
            n10 = 1;
        } else {
            n10 = 0;
            comparable = null;
        }
        return n10 != 0;
    }

    public Comparable leastValueAbove(DiscreteDomain discreteDomain) {
        Comparable comparable = this.endpoint;
        return discreteDomain.next(comparable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        Comparable comparable = this.endpoint;
        stringBuilder.append(comparable);
        stringBuilder.append("\\");
        return stringBuilder.toString();
    }

    public BoundType typeAsLowerBound() {
        return BoundType.OPEN;
    }

    public BoundType typeAsUpperBound() {
        return BoundType.CLOSED;
    }

    public Cut withLowerBoundType(BoundType object, DiscreteDomain discreteDomain) {
        int[] nArray = Cut$1.$SwitchMap$com$google$common$collect$BoundType;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 == n12) {
                return this;
            }
            object = new AssertionError();
            throw object;
        }
        object = this.endpoint;
        object = (object = discreteDomain.next((Comparable)object)) == null ? Cut.belowAll() : Cut.belowValue((Comparable)object);
        return object;
    }

    public Cut withUpperBoundType(BoundType object, DiscreteDomain discreteDomain) {
        int[] nArray = Cut$1.$SwitchMap$com$google$common$collect$BoundType;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 == n11) {
                object = this.endpoint;
                object = (object = discreteDomain.next((Comparable)object)) == null ? Cut.aboveAll() : Cut.belowValue((Comparable)object);
                return object;
            }
            object = new AssertionError();
            throw object;
        }
        return this;
    }
}

