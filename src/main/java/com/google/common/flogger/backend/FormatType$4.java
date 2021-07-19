/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatType;
import java.math.BigInteger;

public final class FormatType$4
extends FormatType {
    public FormatType$4(boolean bl2, boolean bl3) {
    }

    public boolean canFormat(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Integer;
        if (!(bl3 || (bl3 = object instanceof Long) || (bl3 = object instanceof Byte) || (bl3 = object instanceof Short) || (bl2 = object instanceof BigInteger))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

