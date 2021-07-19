/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhb;
import java.util.List;

public final class zzig
extends RuntimeException {
    private final List zza = null;

    public zzig(zzhb zzhb2) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}

