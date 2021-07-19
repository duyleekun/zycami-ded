/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage$ExtensionWriter;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;

public abstract class GeneratedMessageLite$ExtendableMessage
extends GeneratedMessageLite
implements GeneratedMessageLite$ExtendableMessageOrBuilder {
    public FieldSet extensions;

    public GeneratedMessageLite$ExtendableMessage() {
        FieldSet fieldSet;
        this.extensions = fieldSet = FieldSet.emptySet();
    }

    private void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension, ExtensionRegistryLite extensionRegistryLite, int n10) {
        int n11 = WireFormat.makeTag(n10, 2);
        this.parseExtension(codedInputStream, extensionRegistryLite, generatedMessageLite$GeneratedExtension, n11, n10);
    }

    private void mergeMessageSetExtensionFromBytes(ByteString object, ExtensionRegistryLite object2, GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        Object object3 = this.extensions;
        GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor = generatedMessageLite$GeneratedExtension.descriptor;
        if ((object3 = (object3 = (MessageLite)((FieldSet)object3).getField(generatedMessageLite$ExtensionDescriptor)) != null ? object3.toBuilder() : null) == null) {
            object3 = generatedMessageLite$GeneratedExtension.getMessageDefaultInstance().newBuilderForType();
        }
        object3.mergeFrom((ByteString)object, (ExtensionRegistryLite)object2);
        object = object3.build();
        object2 = this.ensureExtensionsAreMutable();
        object3 = generatedMessageLite$GeneratedExtension.descriptor;
        object = generatedMessageLite$GeneratedExtension.singularToFieldSetType(object);
        ((FieldSet)object2).setField((FieldSet$FieldDescriptorLite)object3, object);
    }

    private void mergeMessageSetExtensionFromCodedStream(MessageLite messageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        int n10;
        int n11 = 0;
        ByteString byteString = null;
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = null;
        while ((n10 = codedInputStream.readTag()) != 0) {
            int n12 = WireFormat.MESSAGE_SET_TYPE_ID_TAG;
            if (n10 == n12) {
                n11 = codedInputStream.readUInt32();
                if (n11 == 0) continue;
                generatedMessageLite$GeneratedExtension = extensionRegistryLite.findLiteExtensionByNumber(messageLite, n11);
                continue;
            }
            n12 = WireFormat.MESSAGE_SET_MESSAGE_TAG;
            if (n10 == n12) {
                if (n11 != 0 && generatedMessageLite$GeneratedExtension != null) {
                    this.eagerlyMergeMessageSetExtension(codedInputStream, generatedMessageLite$GeneratedExtension, extensionRegistryLite, n11);
                    byteString = null;
                    continue;
                }
                byteString = codedInputStream.readBytes();
                continue;
            }
            if ((n10 = (int)(codedInputStream.skipField(n10) ? 1 : 0)) != 0) continue;
        }
        int n13 = WireFormat.MESSAGE_SET_ITEM_END_TAG;
        codedInputStream.checkLastTagWas(n13);
        if (byteString != null && n11 != 0) {
            if (generatedMessageLite$GeneratedExtension != null) {
                this.mergeMessageSetExtensionFromBytes(byteString, extensionRegistryLite, generatedMessageLite$GeneratedExtension);
            } else if (byteString != null) {
                this.mergeLengthDelimitedField(n11, byteString);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean parseExtension(CodedInputStream var1_1, ExtensionRegistryLite var2_2, GeneratedMessageLite$GeneratedExtension var3_3, int var4_4, int var5_5) {
        var6_6 = WireFormat.getTagWireType(var4_4);
        var7_7 = 1;
        if (var3_3 == null) {
            while (true) {
                var8_8 = 0;
                var9_9 /* !! */  = null;
                var6_6 = var7_7;
                break;
            }
        } else {
            var9_9 /* !! */  = var3_3.descriptor.getLiteType();
            var8_8 = FieldSet.getWireFormatForFieldType(var9_9 /* !! */ , false);
            if (var6_6 == var8_8) {
                var6_6 = 0;
                var10_11 /* !! */  = null;
                var8_8 = 0;
                var9_9 /* !! */  = null;
            } else {
                var9_9 /* !! */  = var3_3.descriptor;
                if (!(var11_10 = var9_9 /* !! */ .isRepeated) || !(var8_8 = (int)(var9_9 /* !! */  = var9_9 /* !! */ .type).isPackable()) || var6_6 != (var8_8 = FieldSet.getWireFormatForFieldType(var9_9 /* !! */  = var3_3.descriptor.getLiteType(), (boolean)var7_7))) ** continue;
                var6_6 = 0;
                var10_11 /* !! */  = null;
                var8_8 = var7_7;
            }
        }
        if (var6_6) {
            return this.parseUnknownField(var4_4, (CodedInputStream)var1_1);
        }
        this.ensureExtensionsAreMutable();
        if (var8_8) {
            var12_12 = var1_1.readRawVarint32();
            var12_12 = var1_1.pushLimit(var12_12);
            var13_14 /* !! */  = var3_3.descriptor.getLiteType();
            if (var13_14 /* !! */  == (var14_16 = WireFormat$FieldType.ENUM)) {
                while ((var4_4 = var1_1.getBytesUntilLimit()) > 0) {
                    var4_4 = var1_1.readEnum();
                    var14_16 = var3_3.descriptor.getEnumType();
                    var13_14 /* !! */  = var14_16.findValueByNumber(var4_4);
                    if (var13_14 /* !! */  == null) {
                        return (boolean)var7_7;
                    }
                    var14_16 = this.extensions;
                    var10_11 /* !! */  = var3_3.descriptor;
                    var13_14 /* !! */  = var3_3.singularToFieldSetType((Object)var13_14 /* !! */ );
                    var14_16.addRepeatedField((FieldSet$FieldDescriptorLite)var10_11 /* !! */ , (Object)var13_14 /* !! */ );
                }
            } else {
                while ((var4_4 = var1_1.getBytesUntilLimit()) > 0) {
                    var13_14 /* !! */  = var3_3.descriptor.getLiteType();
                    var13_14 /* !! */  = FieldSet.readPrimitiveField((CodedInputStream)var1_1, var13_14 /* !! */ , false);
                    var14_16 = this.extensions;
                    var10_11 /* !! */  = var3_3.descriptor;
                    var14_16.addRepeatedField((FieldSet$FieldDescriptorLite)var10_11 /* !! */ , (Object)var13_14 /* !! */ );
                }
            }
            var1_1.popLimit(var12_12);
        } else {
            var13_15 /* !! */  = GeneratedMessageLite$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType;
            var10_11 /* !! */  = var3_3.descriptor.getLiteJavaType();
            var6_6 = var10_11 /* !! */ .ordinal();
            var4_4 = var13_15 /* !! */ [var6_6];
            if (var4_4 != var7_7) {
                var12_13 = 2;
                if (var4_4 != var12_13) {
                    var2_2 = var3_3.descriptor.getLiteType();
                    var1_1 = FieldSet.readPrimitiveField((CodedInputStream)var1_1, (WireFormat$FieldType)var2_2, false);
                } else {
                    var15_18 = var1_1.readEnum();
                    var2_2 = var3_3.descriptor.getEnumType().findValueByNumber(var15_18);
                    if (var2_2 == null) {
                        this.mergeVarintField(var5_5, var15_18);
                        return (boolean)var7_7;
                    }
                    var1_1 = var2_2;
                }
            } else {
                var4_4 = 0;
                var13_15 /* !! */  = null;
                var14_17 = var3_3.descriptor;
                var5_5 = (int)var14_17.isRepeated();
                if (var5_5 == 0) {
                    var14_17 = this.extensions;
                    var10_11 /* !! */  = var3_3.descriptor;
                    if ((var14_17 = (MessageLite)var14_17.getField((FieldSet$FieldDescriptorLite)var10_11 /* !! */ )) != null) {
                        var13_15 /* !! */  = (int[])var14_17.toBuilder();
                    }
                }
                if (var13_15 /* !! */  == null) {
                    var13_15 /* !! */  = (int[])var3_3.getMessageDefaultInstance().newBuilderForType();
                }
                if ((var14_17 = var3_3.descriptor.getLiteType()) == (var10_11 /* !! */  = WireFormat$FieldType.GROUP)) {
                    var5_5 = var3_3.getNumber();
                    var1_1.readGroup(var5_5, (MessageLite$Builder)var13_15 /* !! */ , (ExtensionRegistryLite)var2_2);
                } else {
                    var1_1.readMessage((MessageLite$Builder)var13_15 /* !! */ , (ExtensionRegistryLite)var2_2);
                }
                var1_1 = var13_15 /* !! */ .build();
            }
            var2_2 = var3_3.descriptor;
            var12_13 = (int)var2_2.isRepeated();
            if (var12_13 != 0) {
                var2_2 = this.extensions;
                var13_15 /* !! */  = (int[])var3_3.descriptor;
                var1_1 = var3_3.singularToFieldSetType(var1_1);
                var2_2.addRepeatedField((FieldSet$FieldDescriptorLite)var13_15 /* !! */ , var1_1);
            } else {
                var2_2 = this.extensions;
                var13_15 /* !! */  = (int[])var3_3.descriptor;
                var1_1 = var3_3.singularToFieldSetType(var1_1);
                var2_2.setField((FieldSet$FieldDescriptorLite)var13_15 /* !! */ , var1_1);
            }
        }
        return (boolean)var7_7;
    }

    private void verifyExtensionContainingType(GeneratedMessageLite$GeneratedExtension object) {
        GeneratedMessageLite generatedMessageLite;
        if ((object = ((GeneratedMessageLite$GeneratedExtension)object).getContainingTypeDefaultInstance()) == (generatedMessageLite = ((GeneratedMessageLite)this).getDefaultInstanceForType())) {
            return;
        }
        object = new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        throw object;
    }

    public FieldSet ensureExtensionsAreMutable() {
        FieldSet fieldSet = this.extensions;
        boolean bl2 = fieldSet.isImmutable();
        if (bl2) {
            this.extensions = fieldSet = this.extensions.clone();
        }
        return this.extensions;
    }

    public boolean extensionsAreInitialized() {
        return this.extensions.isInitialized();
    }

    public int extensionsSerializedSize() {
        return this.extensions.getSerializedSize();
    }

    public int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.getMessageSetSerializedSize();
    }

    public final Object getExtension(ExtensionLite extensionLite) {
        extensionLite = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType((GeneratedMessageLite$GeneratedExtension)extensionLite);
        Object object = this.extensions;
        GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor = ((GeneratedMessageLite$GeneratedExtension)extensionLite).descriptor;
        object = ((FieldSet)object).getField(generatedMessageLite$ExtensionDescriptor);
        if (object == null) {
            return ((GeneratedMessageLite$GeneratedExtension)extensionLite).defaultValue;
        }
        return ((GeneratedMessageLite$GeneratedExtension)extensionLite).fromFieldSetType(object);
    }

    public final Object getExtension(ExtensionLite extensionLite, int n10) {
        extensionLite = GeneratedMessageLite.access$000(extensionLite);
        this.verifyExtensionContainingType((GeneratedMessageLite$GeneratedExtension)extensionLite);
        FieldSet fieldSet = this.extensions;
        GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor = ((GeneratedMessageLite$GeneratedExtension)extensionLite).descriptor;
        Object object = fieldSet.getRepeatedField(generatedMessageLite$ExtensionDescriptor, n10);
        return ((GeneratedMessageLite$GeneratedExtension)extensionLite).singularFromFieldSetType(object);
    }

    public final int getExtensionCount(ExtensionLite object) {
        object = GeneratedMessageLite.access$000((ExtensionLite)object);
        this.verifyExtensionContainingType((GeneratedMessageLite$GeneratedExtension)object);
        FieldSet fieldSet = this.extensions;
        object = ((GeneratedMessageLite$GeneratedExtension)object).descriptor;
        return fieldSet.getRepeatedFieldCount((FieldSet$FieldDescriptorLite)object);
    }

    public final boolean hasExtension(ExtensionLite object) {
        object = GeneratedMessageLite.access$000((ExtensionLite)object);
        this.verifyExtensionContainingType((GeneratedMessageLite$GeneratedExtension)object);
        FieldSet fieldSet = this.extensions;
        object = ((GeneratedMessageLite$GeneratedExtension)object).descriptor;
        return fieldSet.hasField((FieldSet$FieldDescriptorLite)object);
    }

    public final void mergeExtensionFields(GeneratedMessageLite$ExtendableMessage object) {
        FieldSet fieldSet = this.extensions;
        boolean bl2 = fieldSet.isImmutable();
        if (bl2) {
            this.extensions = fieldSet = this.extensions.clone();
        }
        fieldSet = this.extensions;
        object = ((GeneratedMessageLite$ExtendableMessage)object).extensions;
        fieldSet.mergeFrom((FieldSet)object);
    }

    public GeneratedMessageLite$ExtendableMessage$ExtensionWriter newExtensionWriter() {
        GeneratedMessageLite$ExtendableMessage$ExtensionWriter generatedMessageLite$ExtendableMessage$ExtensionWriter = new GeneratedMessageLite$ExtendableMessage$ExtensionWriter(this, false, null);
        return generatedMessageLite$ExtendableMessage$ExtensionWriter;
    }

    public GeneratedMessageLite$ExtendableMessage$ExtensionWriter newMessageSetExtensionWriter() {
        GeneratedMessageLite$ExtendableMessage$ExtensionWriter generatedMessageLite$ExtendableMessage$ExtensionWriter = new GeneratedMessageLite$ExtendableMessage$ExtensionWriter(this, true, null);
        return generatedMessageLite$ExtendableMessage$ExtensionWriter;
    }

    public boolean parseUnknownField(MessageLite messageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int n10) {
        int n11 = WireFormat.getTagFieldNumber(n10);
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = extensionRegistryLite.findLiteExtensionByNumber(messageLite, n11);
        return this.parseExtension(codedInputStream, extensionRegistryLite, generatedMessageLite$GeneratedExtension, n10, n11);
    }

    public boolean parseUnknownFieldAsMessageSet(MessageLite messageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int n10) {
        int n11;
        int n12 = WireFormat.MESSAGE_SET_ITEM_TAG;
        if (n10 == n12) {
            this.mergeMessageSetExtensionFromCodedStream(messageLite, codedInputStream, extensionRegistryLite);
            return true;
        }
        n12 = WireFormat.getTagWireType(n10);
        if (n12 == (n11 = 2)) {
            return this.parseUnknownField(messageLite, codedInputStream, extensionRegistryLite, n10);
        }
        return codedInputStream.skipField(n10);
    }
}

