/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.EmptyImmutableListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableListMultimap$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$FieldSettersHolder;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.UnmodifiableIterator;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class ImmutableListMultimap
extends ImmutableMultimap
implements ListMultimap {
    private static final long serialVersionUID;
    private transient ImmutableListMultimap inverse;

    public ImmutableListMultimap(ImmutableMap immutableMap, int n10) {
        super(immutableMap, n10);
    }

    public static ImmutableListMultimap$Builder builder() {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = new ImmutableListMultimap$Builder();
        return immutableListMultimap$Builder;
    }

    public static ImmutableListMultimap copyOf(Multimap multimap) {
        boolean bl2 = multimap.isEmpty();
        if (bl2) {
            return ImmutableListMultimap.of();
        }
        bl2 = multimap instanceof ImmutableListMultimap;
        if (bl2) {
            Multimap multimap2 = multimap;
            multimap2 = (ImmutableListMultimap)multimap;
            boolean bl3 = ((ImmutableMultimap)multimap2).isPartialView();
            if (!bl3) {
                return multimap2;
            }
        }
        return ImmutableListMultimap.fromMapEntries(multimap.asMap().entrySet(), null);
    }

    public static ImmutableListMultimap copyOf(Iterable iterable) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = new ImmutableListMultimap$Builder();
        return immutableListMultimap$Builder.putAll(iterable).build();
    }

    public static ImmutableListMultimap fromMapEntries(Collection object, Comparator object2) {
        int n10;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return ImmutableListMultimap.of();
        }
        int n11 = object.size();
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(n11);
        n11 = 0;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object3 = (Map.Entry)object.next();
            Object k10 = object3.getKey();
            object3 = (Collection)object3.getValue();
            object3 = object2 == null ? ImmutableList.copyOf((Collection)object3) : ImmutableList.sortedCopyOf((Comparator)object2, (Iterable)object3);
            boolean bl3 = ((AbstractCollection)object3).isEmpty();
            if (bl3) continue;
            immutableMap$Builder.put(k10, object3);
            n10 = ((AbstractCollection)object3).size();
            n11 += n10;
        }
        object2 = immutableMap$Builder.build();
        object = new ImmutableListMultimap((ImmutableMap)object2, n11);
        return object;
    }

    private ImmutableListMultimap invert() {
        boolean bl2;
        Object object = ImmutableListMultimap.builder();
        UnmodifiableIterator unmodifiableIterator = this.entries().iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)unmodifiableIterator.next();
            Object v10 = entry.getValue();
            entry = entry.getKey();
            ((ImmutableListMultimap$Builder)object).put(v10, entry);
        }
        object = ((ImmutableListMultimap$Builder)object).build();
        ((ImmutableListMultimap)object).inverse = this;
        return object;
    }

    public static ImmutableListMultimap of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static ImmutableListMultimap of(Object object, Object object2) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        immutableListMultimap$Builder.put(object5, object6);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        immutableListMultimap$Builder.put(object5, object6);
        immutableListMultimap$Builder.put(object7, object8);
        return immutableListMultimap$Builder.build();
    }

    public static ImmutableListMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        immutableListMultimap$Builder.put(object, object2);
        immutableListMultimap$Builder.put(object3, object4);
        immutableListMultimap$Builder.put(object5, object6);
        immutableListMultimap$Builder.put(object7, object8);
        immutableListMultimap$Builder.put(object9, object10);
        return immutableListMultimap$Builder.build();
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        int n10 = ((ObjectInputStream)object).readInt();
        if (n10 >= 0) {
            Object object2 = ImmutableMap.builder();
            int n11 = 0;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object3 = ((ObjectInputStream)object).readObject();
                int n12 = ((ObjectInputStream)object).readInt();
                if (n12 > 0) {
                    Object object4 = ImmutableList.builder();
                    for (int i11 = 0; i11 < n12; ++i11) {
                        Object object5 = ((ObjectInputStream)object).readObject();
                        ((ImmutableList$Builder)object4).add(object5);
                    }
                    object4 = ((ImmutableList$Builder)object4).build();
                    ((ImmutableMap$Builder)object2).put(object3, object4);
                    n11 += n12;
                    continue;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Invalid value count ");
                charSequence.append(n12);
                charSequence = charSequence.toString();
                object = new InvalidObjectException((String)charSequence);
                throw object;
            }
            try {
                object = ((ImmutableMap$Builder)object2).build();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = illegalArgumentException.getMessage();
                InvalidObjectException invalidObjectException = new InvalidObjectException((String)object2);
                throw (InvalidObjectException)invalidObjectException.initCause(illegalArgumentException);
            }
            ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set((Object)this, object);
            ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set((Object)this, n11);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid key count ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new InvalidObjectException(string2);
        throw object;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    public ImmutableList get(Object object) {
        ImmutableMap immutableMap = this.map;
        if ((object = (ImmutableList)immutableMap.get(object)) == null) {
            object = ImmutableList.of();
        }
        return object;
    }

    public ImmutableListMultimap inverse() {
        ImmutableListMultimap immutableListMultimap = this.inverse;
        if (immutableListMultimap == null) {
            this.inverse = immutableListMultimap = this.invert();
        }
        return immutableListMultimap;
    }

    public ImmutableList removeAll(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableList replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

