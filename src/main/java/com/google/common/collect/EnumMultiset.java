/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.EnumMultiset$1;
import com.google.common.collect.EnumMultiset$2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class EnumMultiset
extends AbstractMultiset
implements Serializable {
    private static final long serialVersionUID;
    private transient int[] counts;
    private transient int distinctElements;
    private transient Enum[] enumConstants;
    private transient long size;
    private transient Class type;

    private EnumMultiset(Class objectArray) {
        this.type = objectArray;
        Preconditions.checkArgument(objectArray.isEnum());
        objectArray = (Enum[])objectArray.getEnumConstants();
        this.enumConstants = objectArray;
        objectArray = new int[objectArray.length];
        this.counts = (int[])objectArray;
    }

    public static /* synthetic */ Enum[] access$000(EnumMultiset enumMultiset) {
        return enumMultiset.enumConstants;
    }

    public static /* synthetic */ int[] access$100(EnumMultiset enumMultiset) {
        return enumMultiset.counts;
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int n10;
        int n11 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = n10 = n11 + -1;
        return n11;
    }

    public static /* synthetic */ long access$300(EnumMultiset enumMultiset) {
        return enumMultiset.size;
    }

    public static /* synthetic */ long access$302(EnumMultiset enumMultiset, long l10) {
        enumMultiset.size = l10;
        return l10;
    }

    public static EnumMultiset create(Class clazz) {
        EnumMultiset enumMultiset = new EnumMultiset(clazz);
        return enumMultiset;
    }

    public static EnumMultiset create(Iterable iterable) {
        Object object = iterable.iterator();
        Preconditions.checkArgument(object.hasNext(), "EnumMultiset constructor passed empty Iterable");
        object = ((Enum)object.next()).getDeclaringClass();
        EnumMultiset enumMultiset = new EnumMultiset((Class)object);
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    public static EnumMultiset create(Iterable iterable, Class serializable) {
        serializable = EnumMultiset.create(serializable);
        Iterables.addAll((Collection)((Object)serializable), iterable);
        return serializable;
    }

    private boolean isActuallyE(Object object) {
        Enum enum_;
        Enum[] enumArray;
        int n10;
        int n11 = object instanceof Enum;
        boolean bl2 = false;
        if (n11 != 0 && (n11 = ((Enum)(object = (Enum)object)).ordinal()) < (n10 = (enumArray = this.enumConstants).length) && (enum_ = enumArray[n11]) == object) {
            bl2 = true;
        }
        return bl2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Object[] objectArray = (Enum[])objectInputStream.readObject();
        this.type = objectArray;
        objectArray = (Enum[])objectArray.getEnumConstants();
        this.enumConstants = objectArray;
        objectArray = new int[objectArray.length];
        this.counts = (int[])objectArray;
        Serialization.populateMultiset(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Class clazz = this.type;
        objectOutputStream.writeObject(clazz);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    public int add(Enum enum_, int n10) {
        long l10;
        int n11;
        int[] nArray;
        this.checkIsE(enum_);
        Object object = "occurrences";
        CollectPreconditions.checkNonnegative(n10, (String)object);
        if (n10 == 0) {
            return this.count(enum_);
        }
        int n12 = enum_.ordinal();
        object = this.counts;
        Object object2 = object[n12];
        long l11 = (long)object2;
        long l12 = n10;
        long l13 = Integer.MAX_VALUE;
        long l14 = (l11 += l12) - l13;
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        int n13 = 1;
        if (n10 <= 0) {
            n10 = n13;
        } else {
            n10 = 0;
            nArray = null;
        }
        String string2 = "too many occurrences: %s";
        Preconditions.checkArgument(n10 != 0, string2, l11);
        nArray = this.counts;
        nArray[n12] = n11 = (int)l11;
        if (object2 == false) {
            this.distinctElements = n12 = this.distinctElements + n13;
        }
        this.size = l10 = this.size + l12;
        return (int)object2;
    }

    public void checkIsE(Object object) {
        Preconditions.checkNotNull(object);
        boolean bl2 = this.isActuallyE(object);
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected an ");
        Class clazz = this.type;
        stringBuilder.append(clazz);
        stringBuilder.append(" but got ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        ClassCastException classCastException = new ClassCastException((String)object);
        throw classCastException;
    }

    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    public int count(Object object) {
        boolean bl2 = this.isActuallyE(object);
        if (!bl2) {
            return 0;
        }
        object = (Enum)object;
        int[] nArray = this.counts;
        int n10 = ((Enum)object).ordinal();
        return nArray[n10];
    }

    public int distinctElements() {
        return this.distinctElements;
    }

    public Iterator elementIterator() {
        EnumMultiset$1 enumMultiset$1 = new EnumMultiset$1(this);
        return enumMultiset$1;
    }

    public Iterator entryIterator() {
        EnumMultiset$2 enumMultiset$2 = new EnumMultiset$2(this);
        return enumMultiset$2;
    }

    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }

    public int remove(Object object, int n10) {
        boolean bl2 = this.isActuallyE(object);
        Object object2 = false;
        if (!bl2) {
            return 0;
        }
        Object object3 = object;
        object3 = (Enum)object;
        String string2 = "occurrences";
        CollectPreconditions.checkNonnegative(n10, string2);
        if (n10 == 0) {
            return this.count(object);
        }
        object3 = this.counts;
        int n11 = ((Enum)object3).ordinal();
        Object object4 = object3[n11];
        if (object4 == false) {
            return 0;
        }
        if (object4 <= n10) {
            object3[n11] = false;
            this.distinctElements = n11 = this.distinctElements + -1;
            long l10 = this.size;
            long l11 = (long)object4;
            this.size = l10 -= l11;
        } else {
            object2 = object4 - n10;
            object3[n11] = object2;
            long l12 = this.size;
            long l13 = n10;
            this.size = l12 -= l13;
        }
        return (int)object4;
    }

    public int setCount(Enum enum_, int n10) {
        this.checkIsE(enum_);
        CollectPreconditions.checkNonnegative(n10, "count");
        int n11 = enum_.ordinal();
        int[] nArray = this.counts;
        int n12 = nArray[n11];
        nArray[n11] = n10;
        long l10 = this.size;
        n11 = n10 - n12;
        long l11 = n11;
        this.size = l10 += l11;
        if (n12 == 0 && n10 > 0) {
            this.distinctElements = n11 = this.distinctElements + 1;
        } else if (n12 > 0 && n10 == 0) {
            this.distinctElements = n11 = this.distinctElements + -1;
        }
        return n12;
    }

    public int size() {
        return Ints.saturatedCast(this.size);
    }
}

