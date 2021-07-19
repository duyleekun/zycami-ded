/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ApiProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Method$1;
import com.google.protobuf.Method$Builder;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Syntax;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Method
extends GeneratedMessageV3
implements MethodOrBuilder {
    private static final Method DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static final Parser PARSER;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List options_;
    private boolean requestStreaming_;
    private volatile Object requestTypeUrl_;
    private boolean responseStreaming_;
    private volatile Object responseTypeUrl_;
    private int syntax_;

    static {
        Object object = new Method();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Method$1();
    }

    private Method() {
        Object object;
        this.memoizedIsInitialized = (byte)-1;
        this.name_ = object = "";
        this.requestTypeUrl_ = object;
        this.responseTypeUrl_ = object;
        this.options_ = object = Collections.emptyList();
        this.syntax_ = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Method(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block18: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(list2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            boolean bl2 = false;
            n10 = 0;
            while (true) {
                boolean bl3 = true;
                if (bl2) break block18;
                try {
                    try {
                        block19: {
                            int n11 = ((CodedInputStream)((Object)list)).readTag();
                            if (n11 != 0) {
                                ArrayList<Object> arrayList;
                                int n12 = 10;
                                if (n11 != n12) {
                                    n12 = 18;
                                    if (n11 != n12) {
                                        n12 = 24;
                                        if (n11 != n12) {
                                            n12 = 34;
                                            if (n11 != n12) {
                                                n12 = 40;
                                                if (n11 != n12) {
                                                    n12 = 50;
                                                    if (n11 != n12) {
                                                        n12 = 56;
                                                        if (n11 != n12) {
                                                            if ((n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n11) ? 1 : 0)) != 0) continue;
                                                            break block19;
                                                        } else {
                                                            this.syntax_ = n11 = ((CodedInputStream)((Object)list)).readEnum();
                                                            continue;
                                                        }
                                                    }
                                                    n11 = n10 & 1;
                                                    if (n11 == 0) {
                                                        this.options_ = arrayList = new ArrayList<Object>();
                                                        n10 |= 1;
                                                    }
                                                    arrayList = this.options_;
                                                    Object object = Option.parser();
                                                    object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                                    arrayList.add(object);
                                                    continue;
                                                }
                                                n11 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                                this.responseStreaming_ = n11;
                                                continue;
                                            }
                                            arrayList = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                                            this.responseTypeUrl_ = arrayList;
                                            continue;
                                        }
                                        n11 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                        this.requestStreaming_ = n11;
                                        continue;
                                    }
                                    arrayList = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                                    this.requestTypeUrl_ = arrayList;
                                    continue;
                                }
                                arrayList = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                                this.name_ = arrayList;
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
                catch (Throwable throwable2) {}
                break;
            }
            boolean bl4 = n10 & true;
            if (bl4) {
                this.options_ = list2 = Collections.unmodifiableList(this.options_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.options_ = list = Collections.unmodifiableList(this.options_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Method(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Method$1 method$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Method(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Method(GeneratedMessageV3$Builder generatedMessageV3$Builder, Method$1 method$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Parser access$1000() {
        return PARSER;
    }

    public static /* synthetic */ Object access$300(Method method) {
        return method.name_;
    }

    public static /* synthetic */ Object access$302(Method method, Object object) {
        method.name_ = object;
        return object;
    }

    public static /* synthetic */ Object access$400(Method method) {
        return method.requestTypeUrl_;
    }

    public static /* synthetic */ Object access$402(Method method, Object object) {
        method.requestTypeUrl_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$502(Method method, boolean bl2) {
        method.requestStreaming_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$600(Method method) {
        return method.responseTypeUrl_;
    }

    public static /* synthetic */ Object access$602(Method method, Object object) {
        method.responseTypeUrl_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$702(Method method, boolean bl2) {
        method.responseStreaming_ = bl2;
        return bl2;
    }

    public static /* synthetic */ List access$800(Method method) {
        return method.options_;
    }

    public static /* synthetic */ List access$802(Method method, List list) {
        method.options_ = list;
        return list;
    }

    public static /* synthetic */ int access$900(Method method) {
        return method.syntax_;
    }

    public static /* synthetic */ int access$902(Method method, int n10) {
        method.syntax_ = n10;
        return n10;
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    public static Method$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Method$Builder newBuilder(Method method) {
        return ((Method$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(method);
    }

    public static Method parseDelimitedFrom(InputStream inputStream) {
        return (Method)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Method parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(ByteString byteString) {
        return (Method)PARSER.parseFrom(byteString);
    }

    public static Method parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Method parseFrom(CodedInputStream codedInputStream) {
        return (Method)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Method parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Method parseFrom(InputStream inputStream) {
        return (Method)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Method parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(ByteBuffer byteBuffer) {
        return (Method)PARSER.parseFrom(byteBuffer);
    }

    public static Method parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Method parseFrom(byte[] byArray) {
        return (Method)PARSER.parseFrom(byArray);
    }

    public static Method parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Method)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        int n10;
        Object object2;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean n11 = object instanceof Method;
        if (!n11) {
            return super.equals(object);
        }
        object = (Method)object;
        Object object3 = this.getName();
        String string2 = ((Method)object).getName();
        boolean bl3 = ((String)object3).equals(string2);
        string2 = null;
        if (!bl3) {
            return false;
        }
        object3 = this.getRequestTypeUrl();
        boolean bl4 = ((String)object3).equals(object2 = ((Method)object).getRequestTypeUrl());
        if (!bl4) {
            return false;
        }
        int n12 = this.getRequestStreaming();
        if (n12 != (n10 = ((Method)object).getRequestStreaming())) {
            return false;
        }
        object3 = this.getResponseTypeUrl();
        boolean bl5 = ((String)object3).equals(object2 = ((Method)object).getResponseTypeUrl());
        if (!bl5) {
            return false;
        }
        int n13 = this.getResponseStreaming();
        if (n13 != (n10 = ((Method)object).getResponseStreaming())) {
            return false;
        }
        object3 = this.getOptionsList();
        boolean bl6 = object3.equals(object2 = ((Method)object).getOptionsList());
        if (!bl6) {
            return false;
        }
        int n14 = this.syntax_;
        n10 = ((Method)object).syntax_;
        if (n14 != n10) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl7 = ((UnknownFieldSet)object3).equals(object);
        if (!bl7) {
            return false;
        }
        return bl2;
    }

    public Method getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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

    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    public String getRequestTypeUrl() {
        Object object = this.requestTypeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.requestTypeUrl_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getRequestTypeUrlBytes() {
        Object object = this.requestTypeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.requestTypeUrl_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    public String getResponseTypeUrl() {
        Object object = this.responseTypeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.responseTypeUrl_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getResponseTypeUrlBytes() {
        Object object = this.responseTypeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.responseTypeUrl_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getSerializedSize() {
        int n10;
        Object object;
        int n11;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        Object object2 = this.getNameBytes();
        n12 = (int)(((ByteString)object2).isEmpty() ? 1 : 0);
        n13 = 0;
        if (n12 == 0) {
            object2 = this.name_;
            n11 = 1;
            n12 = GeneratedMessageV3.computeStringSize(n11, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        Object object3 = this.getRequestTypeUrlBytes();
        n11 = (int)(((ByteString)object3).isEmpty() ? 1 : 0);
        if (n11 == 0) {
            object = this.requestTypeUrl_;
            n11 = GeneratedMessageV3.computeStringSize(2, object);
            n12 += n11;
        }
        if ((n11 = (int)(this.requestStreaming_ ? 1 : 0)) != 0) {
            n10 = 3;
            n11 = CodedOutputStream.computeBoolSize(n10, n11 != 0);
            n12 += n11;
        }
        if ((n11 = (int)(((ByteString)(object3 = this.getResponseTypeUrlBytes())).isEmpty() ? 1 : 0)) == 0) {
            object = this.responseTypeUrl_;
            n11 = GeneratedMessageV3.computeStringSize(4, object);
            n12 += n11;
        }
        if ((n11 = (int)(this.responseStreaming_ ? 1 : 0)) != 0) {
            n10 = 5;
            n11 = CodedOutputStream.computeBoolSize(n10, n11 != 0);
            n12 += n11;
        }
        while (n13 < (n11 = (object3 = this.options_).size())) {
            object = (MessageLite)this.options_.get(n13);
            n11 = CodedOutputStream.computeMessageSize(6, (MessageLite)object);
            n12 += n11;
            ++n13;
        }
        n13 = this.syntax_;
        object3 = Syntax.SYNTAX_PROTO2;
        n11 = ((Syntax)object3).getNumber();
        if (n13 != n11) {
            n11 = this.syntax_;
            n13 = CodedOutputStream.computeEnumSize(7, n11);
            n12 += n13;
        }
        n13 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n13;
        return n12;
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

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Method.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.getName().hashCode();
        n10 = ((n10 + n11) * 37 + 2) * 53;
        n11 = this.getRequestTypeUrl().hashCode();
        n10 = ((n10 + n11) * 37 + 3) * 53;
        n11 = Internal.hashBoolean(this.getRequestStreaming());
        n10 = ((n10 + n11) * 37 + 4) * 53;
        Object object = this.getResponseTypeUrl();
        n11 = ((String)object).hashCode();
        n10 = ((n10 + n11) * 37 + 5) * 53;
        n11 = Internal.hashBoolean(this.getResponseStreaming());
        n10 += n11;
        n11 = this.getOptionsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getOptionsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 = (n10 * 37 + 7) * 53;
        n11 = this.syntax_;
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
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

    public Method$Builder newBuilderForType() {
        return Method.newBuilder();
    }

    public Method$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Method$Builder method$Builder = new Method$Builder(generatedMessageV3$BuilderParent, null);
        return method$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Method();
        return object;
    }

    public Method$Builder toBuilder() {
        MethodOrBuilder methodOrBuilder = DEFAULT_INSTANCE;
        if (this == methodOrBuilder) {
            methodOrBuilder = new Method$Builder(null);
        } else {
            methodOrBuilder = new Method$Builder(null);
            methodOrBuilder = ((Method$Builder)methodOrBuilder).mergeFrom(this);
        }
        return methodOrBuilder;
    }

    /*
     * WARNING - void declaration
     */
    public void writeTo(CodedOutputStream codedOutputStream) {
        void var3_11;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        Object object;
        boolean bl5;
        int n10;
        Object object2 = this.getNameBytes();
        boolean n11 = ((ByteString)object2).isEmpty();
        if (!n11) {
            object2 = this.name_;
            n10 = 1;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        if (!(bl5 = ((ByteString)(object2 = this.getRequestTypeUrlBytes())).isEmpty())) {
            int n12 = 2;
            object = this.requestTypeUrl_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object);
        }
        if (bl4 = this.requestStreaming_) {
            n10 = 3;
            codedOutputStream.writeBool(n10, bl4);
        }
        if (!(bl3 = ((ByteString)(object2 = this.getResponseTypeUrlBytes())).isEmpty())) {
            int n13 = 4;
            object = this.responseTypeUrl_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        if (bl2 = this.responseStreaming_) {
            n10 = 5;
            codedOutputStream.writeBool(n10, bl2);
        }
        boolean bl6 = false;
        object2 = null;
        while (++var3_11 < (n10 = (object = this.options_).size())) {
            n10 = 6;
            MessageLite messageLite = (MessageLite)this.options_.get((int)var3_11);
            codedOutputStream.writeMessage(n10, messageLite);
        }
        int n14 = this.syntax_;
        object = Syntax.SYNTAX_PROTO2;
        n10 = ((Syntax)object).getNumber();
        if (n14 != n10) {
            int n15 = 7;
            n10 = this.syntax_;
            codedOutputStream.writeEnum(n15, n10);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

