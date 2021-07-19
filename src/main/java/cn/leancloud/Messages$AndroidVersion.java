/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AndroidVersion$1;
import cn.leancloud.Messages$AndroidVersion$Builder;
import cn.leancloud.Messages$AndroidVersionOrBuilder;
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

public final class Messages$AndroidVersion
extends GeneratedMessageV3
implements Messages$AndroidVersionOrBuilder {
    public static final int APILEVEL_FIELD_NUMBER = 2;
    public static final int CODENAME_FIELD_NUMBER = 1;
    private static final Messages$AndroidVersion DEFAULT_INSTANCE;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private volatile Object apiLevel_;
    private int bitField0_;
    private volatile Object codename_;
    private byte memoizedIsInitialized = (byte)-1;

    static {
        Object object = new Messages$AndroidVersion();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$AndroidVersion$1();
    }

    private Messages$AndroidVersion() {
        String string2 = "";
        this.codename_ = string2;
        this.apiLevel_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$AndroidVersion(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block11: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            ByteString byteString;
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 18;
                                if (n12 != n13) {
                                    if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                    break block11;
                                } else {
                                    byteString = ((CodedInputStream)object).readBytes();
                                    this.bitField0_ = n11 = this.bitField0_ | 2;
                                    this.apiLevel_ = byteString;
                                    continue;
                                }
                            }
                            byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.codename_ = byteString;
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

    public /* synthetic */ Messages$AndroidVersion(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$AndroidVersion(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$AndroidVersion(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$1800() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$2000(Messages$AndroidVersion messages$AndroidVersion) {
        return messages$AndroidVersion.codename_;
    }

    public static /* synthetic */ Object access$2002(Messages$AndroidVersion messages$AndroidVersion, Object object) {
        messages$AndroidVersion.codename_ = object;
        return object;
    }

    public static /* synthetic */ Object access$2100(Messages$AndroidVersion messages$AndroidVersion) {
        return messages$AndroidVersion.apiLevel_;
    }

    public static /* synthetic */ Object access$2102(Messages$AndroidVersion messages$AndroidVersion, Object object) {
        messages$AndroidVersion.apiLevel_ = object;
        return object;
    }

    public static /* synthetic */ int access$2202(Messages$AndroidVersion messages$AndroidVersion, int n10) {
        messages$AndroidVersion.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$2300(Messages$AndroidVersion messages$AndroidVersion) {
        return messages$AndroidVersion.unknownFields;
    }

    public static Messages$AndroidVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$1400();
    }

    public static Messages$AndroidVersion$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$AndroidVersion$Builder newBuilder(Messages$AndroidVersion messages$AndroidVersion) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$AndroidVersion);
    }

    public static Messages$AndroidVersion parseDelimitedFrom(InputStream inputStream) {
        return (Messages$AndroidVersion)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$AndroidVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AndroidVersion)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$AndroidVersion parseFrom(ByteString byteString) {
        return (Messages$AndroidVersion)PARSER.parseFrom(byteString);
    }

    public static Messages$AndroidVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AndroidVersion)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$AndroidVersion parseFrom(CodedInputStream codedInputStream) {
        return (Messages$AndroidVersion)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$AndroidVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AndroidVersion)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$AndroidVersion parseFrom(InputStream inputStream) {
        return (Messages$AndroidVersion)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$AndroidVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AndroidVersion)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$AndroidVersion parseFrom(ByteBuffer byteBuffer) {
        return (Messages$AndroidVersion)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$AndroidVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AndroidVersion)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$AndroidVersion parseFrom(byte[] byArray) {
        return (Messages$AndroidVersion)PARSER.parseFrom(byArray);
    }

    public static Messages$AndroidVersion parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AndroidVersion)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        String string2;
        Object object2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$AndroidVersion;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$AndroidVersion)object;
        bl5 = this.hasCodename();
        if (bl5 == (bl3 = ((Messages$AndroidVersion)object).hasCodename())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasCodename();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getCodename())).equals(string2 = ((Messages$AndroidVersion)object).getCodename()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasApiLevel()) == (bl3 = ((Messages$AndroidVersion)object).hasApiLevel())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasApiLevel();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getApiLevel())).equals(string2 = ((Messages$AndroidVersion)object).getApiLevel()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (!bl5 || !(bl2 = ((UnknownFieldSet)(object2 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            bl4 = false;
        }
        return bl4;
    }

    public String getApiLevel() {
        Object object = this.apiLevel_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.apiLevel_ = string2;
        }
        return string2;
    }

    public ByteString getApiLevelBytes() {
        Object object = this.apiLevel_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.apiLevel_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getCodename() {
        Object object = this.codename_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.codename_ = string2;
        }
        return string2;
    }

    public ByteString getCodenameBytes() {
        Object object = this.codename_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.codename_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$AndroidVersion getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            object = this.codename_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            object = this.apiLevel_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasApiLevel() {
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

    public boolean hasCodename() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$AndroidVersion.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCodename() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getCodename();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasApiLevel() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getApiLevel();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$1500().ensureFieldAccessorsInitialized(Messages$AndroidVersion.class, Messages$AndroidVersion$Builder.class);
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

    public Messages$AndroidVersion$Builder newBuilderForType() {
        return Messages$AndroidVersion.newBuilder();
    }

    public Messages$AndroidVersion$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$AndroidVersion$Builder messages$AndroidVersion$Builder = new Messages$AndroidVersion$Builder(generatedMessageV3$BuilderParent, null);
        return messages$AndroidVersion$Builder;
    }

    public Messages$AndroidVersion$Builder toBuilder() {
        Messages$AndroidVersionOrBuilder messages$AndroidVersionOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$AndroidVersionOrBuilder) {
            messages$AndroidVersionOrBuilder = new Messages$AndroidVersion$Builder(null);
        } else {
            messages$AndroidVersionOrBuilder = new Messages$AndroidVersion$Builder(null);
            messages$AndroidVersionOrBuilder = ((Messages$AndroidVersion$Builder)messages$AndroidVersionOrBuilder).mergeFrom(this);
        }
        return messages$AndroidVersionOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            object = this.codename_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object = this.apiLevel_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

