/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public final class Descriptors$FieldDescriptor
extends Descriptors$GenericDescriptor
implements Comparable,
FieldSet$FieldDescriptorLite {
    private static final WireFormat$FieldType[] table;
    private Descriptors$OneofDescriptor containingOneof;
    private Descriptors$Descriptor containingType;
    private Object defaultValue;
    private Descriptors$EnumDescriptor enumType;
    private final Descriptors$Descriptor extensionScope;
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final int index;
    private final String jsonName;
    private Descriptors$Descriptor messageType;
    private DescriptorProtos$FieldDescriptorProto proto;
    private Descriptors$FieldDescriptor$Type type;

    static {
        DescriptorProtos$FieldDescriptorProto$Type[] descriptorProtos$FieldDescriptorProto$TypeArray;
        int n10;
        table = WireFormat$FieldType.values();
        Object object = Descriptors$FieldDescriptor$Type.values();
        int n11 = ((Descriptors$FieldDescriptor$Type[])object).length;
        if (n11 == (n10 = (descriptorProtos$FieldDescriptorProto$TypeArray = DescriptorProtos$FieldDescriptorProto$Type.values()).length)) {
            return;
        }
        object = new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Descriptors$FieldDescriptor(DescriptorProtos$FieldDescriptorProto object, Descriptors$FileDescriptor object2, Descriptors$Descriptor object3, int n10, boolean n11) {
        super(null);
        this.index = n10;
        this.proto = object;
        Object object4 = ((DescriptorProtos$FieldDescriptorProto)object).getName();
        this.fullName = object4 = Descriptors.access$1700((Descriptors$FileDescriptor)object2, (Descriptors$Descriptor)object3, (String)object4);
        this.file = object2;
        n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasJsonName() ? 1 : 0);
        this.jsonName = n10 != 0 ? (object4 = ((DescriptorProtos$FieldDescriptorProto)object).getJsonName()) : (object4 = Descriptors$FieldDescriptor.fieldNameToJsonName(((DescriptorProtos$FieldDescriptorProto)object).getName()));
        n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasType() ? 1 : 0);
        if (n10 != 0) {
            object4 = Descriptors$FieldDescriptor$Type.valueOf(((DescriptorProtos$FieldDescriptorProto)object).getType());
            this.type = object4;
        }
        if ((n10 = this.getNumber()) <= 0) {
            object = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Field numbers must be positive integers.", null);
            throw object;
        }
        if (n11 != 0) {
            n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasExtendee() ? 1 : 0);
            if (n10 == 0) {
                object = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "FieldDescriptorProto.extendee not set for extension field.", null);
                throw object;
            }
            this.containingType = null;
            this.extensionScope = object3 != null ? object3 : null;
            boolean bl2 = ((DescriptorProtos$FieldDescriptorProto)object).hasOneofIndex();
            if (bl2) {
                object = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "FieldDescriptorProto.oneof_index set for extension field.", null);
                throw object;
            }
            this.containingOneof = null;
        } else {
            block10: {
                n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasExtendee() ? 1 : 0);
                if (n10 != 0) {
                    object = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "FieldDescriptorProto.extendee set for non-extension field.", null);
                    throw object;
                }
                this.containingType = object3;
                n10 = (int)(((DescriptorProtos$FieldDescriptorProto)object).hasOneofIndex() ? 1 : 0);
                if (n10 != 0) {
                    DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto;
                    n10 = ((DescriptorProtos$FieldDescriptorProto)object).getOneofIndex();
                    if (n10 >= 0 && (n10 = ((DescriptorProtos$FieldDescriptorProto)object).getOneofIndex()) < (n11 = (descriptorProtos$DescriptorProto = ((Descriptors$Descriptor)object3).toProto()).getOneofDeclCount())) {
                        object3 = ((Descriptors$Descriptor)object3).getOneofs();
                        int n12 = ((DescriptorProtos$FieldDescriptorProto)object).getOneofIndex();
                        this.containingOneof = object = (Descriptors$OneofDescriptor)object3.get(n12);
                        Descriptors$OneofDescriptor.access$2008((Descriptors$OneofDescriptor)object);
                        break block10;
                    } else {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("FieldDescriptorProto.oneof_index is out of range for type ");
                        object3 = ((Descriptors$Descriptor)object3).getName();
                        ((StringBuilder)object2).append((String)object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, (String)object2, null);
                        throw object;
                    }
                }
                this.containingOneof = null;
            }
            this.extensionScope = null;
        }
        Descriptors$FileDescriptor.access$1500((Descriptors$FileDescriptor)object2).addSymbol(this);
    }

    public /* synthetic */ Descriptors$FieldDescriptor(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n10, boolean bl2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$FieldDescriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n10, bl2);
    }

    public static /* synthetic */ void access$1000(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        descriptors$FieldDescriptor.crossLink();
    }

    public static /* synthetic */ void access$1400(Descriptors$FieldDescriptor descriptors$FieldDescriptor, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        descriptors$FieldDescriptor.setProto(descriptorProtos$FieldDescriptorProto);
    }

    /*
     * Exception decompiling
     */
    private void crossLink() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static String fieldNameToJsonName(String string2) {
        int n10 = string2.length();
        StringBuilder stringBuilder = new StringBuilder(n10);
        char c10 = '\u0000';
        for (int i10 = 0; i10 < n10; ++i10) {
            char c11;
            char c12 = string2.charAt(i10);
            if (c12 == (c11 = '_')) {
                c10 = '\u0001';
                continue;
            }
            if (c10 != '\u0000') {
                c10 = 'a';
                if (c10 <= c12 && c12 <= (c10 = 'z')) {
                    c12 = (char)(c12 + -97 + 65);
                }
                stringBuilder.append(c12);
                c10 = '\u0000';
                continue;
            }
            stringBuilder.append(c12);
        }
        return stringBuilder.toString();
    }

    private void setProto(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        this.proto = descriptorProtos$FieldDescriptorProto;
    }

    public int compareTo(Descriptors$FieldDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor = ((Descriptors$FieldDescriptor)object).containingType;
        Descriptors$Descriptor descriptors$Descriptor2 = this.containingType;
        if (descriptors$Descriptor == descriptors$Descriptor2) {
            int n10 = this.getNumber();
            int n11 = ((Descriptors$FieldDescriptor)object).getNumber();
            return n10 - n11;
        }
        object = new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        throw object;
    }

    public Descriptors$OneofDescriptor getContainingOneof() {
        return this.containingOneof;
    }

    public Descriptors$Descriptor getContainingType() {
        return this.containingType;
    }

    public Object getDefaultValue() {
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
        Object object = this.getJavaType();
        if (object != (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            return this.defaultValue;
        }
        object = new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        throw object;
    }

    public Descriptors$EnumDescriptor getEnumType() {
        Object object;
        Object object2 = this.getJavaType();
        if (object2 == (object = Descriptors$FieldDescriptor$JavaType.ENUM)) {
            return this.enumType;
        }
        object = new Object[1];
        String string2 = this.fullName;
        object[0] = string2;
        object = String.format("This field is not of enum type. (%s)", object);
        object2 = new UnsupportedOperationException((String)object);
        throw object2;
    }

    public Descriptors$Descriptor getExtensionScope() {
        boolean bl2 = this.isExtension();
        if (bl2) {
            return this.extensionScope;
        }
        Object object = new Object[1];
        String string2 = this.fullName;
        object[0] = string2;
        object = String.format("This field is not an extension. (%s)", object);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }

    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getIndex() {
        return this.index;
    }

    public Descriptors$FieldDescriptor$JavaType getJavaType() {
        return this.type.getJavaType();
    }

    public String getJsonName() {
        return this.jsonName;
    }

    public WireFormat$JavaType getLiteJavaType() {
        return this.getLiteType().getJavaType();
    }

    public WireFormat$FieldType getLiteType() {
        WireFormat$FieldType[] wireFormat$FieldTypeArray = table;
        int n10 = this.type.ordinal();
        return wireFormat$FieldTypeArray[n10];
    }

    public Descriptors$Descriptor getMessageType() {
        Object object;
        Object object2 = this.getJavaType();
        if (object2 == (object = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            return this.messageType;
        }
        object = new Object[1];
        String string2 = this.fullName;
        object[0] = string2;
        object = String.format("This field is not of message type. (%s)", object);
        object2 = new UnsupportedOperationException((String)object);
        throw object2;
    }

    public String getName() {
        return this.proto.getName();
    }

    public int getNumber() {
        return this.proto.getNumber();
    }

    public DescriptorProtos$FieldOptions getOptions() {
        return this.proto.getOptions();
    }

    public Descriptors$FieldDescriptor$Type getType() {
        return this.type;
    }

    public boolean hasDefaultValue() {
        return this.proto.hasDefaultValue();
    }

    public MessageLite$Builder internalMergeFrom(MessageLite$Builder messageLite$Builder, MessageLite messageLite) {
        messageLite$Builder = (Message$Builder)messageLite$Builder;
        messageLite = (Message)messageLite;
        return messageLite$Builder.mergeFrom((Message)messageLite);
    }

    public boolean isExtension() {
        return this.proto.hasExtendee();
    }

    public boolean isMapField() {
        boolean bl2;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
        Object object = this.getType();
        if (object == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.MESSAGE) && (bl2 = this.isRepeated()) && (bl2 = ((DescriptorProtos$MessageOptions)(object = this.getMessageType().getOptions())).getMapEntry())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isOptional() {
        boolean bl2;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label2 = this.proto.getLabel();
        if (descriptorProtos$FieldDescriptorProto$Label2 == (descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL)) {
            bl2 = true;
        } else {
            bl2 = false;
            descriptorProtos$FieldDescriptorProto$Label2 = null;
        }
        return bl2;
    }

    public boolean isPackable() {
        WireFormat$FieldType wireFormat$FieldType;
        boolean bl2 = this.isRepeated();
        if (bl2 && (bl2 = (wireFormat$FieldType = this.getLiteType()).isPackable())) {
            bl2 = true;
        } else {
            bl2 = false;
            wireFormat$FieldType = null;
        }
        return bl2;
    }

    public boolean isPacked() {
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax;
        boolean bl2 = this.isPackable();
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        Object object = this.getFile().getSyntax();
        if (object == (descriptors$FileDescriptor$Syntax = Descriptors$FileDescriptor$Syntax.PROTO2)) {
            return this.getOptions().getPacked();
        }
        object = this.getOptions();
        bl2 = ((DescriptorProtos$FieldOptions)object).hasPacked();
        if (!bl2 || (bl2 = ((DescriptorProtos$FieldOptions)(object = this.getOptions())).getPacked())) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean isRepeated() {
        boolean bl2;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label2 = this.proto.getLabel();
        if (descriptorProtos$FieldDescriptorProto$Label2 == (descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.LABEL_REPEATED)) {
            bl2 = true;
        } else {
            bl2 = false;
            descriptorProtos$FieldDescriptorProto$Label2 = null;
        }
        return bl2;
    }

    public boolean isRequired() {
        boolean bl2;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label2 = this.proto.getLabel();
        if (descriptorProtos$FieldDescriptorProto$Label2 == (descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.LABEL_REQUIRED)) {
            bl2 = true;
        } else {
            bl2 = false;
            descriptorProtos$FieldDescriptorProto$Label2 = null;
        }
        return bl2;
    }

    public boolean needsUtf8Check() {
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax;
        Object object = this.type;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.STRING;
        if (object != descriptors$FieldDescriptor$Type) {
            return false;
        }
        object = this.getContainingType().getOptions();
        boolean bl2 = ((DescriptorProtos$MessageOptions)object).getMapEntry();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        object = this.getFile().getSyntax();
        if (object == (descriptors$FileDescriptor$Syntax = Descriptors$FileDescriptor$Syntax.PROTO3)) {
            return bl3;
        }
        return this.getFile().getOptions().getJavaStringCheckUtf8();
    }

    public DescriptorProtos$FieldDescriptorProto toProto() {
        return this.proto;
    }

    public String toString() {
        return this.getFullName();
    }
}

