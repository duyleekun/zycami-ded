/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;

public final class zzfc$zzb
extends IOException {
    public zzfc$zzb() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzfc$zzb(String string2, Throwable throwable) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        super(string2, throwable);
    }

    public zzfc$zzb(Throwable throwable) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
    }
}

