/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$UnreadTuple;
import cn.leancloud.Messages$UnreadTupleOrBuilder;
import com.google.protobuf.AbstractMessage$Builder;
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
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Messages$UnreadTuple$Builder
extends GeneratedMessageV3$Builder
implements Messages$UnreadTupleOrBuilder {
    private ByteString binaryMsg_;
    private int bitField0_;
    private Object cid_;
    private int convType_;
    private Object data_;
    private Object from_;
    private boolean mentioned_;
    private Object mid_;
    private long patchTimestamp_;
    private long timestamp_;
    private int unread_;

    private Messages$UnreadTuple$Builder() {
        Object object;
        this.cid_ = object = "";
        this.mid_ = object;
        this.from_ = object;
        this.data_ = object;
        this.binaryMsg_ = object = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$UnreadTuple$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$UnreadTuple$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.cid_ = object = "";
        this.mid_ = object;
        this.from_ = object;
        this.data_ = object;
        this.binaryMsg_ = object = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$UnreadTuple$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$4800();
    }

    private void maybeForceBuilderInitialization() {
        Messages$UnreadTuple.access$5200();
    }

    public Messages$UnreadTuple$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$UnreadTuple$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$UnreadTuple build() {
        Messages$UnreadTuple messages$UnreadTuple = this.buildPartial();
        boolean bl2 = messages$UnreadTuple.isInitialized();
        if (bl2) {
            return messages$UnreadTuple;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$UnreadTuple);
    }

    public Messages$UnreadTuple buildPartial() {
        Messages$UnreadTuple messages$UnreadTuple = new Messages$UnreadTuple(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object = this.cid_;
        Messages$UnreadTuple.access$5402(messages$UnreadTuple, object);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        n11 = this.unread_;
        Messages$UnreadTuple.access$5502(messages$UnreadTuple, n11);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        object = this.mid_;
        Messages$UnreadTuple.access$5602(messages$UnreadTuple, object);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        long l10 = this.timestamp_;
        Messages$UnreadTuple.access$5702(messages$UnreadTuple, l10);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        object = this.from_;
        Messages$UnreadTuple.access$5802(messages$UnreadTuple, object);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        object = this.data_;
        Messages$UnreadTuple.access$5902(messages$UnreadTuple, object);
        n11 = n10 & 0x40;
        n13 = 64;
        if (n11 == n13) {
            n12 |= 0x40;
        }
        l10 = this.patchTimestamp_;
        Messages$UnreadTuple.access$6002(messages$UnreadTuple, l10);
        n11 = n10 & 0x80;
        n13 = 128;
        if (n11 == n13) {
            n12 |= 0x80;
        }
        n11 = (int)(this.mentioned_ ? 1 : 0);
        Messages$UnreadTuple.access$6102(messages$UnreadTuple, n11 != 0);
        n11 = n10 & 0x100;
        n13 = 256;
        if (n11 == n13) {
            n12 |= 0x100;
        }
        object = this.binaryMsg_;
        Messages$UnreadTuple.access$6202(messages$UnreadTuple, (ByteString)object);
        n11 = 512;
        if ((n10 &= n11) == n11) {
            n12 |= 0x200;
        }
        n10 = this.convType_;
        Messages$UnreadTuple.access$6302(messages$UnreadTuple, n10);
        Messages$UnreadTuple.access$6402(messages$UnreadTuple, n12);
        this.onBuilt();
        return messages$UnreadTuple;
    }

    public Messages$UnreadTuple$Builder clear() {
        ByteString byteString;
        int n10;
        long l10;
        int n11;
        super.clear();
        String string2 = "";
        this.cid_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.unread_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.mid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.timestamp_ = l10 = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.from_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.data_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFDF;
        this.patchTimestamp_ = l10;
        this.bitField0_ = n10 &= 0xFFFFFFBF;
        this.mentioned_ = false;
        this.bitField0_ = n10 &= 0xFFFFFF7F;
        this.binaryMsg_ = byteString = ByteString.EMPTY;
        this.bitField0_ = n10 &= 0xFFFFFEFF;
        this.convType_ = 0;
        this.bitField0_ = n10 &= 0xFFFFFDFF;
        return this;
    }

    public Messages$UnreadTuple$Builder clearBinaryMsg() {
        ByteString byteString;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.binaryMsg_ = byteString = Messages$UnreadTuple.getDefaultInstance().getBinaryMsg();
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$UnreadTuple.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearConvType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.convType_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearData() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$UnreadTuple.getDefaultInstance().getData();
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$UnreadTuple$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$UnreadTuple$Builder clearFrom() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        String string2 = Messages$UnreadTuple.getDefaultInstance().getFrom();
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearMentioned() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.mentioned_ = false;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearMid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$UnreadTuple.getDefaultInstance().getMid();
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$UnreadTuple$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$UnreadTuple$Builder clearPatchTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        this.patchTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.timestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clearUnread() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.unread_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder clone() {
        return (Messages$UnreadTuple$Builder)super.clone();
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

    public Messages$UnreadTuple getDefaultInstanceForType() {
        return Messages$UnreadTuple.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$4800();
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

    public boolean getMentioned() {
        return this.mentioned_;
    }

    public String getMid() {
        Object object = this.mid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.mid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getMidBytes() {
        Object object = this.mid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.mid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getPatchTimestamp() {
        return this.patchTimestamp_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public int getUnread() {
        return this.unread_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBinaryMsg() {
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

    public boolean hasCid() {
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
    public boolean hasConvType() {
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
    public boolean hasData() {
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
    public boolean hasFrom() {
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
    public boolean hasMentioned() {
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
    public boolean hasMid() {
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
    public boolean hasUnread() {
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
        return Messages.access$4900().ensureFieldAccessorsInitialized(Messages$UnreadTuple.class, Messages$UnreadTuple$Builder.class);
    }

    public final boolean isInitialized() {
        boolean bl2 = this.hasCid();
        if (!bl2) {
            return false;
        }
        bl2 = this.hasUnread();
        return bl2;
    }

    public Messages$UnreadTuple$Builder mergeFrom(Messages$UnreadTuple messageLite) {
        long l10;
        Object object = Messages$UnreadTuple.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.cid_ = object = Messages$UnreadTuple.access$5400(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasUnread()) != 0) {
            n10 = messageLite.getUnread();
            this.setUnread(n10);
        }
        if ((n10 = (int)(messageLite.hasMid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.mid_ = object = Messages$UnreadTuple.access$5600(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getTimestamp();
            this.setTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasFrom() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
            this.from_ = object = Messages$UnreadTuple.access$5800(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasData() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.data_ = object = Messages$UnreadTuple.access$5900(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasPatchTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getPatchTimestamp();
            this.setPatchTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasMentioned() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getMentioned() ? 1 : 0);
            this.setMentioned(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasBinaryMsg() ? 1 : 0)) != 0) {
            object = messageLite.getBinaryMsg();
            this.setBinaryMsg((ByteString)object);
        }
        if ((n10 = messageLite.hasConvType()) != 0) {
            n10 = messageLite.getConvType();
            this.setConvType(n10);
        }
        messageLite = Messages$UnreadTuple.access$6500(messageLite);
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
    public Messages$UnreadTuple$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$UnreadTuple.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$UnreadTuple)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$UnreadTuple)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$UnreadTuple)object2;
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
            this.mergeFrom((Messages$UnreadTuple)object3);
        }
        throw var1_6;
    }

    public Messages$UnreadTuple$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$UnreadTuple;
        if (bl2) {
            message = (Messages$UnreadTuple)message;
            return this.mergeFrom((Messages$UnreadTuple)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$UnreadTuple$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$UnreadTuple$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$UnreadTuple$Builder setBinaryMsg(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.binaryMsg_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setConvType(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x200;
        this.convType_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setData(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setDataBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.data_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$UnreadTuple$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$UnreadTuple$Builder setFrom(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setFromBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.from_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setMentioned(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.mentioned_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setMid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setMidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.mid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setPatchTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.patchTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$UnreadTuple$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$UnreadTuple$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$UnreadTuple$Builder setTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.timestamp_ = l10;
        this.onChanged();
        return this;
    }

    public final Messages$UnreadTuple$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$UnreadTuple$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Messages$UnreadTuple$Builder setUnread(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.unread_ = n10;
        this.onChanged();
        return this;
    }
}

