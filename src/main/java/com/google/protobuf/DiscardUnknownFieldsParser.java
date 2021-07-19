/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DiscardUnknownFieldsParser$1;
import com.google.protobuf.Parser;

public final class DiscardUnknownFieldsParser {
    private DiscardUnknownFieldsParser() {
    }

    public static final Parser wrap(Parser parser) {
        DiscardUnknownFieldsParser$1 discardUnknownFieldsParser$1 = new DiscardUnknownFieldsParser$1(parser);
        return discardUnknownFieldsParser$1;
    }
}

