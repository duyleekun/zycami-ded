/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.EnumBiMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class EnumHashBiMap
extends AbstractBiMap {
    private static final long serialVersionUID;
    private transient Class keyType;

    private EnumHashBiMap(Class clazz) {
        EnumMap enumMap = new EnumMap(clazz);
        HashMap hashMap = Maps.newHashMapWithExpectedSize(((Enum[])clazz.getEnumConstants()).length);
        super(enumMap, hashMap);
        this.keyType = clazz;
    }

    public static EnumHashBiMap create(Class clazz) {
        EnumHashBiMap enumHashBiMap = new EnumHashBiMap(clazz);
        return enumHashBiMap;
    }

    public static EnumHashBiMap create(Map map) {
        EnumHashBiMap enumHashBiMap = EnumHashBiMap.create(EnumBiMap.inferKeyType(map));
        enumHashBiMap.putAll(map);
        return enumHashBiMap;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Serializable serializable;
        objectInputStream.defaultReadObject();
        Serializable serializable2 = this.keyType = (serializable = (Class)objectInputStream.readObject());
        serializable = new EnumMap(serializable2);
        int n10 = ((Enum[])this.keyType.getEnumConstants()).length * 3 / 2;
        serializable2 = new HashMap(n10);
        this.setDelegates((Map)((Object)serializable), (Map)((Object)serializable2));
        Serialization.populateMap(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Class clazz = this.keyType;
        objectOutputStream.writeObject(clazz);
        Serialization.writeMap(this, objectOutputStream);
    }

    public Enum checkKey(Enum enum_) {
        return (Enum)Preconditions.checkNotNull(enum_);
    }

    public Object forcePut(Enum enum_, Object object) {
        return super.forcePut(enum_, object);
    }

    public Class keyType() {
        return this.keyType;
    }

    public Object put(Enum enum_, Object object) {
        return super.put(enum_, object);
    }
}

