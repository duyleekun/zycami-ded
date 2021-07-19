/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Mixin;

public final class Mixin$1
extends AbstractParser {
    public Mixin parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Mixin mixin = new Mixin(codedInputStream, extensionRegistryLite, null);
        return mixin;
    }
}

