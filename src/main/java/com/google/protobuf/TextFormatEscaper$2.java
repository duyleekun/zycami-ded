/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.TextFormatEscaper$ByteSequence;

public final class TextFormatEscaper$2
implements TextFormatEscaper$ByteSequence {
    public final /* synthetic */ byte[] val$input;

    public TextFormatEscaper$2(byte[] byArray) {
        this.val$input = byArray;
    }

    public byte byteAt(int n10) {
        return this.val$input[n10];
    }

    public int size() {
        return this.val$input.length;
    }
}

