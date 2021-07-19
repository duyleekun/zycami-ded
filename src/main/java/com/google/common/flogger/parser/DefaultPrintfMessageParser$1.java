/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parser;

import com.google.common.flogger.backend.FormatChar;
import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.parameter.Parameter;
import com.google.common.flogger.parameter.ParameterVisitor;

public class DefaultPrintfMessageParser$1
extends Parameter {
    public final /* synthetic */ FormatOptions val$options;

    public DefaultPrintfMessageParser$1(FormatOptions formatOptions, int n10, FormatOptions formatOptions2) {
        this.val$options = formatOptions2;
        super(formatOptions, n10);
    }

    public void accept(ParameterVisitor parameterVisitor, Object object) {
        object = object.hashCode();
        FormatChar formatChar = FormatChar.HEX;
        FormatOptions formatOptions = this.getFormatOptions();
        parameterVisitor.visit(object, formatChar, formatOptions);
    }

    public String getFormat() {
        Object object = this.val$options;
        boolean bl2 = ((FormatOptions)object).shouldUpperCase();
        object = bl2 ? "%H" : "%h";
        return object;
    }
}

