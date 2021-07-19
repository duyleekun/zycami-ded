/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AndroidVersion;
import cn.leancloud.Messages$AndroidVersion$Builder;
import cn.leancloud.Messages$AndroidVersionOrBuilder;
import cn.leancloud.Messages$DeviceType;
import cn.leancloud.Messages$SemanticVersion;
import cn.leancloud.Messages$SemanticVersion$Builder;
import cn.leancloud.Messages$SemanticVersionOrBuilder;
import cn.leancloud.Messages$SystemInfo$1;
import cn.leancloud.Messages$SystemInfo$Builder;
import cn.leancloud.Messages$SystemInfoOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$SystemInfo
extends GeneratedMessageV3
implements Messages$SystemInfoOrBuilder {
    public static final int ANDROIDVERSION_FIELD_NUMBER = 3;
    private static final Messages$SystemInfo DEFAULT_INSTANCE;
    public static final int DEVICETYPE_FIELD_NUMBER = 1;
    public static final int ISEMULATOR_FIELD_NUMBER = 4;
    public static final int OSVERSION_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private Messages$AndroidVersion androidVersion_;
    private int bitField0_;
    private int deviceType_;
    private boolean isEmulator_;
    private byte memoizedIsInitialized = (byte)-1;
    private Messages$SemanticVersion osVersion_;

    static {
        Object object = new Messages$SystemInfo();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$SystemInfo$1();
    }

    private Messages$SystemInfo() {
        this.deviceType_ = 0;
        this.isEmulator_ = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$SystemInfo(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block18: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            int n13 = 8;
                            if (n12 != n13) {
                                Object object3;
                                int n14 = 18;
                                GeneratedMessageV3$Builder generatedMessageV3$Builder = null;
                                if (n12 != n14) {
                                    n14 = 26;
                                    if (n12 != n14) {
                                        n14 = 32;
                                        if (n12 != n14) {
                                            if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                            break block18;
                                        } else {
                                            this.bitField0_ = n12 = this.bitField0_ | n13;
                                            n12 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                                            this.isEmulator_ = n12;
                                            continue;
                                        }
                                    }
                                    n12 = this.bitField0_;
                                    n11 = 4;
                                    if ((n12 &= n11) == n11) {
                                        object3 = this.androidVersion_;
                                        generatedMessageV3$Builder = ((Messages$AndroidVersion)object3).toBuilder();
                                    }
                                    object3 = Messages$AndroidVersion.PARSER;
                                    object3 = ((CodedInputStream)object).readMessage((Parser)object3, (ExtensionRegistryLite)object2);
                                    this.androidVersion_ = object3 = (Messages$AndroidVersion)object3;
                                    if (generatedMessageV3$Builder != null) {
                                        ((Messages$AndroidVersion$Builder)generatedMessageV3$Builder).mergeFrom((Messages$AndroidVersion)object3);
                                        this.androidVersion_ = object3 = ((Messages$AndroidVersion$Builder)generatedMessageV3$Builder).buildPartial();
                                    }
                                    this.bitField0_ = n12 = this.bitField0_ | n11;
                                    continue;
                                }
                                n12 = this.bitField0_;
                                n11 = 2;
                                if ((n12 &= n11) == n11) {
                                    object3 = this.osVersion_;
                                    generatedMessageV3$Builder = ((Messages$SemanticVersion)object3).toBuilder();
                                }
                                object3 = Messages$SemanticVersion.PARSER;
                                object3 = ((CodedInputStream)object).readMessage((Parser)object3, (ExtensionRegistryLite)object2);
                                this.osVersion_ = object3 = (Messages$SemanticVersion)object3;
                                if (generatedMessageV3$Builder != null) {
                                    ((Messages$SemanticVersion$Builder)generatedMessageV3$Builder).mergeFrom((Messages$SemanticVersion)object3);
                                    this.osVersion_ = object3 = ((Messages$SemanticVersion$Builder)generatedMessageV3$Builder).buildPartial();
                                }
                                this.bitField0_ = n12 = this.bitField0_ | n11;
                                continue;
                            }
                            n12 = ((CodedInputStream)object).readEnum();
                            Messages$DeviceType messages$DeviceType = Messages$DeviceType.valueOf(n12);
                            if (messages$DeviceType == null) {
                                unknownFieldSet$Builder.mergeVarintField(n11, n12);
                                continue;
                            }
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.deviceType_ = n12;
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

    public /* synthetic */ Messages$SystemInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$SystemInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$SystemInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$2900() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$3102(Messages$SystemInfo messages$SystemInfo, int n10) {
        messages$SystemInfo.deviceType_ = n10;
        return n10;
    }

    public static /* synthetic */ Messages$SemanticVersion access$3202(Messages$SystemInfo messages$SystemInfo, Messages$SemanticVersion messages$SemanticVersion) {
        messages$SystemInfo.osVersion_ = messages$SemanticVersion;
        return messages$SemanticVersion;
    }

    public static /* synthetic */ Messages$AndroidVersion access$3302(Messages$SystemInfo messages$SystemInfo, Messages$AndroidVersion messages$AndroidVersion) {
        messages$SystemInfo.androidVersion_ = messages$AndroidVersion;
        return messages$AndroidVersion;
    }

    public static /* synthetic */ boolean access$3402(Messages$SystemInfo messages$SystemInfo, boolean bl2) {
        messages$SystemInfo.isEmulator_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$3502(Messages$SystemInfo messages$SystemInfo, int n10) {
        messages$SystemInfo.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$3600(Messages$SystemInfo messages$SystemInfo) {
        return messages$SystemInfo.unknownFields;
    }

    public static Messages$SystemInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$2500();
    }

    public static Messages$SystemInfo$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$SystemInfo$Builder newBuilder(Messages$SystemInfo messages$SystemInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$SystemInfo);
    }

    public static Messages$SystemInfo parseDelimitedFrom(InputStream inputStream) {
        return (Messages$SystemInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$SystemInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SystemInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$SystemInfo parseFrom(ByteString byteString) {
        return (Messages$SystemInfo)PARSER.parseFrom(byteString);
    }

    public static Messages$SystemInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SystemInfo)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$SystemInfo parseFrom(CodedInputStream codedInputStream) {
        return (Messages$SystemInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$SystemInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SystemInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$SystemInfo parseFrom(InputStream inputStream) {
        return (Messages$SystemInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$SystemInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SystemInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$SystemInfo parseFrom(ByteBuffer byteBuffer) {
        return (Messages$SystemInfo)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$SystemInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SystemInfo)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$SystemInfo parseFrom(byte[] byArray) {
        return (Messages$SystemInfo)PARSER.parseFrom(byArray);
    }

    public static Messages$SystemInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SystemInfo)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        GeneratedMessageV3 generatedMessageV3;
        MessageLite messageLite;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11 != 0;
        }
        int n12 = object instanceof Messages$SystemInfo;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (Messages$SystemInfo)object;
        n12 = this.hasDeviceType();
        if (n12 == (n10 = ((Messages$SystemInfo)object).hasDeviceType())) {
            n12 = n11;
        } else {
            n12 = 0;
            messageLite = null;
        }
        n10 = this.hasDeviceType();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.deviceType_) == (n10 = ((Messages$SystemInfo)object).deviceType_)) {
                n12 = n11;
            } else {
                n12 = 0;
                messageLite = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasOsVersion() ? 1 : 0)) == (n10 = (int)(((Messages$SystemInfo)object).hasOsVersion() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            messageLite = null;
        }
        n10 = (int)(this.hasOsVersion() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(((Messages$SemanticVersion)(messageLite = this.getOsVersion())).equals(generatedMessageV3 = ((Messages$SystemInfo)object).getOsVersion()) ? 1 : 0)) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                messageLite = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasAndroidVersion() ? 1 : 0)) == (n10 = (int)(((Messages$SystemInfo)object).hasAndroidVersion() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            messageLite = null;
        }
        n10 = (int)(this.hasAndroidVersion() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(((Messages$AndroidVersion)(messageLite = this.getAndroidVersion())).equals(generatedMessageV3 = ((Messages$SystemInfo)object).getAndroidVersion()) ? 1 : 0)) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                messageLite = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasIsEmulator() ? 1 : 0)) == (n10 = (int)(((Messages$SystemInfo)object).hasIsEmulator() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            messageLite = null;
        }
        n10 = (int)(this.hasIsEmulator() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(this.getIsEmulator() ? 1 : 0)) == (n10 = (int)(((Messages$SystemInfo)object).getIsEmulator() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                messageLite = null;
            }
        }
        if (n12 == 0 || !(bl2 = ((UnknownFieldSet)(messageLite = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public Messages$AndroidVersion getAndroidVersion() {
        Messages$AndroidVersion messages$AndroidVersion = this.androidVersion_;
        if (messages$AndroidVersion == null) {
            messages$AndroidVersion = Messages$AndroidVersion.getDefaultInstance();
        }
        return messages$AndroidVersion;
    }

    public Messages$AndroidVersionOrBuilder getAndroidVersionOrBuilder() {
        Messages$AndroidVersion messages$AndroidVersion = this.androidVersion_;
        if (messages$AndroidVersion == null) {
            messages$AndroidVersion = Messages$AndroidVersion.getDefaultInstance();
        }
        return messages$AndroidVersion;
    }

    public Messages$SystemInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Messages$DeviceType getDeviceType() {
        int n10 = this.deviceType_;
        Messages$DeviceType messages$DeviceType = Messages$DeviceType.valueOf(n10);
        if (messages$DeviceType == null) {
            messages$DeviceType = Messages$DeviceType.unknown;
        }
        return messages$DeviceType;
    }

    public boolean getIsEmulator() {
        return this.isEmulator_;
    }

    public Messages$SemanticVersion getOsVersion() {
        Messages$SemanticVersion messages$SemanticVersion = this.osVersion_;
        if (messages$SemanticVersion == null) {
            messages$SemanticVersion = Messages$SemanticVersion.getDefaultInstance();
        }
        return messages$SemanticVersion;
    }

    public Messages$SemanticVersionOrBuilder getOsVersionOrBuilder() {
        Messages$SemanticVersion messages$SemanticVersion = this.osVersion_;
        if (messages$SemanticVersion == null) {
            messages$SemanticVersion = Messages$SemanticVersion.getDefaultInstance();
        }
        return messages$SemanticVersion;
    }

    public Parser getParserForType() {
        return PARSER;
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
        if ((n11 &= n12) == n12) {
            n11 = this.deviceType_;
            n11 = CodedOutputStream.computeEnumSize(n12, n11);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            Messages$SemanticVersion messages$SemanticVersion = this.getOsVersion();
            n11 = CodedOutputStream.computeMessageSize(n12, messages$SemanticVersion);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            Messages$AndroidVersion messages$AndroidVersion = this.getAndroidVersion();
            n11 = CodedOutputStream.computeMessageSize(3, messages$AndroidVersion);
            n10 += n11;
        }
        n11 = this.bitField0_;
        int n13 = 8;
        if ((n11 &= n13) == n13) {
            n11 = (int)(this.isEmulator_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n12, n11 != 0);
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
    public boolean hasAndroidVersion() {
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

    public boolean hasDeviceType() {
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
    public boolean hasIsEmulator() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasOsVersion() {
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

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$SystemInfo.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasDeviceType() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.deviceType_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOsVersion() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getOsVersion();
            n11 = ((Messages$SemanticVersion)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAndroidVersion() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getAndroidVersion();
            n11 = ((Messages$AndroidVersion)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasIsEmulator() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            n11 = Internal.hashBoolean(this.getIsEmulator());
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$2600().ensureFieldAccessorsInitialized(Messages$SystemInfo.class, Messages$SystemInfo$Builder.class);
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

    public Messages$SystemInfo$Builder newBuilderForType() {
        return Messages$SystemInfo.newBuilder();
    }

    public Messages$SystemInfo$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$SystemInfo$Builder messages$SystemInfo$Builder = new Messages$SystemInfo$Builder(generatedMessageV3$BuilderParent, null);
        return messages$SystemInfo$Builder;
    }

    public Messages$SystemInfo$Builder toBuilder() {
        Messages$SystemInfoOrBuilder messages$SystemInfoOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$SystemInfoOrBuilder) {
            messages$SystemInfoOrBuilder = new Messages$SystemInfo$Builder(null);
        } else {
            messages$SystemInfoOrBuilder = new Messages$SystemInfo$Builder(null);
            messages$SystemInfoOrBuilder = ((Messages$SystemInfo$Builder)messages$SystemInfoOrBuilder).mergeFrom(this);
        }
        return messages$SystemInfoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int bl2 = this.bitField0_;
        int n19 = 1;
        int n20 = bl2 & n19;
        if (n20 == n19) {
            int n21 = this.deviceType_;
            codedOutputStream.writeEnum(n19, n21);
        }
        if ((n18 = (n17 = this.bitField0_) & (n16 = 2)) == n16) {
            Messages$SemanticVersion messages$SemanticVersion = this.getOsVersion();
            codedOutputStream.writeMessage(n16, messages$SemanticVersion);
        }
        if ((n15 = (n14 = this.bitField0_) & (n13 = 4)) == n13) {
            int n22 = 3;
            Messages$AndroidVersion messages$AndroidVersion = this.getAndroidVersion();
            codedOutputStream.writeMessage(n22, messages$AndroidVersion);
        }
        if ((n12 = (n11 = this.bitField0_) & (n10 = 8)) == n10) {
            boolean bl3 = this.isEmulator_;
            codedOutputStream.writeBool(n13, bl3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

