/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.parser.MessageParser;
import com.google.common.flogger.util.Checks;

public final class TemplateContext {
    private final String message;
    private final MessageParser parser;

    public TemplateContext(MessageParser object, String string2) {
        object = (MessageParser)Checks.checkNotNull(object, "parser");
        this.parser = object;
        this.message = object = (String)Checks.checkNotNull(string2, "message");
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof TemplateContext;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (TemplateContext)object;
            Object object2 = this.parser;
            MessageParser messageParser = ((TemplateContext)object).parser;
            bl2 = object2.equals(messageParser);
            if (bl2 && (bl4 = ((String)(object2 = this.message)).equals(object = ((TemplateContext)object).message))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public String getMessage() {
        return this.message;
    }

    public MessageParser getParser() {
        return this.parser;
    }

    public int hashCode() {
        int n10 = this.parser.hashCode();
        int n11 = this.message.hashCode();
        return n10 ^ n11;
    }
}

