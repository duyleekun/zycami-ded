/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessage$BuilderParent;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;

public class SingleFieldBuilderV3
implements AbstractMessage$BuilderParent {
    private AbstractMessage$Builder builder;
    private boolean isClean;
    private AbstractMessage message;
    private AbstractMessage$BuilderParent parent;

    public SingleFieldBuilderV3(AbstractMessage abstractMessage, AbstractMessage$BuilderParent abstractMessage$BuilderParent, boolean bl2) {
        this.message = abstractMessage = (AbstractMessage)Internal.checkNotNull(abstractMessage);
        this.parent = abstractMessage$BuilderParent;
        this.isClean = bl2;
    }

    private void onChanged() {
        boolean bl2;
        Object object = this.builder;
        if (object != null) {
            bl2 = false;
            object = null;
            this.message = null;
        }
        if ((bl2 = this.isClean) && (object = this.parent) != null) {
            object.markDirty();
            bl2 = false;
            object = null;
            this.isClean = false;
        }
    }

    public AbstractMessage build() {
        this.isClean = true;
        return this.getMessage();
    }

    public SingleFieldBuilderV3 clear() {
        MessageOrBuilder messageOrBuilder = this.message;
        messageOrBuilder = messageOrBuilder != null ? messageOrBuilder.getDefaultInstanceForType() : this.builder.getDefaultInstanceForType();
        this.message = messageOrBuilder;
        messageOrBuilder = this.builder;
        if (messageOrBuilder != null) {
            ((AbstractMessage$Builder)messageOrBuilder).dispose();
            messageOrBuilder = null;
            this.builder = null;
        }
        this.onChanged();
        return this;
    }

    public void dispose() {
        this.parent = null;
    }

    public AbstractMessage$Builder getBuilder() {
        AbstractMessage$Builder abstractMessage$Builder = this.builder;
        if (abstractMessage$Builder == null) {
            this.builder = abstractMessage$Builder = (AbstractMessage$Builder)this.message.newBuilderForType(this);
            AbstractMessage abstractMessage = this.message;
            abstractMessage$Builder.mergeFrom(abstractMessage);
            abstractMessage$Builder = this.builder;
            abstractMessage$Builder.markClean();
        }
        return this.builder;
    }

    public AbstractMessage getMessage() {
        AbstractMessage abstractMessage = this.message;
        if (abstractMessage == null) {
            this.message = abstractMessage = (AbstractMessage)this.builder.buildPartial();
        }
        return this.message;
    }

    public MessageOrBuilder getMessageOrBuilder() {
        AbstractMessage$Builder abstractMessage$Builder = this.builder;
        if (abstractMessage$Builder != null) {
            return abstractMessage$Builder;
        }
        return this.message;
    }

    public void markDirty() {
        this.onChanged();
    }

    public SingleFieldBuilderV3 mergeFrom(AbstractMessage abstractMessage) {
        Message message;
        MessageOrBuilder messageOrBuilder = this.builder;
        if (messageOrBuilder == null && (messageOrBuilder = this.message) == (message = messageOrBuilder.getDefaultInstanceForType())) {
            this.message = abstractMessage;
        } else {
            messageOrBuilder = this.getBuilder();
            ((AbstractMessage$Builder)messageOrBuilder).mergeFrom(abstractMessage);
        }
        this.onChanged();
        return this;
    }

    public SingleFieldBuilderV3 setMessage(AbstractMessage messageOrBuilder) {
        messageOrBuilder = (AbstractMessage)Internal.checkNotNull(messageOrBuilder);
        this.message = messageOrBuilder;
        messageOrBuilder = this.builder;
        if (messageOrBuilder != null) {
            ((AbstractMessage$Builder)messageOrBuilder).dispose();
            messageOrBuilder = null;
            this.builder = null;
        }
        this.onChanged();
        return this;
    }
}

