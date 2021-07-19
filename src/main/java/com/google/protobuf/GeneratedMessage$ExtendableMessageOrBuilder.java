/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Extension;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;

public interface GeneratedMessage$ExtendableMessageOrBuilder
extends MessageOrBuilder {
    public Message getDefaultInstanceForType();

    public Object getExtension(Extension var1);

    public Object getExtension(Extension var1, int var2);

    public Object getExtension(ExtensionLite var1);

    public Object getExtension(ExtensionLite var1, int var2);

    public Object getExtension(GeneratedMessage$GeneratedExtension var1);

    public Object getExtension(GeneratedMessage$GeneratedExtension var1, int var2);

    public int getExtensionCount(Extension var1);

    public int getExtensionCount(ExtensionLite var1);

    public int getExtensionCount(GeneratedMessage$GeneratedExtension var1);

    public boolean hasExtension(Extension var1);

    public boolean hasExtension(ExtensionLite var1);

    public boolean hasExtension(GeneratedMessage$GeneratedExtension var1);
}

