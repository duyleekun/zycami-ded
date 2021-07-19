/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSet$SerializedForm;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.SingletonImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public abstract class ImmutableSet
extends ImmutableCollection
implements Set {
    private static final int CUTOFF = 0x2CCCCCCC;
    private static final double DESIRED_LOAD_FACTOR = 0.7;
    public static final int MAX_TABLE_SIZE = 0x40000000;
    private transient ImmutableList asList;

    public static /* synthetic */ boolean access$000(int n10, int n11) {
        return ImmutableSet.shouldTrim(n10, n11);
    }

    public static /* synthetic */ ImmutableSet access$100(int n10, Object[] objectArray) {
        return ImmutableSet.construct(n10, objectArray);
    }

    public static ImmutableSet$Builder builder() {
        ImmutableSet$Builder immutableSet$Builder = new ImmutableSet$Builder();
        return immutableSet$Builder;
    }

    public static ImmutableSet$Builder builderWithExpectedSize(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedSize");
        ImmutableSet$Builder immutableSet$Builder = new ImmutableSet$Builder(n10);
        return immutableSet$Builder;
    }

    public static int chooseTableSize(int n10) {
        n10 = Math.max(n10, 2);
        int n11 = 1;
        int n12 = 0x2CCCCCCC;
        if (n10 < n12) {
            double d10;
            double d11;
            double d12;
            n12 = Integer.highestOneBit(n10 + -1);
            n11 = n12 << 1;
            while ((n12 = (int)((d12 = (d11 = (double)n11 * 0.7) - (d10 = (double)n10)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1))) < 0) {
                n11 <<= 1;
            }
            return n11;
        }
        n12 = 0x40000000;
        if (n10 >= n12) {
            n11 = 0;
        }
        Preconditions.checkArgument(n11 != 0, "collection too large");
        return n12;
    }

    private static ImmutableSet construct(int n10, Object ... objectArray) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                Object[] objectArray2;
                int n12;
                int n13 = ImmutableSet.chooseTableSize(n10);
                Object[] objectArray3 = new Object[n13];
                int n14 = n13 + -1;
                int n15 = 0;
                int n16 = 0;
                block0: for (n12 = 0; n12 < n10; ++n12) {
                    objectArray2 = ObjectArrays.checkElementNotNull(objectArray[n12], n12);
                    int n17 = objectArray2.hashCode();
                    int n18 = Hashing.smear(n17);
                    while (true) {
                        int n19;
                        Object object;
                        if ((object = objectArray3[n19 = n18 & n14]) == null) {
                            n18 = n16 + 1;
                            objectArray[n16] = objectArray2;
                            objectArray3[n19] = objectArray2;
                            n15 += n17;
                            n16 = n18;
                            continue block0;
                        }
                        n19 = (int)(object.equals(objectArray2) ? 1 : 0);
                        if (n19 != 0) {
                            continue block0;
                        }
                        ++n18;
                    }
                }
                n12 = 0;
                Arrays.fill(objectArray, n16, n10, null);
                if (n16 == n11) {
                    Object object = objectArray[0];
                    objectArray = new SingletonImmutableSet(object, n15);
                    return objectArray;
                }
                n10 = ImmutableSet.chooseTableSize(n16);
                if (n10 < (n13 /= 2)) {
                    return ImmutableSet.construct(n16, objectArray);
                }
                n10 = objectArray.length;
                if ((n10 = (int)(ImmutableSet.shouldTrim(n16, n10) ? 1 : 0)) != 0) {
                    objectArray = Arrays.copyOf(objectArray, n16);
                }
                objectArray2 = objectArray;
                RegularImmutableSet regularImmutableSet = new RegularImmutableSet(objectArray, n15, objectArray3, n14, n16);
                return regularImmutableSet;
            }
            return ImmutableSet.of(objectArray[0]);
        }
        return ImmutableSet.of();
    }

    public static ImmutableSet copyOf(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        iterable = bl2 ? ImmutableSet.copyOf((Collection)iterable) : ImmutableSet.copyOf(iterable.iterator());
        return iterable;
    }

    public static ImmutableSet copyOf(Collection objectArray) {
        boolean bl2 = objectArray instanceof ImmutableSet;
        if (bl2 && !(bl2 = objectArray instanceof SortedSet)) {
            Object object = objectArray;
            object = (ImmutableSet)objectArray;
            boolean bl3 = ((ImmutableCollection)object).isPartialView();
            if (!bl3) {
                return object;
            }
        }
        objectArray = objectArray.toArray();
        return ImmutableSet.construct(objectArray.length, objectArray);
    }

    public static ImmutableSet copyOf(Iterator iterator2) {
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return ImmutableSet.of();
        }
        Object e10 = iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            return ImmutableSet.of(e10);
        }
        ImmutableSet$Builder immutableSet$Builder = new ImmutableSet$Builder();
        return ((ImmutableSet$Builder)((ImmutableSet$Builder)immutableSet$Builder.add(e10)).addAll(iterator2)).build();
    }

    public static ImmutableSet copyOf(Object[] objectArray) {
        int n10 = objectArray.length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n10 = objectArray.length;
                objectArray = (Object[])objectArray.clone();
                return ImmutableSet.construct(n10, objectArray);
            }
            return ImmutableSet.of(objectArray[0]);
        }
        return ImmutableSet.of();
    }

    public static ImmutableSet of() {
        return RegularImmutableSet.EMPTY;
    }

    public static ImmutableSet of(Object object) {
        SingletonImmutableSet singletonImmutableSet = new SingletonImmutableSet(object);
        return singletonImmutableSet;
    }

    public static ImmutableSet of(Object object, Object object2) {
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        return ImmutableSet.construct(n10, objectArray);
    }

    public static ImmutableSet of(Object object, Object object2, Object object3) {
        int n10 = 3;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        return ImmutableSet.construct(n10, objectArray);
    }

    public static ImmutableSet of(Object object, Object object2, Object object3, Object object4) {
        int n10 = 4;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        return ImmutableSet.construct(n10, objectArray);
    }

    public static ImmutableSet of(Object object, Object object2, Object object3, Object object4, Object object5) {
        int n10 = 5;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        objectArray[3] = object4;
        objectArray[4] = object5;
        return ImmutableSet.construct(n10, objectArray);
    }

    public static ImmutableSet of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object ... objectArray) {
        int n10 = objectArray.length;
        int n11 = 1;
        int n12 = 0x7FFFFFF9;
        n10 = n10 <= n12 ? n11 : 0;
        Preconditions.checkArgument(n10 != 0, "the total number of elements must fit in an int");
        n10 = objectArray.length;
        n12 = 6;
        Object[] objectArray2 = new Object[n10 += n12];
        objectArray2[0] = object;
        objectArray2[n11] = object2;
        objectArray2[2] = object3;
        objectArray2[3] = object4;
        objectArray2[4] = object5;
        objectArray2[5] = object6;
        int n13 = objectArray.length;
        System.arraycopy(objectArray, 0, objectArray2, n12, n13);
        return ImmutableSet.construct(n10, objectArray2);
    }

    private static boolean shouldTrim(int n10, int n11) {
        int n12 = n11 >> 1;
        n10 = n10 < (n12 += (n11 >>= 2)) ? 1 : 0;
        return n10 != 0;
    }

    public ImmutableList asList() {
        ImmutableList immutableList = this.asList;
        if (immutableList == null) {
            this.asList = immutableList = this.createAsList();
        }
        return immutableList;
    }

    public ImmutableList createAsList() {
        return ImmutableList.asImmutableList(this.toArray());
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (object == this) {
            return true;
        }
        boolean n10 = object instanceof ImmutableSet;
        if (n10 && (bl2 = this.isHashCodeFast())) {
            int n11;
            int n12;
            Object object2 = object;
            object2 = (ImmutableSet)object;
            boolean bl3 = ((ImmutableSet)object2).isHashCodeFast();
            if (bl3 && (n12 = this.hashCode()) != (n11 = object.hashCode())) {
                return false;
            }
        }
        return Sets.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract UnmodifiableIterator iterator();

    public Object writeReplace() {
        Object[] objectArray = this.toArray();
        ImmutableSet$SerializedForm immutableSet$SerializedForm = new ImmutableSet$SerializedForm(objectArray);
        return immutableSet$SerializedForm;
    }
}

