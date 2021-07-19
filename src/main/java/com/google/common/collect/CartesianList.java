/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList$1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public final class CartesianList
extends AbstractList
implements RandomAccess {
    private final transient ImmutableList axes;
    private final transient int[] axesSizeProduct;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CartesianList(ImmutableList serializable) {
        this.axes = serializable;
        int n10 = ((AbstractCollection)((Object)serializable)).size();
        int n11 = 1;
        int[] nArray = new int[n10 += n11];
        int n12 = ((AbstractCollection)((Object)serializable)).size();
        nArray[n12] = n11;
        try {
            n12 = ((AbstractCollection)((Object)serializable)).size() - n11;
        }
        catch (ArithmeticException arithmeticException) {
            super("Cartesian product too large; must have size at most Integer.MAX_VALUE");
            throw serializable;
        }
        while (true) {
            if (n12 < 0) {
                this.axesSizeProduct = nArray;
                return;
            }
            n11 = n12 + 1;
            {
                n11 = nArray[n11];
                Object object = serializable.get(n12);
                object = (List)object;
                int n13 = object.size();
                nArray[n12] = n11 = IntMath.checkedMultiply(n11, n13);
                n12 += -1;
                continue;
            }
            break;
        }
    }

    public static /* synthetic */ ImmutableList access$000(CartesianList cartesianList) {
        return cartesianList.axes;
    }

    public static /* synthetic */ int access$100(CartesianList cartesianList, int n10, int n11) {
        return cartesianList.getAxisIndexForProductIndex(n10, n11);
    }

    public static List create(List object) {
        int n10 = object.size();
        Object object2 = new ImmutableList$Builder(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            ImmutableList immutableList = ImmutableList.copyOf((Collection)((List)object.next()));
            boolean bl2 = immutableList.isEmpty();
            if (bl2) {
                return ImmutableList.of();
            }
            ((ImmutableList$Builder)object2).add(immutableList);
        }
        object2 = ((ImmutableList$Builder)object2).build();
        object = new CartesianList((ImmutableList)object2);
        return object;
    }

    private int getAxisIndexForProductIndex(int n10, int n11) {
        int[] nArray = this.axesSizeProduct;
        int n12 = n11 + 1;
        int n13 = nArray[n12];
        n11 = ((List)this.axes.get(n11)).size();
        return (n10 /= n13) % n11;
    }

    public boolean contains(Object object) {
        int n10;
        int n11 = this.indexOf(object);
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public ImmutableList get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        CartesianList$1 cartesianList$1 = new CartesianList$1(this, n10);
        return cartesianList$1;
    }

    public int indexOf(Object listIterator) {
        ImmutableList immutableList;
        Object object;
        int n10 = listIterator instanceof List;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        n10 = (listIterator = (List)((Object)listIterator)).size();
        if (n10 != (object = (immutableList = this.axes).size())) {
            return n11;
        }
        listIterator = listIterator.listIterator();
        n10 = 0;
        while ((object = (Object)listIterator.hasNext()) != 0) {
            Object object2;
            object = listIterator.nextIndex();
            List list = (List)this.axes.get((int)object);
            int n12 = list.indexOf(object2 = listIterator.next());
            if (n12 == n11) {
                return n11;
            }
            object2 = this.axesSizeProduct;
            ++object;
            object = object2[object];
            n10 += (n12 *= object);
        }
        return n10;
    }

    public int size() {
        return this.axesSizeProduct[0];
    }
}

