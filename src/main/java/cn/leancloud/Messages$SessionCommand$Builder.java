/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$SessionCommand;
import cn.leancloud.Messages$SessionCommandOrBuilder;
import cn.leancloud.Messages$SystemInfo;
import cn.leancloud.Messages$SystemInfo$Builder;
import cn.leancloud.Messages$SystemInfoOrBuilder;
import com.google.protobuf.AbstractMessage;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Messages$SessionCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$SessionCommandOrBuilder {
    private int bitField0_;
    private int code_;
    private long configBitmap_;
    private Object detail_;
    private Object deviceId_;
    private Object deviceToken_;
    private long lastPatchTime_;
    private long lastUnreadNotifTime_;
    private Object n_;
    private LazyStringList onlineSessionPeerIds_;
    private boolean r_;
    private Object reason_;
    private Object s_;
    private LazyStringList sessionPeerIds_;
    private boolean sp_;
    private int stTtl_;
    private Object st_;
    private SingleFieldBuilderV3 systemInfoBuilder_;
    private Messages$SystemInfo systemInfo_;
    private long t_;
    private Object tag_;
    private Object ua_;

    private Messages$SessionCommand$Builder() {
        LazyStringList lazyStringList;
        String string2 = "";
        this.n_ = string2;
        this.s_ = string2;
        this.ua_ = string2;
        this.tag_ = string2;
        this.deviceId_ = string2;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.onlineSessionPeerIds_ = lazyStringList;
        this.st_ = string2;
        this.reason_ = string2;
        this.deviceToken_ = string2;
        this.detail_ = string2;
        this.systemInfo_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$SessionCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$SessionCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        LazyStringList lazyStringList;
        this.n_ = object = "";
        this.s_ = object;
        this.ua_ = object;
        this.tag_ = object;
        this.deviceId_ = object;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.onlineSessionPeerIds_ = lazyStringList;
        this.st_ = object;
        this.reason_ = object;
        this.deviceToken_ = object;
        this.detail_ = object;
        this.systemInfo_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$SessionCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureOnlineSessionPeerIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 256;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.onlineSessionPeerIds_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.onlineSessionPeerIds_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureSessionPeerIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 128;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.sessionPeerIds_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.sessionPeerIds_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$13200();
    }

    private SingleFieldBuilderV3 getSystemInfoFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$SystemInfo messages$SystemInfo = this.getSystemInfo();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.systemInfoBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$SystemInfo, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.systemInfo_ = null;
        }
        return this.systemInfoBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$SessionCommand.access$13600();
        if (bl2) {
            this.getSystemInfoFieldBuilder();
        }
    }

    public Messages$SessionCommand$Builder addAllOnlineSessionPeerIds(Iterable iterable) {
        this.ensureOnlineSessionPeerIdsIsMutable();
        LazyStringList lazyStringList = this.onlineSessionPeerIds_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder addAllSessionPeerIds(Iterable iterable) {
        this.ensureSessionPeerIdsIsMutable();
        LazyStringList lazyStringList = this.sessionPeerIds_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder addOnlineSessionPeerIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureOnlineSessionPeerIdsIsMutable();
        this.onlineSessionPeerIds_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder addOnlineSessionPeerIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureOnlineSessionPeerIdsIsMutable();
        this.onlineSessionPeerIds_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$SessionCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$SessionCommand$Builder addSessionPeerIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureSessionPeerIdsIsMutable();
        this.sessionPeerIds_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder addSessionPeerIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureSessionPeerIdsIsMutable();
        this.sessionPeerIds_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand build() {
        Messages$SessionCommand messages$SessionCommand = this.buildPartial();
        boolean bl2 = messages$SessionCommand.isInitialized();
        if (bl2) {
            return messages$SessionCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$SessionCommand);
    }

    public Messages$SessionCommand buildPartial() {
        Object object = null;
        Messages$SessionCommand messages$SessionCommand = new Messages$SessionCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        long l10 = this.t_;
        Messages$SessionCommand.access$13802(messages$SessionCommand, l10);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        Object object2 = this.n_;
        Messages$SessionCommand.access$13902(messages$SessionCommand, object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        object2 = this.s_;
        Messages$SessionCommand.access$14002(messages$SessionCommand, object2);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        object2 = this.ua_;
        Messages$SessionCommand.access$14102(messages$SessionCommand, object2);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        n11 = (int)(this.r_ ? 1 : 0);
        Messages$SessionCommand.access$14202(messages$SessionCommand, n11 != 0);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        object2 = this.tag_;
        Messages$SessionCommand.access$14302(messages$SessionCommand, object2);
        n11 = n10 & 0x40;
        n13 = 64;
        if (n11 == n13) {
            n12 |= 0x40;
        }
        object2 = this.deviceId_;
        Messages$SessionCommand.access$14402(messages$SessionCommand, object2);
        n11 = this.bitField0_;
        n13 = 128;
        if ((n11 &= n13) == n13) {
            this.sessionPeerIds_ = object2 = this.sessionPeerIds_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFF7F;
        }
        object2 = this.sessionPeerIds_;
        Messages$SessionCommand.access$14502(messages$SessionCommand, (LazyStringList)object2);
        n11 = this.bitField0_;
        n13 = 256;
        if ((n11 &= n13) == n13) {
            this.onlineSessionPeerIds_ = object2 = this.onlineSessionPeerIds_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFEFF;
        }
        object2 = this.onlineSessionPeerIds_;
        Messages$SessionCommand.access$14602(messages$SessionCommand, (LazyStringList)object2);
        n11 = n10 & 0x200;
        n13 = 512;
        if (n11 == n13) {
            n12 |= 0x80;
        }
        object2 = this.st_;
        Messages$SessionCommand.access$14702(messages$SessionCommand, object2);
        n11 = n10 & 0x400;
        n13 = 1024;
        if (n11 == n13) {
            n12 |= 0x100;
        }
        n11 = this.stTtl_;
        Messages$SessionCommand.access$14802(messages$SessionCommand, n11);
        n11 = n10 & 0x800;
        n13 = 2048;
        if (n11 == n13) {
            n12 |= 0x200;
        }
        n11 = this.code_;
        Messages$SessionCommand.access$14902(messages$SessionCommand, n11);
        n11 = n10 & 0x1000;
        n13 = 4096;
        if (n11 == n13) {
            n12 |= 0x400;
        }
        object2 = this.reason_;
        Messages$SessionCommand.access$15002(messages$SessionCommand, object2);
        n11 = n10 & 0x2000;
        n13 = 8192;
        if (n11 == n13) {
            n12 |= 0x800;
        }
        object2 = this.deviceToken_;
        Messages$SessionCommand.access$15102(messages$SessionCommand, object2);
        n11 = n10 & 0x4000;
        n13 = 16384;
        if (n11 == n13) {
            n12 |= 0x1000;
        }
        n11 = (int)(this.sp_ ? 1 : 0);
        Messages$SessionCommand.access$15202(messages$SessionCommand, n11 != 0);
        n11 = 32768;
        n13 = n10 & n11;
        if (n13 == n11) {
            n12 |= 0x2000;
        }
        Object object3 = this.detail_;
        Messages$SessionCommand.access$15302(messages$SessionCommand, object3);
        n13 = 65536;
        int n14 = n10 & n13;
        if (n14 == n13) {
            n12 |= 0x4000;
        }
        long l11 = this.lastUnreadNotifTime_;
        Messages$SessionCommand.access$15402(messages$SessionCommand, l11);
        n14 = 131072;
        int n15 = n10 & n14;
        if (n15 == n14) {
            n12 |= n11;
        }
        long l12 = this.lastPatchTime_;
        Messages$SessionCommand.access$15502(messages$SessionCommand, l12);
        n11 = 262144;
        n15 = n10 & n11;
        if (n15 == n11) {
            n12 |= n13;
        }
        l12 = this.configBitmap_;
        Messages$SessionCommand.access$15602(messages$SessionCommand, l12);
        n11 = 524288;
        if ((n10 &= n11) == n11) {
            n12 |= n14;
        }
        if ((object = this.systemInfoBuilder_) == null) {
            object = this.systemInfo_;
            Messages$SessionCommand.access$15702(messages$SessionCommand, (Messages$SystemInfo)object);
        } else {
            object = (Messages$SystemInfo)((SingleFieldBuilderV3)object).build();
            Messages$SessionCommand.access$15702(messages$SessionCommand, (Messages$SystemInfo)object);
        }
        Messages$SessionCommand.access$15802(messages$SessionCommand, n12);
        this.onBuilt();
        return messages$SessionCommand;
    }

    public Messages$SessionCommand$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        int n11;
        long l10;
        super.clear();
        this.t_ = l10 = 0L;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = "";
        this.n_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.s_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.ua_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.r_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.tag_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.deviceId_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFBF;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFF7F;
        this.onlineSessionPeerIds_ = lazyStringList;
        this.bitField0_ = n11 &= 0xFFFFFEFF;
        this.st_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFDFF;
        this.stTtl_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFBFF;
        this.code_ = 0;
        this.bitField0_ = n11 &= 0xFFFFF7FF;
        this.reason_ = string2;
        this.bitField0_ = n11 &= 0xFFFFEFFF;
        this.deviceToken_ = string2;
        this.bitField0_ = n11 &= 0xFFFFDFFF;
        this.sp_ = false;
        this.bitField0_ = n11 &= 0xFFFFBFFF;
        this.detail_ = string2;
        this.bitField0_ = n11 &= 0xFFFF7FFF;
        this.lastUnreadNotifTime_ = l10;
        this.bitField0_ = n11 &= 0xFFFEFFFF;
        this.lastPatchTime_ = l10;
        int n12 = -131073;
        this.bitField0_ = n11 &= n12;
        this.configBitmap_ = l10;
        this.bitField0_ = n10 = 0xFFFBFFFF & n11;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.systemInfo_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFF7FFFF;
        return this;
    }

    public Messages$SessionCommand$Builder clearCode() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        this.code_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearConfigBitmap() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFBFFFF;
        this.configBitmap_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearDetail() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFF7FFF;
        String string2 = Messages$SessionCommand.getDefaultInstance().getDetail();
        this.detail_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearDeviceId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = Messages$SessionCommand.getDefaultInstance().getDeviceId();
        this.deviceId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearDeviceToken() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
        String string2 = Messages$SessionCommand.getDefaultInstance().getDeviceToken();
        this.deviceToken_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$SessionCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$SessionCommand$Builder clearLastPatchTime() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFDFFFF;
        this.lastPatchTime_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearLastUnreadNotifTime() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFEFFFF;
        this.lastUnreadNotifTime_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearN() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$SessionCommand.getDefaultInstance().getN();
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$SessionCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$SessionCommand$Builder clearOnlineSessionPeerIds() {
        int n10;
        LazyStringList lazyStringList;
        this.onlineSessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearR() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.r_ = false;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearReason() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        String string2 = Messages$SessionCommand.getDefaultInstance().getReason();
        this.reason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearS() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$SessionCommand.getDefaultInstance().getS();
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearSessionPeerIds() {
        int n10;
        LazyStringList lazyStringList;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearSp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFBFFF;
        this.sp_ = false;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearSt() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        String string2 = Messages$SessionCommand.getDefaultInstance().getSt();
        this.st_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearStTtl() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.stTtl_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearSystemInfo() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.systemInfo_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFF7FFFF;
        return this;
    }

    public Messages$SessionCommand$Builder clearT() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.t_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearTag() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$SessionCommand.getDefaultInstance().getTag();
        this.tag_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clearUa() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$SessionCommand.getDefaultInstance().getUa();
        this.ua_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder clone() {
        return (Messages$SessionCommand$Builder)super.clone();
    }

    public int getCode() {
        return this.code_;
    }

    public long getConfigBitmap() {
        return this.configBitmap_;
    }

    public Messages$SessionCommand getDefaultInstanceForType() {
        return Messages$SessionCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$13200();
    }

    public String getDetail() {
        Object object = this.detail_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.detail_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    public String getDeviceId() {
        Object object = this.deviceId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.deviceId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getDeviceIdBytes() {
        Object object = this.deviceId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.deviceId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getDeviceToken() {
        Object object = this.deviceToken_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.deviceToken_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getDeviceTokenBytes() {
        Object object = this.deviceToken_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.deviceToken_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getLastPatchTime() {
        return this.lastPatchTime_;
    }

    public long getLastUnreadNotifTime() {
        return this.lastUnreadNotifTime_;
    }

    public String getN() {
        Object object = this.n_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.n_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getNBytes() {
        Object object = this.n_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.n_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getOnlineSessionPeerIds(int n10) {
        return (String)this.onlineSessionPeerIds_.get(n10);
    }

    public ByteString getOnlineSessionPeerIdsBytes(int n10) {
        return this.onlineSessionPeerIds_.getByteString(n10);
    }

    public int getOnlineSessionPeerIdsCount() {
        return this.onlineSessionPeerIds_.size();
    }

    public ProtocolStringList getOnlineSessionPeerIdsList() {
        return this.onlineSessionPeerIds_.getUnmodifiableView();
    }

    public boolean getR() {
        return this.r_;
    }

    public String getReason() {
        Object object = this.reason_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.reason_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    public String getS() {
        Object object = this.s_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.s_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSBytes() {
        Object object = this.s_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.s_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getSessionPeerIds(int n10) {
        return (String)this.sessionPeerIds_.get(n10);
    }

    public ByteString getSessionPeerIdsBytes(int n10) {
        return this.sessionPeerIds_.getByteString(n10);
    }

    public int getSessionPeerIdsCount() {
        return this.sessionPeerIds_.size();
    }

    public ProtocolStringList getSessionPeerIdsList() {
        return this.sessionPeerIds_.getUnmodifiableView();
    }

    public boolean getSp() {
        return this.sp_;
    }

    public String getSt() {
        Object object = this.st_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.st_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getStBytes() {
        Object object = this.st_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.st_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getStTtl() {
        return this.stTtl_;
    }

    public Messages$SystemInfo getSystemInfo() {
        Object object = this.systemInfoBuilder_;
        if (object == null) {
            object = this.systemInfo_;
            if (object == null) {
                object = Messages$SystemInfo.getDefaultInstance();
            }
            return object;
        }
        return (Messages$SystemInfo)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$SystemInfo$Builder getSystemInfoBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        this.onChanged();
        return (Messages$SystemInfo$Builder)this.getSystemInfoFieldBuilder().getBuilder();
    }

    public Messages$SystemInfoOrBuilder getSystemInfoOrBuilder() {
        Object object = this.systemInfoBuilder_;
        if (object != null) {
            return (Messages$SystemInfoOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.systemInfo_;
        if (object == null) {
            object = Messages$SystemInfo.getDefaultInstance();
        }
        return object;
    }

    public long getT() {
        return this.t_;
    }

    public String getTag() {
        Object object = this.tag_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.tag_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getTagBytes() {
        Object object = this.tag_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.tag_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getUa() {
        Object object = this.ua_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.ua_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getUaBytes() {
        Object object = this.ua_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.ua_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasCode() {
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
    public boolean hasConfigBitmap() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasDetail() {
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
    public boolean hasDeviceId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 64;
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
    public boolean hasDeviceToken() {
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
    public boolean hasLastPatchTime() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 131072;
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
    public boolean hasLastUnreadNotifTime() {
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
    public boolean hasN() {
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
    public boolean hasR() {
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
    public boolean hasReason() {
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
    public boolean hasS() {
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
    public boolean hasSp() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasSt() {
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
    public boolean hasStTtl() {
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
    public boolean hasSystemInfo() {
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

    public boolean hasT() {
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
    public boolean hasTag() {
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
    public boolean hasUa() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$13300().ensureFieldAccessorsInitialized(Messages$SessionCommand.class, Messages$SessionCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$SessionCommand$Builder mergeFrom(Messages$SessionCommand messageLite) {
        LazyStringList lazyStringList;
        long l10;
        Object object = Messages$SessionCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasT();
        if (n10 != 0) {
            l10 = messageLite.getT();
            this.setT(l10);
        }
        if ((n10 = messageLite.hasN()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.n_ = object = Messages$SessionCommand.access$13900(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasS()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.s_ = object = Messages$SessionCommand.access$14000(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasUa() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.ua_ = object = Messages$SessionCommand.access$14100(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasR() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getR() ? 1 : 0);
            this.setR(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasTag() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.tag_ = object = Messages$SessionCommand.access$14300(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasDeviceId()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
            this.deviceId_ = object = Messages$SessionCommand.access$14400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$SessionCommand.access$14500(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.sessionPeerIds_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.sessionPeerIds_ = object = Messages$SessionCommand.access$14500(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
            } else {
                this.ensureSessionPeerIdsIsMutable();
                object = this.sessionPeerIds_;
                lazyStringList = Messages$SessionCommand.access$14500(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$SessionCommand.access$14600(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.onlineSessionPeerIds_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.onlineSessionPeerIds_ = object = Messages$SessionCommand.access$14600(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
            } else {
                this.ensureOnlineSessionPeerIdsIsMutable();
                object = this.onlineSessionPeerIds_;
                lazyStringList = Messages$SessionCommand.access$14600(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasSt() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x200;
            this.st_ = object = Messages$SessionCommand.access$14700(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasStTtl() ? 1 : 0)) != 0) {
            n10 = messageLite.getStTtl();
            this.setStTtl(n10);
        }
        if ((n10 = (int)(messageLite.hasCode() ? 1 : 0)) != 0) {
            n10 = messageLite.getCode();
            this.setCode(n10);
        }
        if ((n10 = (int)(messageLite.hasReason() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x1000;
            this.reason_ = object = Messages$SessionCommand.access$15000(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasDeviceToken() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x2000;
            this.deviceToken_ = object = Messages$SessionCommand.access$15100(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasSp() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getSp() ? 1 : 0);
            this.setSp(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasDetail() ? 1 : 0)) != 0) {
            n10 = this.bitField0_;
            int n11 = 32768;
            this.bitField0_ = n10 |= n11;
            this.detail_ = object = Messages$SessionCommand.access$15300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasLastUnreadNotifTime() ? 1 : 0)) != 0) {
            l10 = messageLite.getLastUnreadNotifTime();
            this.setLastUnreadNotifTime(l10);
        }
        if ((n10 = (int)(messageLite.hasLastPatchTime() ? 1 : 0)) != 0) {
            l10 = messageLite.getLastPatchTime();
            this.setLastPatchTime(l10);
        }
        if ((n10 = (int)(messageLite.hasConfigBitmap() ? 1 : 0)) != 0) {
            l10 = messageLite.getConfigBitmap();
            this.setConfigBitmap(l10);
        }
        if ((n10 = (int)(messageLite.hasSystemInfo() ? 1 : 0)) != 0) {
            object = messageLite.getSystemInfo();
            this.mergeSystemInfo((Messages$SystemInfo)object);
        }
        messageLite = Messages$SessionCommand.access$15900(messageLite);
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
    public Messages$SessionCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$SessionCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$SessionCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$SessionCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$SessionCommand)object2;
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
            this.mergeFrom((Messages$SessionCommand)object3);
        }
        throw var1_6;
    }

    public Messages$SessionCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$SessionCommand;
        if (bl2) {
            message = (Messages$SessionCommand)message;
            return this.mergeFrom((Messages$SessionCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Messages$SessionCommand$Builder mergeSystemInfo(Messages$SystemInfo messages$SystemInfo) {
        int n10;
        Object object = this.systemInfoBuilder_;
        int n11 = 524288;
        if (object == null) {
            Messages$SystemInfo messages$SystemInfo2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.systemInfo_) != null && object != (messages$SystemInfo2 = Messages$SystemInfo.getDefaultInstance())) {
                object = Messages$SystemInfo.newBuilder(this.systemInfo_);
                this.systemInfo_ = messages$SystemInfo = ((Messages$SystemInfo$Builder)object).mergeFrom(messages$SystemInfo).buildPartial();
            } else {
                this.systemInfo_ = messages$SystemInfo;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$SystemInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public final Messages$SessionCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$SessionCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$SessionCommand$Builder setCode(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x800;
        this.code_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setConfigBitmap(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        this.configBitmap_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setDetail(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        this.detail_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setDetailBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        this.detail_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setDeviceId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.deviceId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setDeviceIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.deviceId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setDeviceToken(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.deviceToken_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setDeviceTokenBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.deviceToken_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$SessionCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$SessionCommand$Builder setLastPatchTime(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x20000;
        this.lastPatchTime_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setLastUnreadNotifTime(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        this.lastUnreadNotifTime_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setN(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setNBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.n_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setOnlineSessionPeerIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureOnlineSessionPeerIdsIsMutable();
        this.onlineSessionPeerIds_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setR(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.r_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setReason(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.reason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setReasonBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.reason_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$SessionCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$SessionCommand$Builder setS(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setSBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.s_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setSessionPeerIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureSessionPeerIdsIsMutable();
        this.sessionPeerIds_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setSp(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        this.sp_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setSt(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.st_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setStBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.st_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setStTtl(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x400;
        this.stTtl_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setSystemInfo(Messages$SystemInfo$Builder messages$SystemInfoOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$SystemInfoOrBuilder = messages$SystemInfoOrBuilder.build();
            this.systemInfo_ = messages$SystemInfoOrBuilder;
            this.onChanged();
        } else {
            messages$SystemInfoOrBuilder = messages$SystemInfoOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$SystemInfoOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        return this;
    }

    public Messages$SessionCommand$Builder setSystemInfo(Messages$SystemInfo messages$SystemInfo) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.systemInfoBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$SystemInfo);
            this.systemInfo_ = messages$SystemInfo;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$SystemInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        return this;
    }

    public Messages$SessionCommand$Builder setT(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.t_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setTag(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.tag_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setTagBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.tag_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setUa(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.ua_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SessionCommand$Builder setUaBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.ua_ = byteString;
        this.onChanged();
        return this;
    }

    public final Messages$SessionCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$SessionCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

