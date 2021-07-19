/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ErrorCommand$1;
import cn.leancloud.Messages$ErrorCommand$Builder;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$ErrorCommand
extends GeneratedMessageV3
implements Messages$ErrorCommandOrBuilder {
    public static final int APPCODE_FIELD_NUMBER = 3;
    public static final int APPMSG_FIELD_NUMBER = 6;
    public static final int CODE_FIELD_NUMBER = 1;
    private static final Messages$ErrorCommand DEFAULT_INSTANCE;
    public static final int DETAIL_FIELD_NUMBER = 4;
    public static final Parser PARSER;
    public static final int PIDS_FIELD_NUMBER = 5;
    public static final int REASON_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private int appCode_;
    private volatile Object appMsg_;
    private int bitField0_;
    private int code_;
    private volatile Object detail_;
    private byte memoizedIsInitialized;
    private LazyStringList pids_;
    private volatile Object reason_;

    static {
        Object object = new Messages$ErrorCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$ErrorCommand$1();
    }

    private Messages$ErrorCommand() {
        LazyStringList lazyStringList;
        this.memoizedIsInitialized = (byte)-1;
        this.code_ = 0;
        String string2 = "";
        this.reason_ = string2;
        this.appCode_ = 0;
        this.detail_ = string2;
        this.pids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.appMsg_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$ErrorCommand(CodedInputStream object, ExtensionRegistryLite object2) {
        int n10;
        int n11;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block17: {
            Throwable throwable2;
            this();
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n12 = 0;
            n11 = 0;
            while (true) {
                n10 = 16;
                if (n12 != 0) break block17;
                try {
                    try {
                        int n13;
                        block18: {
                            int n14 = ((CodedInputStream)object).readTag();
                            n13 = 1;
                            if (n14 != 0) {
                                int n15 = 8;
                                if (n14 != n15) {
                                    ByteString byteString;
                                    int n16 = 18;
                                    if (n14 != n16) {
                                        n16 = 24;
                                        if (n14 != n16) {
                                            n16 = 34;
                                            if (n14 != n16) {
                                                LazyStringList lazyStringList;
                                                n15 = 42;
                                                if (n14 != n15) {
                                                    n15 = 50;
                                                    if (n14 != n15) {
                                                        n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n14) ? 1 : 0);
                                                        if (n10 != 0) continue;
                                                        break block18;
                                                    } else {
                                                        byteString = ((CodedInputStream)object).readBytes();
                                                        this.bitField0_ = n13 = this.bitField0_ | n10;
                                                        this.appMsg_ = byteString;
                                                        continue;
                                                    }
                                                }
                                                byteString = ((CodedInputStream)object).readBytes();
                                                n13 = n11 & 0x10;
                                                if (n13 != n10) {
                                                    this.pids_ = lazyStringList = new LazyStringArrayList();
                                                    n11 |= 0x10;
                                                }
                                                lazyStringList = this.pids_;
                                                lazyStringList.add(byteString);
                                                continue;
                                            }
                                            byteString = ((CodedInputStream)object).readBytes();
                                            this.bitField0_ = n13 = this.bitField0_ | n15;
                                            this.detail_ = byteString;
                                            continue;
                                        }
                                        this.bitField0_ = n14 = this.bitField0_ | 4;
                                        this.appCode_ = n14 = ((CodedInputStream)object).readInt32();
                                        continue;
                                    }
                                    byteString = ((CodedInputStream)object).readBytes();
                                    this.bitField0_ = n13 = this.bitField0_ | 2;
                                    this.reason_ = byteString;
                                    continue;
                                }
                                this.bitField0_ = n14 = this.bitField0_ | n13;
                                this.code_ = n14 = ((CodedInputStream)object).readInt32();
                                continue;
                            }
                        }
                        n12 = n13;
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
            int n17 = n11 & 0x10;
            if (n17 == n10) {
                this.pids_ = object2 = this.pids_.getUnmodifiableView();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n18 = n11 & 0x10;
        if (n18 == n10) {
            this.pids_ = object = this.pids_.getUnmodifiableView();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$ErrorCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$ErrorCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$ErrorCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$16500() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$16702(Messages$ErrorCommand messages$ErrorCommand, int n10) {
        messages$ErrorCommand.code_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$16800(Messages$ErrorCommand messages$ErrorCommand) {
        return messages$ErrorCommand.reason_;
    }

    public static /* synthetic */ Object access$16802(Messages$ErrorCommand messages$ErrorCommand, Object object) {
        messages$ErrorCommand.reason_ = object;
        return object;
    }

    public static /* synthetic */ int access$16902(Messages$ErrorCommand messages$ErrorCommand, int n10) {
        messages$ErrorCommand.appCode_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$17000(Messages$ErrorCommand messages$ErrorCommand) {
        return messages$ErrorCommand.detail_;
    }

    public static /* synthetic */ Object access$17002(Messages$ErrorCommand messages$ErrorCommand, Object object) {
        messages$ErrorCommand.detail_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$17100(Messages$ErrorCommand messages$ErrorCommand) {
        return messages$ErrorCommand.pids_;
    }

    public static /* synthetic */ LazyStringList access$17102(Messages$ErrorCommand messages$ErrorCommand, LazyStringList lazyStringList) {
        messages$ErrorCommand.pids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Object access$17200(Messages$ErrorCommand messages$ErrorCommand) {
        return messages$ErrorCommand.appMsg_;
    }

    public static /* synthetic */ Object access$17202(Messages$ErrorCommand messages$ErrorCommand, Object object) {
        messages$ErrorCommand.appMsg_ = object;
        return object;
    }

    public static /* synthetic */ int access$17302(Messages$ErrorCommand messages$ErrorCommand, int n10) {
        messages$ErrorCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$17400(Messages$ErrorCommand messages$ErrorCommand) {
        return messages$ErrorCommand.unknownFields;
    }

    public static Messages$ErrorCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$16100();
    }

    public static Messages$ErrorCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$ErrorCommand$Builder newBuilder(Messages$ErrorCommand messages$ErrorCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$ErrorCommand);
    }

    public static Messages$ErrorCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$ErrorCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$ErrorCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ErrorCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ErrorCommand parseFrom(ByteString byteString) {
        return (Messages$ErrorCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$ErrorCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ErrorCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$ErrorCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$ErrorCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$ErrorCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ErrorCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$ErrorCommand parseFrom(InputStream inputStream) {
        return (Messages$ErrorCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$ErrorCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ErrorCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ErrorCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$ErrorCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$ErrorCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ErrorCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$ErrorCommand parseFrom(byte[] byArray) {
        return (Messages$ErrorCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$ErrorCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ErrorCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11;
        }
        int n12 = object instanceof Messages$ErrorCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$ErrorCommand)object;
        n12 = this.hasCode();
        if (n12 == (n10 = ((Messages$ErrorCommand)object).hasCode())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCode();
        if (n10 != 0) {
            if (n12 && (n12 = this.getCode()) == (n10 = ((Messages$ErrorCommand)object).getCode())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasReason() ? 1 : 0)) == (n10 = (int)(((Messages$ErrorCommand)object).hasReason() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasReason() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getReason())).equals(object2 = ((Messages$ErrorCommand)object).getReason()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasAppCode() ? 1 : 0)) == (n10 = (int)(((Messages$ErrorCommand)object).hasAppCode() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAppCode() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getAppCode()) == (n10 = ((Messages$ErrorCommand)object).getAppCode())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasDetail() ? 1 : 0)) == (n10 = (int)(((Messages$ErrorCommand)object).hasDetail() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasDetail() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getDetail())).equals(object2 = ((Messages$ErrorCommand)object).getDetail()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)((object3 = this.getPidsList()).equals(object2 = ((Messages$ErrorCommand)object).getPidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)(this.hasAppMsg() ? 1 : 0)) == (n10 = (int)(((Messages$ErrorCommand)object).hasAppMsg() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAppMsg() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getAppMsg())).equals(object2 = ((Messages$ErrorCommand)object).getAppMsg()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (!n12 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            n11 = 0;
        }
        return n11;
    }

    public int getAppCode() {
        return this.appCode_;
    }

    public String getAppMsg() {
        Object object = this.appMsg_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.appMsg_ = string2;
        }
        return string2;
    }

    public ByteString getAppMsgBytes() {
        Object object = this.appMsg_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.appMsg_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getCode() {
        return this.code_;
    }

    public Messages$ErrorCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getDetail() {
        Object object = this.detail_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.detail_ = string2;
        }
        return string2;
    }

    public ByteString getDetailBytes() {
        Object object = this.detail_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.detail_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public String getPids(int n10) {
        return (String)this.pids_.get(n10);
    }

    public ByteString getPidsBytes(int n10) {
        return this.pids_.getByteString(n10);
    }

    public int getPidsCount() {
        return this.pids_.size();
    }

    public ProtocolStringList getPidsList() {
        return this.pids_;
    }

    public String getReason() {
        Object object = this.reason_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.reason_ = string2;
        }
        return string2;
    }

    public ByteString getReasonBytes() {
        Object object = this.reason_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.reason_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getSerializedSize() {
        Object object;
        int n10;
        Object object2;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = this.bitField0_;
        n12 = 1;
        int n13 = 0;
        Object object3 = null;
        if ((n11 &= n12) == n12) {
            n11 = this.code_;
            n11 = CodedOutputStream.computeInt32Size(n12, n11) + 0;
        } else {
            n11 = 0;
        }
        int n14 = this.bitField0_;
        int n15 = 2;
        if ((n14 &= n15) == n15) {
            object2 = this.reason_;
            n14 = GeneratedMessageV3.computeStringSize(n15, object2);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n15 = 4;
        if ((n14 &= n15) == n15) {
            n10 = this.appCode_;
            n14 = CodedOutputStream.computeInt32Size(3, n10);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n10 = 8;
        if ((n14 &= n10) == n10) {
            object2 = this.detail_;
            n14 = GeneratedMessageV3.computeStringSize(n15, object2);
            n11 += n14;
        }
        n14 = 0;
        object2 = null;
        while (n13 < (n15 = (object = this.pids_).size())) {
            object = this.pids_.getRaw(n13);
            n15 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n14 += n15;
            ++n13;
        }
        n11 += n14;
        object3 = this.getPidsList();
        n13 = object3.size() * n12;
        n11 += n13;
        n12 = this.bitField0_;
        n13 = 16;
        if ((n12 &= n13) == n13) {
            object3 = this.appMsg_;
            n12 = GeneratedMessageV3.computeStringSize(6, object3);
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
    public boolean hasAppCode() {
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
    public boolean hasAppMsg() {
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

    public boolean hasCode() {
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
    public boolean hasDetail() {
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
    public boolean hasReason() {
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
        Object object = Messages$ErrorCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCode() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.getCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasReason() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getReason();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAppCode() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = this.getAppCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDetail() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getDetail();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getPidsCount()) > 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAppMsg() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getAppMsg();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$16200().ensureFieldAccessorsInitialized(Messages$ErrorCommand.class, Messages$ErrorCommand$Builder.class);
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
        by2 = this.hasCode();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasReason();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$ErrorCommand$Builder newBuilderForType() {
        return Messages$ErrorCommand.newBuilder();
    }

    public Messages$ErrorCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$ErrorCommand$Builder messages$ErrorCommand$Builder = new Messages$ErrorCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$ErrorCommand$Builder;
    }

    public Messages$ErrorCommand$Builder toBuilder() {
        Messages$ErrorCommandOrBuilder messages$ErrorCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$ErrorCommandOrBuilder) {
            messages$ErrorCommandOrBuilder = new Messages$ErrorCommand$Builder(null);
        } else {
            messages$ErrorCommandOrBuilder = new Messages$ErrorCommand$Builder(null);
            messages$ErrorCommandOrBuilder = ((Messages$ErrorCommand$Builder)messages$ErrorCommandOrBuilder).mergeFrom(this);
        }
        return messages$ErrorCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        Object object2;
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            n11 = this.code_;
            codedOutputStream.writeInt32(n12, n11);
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            object2 = this.reason_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            n11 = 3;
            n10 = this.appCode_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n11 = this.bitField0_;
        n10 = 8;
        if ((n11 &= n10) == n10) {
            object2 = this.detail_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        object2 = null;
        for (n11 = 0; n11 < (n12 = (object = this.pids_).size()); ++n11) {
            n12 = 5;
            Object object3 = this.pids_.getRaw(n11);
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n11 = this.bitField0_;
        n12 = 16;
        if ((n11 &= n12) == n12) {
            n11 = 6;
            object = this.appMsg_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

