/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AndroidVersion;
import cn.leancloud.Messages$AndroidVersionOrBuilder;
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

public final class Messages$AndroidVersion$Builder
extends GeneratedMessageV3$Builder
implements Messages$AndroidVersionOrBuilder {
    private Object apiLevel_;
    private int bitField0_;
    private Object codename_;

    private Messages$AndroidVersion$Builder() {
        String string2 = "";
        this.codename_ = string2;
        this.apiLevel_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$AndroidVersion$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$AndroidVersion$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.codename_ = object = "";
        this.apiLevel_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$AndroidVersion$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$1400();
    }

    private void maybeForceBuilderInitialization() {
        Messages$AndroidVersion.access$1800();
    }

    public Messages$AndroidVersion$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$AndroidVersion$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$AndroidVersion build() {
        Messages$AndroidVersion messages$AndroidVersion = this.buildPartial();
        boolean bl2 = messages$AndroidVersion.isInitialized();
        if (bl2) {
            return messages$AndroidVersion;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$AndroidVersion);
    }

    public Messages$AndroidVersion buildPartial() {
        Object object = null;
        Messages$AndroidVersion messages$AndroidVersion = new Messages$AndroidVersion(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.codename_;
        Messages$AndroidVersion.access$2002(messages$AndroidVersion, object2);
        n11 = 2;
        if ((n10 &= n11) == n11) {
            n12 |= 2;
        }
        object = this.apiLevel_;
        Messages$AndroidVersion.access$2102(messages$AndroidVersion, object);
        Messages$AndroidVersion.access$2202(messages$AndroidVersion, n12);
        this.onBuilt();
        return messages$AndroidVersion;
    }

    public Messages$AndroidVersion$Builder clear() {
        int n10;
        int n11;
        super.clear();
        String string2 = "";
        this.codename_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.apiLevel_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFD;
        return this;
    }

    public Messages$AndroidVersion$Builder clearApiLevel() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$AndroidVersion.getDefaultInstance().getApiLevel();
        this.apiLevel_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AndroidVersion$Builder clearCodename() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$AndroidVersion.getDefaultInstance().getCodename();
        this.codename_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AndroidVersion$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$AndroidVersion$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$AndroidVersion$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$AndroidVersion$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$AndroidVersion$Builder clone() {
        return (Messages$AndroidVersion$Builder)super.clone();
    }

    public String getApiLevel() {
        Object object = this.apiLevel_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.apiLevel_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getApiLevelBytes() {
        Object object = this.apiLevel_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.apiLevel_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getCodename() {
        Object object = this.codename_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.codename_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getCodenameBytes() {
        Object object = this.codename_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.codename_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$AndroidVersion getDefaultInstanceForType() {
        return Messages$AndroidVersion.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$1400();
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasApiLevel() {
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

    public boolean hasCodename() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$1500().ensureFieldAccessorsInitialized(Messages$AndroidVersion.class, Messages$AndroidVersion$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$AndroidVersion$Builder mergeFrom(Messages$AndroidVersion messageLite) {
        Object object = Messages$AndroidVersion.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCodename();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.codename_ = object = Messages$AndroidVersion.access$2000(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasApiLevel()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.apiLevel_ = object = Messages$AndroidVersion.access$2100(messageLite);
            this.onChanged();
        }
        messageLite = Messages$AndroidVersion.access$2300(messageLite);
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
    public Messages$AndroidVersion$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$AndroidVersion.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$AndroidVersion)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$AndroidVersion)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$AndroidVersion)object2;
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
            this.mergeFrom((Messages$AndroidVersion)object3);
        }
        throw var1_6;
    }

    public Messages$AndroidVersion$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$AndroidVersion;
        if (bl2) {
            message = (Messages$AndroidVersion)message;
            return this.mergeFrom((Messages$AndroidVersion)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$AndroidVersion$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$AndroidVersion$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$AndroidVersion$Builder setApiLevel(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.apiLevel_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AndroidVersion$Builder setApiLevelBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.apiLevel_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$AndroidVersion$Builder setCodename(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.codename_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AndroidVersion$Builder setCodenameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.codename_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$AndroidVersion$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$AndroidVersion$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$AndroidVersion$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$AndroidVersion$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$AndroidVersion$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$AndroidVersion$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

