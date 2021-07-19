/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import java.io.Serializable;
import java.util.Comparator;

public final class GeneralRange
implements Serializable {
    private final Comparator comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    private final Object lowerEndpoint;
    private transient GeneralRange reverse;
    private final BoundType upperBoundType;
    private final Object upperEndpoint;

    private GeneralRange(Comparator object, boolean bl2, Object object2, BoundType boundType, boolean bl3, Object object3, BoundType boundType2) {
        Object object4;
        this.comparator = object4 = (Comparator)Preconditions.checkNotNull(object);
        this.hasLowerBound = bl2;
        this.hasUpperBound = bl3;
        this.lowerEndpoint = object2;
        object4 = (BoundType)((Object)Preconditions.checkNotNull((Object)boundType));
        this.lowerBoundType = object4;
        this.upperEndpoint = object3;
        object4 = (BoundType)((Object)Preconditions.checkNotNull((Object)boundType2));
        this.upperBoundType = object4;
        if (bl2) {
            object.compare(object2, object2);
        }
        if (bl3) {
            object.compare(object3, object3);
        }
        if (bl2 && bl3) {
            boolean bl4;
            int bl5 = object.compare(object2, object3);
            bl2 = true;
            bl3 = false;
            if (bl5 <= 0) {
                bl4 = bl2;
            } else {
                bl4 = false;
                object4 = null;
            }
            String string2 = "lowerEndpoint (%s) > upperEndpoint (%s)";
            Preconditions.checkArgument(bl4, string2, object2, object3);
            if (bl5 == 0) {
                boolean bl6;
                object = BoundType.OPEN;
                if (boundType != object) {
                    bl6 = bl2;
                } else {
                    bl6 = false;
                    object2 = null;
                }
                if (boundType2 == object) {
                    bl2 = false;
                }
                boolean bl7 = bl6 | bl2;
                Preconditions.checkArgument(bl7);
            }
        }
    }

    public static GeneralRange all(Comparator comparator) {
        BoundType boundType = BoundType.OPEN;
        GeneralRange generalRange = new GeneralRange(comparator, false, null, boundType, false, null, boundType);
        return generalRange;
    }

    public static GeneralRange downTo(Comparator comparator, Object object, BoundType boundType) {
        BoundType boundType2 = BoundType.OPEN;
        GeneralRange generalRange = new GeneralRange(comparator, true, object, boundType, false, null, boundType2);
        return generalRange;
    }

    public static GeneralRange from(Range range) {
        Object object;
        boolean bl2 = range.hasLowerBound();
        Comparable comparable = null;
        Object object2 = bl2 ? (object = range.lowerEndpoint()) : null;
        bl2 = range.hasLowerBound();
        object = bl2 ? range.lowerBoundType() : BoundType.OPEN;
        Object object3 = object;
        bl2 = range.hasUpperBound();
        if (bl2) {
            comparable = range.upperEndpoint();
        }
        Comparable comparable2 = comparable;
        bl2 = range.hasUpperBound();
        object = bl2 ? range.upperBoundType() : BoundType.OPEN;
        Object object4 = object;
        Ordering ordering = Ordering.natural();
        boolean bl3 = range.hasLowerBound();
        boolean bl4 = range.hasUpperBound();
        object = new GeneralRange(ordering, bl3, object2, (BoundType)((Object)object3), bl4, comparable2, (BoundType)((Object)object4));
        return object;
    }

    public static GeneralRange range(Comparator comparator, Object object, BoundType boundType, Object object2, BoundType boundType2) {
        GeneralRange generalRange = new GeneralRange(comparator, true, object, boundType, true, object2, boundType2);
        return generalRange;
    }

    public static GeneralRange upTo(Comparator comparator, Object object, BoundType boundType) {
        BoundType boundType2 = BoundType.OPEN;
        GeneralRange generalRange = new GeneralRange(comparator, false, null, boundType2, true, object, boundType);
        return generalRange;
    }

    public Comparator comparator() {
        return this.comparator;
    }

    public boolean contains(Object object) {
        boolean bl2;
        boolean bl3 = this.tooLow(object);
        if (!bl3 && !(bl2 = this.tooHigh(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof GeneralRange;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            boolean bl5;
            object = (GeneralRange)object;
            Object object2 = this.comparator;
            Object object3 = ((GeneralRange)object).comparator;
            bl2 = object2.equals(object3);
            if (bl2 && (bl2 = this.hasLowerBound) == (bl5 = ((GeneralRange)object).hasLowerBound) && (bl2 = this.hasUpperBound) == (bl5 = ((GeneralRange)object).hasUpperBound) && (bl2 = ((Enum)(object2 = this.getLowerBoundType())).equals(object3 = ((GeneralRange)object).getLowerBoundType())) && (bl2 = ((Enum)(object2 = this.getUpperBoundType())).equals(object3 = ((GeneralRange)object).getUpperBoundType())) && (bl2 = Objects.equal(object2 = this.getLowerEndpoint(), object3 = ((GeneralRange)object).getLowerEndpoint())) && (bl4 = Objects.equal(object2 = this.getUpperEndpoint(), object = ((GeneralRange)object).getUpperEndpoint()))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    public Object getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    public Object getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        Object object = this.comparator;
        object = this.getLowerEndpoint();
        Object[] objectArray = new Object[]{object, object, object = this.getLowerBoundType(), object = this.getUpperEndpoint(), object = this.getUpperBoundType()};
        return Objects.hashCode(objectArray);
    }

    public GeneralRange intersect(GeneralRange object) {
        Object object2;
        int n10;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Preconditions.checkNotNull(object);
        Object object7 = this.comparator;
        Object object8 = ((GeneralRange)object).comparator;
        Preconditions.checkArgument(object7.equals(object8));
        boolean bl2 = this.hasLowerBound;
        object8 = this.getLowerEndpoint();
        BoundType boundType = this.getLowerBoundType();
        boolean n11 = this.hasLowerBound();
        if (!n11) {
            bl2 = ((GeneralRange)object).hasLowerBound;
            object8 = ((GeneralRange)object).getLowerEndpoint();
            boundType = ((GeneralRange)object).getLowerBoundType();
        } else {
            Object object9;
            int n12;
            boolean bl3 = ((GeneralRange)object).hasLowerBound();
            if (bl3 && ((n12 = (object6 = this.comparator).compare(object5 = this.getLowerEndpoint(), object9 = ((GeneralRange)object).getLowerEndpoint())) < 0 || n12 == 0 && (object6 = ((GeneralRange)object).getLowerBoundType()) == (object5 = BoundType.OPEN))) {
                object8 = ((GeneralRange)object).getLowerEndpoint();
                boundType = ((GeneralRange)object).getLowerBoundType();
            }
        }
        boolean bl4 = bl2;
        bl2 = this.hasUpperBound;
        object6 = this.getUpperEndpoint();
        object5 = this.getUpperBoundType();
        boolean bl5 = this.hasUpperBound();
        if (!bl5) {
            bl2 = ((GeneralRange)object).hasUpperBound;
            object6 = ((GeneralRange)object).getUpperEndpoint();
            object5 = ((GeneralRange)object).getUpperBoundType();
        } else {
            Object object10;
            int n13;
            boolean bl6 = ((GeneralRange)object).hasUpperBound();
            if (bl6 && ((n13 = (object4 = this.comparator).compare(object3 = this.getUpperEndpoint(), object10 = ((GeneralRange)object).getUpperEndpoint())) > 0 || n13 == 0 && (object4 = ((GeneralRange)object).getUpperBoundType()) == (object3 = BoundType.OPEN))) {
                object6 = ((GeneralRange)object).getUpperEndpoint();
                object5 = ((GeneralRange)object).getUpperBoundType();
            }
        }
        boolean bl7 = bl2;
        Object object11 = object6;
        if (bl4 && bl2 && ((n10 = (object = this.comparator).compare(object8, object6)) > 0 || n10 == 0 && boundType == (object = BoundType.OPEN) && object5 == object)) {
            object = BoundType.OPEN;
            object7 = BoundType.CLOSED;
            object3 = object;
            object2 = object7;
            object4 = object11;
        } else {
            object4 = object8;
            object3 = boundType;
            object2 = object5;
        }
        object5 = this.comparator;
        object6 = object;
        object = new GeneralRange((Comparator)object5, bl4, object4, (BoundType)((Object)object3), bl7, object11, (BoundType)((Object)object2));
        return object;
    }

    public boolean isEmpty() {
        Object object;
        boolean bl2 = this.hasUpperBound();
        if (bl2 && (bl2 = this.tooLow(object = this.getUpperEndpoint())) || (bl2 = this.hasLowerBound()) && (bl2 = this.tooHigh(object = this.getLowerEndpoint()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public GeneralRange reverse() {
        GeneralRange generalRange = this.reverse;
        if (generalRange == null) {
            Ordering ordering = Ordering.from(this.comparator).reverse();
            boolean bl2 = this.hasUpperBound;
            Object object = this.getUpperEndpoint();
            BoundType boundType = this.getUpperBoundType();
            boolean bl3 = this.hasLowerBound;
            Object object2 = this.getLowerEndpoint();
            BoundType boundType2 = this.getLowerBoundType();
            generalRange = new GeneralRange(ordering, bl2, object, boundType, bl3, object2, boundType2);
            generalRange.reverse = this;
            this.reverse = generalRange;
        }
        return generalRange;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.comparator;
        stringBuilder.append(object);
        stringBuilder.append(":");
        object = this.lowerBoundType;
        BoundType boundType = BoundType.CLOSED;
        char c10 = object == boundType ? (char)'[' : '(';
        stringBuilder.append(c10);
        c10 = (char)(this.hasLowerBound ? 1 : 0);
        object = c10 != '\u0000' ? this.lowerEndpoint : "-\u221e";
        stringBuilder.append(object);
        stringBuilder.append(',');
        c10 = (char)(this.hasUpperBound ? 1 : 0);
        object = c10 != '\u0000' ? this.upperEndpoint : "\u221e";
        stringBuilder.append(object);
        object = this.upperBoundType;
        c10 = object == boundType ? (char)']' : ')';
        stringBuilder.append(c10);
        return stringBuilder.toString();
    }

    public boolean tooHigh(Object object) {
        int n10;
        int n11 = this.hasUpperBound();
        int n12 = 0;
        if (n11 == 0) {
            return false;
        }
        Object object2 = this.getUpperEndpoint();
        Comparator comparator = this.comparator;
        int n13 = comparator.compare(object, object2);
        n11 = 1;
        if (n13 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            comparator = null;
        }
        if (n13 == 0) {
            n13 = n11;
        } else {
            n13 = 0;
            object = null;
        }
        BoundType boundType = this.getUpperBoundType();
        BoundType boundType2 = BoundType.OPEN;
        if (boundType == boundType2) {
            n12 = n11;
        }
        return (n13 & n12 | n10) != 0;
    }

    public boolean tooLow(Object object) {
        int n10;
        int n11 = this.hasLowerBound();
        int n12 = 0;
        if (n11 == 0) {
            return false;
        }
        Object object2 = this.getLowerEndpoint();
        Comparator comparator = this.comparator;
        int n13 = comparator.compare(object, object2);
        n11 = 1;
        if (n13 < 0) {
            n10 = n11;
        } else {
            n10 = 0;
            comparator = null;
        }
        if (n13 == 0) {
            n13 = n11;
        } else {
            n13 = 0;
            object = null;
        }
        BoundType boundType = this.getLowerBoundType();
        BoundType boundType2 = BoundType.OPEN;
        if (boundType == boundType2) {
            n12 = n11;
        }
        return (n13 & n12 | n10) != 0;
    }
}

