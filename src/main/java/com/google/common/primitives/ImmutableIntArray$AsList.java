/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.ImmutableIntArray;
import com.google.common.primitives.ImmutableIntArray$1;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class ImmutableIntArray$AsList
extends AbstractList
implements RandomAccess,
Serializable {
    private final ImmutableIntArray parent;

    private ImmutableIntArray$AsList(ImmutableIntArray immutableIntArray) {
        this.parent = immutableIntArray;
    }

    public /* synthetic */ ImmutableIntArray$AsList(ImmutableIntArray immutableIntArray, ImmutableIntArray$1 immutableIntArray$1) {
        this(immutableIntArray);
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
        int n11 = iterator2 instanceof ImmutableIntArray$AsList;
        if (n11 != 0) {
            iterator2 = (ImmutableIntArray$AsList)((Object)iterator2);
            ImmutableIntArray immutableIntArray = this.parent;
            iterator2 = ((ImmutableIntArray$AsList)iterator2).parent;
            return immutableIntArray.equals(iterator2);
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
        ImmutableIntArray immutableIntArray = this.parent;
        n11 = ImmutableIntArray.access$100(immutableIntArray);
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object = iterator2.next();
            boolean bl2 = object instanceof Integer;
            if (bl2) {
                int[] nArray = ImmutableIntArray.access$000(this.parent);
                int n12 = n11 + 1;
                n10 = (Integer)(object = (Integer)object);
                if ((n11 = nArray[n11]) == n10) {
                    n11 = n12;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public Integer get(int n10) {
        return this.parent.get(n10);
    }

    public int hashCode() {
        return this.parent.hashCode();
    }

    public int indexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            ImmutableIntArray immutableIntArray = this.parent;
            object = (Integer)object;
            n10 = (Integer)object;
            n10 = immutableIntArray.indexOf(n10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int lastIndexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            ImmutableIntArray immutableIntArray = this.parent;
            object = (Integer)object;
            n10 = (Integer)object;
            n10 = immutableIntArray.lastIndexOf(n10);
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

