/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzdo;
import java.util.List;

public final class zzew
extends RuntimeException {
    private final List zzoy = null;

    public zzew(zzdo zzdo2) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}

