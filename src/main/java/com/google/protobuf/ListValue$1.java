/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.ListValue;

public final class ListValue$1
extends AbstractParser {
    public ListValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ListValue listValue = new ListValue(codedInputStream, extensionRegistryLite, null);
        return listValue;
    }
}

