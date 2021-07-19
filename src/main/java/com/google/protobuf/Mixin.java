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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Mixin$1;
import com.google.protobuf.Mixin$Builder;
import com.google.protobuf.MixinOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class Mixin
extends GeneratedMessageV3
implements MixinOrBuilder {
    private static final Mixin DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final Parser PARSER;
    public static final int ROOT_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private volatile Object root_;

    static {
        Object object = new Mixin();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Mixin$1();
    }

    private Mixin() {
        String string2 = "";
        this.name_ = string2;
        this.root_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Mixin(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        boolean bl2 = false;
        while (true) {
            if (bl2) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    boolean bl3;
                    block11: {
                        int n10 = ((CodedInputStream)object).readTag();
                        bl3 = true;
                        if (n10 != 0) {
                            String string2;
                            int n11 = 10;
                            if (n10 != n11) {
                                n11 = 18;
                                if (n10 != n11) {
                                    if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                                    break block11;
                                } else {
                                    string2 = ((CodedInputStream)object).readStringRequireUtf8();
                                    this.root_ = string2;
                                    continue;
                                }
                            }
                            string2 = ((CodedInputStream)object).readStringRequireUtf8();
                            this.name_ = string2;
                            continue;
                        }
                    }
                    bl2 = bl3;
                    continue;
                }
                catch (IOException iOException) {
                    object2 = new InvalidProtocolBufferException(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
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
        this.unknownFields = object2 = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
        throw throwable2;
    }

    public /* synthetic */ Mixin(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Mixin$1 mixin$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Mixin(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Mixin(GeneratedMessageV3$Builder generatedMessageV3$Builder, Mixin$1 mixin$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(Mixin mixin) {
        return mixin.name_;
    }

    public static /* synthetic */ Object access$302(Mixin mixin, Object object) {
        mixin.name_ = object;
        return object;
    }

    public static /* synthetic */ Object access$400(Mixin mixin) {
        return mixin.root_;
    }

    public static /* synthetic */ Object access$402(Mixin mixin, Object object) {
        mixin.root_ = object;
        return object;
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Mixin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Mixin_descriptor;
    }

    public static Mixin$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Mixin$Builder newBuilder(Mixin mixin) {
        return ((Mixin$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(mixin);
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream) {
        return (Mixin)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(ByteString byteString) {
        return (Mixin)PARSER.parseFrom(byteString);
    }

    public static Mixin parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Mixin parseFrom(CodedInputStream codedInputStream) {
        return (Mixin)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Mixin parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(InputStream inputStream) {
        return (Mixin)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Mixin parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(ByteBuffer byteBuffer) {
        return (Mixin)PARSER.parseFrom(byteBuffer);
    }

    public static Mixin parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Mixin parseFrom(byte[] byArray) {
        return (Mixin)PARSER.parseFrom(byArray);
    }

    public static Mixin parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        String string2;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Mixin;
        if (!bl3) {
            return super.equals(object);
        }
        object = (Mixin)object;
        Object object2 = this.getName();
        String string3 = ((Mixin)object).getName();
        bl3 = ((String)object2).equals(string3);
        string3 = null;
        if (!bl3) {
            return false;
        }
        object2 = this.getRoot();
        bl3 = ((String)object2).equals(string2 = ((Mixin)object).getRoot());
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = ((UnknownFieldSet)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public Mixin getDefaultInstanceForType() {
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

    public Parser getParserForType() {
        return PARSER;
    }

    public String getRoot() {
        Object object = this.root_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.root_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getRootBytes() {
        Object object = this.root_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.root_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getSerializedSize() {
        Object object;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        ByteString byteString = this.getNameBytes();
        n11 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            object = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(1, object);
            n10 = 0 + n11;
        }
        if ((n11 = (int)((byteString = this.getRootBytes()).isEmpty() ? 1 : 0)) == 0) {
            object = this.root_;
            n11 = GeneratedMessageV3.computeStringSize(2, object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Mixin.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.getName().hashCode();
        n10 = ((n10 + n11) * 37 + 2) * 53;
        n11 = this.getRoot().hashCode();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(Mixin.class, Mixin$Builder.class);
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

    public Mixin$Builder newBuilderForType() {
        return Mixin.newBuilder();
    }

    public Mixin$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Mixin$Builder mixin$Builder = new Mixin$Builder(generatedMessageV3$BuilderParent, null);
        return mixin$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Mixin();
        return object;
    }

    public Mixin$Builder toBuilder() {
        MixinOrBuilder mixinOrBuilder = DEFAULT_INSTANCE;
        if (this == mixinOrBuilder) {
            mixinOrBuilder = new Mixin$Builder(null);
        } else {
            mixinOrBuilder = new Mixin$Builder(null);
            mixinOrBuilder = ((Mixin$Builder)mixinOrBuilder).mergeFrom(this);
        }
        return mixinOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        ByteString byteString = this.getNameBytes();
        int n10 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            n10 = 1;
            object = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        if ((n10 = (byteString = this.getRootBytes()).isEmpty()) == 0) {
            n10 = 2;
            object = this.root_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

