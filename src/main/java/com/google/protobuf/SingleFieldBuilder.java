/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;

public class SingleFieldBuilder
implements GeneratedMessage$BuilderParent {
    private GeneratedMessage$Builder builder;
    private boolean isClean;
    private GeneratedMessage message;
    private GeneratedMessage$BuilderParent parent;

    public SingleFieldBuilder(GeneratedMessage generatedMessage, GeneratedMessage$BuilderParent generatedMessage$BuilderParent, boolean bl2) {
        this.message = generatedMessage = (GeneratedMessage)Internal.checkNotNull(generatedMessage);
        this.parent = generatedMessage$BuilderParent;
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

    public GeneratedMessage build() {
        this.isClean = true;
        return this.getMessage();
    }

    public SingleFieldBuilder clear() {
        MessageOrBuilder messageOrBuilder = this.message;
        messageOrBuilder = messageOrBuilder != null ? messageOrBuilder.getDefaultInstanceForType() : this.builder.getDefaultInstanceForType();
        this.message = messageOrBuilder;
        messageOrBuilder = this.builder;
        if (messageOrBuilder != null) {
            ((GeneratedMessage$Builder)messageOrBuilder).dispose();
            messageOrBuilder = null;
            this.builder = null;
        }
        this.onChanged();
        return this;
    }

    public void dispose() {
        this.parent = null;
    }

    public GeneratedMessage$Builder getBuilder() {
        GeneratedMessage$Builder generatedMessage$Builder = this.builder;
        if (generatedMessage$Builder == null) {
            this.builder = generatedMessage$Builder = (GeneratedMessage$Builder)this.message.newBuilderForType(this);
            GeneratedMessage generatedMessage = this.message;
            generatedMessage$Builder.mergeFrom(generatedMessage);
            generatedMessage$Builder = this.builder;
            generatedMessage$Builder.markClean();
        }
        return this.builder;
    }

    public GeneratedMessage getMessage() {
        GeneratedMessage generatedMessage = this.message;
        if (generatedMessage == null) {
            this.message = generatedMessage = (GeneratedMessage)this.builder.buildPartial();
        }
        return this.message;
    }

    public MessageOrBuilder getMessageOrBuilder() {
        GeneratedMessage$Builder generatedMessage$Builder = this.builder;
        if (generatedMessage$Builder != null) {
            return generatedMessage$Builder;
        }
        return this.message;
    }

    public void markDirty() {
        this.onChanged();
    }

    public SingleFieldBuilder mergeFrom(GeneratedMessage generatedMessage) {
        Message message;
        MessageOrBuilder messageOrBuilder = this.builder;
        if (messageOrBuilder == null && (messageOrBuilder = this.message) == (message = messageOrBuilder.getDefaultInstanceForType())) {
            this.message = generatedMessage;
        } else {
            messageOrBuilder = this.getBuilder();
            ((AbstractMessage$Builder)messageOrBuilder).mergeFrom(generatedMessage);
        }
        this.onChanged();
        return this;
    }

    public SingleFieldBuilder setMessage(GeneratedMessage messageOrBuilder) {
        messageOrBuilder = (GeneratedMessage)Internal.checkNotNull(messageOrBuilder);
        this.message = messageOrBuilder;
        messageOrBuilder = this.builder;
        if (messageOrBuilder != null) {
            ((GeneratedMessage$Builder)messageOrBuilder).dispose();
            messageOrBuilder = null;
            this.builder = null;
        }
        this.onChanged();
        return this;
    }
}

