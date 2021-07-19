/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$MapAdapter$1;
import com.google.protobuf.Internal$MapAdapter$Converter;
import com.google.protobuf.Internal$MapAdapter$SetAdapter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class Internal$MapAdapter
extends AbstractMap {
    private final Map realMap;
    private final Internal$MapAdapter$Converter valueConverter;

    public Internal$MapAdapter(Map map, Internal$MapAdapter$Converter internal$MapAdapter$Converter) {
        this.realMap = map;
        this.valueConverter = internal$MapAdapter$Converter;
    }

    public static /* synthetic */ Internal$MapAdapter$Converter access$000(Internal$MapAdapter internal$MapAdapter) {
        return internal$MapAdapter.valueConverter;
    }

    public static Internal$MapAdapter$Converter newEnumConverter(Internal$EnumLiteMap internal$EnumLiteMap, Internal$EnumLite internal$EnumLite) {
        Internal$MapAdapter$1 internal$MapAdapter$1 = new Internal$MapAdapter$1(internal$EnumLiteMap, internal$EnumLite);
        return internal$MapAdapter$1;
    }

    public Set entrySet() {
        Set set = this.realMap.entrySet();
        Internal$MapAdapter$SetAdapter internal$MapAdapter$SetAdapter = new Internal$MapAdapter$SetAdapter(this, set);
        return internal$MapAdapter$SetAdapter;
    }

    public Object get(Object object) {
        Map map = this.realMap;
        if ((object = map.get(object)) == null) {
            return null;
        }
        return this.valueConverter.doForward(object);
    }

    public Object put(Object object, Object object2) {
        Map map = this.realMap;
        Internal$MapAdapter$Converter internal$MapAdapter$Converter = this.valueConverter;
        if ((object = map.put(object, object2 = internal$MapAdapter$Converter.doBackward(object2))) == null) {
            return null;
        }
        return this.valueConverter.doForward(object);
    }
}

