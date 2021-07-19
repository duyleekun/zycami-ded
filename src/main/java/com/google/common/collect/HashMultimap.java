/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimapGwtSerializationDependencies;
import com.google.common.collect.Multimap;
import com.google.common.collect.Platform;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

public final class HashMultimap
extends HashMultimapGwtSerializationDependencies {
    private static final int DEFAULT_VALUES_PER_KEY = 2;
    private static final long serialVersionUID;
    public transient int expectedValuesPerKey;

    private HashMultimap() {
        this(12, 2);
    }

    private HashMultimap(int n10, int n11) {
        Map map = Platform.newHashMapWithExpectedSize(n10);
        super(map);
        this.expectedValuesPerKey = n10 = 2;
        if (n11 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            map = null;
        }
        Preconditions.checkArgument(n10 != 0);
        this.expectedValuesPerKey = n11;
    }

    private HashMultimap(Multimap multimap) {
        Map map = Platform.newHashMapWithExpectedSize(multimap.keySet().size());
        super(map);
        this.expectedValuesPerKey = 2;
        this.putAll(multimap);
    }

    public static HashMultimap create() {
        HashMultimap hashMultimap = new HashMultimap();
        return hashMultimap;
    }

    public static HashMultimap create(int n10, int n11) {
        HashMultimap hashMultimap = new HashMultimap(n10, n11);
        return hashMultimap;
    }

    public static HashMultimap create(Multimap multimap) {
        HashMultimap hashMultimap = new HashMultimap(multimap);
        return hashMultimap;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int n10 = Serialization.readCount(objectInputStream);
        Map map = Platform.newHashMapWithExpectedSize(12);
        this.setMap(map);
        Serialization.populateMultimap(this, objectInputStream, n10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    public Set createCollection() {
        return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
}

