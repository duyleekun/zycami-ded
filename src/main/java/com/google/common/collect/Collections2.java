/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2$FilteredCollection;
import com.google.common.collect.Collections2$OrderedPermutationCollection;
import com.google.common.collect.Collections2$PermutationCollection;
import com.google.common.collect.Collections2$TransformedCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectCountHashMap;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class Collections2 {
    private Collections2() {
    }

    public static /* synthetic */ boolean access$000(List list, List list2) {
        return Collections2.isPermutation(list, list2);
    }

    public static Collection cast(Iterable iterable) {
        return (Collection)iterable;
    }

    public static boolean containsAllImpl(Collection collection, Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = collection.contains(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    private static ObjectCountHashMap counts(Collection object) {
        boolean bl2;
        ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n10 = objectCountHashMap.get(e10) + 1;
            objectCountHashMap.put(e10, n10);
        }
        return objectCountHashMap;
    }

    public static Collection filter(Collection collection, Predicate predicate) {
        boolean bl2 = collection instanceof Collections2$FilteredCollection;
        if (bl2) {
            return ((Collections2$FilteredCollection)collection).createCombined(predicate);
        }
        collection = (Collection)Preconditions.checkNotNull(collection);
        predicate = (Predicate)Preconditions.checkNotNull(predicate);
        Collections2$FilteredCollection collections2$FilteredCollection = new Collections2$FilteredCollection(collection, predicate);
        return collections2$FilteredCollection;
    }

    private static boolean isPermutation(List list, List list2) {
        int n10;
        int n11;
        int n12 = list.size();
        if (n12 != (n11 = list2.size())) {
            return false;
        }
        ObjectCountHashMap objectCountHashMap = Collections2.counts(list);
        ObjectCountHashMap objectCountHashMap2 = Collections2.counts(list2);
        int n13 = list.size();
        if (n13 != (n10 = list2.size())) {
            return false;
        }
        list2 = null;
        for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
            Object object;
            int n14;
            n13 = objectCountHashMap.getValue(n10);
            if (n13 == (n14 = objectCountHashMap2.get(object = objectCountHashMap.getKey(n10)))) continue;
            return false;
        }
        return true;
    }

    public static StringBuilder newStringBuilderForCollection(int n10) {
        CollectPreconditions.checkNonnegative(n10, "size");
        n10 = (int)Math.min((long)n10 * (long)8, 0x40000000L);
        StringBuilder stringBuilder = new StringBuilder(n10);
        return stringBuilder;
    }

    public static Collection orderedPermutations(Iterable iterable) {
        Ordering ordering = Ordering.natural();
        return Collections2.orderedPermutations(iterable, ordering);
    }

    public static Collection orderedPermutations(Iterable iterable, Comparator comparator) {
        Collections2$OrderedPermutationCollection collections2$OrderedPermutationCollection = new Collections2$OrderedPermutationCollection(iterable, comparator);
        return collections2$OrderedPermutationCollection;
    }

    public static Collection permutations(Collection collection) {
        collection = ImmutableList.copyOf(collection);
        Collections2$PermutationCollection collections2$PermutationCollection = new Collections2$PermutationCollection((ImmutableList)collection);
        return collections2$PermutationCollection;
    }

    public static boolean safeContains(Collection collection, Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public static boolean safeRemove(Collection collection, Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public static String toStringImpl(Collection collection) {
        boolean bl2;
        int n10 = collection.size();
        StringBuilder stringBuilder = Collections2.newStringBuilderForCollection(n10);
        char c10 = '[';
        stringBuilder.append(c10);
        Iterator iterator2 = collection.iterator();
        boolean bl3 = true;
        while (bl2 = iterator2.hasNext()) {
            String string2;
            Object object = iterator2.next();
            if (!bl3) {
                string2 = ", ";
                stringBuilder.append(string2);
            }
            bl3 = false;
            string2 = null;
            if (object == collection) {
                object = "(this Collection)";
                stringBuilder.append((String)object);
                continue;
            }
            stringBuilder.append(object);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static Collection transform(Collection collection, Function function) {
        Collections2$TransformedCollection collections2$TransformedCollection = new Collections2$TransformedCollection(collection, function);
        return collections2$TransformedCollection;
    }
}

