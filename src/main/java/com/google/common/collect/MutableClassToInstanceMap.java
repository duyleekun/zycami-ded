/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.MutableClassToInstanceMap$1;
import com.google.common.collect.MutableClassToInstanceMap$2;
import com.google.common.collect.MutableClassToInstanceMap$SerializedForm;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MutableClassToInstanceMap
extends ForwardingMap
implements ClassToInstanceMap,
Serializable {
    private final Map delegate;

    private MutableClassToInstanceMap(Map map) {
        this.delegate = map = (Map)Preconditions.checkNotNull(map);
    }

    public static /* synthetic */ Object access$000(Class clazz, Object object) {
        return MutableClassToInstanceMap.cast(clazz, object);
    }

    private static Object cast(Class clazz, Object object) {
        return Primitives.wrap(clazz).cast(object);
    }

    public static Map.Entry checkedEntry(Map.Entry entry) {
        MutableClassToInstanceMap$1 mutableClassToInstanceMap$1 = new MutableClassToInstanceMap$1(entry);
        return mutableClassToInstanceMap$1;
    }

    public static MutableClassToInstanceMap create() {
        HashMap hashMap = new HashMap();
        MutableClassToInstanceMap mutableClassToInstanceMap = new MutableClassToInstanceMap(hashMap);
        return mutableClassToInstanceMap;
    }

    public static MutableClassToInstanceMap create(Map map) {
        MutableClassToInstanceMap mutableClassToInstanceMap = new MutableClassToInstanceMap(map);
        return mutableClassToInstanceMap;
    }

    private Object writeReplace() {
        Object object = this.delegate();
        MutableClassToInstanceMap$SerializedForm mutableClassToInstanceMap$SerializedForm = new MutableClassToInstanceMap$SerializedForm((Map)object);
        return mutableClassToInstanceMap$SerializedForm;
    }

    public Map delegate() {
        return this.delegate;
    }

    public Set entrySet() {
        MutableClassToInstanceMap$2 mutableClassToInstanceMap$2 = new MutableClassToInstanceMap$2(this);
        return mutableClassToInstanceMap$2;
    }

    public Object getInstance(Class clazz) {
        Object object = this.get(clazz);
        return MutableClassToInstanceMap.cast(clazz, object);
    }

    public Object put(Class clazz, Object object) {
        object = MutableClassToInstanceMap.cast(clazz, object);
        return super.put(clazz, object);
    }

    public void putAll(Map object) {
        boolean bl2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(object);
        object = linkedHashMap.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Class clazz = (Class)entry.getKey();
            entry = entry.getValue();
            MutableClassToInstanceMap.cast(clazz, entry);
        }
        super.putAll((Map)linkedHashMap);
    }

    public Object putInstance(Class clazz, Object object) {
        object = this.put(clazz, object);
        return MutableClassToInstanceMap.cast(clazz, object);
    }
}

