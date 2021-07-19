/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

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
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$Version;
import com.google.protobuf.compiler.PluginProtos$VersionOrBuilder;
import java.io.IOException;
import java.util.Objects;

public final class PluginProtos$Version$Builder
extends GeneratedMessageV3$Builder
implements PluginProtos$VersionOrBuilder {
    private int bitField0_;
    private int major_;
    private int minor_;
    private int patch_;
    private Object suffix_ = "";

    private PluginProtos$Version$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private PluginProtos$Version$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ PluginProtos$Version$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ PluginProtos$Version$Builder(PluginProtos$1 pluginProtos$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$000();
    }

    private void maybeForceBuilderInitialization() {
        PluginProtos$Version.access$400();
    }

    public PluginProtos$Version$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$Version$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$Version build() {
        Message message = this.buildPartial();
        boolean bl2 = ((PluginProtos$Version)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public PluginProtos$Version buildPartial() {
        Object object = null;
        PluginProtos$Version pluginProtos$Version = new PluginProtos$Version(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            n11 = this.major_;
            PluginProtos$Version.access$602(pluginProtos$Version, n11);
            n11 = 1;
        } else {
            n11 = 0;
        }
        int n12 = n10 & 2;
        if (n12 != 0) {
            n12 = this.minor_;
            PluginProtos$Version.access$702(pluginProtos$Version, n12);
            n11 |= 2;
        }
        if ((n12 = n10 & 4) != 0) {
            n12 = this.patch_;
            PluginProtos$Version.access$802(pluginProtos$Version, n12);
            n11 |= 4;
        }
        if ((n10 &= 8) != 0) {
            n11 |= 8;
        }
        object = this.suffix_;
        PluginProtos$Version.access$902(pluginProtos$Version, object);
        PluginProtos$Version.access$1002(pluginProtos$Version, n11);
        this.onBuilt();
        return pluginProtos$Version;
    }

    public PluginProtos$Version$Builder clear() {
        int n10;
        int n11;
        super.clear();
        this.major_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.minor_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.patch_ = 0;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFB;
        this.suffix_ = "";
        this.bitField0_ = n10 &= 0xFFFFFFF7;
        return this;
    }

    public PluginProtos$Version$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (PluginProtos$Version$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public PluginProtos$Version$Builder clearMajor() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.major_ = 0;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder clearMinor() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.minor_ = 0;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (PluginProtos$Version$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public PluginProtos$Version$Builder clearPatch() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.patch_ = 0;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder clearSuffix() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = PluginProtos$Version.getDefaultInstance().getSuffix();
        this.suffix_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder clone() {
        return (PluginProtos$Version$Builder)super.clone();
    }

    public PluginProtos$Version getDefaultInstanceForType() {
        return PluginProtos$Version.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return PluginProtos.access$000();
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

    public String getSuffix() {
        Object object = this.suffix_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.suffix_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSuffixBytes() {
        Object object = this.suffix_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.suffix_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean hasMajor() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasMinor() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPatch() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSuffix() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$100().ensureFieldAccessorsInitialized(PluginProtos$Version.class, PluginProtos$Version$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PluginProtos$Version$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = PluginProtos$Version.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (PluginProtos$Version)object;
            if (object == null) break block7;
            this.mergeFrom((PluginProtos$Version)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (PluginProtos$Version)object2;
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
            this.mergeFrom((PluginProtos$Version)object3);
        }
        throw var1_6;
    }

    public PluginProtos$Version$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof PluginProtos$Version;
        if (bl2) {
            message = (PluginProtos$Version)message;
            return this.mergeFrom((PluginProtos$Version)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public PluginProtos$Version$Builder mergeFrom(PluginProtos$Version messageLite) {
        Object object = PluginProtos$Version.getDefaultInstance();
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
        if ((n10 = (int)(messageLite.hasSuffix() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.suffix_ = object = PluginProtos$Version.access$900(messageLite);
            this.onChanged();
        }
        messageLite = PluginProtos$Version.access$1100(messageLite);
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final PluginProtos$Version$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$Version$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public PluginProtos$Version$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$Version$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$Version$Builder setMajor(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.major_ = n10;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder setMinor(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.minor_ = n10;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder setPatch(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.patch_ = n10;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (PluginProtos$Version$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public PluginProtos$Version$Builder setSuffix(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.suffix_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$Version$Builder setSuffixBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.suffix_ = byteString;
        this.onChanged();
        return this;
    }

    public final PluginProtos$Version$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$Version$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

