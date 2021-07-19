/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;

public final class zzdw$zza
extends IOException {
    public zzdw$zza() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzdw$zza(String string2, Throwable throwable) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        super(string2, throwable);
    }

    public zzdw$zza(Throwable throwable) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
    }
}

