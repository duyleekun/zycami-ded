/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parameter;

import com.google.common.flogger.backend.FormatChar;
import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.parameter.Parameter;
import com.google.common.flogger.parameter.ParameterVisitor;
import com.google.common.flogger.util.Checks;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public final class SimpleParameter
extends Parameter {
    private static final Map DEFAULT_PARAMETERS;
    private static final int MAX_CACHED_PARAMETERS = 10;
    private final FormatChar formatChar;
    private final String formatString;

    static {
        EnumMap<FormatChar, SimpleParameter[]> enumMap = new EnumMap<FormatChar, SimpleParameter[]>(FormatChar.class);
        for (FormatChar formatChar : FormatChar.values()) {
            SimpleParameter[] simpleParameterArray = SimpleParameter.createParameterArray(formatChar);
            enumMap.put(formatChar, simpleParameterArray);
        }
        DEFAULT_PARAMETERS = Collections.unmodifiableMap(enumMap);
    }

    private SimpleParameter(int n10, FormatChar formatChar, FormatOptions formatOptions) {
        super(formatOptions, n10);
        Object object;
        this.formatChar = object = (FormatChar)((Object)Checks.checkNotNull((Object)formatChar, "format char"));
        n10 = (int)(formatOptions.isDefault() ? 1 : 0);
        object = n10 != 0 ? formatChar.getDefaultFormatString() : SimpleParameter.buildFormatString(formatOptions, formatChar);
        this.formatString = object;
    }

    public static String buildFormatString(FormatOptions object, FormatChar formatChar) {
        char c10 = formatChar.getChar();
        boolean bl2 = ((FormatOptions)object).shouldUpperCase();
        if (bl2) {
            c10 = (char)(c10 & 0xFFFFFFDF);
        }
        StringBuilder stringBuilder = new StringBuilder("%");
        object = ((FormatOptions)object).appendPrintfOptions(stringBuilder);
        ((StringBuilder)object).append(c10);
        return ((StringBuilder)object).toString();
    }

    private static SimpleParameter[] createParameterArray(FormatChar formatChar) {
        int n10 = 10;
        SimpleParameter[] simpleParameterArray = new SimpleParameter[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            SimpleParameter simpleParameter;
            FormatOptions formatOptions = FormatOptions.getDefault();
            simpleParameterArray[i10] = simpleParameter = new SimpleParameter(i10, formatChar, formatOptions);
        }
        return simpleParameterArray;
    }

    public static SimpleParameter of(int n10, FormatChar formatChar, FormatOptions formatOptions) {
        int n11 = 10;
        if (n10 < n11 && (n11 = (int)(formatOptions.isDefault() ? 1 : 0)) != 0) {
            return ((SimpleParameter[])DEFAULT_PARAMETERS.get((Object)formatChar))[n10];
        }
        SimpleParameter simpleParameter = new SimpleParameter(n10, formatChar, formatOptions);
        return simpleParameter;
    }

    public void accept(ParameterVisitor parameterVisitor, Object object) {
        FormatChar formatChar = this.formatChar;
        FormatOptions formatOptions = this.getFormatOptions();
        parameterVisitor.visit(object, formatChar, formatOptions);
    }

    public String getFormat() {
        return this.formatString;
    }
}

