/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.ImmutableLongArray;
import com.google.common.primitives.ImmutableLongArray$1;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class ImmutableLongArray$AsList
extends AbstractList
implements RandomAccess,
Serializable {
    private final ImmutableLongArray parent;

    private ImmutableLongArray$AsList(ImmutableLongArray immutableLongArray) {
        this.parent = immutableLongArray;
    }

    public /* synthetic */ ImmutableLongArray$AsList(ImmutableLongArray immutableLongArray, ImmutableLongArray$1 immutableLongArray$1) {
        this(immutableLongArray);
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
        int n11 = iterator2 instanceof ImmutableLongArray$AsList;
        if (n11 != 0) {
            iterator2 = (ImmutableLongArray$AsList)((Object)iterator2);
            ImmutableLongArray immutableLongArray = this.parent;
            iterator2 = ((ImmutableLongArray$AsList)iterator2).parent;
            return immutableLongArray.equals(iterator2);
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
        ImmutableLongArray immutableLongArray = this.parent;
        n11 = ImmutableLongArray.access$100(immutableLongArray);
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object = iterator2.next();
            boolean bl2 = object instanceof Long;
            if (bl2) {
                long[] lArray = ImmutableLongArray.access$000(this.parent);
                int n12 = n11 + 1;
                long l10 = lArray[n11];
                long l11 = (Long)(object = (Long)object);
                long l12 = l10 - l11;
                if ((n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
                    n11 = n12;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public Long get(int n10) {
        return this.parent.get(n10);
    }

    public int hashCode() {
        return this.parent.hashCode();
    }

    public int indexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Long;
        if (bl2) {
            ImmutableLongArray immutableLongArray = this.parent;
            object = (Long)object;
            long l10 = (Long)object;
            n10 = immutableLongArray.indexOf(l10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int lastIndexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Long;
        if (bl2) {
            ImmutableLongArray immutableLongArray = this.parent;
            object = (Long)object;
            long l10 = (Long)object;
            n10 = immutableLongArray.lastIndexOf(l10);
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

