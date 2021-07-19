/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLite;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MapFieldLite
extends LinkedHashMap {
    private static final MapFieldLite EMPTY_MAP_FIELD;
    private boolean isMutable = true;

    static {
        MapFieldLite mapFieldLite;
        EMPTY_MAP_FIELD = mapFieldLite = new MapFieldLite();
        mapFieldLite.makeImmutable();
    }

    private MapFieldLite() {
    }

    private MapFieldLite(Map map) {
        super(map);
    }

    public static int calculateHashCodeForMap(Map object) {
        int n10;
        object = object.entrySet().iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            int n12 = MapFieldLite.calculateHashCodeForObject(k10);
            entry = entry.getValue();
            n10 = MapFieldLite.calculateHashCodeForObject(entry) ^ n12;
            n11 += n10;
        }
        return n11;
    }

    private static int calculateHashCodeForObject(Object object) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return Internal.hashCode((byte[])object);
        }
        bl2 = object instanceof Internal$EnumLite;
        if (!bl2) {
            return object.hashCode();
        }
        object = new UnsupportedOperationException();
        throw object;
    }

    private static void checkForNullKeysAndValues(Map map) {
        boolean bl2;
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Internal.checkNotNull(object);
            object = map.get(object);
            Internal.checkNotNull(object);
        }
    }

    private static Object copy(Object object) {
        int n10 = object instanceof byte[];
        if (n10 != 0) {
            object = (byte[])object;
            n10 = ((Object)object).length;
            object = Arrays.copyOf((byte[])object, n10);
        }
        return object;
    }

    public static Map copy(Map object) {
        boolean bl2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object k10 = object2.getKey();
            object2 = MapFieldLite.copy(object2.getValue());
            linkedHashMap.put(k10, object2);
        }
        return linkedHashMap;
    }

    public static MapFieldLite emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    private void ensureMutable() {
        boolean bl2 = this.isMutable();
        if (bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private static boolean equals(Object object, Object object2) {
        boolean bl2 = object instanceof byte[];
        if (bl2 && (bl2 = object2 instanceof byte[])) {
            object = (byte[])object;
            object2 = (byte[])object2;
            return Arrays.equals((byte[])object, (byte[])object2);
        }
        return object.equals(object2);
    }

    public static boolean equals(Map object, Map map) {
        int n10;
        boolean bl2 = true;
        if (object == map) {
            return bl2;
        }
        int n11 = object.size();
        if (n11 != (n10 = map.size())) {
            return false;
        }
        object = object.entrySet().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            Object object2 = entry.getKey();
            n10 = (int)(map.containsKey(object2) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
            object2 = entry.getValue();
            entry = entry.getKey();
            n11 = (int)(MapFieldLite.equals(object2, entry = map.get(entry)) ? 1 : 0);
            if (n11 != 0) continue;
            return false;
        }
        return bl2;
    }

    public void clear() {
        this.ensureMutable();
        super.clear();
    }

    public Set entrySet() {
        boolean bl2 = this.isEmpty();
        Set<Object> set = bl2 ? Collections.emptySet() : super.entrySet();
        return set;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Map;
        if (bl3 && (bl2 = MapFieldLite.equals(this, (Map)(object = (Map)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(this);
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapFieldLite mapFieldLite) {
        this.ensureMutable();
        boolean bl2 = mapFieldLite.isEmpty();
        if (!bl2) {
            this.putAll((Map)mapFieldLite);
        }
    }

    public MapFieldLite mutableCopy() {
        boolean bl2 = this.isEmpty();
        MapFieldLite mapFieldLite = bl2 ? new MapFieldLite() : new MapFieldLite((Map)this);
        return mapFieldLite;
    }

    public Object put(Object object, Object object2) {
        this.ensureMutable();
        Internal.checkNotNull(object);
        Internal.checkNotNull(object2);
        return super.put(object, object2);
    }

    public Object put(Map.Entry entry) {
        Object k10 = entry.getKey();
        entry = entry.getValue();
        return this.put(k10, entry);
    }

    public void putAll(Map map) {
        this.ensureMutable();
        MapFieldLite.checkForNullKeysAndValues(map);
        super.putAll(map);
    }

    public Object remove(Object object) {
        this.ensureMutable();
        return super.remove(object);
    }
}

