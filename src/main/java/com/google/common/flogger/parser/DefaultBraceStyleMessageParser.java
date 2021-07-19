/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

import com.google.common.flogger.parameter.BraceStyleParameter;
import com.google.common.flogger.parser.BraceStyleMessageParser;
import com.google.common.flogger.parser.MessageBuilder;
import com.google.common.flogger.parser.ParseException;

public class DefaultBraceStyleMessageParser
extends BraceStyleMessageParser {
    private static final BraceStyleMessageParser INSTANCE;

    static {
        DefaultBraceStyleMessageParser defaultBraceStyleMessageParser = new DefaultBraceStyleMessageParser();
        INSTANCE = defaultBraceStyleMessageParser;
    }

    private DefaultBraceStyleMessageParser() {
    }

    public static BraceStyleMessageParser getInstance() {
        return INSTANCE;
    }

    public void parseBraceFormatTerm(MessageBuilder messageBuilder, int n10, String string2, int n11, int n12, int n13) {
        int n14 = -1;
        if (n12 == n14) {
            BraceStyleParameter braceStyleParameter = BraceStyleParameter.of(n10);
            messageBuilder.addParameter(n11, n13, braceStyleParameter);
            return;
        }
        throw ParseException.withBounds("the default brace style parser does not allow trailing format specifiers", string2, n12 += -1, n13 += -1);
    }
}

