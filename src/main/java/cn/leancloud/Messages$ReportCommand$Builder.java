/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ReportCommand;
import cn.leancloud.Messages$ReportCommandOrBuilder;
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

public final class Messages$ReportCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$ReportCommandOrBuilder {
    private int bitField0_;
    private Object data_;
    private boolean initiative_;
    private Object type_;

    private Messages$ReportCommand$Builder() {
        String string2 = "";
        this.type_ = string2;
        this.data_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ReportCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$ReportCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.type_ = object = "";
        this.data_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ReportCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$38900();
    }

    private void maybeForceBuilderInitialization() {
        Messages$ReportCommand.access$39300();
    }

    public Messages$ReportCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ReportCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$ReportCommand build() {
        Messages$ReportCommand messages$ReportCommand = this.buildPartial();
        boolean bl2 = messages$ReportCommand.isInitialized();
        if (bl2) {
            return messages$ReportCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$ReportCommand);
    }

    public Messages$ReportCommand buildPartial() {
        Object object = null;
        Messages$ReportCommand messages$ReportCommand = new Messages$ReportCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        n11 = (int)(this.initiative_ ? 1 : 0);
        Messages$ReportCommand.access$39502(messages$ReportCommand, n11 != 0);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        Object object2 = this.type_;
        Messages$ReportCommand.access$39602(messages$ReportCommand, object2);
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n12 |= 4;
        }
        object = this.data_;
        Messages$ReportCommand.access$39702(messages$ReportCommand, object);
        Messages$ReportCommand.access$39802(messages$ReportCommand, n12);
        this.onBuilt();
        return messages$ReportCommand;
    }

    public Messages$ReportCommand$Builder clear() {
        int n10;
        super.clear();
        this.initiative_ = false;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = "";
        this.type_ = string2;
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        this.data_ = string2;
        this.bitField0_ = n10 &= 0xFFFFFFFB;
        return this;
    }

    public Messages$ReportCommand$Builder clearData() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$ReportCommand.getDefaultInstance().getData();
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReportCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$ReportCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$ReportCommand$Builder clearInitiative() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.initiative_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ReportCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$ReportCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$ReportCommand$Builder clearType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$ReportCommand.getDefaultInstance().getType();
        this.type_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReportCommand$Builder clone() {
        return (Messages$ReportCommand$Builder)super.clone();
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

    public Messages$ReportCommand getDefaultInstanceForType() {
        return Messages$ReportCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$38900();
    }

    public boolean getInitiative() {
        return this.initiative_;
    }

    public String getType() {
        Object object = this.type_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.type_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getTypeBytes() {
        Object object = this.type_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.type_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasData() {
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

    public boolean hasInitiative() {
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
    public boolean hasType() {
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
        return Messages.access$39000().ensureFieldAccessorsInitialized(Messages$ReportCommand.class, Messages$ReportCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$ReportCommand$Builder mergeFrom(Messages$ReportCommand messageLite) {
        Object object = Messages$ReportCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasInitiative();
        if (n10 != 0) {
            n10 = messageLite.getInitiative();
            this.setInitiative(n10 != 0);
        }
        if ((n10 = messageLite.hasType()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.type_ = object = Messages$ReportCommand.access$39600(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasData()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.data_ = object = Messages$ReportCommand.access$39700(messageLite);
            this.onChanged();
        }
        messageLite = Messages$ReportCommand.access$39900(messageLite);
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
    public Messages$ReportCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$ReportCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$ReportCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$ReportCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$ReportCommand)object2;
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
            this.mergeFrom((Messages$ReportCommand)object3);
        }
        throw var1_6;
    }

    public Messages$ReportCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$ReportCommand;
        if (bl2) {
            message = (Messages$ReportCommand)message;
            return this.mergeFrom((Messages$ReportCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$ReportCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ReportCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$ReportCommand$Builder setData(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReportCommand$Builder setDataBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.data_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ReportCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ReportCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$ReportCommand$Builder setInitiative(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.initiative_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ReportCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$ReportCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$ReportCommand$Builder setType(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.type_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReportCommand$Builder setTypeBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.type_ = byteString;
        this.onChanged();
        return this;
    }

    public final Messages$ReportCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ReportCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

