/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ReadTuple;
import cn.leancloud.Messages$ReadTupleOrBuilder;
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

public final class Messages$ReadTuple$Builder
extends GeneratedMessageV3$Builder
implements Messages$ReadTupleOrBuilder {
    private int bitField0_;
    private Object cid_;
    private Object mid_;
    private long timestamp_;

    private Messages$ReadTuple$Builder() {
        String string2 = "";
        this.cid_ = string2;
        this.mid_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ReadTuple$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$ReadTuple$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.cid_ = object = "";
        this.mid_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ReadTuple$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$34000();
    }

    private void maybeForceBuilderInitialization() {
        Messages$ReadTuple.access$34400();
    }

    public Messages$ReadTuple$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ReadTuple$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$ReadTuple build() {
        Messages$ReadTuple messages$ReadTuple = this.buildPartial();
        boolean bl2 = messages$ReadTuple.isInitialized();
        if (bl2) {
            return messages$ReadTuple;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$ReadTuple);
    }

    public Messages$ReadTuple buildPartial() {
        Object object = null;
        Messages$ReadTuple messages$ReadTuple = new Messages$ReadTuple(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.cid_;
        Messages$ReadTuple.access$34602(messages$ReadTuple, object2);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        long l10 = this.timestamp_;
        Messages$ReadTuple.access$34702(messages$ReadTuple, l10);
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n12 |= 4;
        }
        object = this.mid_;
        Messages$ReadTuple.access$34802(messages$ReadTuple, object);
        Messages$ReadTuple.access$34902(messages$ReadTuple, n12);
        this.onBuilt();
        return messages$ReadTuple;
    }

    public Messages$ReadTuple$Builder clear() {
        int n10;
        int n11;
        super.clear();
        String string2 = "";
        this.cid_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.timestamp_ = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.mid_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFB;
        return this;
    }

    public Messages$ReadTuple$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$ReadTuple.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReadTuple$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$ReadTuple$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$ReadTuple$Builder clearMid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$ReadTuple.getDefaultInstance().getMid();
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReadTuple$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$ReadTuple$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$ReadTuple$Builder clearTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.timestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$ReadTuple$Builder clone() {
        return (Messages$ReadTuple$Builder)super.clone();
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

    public Messages$ReadTuple getDefaultInstanceForType() {
        return Messages$ReadTuple.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$34000();
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

    public long getTimestamp() {
        return this.timestamp_;
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
    public boolean hasTimestamp() {
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
        return Messages.access$34100().ensureFieldAccessorsInitialized(Messages$ReadTuple.class, Messages$ReadTuple$Builder.class);
    }

    public final boolean isInitialized() {
        boolean bl2 = this.hasCid();
        return bl2;
    }

    public Messages$ReadTuple$Builder mergeFrom(Messages$ReadTuple messageLite) {
        Object object = Messages$ReadTuple.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.cid_ = object = Messages$ReadTuple.access$34600(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasTimestamp()) != 0) {
            long l10 = messageLite.getTimestamp();
            this.setTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasMid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.mid_ = object = Messages$ReadTuple.access$34800(messageLite);
            this.onChanged();
        }
        messageLite = Messages$ReadTuple.access$35000(messageLite);
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
    public Messages$ReadTuple$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$ReadTuple.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$ReadTuple)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$ReadTuple)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$ReadTuple)object2;
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
            this.mergeFrom((Messages$ReadTuple)object3);
        }
        throw var1_6;
    }

    public Messages$ReadTuple$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$ReadTuple;
        if (bl2) {
            message = (Messages$ReadTuple)message;
            return this.mergeFrom((Messages$ReadTuple)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$ReadTuple$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ReadTuple$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$ReadTuple$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReadTuple$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ReadTuple$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ReadTuple$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$ReadTuple$Builder setMid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReadTuple$Builder setMidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.mid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ReadTuple$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$ReadTuple$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$ReadTuple$Builder setTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.timestamp_ = l10;
        this.onChanged();
        return this;
    }

    public final Messages$ReadTuple$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ReadTuple$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

