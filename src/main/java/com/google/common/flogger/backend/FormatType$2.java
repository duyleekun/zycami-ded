/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatType;

public final class FormatType$2
extends FormatType {
    public FormatType$2(boolean bl2, boolean bl3) {
    }

    public boolean canFormat(Object object) {
        return object instanceof Boolean;
    }
}

