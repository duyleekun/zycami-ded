/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField$Converter;
import com.google.protobuf.MapField$ImmutableMessageConverter;
import com.google.protobuf.MapField$MutatabilityAwareMap;
import com.google.protobuf.MapField$StorageMode;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Message;
import com.google.protobuf.MutabilityOracle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapField
implements MutabilityOracle {
    private final MapField$Converter converter;
    private volatile boolean isMutable;
    private List listData;
    private MapField$MutatabilityAwareMap mapData;
    private volatile MapField$StorageMode mode;

    private MapField(MapEntry mapEntry, MapField$StorageMode mapField$StorageMode, Map map) {
        MapField$ImmutableMessageConverter mapField$ImmutableMessageConverter = new MapField$ImmutableMessageConverter(mapEntry);
        this(mapField$ImmutableMessageConverter, mapField$StorageMode, map);
    }

    private MapField(MapField$Converter object, MapField$StorageMode mapField$StorageMode, Map map) {
        this.converter = object;
        this.isMutable = true;
        this.mode = mapField$StorageMode;
        this.mapData = object = new MapField$MutatabilityAwareMap(this, map);
        this.listData = null;
    }

    private Message convertKeyAndValueToMessage(Object object, Object object2) {
        return this.converter.convertKeyAndValueToMessage(object, object2);
    }

    private MapField$MutatabilityAwareMap convertListToMap(List object) {
        boolean bl2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Message message = (Message)object.next();
            this.convertMessageToKeyAndValue(message, linkedHashMap);
        }
        object = new MapField$MutatabilityAwareMap(this, linkedHashMap);
        return object;
    }

    private List convertMapToList(MapField$MutatabilityAwareMap object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = ((MapField$MutatabilityAwareMap)object).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object k10 = object2.getKey();
            object2 = object2.getValue();
            object2 = this.convertKeyAndValueToMessage(k10, object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private void convertMessageToKeyAndValue(Message message, Map map) {
        this.converter.convertMessageToKeyAndValue(message, map);
    }

    public static MapField emptyMapField(MapEntry mapEntry) {
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.MAP;
        Map map = Collections.emptyMap();
        MapField mapField = new MapField(mapEntry, mapField$StorageMode, map);
        return mapField;
    }

    public static MapField newMapField(MapEntry mapEntry) {
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.MAP;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        MapField mapField = new MapField(mapEntry, mapField$StorageMode, linkedHashMap);
        return mapField;
    }

    public void clear() {
        Object object;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.mapData = object = new MapField$MutatabilityAwareMap(this, linkedHashMap);
        object = MapField$StorageMode.MAP;
        this.mode = object;
    }

    public MapField copy() {
        MapField$Converter mapField$Converter = this.converter;
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.MAP;
        Map map = MapFieldLite.copy(this.getMap());
        MapField mapField = new MapField(mapField$Converter, mapField$StorageMode, map);
        return mapField;
    }

    public void ensureMutable() {
        boolean bl2 = this.isMutable();
        if (bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof MapField;
        if (!bl2) {
            return false;
        }
        object = (MapField)object;
        Map map = this.getMap();
        object = ((MapField)object).getMap();
        return MapFieldLite.equals(map, (Map)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getList() {
        Object object = this.mode;
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.MAP;
        if (object != mapField$StorageMode) return Collections.unmodifiableList(this.listData);
        synchronized (this) {
            object = this.mode;
            if (object != mapField$StorageMode) return Collections.unmodifiableList(this.listData);
            object = this.mapData;
            object = this.convertMapToList((MapField$MutatabilityAwareMap)object);
            this.listData = object;
            this.mode = object = MapField$StorageMode.BOTH;
            return Collections.unmodifiableList(this.listData);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map getMap() {
        Object object = this.mode;
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.LIST;
        if (object != mapField$StorageMode) return Collections.unmodifiableMap(this.mapData);
        synchronized (this) {
            object = this.mode;
            if (object != mapField$StorageMode) return Collections.unmodifiableMap(this.mapData);
            object = this.listData;
            object = this.convertListToMap((List)object);
            this.mapData = object;
            this.mode = object = MapField$StorageMode.BOTH;
            return Collections.unmodifiableMap(this.mapData);
        }
    }

    public Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public List getMutableList() {
        Object object = this.mode;
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.LIST;
        if (object != mapField$StorageMode) {
            object = this.mode;
            MapField$StorageMode mapField$StorageMode2 = MapField$StorageMode.MAP;
            if (object == mapField$StorageMode2) {
                object = this.mapData;
                object = this.convertMapToList((MapField$MutatabilityAwareMap)object);
                this.listData = object;
            }
            object = null;
            this.mapData = null;
            this.mode = mapField$StorageMode;
        }
        return this.listData;
    }

    public Map getMutableMap() {
        Object object = this.mode;
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.MAP;
        if (object != mapField$StorageMode) {
            object = this.mode;
            MapField$StorageMode mapField$StorageMode2 = MapField$StorageMode.LIST;
            if (object == mapField$StorageMode2) {
                object = this.listData;
                object = this.convertListToMap((List)object);
                this.mapData = object;
            }
            object = null;
            this.listData = null;
            this.mode = mapField$StorageMode;
        }
        return this.mapData;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(this.getMap());
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapField object) {
        Map map = this.getMutableMap();
        object = MapFieldLite.copy(((MapField)object).getMap());
        map.putAll(object);
    }
}

