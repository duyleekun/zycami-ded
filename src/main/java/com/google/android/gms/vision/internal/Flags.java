/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision.internal;

import com.google.android.gms.flags.Flag;

public class Flags {
    private static final Flag zzdr;

    static {
        Boolean bl2 = Boolean.TRUE;
        zzdr = Flag.define(0, "vision:product_barcode_value_logging_enabled", bl2);
    }

    private Flags() {
    }
}

