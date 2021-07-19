/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.ImmutableDoubleArray;
import com.google.common.primitives.ImmutableDoubleArray$1;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class ImmutableDoubleArray$AsList
extends AbstractList
implements RandomAccess,
Serializable {
    private final ImmutableDoubleArray parent;

    private ImmutableDoubleArray$AsList(ImmutableDoubleArray immutableDoubleArray) {
        this.parent = immutableDoubleArray;
    }

    public /* synthetic */ ImmutableDoubleArray$AsList(ImmutableDoubleArray immutableDoubleArray, ImmutableDoubleArray$1 immutableDoubleArray$1) {
        this(immutableDoubleArray);
    }

    public boolean contains(Object object) {
        int n10 = this.indexOf(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean equals(Object iterator2) {
        int n10;
        int n11 = iterator2 instanceof ImmutableDoubleArray$AsList;
        if (n11 != 0) {
            iterator2 = (ImmutableDoubleArray$AsList)((Object)iterator2);
            ImmutableDoubleArray immutableDoubleArray = this.parent;
            iterator2 = ((ImmutableDoubleArray$AsList)iterator2).parent;
            return immutableDoubleArray.equals(iterator2);
        }
        n11 = iterator2 instanceof List;
        if (n11 == 0) {
            return false;
        }
        iterator2 = (List)((Object)iterator2);
        n11 = this.size();
        if (n11 != (n10 = iterator2.size())) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = this.parent;
        n11 = ImmutableDoubleArray.access$100(immutableDoubleArray);
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object = iterator2.next();
            boolean bl2 = object instanceof Double;
            if (bl2) {
                double[] dArray = ImmutableDoubleArray.access$000(this.parent);
                int n12 = n11 + 1;
                double d10 = dArray[n11];
                double d11 = (Double)(object = (Double)object);
                if ((n11 = (int)(ImmutableDoubleArray.access$500(d10, d11) ? 1 : 0)) != 0) {
                    n11 = n12;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public Double get(int n10) {
        return this.parent.get(n10);
    }

    public int hashCode() {
        return this.parent.hashCode();
    }

    public int indexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Double;
        if (bl2) {
            ImmutableDoubleArray immutableDoubleArray = this.parent;
            object = (Double)object;
            double d10 = (Double)object;
            n10 = immutableDoubleArray.indexOf(d10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int lastIndexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Double;
        if (bl2) {
            ImmutableDoubleArray immutableDoubleArray = this.parent;
            object = (Double)object;
            double d10 = (Double)object;
            n10 = immutableDoubleArray.lastIndexOf(d10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int size() {
        return this.parent.length();
    }

    public List subList(int n10, int n11) {
        return this.parent.subArray(n10, n11).asList();
    }

    public String toString() {
        return this.parent.toString();
    }
}

