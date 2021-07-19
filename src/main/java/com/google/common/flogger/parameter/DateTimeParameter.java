/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parameter;

import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.parameter.DateTimeFormat;
import com.google.common.flogger.parameter.Parameter;
import com.google.common.flogger.parameter.ParameterVisitor;

public final class DateTimeParameter
extends Parameter {
    private final DateTimeFormat format;
    private final String formatString;

    /*
     * WARNING - void declaration
     */
    private DateTimeParameter(FormatOptions object, int n10, DateTimeFormat dateTimeFormat) {
        super((FormatOptions)object, n10);
        void var6_9;
        this.format = dateTimeFormat;
        String string2 = "%";
        StringBuilder stringBuilder = new StringBuilder(string2);
        stringBuilder = ((FormatOptions)object).appendPrintfOptions(stringBuilder);
        boolean c10 = ((FormatOptions)object).shouldUpperCase();
        if (c10) {
            int n11 = 84;
        } else {
            int n12 = 116;
        }
        stringBuilder.append((char)var6_9);
        char c11 = dateTimeFormat.getChar();
        stringBuilder.append(c11);
        this.formatString = object = stringBuilder.toString();
    }

    public static Parameter of(DateTimeFormat dateTimeFormat, FormatOptions formatOptions, int n10) {
        DateTimeParameter dateTimeParameter = new DateTimeParameter(formatOptions, n10, dateTimeFormat);
        return dateTimeParameter;
    }

    public void accept(ParameterVisitor parameterVisitor, Object object) {
        DateTimeFormat dateTimeFormat = this.format;
        FormatOptions formatOptions = this.getFormatOptions();
        parameterVisitor.visitDateTime(object, dateTimeFormat, formatOptions);
    }

    public String getFormat() {
        return this.formatString;
    }
}

