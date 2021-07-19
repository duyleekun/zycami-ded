/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
import com.google.protobuf.Type$1;
import com.google.protobuf.Type$Builder;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Type
extends GeneratedMessageV3
implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static final Parser PARSER;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private static final long serialVersionUID;
    private List fields_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private LazyStringList oneofs_;
    private List options_;
    private SourceContext sourceContext_;
    private int syntax_;

    static {
        Object object = new Type();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Type$1();
    }

    private Type() {
        List list;
        this.name_ = "";
        this.fields_ = list = Collections.emptyList();
        this.oneofs_ = list = LazyStringArrayList.EMPTY;
        list = Collections.emptyList();
        this.options_ = list;
        this.syntax_ = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Type(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block24: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            Object object;
                            int n14 = 10;
                            if (n13 != n14) {
                                Object object2;
                                n14 = 18;
                                if (n13 != n14) {
                                    n14 = 26;
                                    if (n13 != n14) {
                                        n14 = 34;
                                        if (n13 != n14) {
                                            n14 = 42;
                                            if (n13 != n14) {
                                                n14 = 48;
                                                if (n13 != n14) {
                                                    if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                                    break block24;
                                                } else {
                                                    this.syntax_ = n13 = ((CodedInputStream)((Object)list)).readEnum();
                                                    continue;
                                                }
                                            }
                                            n13 = 0;
                                            object = null;
                                            object2 = this.sourceContext_;
                                            if (object2 != null) {
                                                object = ((SourceContext)object2).toBuilder();
                                            }
                                            object2 = SourceContext.parser();
                                            object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                            this.sourceContext_ = object2 = (SourceContext)object2;
                                            if (object == null) continue;
                                            ((SourceContext$Builder)object).mergeFrom((SourceContext)object2);
                                            this.sourceContext_ = object = ((SourceContext$Builder)object).buildPartial();
                                            continue;
                                        }
                                        n13 = n11 & 4;
                                        if (n13 == 0) {
                                            object = new ArrayList();
                                            this.options_ = object;
                                            n11 |= 4;
                                        }
                                        object = this.options_;
                                        object2 = Option.parser();
                                        object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                        object.add(object2);
                                        continue;
                                    }
                                    object = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                                    n12 = n11 & 2;
                                    if (n12 == 0) {
                                        this.oneofs_ = object2 = new LazyStringArrayList();
                                        n11 |= 2;
                                    }
                                    object2 = this.oneofs_;
                                    object2.add(object);
                                    continue;
                                }
                                n13 = n11 & 1;
                                if (n13 == 0) {
                                    object = new ArrayList();
                                    this.fields_ = object;
                                    n11 |= 1;
                                }
                                object = this.fields_;
                                object2 = Field.parser();
                                object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                object.add(object2);
                                continue;
                            }
                            this.name_ = object = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                            continue;
                        }
                    }
                    n10 = n12;
                    continue;
                }
                catch (IOException iOException) {
                    list2 = new List(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)((Object)list2)).setUnfinishedMessage(this);
                    throw invalidProtocolBufferException;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                    throw invalidProtocolBufferException2;
                }
            }
            catch (Throwable throwable) {}
            int n15 = n11 & 1;
            if (n15 != 0) {
                list2 = Collections.unmodifiableList(this.fields_);
                this.fields_ = list2;
            }
            if ((n15 = n11 & 2) != 0) {
                list2 = this.oneofs_.getUnmodifiableView();
                this.oneofs_ = list2;
            }
            if ((n15 = n11 & 4) != 0) {
                this.options_ = list2 = Collections.unmodifiableList(this.options_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n16 = n11 & 1;
        if (n16 != 0) {
            list = Collections.unmodifiableList(this.fields_);
            this.fields_ = list;
        }
        if ((n16 = n11 & 2) != 0) {
            list = this.oneofs_.getUnmodifiableView();
            this.oneofs_ = list;
        }
        if ((n16 = n11 & 4) != 0) {
            this.options_ = list = Collections.unmodifiableList(this.options_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Type$1 type$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Type(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Type(GeneratedMessageV3$Builder generatedMessageV3$Builder, Type$1 type$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(Type type) {
        return type.name_;
    }

    public static /* synthetic */ Object access$302(Type type, Object object) {
        type.name_ = object;
        return object;
    }

    public static /* synthetic */ List access$400(Type type) {
        return type.fields_;
    }

    public static /* synthetic */ List access$402(Type type, List list) {
        type.fields_ = list;
        return list;
    }

    public static /* synthetic */ LazyStringList access$500(Type type) {
        return type.oneofs_;
    }

    public static /* synthetic */ LazyStringList access$502(Type type, LazyStringList lazyStringList) {
        type.oneofs_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ List access$600(Type type) {
        return type.options_;
    }

    public static /* synthetic */ List access$602(Type type, List list) {
        type.options_ = list;
        return list;
    }

    public static /* synthetic */ SourceContext access$702(Type type, SourceContext sourceContext) {
        type.sourceContext_ = sourceContext;
        return sourceContext;
    }

    public static /* synthetic */ int access$800(Type type) {
        return type.syntax_;
    }

    public static /* synthetic */ int access$802(Type type, int n10) {
        type.syntax_ = n10;
        return n10;
    }

    public static /* synthetic */ Parser access$900() {
        return PARSER;
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    public static Type$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Type$Builder newBuilder(Type type) {
        return ((Type$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(type);
    }

    public static Type parseDelimitedFrom(InputStream inputStream) {
        return (Type)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(ByteString byteString) {
        return (Type)PARSER.parseFrom(byteString);
    }

    public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Type parseFrom(CodedInputStream codedInputStream) {
        return (Type)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Type parseFrom(InputStream inputStream) {
        return (Type)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(ByteBuffer byteBuffer) {
        return (Type)PARSER.parseFrom(byteBuffer);
    }

    public static Type parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Type parseFrom(byte[] byArray) {
        return (Type)PARSER.parseFrom(byArray);
    }

    public static Type parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Type)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        int n10;
        Object object2;
        boolean bl22 = true;
        if (object == this) {
            return bl22;
        }
        boolean n11 = object instanceof Type;
        if (!n11) {
            return super.equals(object);
        }
        object = (Type)object;
        Object object3 = this.getName();
        String string2 = ((Type)object).getName();
        boolean bl3 = ((String)object3).equals(string2);
        string2 = null;
        if (!bl3) {
            return false;
        }
        object3 = this.getFieldsList();
        boolean bl4 = object3.equals(object2 = ((Type)object).getFieldsList());
        if (!bl4) {
            return false;
        }
        object3 = this.getOneofsList();
        boolean bl5 = object3.equals(object2 = ((Type)object).getOneofsList());
        if (!bl5) {
            return false;
        }
        object3 = this.getOptionsList();
        boolean bl6 = object3.equals(object2 = ((Type)object).getOptionsList());
        if (!bl6) {
            return false;
        }
        int n12 = this.hasSourceContext();
        if (n12 != (n10 = ((Type)object).hasSourceContext())) {
            return false;
        }
        boolean bl7 = this.hasSourceContext();
        if (bl7 && !(bl2 = ((SourceContext)(object3 = this.getSourceContext())).equals(object2 = ((Type)object).getSourceContext()))) {
            return false;
        }
        int n13 = this.syntax_;
        n10 = ((Type)object).syntax_;
        if (n13 != n10) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl8 = ((UnknownFieldSet)object3).equals(object);
        if (!bl8) {
            return false;
        }
        return bl22;
    }

    public Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Field getFields(int n10) {
        return (Field)this.fields_.get(n10);
    }

    public int getFieldsCount() {
        return this.fields_.size();
    }

    public List getFieldsList() {
        return this.fields_;
    }

    public FieldOrBuilder getFieldsOrBuilder(int n10) {
        return (FieldOrBuilder)this.fields_.get(n10);
    }

    public List getFieldsOrBuilderList() {
        return this.fields_;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.name_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getNameBytes() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.name_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getOneofs(int n10) {
        return (String)this.oneofs_.get(n10);
    }

    public ByteString getOneofsBytes(int n10) {
        return this.oneofs_.getByteString(n10);
    }

    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    public ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }

    public Option getOptions(int n10) {
        return (Option)this.options_.get(n10);
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int n10) {
        return (OptionOrBuilder)this.options_.get(n10);
    }

    public List getOptionsOrBuilderList() {
        return this.options_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10;
        Object object2;
        List list;
        int n11;
        int n12;
        int n13 = this.memoizedSize;
        int n14 = -1;
        if (n13 != n14) {
            return n13;
        }
        Object object3 = this.getNameBytes();
        n13 = (int)(((ByteString)object3).isEmpty() ? 1 : 0);
        n14 = 1;
        int n15 = 0;
        Object object4 = null;
        if (n13 == 0) {
            object3 = this.name_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object3) + 0;
        } else {
            n13 = 0;
            object3 = null;
        }
        Object object5 = null;
        for (n12 = 0; n12 < (n11 = (list = this.fields_).size()); ++n12) {
            object2 = (MessageLite)this.fields_.get(n12);
            n11 = CodedOutputStream.computeMessageSize(2, (MessageLite)object2);
            n13 += n11;
        }
        object5 = null;
        n11 = 0;
        list = null;
        for (n12 = 0; n12 < (n10 = (object2 = this.oneofs_).size()); ++n12) {
            object2 = this.oneofs_.getRaw(n12);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object2);
            n11 += n10;
        }
        n13 += n11;
        object5 = this.getOneofsList();
        n12 = object5.size() * n14;
        n13 += n12;
        while (n15 < (n14 = (object = this.options_).size())) {
            object5 = (MessageLite)this.options_.get(n15);
            n14 = CodedOutputStream.computeMessageSize(4, (MessageLite)object5);
            n13 += n14;
            ++n15;
        }
        object = this.sourceContext_;
        if (object != null) {
            object4 = this.getSourceContext();
            n14 = CodedOutputStream.computeMessageSize(5, (MessageLite)object4);
            n13 += n14;
        }
        if ((n14 = this.syntax_) != (n15 = ((Syntax)(object4 = Syntax.SYNTAX_PROTO2)).getNumber())) {
            n15 = this.syntax_;
            n14 = CodedOutputStream.computeEnumSize(6, n15);
            n13 += n14;
        }
        n14 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n13 += n14;
        return n13;
    }

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        if (sourceContext == null) {
            sourceContext = SourceContext.getDefaultInstance();
        }
        return sourceContext;
    }

    public SourceContextOrBuilder getSourceContextOrBuilder() {
        return this.getSourceContext();
    }

    public Syntax getSyntax() {
        int n10 = this.syntax_;
        Syntax syntax = Syntax.valueOf(n10);
        if (syntax == null) {
            syntax = Syntax.UNRECOGNIZED;
        }
        return syntax;
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasSourceContext() {
        boolean bl2;
        SourceContext sourceContext = this.sourceContext_;
        if (sourceContext != null) {
            bl2 = true;
        } else {
            bl2 = false;
            sourceContext = null;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Type.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        Object object = this.getName();
        n11 = ((String)object).hashCode();
        n10 += n11;
        n11 = this.getFieldsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getFieldsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getOneofsCount()) > 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOneofsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getOptionsCount()) > 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getOptionsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSourceContext() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getSourceContext();
            n11 = ((SourceContext)object).hashCode();
            n10 += n11;
        }
        n10 = (n10 * 37 + 6) * 53;
        n11 = this.syntax_;
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Type$Builder newBuilderForType() {
        return Type.newBuilder();
    }

    public Type$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Type$Builder type$Builder = new Type$Builder(generatedMessageV3$BuilderParent, null);
        return type$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Type();
        return object;
    }

    public Type$Builder toBuilder() {
        TypeOrBuilder typeOrBuilder = DEFAULT_INSTANCE;
        if (this == typeOrBuilder) {
            typeOrBuilder = new Type$Builder(null);
        } else {
            typeOrBuilder = new Type$Builder(null);
            typeOrBuilder = ((Type$Builder)typeOrBuilder).mergeFrom(this);
        }
        return typeOrBuilder;
    }

    /*
     * WARNING - void declaration
     */
    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        void var3_5;
        Object object;
        Object object2;
        int n11;
        int n12;
        Object object3 = this.getNameBytes();
        boolean n122 = ((ByteString)object3).isEmpty();
        if (!n122) {
            object3 = this.name_;
            n12 = 1;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        boolean bl2 = false;
        object3 = null;
        Object object4 = null;
        for (n12 = 0; n12 < (n11 = (object2 = this.fields_).size()); ++n12) {
            n11 = 2;
            object = (MessageLite)this.fields_.get(n12);
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        object4 = null;
        for (n12 = 0; n12 < (n11 = (object2 = this.oneofs_).size()); ++n12) {
            n11 = 3;
            object = this.oneofs_.getRaw(n12);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        while (++var3_5 < (n12 = (object4 = this.options_).size())) {
            n12 = 4;
            object2 = (MessageLite)this.options_.get((int)var3_5);
            codedOutputStream.writeMessage(n12, (MessageLite)object2);
        }
        object3 = this.sourceContext_;
        if (object3 != null) {
            int n13 = 5;
            object4 = this.getSourceContext();
            codedOutputStream.writeMessage(n13, (MessageLite)object4);
        }
        if ((n10 = this.syntax_) != (n12 = ((Syntax)(object4 = Syntax.SYNTAX_PROTO2)).getNumber())) {
            int n14 = 6;
            n12 = this.syntax_;
            codedOutputStream.writeEnum(n14, n12);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

