/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

import com.google.common.flogger.parser.MessageBuilder;

public abstract class MessageParser {
    public static final int MAX_ARG_COUNT = 1000000;

    public abstract void parseImpl(MessageBuilder var1);

    public abstract void unescape(StringBuilder var1, String var2, int var3, int var4);
}

