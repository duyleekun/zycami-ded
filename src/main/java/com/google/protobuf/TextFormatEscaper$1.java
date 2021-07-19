/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormatEscaper$ByteSequence;

public final class TextFormatEscaper$1
implements TextFormatEscaper$ByteSequence {
    public final /* synthetic */ ByteString val$input;

    public TextFormatEscaper$1(ByteString byteString) {
        this.val$input = byteString;
    }

    public byte byteAt(int n10) {
        return this.val$input.byteAt(n10);
    }

    public int size() {
        return this.val$input.size();
    }
}

