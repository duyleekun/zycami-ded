/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parameter;

import com.google.common.flogger.backend.FormatChar;
import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.parameter.DateTimeFormat;

public interface ParameterVisitor {
    public void visit(Object var1, FormatChar var2, FormatOptions var3);

    public void visitDateTime(Object var1, DateTimeFormat var2, FormatOptions var3);

    public void visitMissing();

    public void visitNull();

    public void visitPreformatted(Object var1, String var2);
}

