/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.EmptyImmutableSetMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$FieldSettersHolder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSetMultimap$Builder;
import com.google.common.collect.ImmutableSetMultimap$EntrySet;
import com.google.common.collect.ImmutableSetMultimap$SetFieldSettersHolder;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.Serialization$FieldSetter;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class ImmutableSetMultimap
extends ImmutableMultimap
implements SetMultimap {
    private static final long serialVersionUID;
    private final transient ImmutableSet emptySet;
    private transient ImmutableSet entries;
    private transient ImmutableSetMultimap inverse;

    public ImmutableSetMultimap(ImmutableMap serializable, int n10, Comparator comparator) {
        super((ImmutableMap)serializable, n10);
        serializable = ImmutableSetMultimap.emptySet(comparator);
        this.emptySet = serializable;
    }

    public static ImmutableSetMultimap$Builder builder() {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = new ImmutableSetMultimap$Builder();
        return immutableSetMultimap$Builder;
    }

    public static ImmutableSetMultimap copyOf(Multimap multimap) {
        return ImmutableSetMultimap.copyOf(multimap, null);
    }

    private static ImmutableSetMultimap copyOf(Multimap multimap, Comparator comparator) {
        Preconditions.checkNotNull(multimap);
        boolean bl2 = multimap.isEmpty();
        if (bl2 && comparator == null) {
            return ImmutableSetMultimap.of();
        }
        bl2 = multimap instanceof ImmutableSetMultimap;
        if (bl2) {
            Multimap multimap2 = multimap;
            multimap2 = (ImmutableSetMultimap)multimap;
            boolean bl3 = ((ImmutableMultimap)multimap2).isPartialView();
            if (!bl3) {
                return multimap2;
            }
        }
        return ImmutableSetMultimap.fromMapEntries(multimap.asMap().entrySet(), comparator);
    }

    public static ImmutableSetMultimap copyOf(Iterable iterable) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = new ImmutableSetMultimap$Builder();
        return ((ImmutableSetMultimap$Builder)immutableSetMultimap$Builder.putAll(iterable)).build();
    }

    private static ImmutableSet emptySet(Comparator object) {
        object = object == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet((Comparator)object);
        return object;
    }

    public static ImmutableSetMultimap fromMapEntries(Collection object, Comparator comparator) {
        int n10;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return ImmutableSetMultimap.of();
        }
        int n11 = object.size();
        Object object2 = new ImmutableMap$Builder(n11);
        n11 = 0;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object3 = (Map.Entry)object.next();
            Object k10 = object3.getKey();
            object3 = (Collection)object3.getValue();
            boolean bl3 = ((AbstractCollection)(object3 = ImmutableSetMultimap.valueSet(comparator, (Collection)object3))).isEmpty();
            if (bl3) continue;
            ((ImmutableMap$Builder)object2).put(k10, object3);
            n10 = ((AbstractCollection)object3).size();
            n11 += n10;
        }
        object2 = ((ImmutableMap$Builder)object2).build();
        object = new ImmutableSetMultimap((ImmutableMap)object2, n11, comparator);
        return object;
    }

    private ImmutableSetMultimap invert() {
        boolean bl2;
        Object object = ImmutableSetMultimap.builder();
        UnmodifiableIterator unmodifiableIterator = ((ImmutableSet)this.entries()).iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)unmodifiableIterator.next();
            Object v10 = entry.getValue();
            entry = entry.getKey();
            ((ImmutableSetMultimap$Builder)object).put(v10, entry);
        }
        object = ((ImmutableSetMultimap$Builder)object).build();
        ((ImmutableSetMultimap)object).inverse = this;
        return object;
    }

    public static ImmutableSetMultimap of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static ImmutableSetMultimap of(Object object, Object object2) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        immutableSetMultimap$Builder.put(object5, object6);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        immutableSetMultimap$Builder.put(object5, object6);
        immutableSetMultimap$Builder.put(object7, object8);
        return immutableSetMultimap$Builder.build();
    }

    public static ImmutableSetMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        immutableSetMultimap$Builder.put(object, object2);
        immutableSetMultimap$Builder.put(object3, object4);
        immutableSetMultimap$Builder.put(object5, object6);
        immutableSetMultimap$Builder.put(object7, object8);
        immutableSetMultimap$Builder.put(object9, object10);
        return immutableSetMultimap$Builder.build();
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        Object object2 = (Comparator)((ObjectInputStream)object).readObject();
        int n10 = ((ObjectInputStream)object).readInt();
        if (n10 >= 0) {
            ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
            int n11 = 0;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object3 = ((ObjectInputStream)object).readObject();
                int n12 = ((ObjectInputStream)object).readInt();
                if (n12 > 0) {
                    int n13;
                    Object object4 = ImmutableSetMultimap.valuesBuilder((Comparator)object2);
                    for (n13 = 0; n13 < n12; ++n13) {
                        Object object5 = ((ObjectInputStream)object).readObject();
                        ((ImmutableSet$Builder)object4).add(object5);
                    }
                    n13 = ((AbstractCollection)(object4 = ((ImmutableSet$Builder)object4).build())).size();
                    if (n13 == n12) {
                        immutableMap$Builder.put(object3, object4);
                        n11 += n12;
                        continue;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Duplicate key-value pairs exist for key ");
                    ((StringBuilder)object2).append(object3);
                    object2 = ((StringBuilder)object2).toString();
                    object = new InvalidObjectException((String)object2);
                    throw object;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Invalid value count ");
                ((StringBuilder)object2).append(n12);
                object2 = ((StringBuilder)object2).toString();
                object = new InvalidObjectException((String)object2);
                throw object;
            }
            try {
                object = immutableMap$Builder.build();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                String string2 = illegalArgumentException.getMessage();
                object2 = new InvalidObjectException(string2);
                throw (InvalidObjectException)((Throwable)object2).initCause(illegalArgumentException);
            }
            ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set((Object)this, object);
            ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set((Object)this, n11);
            object = ImmutableSetMultimap$SetFieldSettersHolder.EMPTY_SET_FIELD_SETTER;
            object2 = ImmutableSetMultimap.emptySet((Comparator)object2);
            ((Serialization$FieldSetter)object).set((Object)this, object2);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Invalid key count ");
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        object = new InvalidObjectException((String)object2);
        throw object;
    }

    private static ImmutableSet valueSet(Comparator object, Collection collection) {
        object = object == null ? ImmutableSet.copyOf(collection) : ImmutableSortedSet.copyOf((Comparator)object, collection);
        return object;
    }

    private static ImmutableSet$Builder valuesBuilder(Comparator object) {
        if (object == null) {
            object = new ImmutableSet$Builder();
        } else {
            ImmutableSortedSet$Builder immutableSortedSet$Builder = new ImmutableSortedSet$Builder((Comparator)object);
            object = immutableSortedSet$Builder;
        }
        return object;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Comparator comparator = this.valueComparator();
        objectOutputStream.writeObject(comparator);
        Serialization.writeMultimap(this, objectOutputStream);
    }

    public ImmutableSet entries() {
        ImmutableSet immutableSet = this.entries;
        if (immutableSet == null) {
            this.entries = immutableSet = new ImmutableSetMultimap$EntrySet(this);
        }
        return immutableSet;
    }

    public ImmutableSet get(Object object) {
        object = (ImmutableSet)this.map.get(object);
        ImmutableSet immutableSet = this.emptySet;
        return (ImmutableSet)MoreObjects.firstNonNull(object, immutableSet);
    }

    public ImmutableSetMultimap inverse() {
        ImmutableSetMultimap immutableSetMultimap = this.inverse;
        if (immutableSetMultimap == null) {
            this.inverse = immutableSetMultimap = this.invert();
        }
        return immutableSetMultimap;
    }

    public ImmutableSet removeAll(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableSet replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Comparator valueComparator() {
        Object object = this.emptySet;
        boolean bl2 = object instanceof ImmutableSortedSet;
        object = bl2 ? ((ImmutableSortedSet)object).comparator() : null;
        return object;
    }
}

