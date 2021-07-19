/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.MessageLite;

public class LazyField
extends LazyFieldLite {
    private final MessageLite defaultInstance;

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.defaultInstance = messageLite;
    }

    public boolean containsDefaultInstance() {
        MessageLite messageLite;
        MessageLite messageLite2;
        boolean bl2 = super.containsDefaultInstance();
        if (!bl2 && (messageLite2 = this.value) != (messageLite = this.defaultInstance)) {
            bl2 = false;
            messageLite2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        return this.getValue().equals(object);
    }

    public MessageLite getValue() {
        MessageLite messageLite = this.defaultInstance;
        return this.getValue(messageLite);
    }

    public int hashCode() {
        return this.getValue().hashCode();
    }

    public String toString() {
        return this.getValue().toString();
    }
}

