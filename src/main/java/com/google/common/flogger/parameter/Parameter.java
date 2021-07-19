/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parameter;

import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.parameter.ParameterVisitor;

public abstract class Parameter {
    private final int index;
    private final FormatOptions options;

    public Parameter(FormatOptions object, int n10) {
        if (object != null) {
            if (n10 >= 0) {
                this.index = n10;
                this.options = object;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid index: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        object = new IllegalArgumentException("format options cannot be null");
        throw object;
    }

    public abstract void accept(ParameterVisitor var1, Object var2);

    public final void accept(ParameterVisitor parameterVisitor, Object[] object) {
        int n10;
        int n11 = this.getIndex();
        if (n11 < (n10 = ((Object[])object).length)) {
            n11 = this.getIndex();
            if ((object = object[n11]) != null) {
                this.accept(parameterVisitor, object);
            } else {
                parameterVisitor.visitNull();
            }
        } else {
            parameterVisitor.visitMissing();
        }
    }

    public abstract String getFormat();

    public final FormatOptions getFormatOptions() {
        return this.options;
    }

    public final int getIndex() {
        return this.index;
    }
}

