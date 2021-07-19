/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$SemanticVersion;
import cn.leancloud.Messages$SemanticVersionOrBuilder;
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

public final class Messages$SemanticVersion$Builder
extends GeneratedMessageV3$Builder
implements Messages$SemanticVersionOrBuilder {
    private int bitField0_;
    private Object build_;
    private int major_;
    private int minor_;
    private int patch_;
    private Object preRelease_;

    private Messages$SemanticVersion$Builder() {
        String string2 = "";
        this.preRelease_ = string2;
        this.build_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$SemanticVersion$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$SemanticVersion$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.preRelease_ = object = "";
        this.build_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$SemanticVersion$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$000();
    }

    private void maybeForceBuilderInitialization() {
        Messages$SemanticVersion.access$400();
    }

    public Messages$SemanticVersion$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$SemanticVersion$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$SemanticVersion build() {
        Messages$SemanticVersion messages$SemanticVersion = this.buildPartial();
        boolean bl2 = messages$SemanticVersion.isInitialized();
        if (bl2) {
            return messages$SemanticVersion;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$SemanticVersion);
    }

    public Messages$SemanticVersion buildPartial() {
        Object object = null;
        Messages$SemanticVersion messages$SemanticVersion = new Messages$SemanticVersion(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        n11 = this.major_;
        Messages$SemanticVersion.access$602(messages$SemanticVersion, n11);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        n11 = this.minor_;
        Messages$SemanticVersion.access$702(messages$SemanticVersion, n11);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        n11 = this.patch_;
        Messages$SemanticVersion.access$802(messages$SemanticVersion, n11);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        Object object2 = this.preRelease_;
        Messages$SemanticVersion.access$902(messages$SemanticVersion, object2);
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n12 |= 0x10;
        }
        object = this.build_;
        Messages$SemanticVersion.access$1002(messages$SemanticVersion, object);
        Messages$SemanticVersion.access$1102(messages$SemanticVersion, n12);
        this.onBuilt();
        return messages$SemanticVersion;
    }

    public Messages$SemanticVersion$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.major_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.minor_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.patch_ = 0;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFB;
        String string2 = "";
        this.preRelease_ = string2;
        this.bitField0_ = n10 &= 0xFFFFFFF7;
        this.build_ = string2;
        this.bitField0_ = n10 &= 0xFFFFFFEF;
        return this;
    }

    public Messages$SemanticVersion$Builder clearBuild() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        String string2 = Messages$SemanticVersion.getDefaultInstance().getBuild();
        this.build_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$SemanticVersion$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$SemanticVersion$Builder clearMajor() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.major_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder clearMinor() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.minor_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$SemanticVersion$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$SemanticVersion$Builder clearPatch() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.patch_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder clearPreRelease() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$SemanticVersion.getDefaultInstance().getPreRelease();
        this.preRelease_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder clone() {
        return (Messages$SemanticVersion$Builder)super.clone();
    }

    public String getBuild() {
        Object object = this.build_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.build_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getBuildBytes() {
        Object object = this.build_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.build_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$SemanticVersion getDefaultInstanceForType() {
        return Messages$SemanticVersion.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$000();
    }

    public int getMajor() {
        return this.major_;
    }

    public int getMinor() {
        return this.minor_;
    }

    public int getPatch() {
        return this.patch_;
    }

    public String getPreRelease() {
        Object object = this.preRelease_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.preRelease_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPreReleaseBytes() {
        Object object = this.preRelease_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.preRelease_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBuild() {
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

    public boolean hasMajor() {
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
    public boolean hasMinor() {
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
    public boolean hasPatch() {
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
    public boolean hasPreRelease() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$100().ensureFieldAccessorsInitialized(Messages$SemanticVersion.class, Messages$SemanticVersion$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$SemanticVersion$Builder mergeFrom(Messages$SemanticVersion messageLite) {
        Object object = Messages$SemanticVersion.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasMajor();
        if (n10 != 0) {
            n10 = messageLite.getMajor();
            this.setMajor(n10);
        }
        if ((n10 = (int)(messageLite.hasMinor() ? 1 : 0)) != 0) {
            n10 = messageLite.getMinor();
            this.setMinor(n10);
        }
        if ((n10 = (int)(messageLite.hasPatch() ? 1 : 0)) != 0) {
            n10 = messageLite.getPatch();
            this.setPatch(n10);
        }
        if ((n10 = (int)(messageLite.hasPreRelease() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.preRelease_ = object = Messages$SemanticVersion.access$900(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasBuild() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
            this.build_ = object = Messages$SemanticVersion.access$1000(messageLite);
            this.onChanged();
        }
        messageLite = Messages$SemanticVersion.access$1200(messageLite);
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
    public Messages$SemanticVersion$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$SemanticVersion.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$SemanticVersion)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$SemanticVersion)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$SemanticVersion)object2;
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
            this.mergeFrom((Messages$SemanticVersion)object3);
        }
        throw var1_6;
    }

    public Messages$SemanticVersion$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$SemanticVersion;
        if (bl2) {
            message = (Messages$SemanticVersion)message;
            return this.mergeFrom((Messages$SemanticVersion)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$SemanticVersion$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$SemanticVersion$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$SemanticVersion$Builder setBuild(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.build_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder setBuildBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.build_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$SemanticVersion$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$SemanticVersion$Builder setMajor(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.major_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder setMinor(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.minor_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder setPatch(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.patch_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder setPreRelease(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.preRelease_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder setPreReleaseBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.preRelease_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$SemanticVersion$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$SemanticVersion$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$SemanticVersion$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$SemanticVersion$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

