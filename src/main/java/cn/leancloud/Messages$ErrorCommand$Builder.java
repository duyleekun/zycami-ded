/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
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

public final class Messages$ErrorCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$ErrorCommandOrBuilder {
    private int appCode_;
    private Object appMsg_;
    private int bitField0_;
    private int code_;
    private Object detail_;
    private LazyStringList pids_;
    private Object reason_;

    private Messages$ErrorCommand$Builder() {
        LazyStringList lazyStringList;
        String string2 = "";
        this.reason_ = string2;
        this.detail_ = string2;
        this.pids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.appMsg_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ErrorCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$ErrorCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        LazyStringList lazyStringList;
        this.reason_ = object = "";
        this.detail_ = object;
        this.pids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.appMsg_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ErrorCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensurePidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 16;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.pids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.pids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$16100();
    }

    private void maybeForceBuilderInitialization() {
        Messages$ErrorCommand.access$16500();
    }

    public Messages$ErrorCommand$Builder addAllPids(Iterable iterable) {
        this.ensurePidsIsMutable();
        LazyStringList lazyStringList = this.pids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder addPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensurePidsIsMutable();
        this.pids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder addPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensurePidsIsMutable();
        this.pids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ErrorCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$ErrorCommand build() {
        Messages$ErrorCommand messages$ErrorCommand = this.buildPartial();
        boolean bl2 = messages$ErrorCommand.isInitialized();
        if (bl2) {
            return messages$ErrorCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$ErrorCommand);
    }

    public Messages$ErrorCommand buildPartial() {
        Object object = null;
        Messages$ErrorCommand messages$ErrorCommand = new Messages$ErrorCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        n11 = this.code_;
        Messages$ErrorCommand.access$16702(messages$ErrorCommand, n11);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        Object object2 = this.reason_;
        Messages$ErrorCommand.access$16802(messages$ErrorCommand, object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        n11 = this.appCode_;
        Messages$ErrorCommand.access$16902(messages$ErrorCommand, n11);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        object2 = this.detail_;
        Messages$ErrorCommand.access$17002(messages$ErrorCommand, object2);
        n11 = this.bitField0_;
        n13 = 16;
        if ((n11 &= n13) == n13) {
            this.pids_ = object2 = this.pids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFEF;
        }
        object2 = this.pids_;
        Messages$ErrorCommand.access$17102(messages$ErrorCommand, (LazyStringList)object2);
        n11 = 32;
        if ((n10 &= n11) == n11) {
            n12 |= 0x10;
        }
        object = this.appMsg_;
        Messages$ErrorCommand.access$17202(messages$ErrorCommand, object);
        Messages$ErrorCommand.access$17302(messages$ErrorCommand, n12);
        this.onBuilt();
        return messages$ErrorCommand;
    }

    public Messages$ErrorCommand$Builder clear() {
        LazyStringList lazyStringList;
        int n10;
        int n11;
        super.clear();
        this.code_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = "";
        this.reason_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.appCode_ = 0;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFB;
        this.detail_ = string2;
        this.bitField0_ = n10 &= 0xFFFFFFF7;
        this.pids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 &= 0xFFFFFFEF;
        this.appMsg_ = string2;
        this.bitField0_ = n10 &= 0xFFFFFFDF;
        return this;
    }

    public Messages$ErrorCommand$Builder clearAppCode() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.appCode_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder clearAppMsg() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$ErrorCommand.getDefaultInstance().getAppMsg();
        this.appMsg_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder clearCode() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.code_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder clearDetail() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$ErrorCommand.getDefaultInstance().getDetail();
        this.detail_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$ErrorCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$ErrorCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$ErrorCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$ErrorCommand$Builder clearPids() {
        int n10;
        LazyStringList lazyStringList;
        this.pids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder clearReason() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$ErrorCommand.getDefaultInstance().getReason();
        this.reason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder clone() {
        return (Messages$ErrorCommand$Builder)super.clone();
    }

    public int getAppCode() {
        return this.appCode_;
    }

    public String getAppMsg() {
        Object object = this.appMsg_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.appMsg_ = string2;
            }
            return string2;
        }
        return (String)object;
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
        return Messages$ErrorCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$16100();
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
        return this.pids_.getUnmodifiableView();
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
        int n10 = 32;
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$16200().ensureFieldAccessorsInitialized(Messages$ErrorCommand.class, Messages$ErrorCommand$Builder.class);
    }

    public final boolean isInitialized() {
        boolean bl2 = this.hasCode();
        if (!bl2) {
            return false;
        }
        bl2 = this.hasReason();
        return bl2;
    }

    public Messages$ErrorCommand$Builder mergeFrom(Messages$ErrorCommand messageLite) {
        Object object = Messages$ErrorCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCode();
        if (n10 != 0) {
            n10 = messageLite.getCode();
            this.setCode(n10);
        }
        if ((n10 = (int)(messageLite.hasReason() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.reason_ = object = Messages$ErrorCommand.access$16800(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasAppCode() ? 1 : 0)) != 0) {
            n10 = messageLite.getAppCode();
            this.setAppCode(n10);
        }
        if ((n10 = (int)(messageLite.hasDetail() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.detail_ = object = Messages$ErrorCommand.access$17000(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$ErrorCommand.access$17100(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.pids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.pids_ = object = Messages$ErrorCommand.access$17100(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            } else {
                this.ensurePidsIsMutable();
                object = this.pids_;
                LazyStringList lazyStringList = Messages$ErrorCommand.access$17100(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasAppMsg() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.appMsg_ = object = Messages$ErrorCommand.access$17200(messageLite);
            this.onChanged();
        }
        messageLite = Messages$ErrorCommand.access$17400(messageLite);
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
    public Messages$ErrorCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$ErrorCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$ErrorCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$ErrorCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$ErrorCommand)object2;
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
            this.mergeFrom((Messages$ErrorCommand)object3);
        }
        throw var1_6;
    }

    public Messages$ErrorCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$ErrorCommand;
        if (bl2) {
            message = (Messages$ErrorCommand)message;
            return this.mergeFrom((Messages$ErrorCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$ErrorCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ErrorCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$ErrorCommand$Builder setAppCode(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.appCode_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setAppMsg(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.appMsg_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setAppMsgBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.appMsg_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setCode(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.code_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setDetail(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.detail_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setDetailBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.detail_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ErrorCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$ErrorCommand$Builder setPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensurePidsIsMutable();
        this.pids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setReason(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.reason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setReasonBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.reason_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ErrorCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$ErrorCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$ErrorCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ErrorCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

