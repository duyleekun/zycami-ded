/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$DirectCommand;
import cn.leancloud.Messages$DirectCommandOrBuilder;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Messages$DirectCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$DirectCommandOrBuilder {
    private ByteString binaryMsg_;
    private int bitField0_;
    private Object cid_;
    private int convType_;
    private Object dt_;
    private Object fromPeerId_;
    private boolean hasMore_;
    private Object id_;
    private boolean mentionAll_;
    private LazyStringList mentionPids_;
    private Object msg_;
    private boolean offline_;
    private long patchTimestamp_;
    private Object pushData_;
    private boolean r_;
    private Object roomId_;
    private long timestamp_;
    private LazyStringList toPeerIds_;
    private boolean transient_;
    private Object uid_;
    private boolean will_;

    private Messages$DirectCommand$Builder() {
        LazyStringList lazyStringList;
        Object object;
        this.msg_ = object = "";
        this.uid_ = object;
        this.fromPeerId_ = object;
        this.toPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.cid_ = object;
        this.id_ = object;
        this.dt_ = object;
        this.roomId_ = object;
        this.pushData_ = object;
        this.binaryMsg_ = object = ByteString.EMPTY;
        this.mentionPids_ = lazyStringList;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$DirectCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$DirectCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        LazyStringList lazyStringList;
        this.msg_ = object = "";
        this.uid_ = object;
        this.fromPeerId_ = object;
        this.toPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.cid_ = object;
        this.id_ = object;
        this.dt_ = object;
        this.roomId_ = object;
        this.pushData_ = object;
        this.binaryMsg_ = object = ByteString.EMPTY;
        this.mentionPids_ = lazyStringList;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$DirectCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureMentionPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 131072;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.mentionPids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.mentionPids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureToPeerIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 64;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.toPeerIds_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.toPeerIds_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$17600();
    }

    private void maybeForceBuilderInitialization() {
        Messages$DirectCommand.access$18000();
    }

    public Messages$DirectCommand$Builder addAllMentionPids(Iterable iterable) {
        this.ensureMentionPidsIsMutable();
        LazyStringList lazyStringList = this.mentionPids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder addAllToPeerIds(Iterable iterable) {
        this.ensureToPeerIdsIsMutable();
        LazyStringList lazyStringList = this.toPeerIds_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder addMentionPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder addMentionPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$DirectCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$DirectCommand$Builder addToPeerIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureToPeerIdsIsMutable();
        this.toPeerIds_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder addToPeerIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureToPeerIdsIsMutable();
        this.toPeerIds_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand build() {
        Messages$DirectCommand messages$DirectCommand = this.buildPartial();
        boolean bl2 = messages$DirectCommand.isInitialized();
        if (bl2) {
            return messages$DirectCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$DirectCommand);
    }

    public Messages$DirectCommand buildPartial() {
        int n10;
        Messages$DirectCommand messages$DirectCommand = new Messages$DirectCommand(this, null);
        int n11 = this.bitField0_;
        int n12 = n11 & 1;
        int n13 = 1;
        if (n12 != n13) {
            n13 = 0;
        }
        Object object = this.msg_;
        Messages$DirectCommand.access$18202(messages$DirectCommand, object);
        n12 = n11 & 2;
        int n14 = 2;
        if (n12 == n14) {
            n13 |= 2;
        }
        object = this.uid_;
        Messages$DirectCommand.access$18302(messages$DirectCommand, object);
        n12 = n11 & 4;
        n14 = 4;
        if (n12 == n14) {
            n13 |= 4;
        }
        object = this.fromPeerId_;
        Messages$DirectCommand.access$18402(messages$DirectCommand, object);
        n12 = n11 & 8;
        n14 = 8;
        if (n12 == n14) {
            n13 |= 8;
        }
        long l10 = this.timestamp_;
        Messages$DirectCommand.access$18502(messages$DirectCommand, l10);
        n12 = n11 & 0x10;
        n14 = 16;
        if (n12 == n14) {
            n13 |= 0x10;
        }
        n12 = (int)(this.offline_ ? 1 : 0);
        Messages$DirectCommand.access$18602(messages$DirectCommand, n12 != 0);
        n12 = n11 & 0x20;
        n14 = 32;
        if (n12 == n14) {
            n13 |= 0x20;
        }
        n12 = (int)(this.hasMore_ ? 1 : 0);
        Messages$DirectCommand.access$18702(messages$DirectCommand, n12 != 0);
        n12 = this.bitField0_;
        n14 = 64;
        if ((n12 &= n14) == n14) {
            this.toPeerIds_ = object = this.toPeerIds_.getUnmodifiableView();
            this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFBF;
        }
        object = this.toPeerIds_;
        Messages$DirectCommand.access$18802(messages$DirectCommand, (LazyStringList)object);
        n12 = n11 & 0x80;
        n14 = 128;
        if (n12 == n14) {
            n13 |= 0x40;
        }
        n12 = (int)(this.r_ ? 1 : 0);
        Messages$DirectCommand.access$18902(messages$DirectCommand, n12 != 0);
        n12 = n11 & 0x100;
        n14 = 256;
        if (n12 == n14) {
            n13 |= 0x80;
        }
        object = this.cid_;
        Messages$DirectCommand.access$19002(messages$DirectCommand, object);
        n12 = n11 & 0x200;
        n14 = 512;
        if (n12 == n14) {
            n13 |= 0x100;
        }
        object = this.id_;
        Messages$DirectCommand.access$19102(messages$DirectCommand, object);
        n12 = n11 & 0x400;
        n14 = 1024;
        if (n12 == n14) {
            n13 |= 0x200;
        }
        n12 = (int)(this.transient_ ? 1 : 0);
        Messages$DirectCommand.access$19202(messages$DirectCommand, n12 != 0);
        n12 = n11 & 0x800;
        n14 = 2048;
        if (n12 == n14) {
            n13 |= 0x400;
        }
        object = this.dt_;
        Messages$DirectCommand.access$19302(messages$DirectCommand, object);
        n12 = n11 & 0x1000;
        n14 = 4096;
        if (n12 == n14) {
            n13 |= 0x800;
        }
        object = this.roomId_;
        Messages$DirectCommand.access$19402(messages$DirectCommand, object);
        n12 = n11 & 0x2000;
        n14 = 8192;
        if (n12 == n14) {
            n13 |= 0x1000;
        }
        object = this.pushData_;
        Messages$DirectCommand.access$19502(messages$DirectCommand, object);
        n12 = n11 & 0x4000;
        n14 = 16384;
        if (n12 == n14) {
            n13 |= 0x2000;
        }
        n12 = (int)(this.will_ ? 1 : 0);
        Messages$DirectCommand.access$19602(messages$DirectCommand, n12 != 0);
        n12 = 32768;
        n14 = n11 & n12;
        if (n14 == n12) {
            n13 |= 0x4000;
        }
        l10 = this.patchTimestamp_;
        Messages$DirectCommand.access$19702(messages$DirectCommand, l10);
        n14 = 65536;
        int n15 = n11 & n14;
        if (n15 == n14) {
            n13 |= n12;
        }
        object = this.binaryMsg_;
        Messages$DirectCommand.access$19802(messages$DirectCommand, (ByteString)object);
        n12 = this.bitField0_;
        n15 = 131072;
        if ((n12 &= n15) == n15) {
            this.mentionPids_ = object = this.mentionPids_.getUnmodifiableView();
            n12 = this.bitField0_;
            n10 = -131073;
            this.bitField0_ = n12 &= n10;
        }
        object = this.mentionPids_;
        Messages$DirectCommand.access$19902(messages$DirectCommand, (LazyStringList)object);
        n12 = 262144;
        n10 = n11 & n12;
        if (n10 == n12) {
            n13 |= n14;
        }
        n12 = (int)(this.mentionAll_ ? 1 : 0);
        Messages$DirectCommand.access$20002(messages$DirectCommand, n12 != 0);
        n12 = 524288;
        if ((n11 &= n12) == n12) {
            n13 |= n15;
        }
        n11 = this.convType_;
        Messages$DirectCommand.access$20102(messages$DirectCommand, n11);
        Messages$DirectCommand.access$20202(messages$DirectCommand, n13);
        this.onBuilt();
        return messages$DirectCommand;
    }

    public Messages$DirectCommand$Builder clear() {
        ByteString byteString;
        int n10;
        LazyStringList lazyStringList;
        long l10;
        int n11;
        super.clear();
        String string2 = "";
        this.msg_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.uid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.fromPeerId_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.timestamp_ = l10 = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.offline_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.hasMore_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.toPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFFBF;
        this.r_ = false;
        this.bitField0_ = n11 &= 0xFFFFFF7F;
        this.cid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFEFF;
        this.id_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFDFF;
        this.transient_ = false;
        this.bitField0_ = n11 &= 0xFFFFFBFF;
        this.dt_ = string2;
        this.bitField0_ = n11 &= 0xFFFFF7FF;
        this.roomId_ = string2;
        this.bitField0_ = n11 &= 0xFFFFEFFF;
        this.pushData_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFDFFF;
        this.will_ = false;
        this.bitField0_ = n10 &= 0xFFFFBFFF;
        this.patchTimestamp_ = l10;
        this.bitField0_ = n10 &= 0xFFFF7FFF;
        this.binaryMsg_ = byteString = ByteString.EMPTY;
        this.bitField0_ = n10 &= 0xFFFEFFFF;
        this.mentionPids_ = lazyStringList;
        this.bitField0_ = n10 &= 0xFFFDFFFF;
        this.mentionAll_ = false;
        this.bitField0_ = n10 &= 0xFFFBFFFF;
        this.convType_ = 0;
        this.bitField0_ = n10 &= 0xFFF7FFFF;
        return this;
    }

    public Messages$DirectCommand$Builder clearBinaryMsg() {
        ByteString byteString;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFEFFFF;
        this.binaryMsg_ = byteString = Messages$DirectCommand.getDefaultInstance().getBinaryMsg();
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        String string2 = Messages$DirectCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearConvType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFF7FFFF;
        this.convType_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearDt() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        String string2 = Messages$DirectCommand.getDefaultInstance().getDt();
        this.dt_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$DirectCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$DirectCommand$Builder clearFromPeerId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$DirectCommand.getDefaultInstance().getFromPeerId();
        this.fromPeerId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearHasMore() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.hasMore_ = false;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        String string2 = Messages$DirectCommand.getDefaultInstance().getId();
        this.id_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearMentionAll() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFBFFFF;
        this.mentionAll_ = false;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearMentionPids() {
        int n10;
        LazyStringList lazyStringList;
        this.mentionPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFDFFFF;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearMsg() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$DirectCommand.getDefaultInstance().getMsg();
        this.msg_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearOffline() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.offline_ = false;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$DirectCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$DirectCommand$Builder clearPatchTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFF7FFF;
        this.patchTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearPushData() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
        String string2 = Messages$DirectCommand.getDefaultInstance().getPushData();
        this.pushData_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearR() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.r_ = false;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearRoomId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        String string2 = Messages$DirectCommand.getDefaultInstance().getRoomId();
        this.roomId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.timestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearToPeerIds() {
        int n10;
        LazyStringList lazyStringList;
        this.toPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearTransient() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.transient_ = false;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearUid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$DirectCommand.getDefaultInstance().getUid();
        this.uid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clearWill() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFBFFF;
        this.will_ = false;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder clone() {
        return (Messages$DirectCommand$Builder)super.clone();
    }

    public ByteString getBinaryMsg() {
        return this.binaryMsg_;
    }

    public String getCid() {
        Object object = this.cid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.cid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getCidBytes() {
        Object object = this.cid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.cid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getConvType() {
        return this.convType_;
    }

    public Messages$DirectCommand getDefaultInstanceForType() {
        return Messages$DirectCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$17600();
    }

    public String getDt() {
        Object object = this.dt_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.dt_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getDtBytes() {
        Object object = this.dt_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.dt_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getFromPeerId() {
        Object object = this.fromPeerId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.fromPeerId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getFromPeerIdBytes() {
        Object object = this.fromPeerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.fromPeerId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getHasMore() {
        return this.hasMore_;
    }

    public String getId() {
        Object object = this.id_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.id_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getIdBytes() {
        Object object = this.id_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.id_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getMentionAll() {
        return this.mentionAll_;
    }

    public String getMentionPids(int n10) {
        return (String)this.mentionPids_.get(n10);
    }

    public ByteString getMentionPidsBytes(int n10) {
        return this.mentionPids_.getByteString(n10);
    }

    public int getMentionPidsCount() {
        return this.mentionPids_.size();
    }

    public ProtocolStringList getMentionPidsList() {
        return this.mentionPids_.getUnmodifiableView();
    }

    public String getMsg() {
        Object object = this.msg_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.msg_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getMsgBytes() {
        Object object = this.msg_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.msg_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getOffline() {
        return this.offline_;
    }

    public long getPatchTimestamp() {
        return this.patchTimestamp_;
    }

    public String getPushData() {
        Object object = this.pushData_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.pushData_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPushDataBytes() {
        Object object = this.pushData_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.pushData_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getR() {
        return this.r_;
    }

    public String getRoomId() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.roomId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getRoomIdBytes() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.roomId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public String getToPeerIds(int n10) {
        return (String)this.toPeerIds_.get(n10);
    }

    public ByteString getToPeerIdsBytes(int n10) {
        return this.toPeerIds_.getByteString(n10);
    }

    public int getToPeerIdsCount() {
        return this.toPeerIds_.size();
    }

    public ProtocolStringList getToPeerIdsList() {
        return this.toPeerIds_.getUnmodifiableView();
    }

    public boolean getTransient() {
        return this.transient_;
    }

    public String getUid() {
        Object object = this.uid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.uid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getUidBytes() {
        Object object = this.uid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.uid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getWill() {
        return this.will_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBinaryMsg() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 65536;
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
    public boolean hasCid() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 256;
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
    public boolean hasConvType() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 524288;
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
    public boolean hasDt() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 2048;
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
    public boolean hasFromPeerId() {
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
    public boolean hasHasMore() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32;
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
    public boolean hasId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 512;
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
    public boolean hasMentionAll() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 262144;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasMsg() {
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
    public boolean hasOffline() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasPatchTimestamp() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32768;
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
    public boolean hasPushData() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 8192;
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
    public boolean hasR() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 128;
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
    public boolean hasRoomId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 4096;
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
    public boolean hasTimestamp() {
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
    public boolean hasTransient() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 1024;
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
    public boolean hasUid() {
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
    public boolean hasWill() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16384;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$17700().ensureFieldAccessorsInitialized(Messages$DirectCommand.class, Messages$DirectCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$DirectCommand$Builder mergeFrom(Messages$DirectCommand messageLite) {
        LazyStringList lazyStringList;
        long l10;
        Object object = Messages$DirectCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasMsg();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.msg_ = object = Messages$DirectCommand.access$18200(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasUid()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.uid_ = object = Messages$DirectCommand.access$18300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasFromPeerId() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.fromPeerId_ = object = Messages$DirectCommand.access$18400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getTimestamp();
            this.setTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasOffline() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getOffline() ? 1 : 0);
            this.setOffline(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasHasMore() ? 1 : 0)) != 0) {
            n10 = messageLite.getHasMore();
            this.setHasMore(n10 != 0);
        }
        if ((n10 = (object = Messages$DirectCommand.access$18800(messageLite)).isEmpty()) == 0) {
            object = this.toPeerIds_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.toPeerIds_ = object = Messages$DirectCommand.access$18800(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
            } else {
                this.ensureToPeerIdsIsMutable();
                object = this.toPeerIds_;
                lazyStringList = Messages$DirectCommand.access$18800(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasR()) != 0) {
            n10 = messageLite.getR();
            this.setR(n10 != 0);
        }
        if ((n10 = messageLite.hasCid()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x100;
            this.cid_ = object = Messages$DirectCommand.access$19000(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasId()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x200;
            this.id_ = object = Messages$DirectCommand.access$19100(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasTransient() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getTransient() ? 1 : 0);
            this.setTransient(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasDt() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x800;
            this.dt_ = object = Messages$DirectCommand.access$19300(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasRoomId()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x1000;
            this.roomId_ = object = Messages$DirectCommand.access$19400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasPushData() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x2000;
            this.pushData_ = object = Messages$DirectCommand.access$19500(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasWill() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getWill() ? 1 : 0);
            this.setWill(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasPatchTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getPatchTimestamp();
            this.setPatchTimestamp(l10);
        }
        if ((n10 = messageLite.hasBinaryMsg()) != 0) {
            object = messageLite.getBinaryMsg();
            this.setBinaryMsg((ByteString)object);
        }
        if ((n10 = (object = Messages$DirectCommand.access$19900(messageLite)).isEmpty()) == 0) {
            object = this.mentionPids_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.mentionPids_ = object = Messages$DirectCommand.access$19900(messageLite);
                n10 = this.bitField0_;
                int n11 = -131073;
                this.bitField0_ = n10 &= n11;
            } else {
                this.ensureMentionPidsIsMutable();
                object = this.mentionPids_;
                lazyStringList = Messages$DirectCommand.access$19900(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasMentionAll()) != 0) {
            n10 = messageLite.getMentionAll();
            this.setMentionAll(n10 != 0);
        }
        if ((n10 = messageLite.hasConvType()) != 0) {
            n10 = messageLite.getConvType();
            this.setConvType(n10);
        }
        messageLite = Messages$DirectCommand.access$20300(messageLite);
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Messages$DirectCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$DirectCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$DirectCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$DirectCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$DirectCommand)object2;
            }
            try {
                IOException iOException = invalidProtocolBufferException.unwrapIOException();
                throw iOException;
            }
            catch (Throwable throwable) {
                object3 = object2;
            }
        }
        if (object3 != null) {
            this.mergeFrom((Messages$DirectCommand)object3);
        }
        throw var1_6;
    }

    public Messages$DirectCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$DirectCommand;
        if (bl2) {
            message = (Messages$DirectCommand)message;
            return this.mergeFrom((Messages$DirectCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$DirectCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$DirectCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$DirectCommand$Builder setBinaryMsg(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        this.binaryMsg_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setConvType(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x80000;
        this.convType_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setDt(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.dt_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setDtBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.dt_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$DirectCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$DirectCommand$Builder setFromPeerId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.fromPeerId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setFromPeerIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.fromPeerId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setHasMore(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.hasMore_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.id_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.id_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setMentionAll(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        this.mentionAll_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setMentionPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setMsg(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.msg_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setMsgBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.msg_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setOffline(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.offline_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setPatchTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        this.patchTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setPushData(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.pushData_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setPushDataBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.pushData_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setR(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.r_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$DirectCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$DirectCommand$Builder setRoomId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.roomId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setRoomIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.roomId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.timestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setToPeerIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureToPeerIdsIsMutable();
        this.toPeerIds_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setTransient(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        this.transient_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setUid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.uid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$DirectCommand$Builder setUidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.uid_ = byteString;
        this.onChanged();
        return this;
    }

    public final Messages$DirectCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$DirectCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Messages$DirectCommand$Builder setWill(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        this.will_ = bl2;
        this.onChanged();
        return this;
    }
}

