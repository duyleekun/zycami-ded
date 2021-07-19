/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$MaxReadTuple;
import cn.leancloud.Messages$MaxReadTupleOrBuilder;
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

public final class Messages$MaxReadTuple$Builder
extends GeneratedMessageV3$Builder
implements Messages$MaxReadTupleOrBuilder {
    private int bitField0_;
    private long maxAckTimestamp_;
    private long maxReadTimestamp_;
    private Object pid_ = "";

    private Messages$MaxReadTuple$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$MaxReadTuple$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$MaxReadTuple$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$MaxReadTuple$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$35200();
    }

    private void maybeForceBuilderInitialization() {
        Messages$MaxReadTuple.access$35600();
    }

    public Messages$MaxReadTuple$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$MaxReadTuple$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$MaxReadTuple build() {
        Messages$MaxReadTuple messages$MaxReadTuple = this.buildPartial();
        boolean bl2 = messages$MaxReadTuple.isInitialized();
        if (bl2) {
            return messages$MaxReadTuple;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$MaxReadTuple);
    }

    public Messages$MaxReadTuple buildPartial() {
        Messages$MaxReadTuple messages$MaxReadTuple = new Messages$MaxReadTuple(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object = this.pid_;
        Messages$MaxReadTuple.access$35802(messages$MaxReadTuple, object);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        long l10 = this.maxAckTimestamp_;
        Messages$MaxReadTuple.access$35902(messages$MaxReadTuple, l10);
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n12 |= 4;
        }
        long l11 = this.maxReadTimestamp_;
        Messages$MaxReadTuple.access$36002(messages$MaxReadTuple, l11);
        Messages$MaxReadTuple.access$36102(messages$MaxReadTuple, n12);
        this.onBuilt();
        return messages$MaxReadTuple;
    }

    public Messages$MaxReadTuple$Builder clear() {
        long l10;
        int n10;
        super.clear();
        this.pid_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.maxAckTimestamp_ = l10 = 0L;
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        this.maxReadTimestamp_ = l10;
        this.bitField0_ = n10 &= 0xFFFFFFFB;
        return this;
    }

    public Messages$MaxReadTuple$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$MaxReadTuple$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$MaxReadTuple$Builder clearMaxAckTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.maxAckTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$MaxReadTuple$Builder clearMaxReadTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.maxReadTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$MaxReadTuple$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$MaxReadTuple$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$MaxReadTuple$Builder clearPid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$MaxReadTuple.getDefaultInstance().getPid();
        this.pid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$MaxReadTuple$Builder clone() {
        return (Messages$MaxReadTuple$Builder)super.clone();
    }

    public Messages$MaxReadTuple getDefaultInstanceForType() {
        return Messages$MaxReadTuple.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$35200();
    }

    public long getMaxAckTimestamp() {
        return this.maxAckTimestamp_;
    }

    public long getMaxReadTimestamp() {
        return this.maxReadTimestamp_;
    }

    public String getPid() {
        Object object = this.pid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.pid_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    /*
     * WARNING - void declaration
     */
    public boolean hasMaxAckTimestamp() {
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
    public boolean hasMaxReadTimestamp() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$35300().ensureFieldAccessorsInitialized(Messages$MaxReadTuple.class, Messages$MaxReadTuple$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$MaxReadTuple$Builder mergeFrom(Messages$MaxReadTuple messageLite) {
        long l10;
        Object object = Messages$MaxReadTuple.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasPid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.pid_ = object = Messages$MaxReadTuple.access$35800(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasMaxAckTimestamp()) != 0) {
            l10 = messageLite.getMaxAckTimestamp();
            this.setMaxAckTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasMaxReadTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getMaxReadTimestamp();
            this.setMaxReadTimestamp(l10);
        }
        messageLite = Messages$MaxReadTuple.access$36200(messageLite);
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
    public Messages$MaxReadTuple$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$MaxReadTuple.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$MaxReadTuple)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$MaxReadTuple)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$MaxReadTuple)object2;
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
            this.mergeFrom((Messages$MaxReadTuple)object3);
        }
        throw var1_6;
    }

    public Messages$MaxReadTuple$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$MaxReadTuple;
        if (bl2) {
            message = (Messages$MaxReadTuple)message;
            return this.mergeFrom((Messages$MaxReadTuple)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$MaxReadTuple$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$MaxReadTuple$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$MaxReadTuple$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$MaxReadTuple$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$MaxReadTuple$Builder setMaxAckTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.maxAckTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$MaxReadTuple$Builder setMaxReadTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.maxReadTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$MaxReadTuple$Builder setPid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.pid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$MaxReadTuple$Builder setPidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.pid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$MaxReadTuple$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$MaxReadTuple$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$MaxReadTuple$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$MaxReadTuple$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

