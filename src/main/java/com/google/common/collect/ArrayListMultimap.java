/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayListMultimapGwtSerializationDependencies;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Platform;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ArrayListMultimap
extends ArrayListMultimapGwtSerializationDependencies {
    private static final int DEFAULT_VALUES_PER_KEY = 3;
    private static final long serialVersionUID;
    public transient int expectedValuesPerKey;

    private ArrayListMultimap() {
        this(12, 3);
    }

    private ArrayListMultimap(int n10, int n11) {
        Map map = Platform.newHashMapWithExpectedSize(n10);
        super(map);
        CollectPreconditions.checkNonnegative(n11, "expectedValuesPerKey");
        this.expectedValuesPerKey = n11;
    }

    private ArrayListMultimap(Multimap multimap) {
        Set set = multimap.keySet();
        int n10 = set.size();
        int n11 = multimap instanceof ArrayListMultimap;
        if (n11 != 0) {
            Multimap multimap2 = multimap;
            multimap2 = (ArrayListMultimap)multimap;
            n11 = ((ArrayListMultimap)multimap2).expectedValuesPerKey;
        } else {
            n11 = 3;
        }
        this(n10, n11);
        this.putAll(multimap);
    }

    public static ArrayListMultimap create() {
        ArrayListMultimap arrayListMultimap = new ArrayListMultimap();
        return arrayListMultimap;
    }

    public static ArrayListMultimap create(int n10, int n11) {
        ArrayListMultimap arrayListMultimap = new ArrayListMultimap(n10, n11);
        return arrayListMultimap;
    }

    public static ArrayListMultimap create(Multimap multimap) {
        ArrayListMultimap arrayListMultimap = new ArrayListMultimap(multimap);
        return arrayListMultimap;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 3;
        int n10 = Serialization.readCount(objectInputStream);
        CompactHashMap compactHashMap = CompactHashMap.create();
        this.setMap(compactHashMap);
        Serialization.populateMultimap(this, objectInputStream, n10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    public List createCollection() {
        int n10 = this.expectedValuesPerKey;
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }

    public void trimToSize() {
        boolean bl2;
        Iterator iterator2 = this.backingMap().values().iterator();
        while (bl2 = iterator2.hasNext()) {
            ArrayList arrayList = (ArrayList)((Collection)iterator2.next());
            arrayList.trimToSize();
        }
    }
}

