/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Serialization$FieldSetter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Serialization {
    private Serialization() {
    }

    public static Serialization$FieldSetter getFieldSetter(Class annotatedElement, String object) {
        try {
            annotatedElement = annotatedElement.getDeclaredField((String)object);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            object = new AssertionError((Object)noSuchFieldException);
            throw object;
        }
        object = new Serialization$FieldSetter((Field)annotatedElement, null);
        return object;
    }

    public static void populateMap(Map map, ObjectInputStream objectInputStream) {
        int n10 = objectInputStream.readInt();
        Serialization.populateMap(map, objectInputStream, n10);
    }

    public static void populateMap(Map map, ObjectInputStream objectInputStream, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            map.put(object, object2);
        }
    }

    public static void populateMultimap(Multimap multimap, ObjectInputStream objectInputStream) {
        int n10 = objectInputStream.readInt();
        Serialization.populateMultimap(multimap, objectInputStream, n10);
    }

    public static void populateMultimap(Multimap multimap, ObjectInputStream objectInputStream, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectInputStream.readObject();
            object = multimap.get(object);
            int n11 = objectInputStream.readInt();
            for (int i11 = 0; i11 < n11; ++i11) {
                Object object2 = objectInputStream.readObject();
                object.add(object2);
            }
        }
    }

    public static void populateMultiset(Multiset multiset, ObjectInputStream objectInputStream) {
        int n10 = objectInputStream.readInt();
        Serialization.populateMultiset(multiset, objectInputStream, n10);
    }

    public static void populateMultiset(Multiset multiset, ObjectInputStream objectInputStream, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectInputStream.readObject();
            int n11 = objectInputStream.readInt();
            multiset.add(object, n11);
        }
    }

    public static int readCount(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    public static void writeMap(Map object, ObjectOutputStream objectOutputStream) {
        int n10 = object.size();
        objectOutputStream.writeInt(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            objectOutputStream.writeObject(k10);
            entry = entry.getValue();
            objectOutputStream.writeObject(entry);
        }
    }

    public static void writeMultimap(Multimap object, ObjectOutputStream objectOutputStream) {
        Iterator iterator2 = object.asMap();
        int n10 = iterator2.size();
        objectOutputStream.writeInt(n10);
        object = object.asMap().entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            iterator2 = (Map.Entry)object.next();
            Object object2 = iterator2.getKey();
            objectOutputStream.writeObject(object2);
            object2 = (Collection)iterator2.getValue();
            int n11 = object2.size();
            objectOutputStream.writeInt(n11);
            iterator2 = ((Collection)iterator2.getValue()).iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object2 = iterator2.next();
                objectOutputStream.writeObject(object2);
            }
        }
    }

    public static void writeMultiset(Multiset object, ObjectOutputStream objectOutputStream) {
        Object object2 = object.entrySet();
        int n10 = object2.size();
        objectOutputStream.writeInt(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (Multiset$Entry)object.next();
            Object object3 = object2.getElement();
            objectOutputStream.writeObject(object3);
            n10 = object2.getCount();
            objectOutputStream.writeInt(n10);
        }
    }
}

