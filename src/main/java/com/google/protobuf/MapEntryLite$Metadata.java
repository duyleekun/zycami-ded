/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$FieldType;

public class MapEntryLite$Metadata {
    public final Object defaultKey;
    public final Object defaultValue;
    public final WireFormat$FieldType keyType;
    public final WireFormat$FieldType valueType;

    public MapEntryLite$Metadata(WireFormat$FieldType wireFormat$FieldType, Object object, WireFormat$FieldType wireFormat$FieldType2, Object object2) {
        this.keyType = wireFormat$FieldType;
        this.defaultKey = object;
        this.valueType = wireFormat$FieldType2;
        this.defaultValue = object2;
    }
}

