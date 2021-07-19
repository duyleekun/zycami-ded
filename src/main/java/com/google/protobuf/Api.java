/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Api$1;
import com.google.protobuf.Api$Builder;
import com.google.protobuf.ApiOrBuilder;
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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Method;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Mixin;
import com.google.protobuf.MixinOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
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

public final class Api
extends GeneratedMessageV3
implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser PARSER;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private List methods_;
    private List mixins_;
    private volatile Object name_;
    private List options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private volatile Object version_;

    static {
        Object object = new Api();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Api$1();
    }

    private Api() {
        List list;
        Object object;
        this.name_ = object = "";
        this.methods_ = list = Collections.emptyList();
        this.options_ = list = Collections.emptyList();
        this.version_ = object;
        this.mixins_ = object = Collections.emptyList();
        this.syntax_ = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Api(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        boolean bl2 = false;
        int n10 = 0;
        while (!bl2) {
            try {
                try {
                    boolean bl3;
                    block25: {
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
                                            n12 = 42;
                                            if (n11 != n12) {
                                                n12 = 50;
                                                if (n11 != n12) {
                                                    n12 = 56;
                                                    if (n11 != n12) {
                                                        if ((n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n11) ? 1 : 0)) != 0) continue;
                                                        break block25;
                                                    } else {
                                                        this.syntax_ = n11 = ((CodedInputStream)((Object)list)).readEnum();
                                                        continue;
                                                    }
                                                }
                                                n11 = n10 & 4;
                                                if (n11 == 0) {
                                                    object = new ArrayList();
                                                    this.mixins_ = object;
                                                    n10 |= 4;
                                                }
                                                object = this.mixins_;
                                                object2 = Mixin.parser();
                                                object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                                object.add(object2);
                                                continue;
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
                                        object = ((CodedInputStream)((Object)list)).readStringRequireUtf8();
                                        this.version_ = object;
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
                                    this.methods_ = object;
                                    n10 |= 1;
                                }
                                object = this.methods_;
                                object2 = Method.parser();
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
                list2 = Collections.unmodifiableList(this.methods_);
                this.methods_ = list2;
            }
            if ((n13 = n10 & 2) != 0) {
                list2 = Collections.unmodifiableList(this.options_);
                this.options_ = list2;
            }
            if ((n13 = n10 & 4) != 0) {
                this.mixins_ = list2 = Collections.unmodifiableList(this.mixins_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n14 = n10 & 1;
        if (n14 != 0) {
            list = Collections.unmodifiableList(this.methods_);
            this.methods_ = list;
        }
        if ((n14 = n10 & 2) != 0) {
            list = Collections.unmodifiableList(this.options_);
            this.options_ = list;
        }
        if ((n14 = n10 & 4) != 0) {
            this.mixins_ = list = Collections.unmodifiableList(this.mixins_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Api(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Api$1 api$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Api(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Api(GeneratedMessageV3$Builder generatedMessageV3$Builder, Api$1 api$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Parser access$1000() {
        return PARSER;
    }

    public static /* synthetic */ Object access$300(Api api) {
        return api.name_;
    }

    public static /* synthetic */ Object access$302(Api api, Object object) {
        api.name_ = object;
        return object;
    }

    public static /* synthetic */ List access$400(Api api) {
        return api.methods_;
    }

    public static /* synthetic */ List access$402(Api api, List list) {
        api.methods_ = list;
        return list;
    }

    public static /* synthetic */ List access$500(Api api) {
        return api.options_;
    }

    public static /* synthetic */ List access$502(Api api, List list) {
        api.options_ = list;
        return list;
    }

    public static /* synthetic */ Object access$600(Api api) {
        return api.version_;
    }

    public static /* synthetic */ Object access$602(Api api, Object object) {
        api.version_ = object;
        return object;
    }

    public static /* synthetic */ SourceContext access$702(Api api, SourceContext sourceContext) {
        api.sourceContext_ = sourceContext;
        return sourceContext;
    }

    public static /* synthetic */ List access$800(Api api) {
        return api.mixins_;
    }

    public static /* synthetic */ List access$802(Api api, List list) {
        api.mixins_ = list;
        return list;
    }

    public static /* synthetic */ int access$900(Api api) {
        return api.syntax_;
    }

    public static /* synthetic */ int access$902(Api api, int n10) {
        api.syntax_ = n10;
        return n10;
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    public static Api$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Api$Builder newBuilder(Api api) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(api);
    }

    public static Api parseDelimitedFrom(InputStream inputStream) {
        return (Api)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(ByteString byteString) {
        return (Api)PARSER.parseFrom(byteString);
    }

    public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Api parseFrom(CodedInputStream codedInputStream) {
        return (Api)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Api parseFrom(InputStream inputStream) {
        return (Api)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(ByteBuffer byteBuffer) {
        return (Api)PARSER.parseFrom(byteBuffer);
    }

    public static Api parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Api parseFrom(byte[] byArray) {
        return (Api)PARSER.parseFrom(byArray);
    }

    public static Api parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Api)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean n11 = object instanceof Api;
        if (!n11) {
            return super.equals(object);
        }
        object = (Api)object;
        Object object3 = this.getName();
        String string2 = ((Api)object).getName();
        boolean bl3 = ((String)object3).equals(string2);
        string2 = null;
        if (!bl3) {
            return false;
        }
        object3 = this.getMethodsList();
        boolean bl4 = object3.equals(object2 = ((Api)object).getMethodsList());
        if (!bl4) {
            return false;
        }
        object3 = this.getOptionsList();
        boolean bl5 = object3.equals(object2 = ((Api)object).getOptionsList());
        if (!bl5) {
            return false;
        }
        object3 = this.getVersion();
        boolean bl6 = ((String)object3).equals(object2 = ((Api)object).getVersion());
        if (!bl6) {
            return false;
        }
        int n12 = this.hasSourceContext();
        if (n12 != (n10 = ((Api)object).hasSourceContext())) {
            return false;
        }
        boolean bl7 = this.hasSourceContext();
        if (bl7 && !(bl2 = ((SourceContext)(object3 = this.getSourceContext())).equals(object2 = ((Api)object).getSourceContext()))) {
            return false;
        }
        object3 = this.getMixinsList();
        boolean bl8 = object3.equals(object2 = ((Api)object).getMixinsList());
        if (!bl8) {
            return false;
        }
        int n13 = this.syntax_;
        n10 = ((Api)object).syntax_;
        if (n13 != n10) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl9 = ((UnknownFieldSet)object3).equals(object);
        if (!bl9) {
            return false;
        }
        return bl22;
    }

    public Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Method getMethods(int n10) {
        return (Method)this.methods_.get(n10);
    }

    public int getMethodsCount() {
        return this.methods_.size();
    }

    public List getMethodsList() {
        return this.methods_;
    }

    public MethodOrBuilder getMethodsOrBuilder(int n10) {
        return (MethodOrBuilder)this.methods_.get(n10);
    }

    public List getMethodsOrBuilderList() {
        return this.methods_;
    }

    public Mixin getMixins(int n10) {
        return (Mixin)this.mixins_.get(n10);
    }

    public int getMixinsCount() {
        return this.mixins_.size();
    }

    public List getMixinsList() {
        return this.mixins_;
    }

    public MixinOrBuilder getMixinsOrBuilder(int n10) {
        return (MixinOrBuilder)this.mixins_.get(n10);
    }

    public List getMixinsOrBuilderList() {
        return this.mixins_;
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
        MessageLite messageLite;
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
        if (n12 == 0) {
            object2 = this.name_;
            n11 = 1;
            n12 = GeneratedMessageV3.computeStringSize(n11, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        Object object3 = null;
        for (n11 = 0; n11 < (n10 = (object = this.methods_).size()); ++n11) {
            messageLite = (MessageLite)this.methods_.get(n11);
            n10 = CodedOutputStream.computeMessageSize(2, messageLite);
            n12 += n10;
        }
        object3 = null;
        for (n11 = 0; n11 < (n10 = (object = this.options_).size()); ++n11) {
            messageLite = (MessageLite)this.options_.get(n11);
            n10 = CodedOutputStream.computeMessageSize(3, messageLite);
            n12 += n10;
        }
        object3 = this.getVersionBytes();
        n11 = (int)(((ByteString)object3).isEmpty() ? 1 : 0);
        if (n11 == 0) {
            object = this.version_;
            n11 = GeneratedMessageV3.computeStringSize(4, object);
            n12 += n11;
        }
        if ((object3 = this.sourceContext_) != null) {
            object = this.getSourceContext();
            n11 = CodedOutputStream.computeMessageSize(5, (MessageLite)object);
            n12 += n11;
        }
        while (n13 < (n11 = (object3 = this.mixins_).size())) {
            object = (MessageLite)this.mixins_.get(n13);
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

    public String getVersion() {
        Object object = this.version_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.version_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getVersionBytes() {
        Object object = this.version_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.version_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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
        int n11 = Api.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        Object object = this.getName();
        n11 = ((String)object).hashCode();
        n10 += n11;
        n11 = this.getMethodsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getMethodsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getOptionsCount()) > 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOptionsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 = (n10 * 37 + 4) * 53;
        object = this.getVersion();
        n11 = ((String)object).hashCode();
        n10 += n11;
        n11 = (int)(this.hasSourceContext() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getSourceContext();
            n11 = ((SourceContext)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getMixinsCount()) > 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getMixinsList();
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
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
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

    public Api$Builder newBuilderForType() {
        return Api.newBuilder();
    }

    public Api$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Api$Builder api$Builder = new Api$Builder(generatedMessageV3$BuilderParent, null);
        return api$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Api();
        return object;
    }

    public Api$Builder toBuilder() {
        ApiOrBuilder apiOrBuilder = DEFAULT_INSTANCE;
        if (this == apiOrBuilder) {
            apiOrBuilder = new Api$Builder(null);
        } else {
            apiOrBuilder = new Api$Builder(null);
            apiOrBuilder = ((Api$Builder)apiOrBuilder).mergeFrom(this);
        }
        return apiOrBuilder;
    }

    /*
     * WARNING - void declaration
     */
    public void writeTo(CodedOutputStream codedOutputStream) {
        void var3_5;
        MessageLite messageLite;
        Object object;
        int n10;
        int n11;
        Object object2 = this.getNameBytes();
        boolean n12 = ((ByteString)object2).isEmpty();
        if (!n12) {
            object2 = this.name_;
            n11 = 1;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        boolean bl2 = false;
        object2 = null;
        Object object3 = null;
        for (n11 = 0; n11 < (n10 = (object = this.methods_).size()); ++n11) {
            n10 = 2;
            messageLite = (MessageLite)this.methods_.get(n11);
            codedOutputStream.writeMessage(n10, messageLite);
        }
        object3 = null;
        for (n11 = 0; n11 < (n10 = (object = this.options_).size()); ++n11) {
            n10 = 3;
            messageLite = (MessageLite)this.options_.get(n11);
            codedOutputStream.writeMessage(n10, messageLite);
        }
        object3 = this.getVersionBytes();
        n11 = (int)(((ByteString)object3).isEmpty() ? 1 : 0);
        if (n11 == 0) {
            n11 = 4;
            object = this.version_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        if ((object3 = this.sourceContext_) != null) {
            n11 = 5;
            object = this.getSourceContext();
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        while (++var3_5 < (n11 = (object3 = this.mixins_).size())) {
            n11 = 6;
            object = (MessageLite)this.mixins_.get((int)var3_5);
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        int n13 = this.syntax_;
        object3 = Syntax.SYNTAX_PROTO2;
        n11 = ((Syntax)object3).getNumber();
        if (n13 != n11) {
            int n14 = 7;
            n11 = this.syntax_;
            codedOutputStream.writeEnum(n14, n11);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

