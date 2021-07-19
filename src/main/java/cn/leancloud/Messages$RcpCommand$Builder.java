/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$RcpCommand;
import cn.leancloud.Messages$RcpCommandOrBuilder;
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

public final class Messages$RcpCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$RcpCommandOrBuilder {
    private int bitField0_;
    private Object cid_;
    private Object from_;
    private Object id_;
    private boolean read_;
    private long t_;

    private Messages$RcpCommand$Builder() {
        String string2 = "";
        this.id_ = string2;
        this.cid_ = string2;
        this.from_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$RcpCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$RcpCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.id_ = object = "";
        this.cid_ = object;
        this.from_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$RcpCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$32600();
    }

    private void maybeForceBuilderInitialization() {
        Messages$RcpCommand.access$33000();
    }

    public Messages$RcpCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$RcpCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$RcpCommand build() {
        Messages$RcpCommand messages$RcpCommand = this.buildPartial();
        boolean bl2 = messages$RcpCommand.isInitialized();
        if (bl2) {
            return messages$RcpCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$RcpCommand);
    }

    public Messages$RcpCommand buildPartial() {
        Object object = null;
        Messages$RcpCommand messages$RcpCommand = new Messages$RcpCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.id_;
        Messages$RcpCommand.access$33202(messages$RcpCommand, object2);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        object2 = this.cid_;
        Messages$RcpCommand.access$33302(messages$RcpCommand, object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        long l10 = this.t_;
        Messages$RcpCommand.access$33402(messages$RcpCommand, l10);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        n11 = (int)(this.read_ ? 1 : 0);
        Messages$RcpCommand.access$33502(messages$RcpCommand, n11 != 0);
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n12 |= 0x10;
        }
        object = this.from_;
        Messages$RcpCommand.access$33602(messages$RcpCommand, object);
        Messages$RcpCommand.access$33702(messages$RcpCommand, n12);
        this.onBuilt();
        return messages$RcpCommand;
    }

    public Messages$RcpCommand$Builder clear() {
        int n10;
        int n11;
        super.clear();
        String string2 = "";
        this.id_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.cid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.t_ = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.read_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.from_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFEF;
        return this;
    }

    public Messages$RcpCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$RcpCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$RcpCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$RcpCommand$Builder clearFrom() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        String string2 = Messages$RcpCommand.getDefaultInstance().getFrom();
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder clearId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$RcpCommand.getDefaultInstance().getId();
        this.id_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$RcpCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$RcpCommand$Builder clearRead() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.read_ = false;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder clearT() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.t_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder clone() {
        return (Messages$RcpCommand$Builder)super.clone();
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

    public Messages$RcpCommand getDefaultInstanceForType() {
        return Messages$RcpCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$32600();
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

    public boolean getRead() {
        return this.read_;
    }

    public long getT() {
        return this.t_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasCid() {
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

    public boolean hasId() {
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
    public boolean hasRead() {
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
    public boolean hasT() {
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
        return Messages.access$32700().ensureFieldAccessorsInitialized(Messages$RcpCommand.class, Messages$RcpCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$RcpCommand$Builder mergeFrom(Messages$RcpCommand messageLite) {
        Object object = Messages$RcpCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasId();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.id_ = object = Messages$RcpCommand.access$33200(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasCid()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.cid_ = object = Messages$RcpCommand.access$33300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasT() ? 1 : 0)) != 0) {
            long l10 = messageLite.getT();
            this.setT(l10);
        }
        if ((n10 = (int)(messageLite.hasRead() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getRead() ? 1 : 0);
            this.setRead(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasFrom() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
            this.from_ = object = Messages$RcpCommand.access$33600(messageLite);
            this.onChanged();
        }
        messageLite = Messages$RcpCommand.access$33800(messageLite);
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
    public Messages$RcpCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$RcpCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$RcpCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$RcpCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$RcpCommand)object2;
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
            this.mergeFrom((Messages$RcpCommand)object3);
        }
        throw var1_6;
    }

    public Messages$RcpCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$RcpCommand;
        if (bl2) {
            message = (Messages$RcpCommand)message;
            return this.mergeFrom((Messages$RcpCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$RcpCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$RcpCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$RcpCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$RcpCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$RcpCommand$Builder setFrom(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder setFromBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.from_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder setId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.id_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder setIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.id_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder setRead(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.read_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$RcpCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$RcpCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$RcpCommand$Builder setT(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.t_ = l10;
        this.onChanged();
        return this;
    }

    public final Messages$RcpCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$RcpCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

