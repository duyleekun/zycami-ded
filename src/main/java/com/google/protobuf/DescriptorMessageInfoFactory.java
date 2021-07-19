/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorMessageInfoFactory$1;
import com.google.protobuf.DescriptorMessageInfoFactory$2;
import com.google.protobuf.DescriptorMessageInfoFactory$3;
import com.google.protobuf.DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer;
import com.google.protobuf.DescriptorMessageInfoFactory$OneofState;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.FieldInfo;
import com.google.protobuf.FieldType;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal$EnumVerifier;
import com.google.protobuf.JavaType;
import com.google.protobuf.Message;
import com.google.protobuf.MessageInfo;
import com.google.protobuf.MessageInfoFactory;
import com.google.protobuf.OneofInfo;
import com.google.protobuf.ProtoSyntax;
import com.google.protobuf.SchemaUtil;
import com.google.protobuf.StructuralMessageInfo;
import com.google.protobuf.StructuralMessageInfo$Builder;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DescriptorMessageInfoFactory
implements MessageInfoFactory {
    private static final String GET_DEFAULT_INSTANCE_METHOD_NAME = "getDefaultInstance";
    private static final DescriptorMessageInfoFactory instance;
    private static DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer isInitializedCheckAnalyzer;
    private static final Set specialFieldNames;

    static {
        Object object = new DescriptorMessageInfoFactory();
        instance = object;
        List<String> list = Arrays.asList("cached_size", "serialized_size", "class");
        object = new HashSet(list);
        specialFieldNames = object;
        isInitializedCheckAnalyzer = object = new DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer();
    }

    private DescriptorMessageInfoFactory() {
    }

    public static /* synthetic */ String access$200(String string2) {
        return DescriptorMessageInfoFactory.snakeCaseToCamelCase(string2);
    }

    public static /* synthetic */ Field access$300(Class clazz, String string2) {
        return DescriptorMessageInfoFactory.field(clazz, string2);
    }

    private static Field bitField(Class clazz, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bitField");
        stringBuilder.append(n10);
        stringBuilder.append("_");
        String string2 = stringBuilder.toString();
        return DescriptorMessageInfoFactory.field(clazz, string2);
    }

    private static FieldInfo buildOneofMember(Class clazz, Descriptors$FieldDescriptor descriptors$FieldDescriptor, DescriptorMessageInfoFactory$OneofState descriptorMessageInfoFactory$OneofState, boolean bl2, Internal$EnumVerifier internal$EnumVerifier) {
        Descriptors$OneofDescriptor descriptors$OneofDescriptor = descriptors$FieldDescriptor.getContainingOneof();
        OneofInfo oneofInfo = descriptorMessageInfoFactory$OneofState.getOneof(clazz, descriptors$OneofDescriptor);
        FieldType fieldType = DescriptorMessageInfoFactory.getFieldType(descriptors$FieldDescriptor);
        Class clazz2 = DescriptorMessageInfoFactory.getOneofStoredType(clazz, descriptors$FieldDescriptor, fieldType);
        return FieldInfo.forOneofMemberField(descriptors$FieldDescriptor.getNumber(), fieldType, oneofInfo, clazz2, bl2, internal$EnumVerifier);
    }

    private static Field cachedSizeField(Class clazz, Descriptors$FieldDescriptor object) {
        object = DescriptorMessageInfoFactory.getCachedSizeFieldName((Descriptors$FieldDescriptor)object);
        return DescriptorMessageInfoFactory.field(clazz, (String)object);
    }

    private static MessageInfo convert(Class serializable, Descriptors$Descriptor object) {
        Object object2 = DescriptorMessageInfoFactory$3.$SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax = object.getFile().getSyntax();
        int n10 = descriptors$FileDescriptor$Syntax.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                return DescriptorMessageInfoFactory.convertProto3(serializable, object);
            }
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            ((StringBuilder)object2).append("Unsupported syntax: ");
            object = object.getFile().getSyntax();
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        return DescriptorMessageInfoFactory.convertProto2(serializable, object);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static StructuralMessageInfo convertProto2(Class clazz, Descriptors$Descriptor descriptors$Descriptor) {
        int n10;
        Serializable serializable = clazz;
        Object object = descriptors$Descriptor.getFields();
        int n11 = object.size();
        StructuralMessageInfo$Builder structuralMessageInfo$Builder = StructuralMessageInfo.newBuilder(n11);
        Object object2 = DescriptorMessageInfoFactory.getDefaultInstance(clazz);
        structuralMessageInfo$Builder.withDefaultInstance(object2);
        object2 = ProtoSyntax.PROTO2;
        structuralMessageInfo$Builder.withSyntax((ProtoSyntax)((Object)object2));
        int n12 = descriptors$Descriptor.getOptions().getMessageSetWireFormat();
        structuralMessageInfo$Builder.withMessageSetWireFormat(n12 != 0);
        int n13 = 0;
        Object object3 = null;
        object2 = new DescriptorMessageInfoFactory$OneofState(null);
        int n14 = 0;
        int n15 = 1;
        Field field = null;
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = null;
        int n16 = 0;
        int n17 = n15;
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            block17: {
                block19: {
                    int n18;
                    Field field2;
                    void var22_35;
                    boolean bl2;
                    Object object4;
                    block21: {
                        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType2;
                        boolean bl3;
                        block22: {
                            block20: {
                                void var22_37;
                                Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType3;
                                block18: {
                                    object4 = (Descriptors$FieldDescriptor)object.get(i10);
                                    bl2 = ((Descriptors$FieldDescriptor)object4).getFile().getOptions().getJavaStringCheckUtf8();
                                    Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType4 = ((Descriptors$FieldDescriptor)object4).getJavaType();
                                    if (descriptors$FieldDescriptor$JavaType4 == (descriptors$FieldDescriptor$JavaType3 = Descriptors$FieldDescriptor$JavaType.ENUM)) {
                                        DescriptorMessageInfoFactory$1 descriptorMessageInfoFactory$1;
                                        DescriptorMessageInfoFactory$1 descriptorMessageInfoFactory$12 = descriptorMessageInfoFactory$1 = new DescriptorMessageInfoFactory$1((Descriptors$FieldDescriptor)object4);
                                    } else {
                                        Object var22_34 = null;
                                    }
                                    Descriptors$OneofDescriptor descriptors$OneofDescriptor = ((Descriptors$FieldDescriptor)object4).getContainingOneof();
                                    if (descriptors$OneofDescriptor == null) break block18;
                                    object4 = DescriptorMessageInfoFactory.buildOneofMember((Class)serializable, (Descriptors$FieldDescriptor)object4, (DescriptorMessageInfoFactory$OneofState)object2, bl2, (Internal$EnumVerifier)var22_35);
                                    structuralMessageInfo$Builder.withField((FieldInfo)object4);
                                    break block19;
                                }
                                field2 = DescriptorMessageInfoFactory.field((Class)serializable, (Descriptors$FieldDescriptor)object4);
                                n18 = ((Descriptors$FieldDescriptor)object4).getNumber();
                                object3 = DescriptorMessageInfoFactory.getFieldType((Descriptors$FieldDescriptor)object4);
                                boolean bl4 = ((Descriptors$FieldDescriptor)object4).isMapField();
                                if (!bl4) break block20;
                                object3 = ((Descriptors$FieldDescriptor)object4).getMessageType();
                                bl2 = 2 != 0;
                                Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType5 = ((Descriptors$FieldDescriptor)(object3 = ((Descriptors$Descriptor)object3).findFieldByNumber((int)(bl2 ? 1 : 0)))).getJavaType();
                                if (descriptors$FieldDescriptor$JavaType5 == descriptors$FieldDescriptor$JavaType3) {
                                    DescriptorMessageInfoFactory$2 descriptorMessageInfoFactory$2 = new DescriptorMessageInfoFactory$2((Descriptors$FieldDescriptor)object3);
                                }
                                object3 = ((Descriptors$FieldDescriptor)object4).getName();
                                object3 = SchemaUtil.getMapDefaultEntry((Class)serializable, (String)object3);
                                object3 = FieldInfo.forMapField(field2, n18, object3, (Internal$EnumVerifier)var22_37);
                                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                                break block17;
                            }
                            bl3 = ((Descriptors$FieldDescriptor)object4).isRepeated();
                            if (!bl3) break block21;
                            if (var22_35 == null) break block22;
                            bl3 = ((Descriptors$FieldDescriptor)object4).isPacked();
                            if (bl3) {
                                object4 = DescriptorMessageInfoFactory.cachedSizeField((Class)serializable, (Descriptors$FieldDescriptor)object4);
                                object3 = FieldInfo.forPackedFieldWithEnumVerifier(field2, n18, (FieldType)((Object)object3), (Internal$EnumVerifier)var22_35, (Field)object4);
                                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                                break block17;
                            } else {
                                object3 = FieldInfo.forFieldWithEnumVerifier(field2, n18, (FieldType)((Object)object3), (Internal$EnumVerifier)var22_35);
                                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                            }
                            break block17;
                        }
                        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType6 = ((Descriptors$FieldDescriptor)object4).getJavaType();
                        if (descriptors$FieldDescriptor$JavaType6 == (descriptors$FieldDescriptor$JavaType2 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                            object4 = DescriptorMessageInfoFactory.getTypeForRepeatedMessageField((Class)serializable, (Descriptors$FieldDescriptor)object4);
                            object3 = FieldInfo.forRepeatedMessageField(field2, n18, (FieldType)((Object)object3), (Class)object4);
                            structuralMessageInfo$Builder.withField((FieldInfo)object3);
                            break block17;
                        } else {
                            bl3 = ((Descriptors$FieldDescriptor)object4).isPacked();
                            if (bl3) {
                                object4 = DescriptorMessageInfoFactory.cachedSizeField((Class)serializable, (Descriptors$FieldDescriptor)object4);
                                object3 = FieldInfo.forPackedField(field2, n18, (FieldType)((Object)object3), (Field)object4);
                                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                                break block17;
                            } else {
                                object3 = FieldInfo.forField(field2, n18, (FieldType)((Object)object3), bl2);
                                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                            }
                        }
                        break block17;
                    }
                    if (field == null) {
                        field = DescriptorMessageInfoFactory.bitField((Class)serializable, n16);
                    }
                    if ((n10 = (int)(((Descriptors$FieldDescriptor)object4).isRequired() ? 1 : 0)) != 0) {
                        object4 = field2;
                        Object object5 = object3;
                        object3 = FieldInfo.forProto2RequiredField(field2, n18, (FieldType)((Object)object3), field, n17, bl2, (Internal$EnumVerifier)var22_35);
                        structuralMessageInfo$Builder.withField((FieldInfo)object3);
                    } else {
                        object4 = field2;
                        Object object6 = object3;
                        object3 = FieldInfo.forProto2OptionalField(field2, n18, (FieldType)((Object)object3), field, n17, bl2, (Internal$EnumVerifier)var22_35);
                        structuralMessageInfo$Builder.withField((FieldInfo)object3);
                    }
                }
                if ((n17 <<= 1) == 0) {
                    ++n16;
                    n17 = n15;
                    field = null;
                }
            }
            n13 = 0;
            object3 = null;
        }
        serializable = new ArrayList();
        object2 = null;
        for (n12 = 0; n12 < (n13 = object.size()); ++n12) {
            Descriptors$Descriptor descriptors$Descriptor2;
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType7;
            object3 = (Descriptors$FieldDescriptor)object.get(n12);
            n15 = ((Descriptors$FieldDescriptor)object3).isRequired();
            if (n15 == 0 && ((descriptors$FieldDescriptor$JavaType7 = ((Descriptors$FieldDescriptor)object3).getJavaType()) != (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE) || (n15 = DescriptorMessageInfoFactory.needsIsInitializedCheck(descriptors$Descriptor2 = ((Descriptors$FieldDescriptor)object3).getMessageType())) == 0)) continue;
            n13 = ((Descriptors$FieldDescriptor)object3).getNumber();
            object3 = n13;
            serializable.add(object3);
        }
        int n19 = serializable.size();
        object = new int[n19];
        while (true) {
            if (n14 >= (n12 = serializable.size())) {
                structuralMessageInfo$Builder.withCheckInitialized((int[])object);
                return structuralMessageInfo$Builder.build();
            }
            object2 = (Integer)serializable.get(n14);
            n12 = (Integer)object2;
            object[n14] = n12;
            ++n14;
        }
    }

    private static StructuralMessageInfo convertProto3(Class clazz, Descriptors$Descriptor object) {
        int n10;
        object = ((Descriptors$Descriptor)object).getFields();
        int n11 = object.size();
        StructuralMessageInfo$Builder structuralMessageInfo$Builder = StructuralMessageInfo.newBuilder(n11);
        Object object2 = DescriptorMessageInfoFactory.getDefaultInstance(clazz);
        structuralMessageInfo$Builder.withDefaultInstance(object2);
        object2 = ProtoSyntax.PROTO3;
        structuralMessageInfo$Builder.withSyntax((ProtoSyntax)((Object)object2));
        object2 = new DescriptorMessageInfoFactory$OneofState(null);
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            Enum enum_;
            Object object3 = (Descriptors$FieldDescriptor)object.get(i10);
            Object object4 = ((Descriptors$FieldDescriptor)object3).getContainingOneof();
            int n12 = 1;
            if (object4 != null) {
                object3 = DescriptorMessageInfoFactory.buildOneofMember(clazz, (Descriptors$FieldDescriptor)object3, (DescriptorMessageInfoFactory$OneofState)object2, n12 != 0, null);
                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                continue;
            }
            boolean bl2 = ((Descriptors$FieldDescriptor)object3).isMapField();
            if (bl2) {
                object4 = DescriptorMessageInfoFactory.field(clazz, (Descriptors$FieldDescriptor)object3);
                n12 = ((Descriptors$FieldDescriptor)object3).getNumber();
                object3 = ((Descriptors$FieldDescriptor)object3).getName();
                object3 = SchemaUtil.getMapDefaultEntry(clazz, (String)object3);
                object3 = FieldInfo.forMapField((Field)object4, n12, object3, null);
                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                continue;
            }
            bl2 = ((Descriptors$FieldDescriptor)object3).isRepeated();
            if (bl2 && (object4 = ((Descriptors$FieldDescriptor)object3).getJavaType()) == (enum_ = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                object4 = DescriptorMessageInfoFactory.field(clazz, (Descriptors$FieldDescriptor)object3);
                n12 = ((Descriptors$FieldDescriptor)object3).getNumber();
                enum_ = DescriptorMessageInfoFactory.getFieldType((Descriptors$FieldDescriptor)object3);
                object3 = DescriptorMessageInfoFactory.getTypeForRepeatedMessageField(clazz, (Descriptors$FieldDescriptor)object3);
                object3 = FieldInfo.forRepeatedMessageField((Field)object4, n12, (FieldType)enum_, (Class)object3);
                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                continue;
            }
            bl2 = ((Descriptors$FieldDescriptor)object3).isPacked();
            if (bl2) {
                object4 = DescriptorMessageInfoFactory.field(clazz, (Descriptors$FieldDescriptor)object3);
                n12 = ((Descriptors$FieldDescriptor)object3).getNumber();
                enum_ = DescriptorMessageInfoFactory.getFieldType((Descriptors$FieldDescriptor)object3);
                object3 = DescriptorMessageInfoFactory.cachedSizeField(clazz, (Descriptors$FieldDescriptor)object3);
                object3 = FieldInfo.forPackedField((Field)object4, n12, (FieldType)enum_, (Field)object3);
                structuralMessageInfo$Builder.withField((FieldInfo)object3);
                continue;
            }
            object4 = DescriptorMessageInfoFactory.field(clazz, (Descriptors$FieldDescriptor)object3);
            int n13 = ((Descriptors$FieldDescriptor)object3).getNumber();
            object3 = DescriptorMessageInfoFactory.getFieldType((Descriptors$FieldDescriptor)object3);
            object3 = FieldInfo.forField((Field)object4, n13, (FieldType)((Object)object3), n12 != 0);
            structuralMessageInfo$Builder.withField((FieldInfo)object3);
        }
        return structuralMessageInfo$Builder.build();
    }

    private static Descriptors$Descriptor descriptorForType(Class clazz) {
        return DescriptorMessageInfoFactory.getDefaultInstance(clazz).getDescriptorForType();
    }

    private static Field field(Class clazz, Descriptors$FieldDescriptor object) {
        object = DescriptorMessageInfoFactory.getFieldName((Descriptors$FieldDescriptor)object);
        return DescriptorMessageInfoFactory.field(clazz, (String)object);
    }

    private static Field field(Class object, String string2) {
        try {
            return ((Class)object).getDeclaredField(string2);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to find field ");
            stringBuilder.append(string2);
            stringBuilder.append(" in message class ");
            object = ((Class)object).getName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
    }

    private static String getCachedSizeFieldName(Descriptors$FieldDescriptor object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = DescriptorMessageInfoFactory.snakeCaseToCamelCase(((Descriptors$FieldDescriptor)object).getName());
        stringBuilder.append((String)object);
        stringBuilder.append("MemoizedSerializedSize");
        return stringBuilder.toString();
    }

    private static Message getDefaultInstance(Class object) {
        Object object2;
        Object object3 = GET_DEFAULT_INSTANCE_METHOD_NAME;
        Object[] objectArray = null;
        try {
            object2 = new Class[]{};
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to get default instance for message class ");
            object = ((Class)object).getName();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            objectArray = new IllegalArgumentException((String)object, exception);
            throw objectArray;
        }
        object3 = ((Class)object).getDeclaredMethod((String)object3, (Class<?>)object2);
        object2 = null;
        objectArray = new Object[]{};
        object3 = ((Method)object3).invoke(null, objectArray);
        return (Message)object3;
    }

    public static String getFieldName(Descriptors$FieldDescriptor object) {
        Object object2;
        Object object3 = ((Descriptors$FieldDescriptor)object).getType();
        object = object3 == (object2 = Descriptors$FieldDescriptor$Type.GROUP) ? ((Descriptors$FieldDescriptor)object).getMessageType().getName() : ((Descriptors$FieldDescriptor)object).getName();
        object3 = specialFieldNames;
        boolean bl2 = object3.contains(object);
        object3 = bl2 ? "__" : "_";
        object2 = new StringBuilder();
        object = DescriptorMessageInfoFactory.snakeCaseToCamelCase((String)object);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append((String)object3);
        return ((StringBuilder)object2).toString();
    }

    private static FieldType getFieldType(Descriptors$FieldDescriptor object) {
        Object object2 = DescriptorMessageInfoFactory$3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
        Object object3 = object.getType();
        int n10 = ((Enum)object3).ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                object2 = new IllegalArgumentException;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Unsupported field type: ");
                object = object.getType();
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                object2((String)object);
                throw object2;
            }
            case 18: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.UINT64;
                }
                boolean bl2 = object.isPacked();
                object = bl2 ? FieldType.UINT64_LIST_PACKED : FieldType.UINT64_LIST;
                return object;
            }
            case 17: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.UINT32;
                }
                boolean bl3 = object.isPacked();
                object = bl3 ? FieldType.UINT32_LIST_PACKED : FieldType.UINT32_LIST;
                return object;
            }
            case 16: {
                boolean bl4 = object.isRepeated();
                object = bl4 ? FieldType.STRING_LIST : FieldType.STRING;
                return object;
            }
            case 15: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.SINT64;
                }
                boolean bl5 = object.isPacked();
                object = bl5 ? FieldType.SINT64_LIST_PACKED : FieldType.SINT64_LIST;
                return object;
            }
            case 14: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.SINT32;
                }
                boolean bl6 = object.isPacked();
                object = bl6 ? FieldType.SINT32_LIST_PACKED : FieldType.SINT32_LIST;
                return object;
            }
            case 13: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.SFIXED64;
                }
                boolean bl7 = object.isPacked();
                object = bl7 ? FieldType.SFIXED64_LIST_PACKED : FieldType.SFIXED64_LIST;
                return object;
            }
            case 12: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.SFIXED32;
                }
                boolean bl8 = object.isPacked();
                object = bl8 ? FieldType.SFIXED32_LIST_PACKED : FieldType.SFIXED32_LIST;
                return object;
            }
            case 11: {
                n11 = (int)(object.isMapField() ? 1 : 0);
                if (n11 != 0) {
                    return FieldType.MAP;
                }
                boolean bl9 = object.isRepeated();
                object = bl9 ? FieldType.MESSAGE_LIST : FieldType.MESSAGE;
                return object;
            }
            case 10: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.INT64;
                }
                boolean bl10 = object.isPacked();
                object = bl10 ? FieldType.INT64_LIST_PACKED : FieldType.INT64_LIST;
                return object;
            }
            case 9: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.INT32;
                }
                boolean bl11 = object.isPacked();
                object = bl11 ? FieldType.INT32_LIST_PACKED : FieldType.INT32_LIST;
                return object;
            }
            case 8: {
                boolean bl12 = object.isRepeated();
                object = bl12 ? FieldType.GROUP_LIST : FieldType.GROUP;
                return object;
            }
            case 7: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.FLOAT;
                }
                boolean bl13 = object.isPacked();
                object = bl13 ? FieldType.FLOAT_LIST_PACKED : FieldType.FLOAT_LIST;
                return object;
            }
            case 6: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.FIXED64;
                }
                boolean bl14 = object.isPacked();
                object = bl14 ? FieldType.FIXED64_LIST_PACKED : FieldType.FIXED64_LIST;
                return object;
            }
            case 5: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.FIXED32;
                }
                boolean bl15 = object.isPacked();
                object = bl15 ? FieldType.FIXED32_LIST_PACKED : FieldType.FIXED32_LIST;
                return object;
            }
            case 4: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.ENUM;
                }
                boolean bl16 = object.isPacked();
                object = bl16 ? FieldType.ENUM_LIST_PACKED : FieldType.ENUM_LIST;
                return object;
            }
            case 3: {
                n11 = (int)(object.isRepeated() ? 1 : 0);
                if (n11 == 0) {
                    return FieldType.DOUBLE;
                }
                boolean bl17 = object.isPacked();
                object = bl17 ? FieldType.DOUBLE_LIST_PACKED : FieldType.DOUBLE_LIST;
                return object;
            }
            case 2: {
                boolean bl18 = object.isRepeated();
                object = bl18 ? FieldType.BYTES_LIST : FieldType.BYTES;
                return object;
            }
            case 1: 
        }
        n11 = (int)(object.isRepeated() ? 1 : 0);
        if (n11 == 0) {
            return FieldType.BOOL;
        }
        boolean bl19 = object.isPacked();
        object = bl19 ? FieldType.BOOL_LIST_PACKED : FieldType.BOOL_LIST;
        return object;
    }

    public static DescriptorMessageInfoFactory getInstance() {
        return instance;
    }

    private static Class getOneofStoredType(Class serializable, Descriptors$FieldDescriptor object, FieldType fieldType) {
        int[] nArray = DescriptorMessageInfoFactory$3.$SwitchMap$com$google$protobuf$JavaType;
        JavaType javaType = fieldType.getJavaType();
        int n10 = javaType.ordinal();
        int n11 = nArray[n10];
        switch (n11) {
            default: {
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid type for oneof: ");
                ((StringBuilder)object).append((Object)fieldType);
                object = ((StringBuilder)object).toString();
                serializable = new IllegalArgumentException((String)object);
                throw serializable;
            }
            case 9: {
                return DescriptorMessageInfoFactory.getOneofStoredTypeForMessage(serializable, (Descriptors$FieldDescriptor)object);
            }
            case 8: {
                return String.class;
            }
            case 7: {
                return Long.class;
            }
            case 5: 
            case 6: {
                return Integer.class;
            }
            case 4: {
                return Float.class;
            }
            case 3: {
                return Double.class;
            }
            case 2: {
                return ByteString.class;
            }
            case 1: 
        }
        return Boolean.class;
    }

    private static Class getOneofStoredTypeForMessage(Class genericDeclaration, Descriptors$FieldDescriptor object) {
        Class[] classArray;
        block11: {
            block10: {
                try {
                    classArray = ((Descriptors$FieldDescriptor)object).getType();
                }
                catch (Exception exception) {
                    object = new RuntimeException(exception);
                    throw object;
                }
                Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.GROUP;
                if (classArray != descriptors$FieldDescriptor$Type) break block10;
                object = ((Descriptors$FieldDescriptor)object).getMessageType();
                object = ((Descriptors$Descriptor)object).getName();
                break block11;
            }
            object = ((Descriptors$FieldDescriptor)object).getName();
        }
        object = DescriptorMessageInfoFactory.getterForField((String)object);
        classArray = null;
        classArray = new Class[]{};
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod((String)object, classArray);
        return ((Method)genericDeclaration).getReturnType();
    }

    private static Class getTypeForRepeatedMessageField(Class genericDeclaration, Descriptors$FieldDescriptor object) {
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
        Class[] classArray;
        block13: {
            block12: {
                try {
                    classArray = ((Descriptors$FieldDescriptor)object).getType();
                }
                catch (Exception exception) {
                    object = new RuntimeException(exception);
                    throw object;
                }
                descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.GROUP;
                if (classArray != descriptors$FieldDescriptor$Type) break block12;
                object = ((Descriptors$FieldDescriptor)object).getMessageType();
                object = ((Descriptors$Descriptor)object).getName();
                break block13;
            }
            object = ((Descriptors$FieldDescriptor)object).getName();
        }
        object = DescriptorMessageInfoFactory.getterForField((String)object);
        int n10 = 1;
        classArray = new Class[n10];
        descriptors$FieldDescriptor$Type = null;
        Class<Integer> clazz = Integer.TYPE;
        classArray[0] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod((String)object, classArray);
        return ((Method)genericDeclaration).getReturnType();
    }

    private static String getterForField(String string2) {
        string2 = DescriptorMessageInfoFactory.snakeCaseToCamelCase(string2);
        StringBuilder stringBuilder = new StringBuilder("get");
        int n10 = Character.toUpperCase(string2.charAt(0));
        stringBuilder.append((char)n10);
        n10 = string2.length();
        string2 = string2.substring(1, n10);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static boolean needsIsInitializedCheck(Descriptors$Descriptor descriptors$Descriptor) {
        return isInitializedCheckAnalyzer.needsIsInitializedCheck(descriptors$Descriptor);
    }

    /*
     * Unable to fully structure code
     */
    private static String snakeCaseToCamelCase(String var0) {
        var2_2 = var0.length();
        var3_3 = '\u0001';
        var1_1 = new StringBuilder(var2_2 += var3_3);
        var2_2 = 0;
        var5_5 = '\u0000';
        block0: for (var4_4 = '\u0000'; var4_4 < (var6_6 = var0.length()); ++var4_4) {
            var6_6 = var0.charAt(var4_4);
            if (var6_6 == (var7_7 = '_')) lbl-1000:
            // 2 sources

            {
                while (true) {
                    var5_5 = var3_3;
                    continue block0;
                    break;
                }
            }
            var7_7 = (char)Character.isDigit(var6_6);
            if (var7_7 != '\u0000') {
                var1_1.append(var6_6);
                ** continue;
            }
            if (var5_5 != '\u0000') {
                var5_5 = Character.toUpperCase(var6_6);
                var1_1.append(var5_5);
                var5_5 = '\u0000';
                continue;
            }
            if (var4_4 == '\u0000') {
                var6_6 = Character.toLowerCase(var6_6);
                var1_1.append(var6_6);
                continue;
            }
            var1_1.append(var6_6);
        }
        return var1_1.toString();
    }

    public boolean isSupported(Class clazz) {
        return GeneratedMessageV3.class.isAssignableFrom(clazz);
    }

    public MessageInfo messageInfoFor(Class object) {
        Class<GeneratedMessageV3> clazz = GeneratedMessageV3.class;
        boolean bl2 = clazz.isAssignableFrom((Class<?>)object);
        if (bl2) {
            clazz = DescriptorMessageInfoFactory.descriptorForType((Class)object);
            return DescriptorMessageInfoFactory.convert((Class)object, (Descriptors$Descriptor)((Object)clazz));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported message type: ");
        object = ((Class)object).getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        clazz = new IllegalArgumentException((String)object);
        throw clazz;
    }
}

