/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ConvMemberInfo;
import cn.leancloud.Messages$ConvMemberInfoOrBuilder;
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

public final class Messages$ConvMemberInfo$Builder
extends GeneratedMessageV3$Builder
implements Messages$ConvMemberInfoOrBuilder {
    private int bitField0_;
    private Object infoId_;
    private Object pid_;
    private Object role_;

    private Messages$ConvMemberInfo$Builder() {
        String string2 = "";
        this.pid_ = string2;
        this.role_ = string2;
        this.infoId_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ConvMemberInfo$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$ConvMemberInfo$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.pid_ = object = "";
        this.role_ = object;
        this.infoId_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ConvMemberInfo$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$8700();
    }

    private void maybeForceBuilderInitialization() {
        Messages$ConvMemberInfo.access$9100();
    }

    public Messages$ConvMemberInfo$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ConvMemberInfo$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$ConvMemberInfo build() {
        Messages$ConvMemberInfo messages$ConvMemberInfo = this.buildPartial();
        boolean bl2 = messages$ConvMemberInfo.isInitialized();
        if (bl2) {
            return messages$ConvMemberInfo;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$ConvMemberInfo);
    }

    public Messages$ConvMemberInfo buildPartial() {
        Object object = null;
        Messages$ConvMemberInfo messages$ConvMemberInfo = new Messages$ConvMemberInfo(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.pid_;
        Messages$ConvMemberInfo.access$9302(messages$ConvMemberInfo, object2);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        object2 = this.role_;
        Messages$ConvMemberInfo.access$9402(messages$ConvMemberInfo, object2);
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n12 |= 4;
        }
        object = this.infoId_;
        Messages$ConvMemberInfo.access$9502(messages$ConvMemberInfo, object);
        Messages$ConvMemberInfo.access$9602(messages$ConvMemberInfo, n12);
        this.onBuilt();
        return messages$ConvMemberInfo;
    }

    public Messages$ConvMemberInfo$Builder clear() {
        int n10;
        int n11;
        super.clear();
        String string2 = "";
        this.pid_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.role_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.infoId_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFB;
        return this;
    }

    public Messages$ConvMemberInfo$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$ConvMemberInfo$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$ConvMemberInfo$Builder clearInfoId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$ConvMemberInfo.getDefaultInstance().getInfoId();
        this.infoId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$ConvMemberInfo$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$ConvMemberInfo$Builder clearPid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$ConvMemberInfo.getDefaultInstance().getPid();
        this.pid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder clearRole() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$ConvMemberInfo.getDefaultInstance().getRole();
        this.role_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder clone() {
        return (Messages$ConvMemberInfo$Builder)super.clone();
    }

    public Messages$ConvMemberInfo getDefaultInstanceForType() {
        return Messages$ConvMemberInfo.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$8700();
    }

    public String getInfoId() {
        Object object = this.infoId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.infoId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getInfoIdBytes() {
        Object object = this.infoId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.infoId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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

    public String getRole() {
        Object object = this.role_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.role_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getRoleBytes() {
        Object object = this.role_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.role_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasInfoId() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasRole() {
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
        return Messages.access$8800().ensureFieldAccessorsInitialized(Messages$ConvMemberInfo.class, Messages$ConvMemberInfo$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$ConvMemberInfo$Builder mergeFrom(Messages$ConvMemberInfo messageLite) {
        Object object = Messages$ConvMemberInfo.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasPid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.pid_ = object = Messages$ConvMemberInfo.access$9300(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasRole()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.role_ = object = Messages$ConvMemberInfo.access$9400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasInfoId() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.infoId_ = object = Messages$ConvMemberInfo.access$9500(messageLite);
            this.onChanged();
        }
        messageLite = Messages$ConvMemberInfo.access$9700(messageLite);
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
    public Messages$ConvMemberInfo$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$ConvMemberInfo.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$ConvMemberInfo)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$ConvMemberInfo)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$ConvMemberInfo)object2;
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
            this.mergeFrom((Messages$ConvMemberInfo)object3);
        }
        throw var1_6;
    }

    public Messages$ConvMemberInfo$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$ConvMemberInfo;
        if (bl2) {
            message = (Messages$ConvMemberInfo)message;
            return this.mergeFrom((Messages$ConvMemberInfo)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$ConvMemberInfo$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ConvMemberInfo$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$ConvMemberInfo$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ConvMemberInfo$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$ConvMemberInfo$Builder setInfoId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.infoId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder setInfoIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.infoId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder setPid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.pid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder setPidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.pid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$ConvMemberInfo$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$ConvMemberInfo$Builder setRole(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.role_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvMemberInfo$Builder setRoleBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.role_ = byteString;
        this.onChanged();
        return this;
    }

    public final Messages$ConvMemberInfo$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ConvMemberInfo$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

