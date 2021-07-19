/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ApiProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
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
import com.google.protobuf.Method;
import com.google.protobuf.Method$1;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.Syntax;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Method$Builder
extends GeneratedMessageV3$Builder
implements MethodOrBuilder {
    private int bitField0_;
    private Object name_;
    private RepeatedFieldBuilderV3 optionsBuilder_;
    private List options_;
    private boolean requestStreaming_;
    private Object requestTypeUrl_;
    private boolean responseStreaming_;
    private Object responseTypeUrl_;
    private int syntax_;

    private Method$Builder() {
        Object object;
        this.name_ = object = "";
        this.requestTypeUrl_ = object;
        this.responseTypeUrl_ = object;
        this.options_ = object = Collections.emptyList();
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    private Method$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = "";
        this.name_ = list;
        this.requestTypeUrl_ = list;
        this.responseTypeUrl_ = list;
        this.options_ = list = Collections.emptyList();
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Method$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Method$1 method$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Method$Builder(Method$1 method$1) {
        this();
    }

    private void ensureOptionsIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.options_;
            this.options_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    private RepeatedFieldBuilderV3 getOptionsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.options_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getOptionsFieldBuilder();
        }
    }

    public Method$Builder addAllOptions(Iterable iterable) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Method$Builder addOptions(int n10, Option$Builder messageOrBuilder) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            object.add(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Method$Builder addOptions(int n10, Option option) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            Objects.requireNonNull(option);
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.add(n10, option);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, option);
        }
        return this;
    }

    public Method$Builder addOptions(Option$Builder messageOrBuilder) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            object.add(messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Method$Builder addOptions(Option option) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            Objects.requireNonNull(option);
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.add(option);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(option);
        }
        return this;
    }

    public Option$Builder addOptionsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getOptionsFieldBuilder();
        Option option = Option.getDefaultInstance();
        return (Option$Builder)repeatedFieldBuilderV3.addBuilder(option);
    }

    public Option$Builder addOptionsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getOptionsFieldBuilder();
        Option option = Option.getDefaultInstance();
        return (Option$Builder)repeatedFieldBuilderV3.addBuilder(n10, option);
    }

    public Method$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Method$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Method build() {
        Message message = this.buildPartial();
        boolean bl2 = ((Method)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public Method buildPartial() {
        Method method = new Method(this, null);
        List list = this.name_;
        Method.access$302(method, list);
        list = this.requestTypeUrl_;
        Method.access$402(method, list);
        int n10 = this.requestStreaming_;
        Method.access$502(method, n10 != 0);
        list = this.responseTypeUrl_;
        Method.access$602(method, list);
        n10 = this.responseStreaming_;
        Method.access$702(method, n10 != 0);
        list = this.optionsBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 1;
            if (n10 != 0) {
                this.options_ = list = Collections.unmodifiableList(this.options_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.options_;
            Method.access$802(method, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Method.access$802(method, list);
        }
        n10 = this.syntax_;
        Method.access$902(method, n10);
        this.onBuilt();
        return method;
    }

    public Method$Builder clear() {
        super.clear();
        List list = "";
        this.name_ = list;
        this.requestTypeUrl_ = list;
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = list;
        this.responseStreaming_ = false;
        list = this.optionsBuilder_;
        if (list == null) {
            int n10;
            this.options_ = list = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)((Object)list)).clear();
        }
        this.syntax_ = 0;
        return this;
    }

    public Method$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Method$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Method$Builder clearName() {
        String string2 = Method.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Method$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Method$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Method$Builder clearOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            int n10;
            this.options_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Method$Builder clearRequestStreaming() {
        this.requestStreaming_ = false;
        this.onChanged();
        return this;
    }

    public Method$Builder clearRequestTypeUrl() {
        String string2 = Method.getDefaultInstance().getRequestTypeUrl();
        this.requestTypeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Method$Builder clearResponseStreaming() {
        this.responseStreaming_ = false;
        this.onChanged();
        return this;
    }

    public Method$Builder clearResponseTypeUrl() {
        String string2 = Method.getDefaultInstance().getResponseTypeUrl();
        this.responseTypeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Method$Builder clearSyntax() {
        this.syntax_ = 0;
        this.onChanged();
        return this;
    }

    public Method$Builder clone() {
        return (Method$Builder)super.clone();
    }

    public Method getDefaultInstanceForType() {
        return Method.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.name_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getNameBytes() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.name_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Option getOptions(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Option)this.options_.get(n10);
        }
        return (Option)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Option$Builder getOptionsBuilder(int n10) {
        return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(n10);
    }

    public List getOptionsBuilderList() {
        return this.getOptionsFieldBuilder().getBuilderList();
    }

    public int getOptionsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.options_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getOptionsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.options_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public OptionOrBuilder getOptionsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (OptionOrBuilder)this.options_.get(n10);
        }
        return (OptionOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getOptionsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.options_);
    }

    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    public String getRequestTypeUrl() {
        Object object = this.requestTypeUrl_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.requestTypeUrl_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getRequestTypeUrlBytes() {
        Object object = this.requestTypeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.requestTypeUrl_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    public String getResponseTypeUrl() {
        Object object = this.responseTypeUrl_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.responseTypeUrl_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getResponseTypeUrlBytes() {
        Object object = this.responseTypeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.responseTypeUrl_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Syntax getSyntax() {
        int n10 = this.syntax_;
        Syntax syntax = Syntax.valueOf(n10);
        if (syntax == null) {
            syntax = Syntax.UNRECOGNIZED;
        }
        return syntax;
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
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
    public Method$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Method.access$1000();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Method)object;
            if (object == null) break block7;
            this.mergeFrom((Method)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Method)object2;
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
            this.mergeFrom((Method)object3);
        }
        throw var1_6;
    }

    public Method$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Method;
        if (bl2) {
            message = (Method)message;
            return this.mergeFrom((Method)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Method$Builder mergeFrom(Method messageLite) {
        int n10;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        Object object = Method.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = ((Method)messageLite).getName();
        boolean n102 = ((String)object).isEmpty();
        if (!n102) {
            this.name_ = object = Method.access$300((Method)messageLite);
            this.onChanged();
        }
        if (!(bl5 = ((String)(object = ((Method)messageLite).getRequestTypeUrl())).isEmpty())) {
            this.requestTypeUrl_ = object = Method.access$400((Method)messageLite);
            this.onChanged();
        }
        if (bl4 = ((Method)messageLite).getRequestStreaming()) {
            boolean bl6 = ((Method)messageLite).getRequestStreaming();
            this.setRequestStreaming(bl6);
        }
        if (!(bl3 = ((String)(object = ((Method)messageLite).getResponseTypeUrl())).isEmpty())) {
            this.responseTypeUrl_ = object = Method.access$600((Method)messageLite);
            this.onChanged();
        }
        if (bl2 = ((Method)messageLite).getResponseStreaming()) {
            boolean bl7 = ((Method)messageLite).getResponseStreaming();
            this.setResponseStreaming(bl7);
        }
        if ((object = this.optionsBuilder_) == null) {
            object = Method.access$800((Method)messageLite);
            boolean bl8 = object.isEmpty();
            if (!bl8) {
                object = this.options_;
                boolean bl9 = object.isEmpty();
                if (bl9) {
                    int n11;
                    this.options_ = object = Method.access$800((Method)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureOptionsIsMutable();
                    object = this.options_;
                    List list = Method.access$800((Method)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Method.access$800((Method)messageLite);
            boolean bl10 = object.isEmpty();
            if (!bl10) {
                object = this.optionsBuilder_;
                boolean bl11 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl11) {
                    int n12;
                    List list;
                    this.optionsBuilder_.dispose();
                    boolean bl12 = false;
                    object = null;
                    this.optionsBuilder_ = null;
                    this.options_ = list = Method.access$800((Method)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                    n12 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getOptionsFieldBuilder();
                    }
                    this.optionsBuilder_ = object;
                } else {
                    object = this.optionsBuilder_;
                    List list = Method.access$800((Method)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((n10 = Method.access$900((Method)messageLite)) != 0) {
            int n13 = ((Method)messageLite).getSyntaxValue();
            this.setSyntaxValue(n13);
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final Method$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Method$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Method$Builder removeOptions(int n10) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Method$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Method$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Method$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Method$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public Method$Builder setOptions(int n10, Option$Builder messageOrBuilder) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            this.ensureOptionsIsMutable();
            object = this.options_;
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            object.set(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Option$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Method$Builder setOptions(int n10, Option option) {
        Object object = this.optionsBuilder_;
        if (object == null) {
            Objects.requireNonNull(option);
            this.ensureOptionsIsMutable();
            object = this.options_;
            object.set(n10, option);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, option);
        }
        return this;
    }

    public Method$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Method$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Method$Builder setRequestStreaming(boolean bl2) {
        this.requestStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public Method$Builder setRequestTypeUrl(String string2) {
        Objects.requireNonNull(string2);
        this.requestTypeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Method$Builder setRequestTypeUrlBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.requestTypeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    public Method$Builder setResponseStreaming(boolean bl2) {
        this.responseStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public Method$Builder setResponseTypeUrl(String string2) {
        Objects.requireNonNull(string2);
        this.responseTypeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Method$Builder setResponseTypeUrlBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.responseTypeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    public Method$Builder setSyntax(Syntax syntax) {
        int n10;
        Objects.requireNonNull(syntax);
        this.syntax_ = n10 = syntax.getNumber();
        this.onChanged();
        return this;
    }

    public Method$Builder setSyntaxValue(int n10) {
        this.syntax_ = n10;
        this.onChanged();
        return this;
    }

    public final Method$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Method$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

