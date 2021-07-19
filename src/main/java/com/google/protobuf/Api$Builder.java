/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.Api;
import com.google.protobuf.Api$1;
import com.google.protobuf.ApiOrBuilder;
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
import com.google.protobuf.Method$Builder;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Mixin;
import com.google.protobuf.Mixin$Builder;
import com.google.protobuf.MixinOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Api$Builder
extends GeneratedMessageV3$Builder
implements ApiOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 methodsBuilder_;
    private List methods_;
    private RepeatedFieldBuilderV3 mixinsBuilder_;
    private List mixins_;
    private Object name_;
    private RepeatedFieldBuilderV3 optionsBuilder_;
    private List options_;
    private SingleFieldBuilderV3 sourceContextBuilder_;
    private SourceContext sourceContext_;
    private int syntax_;
    private Object version_;

    private Api$Builder() {
        List list;
        Object object;
        this.name_ = object = "";
        this.methods_ = list = Collections.emptyList();
        this.options_ = list = Collections.emptyList();
        this.version_ = object;
        this.mixins_ = object = Collections.emptyList();
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Api$Builder(Api$1 api$1) {
        this();
    }

    private Api$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        List list2;
        list = "";
        this.name_ = list;
        this.methods_ = list2 = Collections.emptyList();
        this.options_ = list2 = Collections.emptyList();
        this.version_ = list;
        this.mixins_ = list = Collections.emptyList();
        this.syntax_ = 0;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Api$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Api$1 api$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureMethodsIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.methods_;
            this.methods_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    private void ensureMixinsIsMutable() {
        int n10 = this.bitField0_ & 4;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.mixins_;
            this.mixins_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 4;
        }
    }

    private void ensureOptionsIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.options_;
            this.options_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    private RepeatedFieldBuilderV3 getMethodsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.methods_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.methodsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.methods_ = null;
        }
        return this.methodsBuilder_;
    }

    private RepeatedFieldBuilderV3 getMixinsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.mixinsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.mixins_;
            int n10 = this.bitField0_ & 4;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.mixinsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.mixins_ = null;
        }
        return this.mixinsBuilder_;
    }

    private RepeatedFieldBuilderV3 getOptionsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.optionsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.options_;
            int n10 = this.bitField0_ & 2;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.optionsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }

    private SingleFieldBuilderV3 getSourceContextFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            SourceContext sourceContext = this.getSourceContext();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.sourceContextBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(sourceContext, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.sourceContext_ = null;
        }
        return this.sourceContextBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getMethodsFieldBuilder();
            this.getOptionsFieldBuilder();
            this.getMixinsFieldBuilder();
        }
    }

    public Api$Builder addAllMethods(Iterable iterable) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            this.ensureMethodsIsMutable();
            object = this.methods_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Api$Builder addAllMixins(Iterable iterable) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Api$Builder addAllOptions(Iterable iterable) {
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

    public Api$Builder addMethods(int n10, Method$Builder messageOrBuilder) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            this.ensureMethodsIsMutable();
            object = this.methods_;
            messageOrBuilder = ((Method$Builder)messageOrBuilder).build();
            object.add(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Method$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Api$Builder addMethods(int n10, Method method) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            Objects.requireNonNull(method);
            this.ensureMethodsIsMutable();
            object = this.methods_;
            object.add(n10, method);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, method);
        }
        return this;
    }

    public Api$Builder addMethods(Method$Builder messageOrBuilder) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            this.ensureMethodsIsMutable();
            object = this.methods_;
            messageOrBuilder = ((Method$Builder)messageOrBuilder).build();
            object.add(messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Method$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Api$Builder addMethods(Method method) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            Objects.requireNonNull(method);
            this.ensureMethodsIsMutable();
            object = this.methods_;
            object.add(method);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(method);
        }
        return this;
    }

    public Method$Builder addMethodsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMethodsFieldBuilder();
        Method method = Method.getDefaultInstance();
        return (Method$Builder)repeatedFieldBuilderV3.addBuilder(method);
    }

    public Method$Builder addMethodsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMethodsFieldBuilder();
        Method method = Method.getDefaultInstance();
        return (Method$Builder)repeatedFieldBuilderV3.addBuilder(n10, method);
    }

    public Api$Builder addMixins(int n10, Mixin$Builder messageOrBuilder) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            messageOrBuilder = ((Mixin$Builder)messageOrBuilder).build();
            object.add(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Mixin$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Api$Builder addMixins(int n10, Mixin mixin) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            Objects.requireNonNull(mixin);
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            object.add(n10, mixin);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, mixin);
        }
        return this;
    }

    public Api$Builder addMixins(Mixin$Builder messageOrBuilder) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            messageOrBuilder = ((Mixin$Builder)messageOrBuilder).build();
            object.add(messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Mixin$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Api$Builder addMixins(Mixin mixin) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            Objects.requireNonNull(mixin);
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            object.add(mixin);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(mixin);
        }
        return this;
    }

    public Mixin$Builder addMixinsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMixinsFieldBuilder();
        Mixin mixin = Mixin.getDefaultInstance();
        return (Mixin$Builder)repeatedFieldBuilderV3.addBuilder(mixin);
    }

    public Mixin$Builder addMixinsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMixinsFieldBuilder();
        Mixin mixin = Mixin.getDefaultInstance();
        return (Mixin$Builder)repeatedFieldBuilderV3.addBuilder(n10, mixin);
    }

    public Api$Builder addOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Api$Builder addOptions(int n10, Option option) {
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

    public Api$Builder addOptions(Option$Builder messageOrBuilder) {
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

    public Api$Builder addOptions(Option option) {
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

    public Api$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Api$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Api build() {
        Api api = this.buildPartial();
        boolean bl2 = api.isInitialized();
        if (bl2) {
            return api;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(api);
    }

    public Api buildPartial() {
        int n10 = 0;
        Api api = new Api(this, null);
        List list = this.name_;
        Api.access$302(api, list);
        list = this.methodsBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 1;
            if (n10 != 0) {
                list = Collections.unmodifiableList(this.methods_);
                this.methods_ = list;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.methods_;
            Api.access$402(api, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Api.access$402(api, list);
        }
        list = this.optionsBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 2;
            if (n10 != 0) {
                list = Collections.unmodifiableList(this.options_);
                this.options_ = list;
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            }
            list = this.options_;
            Api.access$502(api, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Api.access$502(api, list);
        }
        list = this.version_;
        Api.access$602(api, list);
        list = this.sourceContextBuilder_;
        if (list == null) {
            list = this.sourceContext_;
            Api.access$702(api, (SourceContext)((Object)list));
        } else {
            list = (SourceContext)((SingleFieldBuilderV3)((Object)list)).build();
            Api.access$702(api, (SourceContext)((Object)list));
        }
        list = this.mixinsBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 4;
            if (n10 != 0) {
                this.mixins_ = list = Collections.unmodifiableList(this.mixins_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            }
            list = this.mixins_;
            Api.access$802(api, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Api.access$802(api, list);
        }
        n10 = this.syntax_;
        Api.access$902(api, n10);
        this.onBuilt();
        return api;
    }

    public Api$Builder clear() {
        int n10;
        super.clear();
        List list = "";
        this.name_ = list;
        List list2 = this.methodsBuilder_;
        if (list2 == null) {
            list2 = Collections.emptyList();
            this.methods_ = list2;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)((Object)list2)).clear();
        }
        list2 = this.optionsBuilder_;
        if (list2 == null) {
            this.options_ = list2 = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        } else {
            ((RepeatedFieldBuilderV3)((Object)list2)).clear();
        }
        this.version_ = list;
        list = this.sourceContextBuilder_;
        n10 = 0;
        list2 = null;
        if (list == null) {
            this.sourceContext_ = null;
        } else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        list = this.mixinsBuilder_;
        if (list == null) {
            int n11;
            this.mixins_ = list = Collections.emptyList();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFB;
        } else {
            ((RepeatedFieldBuilderV3)((Object)list)).clear();
        }
        this.syntax_ = 0;
        return this;
    }

    public Api$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Api$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Api$Builder clearMethods() {
        Object object = this.methodsBuilder_;
        if (object == null) {
            int n10;
            this.methods_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Api$Builder clearMixins() {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            int n10;
            this.mixins_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Api$Builder clearName() {
        String string2 = Api.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Api$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Api$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Api$Builder clearOptions() {
        Object object = this.optionsBuilder_;
        if (object == null) {
            int n10;
            this.options_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Api$Builder clearSourceContext() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.sourceContext_ = null;
            this.onChanged();
        } else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        return this;
    }

    public Api$Builder clearSyntax() {
        this.syntax_ = 0;
        this.onChanged();
        return this;
    }

    public Api$Builder clearVersion() {
        String string2 = Api.getDefaultInstance().getVersion();
        this.version_ = string2;
        this.onChanged();
        return this;
    }

    public Api$Builder clone() {
        return (Api$Builder)super.clone();
    }

    public Api getDefaultInstanceForType() {
        return Api.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    public Method getMethods(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Method)this.methods_.get(n10);
        }
        return (Method)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Method$Builder getMethodsBuilder(int n10) {
        return (Method$Builder)this.getMethodsFieldBuilder().getBuilder(n10);
    }

    public List getMethodsBuilderList() {
        return this.getMethodsFieldBuilder().getBuilderList();
    }

    public int getMethodsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.methods_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getMethodsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.methods_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public MethodOrBuilder getMethodsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (MethodOrBuilder)this.methods_.get(n10);
        }
        return (MethodOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getMethodsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.methodsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.methods_);
    }

    public Mixin getMixins(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.mixinsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Mixin)this.mixins_.get(n10);
        }
        return (Mixin)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Mixin$Builder getMixinsBuilder(int n10) {
        return (Mixin$Builder)this.getMixinsFieldBuilder().getBuilder(n10);
    }

    public List getMixinsBuilderList() {
        return this.getMixinsFieldBuilder().getBuilderList();
    }

    public int getMixinsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.mixinsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.mixins_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getMixinsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.mixinsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.mixins_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public MixinOrBuilder getMixinsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.mixinsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (MixinOrBuilder)this.mixins_.get(n10);
        }
        return (MixinOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getMixinsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.mixinsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.mixins_);
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

    public SourceContext getSourceContext() {
        Object object = this.sourceContextBuilder_;
        if (object == null) {
            object = this.sourceContext_;
            if (object == null) {
                object = SourceContext.getDefaultInstance();
            }
            return object;
        }
        return (SourceContext)((SingleFieldBuilderV3)object).getMessage();
    }

    public SourceContext$Builder getSourceContextBuilder() {
        this.onChanged();
        return (SourceContext$Builder)this.getSourceContextFieldBuilder().getBuilder();
    }

    public SourceContextOrBuilder getSourceContextOrBuilder() {
        Object object = this.sourceContextBuilder_;
        if (object != null) {
            return (SourceContextOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.sourceContext_;
        if (object == null) {
            object = SourceContext.getDefaultInstance();
        }
        return object;
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

    public String getVersion() {
        Object object = this.version_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.version_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getVersionBytes() {
        Object object = this.version_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.version_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean hasSourceContext() {
        boolean bl2;
        Object object = this.sourceContextBuilder_;
        if (object == null && (object = this.sourceContext_) == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Api$Builder mergeFrom(Api messageLite) {
        int n10;
        boolean bl2;
        boolean bl3;
        List list;
        Object object = Api.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = ((Api)messageLite).getName();
        boolean n102 = ((String)object).isEmpty();
        if (!n102) {
            this.name_ = object = Api.access$300((Api)messageLite);
            this.onChanged();
        }
        object = this.methodsBuilder_;
        Object object2 = null;
        if (object == null) {
            object = Api.access$400((Api)messageLite);
            boolean bl4 = object.isEmpty();
            if (!bl4) {
                object = this.methods_;
                boolean bl5 = object.isEmpty();
                if (bl5) {
                    int n11;
                    this.methods_ = object = Api.access$400((Api)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureMethodsIsMutable();
                    object = this.methods_;
                    list = Api.access$400((Api)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Api.access$400((Api)messageLite);
            boolean bl6 = object.isEmpty();
            if (!bl6) {
                object = this.methodsBuilder_;
                boolean bl7 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl7) {
                    int n12;
                    this.methodsBuilder_.dispose();
                    this.methodsBuilder_ = null;
                    this.methods_ = object = Api.access$400((Api)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                    boolean bl8 = GeneratedMessageV3.alwaysUseFieldBuilders;
                    if (bl8) {
                        object = this.getMethodsFieldBuilder();
                    } else {
                        boolean bl9 = false;
                        object = null;
                    }
                    this.methodsBuilder_ = object;
                } else {
                    object = this.methodsBuilder_;
                    list = Api.access$400((Api)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((object = this.optionsBuilder_) == null) {
            object = Api.access$500((Api)messageLite);
            boolean bl10 = object.isEmpty();
            if (!bl10) {
                object = this.options_;
                boolean bl11 = object.isEmpty();
                if (bl11) {
                    int n13;
                    this.options_ = object = Api.access$500((Api)messageLite);
                    this.bitField0_ = n13 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureOptionsIsMutable();
                    object = this.options_;
                    list = Api.access$500((Api)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Api.access$500((Api)messageLite);
            boolean bl12 = object.isEmpty();
            if (!bl12) {
                object = this.optionsBuilder_;
                boolean bl13 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl13) {
                    int n14;
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = object = Api.access$500((Api)messageLite);
                    this.bitField0_ = n14 = this.bitField0_ & 0xFFFFFFFD;
                    boolean bl14 = GeneratedMessageV3.alwaysUseFieldBuilders;
                    if (bl14) {
                        object = this.getOptionsFieldBuilder();
                    } else {
                        boolean bl15 = false;
                        object = null;
                    }
                    this.optionsBuilder_ = object;
                } else {
                    object = this.optionsBuilder_;
                    list = Api.access$500((Api)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (!(bl3 = ((String)(object = ((Api)messageLite).getVersion())).isEmpty())) {
            this.version_ = object = Api.access$600((Api)messageLite);
            this.onChanged();
        }
        if (bl2 = ((Api)messageLite).hasSourceContext()) {
            object = ((Api)messageLite).getSourceContext();
            this.mergeSourceContext((SourceContext)object);
        }
        if ((object = this.mixinsBuilder_) == null) {
            object = Api.access$800((Api)messageLite);
            boolean bl16 = object.isEmpty();
            if (!bl16) {
                object = this.mixins_;
                boolean bl17 = object.isEmpty();
                if (bl17) {
                    int n15;
                    this.mixins_ = object = Api.access$800((Api)messageLite);
                    this.bitField0_ = n15 = this.bitField0_ & 0xFFFFFFFB;
                } else {
                    this.ensureMixinsIsMutable();
                    object = this.mixins_;
                    object2 = Api.access$800((Api)messageLite);
                    object.addAll(object2);
                }
                this.onChanged();
            }
        } else {
            object = Api.access$800((Api)messageLite);
            boolean bl18 = object.isEmpty();
            if (!bl18) {
                object = this.mixinsBuilder_;
                boolean bl19 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl19) {
                    int n16;
                    this.mixinsBuilder_.dispose();
                    this.mixinsBuilder_ = null;
                    this.mixins_ = object = Api.access$800((Api)messageLite);
                    this.bitField0_ = n16 = this.bitField0_ & 0xFFFFFFFB;
                    boolean bl20 = GeneratedMessageV3.alwaysUseFieldBuilders;
                    if (bl20) {
                        object2 = this.getMixinsFieldBuilder();
                    }
                    this.mixinsBuilder_ = object2;
                } else {
                    object = this.mixinsBuilder_;
                    object2 = Api.access$800((Api)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages((Iterable)object2);
                }
            }
        }
        if ((n10 = Api.access$900((Api)messageLite)) != 0) {
            int n17 = ((Api)messageLite).getSyntaxValue();
            this.setSyntaxValue(n17);
        }
        messageLite = ((GeneratedMessageV3)messageLite).unknownFields;
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
    public Api$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Api.access$1000();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Api)object;
            if (object == null) break block7;
            this.mergeFrom((Api)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Api)object2;
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
            this.mergeFrom((Api)object3);
        }
        throw var1_6;
    }

    public Api$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Api;
        if (bl2) {
            message = (Api)message;
            return this.mergeFrom((Api)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Api$Builder mergeSourceContext(SourceContext message) {
        Object object = this.sourceContextBuilder_;
        if (object == null) {
            object = this.sourceContext_;
            if (object != null) {
                object = SourceContext.newBuilder((SourceContext)object);
                this.sourceContext_ = message = ((SourceContext$Builder)object).mergeFrom((SourceContext)message).buildPartial();
            } else {
                this.sourceContext_ = message;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom((AbstractMessage)message);
        }
        return this;
    }

    public final Api$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Api$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Api$Builder removeMethods(int n10) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            this.ensureMethodsIsMutable();
            object = this.methods_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Api$Builder removeMixins(int n10) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Api$Builder removeOptions(int n10) {
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

    public Api$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Api$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Api$Builder setMethods(int n10, Method$Builder messageOrBuilder) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            this.ensureMethodsIsMutable();
            object = this.methods_;
            messageOrBuilder = ((Method$Builder)messageOrBuilder).build();
            object.set(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Method$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Api$Builder setMethods(int n10, Method method) {
        Object object = this.methodsBuilder_;
        if (object == null) {
            Objects.requireNonNull(method);
            this.ensureMethodsIsMutable();
            object = this.methods_;
            object.set(n10, method);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, method);
        }
        return this;
    }

    public Api$Builder setMixins(int n10, Mixin$Builder messageOrBuilder) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            messageOrBuilder = ((Mixin$Builder)messageOrBuilder).build();
            object.set(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((Mixin$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Api$Builder setMixins(int n10, Mixin mixin) {
        Object object = this.mixinsBuilder_;
        if (object == null) {
            Objects.requireNonNull(mixin);
            this.ensureMixinsIsMutable();
            object = this.mixins_;
            object.set(n10, mixin);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, mixin);
        }
        return this;
    }

    public Api$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Api$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public Api$Builder setOptions(int n10, Option$Builder messageOrBuilder) {
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

    public Api$Builder setOptions(int n10, Option option) {
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

    public Api$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Api$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Api$Builder setSourceContext(SourceContext$Builder messageOrBuilder) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            messageOrBuilder = messageOrBuilder.build();
            this.sourceContext_ = messageOrBuilder;
            this.onChanged();
        } else {
            messageOrBuilder = messageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public Api$Builder setSourceContext(SourceContext sourceContext) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.sourceContextBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(sourceContext);
            this.sourceContext_ = sourceContext;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(sourceContext);
        }
        return this;
    }

    public Api$Builder setSyntax(Syntax syntax) {
        int n10;
        Objects.requireNonNull(syntax);
        this.syntax_ = n10 = syntax.getNumber();
        this.onChanged();
        return this;
    }

    public Api$Builder setSyntaxValue(int n10) {
        this.syntax_ = n10;
        this.onChanged();
        return this;
    }

    public final Api$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Api$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Api$Builder setVersion(String string2) {
        Objects.requireNonNull(string2);
        this.version_ = string2;
        this.onChanged();
        return this;
    }

    public Api$Builder setVersionBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.version_ = byteString;
        this.onChanged();
        return this;
    }
}

