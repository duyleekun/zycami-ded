/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class StructProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_ListValue_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_ListValue_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Struct_FieldsEntry_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Struct_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Struct_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Value_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Value_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n\u001cgoogle/protobuf/struct.proto\u0012\u000fgoogle.protobuf\"\u0084\u0001\n\u0006Struct\u00123\n\u0006fields\u0018\u0001 \u0003(\u000b2#.google.protobuf.Struct.FieldsEntry\u001aE\n\u000bFieldsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012%\n\u0005value\u0018\u0002 \u0001(\u000b2\u0016.google.protobuf.Value:\u00028\u0001\"\u00ea\u0001\n\u0005Value\u00120\n\nnull_value\u0018\u0001 \u0001(\u000e2\u001a.google.protobuf.NullValueH\u0000\u0012\u0016\n\fnumber_value\u0018\u0002 \u0001(\u0001H\u0000\u0012\u0016\n\fstring_value\u0018\u0003 \u0001(\tH\u0000\u0012\u0014\n\nbool_value\u0018\u0004 \u0001(\bH\u0000\u0012/\n\fstruct_value\u0018\u0005 \u0001(\u000b2\u0017.google.protobuf.StructH\u0000\u00120\n\nlist_value\u0018\u0006 \u0001(\u000b2\u001a.google.protobuf.ListValueH\u0000B\u0006\n\u0004kind\"3\n\tListValue\u0012&\n\u0006values\u0018\u0001 \u0003(\u000b2\u0016.google.protobuf.Value*\u001b\n\tNullValue\u0012\u000e\n\nNULL_VALUE\u0010\u0000B\u0081\u0001\n\u0013com.google.protobufB\u000bStructProtoP\u0001Z1github.com/golang/protobuf/ptypes/struct;structpb\u00f8\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        Object object2 = new Descriptors$FileDescriptor[]{};
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom((String[])object, object2);
        internal_static_google_protobuf_Struct_descriptor = object = (Descriptors$Descriptor)StructProto.getDescriptor().getMessageTypes().get(0);
        String[] stringArray = new String[]{"Fields"};
        internal_static_google_protobuf_Struct_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_Struct_FieldsEntry_descriptor = object = (Descriptors$Descriptor)((Descriptors$Descriptor)object).getNestedTypes().get(0);
        object2 = new String[]{"Key", "Value"};
        internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
        internal_static_google_protobuf_Value_descriptor = object = (Descriptors$Descriptor)StructProto.getDescriptor().getMessageTypes().get(1);
        object2 = new String[]{"NullValue", "NumberValue", "StringValue", "BoolValue", "StructValue", "ListValue", "Kind"};
        internal_static_google_protobuf_Value_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
        internal_static_google_protobuf_ListValue_descriptor = object = (Descriptors$Descriptor)StructProto.getDescriptor().getMessageTypes().get(2);
        object2 = new String[]{"Values"};
        internal_static_google_protobuf_ListValue_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
    }

    private StructProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        StructProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

