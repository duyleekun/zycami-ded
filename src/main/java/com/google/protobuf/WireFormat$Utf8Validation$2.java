/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.WireFormat$Utf8Validation;

public final class WireFormat$Utf8Validation$2
extends WireFormat$Utf8Validation {
    public Object readString(CodedInputStream codedInputStream) {
        return codedInputStream.readStringRequireUtf8();
    }
}

