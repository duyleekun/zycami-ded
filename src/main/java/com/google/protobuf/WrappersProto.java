/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class WrappersProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_BoolValue_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_BoolValue_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_BytesValue_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_BytesValue_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_DoubleValue_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_DoubleValue_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_FloatValue_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_FloatValue_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Int32Value_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Int32Value_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Int64Value_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Int64Value_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_StringValue_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_StringValue_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_UInt32Value_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_UInt32Value_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_UInt64Value_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_UInt64Value_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n\u001egoogle/protobuf/wrappers.proto\u0012\u000fgoogle.protobuf\"\u001c\n\u000bDoubleValue\u0012\r\n\u0005value\u0018\u0001 \u0001(\u0001\"\u001b\n\nFloatValue\u0012\r\n\u0005value\u0018\u0001 \u0001(\u0002\"\u001b\n\nInt64Value\u0012\r\n\u0005value\u0018\u0001 \u0001(\u0003\"\u001c\n\u000bUInt64Value\u0012\r\n\u0005value\u0018\u0001 \u0001(\u0004\"\u001b\n\nInt32Value\u0012\r\n\u0005value\u0018\u0001 \u0001(\u0005\"\u001c\n\u000bUInt32Value\u0012\r\n\u0005value\u0018\u0001 \u0001(\r\"\u001a\n\tBoolValue\u0012\r\n\u0005value\u0018\u0001 \u0001(\b\"\u001c\n\u000bStringValue\u0012\r\n\u0005value\u0018\u0001 \u0001(\t\"\u001b\n\nBytesValue\u0012\r\n\u0005value\u0018\u0001 \u0001(\fB|\n\u0013com.google.protobufB\rWrappersProtoP\u0001Z*github.com/golang/protobuf/ptypes/wrappers\u00f8\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        Object object2 = new Descriptors$FileDescriptor[]{};
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, object2);
        internal_static_google_protobuf_DoubleValue_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(0);
        object2 = "Value";
        String[] stringArray = new String[]{object2};
        internal_static_google_protobuf_DoubleValue_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_FloatValue_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(1);
        stringArray = new String[]{object2};
        internal_static_google_protobuf_FloatValue_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_Int64Value_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(2);
        stringArray = new String[]{object2};
        internal_static_google_protobuf_Int64Value_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_UInt64Value_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(3);
        stringArray = new String[]{object2};
        internal_static_google_protobuf_UInt64Value_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_Int32Value_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(4);
        stringArray = new String[]{object2};
        internal_static_google_protobuf_Int32Value_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_UInt32Value_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(5);
        stringArray = new String[]{object2};
        internal_static_google_protobuf_UInt32Value_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_BoolValue_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(6);
        stringArray = new String[]{object2};
        internal_static_google_protobuf_BoolValue_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_StringValue_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(7);
        stringArray = new String[]{object2};
        internal_static_google_protobuf_StringValue_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_BytesValue_descriptor = object = (Descriptors$Descriptor)WrappersProto.getDescriptor().getMessageTypes().get(8);
        object2 = new String[]{object2};
        internal_static_google_protobuf_BytesValue_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
    }

    private WrappersProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        WrappersProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

