/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ConvMemberInfo$1;
import cn.leancloud.Messages$ConvMemberInfo$Builder;
import cn.leancloud.Messages$ConvMemberInfoOrBuilder;
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

public final class Messages$ConvMemberInfo
extends GeneratedMessageV3
implements Messages$ConvMemberInfoOrBuilder {
    private static final Messages$ConvMemberInfo DEFAULT_INSTANCE;
    public static final int INFOID_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int PID_FIELD_NUMBER = 1;
    public static final int ROLE_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object infoId_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object pid_;
    private volatile Object role_;

    static {
        Object object = new Messages$ConvMemberInfo();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$ConvMemberInfo$1();
    }

    private Messages$ConvMemberInfo() {
        String string2 = "";
        this.pid_ = string2;
        this.role_ = string2;
        this.infoId_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$ConvMemberInfo(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block12: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            ByteString byteString;
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 18;
                                if (n12 != n13) {
                                    n13 = 26;
                                    if (n12 != n13) {
                                        if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                        break block12;
                                    } else {
                                        byteString = ((CodedInputStream)object).readBytes();
                                        this.bitField0_ = n11 = this.bitField0_ | 4;
                                        this.infoId_ = byteString;
                                        continue;
                                    }
                                }
                                byteString = ((CodedInputStream)object).readBytes();
                                this.bitField0_ = n11 = this.bitField0_ | 2;
                                this.role_ = byteString;
                                continue;
                            }
                            byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.pid_ = byteString;
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

    public /* synthetic */ Messages$ConvMemberInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$ConvMemberInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$ConvMemberInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$9100() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$9300(Messages$ConvMemberInfo messages$ConvMemberInfo) {
        return messages$ConvMemberInfo.pid_;
    }

    public static /* synthetic */ Object access$9302(Messages$ConvMemberInfo messages$ConvMemberInfo, Object object) {
        messages$ConvMemberInfo.pid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$9400(Messages$ConvMemberInfo messages$ConvMemberInfo) {
        return messages$ConvMemberInfo.role_;
    }

    public static /* synthetic */ Object access$9402(Messages$ConvMemberInfo messages$ConvMemberInfo, Object object) {
        messages$ConvMemberInfo.role_ = object;
        return object;
    }

    public static /* synthetic */ Object access$9500(Messages$ConvMemberInfo messages$ConvMemberInfo) {
        return messages$ConvMemberInfo.infoId_;
    }

    public static /* synthetic */ Object access$9502(Messages$ConvMemberInfo messages$ConvMemberInfo, Object object) {
        messages$ConvMemberInfo.infoId_ = object;
        return object;
    }

    public static /* synthetic */ int access$9602(Messages$ConvMemberInfo messages$ConvMemberInfo, int n10) {
        messages$ConvMemberInfo.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$9700(Messages$ConvMemberInfo messages$ConvMemberInfo) {
        return messages$ConvMemberInfo.unknownFields;
    }

    public static Messages$ConvMemberInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$8700();
    }

    public static Messages$ConvMemberInfo$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$ConvMemberInfo$Builder newBuilder(Messages$ConvMemberInfo messages$ConvMemberInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$ConvMemberInfo);
    }

    public static Messages$ConvMemberInfo parseDelimitedFrom(InputStream inputStream) {
        return (Messages$ConvMemberInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$ConvMemberInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvMemberInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ConvMemberInfo parseFrom(ByteString byteString) {
        return (Messages$ConvMemberInfo)PARSER.parseFrom(byteString);
    }

    public static Messages$ConvMemberInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvMemberInfo)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$ConvMemberInfo parseFrom(CodedInputStream codedInputStream) {
        return (Messages$ConvMemberInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$ConvMemberInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvMemberInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$ConvMemberInfo parseFrom(InputStream inputStream) {
        return (Messages$ConvMemberInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$ConvMemberInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvMemberInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ConvMemberInfo parseFrom(ByteBuffer byteBuffer) {
        return (Messages$ConvMemberInfo)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$ConvMemberInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvMemberInfo)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$ConvMemberInfo parseFrom(byte[] byArray) {
        return (Messages$ConvMemberInfo)PARSER.parseFrom(byArray);
    }

    public static Messages$ConvMemberInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvMemberInfo)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl5 = object instanceof Messages$ConvMemberInfo;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$ConvMemberInfo)object;
        bl5 = this.hasPid();
        if (bl5 == (bl3 = ((Messages$ConvMemberInfo)object).hasPid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasPid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getPid())).equals(string2 = ((Messages$ConvMemberInfo)object).getPid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasRole()) == (bl3 = ((Messages$ConvMemberInfo)object).hasRole())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasRole();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getRole())).equals(string2 = ((Messages$ConvMemberInfo)object).getRole()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasInfoId()) == (bl3 = ((Messages$ConvMemberInfo)object).hasInfoId())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasInfoId();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getInfoId())).equals(string2 = ((Messages$ConvMemberInfo)object).getInfoId()))) {
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

    public Messages$ConvMemberInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getInfoId() {
        Object object = this.infoId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.infoId_ = string2;
        }
        return string2;
    }

    public ByteString getInfoIdBytes() {
        Object object = this.infoId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.infoId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public String getPid() {
        Object object = this.pid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.pid_ = string2;
        }
        return string2;
    }

    public ByteString getPidBytes() {
        Object object = this.pid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.pid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getRole() {
        Object object = this.role_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.role_ = string2;
        }
        return string2;
    }

    public ByteString getRoleBytes() {
        Object object = this.role_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.role_ = object = ByteString.copyFromUtf8((String)object);
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
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            object = this.pid_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            object = this.role_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            Object object2 = this.infoId_;
            n11 = GeneratedMessageV3.computeStringSize(3, object2);
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
    public boolean hasInfoId() {
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

    public boolean hasPid() {
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
    public boolean hasRole() {
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
        Object object = Messages$ConvMemberInfo.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasPid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getPid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasRole() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getRole();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasInfoId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getInfoId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$8800().ensureFieldAccessorsInitialized(Messages$ConvMemberInfo.class, Messages$ConvMemberInfo$Builder.class);
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

    public Messages$ConvMemberInfo$Builder newBuilderForType() {
        return Messages$ConvMemberInfo.newBuilder();
    }

    public Messages$ConvMemberInfo$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$ConvMemberInfo$Builder messages$ConvMemberInfo$Builder = new Messages$ConvMemberInfo$Builder(generatedMessageV3$BuilderParent, null);
        return messages$ConvMemberInfo$Builder;
    }

    public Messages$ConvMemberInfo$Builder toBuilder() {
        Messages$ConvMemberInfoOrBuilder messages$ConvMemberInfoOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$ConvMemberInfoOrBuilder) {
            messages$ConvMemberInfoOrBuilder = new Messages$ConvMemberInfo$Builder(null);
        } else {
            messages$ConvMemberInfoOrBuilder = new Messages$ConvMemberInfo$Builder(null);
            messages$ConvMemberInfoOrBuilder = ((Messages$ConvMemberInfo$Builder)messages$ConvMemberInfoOrBuilder).mergeFrom(this);
        }
        return messages$ConvMemberInfoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            object = this.pid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object = this.role_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            Object object2 = this.infoId_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

