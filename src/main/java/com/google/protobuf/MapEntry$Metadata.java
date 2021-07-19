/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Metadata$1;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat$FieldType;

public final class MapEntry$Metadata
extends MapEntryLite$Metadata {
    public final Descriptors$Descriptor descriptor;
    public final Parser parser;

    public MapEntry$Metadata(Descriptors$Descriptor object, MapEntry object2, WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2) {
        Object object3 = MapEntry.access$000((MapEntry)object2);
        object2 = MapEntry.access$100((MapEntry)object2);
        super(wireFormat$FieldType, object3, wireFormat$FieldType2, object2);
        this.descriptor = object;
        this.parser = object = new MapEntry$Metadata$1(this);
    }
}

