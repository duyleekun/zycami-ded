/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

import com.google.common.flogger.backend.TemplateContext;
import com.google.common.flogger.parameter.Parameter;
import com.google.common.flogger.parser.MessageParser;
import com.google.common.flogger.parser.ParseException;
import com.google.common.flogger.util.Checks;

public abstract class MessageBuilder {
    private final TemplateContext context;
    private int maxIndex = -1;
    private int pmask = 0;

    public MessageBuilder(TemplateContext templateContext) {
        this.context = templateContext = (TemplateContext)Checks.checkNotNull(templateContext, "context");
    }

    public final void addParameter(int n10, int n11, Parameter parameter) {
        int n12;
        int n13 = parameter.getIndex();
        if (n13 < (n12 = 32)) {
            n13 = this.pmask;
            int n14 = parameter.getIndex();
            n12 = 1 << n14;
            this.pmask = n13 |= n12;
        }
        n13 = this.maxIndex;
        n12 = parameter.getIndex();
        this.maxIndex = n13 = Math.max(n13, n12);
        this.addParameterImpl(n10, n11, parameter);
    }

    public abstract void addParameterImpl(int var1, int var2, Parameter var3);

    public final Object build() {
        int n10;
        Object object = this.getParser();
        ((MessageParser)object).parseImpl(this);
        int n11 = this.pmask;
        int n12 = n11 + 1 & n11;
        if (n12 == 0 && ((n12 = this.maxIndex) <= (n10 = 31) || n11 == (n12 = -1))) {
            return this.buildImpl();
        }
        n11 = Integer.numberOfTrailingZeros(~n11);
        object = n11;
        Object object2 = new Object[]{object};
        object = String.format("unreferenced arguments [first missing index=%d]", object2);
        object2 = this.getMessage();
        throw ParseException.generic((String)object, (String)object2);
    }

    public abstract Object buildImpl();

    public final int getExpectedArgumentCount() {
        return this.maxIndex + 1;
    }

    public final String getMessage() {
        return this.context.getMessage();
    }

    public final MessageParser getParser() {
        return this.context.getParser();
    }
}

