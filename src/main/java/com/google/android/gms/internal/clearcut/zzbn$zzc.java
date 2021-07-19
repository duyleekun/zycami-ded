/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzbn$zzc
extends IOException {
    public zzbn$zzc() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzbn$zzc(String string2) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        super(string2);
    }

    public zzbn$zzc(String string2, Throwable throwable) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        super(string2, throwable);
    }

    public zzbn$zzc(Throwable throwable) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
    }
}

