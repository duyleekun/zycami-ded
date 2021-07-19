/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Enum$1;
import com.google.protobuf.Enum$Builder;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
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

public final class Enum
extends GeneratedMessageV3
implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser PARSER;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private static final long serialVersionUID;
    private List enumvalue_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private List options_;
    private SourceContext sourceContext_;
    private int syntax_;

    static {
        Object object = new Enum();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Enum$1();
    }

    private Enum() {
        List list;
        this.name_ = "";
        this.enumvalue_ = list = Collections.emptyList();
        this.options_ = list = Collections.emptyList();
        this.syntax_ = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Enum(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        boolean bl2 = false;
        int n10 = 0;
        while (!bl2) {
            try {
                try {
                    boolean bl3;
                    block20: {
                        int n11 = ((CodedInputStream)((Object)list)).readTag();
                        bl3 = true;
                        if (n11 != 0) {
                            Object object;
                            int n12 = 10;
                            if (n11 != n12) {
                                Object object2;
                                n12 = 18;
                                if (n11 != n12) {
                                    n12 = 26;
                                    if (n11 != n12) {
                                        n12 = 34;
                                        if (n11 != n12) {
                                            n12 = 40;
                                            if (n11 != n12) {
                                                if ((n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n11) ? 1 : 0)) != 0) continue;
                                                break block20;
                                            } else {
                                                this.syntax_ = n11 = ((CodedInputStream)((Object)list)).readEnum();
                                                continue;
                                            }
                                        }
                                        n11 = 0;
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
                                    n11 = n10 & 2;
                                    if (n11 == 0) {
                                        object = new ArrayList();
                                        this.options_ = object;
                                        n10 |= 2;
                                    }
                                    object = this.options_;
                                    object2 = Option.parser();
                                    object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                    object.add(object2);
                                    continue;
                                }
                                n11 = n10 & 1;
                                if (n11 == 0) {
                                    object = new ArrayList();
                                    this.enumvalue_ = object;
                                    n10 |= 1;
                                }
                                object = this.enumvalue_;
                                object2 = EnumValue.parser();
                                object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                object.add(object2);
                                continue;
                            }
                            this.name_ = object = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                            continue;
                        }
                    }
                    bl2 = bl3;
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
            int n13 = n10 & 1;
            if (n13 != 0) {
                list2 = Collections.unmodifiableList(this.enumvalue_);
                this.enumvalue_ = list2;
            }
            if ((n13 = n10 & 2) != 0) {
                this.options_ = list2 = Collections.unmodifiableList(this.options_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n14 = n10 & 1;
        if (n14 != 0) {
            list = Collections.unmodifiableList(this.enumvalue_);
            this.enumvalue_ = list;
        }
        if ((n14 = n10 & 2) != 0) {
            this.options_ = list = Collections.unmodifiableList(this.options_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Enum(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Enum$1 enum$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Enum(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Enum(GeneratedMessageV3$Builder generatedMessageV3$Builder, Enum$1 enum$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(Enum enum_) {
        return enum_.name_;
    }

    public static /* synthetic */ Object access$302(Enum enum_, Object object) {
        enum_.name_ = object;
        return object;
    }

    public static /* synthetic */ List access$400(Enum enum_) {
        return enum_.enumvalue_;
    }

    public static /* synthetic */ List access$402(Enum enum_, List list) {
        enum_.enumvalue_ = list;
        return list;
    }

    public static /* synthetic */ List access$500(Enum enum_) {
        return enum_.options_;
    }

    public static /* synthetic */ List access$502(Enum enum_, List list) {
        enum_.options_ = list;
        return list;
    }

    public static /* synthetic */ SourceContext access$602(Enum enum_, SourceContext sourceContext) {
        enum_.sourceContext_ = sourceContext;
        return sourceContext;
    }

    public static /* synthetic */ int access$700(Enum enum_) {
        return enum_.syntax_;
    }

    public static /* synthetic */ int access$702(Enum enum_, int n10) {
        enum_.syntax_ = n10;
        return n10;
    }

    public static /* synthetic */ Parser access$800() {
        return PARSER;
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    public static Enum$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Enum$Builder newBuilder(Enum enum_) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(enum_);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream) {
        return (Enum)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(ByteString byteString) {
        return (Enum)PARSER.parseFrom(byteString);
    }

    public static Enum parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream) {
        return (Enum)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(InputStream inputStream) {
        return (Enum)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Enum parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer) {
        return (Enum)PARSER.parseFrom(byteBuffer);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Enum parseFrom(byte[] byArray) {
        return (Enum)PARSER.parseFrom(byArray);
    }

    public static Enum parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean n11 = object instanceof Enum;
        if (!n11) {
            return super.equals(object);
        }
        object = (Enum)object;
        Object object3 = this.getName();
        String string2 = ((Enum)object).getName();
        boolean bl3 = ((String)object3).equals(string2);
        string2 = null;
        if (!bl3) {
            return false;
        }
        object3 = this.getEnumvalueList();
        boolean bl4 = object3.equals(object2 = ((Enum)object).getEnumvalueList());
        if (!bl4) {
            return false;
        }
        object3 = this.getOptionsList();
        boolean bl5 = object3.equals(object2 = ((Enum)object).getOptionsList());
        if (!bl5) {
            return false;
        }
        int n12 = this.hasSourceContext();
        if (n12 != (n10 = ((Enum)object).hasSourceContext())) {
            return false;
        }
        boolean bl6 = this.hasSourceContext();
        if (bl6 && !(bl2 = ((SourceContext)(object3 = this.getSourceContext())).equals(object2 = ((Enum)object).getSourceContext()))) {
            return false;
        }
        int n13 = this.syntax_;
        n10 = ((Enum)object).syntax_;
        if (n13 != n10) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl7 = ((UnknownFieldSet)object3).equals(object);
        if (!bl7) {
            return false;
        }
        return bl22;
    }

    public Enum getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public EnumValue getEnumvalue(int n10) {
        return (EnumValue)this.enumvalue_.get(n10);
    }

    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    public List getEnumvalueList() {
        return this.enumvalue_;
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int n10) {
        return (EnumValueOrBuilder)this.enumvalue_.get(n10);
    }

    public List getEnumvalueOrBuilderList() {
        return this.enumvalue_;
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
        int n11;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        Object object2 = this.getNameBytes();
        n12 = (int)(((ByteString)object2).isEmpty() ? 1 : 0);
        n13 = 0;
        SourceContext sourceContext = null;
        if (n12 == 0) {
            object2 = this.name_;
            n11 = 1;
            n12 = GeneratedMessageV3.computeStringSize(n11, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        Object object3 = null;
        for (n11 = 0; n11 < (n10 = (object = this.enumvalue_).size()); ++n11) {
            MessageLite messageLite = (MessageLite)this.enumvalue_.get(n11);
            n10 = CodedOutputStream.computeMessageSize(2, messageLite);
            n12 += n10;
        }
        while (n13 < (n11 = (object3 = this.options_).size())) {
            object = (MessageLite)this.options_.get(n13);
            n11 = CodedOutputStream.computeMessageSize(3, (MessageLite)object);
            n12 += n11;
            ++n13;
        }
        sourceContext = this.sourceContext_;
        if (sourceContext != null) {
            object3 = this.getSourceContext();
            n13 = CodedOutputStream.computeMessageSize(4, (MessageLite)object3);
            n12 += n13;
        }
        if ((n13 = this.syntax_) != (n11 = ((Syntax)(object3 = Syntax.SYNTAX_PROTO2)).getNumber())) {
            n11 = this.syntax_;
            n13 = CodedOutputStream.computeEnumSize(5, n11);
            n12 += n13;
        }
        n13 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n13;
        return n12;
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
        int n11 = Enum.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        Object object = this.getName();
        n11 = ((String)object).hashCode();
        n10 += n11;
        n11 = this.getEnumvalueCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getEnumvalueList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getOptionsCount()) > 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOptionsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSourceContext() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getSourceContext();
            n11 = ((SourceContext)object).hashCode();
            n10 += n11;
        }
        n10 = (n10 * 37 + 5) * 53;
        n11 = this.syntax_;
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
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

    public Enum$Builder newBuilderForType() {
        return Enum.newBuilder();
    }

    public Enum$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Enum$Builder enum$Builder = new Enum$Builder(generatedMessageV3$BuilderParent, null);
        return enum$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Enum();
        return object;
    }

    public Enum$Builder toBuilder() {
        EnumOrBuilder enumOrBuilder = DEFAULT_INSTANCE;
        if (this == enumOrBuilder) {
            enumOrBuilder = new Enum$Builder(null);
        } else {
            enumOrBuilder = new Enum$Builder(null);
            enumOrBuilder = ((Enum$Builder)enumOrBuilder).mergeFrom(this);
        }
        return enumOrBuilder;
    }

    /*
     * WARNING - void declaration
     */
    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        void var3_5;
        Object object;
        int n11;
        int n12;
        Object object2 = this.getNameBytes();
        boolean n122 = ((ByteString)object2).isEmpty();
        if (!n122) {
            object2 = this.name_;
            n12 = 1;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        boolean bl2 = false;
        object2 = null;
        Object object3 = null;
        for (n12 = 0; n12 < (n11 = (object = this.enumvalue_).size()); ++n12) {
            n11 = 2;
            MessageLite messageLite = (MessageLite)this.enumvalue_.get(n12);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        while (++var3_5 < (n12 = (object3 = this.options_).size())) {
            n12 = 3;
            object = (MessageLite)this.options_.get((int)var3_5);
            codedOutputStream.writeMessage(n12, (MessageLite)object);
        }
        object2 = this.sourceContext_;
        if (object2 != null) {
            int n13 = 4;
            object3 = this.getSourceContext();
            codedOutputStream.writeMessage(n13, (MessageLite)object3);
        }
        if ((n10 = this.syntax_) != (n12 = ((Syntax)(object3 = Syntax.SYNTAX_PROTO2)).getNumber())) {
            int n14 = 5;
            n12 = this.syntax_;
            codedOutputStream.writeEnum(n14, n12);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

