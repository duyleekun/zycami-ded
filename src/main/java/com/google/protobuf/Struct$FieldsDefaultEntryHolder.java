/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.MapEntry;
import com.google.protobuf.StructProto;
import com.google.protobuf.Value;
import com.google.protobuf.WireFormat$FieldType;

public final class Struct$FieldsDefaultEntryHolder {
    public static final MapEntry defaultEntry;

    static {
        Descriptors$Descriptor descriptors$Descriptor = StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor;
        WireFormat$FieldType wireFormat$FieldType = WireFormat$FieldType.STRING;
        WireFormat$FieldType wireFormat$FieldType2 = WireFormat$FieldType.MESSAGE;
        Value value = Value.getDefaultInstance();
        defaultEntry = MapEntry.newDefaultInstance(descriptors$Descriptor, wireFormat$FieldType, "", wireFormat$FieldType2, value);
    }

    private Struct$FieldsDefaultEntryHolder() {
    }
}

