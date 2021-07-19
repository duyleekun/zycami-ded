/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.graph.ElementOrder$1;
import com.google.common.graph.ElementOrder$Type;
import java.util.Comparator;
import java.util.Map;

public final class ElementOrder {
    private final Comparator comparator;
    private final ElementOrder$Type type;

    private ElementOrder(ElementOrder$Type elementOrder$Type, Comparator comparator) {
        boolean bl2;
        boolean bl3;
        ElementOrder$Type elementOrder$Type2;
        this.type = elementOrder$Type2 = (ElementOrder$Type)((Object)Preconditions.checkNotNull((Object)elementOrder$Type));
        this.comparator = comparator;
        elementOrder$Type2 = ElementOrder$Type.SORTED;
        boolean bl4 = true;
        if (elementOrder$Type == elementOrder$Type2) {
            bl3 = bl4;
        } else {
            bl3 = false;
            elementOrder$Type = null;
        }
        if (comparator != null) {
            bl2 = bl4;
        } else {
            bl2 = false;
            comparator = null;
        }
        if (bl3 != bl2) {
            bl4 = false;
        }
        Preconditions.checkState(bl4);
    }

    public static ElementOrder insertion() {
        ElementOrder$Type elementOrder$Type = ElementOrder$Type.INSERTION;
        ElementOrder elementOrder = new ElementOrder(elementOrder$Type, null);
        return elementOrder;
    }

    public static ElementOrder natural() {
        ElementOrder$Type elementOrder$Type = ElementOrder$Type.SORTED;
        Ordering ordering = Ordering.natural();
        ElementOrder elementOrder = new ElementOrder(elementOrder$Type, ordering);
        return elementOrder;
    }

    public static ElementOrder sorted(Comparator comparator) {
        ElementOrder$Type elementOrder$Type = ElementOrder$Type.SORTED;
        ElementOrder elementOrder = new ElementOrder(elementOrder$Type, comparator);
        return elementOrder;
    }

    public static ElementOrder stable() {
        ElementOrder$Type elementOrder$Type = ElementOrder$Type.STABLE;
        ElementOrder elementOrder = new ElementOrder(elementOrder$Type, null);
        return elementOrder;
    }

    public static ElementOrder unordered() {
        ElementOrder$Type elementOrder$Type = ElementOrder$Type.UNORDERED;
        ElementOrder elementOrder = new ElementOrder(elementOrder$Type, null);
        return elementOrder;
    }

    public ElementOrder cast() {
        return this;
    }

    public Comparator comparator() {
        Object object = this.comparator;
        if (object != null) {
            return object;
        }
        object = new UnsupportedOperationException("This ordering does not define a comparator.");
        throw object;
    }

    public Map createMap(int n10) {
        int[] nArray = ElementOrder$1.$SwitchMap$com$google$common$graph$ElementOrder$Type;
        ElementOrder$Type elementOrder$Type = this.type;
        int n11 = elementOrder$Type.ordinal();
        int n12 = nArray[n11];
        if (n12 != (n11 = 1)) {
            n11 = 2;
            if (n12 != n11 && n12 != (n11 = 3)) {
                n10 = 4;
                if (n12 == n10) {
                    return Maps.newTreeMap(this.comparator());
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            return Maps.newLinkedHashMapWithExpectedSize(n10);
        }
        return Maps.newHashMapWithExpectedSize(n10);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof ElementOrder;
        if (!bl4) {
            return false;
        }
        object = (ElementOrder)object;
        Object object2 = this.type;
        ElementOrder$Type elementOrder$Type = ((ElementOrder)object).type;
        if (object2 != elementOrder$Type || !(bl2 = Objects.equal(object2 = this.comparator, object = ((ElementOrder)object).comparator))) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Object object = this.type;
        objectArray[0] = object;
        object = this.comparator;
        objectArray[1] = object;
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        Object object = this.type;
        String string2 = "type";
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add(string2, object);
        object = this.comparator;
        if (object != null) {
            string2 = "comparator";
            moreObjects$ToStringHelper.add(string2, object);
        }
        return moreObjects$ToStringHelper.toString();
    }

    public ElementOrder$Type type() {
        return this.type;
    }
}

