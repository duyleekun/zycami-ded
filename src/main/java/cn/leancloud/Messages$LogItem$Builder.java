/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LogItem;
import cn.leancloud.Messages$LogItemOrBuilder;
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

public final class Messages$LogItem$Builder
extends GeneratedMessageV3$Builder
implements Messages$LogItemOrBuilder {
    private long ackAt_;
    private boolean bin_;
    private int bitField0_;
    private int convType_;
    private Object data_;
    private Object from_;
    private boolean mentionAll_;
    private LazyStringList mentionPids_;
    private Object msgId_;
    private long patchTimestamp_;
    private long readAt_;
    private long timestamp_;

    private Messages$LogItem$Builder() {
        Object object;
        this.from_ = object = "";
        this.data_ = object;
        this.msgId_ = object;
        this.mentionPids_ = object = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LogItem$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$LogItem$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.from_ = object = "";
        this.data_ = object;
        this.msgId_ = object;
        this.mentionPids_ = object = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LogItem$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureMentionPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 256;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.mentionPids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.mentionPids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$6700();
    }

    private void maybeForceBuilderInitialization() {
        Messages$LogItem.access$7100();
    }

    public Messages$LogItem$Builder addAllMentionPids(Iterable iterable) {
        this.ensureMentionPidsIsMutable();
        LazyStringList lazyStringList = this.mentionPids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder addMentionPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder addMentionPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LogItem$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$LogItem build() {
        Messages$LogItem messages$LogItem = this.buildPartial();
        boolean bl2 = messages$LogItem.isInitialized();
        if (bl2) {
            return messages$LogItem;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$LogItem);
    }

    public Messages$LogItem buildPartial() {
        Messages$LogItem messages$LogItem = new Messages$LogItem(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object = this.from_;
        Messages$LogItem.access$7302(messages$LogItem, object);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        object = this.data_;
        Messages$LogItem.access$7402(messages$LogItem, object);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        long l10 = this.timestamp_;
        Messages$LogItem.access$7502(messages$LogItem, l10);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        object = this.msgId_;
        Messages$LogItem.access$7602(messages$LogItem, object);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        l10 = this.ackAt_;
        Messages$LogItem.access$7702(messages$LogItem, l10);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        l10 = this.readAt_;
        Messages$LogItem.access$7802(messages$LogItem, l10);
        n11 = n10 & 0x40;
        n13 = 64;
        if (n11 == n13) {
            n12 |= 0x40;
        }
        l10 = this.patchTimestamp_;
        Messages$LogItem.access$7902(messages$LogItem, l10);
        n11 = n10 & 0x80;
        n13 = 128;
        if (n11 == n13) {
            n12 |= 0x80;
        }
        n11 = (int)(this.mentionAll_ ? 1 : 0);
        Messages$LogItem.access$8002(messages$LogItem, n11 != 0);
        n11 = this.bitField0_;
        n13 = 256;
        if ((n11 &= n13) == n13) {
            this.mentionPids_ = object = this.mentionPids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFEFF;
        }
        object = this.mentionPids_;
        Messages$LogItem.access$8102(messages$LogItem, (LazyStringList)object);
        n11 = n10 & 0x200;
        n13 = 512;
        if (n11 == n13) {
            n12 |= 0x100;
        }
        n11 = (int)(this.bin_ ? 1 : 0);
        Messages$LogItem.access$8202(messages$LogItem, n11 != 0);
        n11 = 1024;
        if ((n10 &= n11) == n11) {
            n12 |= 0x200;
        }
        n10 = this.convType_;
        Messages$LogItem.access$8302(messages$LogItem, n10);
        Messages$LogItem.access$8402(messages$LogItem, n12);
        this.onBuilt();
        return messages$LogItem;
    }

    public Messages$LogItem$Builder clear() {
        LazyStringList lazyStringList;
        int n10;
        long l10;
        int n11;
        super.clear();
        String string2 = "";
        this.from_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.data_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.timestamp_ = l10 = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.msgId_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFF7;
        this.ackAt_ = l10;
        this.bitField0_ = n10 &= 0xFFFFFFEF;
        this.readAt_ = l10;
        this.bitField0_ = n10 &= 0xFFFFFFDF;
        this.patchTimestamp_ = l10;
        this.bitField0_ = n10 &= 0xFFFFFFBF;
        this.mentionAll_ = false;
        this.bitField0_ = n10 &= 0xFFFFFF7F;
        this.mentionPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 &= 0xFFFFFEFF;
        this.bin_ = false;
        this.bitField0_ = n10 &= 0xFFFFFDFF;
        this.convType_ = 0;
        this.bitField0_ = n10 &= 0xFFFFFBFF;
        return this;
    }

    public Messages$LogItem$Builder clearAckAt() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.ackAt_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearBin() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.bin_ = false;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearConvType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.convType_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearData() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$LogItem.getDefaultInstance().getData();
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$LogItem$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$LogItem$Builder clearFrom() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$LogItem.getDefaultInstance().getFrom();
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearMentionAll() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.mentionAll_ = false;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearMentionPids() {
        int n10;
        LazyStringList lazyStringList;
        this.mentionPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearMsgId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$LogItem.getDefaultInstance().getMsgId();
        this.msgId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$LogItem$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$LogItem$Builder clearPatchTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        this.patchTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearReadAt() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.readAt_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clearTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.timestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder clone() {
        return (Messages$LogItem$Builder)super.clone();
    }

    public long getAckAt() {
        return this.ackAt_;
    }

    public boolean getBin() {
        return this.bin_;
    }

    public int getConvType() {
        return this.convType_;
    }

    public String getData() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.data_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getDataBytes() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.data_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$LogItem getDefaultInstanceForType() {
        return Messages$LogItem.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$6700();
    }

    public String getFrom() {
        Object object = this.from_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.from_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getFromBytes() {
        Object object = this.from_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.from_ = object = ByteString.copyFromUtf8((String)object);
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

    public String getMsgId() {
        Object object = this.msgId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.msgId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getMsgIdBytes() {
        Object object = this.msgId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.msgId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getPatchTimestamp() {
        return this.patchTimestamp_;
    }

    public long getReadAt() {
        return this.readAt_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAckAt() {
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
    public boolean hasBin() {
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
    public boolean hasConvType() {
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
    public boolean hasData() {
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

    public boolean hasFrom() {
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
    public boolean hasMentionAll() {
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
    public boolean hasMsgId() {
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
    public boolean hasPatchTimestamp() {
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
    public boolean hasReadAt() {
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
    public boolean hasTimestamp() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$6800().ensureFieldAccessorsInitialized(Messages$LogItem.class, Messages$LogItem$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$LogItem$Builder mergeFrom(Messages$LogItem messageLite) {
        long l10;
        Object object = Messages$LogItem.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasFrom();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.from_ = object = Messages$LogItem.access$7300(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasData()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.data_ = object = Messages$LogItem.access$7400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getTimestamp();
            this.setTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasMsgId() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.msgId_ = object = Messages$LogItem.access$7600(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasAckAt() ? 1 : 0)) != 0) {
            l10 = messageLite.getAckAt();
            this.setAckAt(l10);
        }
        if ((n10 = (int)(messageLite.hasReadAt() ? 1 : 0)) != 0) {
            l10 = messageLite.getReadAt();
            this.setReadAt(l10);
        }
        if ((n10 = (int)(messageLite.hasPatchTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getPatchTimestamp();
            this.setPatchTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasMentionAll() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getMentionAll() ? 1 : 0);
            this.setMentionAll(n10 != 0);
        }
        if ((n10 = (object = Messages$LogItem.access$8100(messageLite)).isEmpty()) == 0) {
            object = this.mentionPids_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.mentionPids_ = object = Messages$LogItem.access$8100(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
            } else {
                this.ensureMentionPidsIsMutable();
                object = this.mentionPids_;
                LazyStringList lazyStringList = Messages$LogItem.access$8100(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasBin()) != 0) {
            n10 = messageLite.getBin();
            this.setBin(n10 != 0);
        }
        if ((n10 = messageLite.hasConvType()) != 0) {
            n10 = messageLite.getConvType();
            this.setConvType(n10);
        }
        messageLite = Messages$LogItem.access$8500(messageLite);
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
    public Messages$LogItem$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$LogItem.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$LogItem)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$LogItem)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$LogItem)object2;
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
            this.mergeFrom((Messages$LogItem)object3);
        }
        throw var1_6;
    }

    public Messages$LogItem$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$LogItem;
        if (bl2) {
            message = (Messages$LogItem)message;
            return this.mergeFrom((Messages$LogItem)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$LogItem$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LogItem$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$LogItem$Builder setAckAt(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.ackAt_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setBin(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x200;
        this.bin_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setConvType(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x400;
        this.convType_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setData(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setDataBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.data_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LogItem$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$LogItem$Builder setFrom(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setFromBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.from_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setMentionAll(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.mentionAll_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setMentionPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setMsgId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.msgId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setMsgIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.msgId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setPatchTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.patchTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setReadAt(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.readAt_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$LogItem$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$LogItem$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$LogItem$Builder setTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.timestamp_ = l10;
        this.onChanged();
        return this;
    }

    public final Messages$LogItem$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LogItem$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

