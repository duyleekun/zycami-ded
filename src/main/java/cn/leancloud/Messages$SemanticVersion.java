/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$SemanticVersion$1;
import cn.leancloud.Messages$SemanticVersion$Builder;
import cn.leancloud.Messages$SemanticVersionOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$SemanticVersion
extends GeneratedMessageV3
implements Messages$SemanticVersionOrBuilder {
    public static final int BUILD_FIELD_NUMBER = 5;
    private static final Messages$SemanticVersion DEFAULT_INSTANCE;
    public static final int MAJOR_FIELD_NUMBER = 1;
    public static final int MINOR_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int PATCH_FIELD_NUMBER = 3;
    public static final int PRERELEASE_FIELD_NUMBER = 4;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object build_;
    private int major_;
    private byte memoizedIsInitialized = (byte)-1;
    private int minor_;
    private int patch_;
    private volatile Object preRelease_;

    static {
        Object object = new Messages$SemanticVersion();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$SemanticVersion$1();
    }

    private Messages$SemanticVersion() {
        this.major_ = 0;
        this.minor_ = 0;
        this.patch_ = 0;
        String string2 = "";
        this.preRelease_ = string2;
        this.build_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$SemanticVersion(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
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
                    block14: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            int n13 = 8;
                            if (n12 != n13) {
                                int n14 = 16;
                                if (n12 != n14) {
                                    int n15 = 24;
                                    if (n12 != n15) {
                                        ByteString byteString;
                                        n15 = 34;
                                        if (n12 != n15) {
                                            n13 = 42;
                                            if (n12 != n13) {
                                                if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                                break block14;
                                            } else {
                                                byteString = ((CodedInputStream)object).readBytes();
                                                this.bitField0_ = n11 = this.bitField0_ | n14;
                                                this.build_ = byteString;
                                                continue;
                                            }
                                        }
                                        byteString = ((CodedInputStream)object).readBytes();
                                        this.bitField0_ = n11 = this.bitField0_ | n13;
                                        this.preRelease_ = byteString;
                                        continue;
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

    public /* synthetic */ Messages$SemanticVersion(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$SemanticVersion(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$SemanticVersion(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$1000(Messages$SemanticVersion messages$SemanticVersion) {
        return messages$SemanticVersion.build_;
    }

    public static /* synthetic */ Object access$1002(Messages$SemanticVersion messages$SemanticVersion, Object object) {
        messages$SemanticVersion.build_ = object;
        return object;
    }

    public static /* synthetic */ int access$1102(Messages$SemanticVersion messages$SemanticVersion, int n10) {
        messages$SemanticVersion.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$1200(Messages$SemanticVersion messages$SemanticVersion) {
        return messages$SemanticVersion.unknownFields;
    }

    public static /* synthetic */ boolean access$400() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$602(Messages$SemanticVersion messages$SemanticVersion, int n10) {
        messages$SemanticVersion.major_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$702(Messages$SemanticVersion messages$SemanticVersion, int n10) {
        messages$SemanticVersion.minor_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$802(Messages$SemanticVersion messages$SemanticVersion, int n10) {
        messages$SemanticVersion.patch_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$900(Messages$SemanticVersion messages$SemanticVersion) {
        return messages$SemanticVersion.preRelease_;
    }

    public static /* synthetic */ Object access$902(Messages$SemanticVersion messages$SemanticVersion, Object object) {
        messages$SemanticVersion.preRelease_ = object;
        return object;
    }

    public static Messages$SemanticVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$000();
    }

    public static Messages$SemanticVersion$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$SemanticVersion$Builder newBuilder(Messages$SemanticVersion messages$SemanticVersion) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$SemanticVersion);
    }

    public static Messages$SemanticVersion parseDelimitedFrom(InputStream inputStream) {
        return (Messages$SemanticVersion)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$SemanticVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SemanticVersion)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$SemanticVersion parseFrom(ByteString byteString) {
        return (Messages$SemanticVersion)PARSER.parseFrom(byteString);
    }

    public static Messages$SemanticVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SemanticVersion)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$SemanticVersion parseFrom(CodedInputStream codedInputStream) {
        return (Messages$SemanticVersion)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$SemanticVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SemanticVersion)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$SemanticVersion parseFrom(InputStream inputStream) {
        return (Messages$SemanticVersion)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$SemanticVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SemanticVersion)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$SemanticVersion parseFrom(ByteBuffer byteBuffer) {
        return (Messages$SemanticVersion)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$SemanticVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SemanticVersion)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$SemanticVersion parseFrom(byte[] byArray) {
        return (Messages$SemanticVersion)PARSER.parseFrom(byArray);
    }

    public static Messages$SemanticVersion parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SemanticVersion)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        String string2;
        Object object2;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11;
        }
        int n12 = object instanceof Messages$SemanticVersion;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$SemanticVersion)object;
        n12 = this.hasMajor();
        if (n12 == (n10 = ((Messages$SemanticVersion)object).hasMajor())) {
            n12 = n11;
        } else {
            n12 = 0;
            object2 = null;
        }
        n10 = this.hasMajor();
        if (n10 != 0) {
            if (n12 && (n12 = this.getMajor()) == (n10 = ((Messages$SemanticVersion)object).getMajor())) {
                n12 = n11;
            } else {
                n12 = 0;
                object2 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasMinor() ? 1 : 0)) == (n10 = (int)(((Messages$SemanticVersion)object).hasMinor() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object2 = null;
        }
        n10 = (int)(this.hasMinor() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getMinor()) == (n10 = ((Messages$SemanticVersion)object).getMinor())) {
                n12 = n11;
            } else {
                n12 = 0;
                object2 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasPatch() ? 1 : 0)) == (n10 = (int)(((Messages$SemanticVersion)object).hasPatch() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object2 = null;
        }
        n10 = (int)(this.hasPatch() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getPatch()) == (n10 = ((Messages$SemanticVersion)object).getPatch())) {
                n12 = n11;
            } else {
                n12 = 0;
                object2 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasPreRelease() ? 1 : 0)) == (n10 = (int)(((Messages$SemanticVersion)object).hasPreRelease() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object2 = null;
        }
        n10 = (int)(this.hasPreRelease() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object2 = this.getPreRelease())).equals(string2 = ((Messages$SemanticVersion)object).getPreRelease()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object2 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasBuild() ? 1 : 0)) == (n10 = (int)(((Messages$SemanticVersion)object).hasBuild() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object2 = null;
        }
        n10 = (int)(this.hasBuild() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object2 = this.getBuild())).equals(string2 = ((Messages$SemanticVersion)object).getBuild()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object2 = null;
            }
        }
        if (!n12 || !(bl2 = ((UnknownFieldSet)(object2 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            n11 = 0;
        }
        return n11;
    }

    public String getBuild() {
        Object object = this.build_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.build_ = string2;
        }
        return string2;
    }

    public ByteString getBuildBytes() {
        Object object = this.build_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.build_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$SemanticVersion getDefaultInstanceForType() {
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

    public String getPreRelease() {
        Object object = this.preRelease_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.preRelease_ = string2;
        }
        return string2;
    }

    public ByteString getPreReleaseBytes() {
        Object object = this.preRelease_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.preRelease_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getSerializedSize() {
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = 0;
        n12 = this.bitField0_;
        int n13 = 1;
        if ((n12 &= n13) == n13) {
            n12 = this.major_;
            n12 = CodedOutputStream.computeInt32Size(n13, n12);
            n11 = 0 + n12;
        }
        n12 = this.bitField0_;
        n13 = 2;
        if ((n12 &= n13) == n13) {
            n12 = this.minor_;
            n12 = CodedOutputStream.computeInt32Size(n13, n12);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 4;
        if ((n12 &= n13) == n13) {
            n10 = this.patch_;
            n12 = CodedOutputStream.computeInt32Size(3, n10);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n10 = 8;
        if ((n12 &= n10) == n10) {
            Object object = this.preRelease_;
            n12 = GeneratedMessageV3.computeStringSize(n13, object);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 16;
        if ((n12 &= n13) == n13) {
            Object object = this.build_;
            n12 = GeneratedMessageV3.computeStringSize(5, object);
            n11 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBuild() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasMajor() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasMinor() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 2;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPatch() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 4;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasPreRelease() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 8;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$SemanticVersion.getDescriptor();
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
        if ((n11 = (int)(this.hasPreRelease() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getPreRelease();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasBuild() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getBuild();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$100().ensureFieldAccessorsInitialized(Messages$SemanticVersion.class, Messages$SemanticVersion$Builder.class);
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

    public Messages$SemanticVersion$Builder newBuilderForType() {
        return Messages$SemanticVersion.newBuilder();
    }

    public Messages$SemanticVersion$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$SemanticVersion$Builder messages$SemanticVersion$Builder = new Messages$SemanticVersion$Builder(generatedMessageV3$BuilderParent, null);
        return messages$SemanticVersion$Builder;
    }

    public Messages$SemanticVersion$Builder toBuilder() {
        Messages$SemanticVersionOrBuilder messages$SemanticVersionOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$SemanticVersionOrBuilder) {
            messages$SemanticVersionOrBuilder = new Messages$SemanticVersion$Builder(null);
        } else {
            messages$SemanticVersionOrBuilder = new Messages$SemanticVersion$Builder(null);
            messages$SemanticVersionOrBuilder = ((Messages$SemanticVersion$Builder)messages$SemanticVersionOrBuilder).mergeFrom(this);
        }
        return messages$SemanticVersionOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            n11 = this.major_;
            codedOutputStream.writeInt32(n12, n11);
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            n11 = this.minor_;
            codedOutputStream.writeInt32(n12, n11);
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            n11 = 3;
            n10 = this.patch_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n11 = this.bitField0_;
        n10 = 8;
        if ((n11 &= n10) == n10) {
            Object object = this.preRelease_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object);
        }
        n11 = this.bitField0_;
        n12 = 16;
        if ((n11 &= n12) == n12) {
            n11 = 5;
            Object object = this.build_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

