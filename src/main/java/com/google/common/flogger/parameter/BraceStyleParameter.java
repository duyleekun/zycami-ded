/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parameter;

import com.google.common.flogger.backend.FormatChar;
import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.backend.FormatType;
import com.google.common.flogger.parameter.DateTimeFormat;
import com.google.common.flogger.parameter.Parameter;
import com.google.common.flogger.parameter.ParameterVisitor;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BraceStyleParameter
extends Parameter {
    private static final BraceStyleParameter[] DEFAULT_PARAMETERS;
    private static final int MAX_CACHED_PARAMETERS = 10;
    private static final FormatOptions WITH_GROUPING;
    private static final MessageFormat prototypeMessageFormatter;

    static {
        MessageFormat messageFormat;
        int n10 = -1;
        WITH_GROUPING = FormatOptions.of(16, n10, n10);
        Locale locale = Locale.ROOT;
        BraceStyleParameter[] braceStyleParameterArray = "{0}";
        prototypeMessageFormatter = messageFormat = new MessageFormat((String)braceStyleParameterArray, locale);
        int n11 = 10;
        DEFAULT_PARAMETERS = new BraceStyleParameter[n11];
        locale = null;
        for (n10 = 0; n10 < n11; ++n10) {
            BraceStyleParameter braceStyleParameter;
            braceStyleParameterArray = DEFAULT_PARAMETERS;
            braceStyleParameterArray[n10] = braceStyleParameter = new BraceStyleParameter(n10);
        }
    }

    private BraceStyleParameter(int n10) {
        FormatOptions formatOptions = FormatOptions.getDefault();
        super(formatOptions, n10);
    }

    public static BraceStyleParameter of(int n10) {
        BraceStyleParameter braceStyleParameter;
        int n11 = 10;
        if (n10 < n11) {
            BraceStyleParameter[] braceStyleParameterArray = DEFAULT_PARAMETERS;
            braceStyleParameter = braceStyleParameterArray[n10];
        } else {
            BraceStyleParameter braceStyleParameter2;
            braceStyleParameter = braceStyleParameter2 = new BraceStyleParameter(n10);
        }
        return braceStyleParameter;
    }

    public void accept(ParameterVisitor parameterVisitor, Object object) {
        Object object2 = FormatType.INTEGRAL;
        boolean bl2 = ((FormatType)((Object)object2)).canFormat(object);
        if (bl2) {
            object2 = FormatChar.DECIMAL;
            FormatOptions formatOptions = WITH_GROUPING;
            parameterVisitor.visit(object, (FormatChar)((Object)object2), formatOptions);
        } else {
            object2 = FormatType.FLOAT;
            bl2 = ((FormatType)((Object)object2)).canFormat(object);
            if (bl2) {
                object2 = FormatChar.FLOAT;
                FormatOptions formatOptions = WITH_GROUPING;
                parameterVisitor.visit(object, (FormatChar)((Object)object2), formatOptions);
            } else {
                bl2 = object instanceof Date;
                if (bl2) {
                    object2 = (MessageFormat)prototypeMessageFormatter.clone();
                    int n10 = 1;
                    Object[] objectArray = new Object[n10];
                    objectArray[0] = object;
                    StringBuffer stringBuffer = new StringBuffer();
                    object2 = ((MessageFormat)object2).format(objectArray, stringBuffer, (FieldPosition)null).toString();
                    parameterVisitor.visitPreformatted(object, (String)object2);
                } else {
                    bl2 = object instanceof Calendar;
                    if (bl2) {
                        object2 = DateTimeFormat.DATETIME_FULL;
                        FormatOptions formatOptions = this.getFormatOptions();
                        parameterVisitor.visitDateTime(object, (DateTimeFormat)((Object)object2), formatOptions);
                    } else {
                        object2 = FormatChar.STRING;
                        FormatOptions formatOptions = this.getFormatOptions();
                        parameterVisitor.visit(object, (FormatChar)((Object)object2), formatOptions);
                    }
                }
            }
        }
    }

    public String getFormat() {
        return "%s";
    }
}

