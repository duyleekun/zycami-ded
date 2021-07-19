/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatType;
import java.math.BigDecimal;

public final class FormatType$5
extends FormatType {
    public FormatType$5(boolean bl2, boolean bl3) {
    }

    public boolean canFormat(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Double;
        if (!(bl3 || (bl3 = object instanceof Float) || (bl2 = object instanceof BigDecimal))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

