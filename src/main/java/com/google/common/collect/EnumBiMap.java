/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.EnumHashBiMap;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

public final class EnumBiMap
extends AbstractBiMap {
    private static final long serialVersionUID;
    private transient Class keyType;
    private transient Class valueType;

    private EnumBiMap(Class clazz, Class clazz2) {
        EnumMap enumMap = new EnumMap(clazz);
        EnumMap enumMap2 = new EnumMap(clazz2);
        super(enumMap, enumMap2);
        this.keyType = clazz;
        this.valueType = clazz2;
    }

    public static EnumBiMap create(Class clazz, Class clazz2) {
        EnumBiMap enumBiMap = new EnumBiMap(clazz, clazz2);
        return enumBiMap;
    }

    public static EnumBiMap create(Map map) {
        Serializable serializable = EnumBiMap.inferKeyType(map);
        Class clazz = EnumBiMap.inferValueType(map);
        serializable = EnumBiMap.create((Class)serializable, clazz);
        ((EnumBiMap)serializable).putAll(map);
        return serializable;
    }

    public static Class inferKeyType(Map map) {
        boolean bl2 = map instanceof EnumBiMap;
        if (bl2) {
            return ((EnumBiMap)map).keyType();
        }
        bl2 = map instanceof EnumHashBiMap;
        if (bl2) {
            return ((EnumHashBiMap)map).keyType();
        }
        Preconditions.checkArgument(map.isEmpty() ^ true);
        return ((Enum)map.keySet().iterator().next()).getDeclaringClass();
    }

    private static Class inferValueType(Map map) {
        boolean bl2 = map instanceof EnumBiMap;
        if (bl2) {
            return ((EnumBiMap)map).valueType;
        }
        Preconditions.checkArgument(map.isEmpty() ^ true);
        return ((Enum)map.values().iterator().next()).getDeclaringClass();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Serializable serializable;
        objectInputStream.defaultReadObject();
        this.keyType = serializable = (Class)objectInputStream.readObject();
        this.valueType = serializable = (Class)objectInputStream.readObject();
        Serializable serializable2 = this.keyType;
        serializable = new EnumMap(serializable2);
        Class clazz = this.valueType;
        serializable2 = new EnumMap(clazz);
        this.setDelegates((Map)((Object)serializable), (Map)((Object)serializable2));
        Serialization.populateMap(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Class clazz = this.keyType;
        objectOutputStream.writeObject(clazz);
        clazz = this.valueType;
        objectOutputStream.writeObject(clazz);
        Serialization.writeMap(this, objectOutputStream);
    }

    public Enum checkKey(Enum enum_) {
        return (Enum)Preconditions.checkNotNull(enum_);
    }

    public Enum checkValue(Enum enum_) {
        return (Enum)Preconditions.checkNotNull(enum_);
    }

    public Class keyType() {
        return this.keyType;
    }

    public Class valueType() {
        return this.valueType;
    }
}

