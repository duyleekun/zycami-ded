/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatType;

public final class FormatType$3
extends FormatType {
    public FormatType$3(boolean bl2, boolean bl3) {
    }

    public boolean canFormat(Object object) {
        boolean bl2 = object instanceof Character;
        if (bl2) {
            return true;
        }
        bl2 = object instanceof Integer;
        if (!(bl2 || (bl2 = object instanceof Byte) || (bl2 = object instanceof Short))) {
            return false;
        }
        return Character.isValidCodePoint(((Number)object).intValue());
    }
}

