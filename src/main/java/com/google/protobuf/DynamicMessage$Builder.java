/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage$1;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.UnknownFieldSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DynamicMessage$Builder
extends AbstractMessage$Builder {
    private FieldSet fields;
    private final Descriptors$FieldDescriptor[] oneofCases;
    private final Descriptors$Descriptor type;
    private UnknownFieldSet unknownFields;

    private DynamicMessage$Builder(Descriptors$Descriptor object) {
        this.type = object;
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = FieldSet.newFieldSet();
        this.fields = descriptors$FieldDescriptorArray;
        descriptors$FieldDescriptorArray = UnknownFieldSet.getDefaultInstance();
        this.unknownFields = descriptors$FieldDescriptorArray;
        int n10 = ((Descriptors$Descriptor)object).toProto().getOneofDeclCount();
        descriptors$FieldDescriptorArray = new Descriptors$FieldDescriptor[n10];
        this.oneofCases = descriptors$FieldDescriptorArray;
        object = ((Descriptors$Descriptor)object).getOptions();
        boolean bl2 = ((DescriptorProtos$MessageOptions)object).getMapEntry();
        if (bl2) {
            this.populateMapEntry();
        }
    }

    public /* synthetic */ DynamicMessage$Builder(Descriptors$Descriptor descriptors$Descriptor, DynamicMessage$1 dynamicMessage$1) {
        this(descriptors$Descriptor);
    }

    public static /* synthetic */ DynamicMessage access$000(DynamicMessage$Builder dynamicMessage$Builder) {
        return dynamicMessage$Builder.buildParsed();
    }

    private DynamicMessage buildParsed() {
        boolean bl2 = this.isInitialized();
        if (bl2) {
            return this.buildPartial();
        }
        Descriptors$Descriptor descriptors$Descriptor = this.type;
        FieldSet fieldSet = this.fields;
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$FieldDescriptorArray.length;
        descriptors$FieldDescriptorArray = Arrays.copyOf(descriptors$FieldDescriptorArray, n10);
        UnknownFieldSet unknownFieldSet = this.unknownFields;
        DynamicMessage dynamicMessage = new DynamicMessage(descriptors$Descriptor, fieldSet, descriptors$FieldDescriptorArray, unknownFieldSet);
        throw AbstractMessage$Builder.newUninitializedMessageException(dynamicMessage).asInvalidProtocolBufferException();
    }

    private void ensureEnumValueDescriptor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object iterator2) {
        boolean bl2 = descriptors$FieldDescriptor.isRepeated();
        if (bl2) {
            iterator2 = ((List)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                Object e10 = iterator2.next();
                this.ensureSingularEnumValueDescriptor(descriptors$FieldDescriptor, e10);
            }
        } else {
            this.ensureSingularEnumValueDescriptor(descriptors$FieldDescriptor, iterator2);
        }
    }

    private void ensureIsMutable() {
        FieldSet fieldSet = this.fields;
        boolean bl2 = fieldSet.isImmutable();
        if (bl2) {
            this.fields = fieldSet = this.fields.clone();
        }
    }

    private void ensureSingularEnumValueDescriptor(Descriptors$FieldDescriptor object, Object object2) {
        Internal.checkNotNull(object2);
        boolean bl2 = object2 instanceof Descriptors$EnumValueDescriptor;
        if (bl2) {
            return;
        }
        object = new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
        throw object;
    }

    private void populateMapEntry() {
        boolean bl2;
        Iterator iterator2 = this.type.getFields().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object;
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator2.next();
            Object object2 = descriptors$FieldDescriptor.getJavaType();
            if (object2 == (object = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                object2 = this.fields;
                object = DynamicMessage.getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
                ((FieldSet)object2).setField(descriptors$FieldDescriptor, object);
                continue;
            }
            object2 = this.fields;
            object = descriptors$FieldDescriptor.getDefaultValue();
            ((FieldSet)object2).setField(descriptors$FieldDescriptor, object);
        }
    }

    private void verifyContainingType(Descriptors$FieldDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor;
        if ((object = ((Descriptors$FieldDescriptor)object).getContainingType()) == (descriptors$Descriptor = this.type)) {
            return;
        }
        object = new IllegalArgumentException("FieldDescriptor does not match message type.");
        throw object;
    }

    private void verifyOneofContainingType(Descriptors$OneofDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor;
        if ((object = ((Descriptors$OneofDescriptor)object).getContainingType()) == (descriptors$Descriptor = this.type)) {
            return;
        }
        object = new IllegalArgumentException("OneofDescriptor does not match message type.");
        throw object;
    }

    public DynamicMessage$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        this.fields.addRepeatedField(descriptors$FieldDescriptor, object);
        return this;
    }

    public DynamicMessage build() {
        boolean bl2 = this.isInitialized();
        if (bl2) {
            return this.buildPartial();
        }
        Descriptors$Descriptor descriptors$Descriptor = this.type;
        FieldSet fieldSet = this.fields;
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$FieldDescriptorArray.length;
        descriptors$FieldDescriptorArray = Arrays.copyOf(descriptors$FieldDescriptorArray, n10);
        UnknownFieldSet unknownFieldSet = this.unknownFields;
        DynamicMessage dynamicMessage = new DynamicMessage(descriptors$Descriptor, fieldSet, descriptors$FieldDescriptorArray, unknownFieldSet);
        throw AbstractMessage$Builder.newUninitializedMessageException(dynamicMessage);
    }

    public DynamicMessage buildPartial() {
        this.fields.makeImmutable();
        Descriptors$Descriptor descriptors$Descriptor = this.type;
        FieldSet fieldSet = this.fields;
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$FieldDescriptorArray.length;
        descriptors$FieldDescriptorArray = Arrays.copyOf(descriptors$FieldDescriptorArray, n10);
        UnknownFieldSet unknownFieldSet = this.unknownFields;
        DynamicMessage dynamicMessage = new DynamicMessage(descriptors$Descriptor, fieldSet, descriptors$FieldDescriptorArray, unknownFieldSet);
        return dynamicMessage;
    }

    public DynamicMessage$Builder clear() {
        Object object = this.fields;
        boolean bl2 = ((FieldSet)object).isImmutable();
        if (bl2) {
            object = FieldSet.newFieldSet();
            this.fields = object;
        } else {
            object = this.fields;
            ((FieldSet)object).clear();
        }
        object = this.type.getOptions();
        bl2 = ((DescriptorProtos$MessageOptions)object).getMapEntry();
        if (bl2) {
            this.populateMapEntry();
        }
        this.unknownFields = object = UnknownFieldSet.getDefaultInstance();
        return this;
    }

    public DynamicMessage$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        int n10;
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray;
        Descriptors$FieldDescriptor descriptors$FieldDescriptor2;
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        Descriptors$OneofDescriptor descriptors$OneofDescriptor = descriptors$FieldDescriptor.getContainingOneof();
        if (descriptors$OneofDescriptor != null && (descriptors$FieldDescriptor2 = (descriptors$FieldDescriptorArray = this.oneofCases)[n10 = descriptors$OneofDescriptor.getIndex()]) == descriptors$FieldDescriptor) {
            descriptors$FieldDescriptor2 = null;
            descriptors$FieldDescriptorArray[n10] = null;
        }
        this.fields.clearField(descriptors$FieldDescriptor);
        return this;
    }

    public DynamicMessage$Builder clearOneof(Descriptors$OneofDescriptor descriptors$GenericDescriptor) {
        this.verifyOneofContainingType((Descriptors$OneofDescriptor)descriptors$GenericDescriptor);
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$GenericDescriptor.getIndex();
        descriptors$GenericDescriptor = descriptors$FieldDescriptorArray[n10];
        if (descriptors$GenericDescriptor != null) {
            this.clearField((Descriptors$FieldDescriptor)descriptors$GenericDescriptor);
        }
        return this;
    }

    public DynamicMessage$Builder clone() {
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.type;
        DynamicMessage$Builder dynamicMessage$Builder = new DynamicMessage$Builder((Descriptors$Descriptor)descriptors$FieldDescriptorArray);
        descriptors$FieldDescriptorArray = dynamicMessage$Builder.fields;
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray2 = this.fields;
        descriptors$FieldDescriptorArray.mergeFrom((FieldSet)descriptors$FieldDescriptorArray2);
        descriptors$FieldDescriptorArray = this.unknownFields;
        dynamicMessage$Builder.mergeUnknownFields((UnknownFieldSet)descriptors$FieldDescriptorArray);
        descriptors$FieldDescriptorArray = this.oneofCases;
        descriptors$FieldDescriptorArray2 = dynamicMessage$Builder.oneofCases;
        int n10 = descriptors$FieldDescriptorArray.length;
        System.arraycopy(descriptors$FieldDescriptorArray, 0, descriptors$FieldDescriptorArray2, 0, n10);
        return dynamicMessage$Builder;
    }

    public Map getAllFields() {
        return this.fields.getAllFields();
    }

    public DynamicMessage getDefaultInstanceForType() {
        return DynamicMessage.getDefaultInstance(this.type);
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return this.type;
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$GenericDescriptor) {
        this.verifyContainingType((Descriptors$FieldDescriptor)descriptors$GenericDescriptor);
        Object object = this.fields.getField((FieldSet$FieldDescriptorLite)((Object)descriptors$GenericDescriptor));
        if (object == null) {
            boolean bl2 = descriptors$GenericDescriptor.isRepeated();
            if (bl2) {
                object = Collections.emptyList();
            } else {
                Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
                object = descriptors$GenericDescriptor.getJavaType();
                if (object == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                    descriptors$GenericDescriptor = descriptors$GenericDescriptor.getMessageType();
                    object = DynamicMessage.getDefaultInstance((Descriptors$Descriptor)descriptors$GenericDescriptor);
                } else {
                    object = descriptors$GenericDescriptor.getDefaultValue();
                }
            }
        }
        return object;
    }

    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor object) {
        object = new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        throw object;
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$OneofDescriptor.getIndex();
        return descriptors$FieldDescriptorArray[n10];
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedField(descriptors$FieldDescriptor, n10);
    }

    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        throw object;
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.hasField(descriptors$FieldDescriptor);
    }

    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$GenericDescriptor) {
        this.verifyOneofContainingType((Descriptors$OneofDescriptor)descriptors$GenericDescriptor);
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$GenericDescriptor.getIndex();
        descriptors$GenericDescriptor = descriptors$FieldDescriptorArray[n10];
        return descriptors$GenericDescriptor != null;
    }

    public boolean isInitialized() {
        Descriptors$Descriptor descriptors$Descriptor = this.type;
        FieldSet fieldSet = this.fields;
        return DynamicMessage.isInitialized(descriptors$Descriptor, fieldSet);
    }

    public DynamicMessage$Builder mergeFrom(Message object) {
        int n10 = object instanceof DynamicMessage;
        if (n10 != 0) {
            Object object2;
            Object object3 = DynamicMessage.access$200((DynamicMessage)(object = (DynamicMessage)object));
            if (object3 == (object2 = this.type)) {
                int n11;
                this.ensureIsMutable();
                object3 = this.fields;
                object2 = DynamicMessage.access$300((DynamicMessage)object);
                ((FieldSet)object3).mergeFrom((FieldSet)object2);
                object3 = DynamicMessage.access$400((DynamicMessage)object);
                this.mergeUnknownFields((UnknownFieldSet)object3);
                object3 = null;
                for (n10 = 0; n10 < (n11 = ((Descriptors$FieldDescriptor[])(object2 = this.oneofCases)).length); ++n10) {
                    Descriptors$FieldDescriptor descriptors$FieldDescriptor = object2[n10];
                    if (descriptors$FieldDescriptor == null) {
                        object2[n10] = descriptors$FieldDescriptor = DynamicMessage.access$500((DynamicMessage)object)[n10];
                        continue;
                    }
                    object2 = DynamicMessage.access$500((DynamicMessage)object)[n10];
                    if (object2 == null || (object2 = this.oneofCases[n10]) == (descriptors$FieldDescriptor = DynamicMessage.access$500((DynamicMessage)object)[n10])) continue;
                    object2 = this.fields;
                    descriptors$FieldDescriptor = this.oneofCases[n10];
                    ((FieldSet)object2).clearField(descriptors$FieldDescriptor);
                    object2 = this.oneofCases;
                    descriptors$FieldDescriptor = DynamicMessage.access$500((DynamicMessage)object)[n10];
                    object2[n10] = descriptors$FieldDescriptor;
                }
                return this;
            }
            object = new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            throw object;
        }
        return (DynamicMessage$Builder)super.mergeFrom((Message)object);
    }

    public DynamicMessage$Builder mergeUnknownFields(UnknownFieldSet messageLite) {
        this.unknownFields = messageLite = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom((UnknownFieldSet)messageLite).build();
        return this;
    }

    public DynamicMessage$Builder newBuilderForField(Descriptors$FieldDescriptor object) {
        this.verifyContainingType((Descriptors$FieldDescriptor)object);
        Object object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE;
        if (object2 == descriptors$FieldDescriptor$JavaType) {
            object = ((Descriptors$FieldDescriptor)object).getMessageType();
            object2 = new DynamicMessage$Builder((Descriptors$Descriptor)object);
            return object2;
        }
        object = new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        throw object;
    }

    public DynamicMessage$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        Object object2 = descriptors$FieldDescriptor.getType();
        Object object3 = Descriptors$FieldDescriptor$Type.ENUM;
        if (object2 == object3) {
            this.ensureEnumValueDescriptor(descriptors$FieldDescriptor, object);
        }
        if ((object2 = descriptors$FieldDescriptor.getContainingOneof()) != null) {
            int n10 = ((Descriptors$OneofDescriptor)object2).getIndex();
            object3 = this.oneofCases[n10];
            if (object3 != null && object3 != descriptors$FieldDescriptor) {
                FieldSet fieldSet = this.fields;
                fieldSet.clearField((FieldSet$FieldDescriptorLite)object3);
            }
            object3 = this.oneofCases;
            object3[n10] = descriptors$FieldDescriptor;
        } else {
            boolean bl2;
            object2 = descriptors$FieldDescriptor.getFile().getSyntax();
            if (object2 == (object3 = Descriptors$FileDescriptor$Syntax.PROTO3) && !(bl2 = descriptors$FieldDescriptor.isRepeated()) && (object2 = descriptors$FieldDescriptor.getJavaType()) != (object3 = Descriptors$FieldDescriptor$JavaType.MESSAGE) && (bl2 = object.equals(object2 = descriptors$FieldDescriptor.getDefaultValue()))) {
                this.fields.clearField(descriptors$FieldDescriptor);
                return this;
            }
        }
        this.fields.setField(descriptors$FieldDescriptor, object);
        return this;
    }

    public DynamicMessage$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        this.ensureIsMutable();
        this.fields.setRepeatedField(descriptors$FieldDescriptor, n10, object);
        return this;
    }

    public DynamicMessage$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        this.unknownFields = unknownFieldSet;
        return this;
    }
}

