/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$SourceCodeInfo$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$SourceCodeInfoOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 locationBuilder_;
    private List location_;

    private DescriptorProtos$SourceCodeInfo$Builder() {
        List list;
        this.location_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$SourceCodeInfo$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.location_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureLocationIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.location_;
            this.location_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$27100();
    }

    private RepeatedFieldBuilderV3 getLocationFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.locationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.location_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.locationBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.location_ = null;
        }
        return this.locationBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getLocationFieldBuilder();
        }
    }

    public DescriptorProtos$SourceCodeInfo$Builder addAllLocation(Iterable iterable) {
        Object object = this.locationBuilder_;
        if (object == null) {
            this.ensureLocationIsMutable();
            object = this.location_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(int n10, DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$LocationOrBuilder) {
        Object object = this.locationBuilder_;
        if (object == null) {
            this.ensureLocationIsMutable();
            object = this.location_;
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = ((DescriptorProtos$SourceCodeInfo$Location$Builder)descriptorProtos$SourceCodeInfo$LocationOrBuilder).build();
            object.add(n10, descriptorProtos$SourceCodeInfo$LocationOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = ((DescriptorProtos$SourceCodeInfo$Location$Builder)descriptorProtos$SourceCodeInfo$LocationOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$SourceCodeInfo$LocationOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(int n10, DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        Object object = this.locationBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$SourceCodeInfo$Location);
            this.ensureLocationIsMutable();
            object = this.location_;
            object.add(n10, descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$SourceCodeInfo$Location);
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$LocationOrBuilder) {
        Object object = this.locationBuilder_;
        if (object == null) {
            this.ensureLocationIsMutable();
            object = this.location_;
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = ((DescriptorProtos$SourceCodeInfo$Location$Builder)descriptorProtos$SourceCodeInfo$LocationOrBuilder).build();
            object.add(descriptorProtos$SourceCodeInfo$LocationOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = ((DescriptorProtos$SourceCodeInfo$Location$Builder)descriptorProtos$SourceCodeInfo$LocationOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$SourceCodeInfo$LocationOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        Object object = this.locationBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$SourceCodeInfo$Location);
            this.ensureLocationIsMutable();
            object = this.location_;
            object.add(descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$SourceCodeInfo$Location);
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getLocationFieldBuilder();
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance();
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$SourceCodeInfo$Location);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getLocationFieldBuilder();
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance();
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$SourceCodeInfo$Location);
    }

    public DescriptorProtos$SourceCodeInfo$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$SourceCodeInfo build() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = this.buildPartial();
        boolean bl2 = descriptorProtos$SourceCodeInfo.isInitialized();
        if (bl2) {
            return descriptorProtos$SourceCodeInfo;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$SourceCodeInfo);
    }

    public DescriptorProtos$SourceCodeInfo buildPartial() {
        List list = null;
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = new DescriptorProtos$SourceCodeInfo(this, null);
        int n10 = this.bitField0_;
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.locationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            if ((n10 &= 1) != 0) {
                this.location_ = list = Collections.unmodifiableList(this.location_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.location_;
            DescriptorProtos$SourceCodeInfo.access$28802(descriptorProtos$SourceCodeInfo, list);
        } else {
            list = repeatedFieldBuilderV3.build();
            DescriptorProtos$SourceCodeInfo.access$28802(descriptorProtos$SourceCodeInfo, list);
        }
        this.onBuilt();
        return descriptorProtos$SourceCodeInfo;
    }

    public DescriptorProtos$SourceCodeInfo$Builder clear() {
        super.clear();
        Object object = this.locationBuilder_;
        if (object == null) {
            int n10;
            this.location_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$SourceCodeInfo$Builder clearLocation() {
        Object object = this.locationBuilder_;
        if (object == null) {
            int n10;
            this.location_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$SourceCodeInfo$Builder clone() {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.clone();
    }

    public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$27100();
    }

    public DescriptorProtos$SourceCodeInfo$Location getLocation(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.locationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$SourceCodeInfo$Location)this.location_.get(n10);
        }
        return (DescriptorProtos$SourceCodeInfo$Location)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder getLocationBuilder(int n10) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().getBuilder(n10);
    }

    public List getLocationBuilderList() {
        return this.getLocationFieldBuilder().getBuilderList();
    }

    public int getLocationCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.locationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.location_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getLocationList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.locationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.location_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.locationBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.location_.get(n10);
        }
        return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getLocationOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.locationBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.location_);
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$27200().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
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
    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$SourceCodeInfo.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$SourceCodeInfo)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$SourceCodeInfo)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$SourceCodeInfo)object2;
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
            this.mergeFrom((DescriptorProtos$SourceCodeInfo)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(DescriptorProtos$SourceCodeInfo messageLite) {
        Object object = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.locationBuilder_;
        if (object == null) {
            object = DescriptorProtos$SourceCodeInfo.access$28800(messageLite);
            int n10 = object.isEmpty();
            if (n10 == 0) {
                object = this.location_;
                n10 = object.isEmpty();
                if (n10 != 0) {
                    this.location_ = object = DescriptorProtos$SourceCodeInfo.access$28800(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureLocationIsMutable();
                    object = this.location_;
                    List list = DescriptorProtos$SourceCodeInfo.access$28800(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$SourceCodeInfo.access$28800(messageLite);
            boolean bl2 = object.isEmpty();
            if (!bl2) {
                object = this.locationBuilder_;
                bl2 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl2) {
                    int n11;
                    List list;
                    this.locationBuilder_.dispose();
                    bl2 = false;
                    object = null;
                    this.locationBuilder_ = null;
                    this.location_ = list = DescriptorProtos$SourceCodeInfo.access$28800(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                    n11 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getLocationFieldBuilder();
                    }
                    this.locationBuilder_ = object;
                } else {
                    object = this.locationBuilder_;
                    List list = DescriptorProtos$SourceCodeInfo.access$28800(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$SourceCodeInfo;
        if (bl2) {
            message = (DescriptorProtos$SourceCodeInfo)message;
            return this.mergeFrom((DescriptorProtos$SourceCodeInfo)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$SourceCodeInfo$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$SourceCodeInfo$Builder removeLocation(int n10) {
        Object object = this.locationBuilder_;
        if (object == null) {
            this.ensureLocationIsMutable();
            object = this.location_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$SourceCodeInfo$Builder setLocation(int n10, DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$LocationOrBuilder) {
        Object object = this.locationBuilder_;
        if (object == null) {
            this.ensureLocationIsMutable();
            object = this.location_;
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = ((DescriptorProtos$SourceCodeInfo$Location$Builder)descriptorProtos$SourceCodeInfo$LocationOrBuilder).build();
            object.set(n10, descriptorProtos$SourceCodeInfo$LocationOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$SourceCodeInfo$LocationOrBuilder = ((DescriptorProtos$SourceCodeInfo$Location$Builder)descriptorProtos$SourceCodeInfo$LocationOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$SourceCodeInfo$LocationOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder setLocation(int n10, DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        Object object = this.locationBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$SourceCodeInfo$Location);
            this.ensureLocationIsMutable();
            object = this.location_;
            object.set(n10, descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$SourceCodeInfo$Location);
        }
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DescriptorProtos$SourceCodeInfo$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$SourceCodeInfo$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

