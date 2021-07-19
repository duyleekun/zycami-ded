/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$Version$1;
import com.google.protobuf.compiler.PluginProtos$Version$Builder;
import com.google.protobuf.compiler.PluginProtos$VersionOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class PluginProtos$Version
extends GeneratedMessageV3
implements PluginProtos$VersionOrBuilder {
    private static final PluginProtos$Version DEFAULT_INSTANCE;
    public static final int MAJOR_FIELD_NUMBER = 1;
    public static final int MINOR_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int PATCH_FIELD_NUMBER = 3;
    public static final int SUFFIX_FIELD_NUMBER = 4;
    private static final long serialVersionUID;
    private int bitField0_;
    private int major_;
    private byte memoizedIsInitialized = (byte)-1;
    private int minor_;
    private int patch_;
    private volatile Object suffix_;

    static {
        Object object = new PluginProtos$Version();
        DEFAULT_INSTANCE = object;
        PARSER = object = new PluginProtos$Version$1();
    }

    private PluginProtos$Version() {
        this.suffix_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PluginProtos$Version(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        while (true) {
            if (n10 != 0) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n11;
                    block13: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            int n13 = 8;
                            if (n12 != n13) {
                                int n14 = 16;
                                if (n12 != n14) {
                                    n14 = 24;
                                    if (n12 != n14) {
                                        n14 = 34;
                                        if (n12 != n14) {
                                            if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                            break block13;
                                        } else {
                                            ByteString byteString = ((CodedInputStream)object).readBytes();
                                            this.bitField0_ = n11 = this.bitField0_ | n13;
                                            this.suffix_ = byteString;
                                            continue;
                                        }
                                    }
                                    this.bitField0_ = n12 = this.bitField0_ | 4;
                                    this.patch_ = n12 = ((CodedInputStream)object).readInt32();
                                    continue;
                                }
                                this.bitField0_ = n12 = this.bitField0_ | 2;
                                this.minor_ = n12 = ((CodedInputStream)object).readInt32();
                                continue;
                            }
                            this.bitField0_ = n12 = this.bitField0_ | n11;
                            this.major_ = n12 = ((CodedInputStream)object).readInt32();
                            continue;
                        }
                    }
                    n10 = n11;
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

    public /* synthetic */ PluginProtos$Version(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, PluginProtos$1 pluginProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private PluginProtos$Version(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ PluginProtos$Version(GeneratedMessageV3$Builder generatedMessageV3$Builder, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ int access$1002(PluginProtos$Version pluginProtos$Version, int n10) {
        pluginProtos$Version.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$1100(PluginProtos$Version pluginProtos$Version) {
        return pluginProtos$Version.unknownFields;
    }

    public static /* synthetic */ boolean access$400() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$602(PluginProtos$Version pluginProtos$Version, int n10) {
        pluginProtos$Version.major_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$702(PluginProtos$Version pluginProtos$Version, int n10) {
        pluginProtos$Version.minor_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$802(PluginProtos$Version pluginProtos$Version, int n10) {
        pluginProtos$Version.patch_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$900(PluginProtos$Version pluginProtos$Version) {
        return pluginProtos$Version.suffix_;
    }

    public static /* synthetic */ Object access$902(PluginProtos$Version pluginProtos$Version, Object object) {
        pluginProtos$Version.suffix_ = object;
        return object;
    }

    public static PluginProtos$Version getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$000();
    }

    public static PluginProtos$Version$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PluginProtos$Version$Builder newBuilder(PluginProtos$Version pluginProtos$Version) {
        return ((PluginProtos$Version$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(pluginProtos$Version);
    }

    public static PluginProtos$Version parseDelimitedFrom(InputStream inputStream) {
        return (PluginProtos$Version)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$Version parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$Version)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$Version parseFrom(ByteString byteString) {
        return (PluginProtos$Version)PARSER.parseFrom(byteString);
    }

    public static PluginProtos$Version parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$Version)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PluginProtos$Version parseFrom(CodedInputStream codedInputStream) {
        return (PluginProtos$Version)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PluginProtos$Version parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$Version)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PluginProtos$Version parseFrom(InputStream inputStream) {
        return (PluginProtos$Version)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$Version parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$Version)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$Version parseFrom(ByteBuffer byteBuffer) {
        return (PluginProtos$Version)PARSER.parseFrom(byteBuffer);
    }

    public static PluginProtos$Version parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$Version)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PluginProtos$Version parseFrom(byte[] byArray) {
        return (PluginProtos$Version)PARSER.parseFrom(byArray);
    }

    public static PluginProtos$Version parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$Version)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        String string2;
        Object object2;
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof PluginProtos$Version;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (PluginProtos$Version)object;
        n11 = this.hasMajor();
        if (n11 != (n10 = ((PluginProtos$Version)object).hasMajor())) {
            return false;
        }
        n11 = this.hasMajor();
        if (n11 != 0 && (n11 = this.getMajor()) != (n10 = ((PluginProtos$Version)object).getMajor())) {
            return false;
        }
        n11 = (int)(this.hasMinor() ? 1 : 0);
        if (n11 != (n10 = (int)(((PluginProtos$Version)object).hasMinor() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasMinor() ? 1 : 0);
        if (n11 != 0 && (n11 = this.getMinor()) != (n10 = ((PluginProtos$Version)object).getMinor())) {
            return false;
        }
        n11 = (int)(this.hasPatch() ? 1 : 0);
        if (n11 != (n10 = (int)(((PluginProtos$Version)object).hasPatch() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasPatch() ? 1 : 0);
        if (n11 != 0 && (n11 = this.getPatch()) != (n10 = ((PluginProtos$Version)object).getPatch())) {
            return false;
        }
        n11 = (int)(this.hasSuffix() ? 1 : 0);
        if (n11 != (n10 = (int)(((PluginProtos$Version)object).hasSuffix() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasSuffix() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object2 = this.getSuffix())).equals(string2 = ((PluginProtos$Version)object).getSuffix()) ? 1 : 0)) == 0) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl3 = ((UnknownFieldSet)object2).equals(object);
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public PluginProtos$Version getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public int getMajor() {
        return this.major_;
    }

    public int getMinor() {
        return this.minor_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getPatch() {
        return this.patch_;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            n11 = this.major_;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) != 0) {
            n11 = this.minor_;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) != 0) {
            int n13 = this.patch_;
            n11 = CodedOutputStream.computeInt32Size(3, n13);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 8) != 0) {
            Object object = this.suffix_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public String getSuffix() {
        Object object = this.suffix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.suffix_ = string2;
        }
        return string2;
    }

    public ByteString getSuffixBytes() {
        Object object = this.suffix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.suffix_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasMajor() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasMinor() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPatch() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSuffix() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = PluginProtos$Version.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasMajor() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.getMajor();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMinor() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = this.getMinor();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatch() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = this.getPatch();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSuffix() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getSuffix();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$100().ensureFieldAccessorsInitialized(PluginProtos$Version.class, PluginProtos$Version$Builder.class);
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

    public PluginProtos$Version$Builder newBuilderForType() {
        return PluginProtos$Version.newBuilder();
    }

    public PluginProtos$Version$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        PluginProtos$Version$Builder pluginProtos$Version$Builder = new PluginProtos$Version$Builder(generatedMessageV3$BuilderParent, null);
        return pluginProtos$Version$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new PluginProtos$Version();
        return object;
    }

    public PluginProtos$Version$Builder toBuilder() {
        PluginProtos$VersionOrBuilder pluginProtos$VersionOrBuilder = DEFAULT_INSTANCE;
        if (this == pluginProtos$VersionOrBuilder) {
            pluginProtos$VersionOrBuilder = new PluginProtos$Version$Builder(null);
        } else {
            pluginProtos$VersionOrBuilder = new PluginProtos$Version$Builder(null);
            pluginProtos$VersionOrBuilder = ((PluginProtos$Version$Builder)pluginProtos$VersionOrBuilder).mergeFrom(this);
        }
        return pluginProtos$VersionOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            n10 = this.major_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            n10 = this.minor_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) != 0) {
            n10 = 3;
            int n12 = this.patch_;
            codedOutputStream.writeInt32(n10, n12);
        }
        if ((n10 = this.bitField0_ & 8) != 0) {
            Object object = this.suffix_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

