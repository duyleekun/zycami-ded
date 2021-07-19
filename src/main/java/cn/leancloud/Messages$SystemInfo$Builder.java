/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AndroidVersion;
import cn.leancloud.Messages$AndroidVersion$Builder;
import cn.leancloud.Messages$AndroidVersionOrBuilder;
import cn.leancloud.Messages$DeviceType;
import cn.leancloud.Messages$SemanticVersion;
import cn.leancloud.Messages$SemanticVersion$Builder;
import cn.leancloud.Messages$SemanticVersionOrBuilder;
import cn.leancloud.Messages$SystemInfo;
import cn.leancloud.Messages$SystemInfoOrBuilder;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Messages$SystemInfo$Builder
extends GeneratedMessageV3$Builder
implements Messages$SystemInfoOrBuilder {
    private SingleFieldBuilderV3 androidVersionBuilder_;
    private Messages$AndroidVersion androidVersion_ = null;
    private int bitField0_;
    private int deviceType_ = 0;
    private boolean isEmulator_;
    private SingleFieldBuilderV3 osVersionBuilder_;
    private Messages$SemanticVersion osVersion_ = null;

    private Messages$SystemInfo$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$SystemInfo$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$SystemInfo$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$SystemInfo$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private SingleFieldBuilderV3 getAndroidVersionFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.androidVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$AndroidVersion messages$AndroidVersion = this.getAndroidVersion();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.androidVersionBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$AndroidVersion, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.androidVersion_ = null;
        }
        return this.androidVersionBuilder_;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$2500();
    }

    private SingleFieldBuilderV3 getOsVersionFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.osVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$SemanticVersion messages$SemanticVersion = this.getOsVersion();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.osVersionBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$SemanticVersion, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.osVersion_ = null;
        }
        return this.osVersionBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$SystemInfo.access$2900();
        if (bl2) {
            this.getOsVersionFieldBuilder();
            this.getAndroidVersionFieldBuilder();
        }
    }

    public Messages$SystemInfo$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$SystemInfo$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$SystemInfo build() {
        Messages$SystemInfo messages$SystemInfo = this.buildPartial();
        boolean bl2 = messages$SystemInfo.isInitialized();
        if (bl2) {
            return messages$SystemInfo;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$SystemInfo);
    }

    public Messages$SystemInfo buildPartial() {
        Object object;
        Messages$SystemInfo messages$SystemInfo = new Messages$SystemInfo(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        n11 = this.deviceType_;
        Messages$SystemInfo.access$3102(messages$SystemInfo, n11);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        if ((object = this.osVersionBuilder_) == null) {
            object = this.osVersion_;
            Messages$SystemInfo.access$3202(messages$SystemInfo, (Messages$SemanticVersion)object);
        } else {
            object = (Messages$SemanticVersion)((SingleFieldBuilderV3)object).build();
            Messages$SystemInfo.access$3202(messages$SystemInfo, (Messages$SemanticVersion)object);
        }
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        if ((object = this.androidVersionBuilder_) == null) {
            object = this.androidVersion_;
            Messages$SystemInfo.access$3302(messages$SystemInfo, (Messages$AndroidVersion)object);
        } else {
            object = (Messages$AndroidVersion)((SingleFieldBuilderV3)object).build();
            Messages$SystemInfo.access$3302(messages$SystemInfo, (Messages$AndroidVersion)object);
        }
        n11 = 8;
        if ((n10 &= n11) == n11) {
            n12 |= 8;
        }
        n10 = (int)(this.isEmulator_ ? 1 : 0);
        Messages$SystemInfo.access$3402(messages$SystemInfo, n10 != 0);
        Messages$SystemInfo.access$3502(messages$SystemInfo, n12);
        this.onBuilt();
        return messages$SystemInfo;
    }

    public Messages$SystemInfo$Builder clear() {
        int n10;
        super.clear();
        int n11 = 0;
        this.deviceType_ = 0;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.osVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.osVersion_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        singleFieldBuilderV3 = this.androidVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.androidVersion_ = null;
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.isEmulator_ = false;
        this.bitField0_ = n11 = n10 & 0xFFFFFFF7;
        return this;
    }

    public Messages$SystemInfo$Builder clearAndroidVersion() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.androidVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.androidVersion_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        return this;
    }

    public Messages$SystemInfo$Builder clearDeviceType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.deviceType_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$SystemInfo$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$SystemInfo$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$SystemInfo$Builder clearIsEmulator() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.isEmulator_ = false;
        this.onChanged();
        return this;
    }

    public Messages$SystemInfo$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$SystemInfo$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$SystemInfo$Builder clearOsVersion() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.osVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.osVersion_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        return this;
    }

    public Messages$SystemInfo$Builder clone() {
        return (Messages$SystemInfo$Builder)super.clone();
    }

    public Messages$AndroidVersion getAndroidVersion() {
        Object object = this.androidVersionBuilder_;
        if (object == null) {
            object = this.androidVersion_;
            if (object == null) {
                object = Messages$AndroidVersion.getDefaultInstance();
            }
            return object;
        }
        return (Messages$AndroidVersion)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$AndroidVersion$Builder getAndroidVersionBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.onChanged();
        return (Messages$AndroidVersion$Builder)this.getAndroidVersionFieldBuilder().getBuilder();
    }

    public Messages$AndroidVersionOrBuilder getAndroidVersionOrBuilder() {
        Object object = this.androidVersionBuilder_;
        if (object != null) {
            return (Messages$AndroidVersionOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.androidVersion_;
        if (object == null) {
            object = Messages$AndroidVersion.getDefaultInstance();
        }
        return object;
    }

    public Messages$SystemInfo getDefaultInstanceForType() {
        return Messages$SystemInfo.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$2500();
    }

    public Messages$DeviceType getDeviceType() {
        int n10 = this.deviceType_;
        Messages$DeviceType messages$DeviceType = Messages$DeviceType.valueOf(n10);
        if (messages$DeviceType == null) {
            messages$DeviceType = Messages$DeviceType.unknown;
        }
        return messages$DeviceType;
    }

    public boolean getIsEmulator() {
        return this.isEmulator_;
    }

    public Messages$SemanticVersion getOsVersion() {
        Object object = this.osVersionBuilder_;
        if (object == null) {
            object = this.osVersion_;
            if (object == null) {
                object = Messages$SemanticVersion.getDefaultInstance();
            }
            return object;
        }
        return (Messages$SemanticVersion)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$SemanticVersion$Builder getOsVersionBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.onChanged();
        return (Messages$SemanticVersion$Builder)this.getOsVersionFieldBuilder().getBuilder();
    }

    public Messages$SemanticVersionOrBuilder getOsVersionOrBuilder() {
        Object object = this.osVersionBuilder_;
        if (object != null) {
            return (Messages$SemanticVersionOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.osVersion_;
        if (object == null) {
            object = Messages$SemanticVersion.getDefaultInstance();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAndroidVersion() {
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

    public boolean hasDeviceType() {
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
    public boolean hasIsEmulator() {
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
    public boolean hasOsVersion() {
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
        return Messages.access$2600().ensureFieldAccessorsInitialized(Messages$SystemInfo.class, Messages$SystemInfo$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$SystemInfo$Builder mergeAndroidVersion(Messages$AndroidVersion messages$AndroidVersion) {
        int n10;
        Object object = this.androidVersionBuilder_;
        int n11 = 4;
        if (object == null) {
            Messages$AndroidVersion messages$AndroidVersion2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.androidVersion_) != null && object != (messages$AndroidVersion2 = Messages$AndroidVersion.getDefaultInstance())) {
                object = Messages$AndroidVersion.newBuilder(this.androidVersion_);
                this.androidVersion_ = messages$AndroidVersion = ((Messages$AndroidVersion$Builder)object).mergeFrom(messages$AndroidVersion).buildPartial();
            } else {
                this.androidVersion_ = messages$AndroidVersion;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$AndroidVersion);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$SystemInfo$Builder mergeFrom(Messages$SystemInfo messageLite) {
        Object object = Messages$SystemInfo.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        boolean bl2 = messageLite.hasDeviceType();
        if (bl2) {
            object = messageLite.getDeviceType();
            this.setDeviceType((Messages$DeviceType)object);
        }
        if (bl2 = messageLite.hasOsVersion()) {
            object = messageLite.getOsVersion();
            this.mergeOsVersion((Messages$SemanticVersion)object);
        }
        if (bl2 = messageLite.hasAndroidVersion()) {
            object = messageLite.getAndroidVersion();
            this.mergeAndroidVersion((Messages$AndroidVersion)object);
        }
        if (bl2 = messageLite.hasIsEmulator()) {
            bl2 = messageLite.getIsEmulator();
            this.setIsEmulator(bl2);
        }
        messageLite = Messages$SystemInfo.access$3600(messageLite);
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
    public Messages$SystemInfo$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$SystemInfo.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$SystemInfo)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$SystemInfo)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$SystemInfo)object2;
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
            this.mergeFrom((Messages$SystemInfo)object3);
        }
        throw var1_6;
    }

    public Messages$SystemInfo$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$SystemInfo;
        if (bl2) {
            message = (Messages$SystemInfo)message;
            return this.mergeFrom((Messages$SystemInfo)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Messages$SystemInfo$Builder mergeOsVersion(Messages$SemanticVersion messages$SemanticVersion) {
        int n10;
        Object object = this.osVersionBuilder_;
        int n11 = 2;
        if (object == null) {
            Messages$SemanticVersion messages$SemanticVersion2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.osVersion_) != null && object != (messages$SemanticVersion2 = Messages$SemanticVersion.getDefaultInstance())) {
                object = Messages$SemanticVersion.newBuilder(this.osVersion_);
                this.osVersion_ = messages$SemanticVersion = ((Messages$SemanticVersion$Builder)object).mergeFrom(messages$SemanticVersion).buildPartial();
            } else {
                this.osVersion_ = messages$SemanticVersion;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$SemanticVersion);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public final Messages$SystemInfo$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$SystemInfo$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$SystemInfo$Builder setAndroidVersion(Messages$AndroidVersion$Builder messages$AndroidVersionOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.androidVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$AndroidVersionOrBuilder = messages$AndroidVersionOrBuilder.build();
            this.androidVersion_ = messages$AndroidVersionOrBuilder;
            this.onChanged();
        } else {
            messages$AndroidVersionOrBuilder = messages$AndroidVersionOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$AndroidVersionOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public Messages$SystemInfo$Builder setAndroidVersion(Messages$AndroidVersion messages$AndroidVersion) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.androidVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$AndroidVersion);
            this.androidVersion_ = messages$AndroidVersion;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$AndroidVersion);
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
        return this;
    }

    public Messages$SystemInfo$Builder setDeviceType(Messages$DeviceType messages$DeviceType) {
        int n10;
        int n11;
        Objects.requireNonNull(messages$DeviceType);
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.deviceType_ = n10 = messages$DeviceType.getNumber();
        this.onChanged();
        return this;
    }

    public Messages$SystemInfo$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$SystemInfo$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$SystemInfo$Builder setIsEmulator(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.isEmulator_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$SystemInfo$Builder setOsVersion(Messages$SemanticVersion$Builder messages$SemanticVersionOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.osVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$SemanticVersionOrBuilder = messages$SemanticVersionOrBuilder.build();
            this.osVersion_ = messages$SemanticVersionOrBuilder;
            this.onChanged();
        } else {
            messages$SemanticVersionOrBuilder = messages$SemanticVersionOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$SemanticVersionOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
        return this;
    }

    public Messages$SystemInfo$Builder setOsVersion(Messages$SemanticVersion messages$SemanticVersion) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.osVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$SemanticVersion);
            this.osVersion_ = messages$SemanticVersion;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$SemanticVersion);
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
        return this;
    }

    public Messages$SystemInfo$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$SystemInfo$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$SystemInfo$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$SystemInfo$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

